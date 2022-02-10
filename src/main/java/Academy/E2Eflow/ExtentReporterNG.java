package Academy.E2Eflow;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
public static ExtentReports extent;
	public static ExtentReports getExtentReport() {
		
		String path=System.getProperty("user.dir")+"\\extentreports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Reports");
		reporter.config().setDocumentTitle("Test Results of Framework");
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Govarthini");
		
		return extent;
	}

}
