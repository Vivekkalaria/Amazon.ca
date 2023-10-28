package ca.amazon.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ca.amazon.actiondriver.Action;
import ca.amazon.base.Baseclass;

public class Loginandsecurityeditmobilenumberotppage extends Baseclass{
	
	@FindBy(id="auth-pv-enter-code")
	WebElement mobilenumberotpbox;
	@FindBy(id="a-autoid-0")
	WebElement mobilenumberotpcontinuebtn;
	
	
	public Loginandsecurityeditmobilenumberotppage() {
		PageFactory.initElements(getdriver(),this);
	}
	
	public Loginandsecurity typemobilenumberotp(String mobilenumberotp) {
		Action.type(mobilenumberotpbox, mobilenumberotp);
		Action.click(getdriver(), mobilenumberotpcontinuebtn);
		return new Loginandsecurity();
	}
	
}
