package tests;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;

    //env set up
    protected  String url;



    @BeforeMethod
    public void setUp(){

        url = ConfigurationReader.getProperty("url");
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(url);

    }
    //ITestResult class describes the result of a test in TestNG
    public void tearDown(ITestResult result) {
        if (Driver.getDriver() != null && result.getStatus() == ITestResult.FAILURE) {
            attachLog(result.getInstanceName() + " failed.");
            attachLog("Screenshot captured for test case: " + result.getInstanceName());
            Allure.addAttachment ("Screenshot", new ByteArrayInputStream(BrowserUtils.captureScreenshot()));
        }
            Driver.closeDriver();
    }
            public String attachLog (String message){
                Allure.addAttachment("Log", message);
                return message;
            }

    @AfterTest
    public void tearDownTest(){

    }
}
