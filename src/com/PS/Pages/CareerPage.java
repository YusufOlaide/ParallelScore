package com.PS.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CareerPage {
	WebDriver driver;
	
	By titleText = By.xpath("//title[contains(text(),'Careers – ParallelScore')]");
	By category = By.xpath("//select[@id='category']");
	By fulltime = By.xpath("//option[contains(text(),'Full Time')]");
	By categoryPlaceholder = By.xpath("//option[contains(text(),'Category')]");
	By location = By.xpath("//select[@id='location']");
	By lagos = By.xpath("//option[contains(text(),'Lagos')]");
	By locationPlaceholder = By.xpath("//option[contains(text(),'Location')]");
	By btn = By.xpath("//body/div[@id='ajax-content-wrap']/div[1]/div[1]/div[1]"
			+ "/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[5]/input[1]");
	
	

	
	public CareerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String careerPageTitle() {
		return driver.findElement(titleText).getText();
		
	}
	
	public void clickOnCategory() {
		driver.findElement(category).isDisplayed();
		driver.findElement(category).click();
	}
	
	public void selectFullTimeOption() {
		driver.findElement(fulltime).isDisplayed();
		driver.findElement(fulltime).click();
	}
	public void clickOnLocation() {
		driver.findElement(location).isDisplayed();
		driver.findElement(location).click();;
	}
	
	public void selectLagosOption() {
		driver.findElement(lagos).isDisplayed();
		driver.findElement(lagos).click();;
	}
	public void clickOnSearchBtn() {
		driver.findElement(btn).isDisplayed();
		driver.findElement(btn).click();
	}
	
	public String verifyCategoryPlaceholder() {
		return driver.findElement(categoryPlaceholder).getText();
	}
	public String verifyLocationPlaceholder() {
		return driver.findElement(locationPlaceholder).getText();
	}
	

}
