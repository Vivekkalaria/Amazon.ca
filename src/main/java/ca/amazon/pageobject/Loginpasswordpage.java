package ca.amazon.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ca.amazon.actiondriver.Action;
import ca.amazon.base.Baseclass;

public class Loginpasswordpage extends Baseclass {
	
	@FindBy(xpath="//*[@id=\"ap_password\"]")
	WebElement passwordbtn;
	@FindBy(xpath="//*[@id=\"signInSubmit\"]")
	WebElement signinbtn;
	@FindBy(name="rememberMe")
	WebElement remembermecheckbox;
	
	public Loginpasswordpage() {
		PageFactory.initElements(getdriver(), this);
	}
	
	public Homepage signin(String password) {
		Action.type(passwordbtn, password);
		Action.click(getdriver(), remembermecheckbox);
		Action.click(getdriver(), signinbtn);
		return new Homepage();
	}
	
	public Addtocartcheckoutpage signinaddtocart(String password) {
		Action.type(passwordbtn, password);
		Action.click(getdriver(), remembermecheckbox);
		Action.click(getdriver(), signinbtn);
		return new Addtocartcheckoutpage();
	}

}
