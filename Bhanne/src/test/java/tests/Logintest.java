package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobject.Homelandingpage;
import pageobject.Loginpage;
import pageobject.Registerpage;
import resources5.Base;

import java.io.IOException;

import static tests.Registertest.driver;

public class Logintest extends Base {

    Logger log;

    WebDriver driver;

    @Test
    public void login() throws InterruptedException {

        Base base = new Base();

        Homelandingpage landingpages = new Homelandingpage(driver);
        base.clickwebelement(landingpages.popup());

        base.clickwebelement(landingpages.Myaccountdropdown());


        Loginpage loginpage = new Loginpage(driver);

        base.clickwebelementsendkeys(loginpage.loginemail(), (prop.getProperty("email")));
        log.debug("user entered email");

        base.clickwebelementsendkeys(loginpage.loginpassword(), (prop.getProperty("password")));
        log.debug("user entered password");

        loginpage.loginsubmit().click();
        log.info("user succesfully logged in");

        Registerpage registerpage1 = new Registerpage(driver);
        base.clickwebelement(registerpage1.Accountbutton());
        log.debug("Clicked on Accountbutton");

        if (loginpage.logoutbutton().isDisplayed()) {

            log.info("login succesfull");

        } else {

            log.info("login failed");

        }


    }

    @BeforeMethod
    public void openapp() throws IOException {

        log = LogManager.getLogger(Registertest.class.getName());
        driver = intilizebrowser();
        log.debug("Browser got launched");
        driver.get(prop.getProperty("url"));
        log.debug("Navigated to application url");


    }

    @AfterMethod
    public void closser() {

        driver.close();
        log.debug("Browser got closed");

    }


}
