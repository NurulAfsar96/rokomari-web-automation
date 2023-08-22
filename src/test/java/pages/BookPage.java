package pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import drivers.pageDriver;
import utilities.CommonMethods;
import utilities.getScreenshot;

public class BookPage extends CommonMethods{
	ExtentTest test;
	//------------------------------->>> Constructor <<<---------------------------------------
	public BookPage(ExtentTest test)
		{	PageFactory.initElements(pageDriver.getCurrentDriver(), this);
		this.test = test;	
		}
	//--------------------------------->>> Locators <<<----------------------------------------

	@FindBy(xpath="//label[contains(text(),'সমকালীন উপন্যাস')]") 
	WebElement somokalinUponnas;
	
	@FindBy(xpath="//label[contains(text(),'পশ্চিমবঙ্গের বই: রহস্য, গোয়েন্দা, ভৌতিক, থ্রিলার ও')]") 
	WebElement thriller;
	
	@FindBy(xpath="//label[contains(text(),'উপন্যাস সমগ্র')]") 
	WebElement allUponnas;
	
	@FindBy(xpath="//a[contains(text(),'Next')]") 
	WebElement nextPage;
	
	@FindBy(xpath="//*[@id='cart-icon']")
	WebElement cartIcon;
	
	@FindBy(xpath="//p[contains(text(),'Shop by Categories')]")
	WebElement categoryText;
	
	@FindBys({
		@FindBy(xpath="//body/div[8]/div[1]/div[1]/div[1]/section[2]/div[2]/div[1]/div[1]/div[1]"),
		@FindBy(xpath="//h4[contains(text(),'সাতকাহন')]")	
	})
	
	WebElement satkahon;
	@FindBys({
	@FindBy(xpath="//body/div[8]/div[1]/div[1]/div[1]/section[2]/div[2]/div[1]/div[1]/div[1]/a[1]/div[1]/div[2]/button[1]")
	})
	WebElement addtoCart;
	
	//------------------------------->>> Methods <<<---------------------------------------
//~~~~~~~~~~~~~~~~~~filterCategory~~~~~~~~~~~~~~~~~~~~~~~
	public void filterCategory() throws IOException
	{
		try {
		JavascriptExecutor js = (JavascriptExecutor) pageDriver.getCurrentDriver();
		js.executeScript("window.scrollTo(0,500)");
		sleep(3000);
		}
		catch (Exception e)
		{
			test.fail("<p style=\"color:#ff3300; font-size:14px\"><b>Scroll not working. </b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenshotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "scrollLocator");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "scrollLocator.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			pageDriver.getCurrentDriver().quit();
		}
		try {
				if(!somokalinUponnas.isSelected()) 
				{
					somokalinUponnas.click();
					sleep(3000);
					test.pass("<p style=\"color:#29a329; font-size:14px\"><b>Successfully filter 'সমকালীন উপন্যাস'.</b></p>");
					@SuppressWarnings("unused")
					String screenshotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "UponnasPass");
					String dest = System.getProperty("user.dir") + "\\screenshots\\" + "UponnasPass.png";
					test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
				}
			} 
		catch (Exception e)
			{
			test.fail("<p style=\"color:#ff3300; font-size:14px\"><b>Uponnas is not locatable. </b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenshotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "UponnasLocator");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "UponnasLocator.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			Assert.assertTrue(somokalinUponnas.isDisplayed());
			pageDriver.getCurrentDriver().quit();
			}
	}
	
	//~~~~~~~~~~~~~~~~~~ScrollPage~~~~~~~~~~~~~~~~~~~~~~~
		public void scrollPage() throws IOException
		{
			try {
	
					JavascriptExecutor js = (JavascriptExecutor) pageDriver.getCurrentDriver();
					js.executeScript("window.scrollTo(0,4000)");
					sleep(3000);	
					test.pass("<p style=\"color:#29a329; font-size:14px\"><b>Successfully Scroll Down.</b></p>");
					@SuppressWarnings("unused")
					String screenshotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "ScrollDownPass");
					String dest = System.getProperty("user.dir") + "\\screenshots\\" + "ScrollDownPass.png";
					test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
				} 
			catch (Exception e)
				{
				test.fail("<p style=\"color:#ff3300; font-size:14px\"><b>Scroll Down Failed. </b></p>");
				Throwable t = new InterruptedException("Exception");
				test.fail(t);
				@SuppressWarnings("unused")
				String screenshotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "ScrollDown");
				String dest = System.getProperty("user.dir") + "\\screenshots\\" + "ScrollDown.png";
				test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
				pageDriver.getCurrentDriver().quit();
				}
		}
		//~~~~~~~~~~~~~~~~~~Go to Next Page~~~~~~~~~~~~~~~~~~~~~~~
		public void nextPage() throws IOException
		{
			try {
					if(nextPage.isDisplayed()) 
					{
					nextPage.click();
					sleep(3000);	
					test.pass("<p style=\"color:#29a329; font-size:14px\"><b>Successfully go to Next Page.</b></p>");
					@SuppressWarnings("unused")
					String screenshotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "NextPagePass");
					String dest = System.getProperty("user.dir") + "\\screenshots\\" + "NextPagePass.png";
					test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
					}
				} 
			catch (Exception e)
				{
				test.fail("<p style=\"color:#ff3300; font-size:14px\"><b>NextPage is not locatable. </b></p>");
				Throwable t = new InterruptedException("Exception");
				test.fail(t);
				@SuppressWarnings("unused")
				String screenshotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "NextPageLocator");
				String dest = System.getProperty("user.dir") + "\\screenshots\\" + "NextPageLocator.png";
				test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
				Assert.assertTrue(nextPage.isDisplayed());
				pageDriver.getCurrentDriver().quit();
				}
		}
		
		//~~~~~~~~~~~~~~~~~~Go to Previuos Page~~~~~~~~~~~~~~~~~~~~~~~
		public void previousPage() throws IOException
		{
			try {	JavascriptExecutor js =(JavascriptExecutor) pageDriver.getCurrentDriver();
					pageDriver.getCurrentDriver().navigate().back();
					sleep(3000);
					//js.executeScript("window.scrollBy(0,-3500)", "");
					js.executeScript("window.scrollBy(0,-3600)");
					sleep(3000);
					test.pass("<p style=\"color:#29a329; font-size:14px\"><b>Successfully go to Previous Page.</b></p>");
					@SuppressWarnings("unused")
					String screenshotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "PreviousPagePass");
					String dest = System.getProperty("user.dir") + "\\screenshots\\" + "PreviousPagePass.png";
					test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
					
				} 
			catch (Exception e)
				{
				test.fail("<p style=\"color:#ff3300; font-size:14px\"><b>PreviousPage is not locatable. </b></p>");
				Throwable t = new InterruptedException("Exception");
				test.fail(t);
				@SuppressWarnings("unused")
				String screenshotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "PreviousPageLocator");
				String dest = System.getProperty("user.dir") + "\\screenshots\\" + "NextPageLocator.png";
				test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
				Assert.assertTrue(nextPage.isDisplayed());
				pageDriver.getCurrentDriver().quit();
				}
		}
		
		//~~~~~~~~~~~~~~~~~~Click cart Icon~~~~~~~~~~~~~~~~~~~~~~~
				public void addtoCart() throws IOException
				{
					try {
							if(satkahon.isDisplayed()) 
							{ Actions act = new Actions(pageDriver.getCurrentDriver());
							act.moveToElement(satkahon).perform();
							sleep(2000);
							act.moveToElement(addtoCart).perform();
							sleep(2000);
							addtoCart.click();
							sleep(3000);	
							test.pass("<p style=\"color:#29a329; font-size:14px\"><b>Successfully hover over Book and Added to Cart.</b></p>");
							@SuppressWarnings("unused")
							String screenshotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "addcartPass");
							String dest = System.getProperty("user.dir") + "\\screenshots\\" + "addcartPass.png";
							test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
							}
						} 
					catch (Exception e)
						{
						test.fail("<p style=\"color:#ff3300; font-size:14px\"><b>addcart is not locatable. </b></p>");
						Throwable t = new InterruptedException("Exception");
						test.fail(t);
						@SuppressWarnings("unused")
						String screenshotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "addcartLocator");
						String dest = System.getProperty("user.dir") + "\\screenshots\\" + "addcartLocator.png";
						test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
						Assert.assertTrue(satkahon.isDisplayed());
						pageDriver.getCurrentDriver().quit();
					
						}
				}
				
				public void clickCartIcon() throws IOException
				{
					
					try {		
							if(cartIcon.isDisplayed()) 
							{
							cartIcon.click();
							sleep(3000);	
							test.pass("<p style=\"color:#29a329; font-size:14px\"><b>Successfully click CartIcon.</b></p>");
							@SuppressWarnings("unused")
							String screenshotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "CartIconPass");
							String dest = System.getProperty("user.dir") + "\\screenshots\\" + "CartIconPass.png";
							test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
							}
						} 
					catch (Exception e)
						{
						test.fail("<p style=\"color:#ff3300; font-size:14px\"><b>CartIcon is not locatable. </b></p>");
						Throwable t = new InterruptedException("Exception");
						test.fail(t);
						@SuppressWarnings("unused")
						String screenshotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "CartIconLocator");
						String dest = System.getProperty("user.dir") + "\\screenshots\\" + "CartIconLocator.png";
						test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
						Assert.assertTrue(cartIcon.isDisplayed());
						pageDriver.getCurrentDriver().quit();
						}
					
				}

}
