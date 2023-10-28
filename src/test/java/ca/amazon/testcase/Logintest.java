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
import ca.amazon.pageobject.Loginpasswordpage;
import ca.amazon.pageobject.Youraccountpage;
import ca.amazon.utility.Log;
public class Logintest extends Baseclass {

	
	public static Homepage homepage=new Homepage();
	public static Loginpage loginpage=new Loginpage();
	public static Loginpasswordpage loginpassword= new Loginpasswordpage();
	public static Youraccountpage youraccountpage= new Youraccountpage();
	
	@Parameters("browser")
	@BeforeMethod(groups={"smoke","sanity"})
	public void launchapp() {
		loadbrowser();
	}
	
	@AfterMethod  (groups={"smoke","sanity"})
	public void teardown() { 
		getdriver().quit(); }
	 
	
	@Test(groups="smoke")
	
	public void logintest() throws Exception {
		Log.startTestCase("Login test");
		loginpage=homepage.Hellosignin();

		loginpage.typeemail("kalaria.vivek@gmail.com");
		loginpassword=loginpage.signin1();
		homepage=loginpassword.signin("Vivekkalaria@123");
		Thread.sleep(Duration.ofSeconds(60));
		Log.endTestCase("Login test");
	}
	
	@Test(groups="smoke")
	
	public void emptyemailerror() throws Throwable {
		Log.startTestCase("Empty email error");
		loginpage=homepage.Hellosignin();
		boolean actual=loginpage.emptyerrormessage();
		String expact="Enter your e-mail address or mobile phone number";
		Assert.assertTrue(actual, expact);
		Log.endTestCase("Empty email error");
		}
	
	@Test
	public void accountdetails() throws Throwable {
		Log.startTestCase("Your Account");
		loginpage=homepage.Hellosignin();
		loginpage.typeemail("kalaria.vivek@gmail.com");
		loginpassword=loginpage.signin1();
		homepage=loginpassword.signin("Vivekkalaria@123");
		loginpage=homepage.Hellosignin();
		String actual=youraccountpage.validateyouraccountsite();
		String expacted="https://www.amazon.ca/gp/css/homepage.html?ref_=nav_youraccount_btn";
		Assert.assertEquals(actual, expacted);
		}
	
	
	
	
	
	
	
	
}
