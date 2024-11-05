package Pages;

import Data.TestData;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class LoginPage extends ParentPage {

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement inputUserNameInLoginForm;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement inputPasswordInLoginForm;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement buttonLogIn;

    @FindBy (xpath = "//div[contains(@class, 'error-message-container')]//h3[@data-test='error' and contains(., 'Epic sadface: Username and password do not match any user in this service')]\n")
    private WebElement notificationAlert;

    final static String listErrorMessages = "//div[contains(@class, 'error-message-container')]";
    @FindBy(xpath = listErrorMessages)
    private List<WebElement> listOfMessages;

    private Logger logger = Logger.getLogger(getClass());



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
    public LoginPage checkIsInputUserNameVisible() {
        checkIsElementVisible(inputUserNameInLoginForm);
        return this;
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


    public LoginPage checkErrorMessageForLoginForm(String expectedMessage) {
        logger.info("Expected error message: " + expectedMessage);
        webDriverWait_15.until(ExpectedConditions.
                visibilityOfAllElementsLocatedBy(By.xpath(listErrorMessages)));
        List<WebElement> errorMessages = listOfMessages;
        List<String> actualMessages = errorMessages.stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());
        logger.info("Actual error messages: " + actualMessages);
        boolean messageFound = actualMessages.contains(expectedMessage.trim());
        Assert.assertTrue("Expected message not found: " + expectedMessage,
                messageFound);
        if (messageFound) {
            logger.info("Expected message found.");
        } else {
            logger.warn("Expected message not found.");
        }

        return this;
    }

}
