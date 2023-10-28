package ca.amazon.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ca.amazon.actiondriver.Action;
import ca.amazon.base.Baseclass;

public class Yourpaymentspage extends Baseclass {
	
	@FindBy(id="pp-PpHzvA-45-announce")
	WebElement addcreditcardbtn;
	@FindBy(id="pp-YLUzXJ-17")
	WebElement cardnumberbox;
	@FindBy(id="pp-YLUzXJ-19")
	WebElement nameoncardbox;
	@FindBy(xpath="//*[@id=\"pp-YLUzXJ-23\"]/span/span")
	WebElement expirymonthdropdown;
	@FindBy(xpath="//*[@id=\"pp-YLUzXJ-24\"]/span/span/span")
	WebElement expiryyeardropdown;
	@FindBy(id="pp-YLUzXJ-26")
	WebElement securitycodebox;
	@FindBy(id="pp-YLUzXJ-32-announce")
	WebElement addyourcardbtn;
	
	public Yourpaymentspage() {
		PageFactory.initElements(getdriver(), this);
	}
	
	public void addcreditcard() {
		Action.click(getdriver(), addcreditcardbtn);
	}
	
	public void typecardnumber(String credircardnumber ,String nameoncard) {
		Action.type(cardnumberbox, credircardnumber);
		Action.type(nameoncardbox, nameoncard);
	}
	
	public void expirymonthdropdown(String monthofexpiry ,String yearofexpiry) {
		Action.selectByVisibleText(monthofexpiry, expirymonthdropdown);
		Action.selectByVisibleText(yearofexpiry, expiryyeardropdown);
	}

	public void typesecuritycode(String securitycode) {
		Action.type(securitycodebox, securitycode);
		Action.click(getdriver(), addyourcardbtn);
	}
}

