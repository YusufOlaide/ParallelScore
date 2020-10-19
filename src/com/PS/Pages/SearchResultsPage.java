package com.PS.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage {

	WebDriver driver;
	
	By locationFilter = By.xpath("//header/div[1]/div[2]/div[1]/div[3]/div[1]");
	
	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
	}
	

	public boolean verifyLocationFilter() {
		return driver.findElement(locationFilter).isDisplayed();
	}
	
}
