package ca.amazon.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ca.amazon.actiondriver.Action;
import ca.amazon.base.Baseclass;

public class Searchresultpage extends Baseclass {
	
	@FindBy(id="twotabsearchtextbox")
	WebElement Searchbox;
	@FindBy(id="nav-search-submit-button")
	WebElement Searchbtn;
	@FindBy(xpath="(//span[@class='a-size-base-plus a-color-base a-text-normal'][contains(text(),'Balaji Tomato Twist (Tomato Potato Wafer) - 135g -')])[1]")
	WebElement searchblalajiwafers;
	@FindBy(xpath="//span[normalize-space()='a']")
	WebElement searchpartialtextPAS;
	@FindBy(xpath="//span[@class='a-dropdown-prompt']")
	WebElement sortbydropdown;
	@FindBy(xpath="//span[normalize-space()='1-48 of over 3,000 results for']")
	WebElement searchresultcount;
	@FindBy(xpath="//a[normalize-space()='Next']")
	WebElement nextpagebtn;
	
	@FindBy(xpath="//span[contains(text(),'$50 to $100')]")
	WebElement pricefilter;
	
	
	
	
	public Searchresultpage() {
		PageFactory.initElements(getdriver(), this);
	}
	
	public void typeinsearchbox(String keyword) {
		Action.type(Searchbox, keyword);
	}	
	
	public void searchclick() {
		Action.click(getdriver(), Searchbtn);
	}
	
	public boolean validateseachresult() {
		return Action.isDisplayed(getdriver(), searchblalajiwafers);
	}
	
	
	
	public String searchpartialtextresult() {
		String pas=searchpartialtextPAS.getText();
		return pas;
	}
	public String searchresultperpage() {
		String productcount=searchresultcount.getText();
		return productcount;
	}
	
	public void sortbyselection(String sortbyoptions) {
		Action.selectByVisibleText(sortbyoptions, sortbydropdown);
	}
	
	public Searchresultsecondpage nextpage() {
		Action.click(getdriver(), nextpagebtn);
		return new Searchresultsecondpage();
	}
	
	public void pricefiltersearch() {
		Action.click(getdriver(), pricefilter);
		
	}
	
	

}
