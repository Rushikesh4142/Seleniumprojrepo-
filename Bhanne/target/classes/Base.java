package resources5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Base {

    public WebDriver driver;
    public Properties prop;

    public WebDriver intilizebrowser() throws IOException {

        prop = new Properties();

        String proppath = System.getProperty("user.dir") + "\\src\\main\\java\\resources5\\data.properties";

        FileInputStream fis = new FileInputStream(proppath);

        prop.load(fis);

        WebDriver driver = null;

        String browser = prop.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver();


        } else if (browser.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();

            driver = new FirefoxDriver();


        }

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }

    public String takeScreenshot(String testName, WebDriver driver) throws IOException {

        File SourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destinationFilePath = System.getProperty("user.dir") + "\\screenshots\\" + testName + "" + System.currentTimeMillis() + ".png";
        FileUtils.copyFile(SourceFile, new File(destinationFilePath));


        return destinationFilePath;
    }


    public  void clickwebelementsendkeys(WebElement element, String msg) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {

            wait.until(ExpectedConditions.visibilityOf(element));
            element.sendKeys(msg);
        } catch (Exception e) {
            element.sendKeys(msg);

        }

    }

    public void clickwebelement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {

            wait.until(ExpectedConditions.visibilityOf(element));
            element.click();

        } catch (Exception e) {

            element.click();


        }


    }


    public String generateRandomEmail() {
        String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "example.com"};
        Random random = new Random();
        String randomDomain = domains[random.nextInt(domains.length)];
        return "user" + System.currentTimeMillis() + "@" + randomDomain;
    }


}
