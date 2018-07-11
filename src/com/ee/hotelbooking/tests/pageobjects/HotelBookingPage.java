package com.ee.hotelbooking.tests.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ee.hotelbooking.tests.utils.Constants;

/**
 * HotelBookingPage.java 
 * Purpose: Page Object Model for Hotel Booking Form page.
 *
 * @author Iftikhar Ahmad
 * @version 1.0 12/07/2018
 *
 */

public class HotelBookingPage {

	public static WebElement get_elementFirstName(WebDriver driver) {
		return driver.findElement(By.id("firstname"));
	}

	public static WebElement get_elementLastName(WebDriver driver) {
		return driver.findElement(By.id("lastname"));
	}

	public static WebElement get_elementPrice(WebDriver driver) {
		return driver.findElement(By.id("totalprice"));
	}

	public static WebElement get_elementDeposit(WebDriver driver) {
		return driver.findElement(By.id("depositpaid"));
	}

	public static WebElement get_elementCheckin(WebDriver driver) {
		return driver.findElement(By.id("checkin"));
	}

	public static WebElement get_elementCheckout(WebDriver driver) {
		return driver.findElement(By.id("checkout"));
	}

	public static WebElement get_elementSave(WebDriver driver) {
		return driver.findElement(By.cssSelector("#form > div:nth-child(1) > div:nth-child(7) > input:nth-child(1)"));
	}

	/*
	 * TODO - Wondering if booking record can be made more testable, instead of
	 * relying on xpath which is slow and error prone. A Bug will be raised to make
	 * the code more testable
	 */
	
	public static WebElement get_elementFirstNameEntryByText(WebDriver driver, String text) {
		
		WebDriverWait wait = new WebDriverWait(driver, Constants.WAIT_TIMEOUT);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/*[contains(text(), \"" + text + "\")]")));
		} catch (TimeoutException toe) {
			return null;
		}
		
		return driver.findElement(By.xpath("//div/*[contains(text(), \"" + text + "\")]"));
	}
	
	public static WebElement get_elementDeleteByText(WebDriver driver, String text) {
		
		WebDriverWait wait = new WebDriverWait(driver, Constants.WAIT_TIMEOUT);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/*[contains(text(), \"" + text + "\")]/parent::*/parent::*//input[@value=\"Delete\"]")));
		} catch (TimeoutException toe) {
			return null;
		}
		
		return driver.findElement(By.xpath("//div/*[contains(text(), \"" + text + "\")]/parent::*/parent::*//input[@value=\"Delete\"]"));
	}
}
