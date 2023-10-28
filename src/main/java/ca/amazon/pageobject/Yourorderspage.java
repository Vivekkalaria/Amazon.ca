package ca.amazon.pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ca.amazon.actiondriver.Action;
import ca.amazon.base.Baseclass;

public class Yourorderspage extends Baseclass {
	
	@FindBy(xpath="//*[@id=\"orderTypeMenuContainer\"]/ul/li[2]/span/a")
	WebElement ordersbtn;
	@FindBy(xpath="//*[@id=\"orderTypeMenuContainer\"]/ul/li[3]/span/a")
	WebElement buyagainbtn;
	@FindBy(xpath="//*[@id=\"orderTypeMenuContainer\"]/ul/li[4]/span/a")
	WebElement notyetshipped;
	@FindBy(xpath="//*[@id=\"orderTypeMenuContainer\"]/ul/li[5]/span/a")
	WebElement cancelledorders;
	@FindBy(xpath="//*[@id=\"closedCard-B09GV741RY\"]")
	WebElement buyagainsuggetions;
	@FindBy(xpath="//*[@id=\"a-autoid-1-announce\"]/span")
	WebElement pastordersdropdown;
	@FindBy(xpath="//*[@id=\"a-page\"]/section/div[1]/div[10]/div/div[2]/div/div/div/div[1]/div[3]/div/div/div[2]/div[1]/a/div")
	WebElement pastorderedproduct;
	@FindBy(xpath="//*[@id=\"ordersContainer\"]/div[1]/div/text()")
	WebElement cancelledorderstext;
	@FindBy(xpath="//*[@id=\"ordersContainer\"]/div[1]/div/text()")
	WebElement notyetshippedtext;
	
	public Yourorderspage() {
		PageFactory.initElements(getdriver(),this);
	}
	
	public boolean validateordersdropdown(WebDriver driver, WebElement pastordersdropdown) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='Achieved Orders'", pastordersdropdown);
		boolean flag = false;
		try {
			pastordersdropdown.isDisplayed();
			flag = true;
		} catch (Exception e) {
			System.out.println("Location not found: "+pastordersdropdown);
			flag = false;
		} finally {
			if (flag) {
				System.out.println("Successfully Found element at");

			} else {
				System.out.println("Unable to locate element at");
			}
		}
		return flag;
	
	}
	public void buyagainsuggetions() {
		Action.click(getdriver(), buyagainbtn);
		Action.implicitWait(getdriver(), 5);
	}
	public boolean validatebuyagainsuggestions() {
		return Action.isDisplayed(getdriver(), buyagainsuggetions);
		}
	public String validatecancelledorderstext() {
		String cancelorderstext= cancelledorderstext.getText();
		return cancelorderstext;
		}
	public String validatenotyetshippedtext() {
		String notyetshipped=notyetshippedtext.getText();
		return notyetshipped;
	}
	public void pastorderproduct() {
		Action.click(getdriver(), pastorderedproduct);
	}
}
