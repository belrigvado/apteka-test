package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ItemsPage extends AbstractPage {
	private final By catalogBy = By.className("catalog_block");
	public ItemsPage(WebDriver driver) {
		super(driver);
	}

	public List<String> getItems() {
		WebElement catalogElement = driver.findElement(catalogBy);
		List<WebElement> itemElements = catalogElement.findElements(By.className("item-title"));
		List<String> result = new ArrayList<>();
		for(WebElement element : itemElements) {
			WebElement span = element.findElement(By.tagName("span"));
			result.add(span.getText());
		}
		return result;
	}
}
