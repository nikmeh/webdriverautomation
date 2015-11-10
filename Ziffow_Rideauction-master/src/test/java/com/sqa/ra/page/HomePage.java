package com.sqa.ra.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.sqa.ra.framework.BasePage;
import com.sqa.ra.page.bid.BidOnRideAirportPage;

public class HomePage extends BasePage {
	
	@FindBy(how=How.CSS,using="img[title=RideAuction]")
	WebElement homePgaeLogoImg;
  
	
	//Bid On Ride buttons for each module
	@FindBy(id="toairport")
	WebElement TO_AIRPORT_RADIO_BTN ;
	@FindBy(id="fromairport")
	WebElement FROM_AIRPORT_RADIO_BTN;
	
	@FindBy(how=How.CSS,using="#airport input[type='submit']")
	WebElement BID_ON_RIDE_AIRPORT_BTN ;
	
	@FindBy(how=How.CSS,using="#hourly input[type='submit']")
	WebElement BID_ON_RIDE_HOURLY_BTN ;
	
	@FindBy(id="hourlydriver")
	WebElement INTHECITY_RADIO_BTN ;
	
	@FindBy(id="hourlycircle")
	WebElement OUTSIDE_RADIO_BTN ;
	
	
	@FindBy(how=How.CSS,using="#transfers input[type='submit']")
	WebElement BID_ON_RIDE_POINT_TO_POINT_BTN ;
	
	@FindBy(how=How.CSS,using="#exotic input[type='submit']")
	WebElement BID_ON_RIDE_BSEC_BTN ;
	
	

	
	@FindBy(how=How.LINK_TEXT,using="How it works")
	WebElement HOW_IT_WORKS_LNK ;
	//Bottom links
	@FindBy(how=How.LINK_TEXT,using="Become our Partner")
	WebElement BECOME_OUR_PARTNER_LNK ;
	
	@FindBy(how=How.LINK_TEXT,using="FAQ")
	WebElement FAQ_LNK ;
	
	@FindBy(how=How.LINK_TEXT,using="About Us")
	WebElement ABOUT_US_LNK ;
	
	@FindBy(how=How.LINK_TEXT,using="Corporate")
	WebElement CORPORATE_LNK ;
	
	@FindBy(how=How.LINK_TEXT,using="Contact Us")
	WebElement CONTACT_US_LNK ;
	@FindBy(how=How.LINK_TEXT,using="Login")
	WebElement LOGIN_LNK ;
	@FindBy(how=How.LINK_TEXT,using="Registration")
	WebElement REGISTRATION_LNK ;
	@FindBy(how=How.LINK_TEXT,using="My Account")
	WebElement myAccountLink ;
	
	
	
	
	

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void waitForPageToLoad() {
		// TODO Auto-generated method stub
		waitForElementToBeVisible(LOGIN_LNK);
	}

	@Override
	public void verifyPageElements() {
		// TODO Auto-generated method stub
		
		verifyElementVisible(HOW_IT_WORKS_LNK);
		verifyElementVisible(FAQ_LNK);
		verifyElementVisible(ABOUT_US_LNK);
		verifyElementVisible(CORPORATE_LNK);
		verifyElementVisible(BECOME_OUR_PARTNER_LNK);
		verifyElementVisible(CONTACT_US_LNK);
		verifyElementVisible(LOGIN_LNK);
		
	}
	
	
	public LoginPage clickOnLoginLink(){
		verifyAndClick(LOGIN_LNK);
		return new LoginPage(driver);
		
	}
	public ContactUsPage clickOnContactLink(){
		verifyAndClick(CONTACT_US_LNK);
		return new ContactUsPage(driver);
		
	}
	public BidOnRideAirportPage clickOnBidOnRideAirport(){
		verifyAndClick(BID_ON_RIDE_AIRPORT_BTN);
		return new BidOnRideAirportPage(driver);
		
	}
		
		
	

}
