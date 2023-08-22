package pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import drivers.pageDriver;
import utilities.CommonMethods;
import utilities.getScreenshot;

public class ShippingPage extends CommonMethods {
	
	ExtentTest test;
	
	public ShippingPage(ExtentTest test)
	{
		PageFactory.initElements(pageDriver.getCurrentDriver(), this);
		this.test = test;
	}
	
	//------------------------------------------->>> Locators <<<-------------------------------------------
	@FindBy(xpath="//body/div[@id='shipping-payment']/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[2]/fieldset[1]/input[1]") 
	WebElement name;

	@FindBy(xpath="//select[@id='js--country']") 
	WebElement selectCountry;
	
	@FindBy(xpath="//select[@id='js--city']") 
	WebElement selectCity;
	
	@FindBy(xpath="//select[@id='js--area']") 
	WebElement selectArea;
	
	@FindBy(xpath="//select[@id='js--zone']") 
	WebElement selectZone;

	@FindBy(xpath="//body/div[@id='shipping-payment']/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[2]/fieldset[2]/textarea[1]") 
	WebElement address;
	
	@FindBy(xpath="//body/div[@id='shipping-payment']/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[1]/div[1]/label[1]") 
	WebElement payMethod;
	
	@FindBy(xpath="//label[contains(text(),'এই শর্তগুলো মেনে অর্ডার প্রদান করছি।')]") 
	WebElement acceptCondition;
	
	@FindBy(xpath="//header/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[3]/a[1]/i[1]") 
	WebElement profileMenu;
	
	@FindBy(xpath="//a[contains(text(),'Sign Out')]") 
	WebElement signOut;

	
	//------------------------------------------------>>> Methods <<<------------------------------------------------
	
	public void fillAddress() throws IOException
	{
		//--->Name
		try
		{
			if(name.isDisplayed())
			{
				name.sendKeys("Tester");
				sleep(3000);
				test.pass("<p style=\"color:#29a329; font-size:14px\"><b>Successfully input Name.</b></p>");
				@SuppressWarnings("unused")
				String screenshotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "InputNamePass");
				String dest = System.getProperty("user.dir") + "\\screenshots\\" + "InputNamePass.png";
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			}
		}
		catch(Exception e)
			{
				test.fail("<p style=\"color:#ff3300; font-size:13px\"><b>InputName is not locateable.Please check the error message.</b></p>");
				Throwable t = new InterruptedException("Exception");
				test.fail(t);
				@SuppressWarnings("unused")
				String screenShotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "InputNameLocator");
				String dest = System.getProperty("user.dir") + "\\screenshots\\" + "InputNameLocator.png";
				test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
				Assert.assertTrue(name.isDisplayed());
				pageDriver.getCurrentDriver().quit();
		}
		
		//--->Select Country
		try
		{

			Select select = new Select(selectCountry);
			select.selectByVisibleText("Bangladesh");
			sleep(3000);
			test.pass("<p style=\"color:#29a329; font-size:14px\"><b>Successfully Select Bangladesh.</b></p>");
			@SuppressWarnings("unused")
			String screenshotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "SelectCountryPass");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "SelectCountryPass.png";
			test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		
		}
		catch(Exception e)
		{
			test.fail("<p style=\"color:#ff3300; font-size:13px\"><b>SelectCountry is not locateable.Please check the error message.</b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenShotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "SelectCountryLocator");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "SelectCountryLocator.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			pageDriver.getCurrentDriver().quit();
		}
		
		//--->Select City
		try
		{
			Select select = new Select(selectCity);
			select.selectByVisibleText("ফেনী");
			sleep(3000);
			test.pass("<p style=\"color:#29a329; font-size:14px\"><b>Successfully Select ফেনী.</b></p>");
			@SuppressWarnings("unused")
			String screenshotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "SelectCityPass");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "SelectCityPass.png";
			test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		
		}
		catch(Exception e)
		{
			test.fail("<p style=\"color:#ff3300; font-size:13px\"><b>SelectCity is not locateable.Please check the error message.</b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenShotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "SelectCityLocator");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "SelectCityLocator.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			pageDriver.getCurrentDriver().quit();
		}
		
		//--->Select Area
		try
		{
			Select select = new Select(selectArea);
			select.selectByValue("480");
			sleep(3000);
			//select.selectByVisibleText("ফুলগাজী");
			test.pass("<p style=\"color:#29a329; font-size:14px\"><b>Successfully Select ফুলগাজী .</b></p>");
			@SuppressWarnings("unused")
			String screenshotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "SelectAreaPass");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "SelectAreaPass.png";
			test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		
		}
		catch(Exception e)
		{
			test.fail("<p style=\"color:#ff3300; font-size:13px\"><b>SelectArea is not locateable.Please check the error message.</b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenShotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "SelectAreaLocator");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "SelectAreaLocator.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			pageDriver.getCurrentDriver().quit();
		}
		
		//--->Select Zone
		try
		{
			Select select = new Select(selectZone);
			select.selectByValue("4470");
			sleep(3000);
			//select.selectByVisibleText("ফুলগাজী");
			test.pass("<p style=\"color:#29a329; font-size:14px\"><b>Successfully Select ফুলগাজী পৌরসভা .</b></p>");
			@SuppressWarnings("unused")
			String screenshotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "SelectZonePass");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "SelectZonePass.png";
			test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		
		}
		catch(Exception e)
		{
			test.fail("<p style=\"color:#ff3300; font-size:13px\"><b>SelectZone is not locateable.Please check the error message.</b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenShotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "SelectZoneLocator");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "SelectZoneLocator.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			pageDriver.getCurrentDriver().quit();
		}
		
		//--->Address
		try
		{
			if(address.isDisplayed())
			{
				address.sendKeys("SouthZone,Zroad");
				sleep(3000);
				test.pass("<p style=\"color:#29a329; font-size:14px\"><b>Successfully input Address.</b></p>");
				@SuppressWarnings("unused")
				String screenshotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "InputAddressPass");
				String dest = System.getProperty("user.dir") + "\\screenshots\\" + "InputAddressPass.png";
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			}
		}
		catch(Exception e)
		{
		test.fail("<p style=\"color:#ff3300; font-size:13px\"><b>InputAddress is not locateable.Please check the error message.</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		@SuppressWarnings("unused")
		String screenShotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "InputAddressLocator");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + "InputAddressLocator.png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		Assert.assertTrue(address.isDisplayed());
		pageDriver.getCurrentDriver().quit();
		}
	}
	//---------------------------------------------------------------------------------------------------------------------------------------------
	 public void clickOption() throws IOException
	 {
			try
			{			
					JavascriptExecutor js = (JavascriptExecutor) pageDriver.getCurrentDriver();
					js.executeScript("window.scrollBy(0,600)");
					sleep(3000);
					test.pass("<p style=\"color:#29a329; font-size:14px\"><b>Scroll to Payment Method.</b></p>");
					@SuppressWarnings("unused")
					String screenshotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "ScrollPass");
					String dest = System.getProperty("user.dir") + "\\screenshots\\" + "ScrollPass.png";
					test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
					
			}
			catch(Exception e)
			{
				test.fail("<p style=\"color:#ff3300; font-size:13px\"><b>Scroll is not locateable.Please check the error message.</b></p>");
				Throwable t = new InterruptedException("Exception");
				test.fail(t);
				@SuppressWarnings("unused")
				String screenShotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "ScrollLocator");
				String dest = System.getProperty("user.dir") + "\\screenshots\\" + "ScrollLocator.png";
				test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
				pageDriver.getCurrentDriver().quit();
			}
		//--->Click Payment Method-CashOnDelivery	
		 try
			{
				if(!payMethod.isSelected())
				{
					payMethod.click();
					sleep(3000);
					test.pass("<p style=\"color:#29a329; font-size:14px\"><b>Successfully click on Cash-on-Delivery Method.</b></p>");
					@SuppressWarnings("unused")
					String screenshotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "PaymentMethodPass");
					String dest = System.getProperty("user.dir") + "\\screenshots\\" + "PaymentMethodPass.png";
					test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
				}
			}
			catch(Exception e)
			{
			test.fail("<p style=\"color:#ff3300; font-size:13px\"><b>PaymentMethod is not locateable.Please check the error message.</b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenShotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "PaymentMethodLocator");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "PaymentMethodLocator.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			Assert.assertTrue(!payMethod.isSelected());
			pageDriver.getCurrentDriver().quit();
			}
			//--->Click Condition	
		 try
			{
				if(!acceptCondition.isSelected())
				{
					acceptCondition.click();
					sleep(3000);
					test.pass("<p style=\"color:#29a329; font-size:14px\"><b>Successfully click on accept Condition.</b></p>");
					@SuppressWarnings("unused")
					String screenshotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "AcceptConditionPass");
					String dest = System.getProperty("user.dir") + "\\screenshots\\" + "AcceptConditionPass.png";
					test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
				}
			}
			catch(Exception e)
			{
			test.fail("<p style=\"color:#ff3300; font-size:13px\"><b>AcceptCondition is not locateable.Please check the error message.</b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenShotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "AcceptConditionLocator");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "AcceptConditionLocator.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			Assert.assertTrue(!acceptCondition.isSelected());
			pageDriver.getCurrentDriver().quit();
			}
	 }
	 
	 public void signout() throws IOException
	 {
		//--->Click profilemenu	
		 try
			{
				if(profileMenu.isDisplayed())
				{
					profileMenu.click();
					sleep(3000);
					test.pass("<p style=\"color:#29a329; font-size:14px\"><b>Successfully click on Profile Menu.</b></p>");
					@SuppressWarnings("unused")
					String screenshotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "ProfileMenuPass");
					String dest = System.getProperty("user.dir") + "\\screenshots\\" + "ProfileMenuPass.png";
					test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
				}
			}
			catch(Exception e)
			{
			test.fail("<p style=\"color:#ff3300; font-size:13px\"><b>ProfileMenu is not locateable.Please check the error message.</b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenShotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "ProfileMenuLocator");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "ProfileMenuLocator.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			Assert.assertTrue(profileMenu.isDisplayed());
			pageDriver.getCurrentDriver().quit();
			}
			//--->Click signOut	
		 try
			{
				if(signOut.isDisplayed())
				{	
					Actions act = new Actions(pageDriver.getCurrentDriver());
					act.moveToElement(signOut).perform();
					sleep(3000);
					signOut.click();
					sleep(3000);
					test.pass("<p style=\"color:#29a329; font-size:14px\"><b>Successfully SignOut.</b></p>");
					@SuppressWarnings("unused")
					String screenshotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "SignOutPass");
					String dest = System.getProperty("user.dir") + "\\screenshots\\" + "SignOutPass.png";
					test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
				}
			}
			catch(Exception e)
			{
			test.fail("<p style=\"color:#ff3300; font-size:13px\"><b>SignOut is not locateable.Please check the error message.</b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenShotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "SignOutLocator");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "SignOutLocator.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			Assert.assertTrue(signOut.isDisplayed());
			pageDriver.getCurrentDriver().quit();
			}
	 }
	 
	
}
