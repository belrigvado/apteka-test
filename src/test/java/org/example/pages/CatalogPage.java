package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CatalogPage extends ItemsPage {
	private final By breadCrumbsBy = By.className("breadcrumbs");
	public CatalogPage(WebDriver driver) {
		super(driver);
	}

	public List<String> getBreadCrumbs() {
		List<WebElement> elements = driver.findElements(breadCrumbsBy);
		List<String> result = new ArrayList<>();
		for(WebElement element : elements) {
			List<WebElement> links = element.findElements(By.tagName("span"));
			for(WebElement link : links) {
				if("name".equals(link.getAttribute("itemprop"))) {
					result.add(link.getText());
				}
			}
		}
		return result;
	}
}
