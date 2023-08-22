package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseDriver {
	
	public static String url = "https://www.rokomari.com/book";
	WebDriver driver = null;
	@BeforeSuite
	public void start()
	{
		String browser = System.getProperty("browser","chrome");
		
		if(browser.contains("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		else if(browser.contains("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		else if(browser.contains("explorer"))
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		
		else
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
pageDriver.getInstance().setDriver(driver);
		
	}
	
	@AfterSuite
	public void close()
	{
		pageDriver.getCurrentDriver().quit();
	}

}

