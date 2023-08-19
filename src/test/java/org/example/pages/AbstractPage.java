package org.example.pages;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AbstractPage {
	protected WebDriver driver;
	private By cityWindowBy = By.className("confirm_region");
	private By delayedBy = By.className("delay");

	private By searchBy = By.tagName("form");


	public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean checkNoCityWindow() {
		return driver.findElements(cityWindowBy).isEmpty();
	}

	public int getDelayedCount() {
		List<WebElement> delayElements = driver.findElements(delayedBy);
		WebElement target = null;
		for(WebElement delayElement : delayElements) {
			if(delayElement.getTagName().equals("a")) {
				for(WebElement webElement : delayElement.findElements(By.className("count"))) {
					if(webElement.getTagName().equals("span")) {
						target = webElement;
						break;
					}
				}
			}
			if(target != null) {
				break;
			}
		}
		Assertions.assertNotNull(target);
		return Integer.parseInt(target.getText());
	}

	public void makeSearch(String query) {
		WebElement searchForm = driver.findElement(searchBy);
		WebElement inputElement = searchForm.findElement(By.tagName("input"));
		inputElement.sendKeys(query);
		WebElement button = searchForm.findElement(By.tagName("button"));
		button.click();
	}
}
