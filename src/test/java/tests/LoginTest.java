package tests;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.LoginPage;
import utilities.Driver;
import utilities.Groups;


@Feature("Login Features")
public class LoginTest extends TestBase {

    @Test(groups = Groups.REGRESSION)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that the user can log in with valid credentials ")
    public void verifyLoginWithValidCredentials() {
        new LoginPage()
                .loginAsUserType("hr")
                .verifySuccessfulLogin();
    }

    @DataProvider(name = "invalidCredentials")
    public Object[][] invalidCredentials() {
        // Provide invalid username-password pairs
        return new Object[][]{
                {"hr1@cybertekschool.com", "invalidPassword"},
                {"invalidUser","UserUser"},
                {"",""},
        };
    }

    @Test(dataProvider = "invalidCredentials", groups = Groups.REGRESSION)
    @Severity(SeverityLevel.CRITICAL)

    public void verifyLoginWithInvalidCredentials(String username, String password) {
        new LoginPage()
                .login(username, password)
                .verifyUnsuccessfulLogin();
    }

    @Test(groups = Groups.REGRESSION)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that remember me link is clickable")
    public void verifyRememberMeLinkIsClickable() {
       LoginPage loginPage= new LoginPage();
       loginPage.click(loginPage.rememberMe)
               .verifyRememberMeLinkIsClickable();
    }

}
