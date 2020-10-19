package com.PS.Tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.PS.Pages.CareerPage;
import com.PS.Pages.HomePage;
import com.PS.Pages.SearchResultsPage;


public class SearchTest {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void Initialization() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
	}
	
	@BeforeMethod
	public void Launcher() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void ValidateSearch() {
		driver.navigate().to("https://parallelscore.com");
		
		HomePage home = new HomePage(driver);

		home.cancelPopUp();
		home.clickOnCareerLink();
		
		wait = new WebDriverWait(driver,3000);
		
		CareerPage career = new CareerPage(driver);
		
		String careerPageTitle = career.careerPageTitle();
		Assert.assertEquals(careerPageTitle.contains(careerPageTitle), true);
	
		
		career.clickOnCategory();
		career.selectFullTimeOption();
		career.clickOnLocation();
		career.selectLagosOption();
		career.clickOnSearchBtn();
		
		String categoryPlaceholder = career.verifyCategoryPlaceholder();
		Assert.assertEquals(categoryPlaceholder.contains(categoryPlaceholder), true);
		
		String locationPlaceholder = career.verifyLocationPlaceholder();
		Assert.assertEquals(locationPlaceholder.contains(locationPlaceholder), true);
		
		wait = new WebDriverWait(driver, 3000);
		
		SearchResultsPage searchResults = new SearchResultsPage(driver);
		
		
		boolean location_filter = searchResults.verifyLocationFilter();
		if(location_filter ==true) {
			System.out.println("Jobs found");
		}
		
		
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				
					if(driver.getCurrentUrl().contains("https://parallelscore.com/careers/"
							+ "?search_keywords=&selected_category=full-time&selected_jobtype=-1&selected_location=lagos")) {
						return true;
					}
					else {
						return false;
					}			
			}
		});
	}
				

	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}

}
