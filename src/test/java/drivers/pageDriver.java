package drivers;

import org.openqa.selenium.WebDriver;

public class pageDriver {
	
	public static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
	public static pageDriver pdriver = null; //create an instance for pageDriver class;
	
	private pageDriver() {} //constructor
	
	public static pageDriver getInstance()
	{
		if(pdriver == null) { pdriver = new pageDriver(); }
		return pdriver;
	}
	
	public WebDriver getDriver()
	{
		return webDriver.get();	
	}
	
	public void setDriver(WebDriver driver)
	{
		webDriver.set(driver);
	}
	
	public static WebDriver getCurrentDriver()
	{
		return getInstance().getDriver();
	}


}
