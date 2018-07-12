package com.ee.hotelbooking.tests;

import com.ee.hotelbooking.tests.Constants;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * HotelBookingPage.java 
 * Purpose: Page Object Model for Hotel Booking Form page.
 *
 * @author Iftikhar Ahmad
 * @version 1.0 12/07/2018
 *
 */

public class HotelBookingPage {
	
	public static final String LOCATOR_ID_FIRSTNAME = "firstname";

	public static final String LOCATOR_ID_LASTNAME = "lastname";

	public static final String LOCATOR_ID_PRICE = "totalprice";

	public static final String LOCATOR_ID_DEPOSIT = "depositpaid";

	public static final String LOCATOR_ID_CHECKIN = "checkin";

	public static final String LOCATOR_ID_CHECKOUT = "checkout";
	
	public static final String LOCATOR_CSS_SELECTOR_SAVE = "#form > div:nth-child(1) > div:nth-child(7) > input:nth-child(1)"; 
	
	public static final String LOCATOR_XPATH_BOOKING_ENTRY = "//div/*[contains(text(), \"%s\")]";
	
	public static final String LOCATOR_XPATH_ENTRY_DELETE = LOCATOR_XPATH_BOOKING_ENTRY+"/parent::*/parent::*//input[@value=\"Delete\"]";
			
			
	public static WebElement get_elementFirstName(WebDriver driver) {
		return driver.findElement(By.id(LOCATOR_ID_FIRSTNAME));
	}

	public static WebElement get_elementLastName(WebDriver driver) {
		return driver.findElement(By.id(LOCATOR_ID_LASTNAME));
	}

	public static WebElement get_elementPrice(WebDriver driver) {
		return driver.findElement(By.id(LOCATOR_ID_PRICE));
	}

	public static WebElement get_elementDeposit(WebDriver driver) {
		return driver.findElement(By.id(LOCATOR_ID_DEPOSIT));
	}

	public static WebElement get_elementCheckin(WebDriver driver) {
		return driver.findElement(By.id(LOCATOR_ID_CHECKIN));
	}

	public static WebElement get_elementCheckout(WebDriver driver) {
		return driver.findElement(By.id(LOCATOR_ID_CHECKOUT));
	}

	public static WebElement get_elementSave(WebDriver driver) {
		return driver.findElement(By.cssSelector(LOCATOR_CSS_SELECTOR_SAVE));
	}

	/*
	 * TODO - Wondering if booking record can be made more testable, instead of
	 * relying on xpath which is slow and error prone. A Bug will be raised to make
	 * the code more testable
	 */
	
	public static WebElement get_elementFirstNameEntryByText(WebDriver driver, String text) {
		
		WebDriverWait wait = new WebDriverWait(driver, Constants.WAIT_TIMEOUT);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(LOCATOR_XPATH_BOOKING_ENTRY, text))));
		} catch (TimeoutException toe) {
			return null;
		}
		
		return driver.findElement(By.xpath(String.format(LOCATOR_XPATH_BOOKING_ENTRY, text)));
	}
	
	public static WebElement get_elementDeleteByText(WebDriver driver, String text) {
		
		WebDriverWait wait = new WebDriverWait(driver, Constants.WAIT_TIMEOUT);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(LOCATOR_XPATH_ENTRY_DELETE, text))));
		} catch (TimeoutException toe) {
			return null;
		}
		
		return driver.findElement(By.xpath(String.format(LOCATOR_XPATH_ENTRY_DELETE, text)));
	}
}
