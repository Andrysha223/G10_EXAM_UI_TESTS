package CartTest;

import BaseTest.BaseTest;
import Data.TestData;
import org.junit.Assert;
import org.junit.Test;




public class AddToCart extends BaseTest {

    @Test
    public void T08_AddToCartAndCheckCount() {
        pageProvider.getLoginPage().openLoginPageAndFillLoginFormWithValidCredentials();
        pageProvider.getHomePage().addToCartByName(TestData.ProductNames.SAUCE_LABS_BACKPACK);
        pageProvider.getHomePage().addToCartByName(TestData.ProductNames.SAUCE_LABS_BIKER_JACKET);
        pageProvider.getHomePage().checkIsRemoveButtonVisible(TestData.ProductNames.SAUCE_LABS_BACKPACK);
        pageProvider.getHomePage().checkIsRemoveButtonVisible(TestData.ProductNames.SAUCE_LABS_BIKER_JACKET);
        Assert.assertEquals("2",
                pageProvider.getHomePage().getHeaderElement().getCartCount());
    }

    @Test
    public void T_09_AddToCartAndRemove() {
        pageProvider.getLoginPage().openLoginPageAndFillLoginFormWithValidCredentials();
        pageProvider.getHomePage().addToCartByName(TestData.ProductNames.SAUCE_LABS_BACKPACK);
        pageProvider.getHomePage().addToCartByName(TestData.ProductNames.SAUCE_LABS_BIKER_JACKET);
        pageProvider.getHomePage().checkIsRemoveButtonVisible(TestData.ProductNames.SAUCE_LABS_BACKPACK);

        pageProvider.getHomePage().checkIsRemoveButtonVisible(TestData.ProductNames.SAUCE_LABS_BIKER_JACKET);
        Assert.assertEquals("2",
                pageProvider.getHomePage().getHeaderElement().getCartCount());

        pageProvider.getHomePage().removeFromCartByName(TestData.ProductNames.SAUCE_LABS_BACKPACK);
        pageProvider.getHomePage().removeFromCartByName(TestData.ProductNames.SAUCE_LABS_BIKER_JACKET);
        pageProvider.getHomePage().checkIsRemoveButtonNotVisible(TestData.ProductNames.SAUCE_LABS_BACKPACK);
        pageProvider.getHomePage().checkIsRemoveButtonNotVisible(TestData.ProductNames.SAUCE_LABS_BIKER_JACKET);
        Assert.assertEquals("0",
                pageProvider.getHomePage().getHeaderElement().getCartCount());
    }

    @Test
    public void T_10_AddToCartOnProductPage() {
        pageProvider.getLoginPage().openLoginPageAndFillLoginFormWithValidCredentials();
        pageProvider.getHomePage().goToProductPageByName(TestData.ProductNames.SAUCE_LABS_BIKER_JACKET);
        pageProvider.getProductPage().clickAddToCart();
        pageProvider.getProductPage().isRemoveButtonVisible();
        pageProvider.getProductPage().checkProductImageVisible(TestData.ProductNames.SAUCE_LABS_BIKER_JACKET);
        pageProvider.getProductPage().getHeaderElement().verifyCartCount("1");
        pageProvider.getProductPage().getHeaderElement().isBurgerMenuButtonIsVisible();
    }
}
