package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpage {

	public Loginpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
WebDriver driver;


By email=By.id("user_email");
By pwd=By.id("user_password");
By submitbtn=By.name("commit");


public WebElement Enterusername() {
	return driver.findElement(email);
	 
}
public WebElement Enterpwd() {
	return driver.findElement(pwd);
	 
}
public WebElement Clickonsubmit() {
	return driver.findElement(submitbtn);
	 
}
}
