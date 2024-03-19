package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.Accountpage;
import pageobject.Homelandingpage;
import pageobject.Registerpage;
import resources5.Base;

import java.io.IOException;


public class Registertest extends Base {

    Logger log;
    public static WebDriver driver;

    @Test
    public void register() throws InterruptedException {

        Base base = new Base();
        String randomemail = base.generateRandomEmail();

        Homelandingpage landingpage = new Homelandingpage(driver);
        base.clickwebelement(landingpage.popup());
        base.clickwebelement(landingpage.Myaccountdropdown());


        landingpage.signupbutton().click();


        Registerpage registerpage = new Registerpage(driver);
        base.clickwebelementsendkeys(registerpage.firstnamefield(), (prop.getProperty("firstname")));

        log.debug("Firstname is entered");

        base.clickwebelementsendkeys(registerpage.lastnamefield(), (prop.getProperty("lastname")));
        log.debug("Lastname is enetered");

        base.clickwebelementsendkeys(registerpage.emailfield(), (randomemail));
        log.debug("email is entered");

        base.clickwebelementsendkeys(registerpage.mobilefield(), (prop.getProperty("mobile")));
        log.debug("mobile no is entered");

        base.clickwebelementsendkeys(registerpage.passwordfield(), (prop.getProperty("password")));
        log.debug("password is entered");

        base.clickwebelement(registerpage.submitbutton());
        log.debug("Clicked om submitbutton");

        base.clickwebelement(registerpage.Accountbutton());
        log.debug("Clicked on Accountbutton");

        Accountpage accountpage = new Accountpage(driver);

        String actualresult = null;
        try {

            if (accountpage.recentorder().isDisplayed()) {
                actualresult = "Succesful";
                log.debug("user got registered");

            }
        } catch (Exception e) {
            actualresult = "failure";
            log.debug("user didnt logged in");

        }


    }

    @BeforeMethod
    public void openapplicationn() throws IOException {

        log = LogManager.getLogger(Registertest.class.getName());
        driver = intilizebrowser();
        log.debug("Browser got launched");
        driver.get(prop.getProperty("url"));
        log.debug("Navigated to application url");

    }

    @AfterMethod
    public void close() {

        driver.close();
        log.debug("Browser got closed");


    }


}
