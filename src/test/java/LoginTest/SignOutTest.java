package LoginTest;

import BaseTest.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SignOutTest extends BaseTest {


    @Before
    public void LogIn() {
        pageProvider.getLoginPage().openLoginPageAndFillLoginFormWithValidCredentials();

        Assert.assertTrue("Button Cart is not displayed",
                pageProvider.getHomePage().getHeaderElement().isCartButtonIsVisible());
        Assert.assertTrue("Button BurgerMenu as not displayed",
                pageProvider.getHomePage().getHeaderElement().isBurgerMenuButtonIsVisible());
        Assert.assertTrue("SortDropDown is not displayed",
                pageProvider.getHomePage().isSortDropDownIsVisible());


        Assert.assertFalse("Button Sign In is displayed",
                pageProvider.getLoginPage().isButtonLogInVisible());
        Assert.assertFalse("Input for password is visible",
                pageProvider.getLoginPage().isInputPasswordVisible());
        Assert.assertFalse("Input for login is visible",
                pageProvider.getLoginPage().isInputUserNameVisible());


}
    @Test
    public void T05_signOut() {
        pageProvider.getHomePage().getHeaderElement().clickOnButtonBurgerMenuButton();
        pageProvider.getHomePage().getHeaderElement().clickOnButtonSignOut();

        Assert.assertTrue("Button Sign Out is not displayed",
                pageProvider.getLoginPage().isButtonSignInVisible());
        Assert.assertTrue("InputLogin is not visible",
                pageProvider.getLoginPage().isInputUserNameVisible());
        Assert.assertTrue("InputPassword is not visible",
                pageProvider.getLoginPage().isInputPasswordVisible());
        Assert.assertFalse("Button Cart is not displayed",
                pageProvider.getHomePage().getHeaderElement().isCartButtonIsVisible());
        Assert.assertFalse("Button BurgerMenu Is displayed",
                pageProvider.getHomePage().getHeaderElement().isBurgerMenuButtonIsVisible());

    }
    }
