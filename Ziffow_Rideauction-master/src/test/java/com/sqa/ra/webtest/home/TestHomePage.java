package com.sqa.ra.webtest.home;

import org.testng.annotations.Test;

import com.sqa.ra.framework.BaseTest;
import com.sqa.ra.page.HomePage;
import com.sqa.ra.page.LoginPage;

public class TestHomePage extends BaseTest{
	
	@Test
	public void testHomeLoginLinkFromHomePage(){
		LoginPage loginPage=homePage.clickOnLoginLink();
		loginPage.clickonBackToRideAuctionLink();
		
	}
	@Test
	public void testHomeLoginLinkFromHomePage1(){
		LoginPage loginPage=homePage.clickOnLoginLink();
		loginPage.loginWithInValidUserId("rewrwe", "ewqrqrwe");
		//homePage.		//loginPage.clickonBackToRideAuctionLink();
		
	}

}
