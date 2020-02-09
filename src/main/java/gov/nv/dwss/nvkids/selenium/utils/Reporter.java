package gov.nv.dwss.nvkids.selenium.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.TimeZone;

import javax.imageio.ImageIO;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;
import org.w3c.dom.Document;
import org.w3c.dom.css.DocumentCSS;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public abstract class Reporter {
	
	public static RemoteWebDriver driver=null;
	
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentTest logger;
	
	public String testcaseName, testcaseDec, author ; 
	
	public int testcasenumb;
	
	
	
	public String category="";
	public static  String excelFileName;
	public static String extentreportpath;
	
	@BeforeSuite
	public void startReport(ITestContext c) throws IOException 
	{
		String reportName=this.getClass().getName().substring(29, 33).toUpperCase() +" Screen Test Report";
		String screenName=this.getClass().getName().substring(29, 33).toUpperCase() +" Tests";
		String rptName="h5{font-size: 0px;}h5::after{content:\'"+screenName+"\';font-size: 1.64rem; line-height: 110%;margin: 0.82rem 0 0.656rem 0;}";
		String suiteName = c.getCurrentXmlTest().getSuite().getName();
        if (suiteName.contains("Default suite")||suiteName.contains("Failed suite"))
        suiteName ="";
        extentreportpath="./reports/"+suiteName+"Report.html";
		reporter = new ExtentHtmlReporter(extentreportpath);
		reporter.setAppendExisting(true); 		
		extent   = new ExtentReports();	
		extent.attachReporter(reporter);
		reporter.loadXMLConfig(new File("./Resources/extent-config.xml"));
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		reporter.config().setReportName(reportName);
		reporter.config().setCSS(rptName);
		}
	
    
	public void report()  
	{
		Capabilities browserCap = driver.getCapabilities();
		String browserName = browserCap.getBrowserName();
		String browserVersion = browserCap.getVersion();
		String osname= System.getProperty("os.name");
		String osversion= System.getProperty("os.version");
		String osarch= System.getProperty("os.arch");
		//get Calendar instance
	    Calendar now = Calendar.getInstance();
	    //get current TimeZone using getTimeZone method of Calendar class
	    TimeZone timeZone = now.getTimeZone();
	    String executionLocation =timeZone.getDisplayName();
		test = extent.createTest(testcaseName, testcaseDec+" <br /><br />OS Name: "+osname + ", OS Version: "
				+ ""+osversion+", OS Architecture: "+osarch+" <br />Browser Name: "+browserName+" "
						+ ", Browser Version: "+browserVersion+ "<br />Execution TimeZone: "+executionLocation);
	    test.assignAuthor(author);
	    test.assignCategory(category);  
	}
	
	
    
    public abstract long takeSnap();
	
	public void reportStep(String desc,String status,boolean bSnap)
	{
		MediaEntityModelProvider img=null;
		if(bSnap && !status.equalsIgnoreCase("INFO"))
		{
			long snapNumber=100000L;
			snapNumber=takeSnap();
			try
			{
				img=MediaEntityBuilder.createScreenCaptureFromPath("./../reports/images/"+snapNumber+".jpg").build();
			}
			catch(IOException e)
			{
				
			}
		}
		if(status.equalsIgnoreCase("pass"))
		{
			//test.pass(desc,img);
			test.log(Status.PASS, desc, img);
			
		}
		else if(status.equalsIgnoreCase("fail"))
		{
		
			//test.fail(desc,img);
			
			test.log(Status.FAIL, desc, img);
		}
		else if(status.equalsIgnoreCase("INFO"))
		{
			//test.pass(desc);
			test.log(Status.INFO, desc,img);
		}
	}
	
	public void reportStep(String desc,String status)
	{
	
		reportStep(desc,status,true);
	}
	
	
    @AfterSuite
    public void stopReport() throws Exception 
    {
      	extent.flush();
    }
}














