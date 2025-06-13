package com.selenium.practice.SeleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoQATest {

	private WebDriver driver;

	@BeforeMethod
	public void SetUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		String TitleName = driver.getTitle();
		System.out.println(TitleName);
	}

	@Test
	public void Gsearch() {

		WebElement SearchBox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
		SearchBox.sendKeys("jira");
		SearchBox.sendKeys(Keys.ENTER);
		System.out.println("Performed Google search for 'jira'."); // Added a confirmation message

	}

	@AfterMethod // This method will run after each @Test method
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			System.out.println("Browser closed."); // Added a confirmation message
		}
	}
}
