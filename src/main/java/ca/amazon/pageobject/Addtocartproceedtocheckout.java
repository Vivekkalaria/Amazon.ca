package ca.amazon.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ca.amazon.actiondriver.Action;
import ca.amazon.base.Baseclass;

public class Addtocartproceedtocheckout extends Baseclass {

	@FindBy(xpath="//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']")
	WebElement addedtocarttext;
	@FindBy(xpath="//input[@name='proceedToRetailCheckout']")
	WebElement proceedtocheckoutbtn;
	@FindBy(xpath="//a[@href='/cart?ref_=sw_gtc']")
	WebElement gotocartbtn;
	
	public Addtocartproceedtocheckout() {
		PageFactory.initElements(getdriver(),this);
	}
	
	public String validateaddedtocart() {
		String addedtocart=addedtocarttext.getText();
		return addedtocart;
	}
	
	public Addtocartcheckoutpage proceedtocheckoutclick() {
		Action.click(getdriver(), proceedtocheckoutbtn);
		return new Addtocartcheckoutpage();
	}
	
	public Loginpage clickoncheckoutbtn() {
		Action.click(getdriver(), proceedtocheckoutbtn);
		return new Loginpage();
	}
}
