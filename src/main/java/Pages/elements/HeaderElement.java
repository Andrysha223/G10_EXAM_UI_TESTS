package Pages.elements;

import Pages.CommonActionsWithElements;
import Pages.HomePage;
import io.qameta.allure.Step;
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


    public HeaderElement(WebDriver webDriver) {
        super(webDriver);
    }

    @Step
    public boolean isCartButtonIsVisible() {
        return isElementDisplayed(buttonCart , "Cart button");
    }

    @Step
    public String getCartCount() {
        if (isElementDisplayed(cartBadge, "Cart badge")) {
            return cartBadge.getText();
        }
        return "0";
    }

    @Step
    public boolean isBurgerMenuButtonIsVisible() {
        return isElementDisplayed(burgerMenuButton , "Cart button");
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
