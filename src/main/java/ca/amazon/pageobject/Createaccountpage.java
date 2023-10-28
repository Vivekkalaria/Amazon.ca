package ca.amazon.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ca.amazon.actiondriver.Action;
import ca.amazon.base.Baseclass;

public class Createaccountpage extends Baseclass {
	
	@FindBy(id="ap_customer_name")
	WebElement yournamebox;
	@FindBy(id="ap_email")
	WebElement emailidbox;
	@FindBy(id="ap_password")
	WebElement passwordbox;
	@FindBy(id="ap_password_check")
	WebElement passwordagainbox ;
	@FindBy(xpath="//*[@id=\"continue\"]")
	WebElement verifyemailidbtn;
	
	public Createaccountpage() {
		PageFactory.initElements(getdriver(), this);
	}
	
	public void yourname(String fullname) {
		Action.type(yournamebox, fullname);
	}

	public void emailid(String emailid) {
		Action.type(emailidbox, emailid);
	}
	
	public void passwords(String password,String passwordagain) {
		Action.type(passwordbox, password);
		Action.type(passwordagainbox, passwordagain);
	}
	
	public Createaccountotppage clickverifyemail() {
		Action.click(getdriver(), verifyemailidbtn);
		return new Createaccountotppage();
	}
	
}
