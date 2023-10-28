package ca.amazon.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ca.amazon.actiondriver.Action;
import ca.amazon.base.Baseclass;

public class Loginandsecurityeditnamepage extends Baseclass{
	@FindBy(id="ap_customer_name")
	WebElement newname;
	@FindBy(id="cnep_1C_submit_button")
	WebElement savenamebtn;
	
	public Loginandsecurityeditnamepage() {
		PageFactory.initElements(getdriver(), this);
	}

	public Loginandsecurity typenewname(String name) {
		Action.type(newname, name);
		Action.click(getdriver(), savenamebtn);
		return new Loginandsecurity();
	}
}
