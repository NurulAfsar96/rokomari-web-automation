package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import drivers.baseDriver;
import pages.ShippingPage;
import utilities.ExtentReport;

public class ShippingTest extends baseDriver{

	//------------------ Report -------------------------
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	//---------------------------------------------------------------
	@Test(priority=0)
	public void bookTest() throws IOException, InterruptedException
	{
		report = ExtentReport.getInstance();
		parentTest = report.createTest("<p style=\"color:#ffcc00; font-size:22px\"><b>Rokomari.com-SHIPPING</b></p>").assignAuthor("Nurul-Afsar").assignDevice("Windows");
		childTest =parentTest.createNode("<p style=\"color:#9161AB; font-size:18px\"><b>SHIPPING TEST</b></p>");
		ShippingPage sp = new ShippingPage(childTest);
		sp.fillAddress();
		sp.clickOption();
		sp.signout();
	}
	
	@AfterClass
	public void pushReport()
	{
		report.flush();
	}
	
	
}
