package DemoPackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import pageObjectRepo.LandingPage;
import pageObjectRepo.Pref_menu_2;
import resources.baseClass;


public class TC_01Test extends baseClass {

	
	@Test
	public void ClickTest() throws IOException
	{
		LandingPage lp=new LandingPage(driver);
		Pref_menu_2 menu2 = new Pref_menu_2(driver);
		lp.preferences.click();
		menu2.pref_dependencies.click();

	}
	
//	@AfterTest
//	public void closeDriver()
//	{
//		driver.resetApp();
//		driver = null;
//	}
}
