package CartTest;

import BaseTest.BaseTest;
import org.junit.Assert;
import org.junit.Test;




public class AddToCart extends BaseTest {

    @Test
    public void T07_AddToCart(){
        pageProvider.getLoginPage().openLoginPageAndFillLoginFormWithValidCredentials();
        pageProvider.getHomePage().addToCart();
        Assert.assertTrue("RemoveButton is not Visible",
                pageProvider.getHomePage().isRemoveButtonFromCartIsVisible());
        Assert.assertEquals("1",
                pageProvider.getHomePage().getHeaderElement().getCartCount());
    }
}
