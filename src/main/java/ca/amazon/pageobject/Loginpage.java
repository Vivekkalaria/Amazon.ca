package ca.amazon.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ca.amazon.actiondriver.Action;
import ca.amazon.base.Baseclass;

public class Loginpage extends Baseclass{

	
	@FindBy(xpath="//*[@id=\"ap_email\"]")
	WebElement emailbox;
	@FindBy(xpath="//*[@id=\"continue\"]")
	WebElement continuebtn;
	@FindBy(xpath="//*[@id=\"createAccountSubmit\"]")
	WebElement createaccountbtn;
	@FindBy(xpath="//div[contains(text(),'Enter your e-mail address or mobile phone number')]")
	WebElement emptyemailerror;
	
	public Loginpage(){
		PageFactory.initElements(getdriver(), this);
	}
	
	public void typeemail(String emailid) {
		Action.type(emailbox, emailid);
	}
	
	
	public Loginpasswordpage signin1() {
		Action.click(getdriver(), continuebtn);
		return new Loginpasswordpage();
	}
	
	public Createaccountpage createaccount() {
		Action.click(getdriver(), createaccountbtn);
		return new Createaccountpage();
	}
	
	public boolean emptyerrormessage() {
		Action.click(getdriver(), continuebtn);
		return Action.isDisplayed(getdriver(), emptyemailerror);
	}
	
	public String getcurrentutl() {
		String loginpageurl=getdriver().getCurrentUrl();
		return loginpageurl;
	}
}
