package com.sqa.ra.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.sqa.ra.framework.BasePage;

public class LoginPage extends BasePage{
	
	@FindBy(id="Login")
	WebElement LOGIN_LINK;
	
	@FindBy(how=How.CSS,using="#login>h1>a")
	WebElement LOGIN_PAGE_IMG;
	
	@FindBy(id="user_login")
	//@FindBy(how=How.ID ,using ="user_login")
	WebElement USER_NAME_TXT_BOX;
	@FindBy(id="user_pass")
	WebElement PASSWORD_TXT_BOX;
	
	@FindBy(id="wp-submit")
	WebElement LOGIN_BTN;
	
	@FindBy(how=How.CSS,using="#backtoblog>a")
	WebElement BACKTO_RIDEAUCTION_LINK;
	
	@FindBy(how=How.LINK_TEXT,using="Register")
	WebElement REGISTER_LINK;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}

	@Override
	public void waitForPageToLoad() {
		// TODO Auto-generated method stub
		waitForElementToBeVisible(LOGIN_BTN);
	}

	@Override
	public void verifyPageElements() {
		// TODO Auto-generated method stub
		verifyElementVisible(LOGIN_BTN);
		verifyElementVisible(BACKTO_RIDEAUCTION_LINK);
		verifyElementVisible(PASSWORD_TXT_BOX);
		verifyElementVisible(USER_NAME_TXT_BOX);
		verifyElementVisible(LOGIN_PAGE_IMG);
		
		
	}
	
	public HomePage clickOnLoginBtn(){
		verifyAndClick(LOGIN_BTN);
		return new HomePage(driver);
	}
	
	
	public HomePage loginWithValidUserId(String userId, String password){
		type(USER_NAME_TXT_BOX, userId);
		type(PASSWORD_TXT_BOX,password);
		verifyAndClick(LOGIN_BTN);
		return new HomePage(driver);
	}
	
	public void  loginWithInValidUserId(String userId, String password){
		type(USER_NAME_TXT_BOX, userId);
		type(PASSWORD_TXT_BOX,password);
		verifyAndClick(LOGIN_BTN);
		//
		verifyPageElements();
		//return new HomePage(driver);
	}
	
	public HomePage clickonBackToRideAuctionLink(){
		//verifyAttribute(elmLocator, "href", PropertyManager.getProperty("appurl"));;
		verifyAndClick(BACKTO_RIDEAUCTION_LINK);
		return new HomePage(driver);
	}
//	public HomePage clickOnRegisterLink(){
//		//verifyAttribute(elmLocator, "href", PropertyManager.getProperty("appurl"));;
//		verifyAndClick(REGISTER_LINK);
//		
//		
//		//return new RegisPage(driver);
//	}

	

}
