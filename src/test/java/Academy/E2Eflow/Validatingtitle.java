package Academy.E2Eflow;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pageObject.LandingPage;

public class Validatingtitle extends base {

	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	public ExtentReports extent;
	@BeforeTest
	public void reportconfig() throws IOException
	{
		String path=System.getProperty("user.dir")+"\\extentreports\\index.html";
		ExtentSparkReporter report=new ExtentSparkReporter(path);
		report.config().setReportName("Web Automation");
		report.config().setDocumentTitle("Test Result");
		
		extent=new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Tester", "Govarthini");
		
		
	}
	@Test
	public void test2() throws IOException {
		extent.createTest("Initial Demo");
		driver=Initializedriver();
		log.info("Driver Initialized");
		driver=Initializedriver();
		driver.get(prop.getProperty("url"));
		LandingPage sign=new LandingPage(driver);
		log.info("driver opened successfully");
		Assert.assertEquals(sign.getfeaturedtext().getText(), "FEATURED COURSES");
		System.out.println();
		extent.flush();
		
	}
	@AfterTest
	public void closebrowser()
	{
		driver.close();
		log.info("Driver closed cccccccccccccccccccccccccccccccccccc");
	}

}
