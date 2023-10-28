package ca.amazon.testcase;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ca.amazon.base.Baseclass;
import ca.amazon.pageobject.Homepage;
import ca.amazon.pageobject.Loginpage;
import ca.amazon.pageobject.Createaccountpage;
import ca.amazon.pageobject.Createaccountotppage;

public class Createaccounttest extends Baseclass {
	
	public static Homepage homepage=new Homepage();
	public static Loginpage loginpage=new Loginpage();
	public static Createaccountpage createaccount=new Createaccountpage();
	public static Createaccountotppage createaccount1= new Createaccountotppage();

	

	@BeforeMethod(groups={"smoke","sanity"})
	public void launchapp() {
		loadbrowser();
	}
	
	@AfterMethod (groups={"smoke","sanity"})
	public void teardown() {
		getdriver().quit(); }
	 

	
	@Test(priority=1)
	
	public void validatehellosigninbtn() throws Exception {

	homepage.hellosigninmousehover();
	boolean result=homepage.validatestarthere();
	Assert.assertTrue(result);
	}

	
	@Test(priority=2)
	
	public void verifyemail() throws Exception  {
		
		loginpage=homepage.Hellosignin();
		createaccount=loginpage.createaccount(); 
		createaccount.yourname("vivek kalaria");
		createaccount.emailid("kalaria151995@gmail.com");
		createaccount.passwords("1234567890","1234567890");
		createaccount1=createaccount.clickverifyemail();
		Thread.sleep(Duration.ofSeconds(20));
		homepage=createaccount1.createaccountfinal();
		}
	
	
	
	
}
