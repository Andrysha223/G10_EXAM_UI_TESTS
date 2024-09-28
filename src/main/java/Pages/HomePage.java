package Pages;

import Pages.elements.HeaderElement;
import org.openqa.selenium.WebDriver;

public class HomePage extends ParentPage {

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
}
