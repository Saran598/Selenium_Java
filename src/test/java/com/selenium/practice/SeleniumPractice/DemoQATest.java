package com.selenium.practice.SeleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
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
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		String TitleName = driver.getTitle();
		System.out.println(TitleName);
	}

	@Test
	public void InputForm() throws Exception {

		WebElement nameBox = driver.findElement(By.xpath("//div[@class='form-group']//input[@name='name']"));
		nameBox.sendKeys("Krishnaveni");
		WebElement emailBox = driver.findElement(By.xpath("//input[@name='email']"));
		emailBox.sendKeys("krishnaveni@gmail.com");
		WebElement passwordBox = driver.findElement(By.xpath("//input[@id='exampleInputPassword1']"));
		passwordBox.sendKeys("krishna@345"); 
		Thread.sleep(2000);
		Select sl = new Select(driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']")));
		Thread.sleep(2000);
		sl.selectByValue("Female");
		System.out.println("Selected" +sl+ "from the Gender dropdown"); 
		

	}

	@AfterMethod // This method will run after each @Test method
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			System.out.println("Browser closed."); // Added a confirmation message
		}
	}
}
