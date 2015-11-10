package com.sqa.ra.webtest.bid;

import org.testng.annotations.Test;

import com.sqa.ra.framework.BaseTest;
import com.sqa.ra.page.bid.BidOnRideAirportPage;
import com.sqa.ra.page.bid.PassengerInfoPage;
import com.sqa.ra.page.bid.PriceCheckPage;

public class TestBidOnRideAirport extends BaseTest {
	
	@Test
	public void testBidOnRideToAirport(){
		BidOnRideAirportPage bidPage=homePage.clickOnBidOnRideAirport();
		PriceCheckPage pcPage=bidPage.doPriceCheckAfterFillingRequiredFields("3", "08-15-2014", "3 AM", "SFO-San Francisco International", "12 Geary Street, San Francisco, CA, United States");
		pcPage.verifyPrice("58.00", "$67.00");
	}
	@Test
	public void testBidOnRideToAirportBuy(){
		BidOnRideAirportPage bidPage=homePage.clickOnBidOnRideAirport();
		PriceCheckPage pcPage=bidPage.doPriceCheckAfterFillingRequiredFields("3", "08-15-2014", "3 AM", "SFO-San Francisco International", "12 Geary Street, San Francisco, CA, United States");
		pcPage.verifyPrice("58.00", "$67.00");
		PassengerInfoPage pinfoPage=pcPage.clickBuyButtonWithAcceptingTermsCheckBox();
		pinfoPage.eneterPassengerInfo();
	}
	
	@Test
	public void testBidOnRideToAirportBid(){
		BidOnRideAirportPage bidPage=homePage.clickOnBidOnRideAirport();
		PriceCheckPage pcPage=bidPage.doPriceCheckAfterFillingRequiredFields("3", "08-15-2014", "3 AM", "SFO-San Francisco International", "12 Geary Street, San Francisco, CA, United States");
		pcPage.verifyPrice("58.00", "$67.00");
		PassengerInfoPage pinfoPage=pcPage.clickBidButtonWithAcceptingTermsCheckBox("2000");
		pinfoPage.eneterPassengerInfo();
	}


}
