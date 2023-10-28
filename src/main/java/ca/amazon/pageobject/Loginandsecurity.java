package ca.amazon.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ca.amazon.actiondriver.Action;
import ca.amazon.base.Baseclass;

public class Loginandsecurity extends Baseclass{
	
	@FindBy(xpath="//*[@id=\"auth-cnep-edit-name-button\"]")
	WebElement nameedit;
	@FindBy(xpath="//*[@id=\"auth-cnep-edit-email-button\"]")
	WebElement emailedit;
	@FindBy(xpath="//*[@id=\"auth-cnep-edit-phone-button\"]")
	WebElement mobilenumberedit;
	@FindBy(xpath="//*[@id=\"auth-cnep-edit-password-button\"]")
	WebElement passwordedit;
	@FindBy(xpath="//*[@id=\"auth-cnep-done-button\"]")
	WebElement donebtn;
	
	public Loginandsecurity() {
		PageFactory.initElements(getdriver(), this);
	}

	public Loginandsecurityeditnamepage editname() {
		Action.click(getdriver(), nameedit);
		return new Loginandsecurityeditnamepage();
	}
	
	public Loginandsecurityeditemailpage editemail() {

		Action.click(getdriver(), emailedit);
		return new Loginandsecurityeditemailpage();
	}
	
	public Loginandsecurityeditmobilenumberpage editmobilenumber() {
		Action.click(getdriver(), mobilenumberedit);
		return new Loginandsecurityeditmobilenumberpage();
	}
	
	public Loginandsecurityeditpasswordpage editpassword() {

		Action.click(getdriver(), passwordedit);
		return new Loginandsecurityeditpasswordpage();
	}
	public void addressadddonebtn() {
		Action.click(getdriver(), donebtn);
	}
	
	
	
	
	
	
	
	
}
