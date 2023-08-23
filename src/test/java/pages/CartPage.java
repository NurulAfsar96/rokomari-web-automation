package pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import drivers.pageDriver;
import utilities.CommonMethods;
import utilities.getScreenshot;

public class CartPage extends CommonMethods {
	ExtentTest test;
	public CartPage(ExtentTest test)
	{
		PageFactory.initElements(pageDriver.getCurrentDriver(), this);
		this.test = test;
	}
	
	//------------------------------------------->>> Locators <<<-------------------------------------------
	@FindBy(xpath="//body/div[@id='cart-page']/div[1]/div[1]/div[1]/section[3]/div[1]/div[1]/div[1]/div[1]/label[1]") 
	WebElement checkbox;

	@FindBy(xpath="//a[@id='js-continue-to-shipping']") 
	WebElement placeOrderBtn;
	
	@FindBy(xpath="//body/div[@id='cart-page']/div[1]/div[1]/div[1]/div[2]/div[1]/a[2]/span[1]") 
	WebElement placeOrder;
	//body/div[@id='cart-page']/div[1]/div[1]/div[1]/div[2]/div[1]/a[2]/span[1]
	
	//------------------------------------------->>> Methods <<<-------------------------------------------
	
	public void checkBook() throws IOException
	{
		try
		{	
				JavascriptExecutor js = (JavascriptExecutor) pageDriver.getCurrentDriver();
				js.executeScript("window.scrollBy(0,500)");
				sleep(3000);
				test.pass("<p style=\"color:#29a329; font-size:14px\"><b>Scroll to Place Order.</b></p>");
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
	}
	
	public void placeorder() throws IOException
	{
		try
		{	if(placeOrderBtn.isDisplayed())
				{
				Actions act = new Actions(pageDriver.getCurrentDriver());
				act.moveToElement(placeOrderBtn).perform();
				sleep(3000);
				act.moveToElement(placeOrder).perform();
				placeOrder.click();
				sleep(3000);
				test.pass("<p style=\"color:#29a329; font-size:14px\"><b>Place Order is Clickable.</b></p>");
				@SuppressWarnings("unused")
				String screenshotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "PlaceOrderPass");
				String dest = System.getProperty("user.dir") + "\\screenshots\\" + "PlaceOrderPass.png";
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
				}
		}
		catch(Exception e)
		{
			test.fail("<p style=\"color:#ff3300; font-size:13px\"><b>PlaceOrder is not locateable.Please check the error message.</b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenShotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "PlaceOrderLocator");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "PlaceOrderLocator.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			Assert.assertTrue(placeOrderBtn.isDisplayed());
			pageDriver.getCurrentDriver().quit();
		}
	}	
}
