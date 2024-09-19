package LoginTest;

import BaseTest.BaseTest;
import org.junit.Test;

public class LoginTest extends BaseTest {

    @Test
    public void T01_ValidLoginTest() {
        pageProvider.getLoginPage().openLoginPage();

    }
}
