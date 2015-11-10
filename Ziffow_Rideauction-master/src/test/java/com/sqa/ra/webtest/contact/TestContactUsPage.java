package com.sqa.ra.webtest.contact;

import org.testng.annotations.Test;

import com.sqa.ra.framework.BaseTest;
import com.sqa.ra.page.ContactUsPage;

public class TestContactUsPage extends BaseTest {

	@Test
	public void testSendContactInfo() {
		ContactUsPage contactPage = homePage.clickOnContactLink();
		contactPage.typeContactUsInfo("dgsd", "sdfgd@gmail.com", "dgsdg",
				"dvsfdg");
		contactPage.clickOnSendBtn();
		contactPage.waitForSuccessMsg();
		contactPage.verifySucessMsg();

	}

	@Test
	public void testErrorMsgDisplayed() {
		ContactUsPage contactPage = homePage.clickOnContactLink();
		contactPage.clickOnSendBtn();
		contactPage.waitForErrMsg();
		contactPage.verifyNameErrorMsg();

	}

}
