package com.sqa.ra.page;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.AssertJUnit.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.sqa.ra.framework.BasePage;


public class DatePickerPage extends BasePage {
	static Logger logger = Logger.getLogger(DatePickerPage.class);
	static final String MM_dd_yyyy = "MM-dd-yyyy";

	Locale locale = Locale.ENGLISH;

	Calendar calStart = Calendar.getInstance();
	Calendar calEnd = Calendar.getInstance();
	
	@FindBy(how=How.CSS, using=".ui-datepicker-calendar span[title='Sunday']")
	WebElement SUN_DAY_HDR;

	@FindBy(how=How.CSS,using="#ui-datepicker-div a[title='Next']")
	WebElement DATE_PKR_NEXT_MONTH;
	
	@FindBy(how=How.CSS,using="#ui-datepicker-div a[title='Prev']")
	WebElement DATE_PKR_PREV_MONTH;
	

		/**
	 * Web Element of the Date Picker that has the calendar class name.
	 */
	@FindBy(id="date_picker")
	WebElement DATE_PICKER ;

	/**
	 * Web Element of the Date Picker that has the calendar class name.
	 */
	@FindBy(how=How.CLASS_NAME,using="ui-datepicker-calendar")
	WebElement DATE_PICKER_CAL;


	/**
	 * Web Element of the Date Picker that has the month as text.
	 */
	@FindBy(how=How.XPATH ,using="//span[@class='ui-datepicker-month']")
	WebElement DATE_PICKER_MONTH;

	/**
	 * Web Element of the Date Picker that has the year as text.
	 */
	@FindBy(how=How.XPATH ,using="//span[@class='ui-datepicker-year']")
	WebElement DATE_PICKER_YEAR;

	/**
	 * Left arrow for the Date Picker to go to the previous month.
	 */
	@FindBy(how=How.XPATH ,using="//span[@class='ui-icon ui-icon-circle-triangle-w")
	WebElement DATE_PICKER_PREV;

	/**
	 * Right arrow for the Date Picker to go to the next month.
	 */
	@FindBy(how=How.XPATH ,using="//span[@class='ui-icon ui-icon-circle-triangle-e']")
	WebElement DATE_PICKER_NEXT;

	/**
	 * First Thursday of the Month, [1]-Sun, [5]-Thurs.
	 */
	@FindBy(how=How.XPATH ,using="//td[5]/a")
	WebElement DATE_PICKER_FIST_THURS;



	public DatePickerPage(WebDriver driver) {
		super(driver);
	}

	public DatePickerPage(WebDriver driver, Locale locale) {
		super(driver);
		this.locale = locale;
	}

	@Override
	public void waitForPageToLoad() {
		waitForElementToBeVisible(DATE_PKR_PREV_MONTH);
	};

	@Override
	public void verifyPageElements() {
		// verify header on Calendar
		verifyElementVisible(SUN_DAY_HDR);
		verifyElementVisible(DATE_PKR_NEXT_MONTH);
		verifyElementVisible(DATE_PKR_PREV_MONTH);
	}

	/**
	 * Verify Date element exist and click it
	 * 
	 * @param date
	 *            - fixed format MM-dd-yyyy e.g. "12-31-2014"
	 */
	public void verifyAndClickDate(String dateStr) {
		verifyAndClickDate(dateStr, MM_dd_yyyy);
	}

	/**
	 * Verify Date element exist and click it
	 * 
	 * @param dateStr
	 *            - variable date format
	 * @param dateFormat
	 */
	public void verifyAndClickDate(String dateStr, String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, locale);
		Date date = null;
		try {
			date = sdf.parse(dateStr);

		} catch (ParseException e) {
			// Assert.assertNotNull(null, e.getLocalizedMessage());
			assertNotNull(date, "Bad Date string or format");
			logger.error("Error in parsing date", e);
		}

		selectDate(date);
	}

	/**
	 * Select day (+/-) relative to today
	 * 
	 * @param offsetFromToday
	 *            - 0 = Today, 1 = Tomorrow, ..
	 */
	public void verifyAndClickDate(int offsetFromToday) {
		assertTrue(offsetFromToday >= 0 && offsetFromToday <= 180);
		Date now = new Date();
		calEnd.setTime(now);
		calEnd.add(Calendar.DAY_OF_YEAR, offsetFromToday);
		Date desiredDate = calEnd.getTime();
		logger.debug(desiredDate);
		selectDate(desiredDate);
	}

	/**
	 * Adjust the calendar DatePicker Widget to the desired Day/Month/Year.
	 * Month/Year are both adjusted using a 0 or more PREV / NEXT Month
	 * button selects
	 * 
	 * @param desiredDate
	 *            - java date
	 * 
	 */
	private void selectDate(Date desiredDate) {

		calEnd.setTime(desiredDate);
		calStart.setTime(new Date());

		int prev_next_clicks = getMonthClicks(calStart, calEnd);

		while(prev_next_clicks != 0) {

			if (prev_next_clicks < 0) {
				verifyAndClick(DATE_PKR_PREV_MONTH);
				prev_next_clicks++;
			}
			if (prev_next_clicks > 0) {
				verifyAndClick(DATE_PKR_NEXT_MONTH);
				prev_next_clicks--;
			}
			waitForPageToLoad();
		}
		
		// (2) Verify Correct Year/Month
		assertEquals(calEnd.get(Calendar.YEAR), Integer.parseInt(DATE_PICKER_YEAR.getText()),
				"Unable to find correct Year");
		
		String month = new SimpleDateFormat("MMMM", locale).format(calEnd.getTime());
		assertEquals(month, DATE_PICKER_MONTH.getText(),"Unable to find correct Month");

		// (3) Select the Day
		By dateBy = By.linkText(String.valueOf(calEnd.get(Calendar.DATE)));
		verifyElementVisible(getElement(dateBy));
		verifyAndClick(getElement(dateBy));

	} // endof selectDate

	private int getMonthClicks(Calendar startCal, Calendar endCal) {
		int next_prev_clicks = 0;
		int diffYear = endCal.get(Calendar.YEAR) - startCal.get(Calendar.YEAR);
		next_prev_clicks = diffYear * 12 + endCal.get(Calendar.MONTH)
				- startCal.get(Calendar.MONTH);
		return next_prev_clicks;
	}

}
