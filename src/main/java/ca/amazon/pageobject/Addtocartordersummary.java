package ca.amazon.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ca.amazon.actiondriver.Action;
import ca.amazon.base.Baseclass;

public class Addtocartordersummary extends Baseclass{

	@FindBy(id="add-to-cart-button")
	WebElement addtocartbtn;
	@FindBy(id="quantity")
	WebElement qauntitydropdown;
	@FindBy(id="landingImage")
	WebElement productimage;
	@FindBy(xpath="//i[@class='a-icon a-icon-close']")
	WebElement closeimagebtn;
	@FindBy(xpath="//span[@id='productTitle']")
	WebElement producttext;
	
	public Addtocartordersummary() {
		PageFactory.initElements(getdriver(),this);
	}
	
	public void quantityselection(String quantity) {
		Action.selectByVisibleText(quantity, qauntitydropdown);
	}
	public Addtocartproceedtocheckout addtocart() {
		Action.click(getdriver(), addtocartbtn);
		return new Addtocartproceedtocheckout();
	}
	
	public void closeimage() throws Throwable {
		Action.JSClick(getdriver(), closeimagebtn);
	}
	
	public void clickonproductimage() {
		Action.click(getdriver(), productimage);
	}
	public void closeproductimage() {
		Action.click(getdriver(), closeimagebtn);
	}
	public String validateproduct() {
		String producttext1=producttext.getText();
		return producttext1;
	}
	
	
}
