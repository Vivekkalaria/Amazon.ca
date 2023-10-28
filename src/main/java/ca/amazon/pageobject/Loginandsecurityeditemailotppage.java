package ca.amazon.pageobject;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ca.amazon.actiondriver.Action;
import ca.amazon.base.Baseclass;

public class Loginandsecurityeditemailotppage extends Baseclass{

	@FindBy(xpath="//*[@id=\"cvf-page-content\"]/div/div/div/form/div[1]/div/div[2]/div/input")
	WebElement emailotpbox;
	@FindBy(xpath="//*[@id=\"a-autoid-0\"]/span/input")
	WebElement otpcontinuebtn;
	
	public Loginandsecurityeditemailotppage() {
		PageFactory.initElements(getdriver(), this);
	}
	public Loginandsecurity typeotp(String emailotp) throws InterruptedException {
		Thread.sleep(Duration.ofSeconds(30));
		Action.type(emailotpbox, emailotp);
		Action.click(getdriver(), otpcontinuebtn);
		return new Loginandsecurity();
		
		
	}
	
	
	
}
