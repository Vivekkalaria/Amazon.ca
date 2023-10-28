package ca.amazon.utility;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentmanager {

	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void setExtent() throws Throwable {
		//htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport_"+BaseClass.getCurrentTime()+".html");
		sparkReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/Extentreport/"+"MyReport.html");
		sparkReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		//htmlReporter.config().setDocumentTitle("Automation Test Report");
		//htmlReporter.config().setReportName("OrangeHRM Test Automation Report");
		//htmlReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("HostName", "MyHost");
		extent.setSystemInfo("ProjectName", "Amazon.ca");
		extent.setSystemInfo("Tester", "Vivek");
		extent.setSystemInfo("OS", "Win11");
		extent.setSystemInfo("Browser", "Chrome");
	}
	public static void endReport() {
		extent.flush();
	}
}
