package ca.amazon.pageobject;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ca.amazon.actiondriver.Action;
import ca.amazon.base.Baseclass;

public class Loginandsecurityeditmobilenumberpage extends Baseclass{

	
	@FindBy(id="ap_phone_number")
	WebElement newphonenumberbox;
	@FindBy(id="auth-continue")
	WebElement continuephonenumber;
	
	public Loginandsecurityeditmobilenumberpage() {
		PageFactory.initElements(getdriver(), this);
	}
	public Loginandsecurityeditmobilenumberotppage typemobilenumber(String entermobilenumber) throws InterruptedException {
		Action.type(newphonenumberbox, entermobilenumber);
		Action.click(getdriver(), continuephonenumber);
		Thread.sleep(Duration.ofSeconds(10));
		return new Loginandsecurityeditmobilenumberotppage();
	}
}
