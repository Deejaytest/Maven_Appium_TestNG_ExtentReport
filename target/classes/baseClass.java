package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;


public class baseClass {
	public static AndroidDriver driver;
	public static Properties prop;
	public static Logger log = (Logger) LogManager.getLogger(baseClass.class.getName());

	@BeforeSuite
	public static AndroidDriver InitialiseDriver() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\c-deepak.jindal\\E2EFramework\\src\\main\\java\\resources\\reusablProperties.properties");
		prop.load(fis);
		log.info("Properties file loaded");
		
		File f= new File("src");
		File fs = new File(f,prop.getProperty("APKName"));
		
		log.info("Initialising Driver");
		DesiredCapabilities Cap = new DesiredCapabilities();
		Cap.setCapability(MobileCapabilityType.PLATFORM, prop.getProperty("platform"));
		Cap.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("deviceName"));
		Cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),Cap);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		log.info("Driver initialised");

		return driver;
	
	}
	
	public void getScreenshot(String result) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C://test//"+result+"screenshot.png"));
		
	}

	@AfterSuite
	public void tearDown() throws InterruptedException, IOException {

		driver.quit();
	}
}
