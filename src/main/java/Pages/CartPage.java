package Pages;

import Pages.elements.HeaderElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends ParentPage {

    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CartPage getProductPage() {
        return new CartPage(webDriver);
    }

    public HeaderElement getHeaderElement() {
        return new HeaderElement(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/";
    }

    public CartPage getCartPage() {
        return new CartPage(webDriver);
    }

    public CommonActionsWithElements getCommonActionsWithElements() {
        return new CommonActionsWithElements(webDriver);
    }


}
