package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC001_RegistrationTest extends BaseClass{
	
	@Test(groups={"Regression", "Master"})
	public void verify_Account_Registration() {
		
		logger.info("****Starting TC001_RegistrationTest Case*****");
		
		try{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link");
		
		hp.clickRegister();
		logger.info("Clicked on Register Link");
		
		logger.info("Providing Customer Details");
		RegistrationPage regPage=new RegistrationPage(driver);
		regPage.setFirstName(randomString().toUpperCase());
		regPage.setLastName(randomString().toUpperCase());
		regPage.setEmail(randomString()+"@gmail.com");
		regPage.setTelephone(randomNumber());
		
		String password=randomAlphanumeric();
		regPage.setPassword(password);
		regPage.setConfirmPassword(password);
		regPage.setPrivacyPolicy();
		regPage.clickContinue();
		
		logger.info("Validating Expected Message");
		String confirmmsg=regPage.getConfirmationMsg();
		if(confirmmsg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}
		else {
			logger.error("Test Failed");
			logger.debug("Debug logs...");
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(confirmmsg, "Your Account Has Been Created!");
		}
		
		catch(Exception e) {
			Assert.fail();
		}
	
		logger.info("*******Finished TC001_RegistrationTest*****");
		
	}
}
