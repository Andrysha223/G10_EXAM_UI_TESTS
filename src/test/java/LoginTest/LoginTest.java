package LoginTest;

import BaseTest.BaseTest;
import Data.TestData;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static Data.TestData.*;

@RunWith(JUnitParamsRunner.class)
public class LoginTest extends BaseTest {

    @Test
    public void T01_ValidLoginTest() {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputLogin(VALID_LOGIN_UI);
        pageProvider.getLoginPage().enterTextIntoInputPassword(TestData.VALID_PASSWORD_UI);
        pageProvider.getLoginPage().clickOnButtonLogin();

        Assert.assertTrue("Button BurgerMenu is not displayed",
                pageProvider.getHomePage().getHeaderElement().isBurgerMenuButtonIsVisible());
        Assert.assertTrue("Button Cart is not displayed",
                pageProvider.getHomePage().getHeaderElement().isCartButtonIsVisible());
        Assert.assertFalse("Button Sign In is displayed",
                pageProvider.getLoginPage().isButtonLogInVisible());
        Assert.assertFalse("Input for password is visible",
                pageProvider.getLoginPage().isInputPasswordVisible());
        Assert.assertFalse("Input for login is visible",
                pageProvider.getLoginPage().isInputUserNameVisible());
    }

    @Test
    public void T02_inputsAreClearedAfterRefresh() {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputLogin(VALID_LOGIN_UI);
        pageProvider.getLoginPage().enterTextIntoInputPassword(TestData.VALID_PASSWORD_UI);
        pageProvider.getCommonActionsWithElements().refreshPage();
        pageProvider.getLoginPage().clickOnButtonLogin();
        pageProvider.getLoginPage().checkIsLogInVisible();
    }

    @Test
    public void T03_SessionPersistenceAcrossTabs() {
        pageProvider.getLoginPage().openLoginPageAndFillLoginFormWithValidCredentials();
        pageProvider.getHomePage().getHeaderElement().checkIsBurgerMenuButtonIsVisible();
        pageProvider.getHomePage().getHeaderElement().checkCartButtonIsVisible();
        pageProvider.getCommonActionsWithElements().openNewTab();
        pageProvider.getCommonActionsWithElements().switchToTab("new tab", 1);
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getCommonActionsWithElements().switchToTab("main tab", 0);
        pageProvider.getHomePage().getHeaderElement().checkIsBurgerMenuButtonIsVisible();
        pageProvider.getHomePage().getHeaderElement().checkCartButtonIsVisible();
        pageProvider.getCommonActionsWithElements().closeTab("new tab",1);
        pageProvider.getCommonActionsWithElements().switchToTab("main tab", 0);
        pageProvider.getHomePage().getHeaderElement().checkIsBurgerMenuButtonIsVisible();
        pageProvider.getHomePage().getHeaderElement().checkCartButtonIsVisible();
    }

    @Test
    public void T04_invalidLogin() {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputLogin(INVALID_LOGIN_UI);
        pageProvider.getLoginPage().enterTextIntoInputPassword(INVALID_PASSWORD_UI);
        pageProvider.getLoginPage().clickOnButtonLogin();


        Assert.assertTrue("Button Sign Out is not displayed",
                pageProvider.getLoginPage().isButtonSignInVisible());
        Assert.assertTrue("Notification is not displayed",
                pageProvider.getLoginPage().isNotificationVisible());
        Assert.assertTrue("InputLogin is not visible",
                pageProvider.getLoginPage().isInputUserNameVisible());
        Assert.assertTrue("InputPassword is not visible",
                pageProvider.getLoginPage().isInputPasswordVisible());
        Assert.assertFalse("Button BurgerMenu is displayed",
                pageProvider.getHomePage().getHeaderElement().isBurgerMenuButtonIsVisible());
        Assert.assertFalse("Button Cart is displayed",
                pageProvider.getHomePage().getHeaderElement().isCartButtonIsVisible());

    }

    @Test
    @Parameters(method = "ParametersForInvalidLoginTest")
    public void T06_InvalidLoginWithParameters(String login, String password) {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputLogin(login);
        pageProvider.getLoginPage().enterTextIntoInputPassword(password);
        pageProvider.getLoginPage().clickOnButtonLogin();
    }

    public Object[][] ParametersForInvalidLoginTest() {
        return new Object[][]{
                {INVALID_LOGIN_UI, INVALID_PASSWORD_UI},
                {VALID_LOGIN_UI, INVALID_PASSWORD_UI},
                {INVALID_LOGIN_UI, VALID_PASSWORD_UI}
        };
    }




}
