package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources5.Base;
import utilities.ExtentReporter;

import java.io.IOException;



public class Listeners5 extends Base implements ITestListener {

    WebDriver driver = null;

    ExtentReports extentReport = ExtentReporter.getExtentReport();
    ExtentTest extenttest;
    ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();


    @Override
    public void onTestStart(ITestResult result) {

        String testName = result.getName();

         extenttest = extentReport.createTest(testName + " excutation started");
         extentTestThread.set(extenttest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {


        String testname = result.getName();

        try {
            driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            String screenshotFilePath = takeScreenshot(testname, driver);
            extentTestThread.get().addScreenCaptureFromPath(screenshotFilePath, testname );
        } catch (IOException e) {
            e.printStackTrace();
        }

       
        extentTestThread.get().log(Status.PASS,"Test Passed");




    }

    @Override
    public void onTestFailure(ITestResult result) {

        String testname = result.getName();

        extentTestThread.get().fail(result.getThrowable());
        
        try {
            driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            String screenshotFilePath = takeScreenshot(testname, driver);
            extentTestThread.get().addScreenCaptureFromPath(screenshotFilePath, testname );
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ;
    }

    @Override
    public void onStart(ITestContext context) {
        ;
    }

    @Override
    public void onFinish(ITestContext context) {

        extentReport.flush();

    }
}
