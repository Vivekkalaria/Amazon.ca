package ca.amazon.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ca.amazon.actiondriver.Action;
import ca.amazon.utility.Extentmanager;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.remote.RemoteWebDriver;



public class Baseclass {

	public static Properties prop=new Properties();
	
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	
	@BeforeSuite(groups={"smoke","sanity"})
	public void loadconfig() throws Throwable {
		Extentmanager.setExtent();
		DOMConfigurator.configure("Log4j.xml");
		
		try {
			FileInputStream file=new FileInputStream("C:\\Users\\Tast\\eclipse-workspace\\Amazon.ca\\Configuration\\Config.properties");
			prop.load(file);
			}
				
			catch(FileNotFoundException e) {
			e.printStackTrace();
			}
			
			catch(IOException a) {
			a.printStackTrace();
			}
		
		
		
	}
	
	
	
	public static WebDriver getdriver() {
	return driver.get();
	}

	
	

	
	public static void loadbrowser(String browsername) {
		//String browsername1= prop.getProperty("browser");
		if (browsername.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			// Set Browser to ThreadLocalMap
			driver.set(new ChromeDriver());
		} else if (browsername.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		} else if (browsername.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver.set(new InternetExplorerDriver());
		}
	
		
		getdriver().manage().window().maximize();
		//driver.manage().window().minimize();
		
		getdriver().manage().deleteAllCookies();
		
		getdriver().get(prop.getProperty("url"));
		
		Action.implicitWait(getdriver(),5);
		
		Action.pageLoadTimeOut(getdriver(),5);
		
		
	}
	
	
	 @AfterSuite(groups = { "Smoke", "Regression","Sanity" }) 
	 public void
	 afterSuite() { Extentmanager.endReport(); }
	
}
