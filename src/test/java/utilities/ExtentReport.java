package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	public static final ExtentReports report = new ExtentReports();
	
	public synchronized static ExtentReports getInstance()
	{
		ExtentSparkReporter reporter = new ExtentSparkReporter("./report/TestReport.html");
		reporter.config().setReportName("Rokomari.com Test Report");
		report.attachReporter(reporter);
		return report;
	
	}
}
