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


@Feature("Login Features")
@Story("As a user, I should be able to login")
public class LoginTest extends TestBase {

    @Test
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

    @Test(dataProvider = "invalidCredentials")
    @Severity(SeverityLevel.CRITICAL) @Owner("Leena") @Tag("smoke")
    @TmsLink("CRMLY10-2")
    @Description("Verify that the user can log in with valid credentials ")
    public void verifyLoginWithInvalidCredentials(String username, String password) {
        new LoginPage()
                .login(username, password)
                .verifyUnsuccessfulLogin();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that remember me link is clickable")
    public void verifyRememberMeLinkIsClickable() {
       LoginPage loginPage= new LoginPage();
       loginPage.click(loginPage.rememberMe)
               .verifyRememberMeLinkIsClickable();
    }

}
