package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

    WebDriver driver;

    public Loginpage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//form[@action='https://www.bhaane.com/login']//input[@name='email']")
    private WebElement loginemail;

    @FindBy(xpath = "//div[@class='form-group mt-lg']//input[@name='password']")
    private WebElement loginpassword;

    @FindBy(xpath = "//button[@class='btn btn-primary'][normalize-space()='submit']")
    private WebElement loginsubmit;

    @FindBy(xpath = "//a[normalize-space()='log out']")
    private WebElement logoutbutton;

    public WebElement loginemail() {

        return loginemail;

    }

    public WebElement loginpassword() {

        return loginpassword;

    }

    public WebElement loginsubmit() {

        return loginsubmit;


    }

    public WebElement logoutbutton() {

        return logoutbutton;


    }


}
