package com.sqa.ra.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.sqa.ra.framework.BasePage;

public class ContactUsPage extends BasePage {
	
	@FindBy(how=How.ID_OR_NAME,using="your-name")
	WebElement yourName;
	@FindBy(how=How.ID_OR_NAME,using="your-email")
	WebElement yourEmail;
	@FindBy(how=How.ID_OR_NAME,using="your-subject")
	WebElement yourSubj;
	@FindBy(how=How.ID_OR_NAME,using="your-message")
	WebElement yourMessage;
	@FindBy(how=How.CSS,using="input[value=Send]")
	WebElement sendBtn;
	@FindBy(how=How.XPATH ,using="//div[text()='Your message was sent successfully. Thanks.']")
	WebElement successMsg;
	@FindBy(how=How.XPATH ,using="//div[text()='Validation errors occurred. Please confirm the fields and submit it again.']")
	WebElement validationErrorMsg;
	
	@FindBy(how=How.XPATH ,using="//input[@id='your-name']/../span")
	WebElement errorMsgOnName;
	
	

	public ContactUsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void waitForPageToLoad() {
		// TODO Auto-generated method stub
		waitForElementToBeVisible(sendBtn);
		System.out.println("WaitForPageTolaod");

	}

	@Override
	public void verifyPageElements() {
		// TODO Auto-generated method stub
		verifyElementVisible(sendBtn);
		verifyElementVisible(yourEmail);
		verifyElementVisible(yourName);
		verifyElementVisible(yourSubj);
	}

	public void typeContactUsInfo(String name, String email, String sub, String msg){
		type(yourEmail,email);
		type(yourName,name);
		type(yourSubj,sub);
		type(yourMessage,msg);
		
	}
	
	public void clickOnSendBtn(){
		verifyAndClick(sendBtn);
		verifyPageElements();
	}
	
	public void verifySucessMsg(){
		verifyElementVisible(successMsg);
		
	}
	public void verifyValidationMsg(){
		verifyElementVisible(validationErrorMsg);
		
	}
	
	public void waitForErrMsg(){
		waitForElementToBeVisible(errorMsgOnName);
		
	}
	public void waitForSuccessMsg(){
		waitForElementToBeVisible(successMsg);
		
	}
	public void verifyNameErrorMsg(){
		verifyElementVisible(errorMsgOnName);
		
	}

}
