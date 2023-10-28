package ca.amazon.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ca.amazon.actiondriver.Action;
import ca.amazon.base.Baseclass;

public class Loginotppage extends Baseclass {

	@FindBy(id="cvf-input-code")
	WebElement otpbox;
	
	@FindBy(xpath="//*[@id=\"cvf-submit-otp-button\"]/span/input")
	WebElement createaccountbtn;
	
	@FindBy(id="cvf-resend-link")
	WebElement resendbtn;
	
	public Loginotppage(){
		PageFactory.initElements(getdriver(), this);
	}
	
	public Homepage createaccountfinal(String otp) {
		Action.type(otpbox, otp);
		Action.click(getdriver(), createaccountbtn);
		return new Homepage();
	}
	public void resendotp() {
		Action.click(getdriver(), resendbtn);
	}
}
