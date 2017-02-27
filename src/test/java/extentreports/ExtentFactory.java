package extentreports;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {
	public static ExtentReports getInstance()
	{
		ExtentReports extent;
		String path = "/Users/megharastogi/Desktop/reports/report-demo.html";
		extent = new ExtentReports(path, false);
		extent.addSystemInfo("Selenium Version", "3.5.2");
		extent.addSystemInfo("Platform", "Mac");
		
		return extent;
	}

}
