package ca.amazon.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ca.amazon.actiondriver.Action;
import ca.amazon.base.Baseclass;

public class Homepage extends Baseclass{
	
	@FindBy(xpath="//span[@class='nav-action-inner']")
	WebElement signinbtn;
	@FindBy(xpath="//a[normalize-space()='Start here.']")
	WebElement Startheremousehover;
	@FindBy(id="nav-link-accountList-nav-line-1")
	WebElement Hellosigninbtn;
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement Searchbox;
	@FindBy(xpath="//input[@id='nav-search-submit-button']")
	WebElement Searchbtn;
	@FindBy(xpath="//span[@class='nav-cart-icon nav-sprite']")
	WebElement Cart;
	@FindBy(xpath="//span[normalize-space()='Your Account']")
	WebElement youraccountbtn;
	
	public Homepage(){
		PageFactory.initElements(getdriver(), this);
	}
	
	public boolean validatesigninbtn() {
	return Action.isDisplayed(getdriver(), signinbtn);
	}
	public boolean validatestarthere() {
	return Action.isDisplayed(getdriver(), Startheremousehover);
	}
	public boolean validatehellosigninbtn() {
	return Action.isDisplayed(getdriver(), Hellosigninbtn);
	}
	public boolean validatesearchbox() {
	return Action.isDisplayed(getdriver(), Searchbox);
	}
	public boolean validatesearchbtn() {
	return Action.isDisplayed(getdriver(), Searchbtn);
	}
	
	public void hellosigninmousehover() {
		Action.mouseover(getdriver(), Hellosigninbtn);
		
	}
	
	public Loginpage Hellosignin() throws Exception {
	getdriver().findElement(By.id("nav-link-accountList-nav-line-1")).click();
	return new Loginpage();
	}
	
	public Createaccountpage clickonstarthere() throws Exception {
		Action.click(getdriver(), Startheremousehover);
		return new Createaccountpage();
	}
	
	public Searchresultpage searchproduct(String productname)throws Exception {
		Action.type(Searchbox, productname);
		Action.click(getdriver(), Searchbtn);
		return new Searchresultpage();
		
	}
	public Youraccountpage starthere()throws Exception {
		Action.mouseover(getdriver(), Hellosigninbtn);
		Action.click(getdriver(), youraccountbtn);
		return new Youraccountpage();
	}
	
	
	
}
