package LoginTest;

import BaseTest.BaseTest;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class ValidationMessage extends BaseTest {
    final String USER_NAME_MESSAGE = "Epic sadface: Username is required";
    final String PASSWORD_MESSAGE = "Epic sadface: Password is required";



    @Test
    @Parameters(method = "parametersForValidationMessagesTest")
    public void T07_ValidationMessagesTest(String userName, String password, String expectedMessages) {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputLogin(userName);
        pageProvider.getLoginPage().enterTextIntoInputPassword(password);
        pageProvider.getLoginPage().clickOnButtonLogin();
        pageProvider.getLoginPage().checkErrorMessageForLoginForm(expectedMessages);
    }

    public Object[][] parametersForValidationMessagesTest() {
        return new Object[][]{
                { "", "qwe12335", USER_NAME_MESSAGE },
                {"Andriy", "", PASSWORD_MESSAGE}
        };
    }
}
