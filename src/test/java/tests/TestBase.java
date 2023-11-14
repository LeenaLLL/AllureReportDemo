package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigurationReader;
import utilities.Driver;

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
    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException {
        //if test fails
        if(result.getStatus()==ITestResult.FAILURE){

        }
        Thread.sleep(2000);
        Driver.closeDriver();
    }

    @AfterTest
    public void tearDownTest(){

    }
}
