package Pages.elements;

import Pages.CommonActionsWithElements;
import Pages.HomePage;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderElement extends CommonActionsWithElements {

    @FindBy (xpath = "//div[@id='shopping_cart_container']//a[@class='shopping_cart_link']")
    private WebElement buttonCart;

    @FindBy (xpath = "//div[@class='bm-burger-button']//button[@id='react-burger-menu-btn']\n")
    private WebElement burgerMenuButton;

    @FindBy (xpath = "//a[@id='logout_sidebar_link' and @data-test='logout-sidebar-link']\n")
    private WebElement buttonSignOut;

    @FindBy(css = "span.shopping_cart_badge[data-test='shopping-cart-badge']")
    private WebElement cartBadge;
    private Logger logger = Logger.getLogger(getClass());



    public HeaderElement(WebDriver webDriver) {
        super(webDriver);
    }

    @Step
    public boolean isCartButtonIsVisible() {
        return isElementDisplayed(buttonCart , "Cart button");
    }

    @Step
    public HeaderElement checkCartButtonIsVisible() {
        checkIsElementVisible(buttonCart);
        return this;
    }


    @Step
    public String getCartCount() {
        String count = "0";

        if (isElementDisplayed(cartBadge, "Cart badge")) {
            count = cartBadge.getText();
        }
        logger.info("Goods Count: " + count);

        return count;
    }

    @Step
    public void checkCartCount(String expectedCount) {
        String actualCount = getCartCount();
        Assert.assertEquals("Error: The number of items in the cart does not match the expected value.",
                expectedCount, actualCount);
        logger.info("Expected quantity of goods " + expectedCount + " coincides with the actual one.");
    }

    @Step
    public boolean isBurgerMenuButtonIsVisible() {
        return isElementDisplayed(burgerMenuButton , "BurgerMenu button");
    }

    @Step
    public HomePage clickOnButtonBurgerMenuButton() {
        clickOnElement(burgerMenuButton);
        return new HomePage(webDriver);
    }
    @Step
    public HomePage clickOnButtonSignOut() {
        clickOnElement(buttonSignOut);
        return new HomePage(webDriver);
    }



}
