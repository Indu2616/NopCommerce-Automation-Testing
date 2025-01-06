package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{
	
	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="input-firstname")
	WebElement txtbox_Firstname;
	
	@FindBy(id="input-lastname")
	WebElement txtbox_Lastname;
	
	@FindBy(id="input-email")
	WebElement txtbox_Email;
	
	@FindBy(id="input-telephone")
	WebElement txtbox_Telephone;
	
	@FindBy(id="input-password")
	WebElement txtbox_Password;
	
	@FindBy(id="input-confirm")
	WebElement txtbox_PasswordConfirm;

	@FindBy(name="agree")
	WebElement chkbox_Policy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btn_continue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	
	public void setFirstName(String fname) {
		txtbox_Firstname.sendKeys(fname);
	}
	public void setLastName(String lname) {
		txtbox_Lastname.sendKeys(lname);;
	}
	public void setEmail(String email) {
		txtbox_Email.sendKeys(email);;
	}
	public void setTelephone(String tel) {
		txtbox_Telephone.sendKeys(tel);;
	}
	public void setPassword(String pwd) {
		txtbox_Password.sendKeys(pwd);
	}
	public void setConfirmPassword(String pwd) {
		txtbox_PasswordConfirm.sendKeys(pwd);
	}
	public void setPrivacyPolicy() {
		chkbox_Policy.click();
	}
	public void clickContinue() {
		
		//solution - 1
		btn_continue.click();
		
		//solution - 2
		//btn_continue.submit();
		
		//solution - 3
		/*Actions act=new Actions(driver);
		act.moveToElement(btn_continue).click().perform(); */
		
		//solution - 4
		/*JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", btn_continue); */
		
		//solution - 5
		//btn_continue.sendKeys(Keys.RETURN);			- keyboard action
		
		//solution - 6
		/*WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.elementToBeClickable(btn_continue)).click();  */
		
	}
	
	public String getConfirmationMsg() {
		try {
			return(msgConfirmation.getText());
		}
		catch(Exception e) {
			return(e.getMessage());
		}
	}
	
}
