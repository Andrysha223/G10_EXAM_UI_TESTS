package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class LoginPage extends ParentPage {
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/";
    }

    @Step
    public void openLoginPage() {
        webDriver.get(baseUrl);
        logger.info( "Login page was opened_" + baseUrl);
    }
}
