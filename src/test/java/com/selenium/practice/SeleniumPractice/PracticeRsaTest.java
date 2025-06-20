package com.selenium.practice.SeleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeRsaTest {

	private WebDriver driver;

	@BeforeMethod // This method will run before each @Test method
	public void SetUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String TitleName = driver.getTitle();
		System.out.println(TitleName);
	}

	@Test
	public void RadioButtonExample() throws Exception {
		WebElement RB = driver.findElement(By.xpath("//legend[normalize-space()='Radio Button Example']"));
		System.out.println(RB.getText());
		Thread.sleep(3000);
		WebElement rbc = driver.findElement(By.xpath("//input[@value='radio1']"));
		rbc.click();
		Thread.sleep(2000);
		System.out.println(rbc.isSelected());
	}

	@Test (enabled=true)
	public void AutoSuggestionExample() throws Exception {
		
		WebElement as = driver.findElement(By.xpath("//legend[normalize-space()='Suggession Class Example']"));
		System.out.println(as.getText());
		WebElement autoCompleteBox = driver.findElement(By.cssSelector("#autocomplete"));
		autoCompleteBox.sendKeys("america");
		autoCompleteBox.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		  Rectangle R = autoCompleteBox.getRect();
		  System.out.println(R);

	}

	@AfterMethod // This method will run after each @Test method
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			System.out.println("Browser closed."); // Added a confirmation message
		}
	}

}
