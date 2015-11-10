package com.sqa.ra.page.bid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.sqa.ra.framework.BasePage;

public class PriceCheckPage extends BasePage {

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Average Price')]")
	WebElement AVERAGE_PRICE;
	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Confirmed Ride')]")
	WebElement CONFIRM_PRICE;

	@FindBy(id = "garantserv")
	WebElement BUY_BTN;

	@FindBy(id = "termscheck")
	WebElement TERMS_CHK_BOX;

	@FindBy(id = "bidsubmit")
	WebElement BID_BTN;
	@FindBy(id = "bidprice")
	WebElement BID_PRICE_TEXT_BOX;

	public PriceCheckPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void waitForPageToLoad() {
		// TODO Auto-generated method stub
		waitForElementToBeVisible(BUY_BTN);

	}

	@Override
	public void verifyPageElements() {
		// TODO Auto-generated method stub
		verifyElementVisible(AVERAGE_PRICE);
		verifyElementVisible(BID_BTN);
		verifyElementVisible(BID_PRICE_TEXT_BOX);
		verifyElementVisible(CONFIRM_PRICE);
	}

	public void verifyPrice(String averagePrice, String confirmPrice) {

		verifyElementContainText(AVERAGE_PRICE, averagePrice);
		verifyElementContainText(CONFIRM_PRICE, confirmPrice);

	}

	public void clickBuyButtonWithoutAcceptingTermsCheckBox() {
		WaitForElementToBeClickable(BUY_BTN);
		// add the verification of elements after price check
		verifyAndClick(BUY_BTN);
		// very the terms and condition message
		//
		verifyPageElements();
	}

	public PassengerInfoPage clickBuyButtonWithAcceptingTermsCheckBox() {
		//WaitForElementToBeClickable(BUY_BTN);
		// add the verification of elements after price check
		verifyAndClick(TERMS_CHK_BOX);
		verifyAndClick(BUY_BTN);
		// very the terms and condition message
		return new PassengerInfoPage(driver);
	}

	public void clickBidButtonWithoutAcceptingTermsCheckBox() {
		WaitForElementToBeClickable(BID_BTN);
		// add the verification of elements after price check
		verifyAndClick(BID_BTN);
		// very the terms and condition message
		//
		verifyPageElements();
	}

	public PassengerInfoPage clickBidButtonWithAcceptingTermsCheckBox(
			String minAmt) {
		//WaitForElementToBeClickable(BID_BTN);
		// add the verification of elements after price check
		verifyAndClick(TERMS_CHK_BOX);
		type(BID_PRICE_TEXT_BOX, minAmt);
		verifyAndClick(BID_BTN);
		// very the terms and condition message
		return new PassengerInfoPage(driver);
	}

}
