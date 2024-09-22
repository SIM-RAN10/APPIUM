package nativeApp;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import javax.annotation.Tainted;

import org.apache.commons.validator.Msg;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

// static import for long press
import  static io.appium.java_client.touch.LongPressOptions.longPressOptions;
// static import for element
import static io.appium.java_client.touch.offset.ElementOption.element;
// static import for time
import static java.time.Duration.ofSeconds;

public class ApiDemo extends Capibilities {
	
	AndroidDriver<AndroidElement>driver;
	
	@BeforeTest
	public void bt() throws MalformedURLException {
		
		// I'm calling the cap method from the previous class by extending that class using extend method
		driver = cap(); // method name
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void tc() {
		
		System.out.println("Api Demo Opened");
		// From session I need to click
		driver.findElement(MobileBy.AccessibilityId("Accessibility")).click();		
		driver.findElement(MobileBy.AccessibilityId("Accessibility Node Provider")).click();
	}
	
	@Test
	public void prefernce() throws InterruptedException {
		
		driver.findElement(MobileBy.AccessibilityId("Preference")).click();
		driver.findElement(MobileBy.AccessibilityId("3. Preference dependencies")).click();
		driver.findElement(MobileBy.id("android:id/checkbox")).click();
		// many ways to use text
		// to use the text we need two things if we have to click on anything using text attribute
		// 1. AndroidUIAutomator 2. UISelector
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"WiFi settings\")")).click();
		driver.findElement(MobileBy.id("android:id/edit")).sendKeys("Simran");
		driver.hideKeyboard();
		driver.findElement(MobileBy.id("android:id/button2")).click();
		// now for going back 
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(5000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
	
	@Test
	public void notifications() {
		
		driver.openNotifications();
		driver.findElements(MobileBy.className("android.widget.ImageView")).get(4).click();
		driver.findElements(MobileBy.className("android.widget.ImageView")).get(4).click();
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
	}
	
	@Test
	public void scrolll() {
		
		// we need three things for scroll
//		1. UIscrollable 2. UIselector 3. scrollIntoView
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))")).click(); 
		
	}
	
	@Test
	public void longgpress() {
		
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		driver.findElement(MobileBy.AccessibilityId("Expandable Lists")).click();
		driver.findElement(MobileBy.AccessibilityId("1. Custom Adapter")).click();
		AndroidElement dog = driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Dog Names\")"));
		// long press comes under what?? --- Touch & Tap
		TouchAction tA = new TouchAction(driver);
		tA.longPress(longPressOptions().withElement(element(dog)).withDuration(ofSeconds(3))).release().perform();
		
	}
	
	@Test
	public void swipee() {
		
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		driver.findElement(MobileBy.AccessibilityId("Date Widgets")).click();
		driver.findElement(MobileBy.AccessibilityId("2. Inline")).click();
		AndroidElement ele1 = driver.findElement(MobileBy.AccessibilityId("12"));
		AndroidElement ele2 = driver.findElement(MobileBy.AccessibilityId("6"));
		TouchAction tA = new TouchAction(driver);
		tA.longPress(longPressOptions().withElement(element(ele1)).withDuration(ofSeconds(3))).moveTo(element(ele2)).release().perform();
		
	}
	
	@Test
	public void dragdrop() {
		
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		driver.findElement(MobileBy.AccessibilityId("Drag and Drop")).click();
		AndroidElement ele1 = driver.findElement(MobileBy.id("io.appium.android.apis:id/drag_dot_1"));
		AndroidElement ele2 = driver.findElement(MobileBy.id("io.appium.android.apis:id/drag_dot_2"));
		TouchAction tA = new TouchAction(driver);
		tA.longPress(longPressOptions().withElement(element(ele1)).withDuration(ofSeconds(3))).moveTo(element(ele2)).release().perform();
		
	}
	
	@Test
	public void switchapp() throws InterruptedException {
		
		driver.findElement(MobileBy.AccessibilityId("OS")).click();
		driver.findElement(MobileBy.AccessibilityId("SMS Messaging")).click();
		driver.findElement(MobileBy.AccessibilityId("Enable SMS broadcast receiver")).click();
		driver.findElement(By.id("io.appium.android.apis:id/sms_recipient")).sendKeys("(650)555-1212");
		driver.findElement(By.id("io.appium.android.apis:id/sms_content")).sendKeys("Anneyong");
		driver.hideKeyboard();
		driver.findElement(MobileBy.AccessibilityId("Send")).click();
		driver.activateApp("com.google.android.apps.messaging");
		Thread.sleep(5000);
		String Msg = driver.findElement(MobileBy.id("com.google.android.apps.messaging:id/conversation_snippet")).getText();
		System.out.println(Msg);
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		System.out.println("Native App Testing Done.");
		
		
		
	}

}
