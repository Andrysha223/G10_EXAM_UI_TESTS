package Pages;

import Pages.elements.HeaderElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends ParentPage {

    @FindBy (xpath = "//select[@class='product_sort_container' and @data-test='product-sort-container']\n")
    private WebElement sortDropDown;

    @FindBy(css = "select.product_sort_container[data-test='product-sort-container']")
    private WebElement sortDropdown;

    @FindBy (xpath = "//button[@id='add-to-cart-sauce-labs-backpack']\n")
    private WebElement getAddToCart;

    @FindBy (xpath = "//button[@id='remove-sauce-labs-backpack']\n")
    private WebElement removeButton;



    public HeaderElement getHeaderElement() {
        return new HeaderElement(webDriver);
    }

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/";
    }

    public HomePage getHomePage() {
        return new HomePage(webDriver);
    }

    public CommonActionsWithElements getCommonActionsWithElements() {
        return new CommonActionsWithElements(webDriver);
    }

    @Step
    public boolean isSortDropDownIsVisible() {
        return isElementVisible(sortDropDown, "SortDropDown is visible");
    }

    @Step
    public void selectSortOptionByValue(String value) {
        Select dropdown = new Select(sortDropdown);
        dropdown.selectByValue(value);
    }

    @Step
    public void selectSortOptionByText(String visibleText) {
        Select dropdown = new Select(sortDropdown);
        dropdown.selectByVisibleText(visibleText);
    }

    @Step
    public String getSelectedOption() {
        Select dropdown = new Select(sortDropdown);
        return dropdown.getFirstSelectedOption().getAttribute("value");
    }

    @Step
    public void addToCart () {
        clickOnElement(getAddToCart);
    }

    @Step
    public boolean isRemoveButtonFromCartIsVisible (){
        return isElementVisible(removeButton, "RemoveButton is Visible");
    }



}
