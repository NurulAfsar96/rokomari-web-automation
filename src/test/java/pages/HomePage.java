package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import drivers.pageDriver;
import utilities.CommonMethods;
import utilities.getScreenshot;

public class HomePage extends CommonMethods {
	ExtentTest test;
	//--------------------------> Constructor <-----------------------------
	public HomePage(ExtentTest test)
	{
		PageFactory.initElements(pageDriver.getCurrentDriver(), this);
		this.test = test;
	}
	

	@FindBys({
		@FindBy(xpath="//button[@id='js--notification-btn-close']")
	})
	WebElement closeOffer;

	@FindBys({
		@FindBy(xpath="//body/div[@id='js--entry-popup']/div[1]/button[1]/i[1]")
	})
	WebElement closePopup;
	
	@FindBy(xpath="//a[contains(text(),'Sign in')]") WebElement signinbtn;
	//----------------------------------->>> Methods <<<----------------------------------------------------
	//--- Check Dashboard method ---
		 public void checkDashboard() throws IOException
		 {
			 try
			 {
				 if(pageDriver.getCurrentDriver().getTitle().contains("Buy Book Online - Best Online Book Shop in Bangladesh | Rokomari.com")) {
				 sleep(2000);
				 test.pass("<p style=\"color:#29a329; font-size:14px\"><b>Successfully Dashboard webpage is loaded.</b></p>");
				 @SuppressWarnings("unused")
				 String screenshotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "DashboardPass");
				 String dest = System.getProperty("user.dir") + "\\screenshots\\" + "DashBoardPass.png";
				 test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			 }
			 }
			 catch (Exception e)
			 {
					test.fail("<p style=\"color:#ff3300; font-size:14px\"><b>Dashboard title is not locatable. </b></p>");
					Throwable t = new InterruptedException("Exception");
					test.fail(t);
					@SuppressWarnings("unused")
					String screenshotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "DashboardLocator");
					String dest = System.getProperty("user.dir") + "\\screenshots\\" + "DashBoardLocator.png";
					test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
					Assert.assertTrue(pageDriver.getCurrentDriver().getTitle().contains("Buy Book Online - Best Online Book Shop in Bangladesh | Rokomari.com"));
					pageDriver.getCurrentDriver().quit();
			 }
			 /*
				try{
					if(closeOffer.isDisplayed())
						{
						closeOffer.click();
						sleep(3000);
						test.pass("<p style=\"color:#29a329; font-size:14px\"><b> Close Offer PASSED.</b></p>");
						@SuppressWarnings("unused")
						String screenShotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "CloseOffer");
						String dest = System.getProperty("user.dir") + "\\screenshots\\" + "CloseOffer.png";
						test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
						}
					}
				catch(Exception e)
				{
					test.fail("<p style=\"color:#ff3300; font-size:13px\"><b>CloseOffer FAILED.Please check the error message.</b></p>");
					Throwable t = new InterruptedException("Exception");
					test.fail(t);
					@SuppressWarnings("unused")
					String screenShotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "CloseOfferLocator");
					String dest = System.getProperty("user.dir") + "\\screenshots\\" + "CloseOfferLocator.png";
					test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
					Assert.assertTrue(closeOffer.isDisplayed());
					pageDriver.getCurrentDriver().quit();
				}
			 */
				try{
					if(closePopup.isDisplayed())
						{
						closePopup.click();
						sleep(3000);
						test.pass("<p style=\"color:#29a329; font-size:14px\"><b> Close PopUp PASSED.</b></p>");
						@SuppressWarnings("unused")
						String screenShotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "ClosePopup");
						String dest = System.getProperty("user.dir") + "\\screenshots\\" + "ClosePopup.png";
						test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
						}
					}
				catch(Exception e)
				{
					test.fail("<p style=\"color:#ff3300; font-size:13px\"><b>Close PopUp FAILED.Please check the error message.</b></p>");
					Throwable t = new InterruptedException("Exception");
					test.fail(t);
					@SuppressWarnings("unused")
					String screenShotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "ClosePopupLocator");
					String dest = System.getProperty("user.dir") + "\\screenshots\\" + "ClosePopupLocator.png";
					test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
					Assert.assertTrue(closePopup.isDisplayed());
					pageDriver.getCurrentDriver().quit();
				}
			 
		 }
		 //--------------> SignIn Method <--------------------------
		 
		 public void signin() throws IOException {
			 try
				{
					if(signinbtn.isDisplayed())
					{
						signinbtn.click();
						sleep(3000);
						test.pass("<p style=\"color:#29a329; font-size:14px\"><b>Successfully Click SignIn.</b></p>");
						@SuppressWarnings("unused")
						String screenshotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "ClickSignInPass");
						String dest = System.getProperty("user.dir") + "\\screenshots\\" + "ClickSignInPass.png";
						test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
					}
				}
				catch (Exception e)
				{
					test.fail("<p style=\"color:#ff3300; font-size:14px\"><b>SignIn button is not locatable. </b></p>");
					Throwable t = new InterruptedException("Exception");
					test.fail(t);
					@SuppressWarnings("unused")
					String screenshotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "ClickSignInLocator");
					String dest = System.getProperty("user.dir") + "\\screenshots\\" + "ClickSignInLocator.png";
					test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
					Assert.assertTrue(signinbtn.isDisplayed());
					pageDriver.getCurrentDriver().quit();
				}
		 }
		 

}
