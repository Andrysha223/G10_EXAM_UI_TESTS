package Pages;

import Pages.elements.HeaderElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends ParentPage {

    @FindBy (xpath = "//button[@id='add-to-cart']\n")
    private WebElement productAddToCart;

    @FindBy (xpath = "//button[@id='remove']\n")
    private WebElement removeButton;

    public ProductPage (WebDriver webDriver) {
        super(webDriver);
    }

    public HeaderElement getHeaderElement() {
        return new HeaderElement(webDriver);
    }


    public ProductPage getProductPage(){
        return new ProductPage(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/";
    }


    public ProductPage clickAddToCart() {
        clickOnElement(productAddToCart);
        return new ProductPage(webDriver);
    }

    public boolean isRemoveButtonVisible () {
        return isElementDisplayed(removeButton, "Remove Product button");
    }

    public void checkProductImageVisible(String productName) {
        String imageLocator = String.format("//img[@data-test='item-%s-img']",
                productName.toLowerCase().replace(" ", "-"));
        try {
            WebElement productImage = webDriver.findElement(By.xpath(imageLocator));
            Assert.assertTrue("Ошибка: Изображение для товара '" + productName + "' не отображается.",
                    productImage.isDisplayed());
        } catch (NoSuchElementException e) {
            Assert.fail("Ошибка: Изображение для товара '" + productName + "' не найдено на странице.");
        }
    }



}
