package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	WebDriver driver;

	private By sigin=By.cssSelector("a[href*='sign_in']");
	private By title=By.cssSelector(".text-center");
	
	public Loginpage getlogin() {
		 driver.findElement(sigin).click();
		 Loginpage login=new Loginpage(driver);
		 return login;
		 
	}
	public WebElement getfeaturedtext() {
		return driver.findElement(title);
		 
	}
}
