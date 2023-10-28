package ca.amazon.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ca.amazon.actiondriver.Action;
import ca.amazon.base.Baseclass;

public class Addnewaddresspage extends Baseclass{
	
	@FindBy(xpath="//*[@id=\"address-ui-widgets-countryCode\"]/span/span")
	WebElement countrydropdown;
	@FindBy(xpath="//*[@id=\"address-ui-widgets-enterAddressFullName\"]")
	WebElement fullname;
	@FindBy(xpath="//*[@id=\"address-ui-widgets-enterAddressPhoneNumber\"]")
	WebElement phonenumber;
	@FindBy(xpath="//*[@id=\"address-ui-widgets-enterAddressLine1\"]")
	WebElement address;
	@FindBy(xpath="//*[@id=\"address-ui-widgets-enterAddressCity\"]")
	WebElement city;
	@FindBy(xpath="//*[@id=\"address-ui-widgets-enterAddressStateOrRegion\"]/span/span")
	WebElement provincedropdown;
	@FindBy(xpath="//*[@id=\"address-ui-widgets-enterAddressPostalCode\"]")
	WebElement postalcode;
	@FindBy(xpath="//*[@id=\"address-ui-widgets-use-as-my-default\"]")
	WebElement defaultaddresscheckbox;
	@FindBy(xpath="//*[@id=\"address-ui-widgets-enterAddressFormContainer\"]/div[4]/a/span/span")
	WebElement deliveryinstructionsdropdown;
	@FindBy(xpath="//*[@id=\"address-ui-widgets-form-submit-button\"]/span/input")
	WebElement addaddressbtn;
	
	public Addnewaddresspage() {
		PageFactory.initElements(getdriver(), this);
	}
	public boolean validatecountry(String expacted) {
		String text= countrydropdown.getText();
		return text.equals(expacted);
	}
	public boolean validatefullname() {
		return Action.isDisplayed(getdriver(), fullname);
	}
	
	public void typefullname(String name) {
		Action.type(fullname, name);
	}
	public boolean validatephonenumber() {
		return Action.isDisplayed(getdriver(), phonenumber);
		
	}
	
	public void typephonenumber(String number) {
		Action.type(phonenumber, number);
	}
	public boolean validateaddress() {
		return Action.isDisplayed(getdriver(), address);
	}

	public void typeaddress(String fulladdress) {
		Action.type(address, fulladdress);
	}
	
	public boolean validatecity() {
		return Action.isDisplayed(getdriver(), city);
	}

	public void typecity(String cityname) {
		Action.type(city, cityname);
	}
	
	public boolean validateprovince() {
		return Action.isDisplayed(getdriver(), provincedropdown);
	}
	public void selectprovince(String provincename) {
		Action.selectByVisibleText(provincename, provincedropdown);
	}
	
	public boolean validatepostalcode() {
		return 	Action.isDisplayed(getdriver(),postalcode);
		
	}
	public void typepostalcode(String code) {
		Action.type(postalcode, code);
	}
	public void defaultaddress(String defaultaddresscheck) {
		Action.click(getdriver(), defaultaddresscheckbox);
	}
	public Youraddresses addaddress() {
		Action.click(getdriver(), addaddressbtn);
		return new Youraddresses();
	}
	
	
	
	
	
	
	
	
	
	
}
