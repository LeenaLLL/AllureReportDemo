package pages;
import com.fasterxml.jackson.databind.ser.Serializers;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;

import java.util.List;

public class LogoutPage extends BasePage {

    public LogoutPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath="//span[@id=\"user-name\"]")
    public WebElement userNameButton;

    @FindBy(xpath="//span[text()=\"My Profile\"]")
    public WebElement myProfile;

    @FindBy(xpath = "//span[.='Log out']")
    public WebElement logOutButton;

    @FindBy (xpath = "//div[@class=\"menu-popup-items\"]//a")
    public List<WebElement> profile_edit_logout;

    @FindBy(xpath = "(//span[.=\"Themes\"])[2]")
    public WebElement teamButton;

    @FindBy(xpath = "(//span[.=\"Configure notifications\"])[2]")
    public WebElement config;

    @Step("Click on {0}")
    public LogoutPage clickOn(WebElement webElement){
        webElement.click();
        return this;
    }
    @Step( "Verify user can log out" )
    public void verifySuccessfulLogOut() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Authorization"));

    }




}
