package Pages;

import io.qameta.allure.Step;
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
        return isElementVisible(inputUserNameInLoginForm);
    }

    @Step
    public boolean isInputPasswordVisible() {
        return isElementVisible(inputPasswordInLoginForm);
    }

    @Step
    public void clickOnButtonLogin() {
        clickOnElement(buttonLogIn);
    }

    @Step
    public boolean isButtonLogInVisible() {
        return isElementDisplayed(buttonLogIn, "Log In button");
    }
}
