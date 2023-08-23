package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import drivers.pageDriver;
import utilities.CommonMethods;
import utilities.getScreenshot;

public class LoginPage extends CommonMethods{
	ExtentTest test;
	public LoginPage(ExtentTest test) {
		PageFactory.initElements(pageDriver.getCurrentDriver(), this);
		this.test = test;
	}
   //------------------>>> Locators <<<---------------------------------
	@FindBy(xpath="//body/div[@id='login-registration']/div[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[1]/input[2]") 
	WebElement phone;
	@FindBy(xpath="//body/div[@id='login-registration']/div[1]/section[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/input[1]") 
	WebElement password;
	@FindBy(xpath="//button[@id='js--btn-next']") 
	WebElement nextbtn;
	@FindBy(xpath="//body/div[@id='login-registration']/div[1]/section[1]/div[1]/div[2]/div[2]/form[1]/button[1]") 
	WebElement loginbtn;
	
	//------------------>>> Methods <<<---------------------------------
	
	public void login() throws IOException
	{
		try
		{
			if(phone.isDisplayed())
			{
				phone.sendKeys("01614735074");
				sleep(3000);
				test.pass("<p style=\"color:#29a329; font-size:14px\"><b>Successfully input Phone Number.</b></p>");
				@SuppressWarnings("unused")
				String screenshotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "InputPhonePass");
				String dest = System.getProperty("user.dir") + "\\screenshots\\" + "InputPhonePass.png";
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			}
		}
		catch (Exception e)
		{
			test.fail("<p style=\"color:#ff3300; font-size:14px\"><b>Phone Number field is not locatable. </b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenshotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "PhoneLocator");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "PhoneLocator.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			Assert.assertTrue(phone.isDisplayed());
			pageDriver.getCurrentDriver().quit();
		}
		try
		{
			if(nextbtn.isDisplayed())
			{
				nextbtn.click();
				sleep(2000);
				test.pass("<p style=\"color:#29a329; font-size:14px\"><b>Successfully Click Next.</b></p>");
				@SuppressWarnings("unused")
				String screenshotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "ClickNextPass");
				String dest = System.getProperty("user.dir") + "\\screenshots\\" + "ClickNextPass.png";
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			}
		}
		catch (Exception e)
		{
			test.fail("<p style=\"color:#ff3300; font-size:14px\"><b>Next button is not locatable. </b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenshotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "ClickNextLocator");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "ClickNextLocator.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			Assert.assertTrue(nextbtn.isDisplayed());
			pageDriver.getCurrentDriver().quit();
		}
		try
		{
			if(password.isDisplayed())
			{
				password.sendKeys("test@123");
				sleep(3000);
				test.pass("<p style=\"color:#29a329; font-size:14px\"><b>Successfully input Password.</b></p>");
				@SuppressWarnings("unused")
				String screenshotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "InputPasswordPass");
				String dest = System.getProperty("user.dir") + "\\screenshots\\" + "InputPasswordPass.png";
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			}
		}
		catch (Exception e)
		{
			test.fail("<p style=\"color:#ff3300; font-size:14px\"><b>Password field is not locatable. </b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenshotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "PasswordLocator");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "PasswordLocator.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			Assert.assertTrue(password.isDisplayed());
			pageDriver.getCurrentDriver().quit();
		}
		try
		{
			if(loginbtn.isDisplayed())
			{
				loginbtn.click();
				sleep(3000);
				test.pass("<p style=\"color:#29a329; font-size:14px\"><b>Successfully Click Login button.</b></p>");
				@SuppressWarnings("unused")
				String screenshotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "ClickLoginPass");
				String dest = System.getProperty("user.dir") + "\\screenshots\\" + "ClickLoginPass.png";
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			}
		}
		catch (Exception e)
		{
			test.fail("<p style=\"color:#ff3300; font-size:14px\"><b>Login button is not locatable. </b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenshotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "ClickLoginLocator");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "ClickLoginLocator.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			Assert.assertTrue(loginbtn.isDisplayed());
			pageDriver.getCurrentDriver().quit();
		}
	}
}
