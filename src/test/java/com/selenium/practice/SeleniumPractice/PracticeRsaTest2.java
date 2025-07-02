package com.selenium.practice.SeleniumPractice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class PracticeRsaTest2 extends PracticeRsaTest {

	@Test
	public void MouseOverExample() throws InterruptedException {
		Actions acts = new Actions(driver);
		acts.moveToElement(driver.findElement(By.id("mousehover"))).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[normalize-space()='Reload']")).click();
		System.out.println("Clicked on Submenu button");
	}
	
	@Test
	public void PromptAlert() throws InterruptedException {
		WebElement alertheading = driver.findElement(By.xpath("//legend[normalize-space()='Switch To Alert Example']"));
		System.out.println(alertheading.getText());
		WebElement alertname = driver.findElement(By.xpath("//input[@id='name']"));
		alertname.sendKeys("Saran");
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(4000);
		Alert alrt = driver.switchTo().alert();
		System.out.println(alrt.getText());
		alrt.accept();
		
	}
	
	@Test
	public void ConfirmationAlert() {
		
	}
}
