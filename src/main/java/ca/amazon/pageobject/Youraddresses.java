package ca.amazon.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ca.amazon.actiondriver.Action;
import ca.amazon.base.Baseclass;

public class Youraddresses extends Baseclass {
	
	@FindBy(xpath="//*[@id=\"ya-myab-plus-address-icon\"]")
	WebElement addaddressbtn;
	
	public Youraddresses() {
		PageFactory.initElements(getdriver(), this);
	}
	public Addnewaddresspage addaddressclick() {
		Action.click(getdriver(), addaddressbtn);
		return new Addnewaddresspage();
	}
	
}
