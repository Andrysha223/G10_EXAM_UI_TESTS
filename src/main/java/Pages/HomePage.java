package Pages;

import Pages.elements.HeaderElement;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {

    @FindBy (xpath = "//select[@class='product_sort_container' and @data-test='product-sort-container']\n")
    private WebElement sortDropDown;

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

    @Step
    public boolean isSortDropDownIsVisible() {
        return isElementVisible(sortDropDown, "SortDropDown is visible");
    }

    public void addToCartByName(String productName) {
        String buttonLocator = String.format("//button[@data-test='add-to-cart-%s']",
                productName.toLowerCase().replace(" ", "-"));
        WebElement addToCartButton = webDriver.findElement(By.xpath(buttonLocator));
        clickOnElement(addToCartButton);
    }

    public boolean isRemoveButtonVisible(String productName) {
        String buttonLocator = String.format("//button[@data-test='remove-%s']",
                productName.toLowerCase().replace(" ", "-"));
        try {
            WebElement removeButton = webDriver.findElement(By.xpath(buttonLocator));
            return isElementDisplayed(removeButton, "Remove button for " + productName);
        } catch (Exception e) {
            logger.info("Remove button for " + productName + " is not found");
            return false;
        }
    }

    public HomePage checkIsRemoveButtonVisible(String productName) {
        Assert.assertTrue("Remove Button for "
                + productName + " is not visible", isRemoveButtonVisible(productName));
        return this;
    }

    public HomePage checkIsRemoveButtonNotVisible(String productName) {
        Assert.assertFalse("Remove Button for "
                + productName + " is visible", isRemoveButtonVisible(productName));
        return this;
    }


    public void removeFromCartByName(String productName) {
        String buttonLocator = String.format("//button[@data-test='remove-%s']",
                productName.toLowerCase().replace(" ", "-"));
        WebElement removeButton = webDriver.findElement(By.xpath(buttonLocator));
        clickOnElement(removeButton);
    }


    public void goToProductPageByName(String productName) {
        String productLocator = String.format("//div[@data-test='inventory-item-name' and text()='%s']", productName);
        WebElement productElement = webDriver.findElement(By.xpath(productLocator));
        clickOnElement(productElement);
    }




}
