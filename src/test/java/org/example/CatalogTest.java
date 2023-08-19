package org.example;


import org.example.pages.CatalogPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class CatalogTest extends AbstractTest {

	@Test
	public void testCatalog() throws Exception {
		openItems();
		CatalogPage catalogPage = new CatalogPage(driver);
		List<String> breadCrumbs = catalogPage.getBreadCrumbs();
		Assertions.assertEquals(4, breadCrumbs.size());
		Assertions.assertEquals(String.copyValueOf("Главная".toCharArray()), breadCrumbs.get(0));
		Assertions.assertEquals(String.copyValueOf("Каталог".toCharArray()), breadCrumbs.get(1));
		Assertions.assertEquals(String.copyValueOf("Лечебное и диетическое питание".toCharArray()), breadCrumbs.get(2));
		Assertions.assertEquals(String.copyValueOf("Препараты от кашля".toCharArray()), breadCrumbs.get(3));

		Assertions.assertTrue(catalogPage.getItems().size() > 0);
	}
}
