package Academy.E2Eflow;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class base {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
	}
		public WebDriver driver;
		public Properties prop;
		
		
		
		public WebDriver Initializedriver() throws IOException {
		 prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		//System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties";
		prop.load(fis);
		
	String browsername=prop.getProperty("browser");
	if(browsername.contains("chrome")) {
		System.setProperty("webdriver.chrome.driver","C:\\Automation\\chromedriver.exe");
		ChromeOptions option=new ChromeOptions();
		if(browsername.contains("headless"))
		{
		option.addArguments("headless");
		}
		driver=new ChromeDriver(option);
	}
	return driver;
	}

		public String getScreenshots(String testcasename, WebDriver driver) throws IOException
		{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String destfile=System.getProperty("user.dir")+"\\Screenshots\\"+testcasename+".png";
		FileUtils.copyFile(src,new File(destfile));
		return destfile;
		}
}

