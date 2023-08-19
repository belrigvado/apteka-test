package org.example;

import org.example.pages.CatalogPage;
import org.example.pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class AddDelayedTest extends AbstractTest {
    @Test
    public void addDelayedTest() throws Exception {
        HomePage homePage = new HomePage(driver);
        Assertions.assertEquals(0, homePage.getDelayedCount());
        openItems();
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.addFirstToDelay();
        Thread.sleep(1000);
        homePage = new HomePage(driver);
        Assertions.assertEquals(1, homePage.getDelayedCount());
    }
}
