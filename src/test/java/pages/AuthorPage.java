package pages;

import java.io.IOException;

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

public class AuthorPage extends CommonMethods{
	
	ExtentTest test;
	//---------------------------------->>> Constructor <<<-----------------------------------------------
	public AuthorPage(ExtentTest test)
	{
		PageFactory.initElements(pageDriver.getCurrentDriver(), this);
		this.test = test;
	}
	//----------------------------------->>> Locators <<<----------------------------------------------------
	@FindBys({
		@FindBy(xpath="//a[@id='js--authors']")
	})
	WebElement  author;
	
	@FindBys({
		@FindBy(xpath="//a[contains(text(),'সমরেশ মজুমদার')]")
	})
	WebElement  selectAuthor;
	
	//----------------------------------->>> Methods <<<----------------------------------------------------
//--------------> Select Author Method <--------------------------
		 
	public void selectAuthor() throws IOException, InterruptedException {
		Actions action = new Actions(pageDriver.getCurrentDriver());
		try{

			if(author.isDisplayed()) {		
				
				action.moveToElement(author).perform();	
				sleep();
				action.moveToElement(selectAuthor).perform();	
				sleep(2000);
				selectAuthor.click();
				sleep();
				
				test.pass("<p style=\"color:#29a329; font-size:14px\"><b>You have successfully Selected Author.</b></p>");
				@SuppressWarnings("unused")
				String screenShotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "writer");
				String dest = System.getProperty("user.dir") + "\\screenshots\\" + "writer.png";
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			}
		}catch(Exception e){
			test.fail("<p style=\"color:#ff3300; font-size:13px\"><b>Writer is not locateable.Please check the error message.</b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenShotPath = getScreenshot.capture(pageDriver.getCurrentDriver(), "writerLocator");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "writerLocator.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			Assert.assertTrue(author.isDisplayed());
			pageDriver.getCurrentDriver().quit();
		}
		
	}
	

}
