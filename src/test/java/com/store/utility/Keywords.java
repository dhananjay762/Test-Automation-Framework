package com.store.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Keywords implements ICommonConstants{
	
	public static WebDriver driver;
	
	public void setup(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
		}
	}
	
	public void navigateToURL(String url) {
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}
	
	public void EnterText(By locator, String textToEnter) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = driver.findElement(locator);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(textToEnter);
	}
	
	public void ClickOb(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = driver.findElement(locator);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	public void SelectByVisibleText(By locator, String valueToSelect) {
		WebElement element = driver.findElement(locator);
		Select select = new Select(element);
		select.selectByVisibleText(valueToSelect);
	}
	
	public void verifyText(By locator, String textToVerify) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = driver.findElement(locator);
		wait.until(ExpectedConditions.visibilityOf(element));
		Assert.assertEquals(textToVerify, element.getText());
	}
	
	public void HoverOverElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = driver.findElement(locator);
		wait.until(ExpectedConditions.visibilityOf(element));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	public void SelectCheckbox(By locator) {
		WebElement element = driver.findElement(locator);
		if(!element.isSelected()) {
			element.click();
		}
	}
	
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}

}
