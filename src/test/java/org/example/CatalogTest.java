package org.example;


import org.example.pages.CatalogPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CatalogTest extends AbstractTest {

	@Test
	public void testCatalog() throws Exception {
		WebElement element = driver.findElement(By.className("table-menu"));
		List<WebElement> links = element.findElements(By.tagName("a"));
		WebElement target = null;
		for(WebElement link : links) {
			String title = link.getAttribute("title");
			System.out.println(title);
			if("Препараты от кашля".equals(title.trim())) {
				target = link;
				break;
			}
		}
		Assertions.assertNotNull(target);
		target.click();
		Thread.sleep(1000);
		CatalogPage catalogPage = new CatalogPage(driver);
		List<String> breadCrumbs = catalogPage.getBreadCrumbs();
		Assertions.assertEquals(4, breadCrumbs.size());
		Assertions.assertEquals("Главная", breadCrumbs.get(0));
		Assertions.assertEquals("Каталог", breadCrumbs.get(1));
		Assertions.assertEquals("Лечебное и диетическое питание", breadCrumbs.get(2));
		Assertions.assertEquals("Препараты от кашля", breadCrumbs.get(3));

		Assertions.assertTrue(catalogPage.getItems().size() > 0);
	}
}
