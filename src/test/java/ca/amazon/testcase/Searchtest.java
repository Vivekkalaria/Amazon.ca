package ca.amazon.testcase;

import java.time.Duration;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ca.amazon.base.Baseclass;
import ca.amazon.dataprovider.Dataprovider;
import ca.amazon.pageobject.Homepage;
import ca.amazon.pageobject.Searchresultpage;
import ca.amazon.pageobject.Searchresultsecondpage;

public class Searchtest extends Baseclass {
	
	public static Homepage homepage;
	public static Searchresultsecondpage search2;
	public static Searchresultpage search1;

	
	
	@BeforeMethod (groups={"smoke","sanity"})
	public void launchapp() {
		loadbrowser();;
	}
	
	@AfterMethod (groups={"smoke","sanity"})
	public void teardown() { 
		getdriver().quit(); }
	
	
	@Test(dataProvider="Differentsearch", dataProviderClass=Dataprovider.class, groups= {"smoke", "sanity"})
	
	public void searchresult(String productname)throws Throwable {
		Searchresultpage search1= new Searchresultpage();
		search1.typeinsearchbox(productname);
		search1.searchclick();
		boolean result=search1.validateseachresult();
		Assert.assertTrue(result);
		}
	
	
	@Test
	public void partialtextvalidate() throws Throwable{
		Searchresultpage search1= new Searchresultpage();
		search1.typeinsearchbox("past");
		Thread.sleep(Duration.ofSeconds(7));
		String partialtext=search1.searchpartialtextresult();
		String expacted= "a";
		Assert.assertEquals(partialtext, expacted);
	}
	
	@Test
	
	public void validateproductperpage() {
		Searchresultpage search1= new Searchresultpage();
		search1.typeinsearchbox("pasta");
		search1.searchclick();
		String productperpage=search1.searchresultperpage();
		String expected="1-60 of over 3,000 results for";
		Assert.assertEquals(productperpage, expected);
	}
	
	
	

}
