package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ItemsPage extends AbstractPage {
	private final By catalogBy = By.className("catalog_block");
	private final By catalogItemBy = By.className("catalog_item");
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



	public void addFirstToDelay() {
		WebElement catalogItemElement = driver.findElement(catalogItemBy);
		new Actions(driver).moveToElement(catalogItemElement).perform();
		List<WebElement> spanElements = catalogItemElement.findElements(By.tagName("span"));
		String targetText = String.copyValueOf("Отложить".toCharArray());
		for(WebElement spanElement : spanElements) {
			System.out.println(spanElement.getAttribute("title"));
			if(targetText.equals(spanElement.getAttribute("title").trim())) {
				new Actions(driver).click(spanElement).perform();
				break;
			}
		}
	}
}
