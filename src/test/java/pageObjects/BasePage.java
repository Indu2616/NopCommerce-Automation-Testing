package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
													//BasePage concept - to achieve the reusability
public class BasePage {								//class

	WebDriver driver;								//variable
	
	public BasePage(WebDriver driver) {				//constructor
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
}
