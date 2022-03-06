package tests;
import java.net.URL;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;

// This project is to open a chrome browser and open google link

public class BaseClass  {
	
	AppiumDriver<WebElement> driver;
	
	@BeforeTest
	public void setup() {
		try{
		DesiredCapabilities caps = new DesiredCapabilities();
		//caps.setCapability("platformName", "ANDRIOD");
		caps.setCapability(CapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4 API 30");
		//caps.setCapability(MobileCapabilityType.DEVICE_NAME, "vivo 1920");
		//caps.setCapability(MobileCapabilityType.UDID, "dce21caf");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
		caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		caps.setCapability(CapabilityType.VERSION, "83"); //this is for emulator
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<WebElement>(url,caps);
		driver.get("https://www.google.com");
		}
	
		catch(Exception exp) {
		System.out.println("cause is " +exp.getCause());	
		System.out.println("Message is " +exp.getMessage());
		exp.printStackTrace();
	    }
	}	
	
	@Test
	public void sampletest() throws MalformedURLException {
		System.out.println("I am inside sampletest");
	}
@AfterTest
	public void teardown() {
		}
}
