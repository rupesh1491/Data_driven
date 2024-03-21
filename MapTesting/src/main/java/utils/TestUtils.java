package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Locators.Loactors;

public class TestUtils {
	 public static WebElement findElement(WebDriver driver, String locatorKey) {
	        String[] parts = Loactors.get(locatorKey).split(",");
	        String locatorType = parts[0];
	        String locatorValue = parts[1];

	        switch (locatorType) {
	            case "xpath":
	                return driver.findElement(By.xpath(locatorValue));
	            case "id":
	                return driver.findElement(By.id(locatorValue));
	            case "name":
	                return driver.findElement(By.name(locatorValue));
	            case "class":
	                return driver.findElement(By.className(locatorValue));
	            default:
	                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
	        }
	    }

	    public static void clickElement(WebDriver driver, String locatorKey) {
	        WebElement element = findElement(driver, locatorKey);
	        element.click();
	    }
	}


