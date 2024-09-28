package Pages.elements;

import Pages.CommonActionsWithElements;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderElement extends CommonActionsWithElements {

    @FindBy (xpath = "//div[@id='shopping_cart_container']//a[@class='shopping_cart_link']")
    private WebElement buttonCart;

    @FindBy (xpath = "//div[@class='bm-burger-button']//button[@id='react-burger-menu-btn']\n")
    private WebElement burgerMenuButton;




    public HeaderElement(WebDriver webDriver) {
        super(webDriver);
    }

    @Step
    public boolean isCartButtonIsVisible() {
        return isElementDisplayed(buttonCart , "Cart button");
    }
    @Step
    public boolean isBurgerMenuButtonIsVisible() {
        return isElementDisplayed(burgerMenuButton , "Cart button");
    }




}
