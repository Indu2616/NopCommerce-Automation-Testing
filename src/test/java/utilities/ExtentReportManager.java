package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
//import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener{
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName;
	
	public void onStart(ITestContext testContext) {
		
	    /*SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		  Date dt=new Date();
		  String currentdatetimestamp=df.format(dt); */
		
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //time stamp
		
		repName="Test-Report-" + timeStamp + ".html";
		sparkReporter = new ExtentSparkReporter(".\\reports\\" +repName); //specify location of the report
		     
		sparkReporter.config().setDocumentTitle("Opencart Automation Report"); //Title of the Report
		sparkReporter.config().setReportName("Opencart Functional Testing"); //Name of the Report
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Opencart");
		extent.setSystemInfo("Module", "Admin"); 
		extent.setSystemInfo("Sub Module", "Customers");
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		
		String os=testContext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);
		
		String browser=testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
		
		List<String> includedGroups=testContext.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty()) {
			extent.setSystemInfo("Groups", includedGroups.toString());
		}
	}
	
	public void onTestSuccess(ITestResult result) {
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getName()+" got successfully executed");
	}
	
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getName()+" got failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		try {
			String imgPath= new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName()+ "got Skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}
	
	public void onFinish(ITestContext textContext) {
		extent.flush();
		
		//To open the report automatically after xml file execution (optional)
		String PathOfExtentReport=System.getProperty("user.dir")+"\\reports\\"+repName;
		File extentReport=new File(PathOfExtentReport);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		/*To send the report to team  automatiocally through email
	
		  try{
		  URL url= new URL("file://"+System.getProperty("user.dir")+"\\reports\\"+repName);
		  
		  //create a email message -- add Apache commons email dependency in pom.xml
		  ImageHtmlEmail email=new ImagehtmlEmail();
		  email.setDataSourceResolver(new DataSourceURLResolver(url));
		  email.setHostName("smtp.googlemail.com");
		  email.setSmtpPort(123);
		  email.setAuthenticator(new DefaultAuthenticator("indugopathi2737@gmail.com", "password"));
		  email.setSSLOnConnect(true);
		  email.setFrom("indugopathi2737@gmail.com"); //sender
		  email.setSubject("Test Results");
		  email.setMsg("Please find Attached Report....");
		  email.addTo("indugopathi1234@gmail.com"); //Receiver
		  email.attach(url, "extent report", "Please check report...");
		  email.send(); //send the email
		  }
		  catch (Exception e) {e.printStackTrace();}	*/
	}
}
