package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

public class LoginPage extends BasePage{

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //--LOCATORS--
    @FindBy(xpath = "//div[@class='errortext']")
    public WebElement errMessage;
    @FindBy(id="USER_REMEMBER")
    public WebElement rememberMe;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement attribute;
    @FindBy(xpath = "//input[@name='USER_LOGIN']")
    public WebElement usernameField;
    @FindBy(xpath = "//input[@name='USER_PASSWORD']")
    public WebElement passwordField;
    @FindBy(xpath = "//input[@value='Log In']")
    public WebElement logInButton;

    //--METHODS--
    /*
    Log in with valid credentials
     */
    @Step("Enter {0} as username and {1} as password")
    public LoginPage login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        BrowserUtils.sleep(3);
        logInButton.click();
        return this;
    }

    /*
    Log in as a specific userType
     */
    @Step("Login as {0}")
    public LoginPage loginAsUserType(String userType) {
        String username = ConfigurationReader.getProperty(userType + "_username");
        String password = ConfigurationReader.getProperty(userType + "_password");
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        logInButton.click();
        return this;

    }

    @Step("Verify that the user can log in with valid credentials ")
    public void verifySuccessfulLogin() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Portal") );
    }
    @Step("Verify that the user can log in with invalid credentials ")
    public void verifyUnsuccessfulLogin() {
        Assert.assertFalse(Driver.getDriver().getTitle().contains("Portal") );
    }
    @Step("Click on Remember Me checkbox")
    public LoginPage click(WebElement webElement){
        webElement.click();
        return this;
    }
    public void verifyRememberMeLinkIsClickable() {
        Assert.assertTrue(rememberMe.isSelected());
    }
}
