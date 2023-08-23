package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import drivers.baseDriver;
import pages.BookPage;
import utilities.ExtentReport;

public class BookTest extends baseDriver{
	//------------------ Report -------------------------
		ExtentReports report;
		ExtentTest parentTest;
		ExtentTest childTest;
		//---------------------------------------------------------------
		@Test(priority=0)
		public void bookTest() throws IOException, InterruptedException
		{
			report = ExtentReport.getInstance();
			parentTest = report.createTest("<p style=\"color:#ffcc00; font-size:22px\"><b>Rokomari.com-BOOK</b></p>").assignAuthor("Nurul-Afsar").assignDevice("Windows");
			childTest =parentTest.createNode("<p style=\"color:#9161AB; font-size:18px\"><b>BOOK TEST</b></p>");
			BookPage bp = new BookPage(childTest);
			bp.filterCategory();
			bp.scrollDown();
			bp.nextPage();
			bp.previousPage();
			bp.scrollUp();
			bp.addtoCart();
			bp.clickCartIcon();
			
		}
		
		@AfterClass
		public void pushReport()
		{
			report.flush();
		}

}
