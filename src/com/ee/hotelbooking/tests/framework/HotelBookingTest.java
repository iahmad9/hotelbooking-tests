package com.ee.hotelbooking.tests.framework;

import com.ee.hotelbooking.tests.pageobjects.HotelBookingPage;
import com.ee.hotelbooking.tests.utils.Constants;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * HotelBookingTest.java 
 * Purpose: Test Framework for the Hotel Booking Form.
 *
 * @author Iftikhar Ahmad
 * @version 1.0 12/07/2018
 *
 */

public class HotelBookingTest {

	private static WebDriver driver = null;
	
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get(Constants.TEST_URL);
	}


	/**
	 * Description: Helper method to make a booking using given 
	 * data inputs.
	 * 
	 * @param firstName
	 * @param lastName
	 * @param price
	 * @param deposit
	 * @param CheckinDate
	 * @param CheckoutDate
	 * 
	 */

	private void createBooking(String firstName, String lastName, String price, String deposit, String checkinDate, String checkoutDate ) {
		// Find and set element's values for a valid booking
		HotelBookingPage.get_elementFirstName(driver).sendKeys(firstName);
		HotelBookingPage.get_elementLastName(driver).sendKeys(lastName);
		HotelBookingPage.get_elementPrice(driver).sendKeys(price);
		HotelBookingPage.get_elementDeposit(driver).sendKeys(deposit);
		HotelBookingPage.get_elementCheckin(driver).sendKeys(checkinDate);
		HotelBookingPage.get_elementCheckout(driver).sendKeys(checkoutDate);
		HotelBookingPage.get_elementSave(driver).click();
	}

	/**
	 * Description: Helper method to remove existing booking 
	 * identified by given text.
	 * 
	 * @param textToFindBooking
	 * 
	 */
	
	private void removeBooking(String textToFindBooking) {
		
		if (textToFindBooking.isEmpty())
			return;
		
		// Remove the created booking and verify
		WebElement elmDelete = HotelBookingPage.get_elementDeleteByText(driver, textToFindBooking);
		if (elmDelete != null) {
			elmDelete.click();

			/*
			 * Wait for the entry to disappear as it takes some time for the delete action
			 * to take effect
			 */
			WebDriverWait wait = new WebDriverWait(driver, Constants.WAIT_TIMEOUT);
			try {
				wait.until(ExpectedConditions.invisibilityOf(elmDelete));
			} catch (TimeoutException toe) {
			}
		}
	}

	
	/**
	 * Test: To Verify removing a booking is successful after creation. 
	 * 
	 */

	@Test (invocationCount=1)
	public void testCreateAndRemoveBooking() {

		String firstNameAsUniqueText = Long.toString(System.currentTimeMillis());
		//Create booking with valid data set
		createBooking(firstNameAsUniqueText, Constants.LASTNAME, Constants.PRICE, Constants.DEPOSIT, Constants.CHECKIN_DATE, Constants.CHECKOUT_DATE); 	
		WebElement element = HotelBookingPage.get_elementFirstNameEntryByText(driver, firstNameAsUniqueText);
		assertNotNull(element, "Failed to create booking with valid data set");
		
		// Verify entry is indeed removed.
		removeBooking(firstNameAsUniqueText); //Remove booking
		element = HotelBookingPage.get_elementFirstNameEntryByText(driver, firstNameAsUniqueText);
		assertNull(element, "Failed to remove booking");
	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
