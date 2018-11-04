package DemoPackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import pageObjectRepo.LandingPage;
import pageObjectRepo.Pref_menu_2;
import resources.baseClass;

public class TC_02Test extends baseClass {


	@Test
	public void Validations() throws IOException
	{
		LandingPage lp=new LandingPage(driver);
		Pref_menu_2 menu2 = new Pref_menu_2(driver);
		lp.preferences.click();
		
		// Check whether text "Preference dependencies" is present on this screen or not
		Assert.assertTrue(menu2.pref_dependencies.isDisplayed());
		
		// Check whether text "Preference dependencies" is correct as per requirement. Using assertion		
		Assert.assertEquals(menu2.pref_dependencies.getText(), "3. Preference dependencies");

	}
	
}
