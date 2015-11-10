package com.sqa.ra.page.bid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.sqa.ra.framework.BasePage;
import com.sqa.ra.page.DatePickerPage;

public class BidOnRideAirportPage  extends BasePage{
	
	@FindBy(how=How.CSS,using="#airport input[type=submit]")
	WebElement BID_ON_RIDE_BTN;
	@FindBy(id="passengers")
	WebElement PSNGR_DROP_DOWN;
	@FindBy(id="datepicker")
	WebElement DATE_PICKER;
	@FindBy(id="hour")
	WebElement HOUR;
	@FindBy(id="minute")
	WebElement MINUTE;
	
	@FindBy(id="pricecheck")
	WebElement PRICE_CHK_BTN;
	
	@FindBy(id="ToAirport")
	WebElement TO_AIRPORT_DROP_DOWN;
	
	@FindBy(name="OriginationAddress")
	WebElement ORIGIN_ADDRS;
	
	@FindBy(id="Car")
	WebElement CAR_DROP_DOWN;
	
	@FindBy(name="PromoCode")
	WebElement PROMOCODE_TEXT_BOX;
	



	
	public BidOnRideAirportPage(WebDriver driver){
		super(driver);
	}

	@Override
	public void waitForPageToLoad() {
		// TODO Auto-generated method stub
		waitForElementToBeVisible(PRICE_CHK_BTN);
		
	}

	@Override
	public void verifyPageElements() {
		// TODO Auto-generated method stub
		
		verifyElementVisible(PSNGR_DROP_DOWN);
		verifyElementVisible(DATE_PICKER);
		verifyElementVisible(HOUR);
		verifyElementVisible(MINUTE);
		
		verifyElementVisible(TO_AIRPORT_DROP_DOWN);
		verifyElementVisible(ORIGIN_ADDRS);
		verifyElementVisible(CAR_DROP_DOWN);
		verifyElementVisible(PROMOCODE_TEXT_BOX);
		
	}
	
	
	public DatePickerPage selectDatePicker(){
		verifyAndClick(DATE_PICKER);
		DatePickerPage dp=new DatePickerPage(driver);
       return dp;
	}
	
	public PriceCheckPage doPriceCheckAfterFillingRequiredFields(String noPsngr,String pickUpDate,String hour,
			String airport,String originAddress){
		selectDropDownByVisibleText(PSNGR_DROP_DOWN, noPsngr);
		//select a date using the date Picker Page

		DatePickerPage dp = selectDatePicker();
		dp.verifyAndClickDate(pickUpDate);
		
		selectDropDownByVisibleText(HOUR, hour);
		selectDropDownByVisibleText(TO_AIRPORT_DROP_DOWN, airport);
		type(ORIGIN_ADDRS, originAddress);
		verifyAndClick(PRICE_CHK_BTN);
		return new PriceCheckPage(driver);
		
		
		
	}
	
	
	
}
