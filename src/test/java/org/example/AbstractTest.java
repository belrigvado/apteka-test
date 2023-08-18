package org.example;

import org.example.pages.HomePage;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class AbstractTest {
	protected WebDriver driver;

	@BeforeEach
	public void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
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

	@AfterEach
	public void destroy() {
		driver.close();
	}
}
