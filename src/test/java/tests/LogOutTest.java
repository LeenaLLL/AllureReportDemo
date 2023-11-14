package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LogoutPage;

@Feature("Login Features")
@Story("As a user, I should be able to login")
public class LogOutTest {

    @Test
    public void verifyLogOut(){
        LogoutPage logoutPage= new LogoutPage();
        LoginPage loginPage= new LoginPage();

        loginPage
                .loginAsUserType("hr");
        logoutPage
                .clickOn(logoutPage.userNameButton)
                .verifySuccessfulLogOut();
    }




}
