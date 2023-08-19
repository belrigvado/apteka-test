package org.example;


import org.example.pages.CatalogPage;
import org.example.pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


public class SearchTest extends AbstractTest {

	@Test
	public void testSearch() throws Exception {
		HomePage homePage = new HomePage(driver);
		String query = "bobs";
		homePage.makeSearch(query);
		Thread.sleep(1000);
		CatalogPage catalogPage = new CatalogPage(driver);
		List<String> items = catalogPage.getItems();
		Assertions.assertFalse(items.isEmpty());
		for(String item : catalogPage.getItems()) {
			Assertions.assertTrue(item.toLowerCase().contains(query));
		}
	}
}
