package Pages;

import Data.TestData;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement inputUserNameInLoginForm;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement inputPasswordInLoginForm;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement buttonLogIn;

    @FindBy (xpath = "//div[contains(@class, 'error-message-container')]//h3[@data-test='error' and contains(., 'Epic sadface: Username and password do not match any user in this service')]\n")
    private WebElement notificationAlert;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/";
    }

    @Step
    public void openLoginPage() {
        webDriver.get(baseUrl);
        logger.info( "Login page was opened_" + baseUrl);
    }
    @Step
    public void enterTextIntoInputLogin(String login) {
        clearAndEnterTextIntoElement(inputUserNameInLoginForm, login);
    }
    @Step
    public void enterTextIntoInputPassword(String password) {
        clearAndEnterTextIntoElement(inputPasswordInLoginForm, password);
    }

    @Step
    public boolean isInputUserNameVisible() {
        return isElementVisible(inputUserNameInLoginForm, "InputUserName is visible");
    }

    @Step
    public boolean isInputPasswordVisible() {
        return isElementVisible(inputPasswordInLoginForm, "InputPassword is visible");
    }

    @Step
    public void clickOnButtonLogin() {
        clickOnElement(buttonLogIn);
    }

    @Step
    public boolean isButtonLogInVisible() {
        return isElementDisplayed(buttonLogIn, "Log In button");
    }

    @Step
    public HomePage openLoginPageAndFillLoginFormWithValidCredentials() {
        openLoginPage();
        enterTextIntoInputLogin(TestData.VALID_LOGIN_UI);
        enterTextIntoInputPassword(TestData.VALID_PASSWORD_UI);
        clickOnButtonLogin();
        return new HomePage(webDriver);
    }

    public LoginPage checkIsLogInVisible() {
        Assert.assertTrue("Button Log In is not visible", isButtonSignInVisible());
        return this;
    }

    public boolean isButtonSignInVisible() {
        return isElementDisplayed(buttonLogIn, "Sign In button");
    }


    public boolean isNotificationVisible() {
        return isElementDisplayed(notificationAlert, "Notification alert");
    }

}
