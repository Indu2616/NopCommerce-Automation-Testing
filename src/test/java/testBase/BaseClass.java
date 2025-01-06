package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.apache.logging.log4j.Logger;		//log4j		
import org.apache.logging.log4j.LogManager;	//log4j


public class BaseClass {

public static WebDriver driver;
public Logger logger;		//log4j	
public Properties prop;		//Properties file	

	@BeforeClass(groups= {"Master", "Sanity", "Regression"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException {
		
		//Reading the Properties file
		FileReader file=new FileReader("./src//test//resources//config.properties");
		prop=new Properties();
		prop.load(file);
		
		//Loggers
		logger=LogManager.getLogger(this.getClass());	//log4j
		
		//Browser setup
		switch(br.toLowerCase()) {
		case "chrome": driver=new ChromeDriver(); break;
		case "edge":   driver=new EdgeDriver();	  break;
		case "firefox":driver=new FirefoxDriver();break;
		default: System.out.println("Invalid browser name.."); return;
		}
		driver.manage().deleteAllCookies();    //deletes all the cookies history
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("appURL"));
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups= {"Master", "Sanity", "Regression"})
	public void tearDown() {
		driver.quit();
	}
	
	public String randomString() {
		String generatedString=RandomStringUtils.randomAlphabetic(6);
		return(generatedString);
	}
	
	public String randomNumber() {
		String generatedNumbers=RandomStringUtils.randomNumeric(10);
		return(generatedNumbers);
	}
	
	public String randomAlphanumeric() {
		String generatedString=RandomStringUtils.randomAlphabetic(3);
		String generatedNumbers=RandomStringUtils.randomNumeric(3);
		return(generatedString+"@*"+generatedNumbers);
	}
	
	
	public String captureScreen(String tname)throws IOException{
		
		String timeStamp= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
		File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" +tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
	}
	
}
