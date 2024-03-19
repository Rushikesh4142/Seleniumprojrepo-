package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Accountpage {

    WebDriver driver ;

    public Accountpage(WebDriver driver){

        this.driver =  driver;
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(xpath = "//h2[normalize-space()='recent orders']")
    private  WebElement recentorder;

    public WebElement recentorder(){

        return recentorder;

    }











}
