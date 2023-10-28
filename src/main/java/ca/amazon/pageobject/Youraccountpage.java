package ca.amazon.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ca.amazon.actiondriver.Action;
import ca.amazon.base.Baseclass;

public class Youraccountpage extends Baseclass {

	
	@FindBy(xpath="//*[@id=\"a-page\"]/div[1]/div/div[2]/div[1]/a/div/div/div/div[2]/h2")
	WebElement yourorders;
	@FindBy(xpath="//*[@id=\"a-page\"]/div[1]/div/div[3]/div[1]/a/div/div/div/div[2]/h2")
	WebElement youraddresses;
	@FindBy(xpath="//*[@id=\"a-page\"]/div[1]/div/div[2]/div[2]/a/div/div/div/div[2]/h2")
	WebElement loginandsecurity;
	@FindBy(xpath="//*[@id=\"a-page\"]/div[1]/div/div[3]/div[2]/a/div/div/div/div[2]/h2")
	WebElement yourpayments;
	
	public Youraccountpage() {
		PageFactory.initElements(getdriver(), this);
	}
	
	public boolean validateyouraddress() {
		return Action.isDisplayed(getdriver(), youraddresses);
	}
	
	public Youraddresses youraddressesclick() {
		Action.click(getdriver(), youraddresses);
		return new Youraddresses();
	}
	
	public boolean validateyourorders() {
		return Action.isDisplayed(getdriver(), yourorders);
	}
	public Yourorderspage yourordersclick() {
		Action.click(getdriver(), yourorders);
		return new Yourorderspage();
	}
	
	public boolean validateyourpayments() {
		return Action.isDisplayed(getdriver(), yourpayments);
	}
	public Yourpaymentspage yourpaymentsclick() {
		Action.click(getdriver(), yourpayments);
		return new Yourpaymentspage();
	}
	
	public boolean validateloginandsecurity() {
		return Action.isDisplayed(getdriver(), loginandsecurity);
	}
	
	public Loginandsecurity loginandsecurityclick() {
		Action.click(getdriver(), loginandsecurity);
		return new Loginandsecurity();
	}
	
	public String validateyouraccountsite() {
		String youraccounturl=getdriver().getCurrentUrl();
		return youraccounturl;
	}
}
