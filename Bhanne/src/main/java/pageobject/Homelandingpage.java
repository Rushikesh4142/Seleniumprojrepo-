package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homelandingpage {


    WebDriver driver;

    public Homelandingpage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "mdiv")
    private WebElement popup;

    @FindBy(xpath = "//li[@class='col hidden-xs']")
    private WebElement Myaccountdropdown;

    @FindBy(xpath = "//div[@data-modal='#modal-register']")
    private WebElement signupbutton;


    public WebElement popup() {

        return popup;

    }

    public WebElement Myaccountdropdown() {

        return Myaccountdropdown;
    }

    public WebElement signupbutton() {

        return signupbutton;
    }


}
