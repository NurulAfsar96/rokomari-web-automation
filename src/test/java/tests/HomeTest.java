package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import drivers.baseDriver;
import drivers.pageDriver;
import pages.HomePage;
import utilities.ExtentReport;

public class HomeTest extends baseDriver {
	//------------------ Report -------------------------
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	//---------------------------------------------------------------
	@BeforeClass
	public void openURL() 
	{
		pageDriver.getCurrentDriver().manage().window().maximize();
		pageDriver.getCurrentDriver().get(url);
		
	}
	
	@Test(priority=0)
	public void dashBoardTest() throws IOException, InterruptedException
	{
		report = ExtentReport.getInstance();
		parentTest = report.createTest("<p style=\"color:#ffcc00; font-size:22px\"><b>Rokomari.com-HOME</b></p>").assignAuthor("Nurul-Afsar").assignDevice("Windows");
		childTest =parentTest.createNode("<p style=\"color:#9161AB; font-size:18px\"><b>HOMEPAGE TEST</b></p>");
		HomePage hp = new HomePage(childTest);
		hp.checkDashboard();
		hp.signin();
		
	}
	
	@AfterClass
	public void pushReport()
	{
		report.flush();
	}
	
	
	
}
