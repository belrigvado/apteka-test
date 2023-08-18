package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
	protected WebDriver driver;
	private By cityWindowBy = By.className("confirm_region");

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean checkNoCityWindow() {
		return driver.findElements(cityWindowBy).isEmpty();
	}
}
