package SortTest;

import BaseTest.BaseTest;
import org.junit.Test;

public class SortTest extends BaseTest {
     final String SORT_NAME_AZ = "az";
     final String SORT_NAME_ZA = "za";
     final String SORT_PRICE_LOW_TO_HIGH = "lohi";
     final String SORT_PRICE_HIGH_TO_LOW = "hilo";


     @Test
    public void T07_SortTestLowToHigh () {
         pageProvider.getLoginPage().openLoginPageAndFillLoginFormWithValidCredentials();
         pageProvider.getHomePage().selectSortOptionByValue(SORT_PRICE_LOW_TO_HIGH);



     }
}
