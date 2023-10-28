package ca.amazon.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ca.amazon.actiondriver.Action;
import ca.amazon.base.Baseclass;

public class Createaccountotppage extends Baseclass {
	
	@FindBy(xpath="//input[@aria-labelledby='cvf-submit-otp-button-announce']")
	WebElement createaccountbtn;

	
	@FindBy(xpath="//a[@id='cvf-resend-link']")
	WebElement resendotpbtn;
	
	public Createaccountotppage() {
		PageFactory.initElements(getdriver(), this);
	}
	
	public Homepage createaccountfinal() {
		Action.click(getdriver(), createaccountbtn);
		return new Homepage();
	}
}

	
