package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import drivers.baseDriver;
import pages.LoginPage;
import utilities.ExtentReport;

public class LoginTest extends baseDriver{
	//------------------ Report -------------------------
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	//---------------------------------------------------------------
	
	@Test(priority=0)
	public void loginTest() throws IOException, InterruptedException
	{
		report = ExtentReport.getInstance();
		parentTest = report.createTest("<p style=\"color:#ffcc00; font-size:22px\"><b>Rokomari.com-LOGIN</b></p>").assignAuthor("Nurul-Afsar").assignDevice("Windows");
		childTest =parentTest.createNode("<p style=\"color:#9161AB; font-size:18px\"><b>LOGIN TEST</b></p>");
		LoginPage lp = new LoginPage(childTest);
		lp.login();
		
	}
	
	@AfterClass
	public void pushReport()
	{
		report.flush();
	}

}
