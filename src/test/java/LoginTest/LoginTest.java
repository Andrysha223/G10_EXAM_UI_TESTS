package LoginTest;

import BaseTest.BaseTest;
import Data.TestData;
import org.junit.Assert;
import org.junit.Test;
import utils.Utils;


public class LoginTest extends BaseTest {

    @Test
    public void T01_ValidLoginTest() {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputLogin(TestData.VALID_LOGIN_UI);
        pageProvider.getLoginPage().enterTextIntoInputPassword(TestData.VALID_PASSWORD_UI);
        pageProvider.getLoginPage().clickOnButtonLogin();


        Assert.assertFalse("Button Sign In is displayed",
                pageProvider.getLoginPage().isButtonLogInVisible());
        Assert.assertFalse("Input for password is visible",
                pageProvider.getLoginPage().isInputPasswordVisible());
        Assert.assertFalse("Input for login is visible",
                pageProvider.getLoginPage().isInputUserNameVisible());


    }
}
