package ca.amazon.testcase;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ca.amazon.base.Baseclass;
import ca.amazon.pageobject.*;
import ca.amazon.utility.Log;

public class Addtocarttest extends Baseclass {
	
	public static Addtocartpage addtocart= new Addtocartpage();
	public static Addtocartordersummary addtocartordersummary= new Addtocartordersummary();
	public static Addtocartcheckoutpage finalcheckout= new Addtocartcheckoutpage();
	public static Addtocartproceedtocheckout semifinalcheckout=new Addtocartproceedtocheckout();
	public static Homepage homepage= new Homepage();
	public static Searchresultsecondpage search2= new Searchresultsecondpage();
	public static Searchresultpage search1= new Searchresultpage();

	
	
	@BeforeMethod(groups={"smoke","sanity"})
	public void launchapp(String browser) {
		loadbrowser(browser);
	}
	
	@AfterMethod (groups={"smoke","sanity"})
	public void teardown() {
		  getdriver().quit(); }
	
	@Test(groups={"smoke","sanity"})
	public void validateproduct() {
		Log.startTestCase("Product details");
		Searchresultpage search1= new Searchresultpage();
		Addtocartordersummary addtocartordersummary= new Addtocartordersummary();
		Addtocartpage addtocart= new Addtocartpage();
		Log.info("Going to type balaji wafers");
		search1.typeinsearchbox("balaji wafers 135g");
		search1.searchclick();
		addtocartordersummary=addtocart.searchbalajiwafers();
		String result=addtocartordersummary.validateproduct();
		String expacted="Balaji Tomato Twist (Tomato Potato Wafer) - 135g - (Pack of 4)";
		Assert.assertEquals(result, expacted);
	}
	
	
	@Test(groups="sanity")
	public void validateproductimage() throws Throwable {
		
		Addtocartordersummary addtocartordersummary= new Addtocartordersummary();
		Searchresultpage search1= new Searchresultpage();
		Addtocartpage addtocart= new Addtocartpage();
		search1.typeinsearchbox("balaji wafers 135g");
		search1.searchclick();
		addtocartordersummary=addtocart.searchbalajiwafers();
		addtocartordersummary.clickonproductimage();
		addtocartordersummary.closeimage();
	}
	
	@Test(groups="sanity")
	
	public void validateaddtocartproduct() {
		Addtocartordersummary addtocartordersummary= new Addtocartordersummary();
		Searchresultpage search1= new Searchresultpage();
		Addtocartpage addtocart= new Addtocartpage();
		Addtocartproceedtocheckout semifinalcheckout=new Addtocartproceedtocheckout();
		search1.typeinsearchbox("balaji wafers 135g");
		search1.searchclick();
		addtocartordersummary=addtocart.searchbalajiwafers();
		semifinalcheckout=addtocartordersummary.addtocart();
		String actual=semifinalcheckout.validateaddedtocart();
		String expected= "Added to Cart";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(groups="sanity")
	
	public void selectquantity() throws Throwable {
		
		Addtocartpage addtocart= new Addtocartpage();
		Addtocartordersummary addtocartordersummary= new Addtocartordersummary();
		Addtocartcheckoutpage finalcheckout= new Addtocartcheckoutpage();
		Addtocartproceedtocheckout semifinalcheckout=new Addtocartproceedtocheckout();
		Searchresultpage search1= new Searchresultpage();
		Loginpage loginpage=new Loginpage();
		Loginpasswordpage loginpassword= new Loginpasswordpage();
		
		search1.typeinsearchbox("balaji wafers 135g");
		search1.searchclick();
		addtocartordersummary=addtocart.searchbalajiwafers();
		semifinalcheckout=addtocartordersummary.addtocart();
		loginpage=semifinalcheckout.clickoncheckoutbtn();
		loginpage.typeemail("kalaria.vivek@gmail.com");
		loginpassword=loginpage.signin1();
		finalcheckout=loginpassword.signinaddtocart("Vivekkalaria@123");
		Thread.sleep(Duration.ofSeconds(15));
		Double productprice=finalcheckout.getproductprice();
		Double totalproductprice=finalcheckout.gettotalprice();
		
		Assert.assertEquals(productprice, totalproductprice);
		
		
		
	}
	
	
	
	
	
	
	

}
