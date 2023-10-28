package ca.amazon.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ca.amazon.actiondriver.Action;
import ca.amazon.base.Baseclass;

public class Loginandsecurityeditpasswordpage extends Baseclass {

	
	@FindBy(id="ap_password")
	WebElement oldpasswordbox;
	@FindBy(id="ap_password_new")
	WebElement newpasswordbox;
	@FindBy(id="ap_password_new_check")
	WebElement newpasswordagainbox;
	@FindBy(id="cnep_1D_submit_button")
	WebElement passwordcontinuebtn;
	
	public Loginandsecurityeditpasswordpage() {
		PageFactory.initElements(getdriver(), this);
	}
	public Loginandsecurity typepassword(String oldpassword, String newpassword, String newpasswordagain) {
		Action.type(oldpasswordbox, oldpassword);
		Action.type(newpasswordbox, newpassword);
		Action.type(newpasswordagainbox, newpasswordagain);
		Action.click(getdriver(), passwordcontinuebtn);
		return new Loginandsecurity();
		
	}
	
}
