package com.PS.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	WebDriver driver;
	
	By popUp = By.className("mc-closeModal");
	By careerLink = By.xpath("//header/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[2]/a[1]");
	

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void cancelPopUp() {
		driver.findElement(popUp).isDisplayed();
		driver.findElement(popUp).click();
	}
	
	public void clickOnCareerLink() {
		driver.findElement(careerLink).isDisplayed();
		driver.findElement(careerLink).click();
	}
	
	
}
