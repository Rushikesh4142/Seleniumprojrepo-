package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Registerpage {


    WebDriver driver;

    public Registerpage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(this.driver, this);

    }

    @FindBy(name = "first_name")
    private WebElement firstnamefield;

    @FindBy(name = "last_name")
    private WebElement lastnamefield;

    @FindBy(xpath = "//div[@class='col-12']//input[@name='email']")
    private WebElement emailfield;

    @FindBy(name = "mobile")
    private WebElement mobilefield;

    @FindBy(xpath = "//div[@class='form-group']//input[@name='password']")
    private WebElement passwordfield;

    @FindBy(xpath = "//button[@class='btn btn-primary c-center']")
    private WebElement submitbutton;

    @FindBy(xpath = "//a[normalize-space()='Rushikesh']")
    private WebElement Accountbutton;

    public WebElement firstnamefield() {

        return firstnamefield;
    }

    public WebElement lastnamefield() {

        return lastnamefield;

    }

    public WebElement emailfield() {

        return emailfield;

    }

    public WebElement mobilefield() {

        return mobilefield;

    }

    public WebElement passwordfield() {

        return passwordfield;

    }

    public WebElement submitbutton() {

        return submitbutton;


    }

    public WebElement Accountbutton() {

        return Accountbutton;


    }


}
