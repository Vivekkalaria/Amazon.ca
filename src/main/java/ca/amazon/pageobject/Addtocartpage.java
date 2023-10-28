 package ca.amazon.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ca.amazon.actiondriver.Action;
import ca.amazon.base.Baseclass;

public class Addtocartpage extends Baseclass {
	
	@FindBy(xpath="//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1']//span[@class='a-size-base-plus a-color-base a-text-normal'][contains(text(),'Balaji Tomato Twist (Tomato Potato Wafer) - 135g -')]")
	WebElement balajiwaferssearch;
	
	
	public Addtocartpage() {
		PageFactory.initElements(getdriver(), this);
	}
	
	public Addtocartordersummary searchbalajiwafers() {
		Action.click(getdriver(), balajiwaferssearch);
		return new Addtocartordersummary();
	}
	
	

}
