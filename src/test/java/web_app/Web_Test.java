package web_app;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Web_App.Web_Capabilities;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Web_Test extends Web_Capabilities{
	
	
	AndroidDriver<AndroidElement>driver;
	
	@BeforeTest
	public void bt() throws MalformedURLException {
		
		// I'm calling the cap method from the previous class by extending that class using extend method
		driver = cap(); // method name
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void t1() {
		
		System.out.println("I'm in");
		
		driver.get("https://www.google.com/");
		
		driver.findElement(MobileBy.cssSelector("[class='gLFyf']")).sendKeys("Masai", Keys.ENTER);
		
	}
	         
	

}
