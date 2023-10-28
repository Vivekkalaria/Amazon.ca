package ca.amazon.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ca.amazon.actiondriver.Action;
import ca.amazon.base.Baseclass;

public class Loginandsecurityeditemailpage extends Baseclass {
	
	@FindBy(xpath="//*[@id=\"cvf-page-content\"]/div/div/div/form/div[1]/div/div[2]/div/input")
	WebElement newemailbox;
	@FindBy(xpath="//*[@id=\"a-autoid-0\"]")
	WebElement continueotpbtn;
	
	public Loginandsecurityeditemailpage() {
		PageFactory.initElements(getdriver(), this);
	}
	public Loginandsecurityeditemailotppage typeemail(String newemail) {
		Action.type(newemailbox, newemail);
		Action.click(getdriver(), continueotpbtn);
		return new Loginandsecurityeditemailotppage();
	}
}
