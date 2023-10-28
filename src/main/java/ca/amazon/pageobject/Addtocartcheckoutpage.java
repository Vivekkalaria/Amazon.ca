package ca.amazon.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ca.amazon.actiondriver.Action;
import ca.amazon.base.Baseclass;

public class Addtocartcheckoutpage extends Baseclass{
	@FindBy(id="submitOrderButtonId-announce")
	WebElement placeorderbtn;
	@FindBy(xpath="//span[@class='a-dropdown-label']")
	WebElement quantitybtncheckout;
	@FindBy(xpath="(//td[@class='a-text-right aok-nowrap a-nowrap'][normalize-space()='$22.19'])[1]")
	WebElement productprice;
	@FindBy(xpath="//td[@class='a-color-price a-size-medium a-text-right grand-total-price aok-nowrap a-text-bold a-nowrap']")
	WebElement finalprice;
	
	
	
	public Addtocartcheckoutpage() {
		PageFactory.initElements(getdriver(), this);
	}
	public double getproductprice() {
		String productprice1=productprice.getText();
		String productprice2=productprice1.replaceAll("[^a-zA-Z0-]", "");
		double finalprice=Double.parseDouble(productprice2);
		return finalprice/100;
	}
	
	public double gettotalprice() {
		String totalprice1=finalprice.getText();
		String totalprice2=totalprice1.replaceAll("[^a-zA-Z0-])", "");
		double totalfinalprice=Double.parseDouble(totalprice2);
		return totalfinalprice/100;
	}
	
	public void selectquantity(int quantity ) {
		Action.selectByIndex(quantitybtncheckout, quantity);
	}
	
	public void checkout() {
		Action.click(getdriver(), placeorderbtn);
	}
}
