package hybrid_app;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Hybrid_App.General_Capabilities;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class General_store extends General_Capabilities {
	
AndroidDriver<AndroidElement>driver;
	
	@BeforeTest
	public void bt() throws MalformedURLException {
		
		// I'm calling the cap method from the previous class by extending that class using extend method
		driver = cap(); // method name
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void tc() throws InterruptedException {
		
		System.out.println("General Store Opened");
		// From session I need to click
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();	
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Thailand\"))")).click();
     	driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Daisy");
     	driver.findElement(MobileBy.id("com.androidsample.generalstore:id/radioFemale")).click();
     	driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
     	driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(0).click();
     	driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(0).click();
     	driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
     	
     	Thread.sleep(3000);
     	String price1 = driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
     	System.out.println(price1);
     	Thread.sleep(3000);
     	
    	String price2 = driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
    	System.out.println(price2);
    	Thread.sleep(3000);
    	
    	String totalprice = driver.findElement(MobileBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
    	System.out.println(totalprice);
    	Thread.sleep(3000);
    	
    	String pt1 = price1.substring(1);
    	String pt2 = price2.substring(1);
    	String tp = totalprice.substring(1);
    	System.out.println(pt1);
    	System.out.println(pt2);
    	System.out.println(tp);
    	
    	double pro1 = Double.parseDouble(pt1);
    	double pro2 = Double.parseDouble(pt2);
    	double topr = Double.parseDouble(tp);
    	System.out.println(pro1);
    	System.out.println(pro2);
    	System.out.println(topr);
    	
    	Double total = pro1+pro2;
    	System.out.println(total);
    	if(total.equals(topr)) {
    		System.out.println("Costs are matching");
    	} else {
    		System.out.println("Costs are not matching");
    	}
    	
    	Assert.assertEquals(false, null);
    	
	}

}
