package Academy.E2Eflow;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.Loginpage;

public class homepage extends base {

	private static final OutputType OutputType = null;
	private static final String FILE = null;
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=Initializedriver();
		log.info("Driver Initialized");
	}
	
	@Test(dataProvider="getdata")
	public void test1(String Username,String password,String text) throws IOException {
		
		driver.get(prop.getProperty("url"));
		LandingPage sign=new LandingPage(driver);
		Loginpage login=sign.getlogin();
		//Loginpage login=new Loginpage(driver);
		login.Enterusername().sendKeys(Username);
		log.info("User name entered successfully...uuuuuuuuuuu");
		login.Enterpwd().sendKeys(password);
		System.out.println(text);
		login.Clickonsubmit().click();
		
		
		
	}
	@AfterTest
	public void closebrowser()
	{
		driver.close();
		log.info("Driver closed cccccccccccccccccccccccccccccccccccc");
	}
	@DataProvider
	public Object[][] getdata() {
		Object[][] data=new Object[2][3];
		data[0][0]="norestricteduser@gm.com";
		data[0][1]="pwdrrr";
		data[0][2]="Restricted user";
		
		data[1][0]="restricteduser@gm.com";
		data[1][1]="pwdsse";
		data[1][2]="Non Restricted user";  
		return data;
	}
	


}
