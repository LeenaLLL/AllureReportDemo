package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LogoutPage;

@Feature("Log Out Features")
@Story("As a user, I should be able to logout")
public class LogOutTest extends TestBase{

    @Test
    @Description("verify ....")
    @Link("Crmly-234")
    public void verifyLogOut(){
        LogoutPage logoutPage= new LogoutPage();
        LoginPage loginPage= new LoginPage();

        loginPage
                .loginAsUserType("hr");
        logoutPage
                .clickOn(logoutPage.userNameButton)
                .clickOn(logoutPage.logOutButton)
                .verifySuccessfulLogOut();
    }



}
