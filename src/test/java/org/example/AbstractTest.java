package org.example;

import org.example.pages.HomePage;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.charset.StandardCharsets;
import java.util.List;

public abstract class AbstractTest {
	protected WebDriver driver;

	@BeforeEach
	public void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--start-fullscreen");
		driver = new ChromeDriver(options);

		driver.get("https://aptekaeconom.com/");
		// setting location cookie
		driver.manage().addCookie(new Cookie("current_region", "103006", ".aptekaeconom.com", "/", null));
		driver.get("https://aptekaeconom.com/");
	}

	@Test
	public void testNoCityWindow() {
		HomePage homePage = new HomePage(driver);
		Assertions.assertTrue(homePage.checkNoCityWindow());
	}

	protected void openItems() throws Exception {
		Thread.sleep(1000);
		WebElement element = driver.findElement(By.className("table-menu"));
		List<WebElement> links = element.findElements(By.tagName("a"));
		WebElement target = null;
		String targetSection = new String("Лечебное и диетическое питание".getBytes(), StandardCharsets.UTF_8);
		for(WebElement link : links) {
			List<WebElement> divElements = link.findElements(By.tagName("div"));
			WebElement divTitle = divElements.stream().filter(de -> de.getText().contains(targetSection)).findAny().orElse(null);
			if(divTitle != null) {
				target = link;
				break;
			}
		}
		Assertions.assertNotNull(target);
		target.click();
		Thread.sleep(1000);
		element = driver.findElement(By.className("section_block"));
		links = element.findElements(By.tagName("a"));
		String targetSubsection = new String("Препараты от кашля".getBytes(), StandardCharsets.UTF_8);
		target = null;
		for(WebElement link : links) {
			if(link.getText().equals(targetSubsection)) {
				target = link;
				break;
			}
		}
		Assertions.assertNotNull(target);
		target.click();
		Thread.sleep(1000);
	}

	@AfterEach
	public void destroy() {
		driver.close();
	}
}
