package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import drivers.baseDriver;
import pages.CartPage;
import utilities.ExtentReport;

public class CartTest extends baseDriver {
	//------------------ Report -------------------------
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	//---------------------------------------------------------------
	
	@Test(priority=0)
	public void bookTest() throws IOException, InterruptedException
	{
		report = ExtentReport.getInstance();
		parentTest = report.createTest("<p style=\"color:#ffcc00; font-size:22px\"><b>Rokomari.com-CART</b></p>").assignAuthor("Nurul-Afsar").assignDevice("Windows");
		childTest =parentTest.createNode("<p style=\"color:#9161AB; font-size:18px\"><b>CART TEST</b></p>");
		CartPage cp = new CartPage(childTest);
		cp.checkBook();
		cp.placeorder();
		
	}
	
	@AfterClass
	public void pushReport()
	{
		report.flush();
	}

}
