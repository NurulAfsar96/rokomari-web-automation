package utilities;

import drivers.baseDriver;

public class CommonMethods extends baseDriver {

		public static void sleep() throws InterruptedException
		{
			Thread.sleep(5000);
		}
		
		public static void sleep(int time) throws InterruptedException
		{
			Thread.sleep(time);
		}

}
