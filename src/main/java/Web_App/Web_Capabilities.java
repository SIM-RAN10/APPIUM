package Web_App;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Web_Capabilities {
	
	//in this class i will give the desired capabilities
	public static AndroidDriver<AndroidElement> cap() throws MalformedURLException {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Sam");
		
		// here specified that i am using the android
		
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		
		dc.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		
		dc.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "C://Users//sharm//Downloads//chromedriver-win64//chromedriver.exe");
		
		dc.setCapability("appium:ChromeOptions", ImmutableMap.of("w3c",false));
		
		// for android we have android driver 
		// we have android element // here giving the information of the Appium by giving the host, portNumber and remotePath 
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		
		return driver; // So we can use this any class
		

		
	}

}
