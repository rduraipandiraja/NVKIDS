package gov.nv.dwss.nvkids.selenium.api.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import gov.nv.dwss.nvkids.selenium.api.design.Browser;
import gov.nv.dwss.nvkids.selenium.api.design.Element;
import gov.nv.dwss.nvkids.selenium.utils.ReadPropertyFile;
import gov.nv.dwss.nvkids.selenium.utils.Reporter;


public class SeleniumBase extends Reporter implements Browser, Element {

	public Properties prop = new Properties();
	public static WebDriverWait wait;
	public SoftAssert softAssert;
	public ExtentReports extent;
	ExtentTest logger; 
	public String hubIPAddress;

	@BeforeClass
	public void beforeclass() throws FileNotFoundException, IOException
	{
		this.author = System.getProperty("user.name"); 
	}


	@BeforeMethod
	public void configureAndLaunch(Method m) throws IOException // Method m -> Used to access the properties of @Test - annotations
	{   
		Test testClass = m.getAnnotation(Test.class); 
		//testcaseName = m.getName();                    
		this.testcaseName = testClass.testName(); // Returns the method name - LeftPanel TC name in Report
		this.testcaseDec= testClass.description();        // Returns description which is exist inside the @Test (attributes)
		String[] group = new String[testClass.groups().length];
		for (int i = 0; i < testClass.groups().length; i++) 
		{
			group[i] = testClass.groups()[i];	            
			this.category = this.category +group[i]+", ";
		}
		if(this.category!="")
			this.category =this.category.substring(0, this.category.length()-2);
		else 
			this.category="";
		startApp(ReadPropertyFile.get("Browser"), ReadPropertyFile.get("URL"));
		report();
	}

	@Override
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
	
	/* *****INITIAL SETUP************ */

	@Override
	public void startApp(String browser, String url) 
	{
		try 
		{
			if (browser.equalsIgnoreCase("chrome")) 
			{
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
				
			} 
			else if (browser.equalsIgnoreCase("firefox")) 
			{
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
				
			} 
			else if (browser.equalsIgnoreCase("ie")) 
			{
				System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();

			}
			driver.get(url);

			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			driver.manage().window().maximize();

			
		} 
		catch (Exception e) 
		{
			System.err.println("The Browser Could not be Launched. Hence Failed");

		} 
		finally 
		{
			takeSnap();
			
		}
	}

	/* *****ACTIONS************ */

	@Override
	public void click(WebElement ele,String label) 
	{
		try 
		{
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			String text = ele.getText();
			ele.click();
			reportStep("The Element "+ label +" is clicked", "pass");
		
		} 
		catch (Exception e) 
		{
			int a = e.toString().indexOf("Exception:");
			String str = e.toString().substring(0, a + 10);
			reportStep("The element not clicked because of - " + str, "fail");

			Assert.fail("The element is not accessible");
		}
		finally 
		{
			takeSnap();
			
		}
	}

	/* This method is used for clicking dropdown,LOV, radiobutton and checkbox */
	

	@Override
	public void clear(WebElement ele,String label) 
	{
		try 
		{   
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.clear();

			reportStep("The data in the "+label +" field cleared Successfully", "pass");
		} 
		catch (ElementNotInteractableException e) 
		{   
			int a = e.toString().indexOf("Exception:");
			String str = e.toString().substring(0, a + 10);
			reportStep("The data in the "+label +" field is not cleared"+ str, "fail");

			Assert.fail("The field "+label +" is not Interactable");
		}
		finally 
		{
			takeSnap();
			
		}
	}

	@Override
	public void clearValue(WebElement ele) throws InterruptedException 
	{
		try 
		{   
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.sendKeys(Keys.CONTROL,"a");
			ele.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(3000);
			String value = ele.getAttribute("value");
			if((value.equals("") || value.contains("___")) && !(value.contains("^\\d")))
			{

			reportStep("The data in the field cleared Successfully", "pass");
			}
			else
			{

				reportStep("The data '" +value+"'  is not cleared", "fail");
				Assert.fail("The data '" +value+"'  is not cleared");
			}
		} 
		catch (ElementNotInteractableException e) 
		{   
			int a = e.toString().indexOf("Exception:");
			String str = e.toString().substring(0, a + 10);
			reportStep("The data in the field is not cleared"+ str, "fail");

			Assert.fail("The field is not Interactable");
		}
		finally 
		{
			takeSnap();
			
		}
	}
	
	@Override
	public void clearAndType(WebElement ele,String label, String data) {
		try 
		{
			wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.clear();

			ele.sendKeys(data);
			if(ele.getAttribute("value").equals(""))
			{
				reportStep("The Data '" + data + "' is not entered in the '"+label+"' field", "fail");
			}
			else
			{

				reportStep("The Data '" + data + "' entered Successfully in the '"+label+"' field", "pass");
			}

		} 
		catch (Exception e) 
		{   
			int a = e.toString().indexOf("Exception:");
			String str = e.toString().substring(0, a + 10);
			reportStep("The Element is not Interactable" + str , "fail");

			Assert.fail("The Element is not Interactable");
		} 
		finally 
		{
			takeSnap();
			
		}
	}

	@Override
	public void selectDropdownValue(WebElement ele,String value) 
	{
		try 
		{  
			int count =0;
			wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
			List<WebElement> options = driver.findElements(By.xpath("//li[@role='option']/span"));
			for(WebElement a : options)
			{
				if(a.getText().equals(value))
				{
					a.click();
					reportStep("The dropdowntext '" + a.getText() + "'is successfully selected", "pass");
					break;
				}
				else if(count == options.size()){
					reportStep("The dropdowntext '" + a.getText() + "'is not selected", "fail");
					Assert.fail();	

				}
				else
				{
					count = count+1;
					continue;

				}
			}

		}
		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable to access the element " , "fail");

			Assert.fail();	
		} 
		finally 
		{
			takeSnap();
			
		}

	}

	@Override
	public void selectRandomDropdownValue(WebElement ele) 
	{
		try 
		{	
			wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
			List<WebElement> options = driver.findElements(By.xpath("//li[@role='option']/span[not(contains(text(),'--SELECT--'))]"));
			int dropdownsize = options.size();
			int randnMumber = ThreadLocalRandom.current().nextInt(0, dropdownsize);
			options.get(randnMumber).click();
			if(!options.get(randnMumber).getText().equals(""))
			{
				reportStep("The dropdowntext '" + options.get(randnMumber).getText() + "'is successfully selected", "pass");
			}
			else
			{
				reportStep("The dropdowntext '" + options.get(randnMumber).getText() + "'is not selected", "fail");
				Assert.fail();				
			}

		}
		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable to access the element " , "fail");

			Assert.fail();	
		} 
		finally 
		{
			takeSnap();
			
		}

	}
	
	@Override
	public void deselectDropdownValue(WebElement ele) 
	{
		try 
		{  
			int count =0;
			wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
			List<WebElement> options = driver.findElements(By.xpath("//li[@role='option']/span"));
			for(WebElement a : options)
			{
				if(a.getText().equals("--SELECT--"))
				{
					a.click();
					reportStep("The dropdowntext '" + a.getText() + "'is successfully selected", "pass");
					break;
				}
				else if(count == options.size()){
					reportStep("The dropdowntext '" + a.getText() + "'is not selected", "fail");
					Assert.fail();	

				}
				else
				{
					count = count+1;
					continue;

				}
			}

		}
		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable to access the element " , "fail");

			Assert.fail();	
		} 
		finally 
		{
			takeSnap();
			
		}

	}

	@Override
	public void switchToAlert() 
	{
		try 
		{
			Alert alert = driver.switchTo().alert();
			reportStep("Successfully switched to Alert window", "pass");

		}
		catch (Exception e) 
		{
			reportStep("failed to switch Alert window", "fail");

		}
		finally 
		{
			takeSnap();
			
		}
	}

	@Override
	public void acceptAlert() 
	{
		String text = "";
		try 
		{
			Alert alert = driver.switchTo().alert();
			text = alert.getText();

			alert.accept();

			reportStep("Alert successfully accepted", "pass");
		} 
		catch (NoAlertPresentException e) 
		{
			System.out.println("There is no alert present");

		} 
		catch (WebDriverException e) 
		{
			System.out.println("WebDriverException : " + e.getMessage());
			reportStep("Failed to Accept Alert", "fail");

		}
		finally 
		{
			takeSnap();
			
		}

	}

	@Override
	public void dismissAlert() 
	{
		String text = "";
		try 
		{
			Alert alert = driver.switchTo().alert();
			text = alert.getText();

			alert.dismiss();

			reportStep("Alert successfully dismissed", "pass");
		} 
		catch (NoAlertPresentException e) 
		{
			System.out.println("There is no alert present");

		} 
		catch (WebDriverException e) 
		{
			System.out.println("WebDriverException : " + e.getMessage());
			reportStep("Failed to dismiss Alert", "fail");

		}
		finally 
		{
			takeSnap();
			
		}

	}

	@Override
	public void typeAlert(String data) 
	{
		try 
		{
			driver.switchTo().alert().sendKeys(data);

			reportStep("The data" + data + "entered on Alert window", "pass");
		} 
		catch (Exception e)
		{
			reportStep("The data" + data + " is not entered on Alert window", "fail");

		}
		finally 
		{
			takeSnap();
			
		}

	}

	@Override
	public void switchToWindow(int windowNumber) 
	{
		try 
		{
			Set<String> allWindows = driver.getWindowHandles();
			List<String> allhandles = new ArrayList<>(allWindows);

			String exWindow = allhandles.get(windowNumber);
			driver.switchTo().window(exWindow);

			reportStep("Successfully switched to the window index" + windowNumber, "pass");
		} 
		catch (NoSuchWindowException e) 
		{
			reportStep("Switching to the window index" + windowNumber+ " unsuccessful", "fail");

		}
		finally 
		{
			takeSnap();
			
		}
	}

	@Override
	public void switchTo_AllWindow(String title) 
	{
		try 
		{
			Set<String> allWindows = driver.getWindowHandles();

			for (String eachWindow : allWindows) 
			{
				driver.switchTo().window(eachWindow);
				if (driver.getTitle().equals(title)) 
				{

					break;
				}
			}
			System.out.println("The Window With Title: " + title + "is switched");
		}
		catch (NoSuchWindowException e) 
		{
			System.err.println("The Window With Title: " + title + " not found");

		}
		finally 
		{
			takeSnap();
			
		}
	}

	@Override
	public void switchToFrame(int index) 
	{
		try 
		{
			driver.switchTo().frame(index);

			reportStep("Successfully switched to the frame", "pass");
		}
		catch (Exception e) 
		{
			reportStep("Failed to switch to the frame", "fail");

		}

	}

	@Override
	public void switchToFrame(WebElement ele) 
	{
		try 
		{
			driver.switchTo().frame(ele);

			reportStep("successfully switched to the frame", "pass");
		}
		catch (Exception e) 
		{
			reportStep("failed to switch to the frame", "fail");

		}
	}

	@Override
	public void switchToFrame(String idOrName) 
	{
		try 
		{
			driver.switchTo().frame(idOrName);

			reportStep("successfully switched to the frame", "pass");

		}
		catch (Exception e) 
		{
			reportStep("failed to switch to the frame", "fail");

		}

	}

	@Override
	public void defaultContent() 
	{
		try 
		{
			driver.switchTo().defaultContent();

			reportStep("successfully switched to the default frame", "pass");
		}
		catch (Exception e) 
		{
			reportStep("Failed to switch to the default frame", "fail");

		}

	}

	@Override
	public long takeSnap() 
	{
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		try 
		{
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE),
					new File("./reports/images/" + number + ".jpg"));
		} 
		catch (WebDriverException e) 
		{
			System.out.println("The browser has been closed");
		} 
		catch (IOException e)
		{
			System.out.println("The snapshot could not be taken");
		}
		return number;
	}

	@Override
	public String setCurrentDate(WebElement ele) 
	{
		String systemdate="";
		try 
		{
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();
			systemdate = dateFormat.format(date);
			systemdate =systemdate.replace("/", "");
			ele.clear();
			ele.sendKeys(systemdate);

			reportStep("Current date " +systemdate+ " successfully entered in the field", "pass");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			reportStep("Unable to set the date", "fail");

			Assert.fail("Unable to set the date");
		}
		finally 
		{
			takeSnap();
			
		}
		return systemdate;
	}

	@Override
	public String setFutureDate(WebElement ele) 
	{
		String futureDate="";
		try 
		{
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date currentDate = new Date();
			Calendar c = Calendar.getInstance(); 	/* convert date to calendar */
			c.setTime(currentDate);
			c.add(Calendar.DATE, 1);
			futureDate = dateFormat.format(c.getTime());
			futureDate=futureDate.replace("/", "");
			ele.clear();
			ele.sendKeys(futureDate);

			reportStep("Future date "+futureDate+ " successfully entered in the field", "pass");

		}
		catch (Exception e) 
		{
			e.printStackTrace();
			reportStep("Unable to set the date", "fail");
			Assert.fail("Unable to set the date");

		}
		finally 
		{
			takeSnap();
			
		}
		return futureDate;
	}
	@Override
	public String setFutureDate(WebElement ele, int days) 
	{
		String futureDate="";
		try 
		{
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date currentDate = new Date();
			Calendar c = Calendar.getInstance(); 	/* convert date to calendar */
			c.setTime(currentDate);
			c.add(Calendar.DATE, days);
			futureDate = dateFormat.format(c.getTime());
			futureDate=futureDate.replace("/", "");
			ele.clear();
			ele.sendKeys(futureDate);

			reportStep("Future date "+futureDate+ " successfully entered in the field", "pass");

		}
		catch (Exception e) 
		{
			e.printStackTrace();
			reportStep("Unable to set the date", "fail");
			Assert.fail("Unable to set the date");

		}
		finally 
		{
			takeSnap();
			
		}
		return futureDate;
	}
	
	
	@Override
	public String setPastDate(WebElement ele,int days) 
	{
		String pastDate="";
		try 
		{
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date currentDate = new Date();
			Calendar c = Calendar.getInstance(); /* convert date to calendar */
			c.setTime(currentDate);
			c.add(Calendar.DATE, -days);
			pastDate = dateFormat.format(c.getTime());
			pastDate=pastDate.replace("/", "");
			ele.clear();
			ele.sendKeys(pastDate);

			reportStep("Past date " +pastDate+ " successfully entered in the field", "pass");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			reportStep("Unable to set the date", "fail");

			Assert.fail("Unable to set the date");
		}
		finally 
		{
			takeSnap();
			
		}
		return pastDate;
	}

	@Override
	public String addDaysToDate(WebElement ele,int days) 
	{
		String dt=ele.getAttribute("value");
		String newDate="";
		try 
		{
			wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOf(ele));
			Date date1=new SimpleDateFormat("MM/dd/yyyy").parse(dt); 
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Calendar cal = Calendar.getInstance();
			cal.setTime(date1);
		    cal.add(Calendar.DATE, days); 
		    newDate = dateFormat.format(cal.getTime());
		    newDate=newDate.replace("/", "");

			reportStep(+days +" days added and" +newDate +" successfully entered", "pass");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			reportStep("Unable to set the date", "fail");

			Assert.fail("Unable to set the date");
		}
		finally 
		{
			takeSnap();
			
		}
		return newDate;
	}
	
	@Override
	public String subtractDaysFromDate(WebElement ele,int days) 
	{
		String dt=ele.getAttribute("value");
		String newDate="";
		try 
		{
			wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			Date date1=new SimpleDateFormat("MM/dd/yyyy").parse(dt); 
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Calendar cal = Calendar.getInstance();
			cal.setTime(date1);
		    cal.add(Calendar.DATE, -days); 
		    newDate = dateFormat.format(cal.getTime());
		    newDate=newDate.replace("/", "");

			reportStep(+days +" days subtracted and" +newDate +" successfully entered", "pass");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			reportStep("Unable to set the date", "fail");

			Assert.fail("Unable to set the date");
		}
		finally 
		{
			takeSnap();
			
		}
		return newDate;
	}
	
	@Override
	public void selectDateFromCalendar(WebElement ele,int date) 
	{
		String expectedDate = Integer.toString(date);
		try 
		{
			List<WebElement> columns=ele.findElements(By.tagName("td"));
			for (WebElement cell: columns)
			{
				if (cell.getText().equals(expectedDate))
				{
					cell.findElement(By.linkText(expectedDate)).click();

					reportStep("Successfully selected a date from calendar", "pass");
					break;
				}
			}
		}
		catch (Exception e) 
		{
			reportStep("Unable to select a date from calendar", "fail");

			Assert.fail("Unable to select a date from calendar");
		}
		finally 
		{
			takeSnap();
			
		}
	}

	public String formatDate(String unformattedDate) 
	{
		String format2="";
		try 
		{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");	
			Date formatted = format.parse(unformattedDate);
			format = new SimpleDateFormat("MM/dd/yyyy");
			format2 = format.format(formatted);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			reportStep("Unable to convert the date", "fail");

			Assert.fail("Unable to convert the date");
		}
		finally 
		{
			takeSnap();
			
		}
		return format2;
	}
	
	@Override
	public void uploadFile(String path) throws IOException 
	{
		try 
		{
			/*precondition :AutoIT executable file must exist */
			Runtime.getRuntime().exec(path);

			reportStep("File uploaded successfully", "pass");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			reportStep("Failed to upload File", "fail");

			Assert.fail("Failed to upload File from path: "+path);
		}
		finally 
		{
			takeSnap();
			
		}
	}

	@Override
	public void pressKey(WebElement ele, String key) throws IOException 
	{
		/* pass data as "Keys.TAB" */
		try 
		{
			ele.sendKeys(key);

			reportStep("Successfully pressed the key  " + key + "from the keyboard", "pass");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			reportStep("Failed to press the key  " + key + "from the keyboard", "fail");

			Assert.fail("Failed to press the key  " + key);
		}
		finally 
		{
			takeSnap();
			
		}
	}

	@Override
	public void delay(int waittime) throws IOException, InterruptedException 
	{
		Thread.sleep(waittime);

	}

	
	@Override
	public void deleteAllcookies() 
	{
		driver.manage().deleteAllCookies();

	}

	@Override
	public void executeJavaScript(WebElement element) 
	{
		try 
		{
			JavascriptExecutor js = driver;
			js.executeScript("arguments[0].click()", element);
			reportStep("The element is clicked successfully","pass");
		}
		catch (Exception e) 
		{   
			reportStep("The Java Script couldn't click element","fail");
			Assert.fail("The Java Script couldn't click element");
		}
		finally 
		{
			takeSnap();
			
		}
	}

	@Override
	public void forward() 
	{
		driver.navigate().forward();

		reportStep("Successfully forwarded the web page", "pass");
	}

	@Override
	public void refresh() 
	{
		driver.navigate().refresh();

		reportStep("Successfully refreshed the web page", "pass");
	}

	@Override
	public void scrolltoPosition(String value) 
	{
		try 
		{
			JavascriptExecutor js = driver;
			js.executeScript("window.scrollBy(0,"+value+")", "");
			/*js.executeScript("scroll(0,"+value+")", ""); */
	
			reportStep("Successfully scrolled to the position", "pass");

		}
		catch (Exception e) 
		{
			e.printStackTrace();
			reportStep("Unable to perform scroll", "fail");
			Assert.fail("Unable to perform scroll");
		}

		finally 
		{
			takeSnap();
			
		}
	}


	@Override
	public void scrollToElementPosition(WebElement element) 
	{
		try
		{
		JavascriptExecutor js = driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
		reportStep("Successfully scrolled to the element position", "pass");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			reportStep("Unable to perform scroll", "fail");
			Assert.fail("Unable to perform scroll");
		}

		finally 
		{
			takeSnap();
			
		}
	}

	@Override
	public void deselectAlloptions(int waittime, WebElement... elements) 
	{
		try 
		{
			WebElement checkElement = null;
			if (elements.length > 0) 
			{
				for (WebElement currentElement : elements) 
				{
					currentElement = checkElement;
					WebDriverWait wait = new WebDriverWait(driver, waittime);
					wait.until(ExpectedConditions.elementToBeClickable(currentElement));
					WebElement checkbox = currentElement;
					if (checkbox.isSelected()) 
					{
						System.out.println("The Element " + currentElement + "is checked");
					} 
					else
						checkbox.click();

					reportStep("All options deselected", "pass");
				}
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			reportStep("Not able to deselect all options", "fail");

		}
	}

	@Override
	public void close() 
	{
		driver.close();

	}

	@Override
	public void quit() 
	{
		driver.quit();
	}

	@Override
	public void doRightClick(WebElement ele) 
	{
		try 
		{
			Actions actions = new Actions(driver);
			actions.contextClick(ele).perform();

			reportStep("Successfully Right clicked on the element", "pass");
		}
		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable to right click on element --> " + error, "fail");

			Assert.fail("Unable to do right click on element");
		}
		finally 
		{
			takeSnap();
			
		}
	}

	@Override
	public void setFocus(WebElement ele) 
	{
		try 
		{
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(ele));
			ele.sendKeys("");

			reportStep("The Element is focussed", "pass");
		} 
		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("The Element  could not be focussed --> " + error, "fail");

			Assert.fail("The Element  could not be focussed");
		}
		finally 
		{
			takeSnap();
			
		}
	}
	
	@Override
	public void setFocus(WebElement label, WebElement ele){
		try 
		{
         	wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(ele));
			String text = label.getText();
			ele.sendKeys("");

			reportStep("The Element "+text+" is focussed", "pass");
		}
		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("The Element could not be focussed --> " + error, "fail");

			Assert.fail("The Element could not be focussed");
		}
		finally 
		{
			takeSnap();
			
		}
	}

	@Override
	public String decode(String data) 
	{
		byte[] decoded = Base64.decodeBase64(data);

		return new String(decoded);
	}

	@Override
	public void clickOffset(WebElement ele, int xOffset, int yOffset) 
	{
		try 
		{
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			Actions build = new Actions(driver);
			build.moveToElement(ele, xOffset, yOffset).click().build().perform();

			reportStep("The Element is clicked", "pass");
		}
		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("The Element could not be clicked --> " + error, "fail");

			Assert.fail("The Element could not be clicked");
		}
		finally 
		{
			takeSnap();
			
		}
	}

	@Override
	public void doDoubleClick(WebElement ele) 
	{
		try 
		{
			wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			Actions build = new Actions(driver);
			build.doubleClick(ele).build().perform();

			reportStep("The Element is double-clicked", "pass");
		}
		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("The Element is could not be clicked --> " + error, "fail");

			Assert.fail("The Element could not be clicked");
		}
		finally 
		{
			takeSnap();
			
		}
	}

	/* RETURN VALUES USING GETMETHODS */

	@Override
	public void getElementWidth(WebElement ele) 
	{
		try 
		{
			int width = ele.getSize().getWidth();

			reportStep("Retrieved Element Width is " +width+ " pixels", "pass");
		} 
		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable to find element --> " + error, "fail");

			Assert.fail("Unable to find element");
		}
		finally 
		{
			takeSnap();
			
		}
	}

	@Override
	public void getElementHeight(WebElement ele) 
	{
		try 
		{
			int height = ele.getSize().getHeight();

			reportStep("Retrieved Element Height is " +height+ " pixels", "pass");
		}
		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable to find element --> " + error, "fail");

			Assert.fail("Unable to find element");
		}
		finally 
		{
			takeSnap();
			
		}
	}

	@Override
	public String getElementText(WebElement ele) 
	{
		try 
		{
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(ele));
			ele.getText();

			reportStep("Successfully got element text " +ele.getText(), "pass");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			reportStep("Failed to get element text", "pass");

			Assert.fail("Failed to get element text");
		}
		finally 
		{
			takeSnap();
			
		}
		return ele.getText();
	}

	@Override
	public String getBackgroundColor(WebElement ele) 
	{
		try 
		{
			String s = ele.getCssValue("color");

			reportStep("Successfully got element background color "+s, "pass");
			return s;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			reportStep("Failed to get element background color", "fail");

			Assert.fail("Failed to get background color");
			
		}
		finally 
		{
			takeSnap();
			
		}
		return ele.getCssValue("color");
	}

	@Override
	public void verifyBorderColor(WebElement... elements) 
	{
		try 
		{
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfAllElements(elements));
			for (WebElement ele : elements) 
			{
				if(ele.getCssValue("border-color").contains("rgb(175, 175, 175)"))
				{
					reportStep("The element is not highlighted in red", "fail");

					Assert.fail("The element is not highlighted in red");
				}
				else if(ele.getCssValue("border-color").contains("rgb(236, 77, 77)"))
				{
					reportStep("The element is highlighted in red", "pass");

				}
				else
				{
					reportStep("The element is not highlighted in red", "fail");

					Assert.fail("The element is not highlighted in red");
				}

			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			reportStep("Failed to get element border color", "fail");

			Assert.fail("Failed to get element border color");
		}
		finally 
		{
			takeSnap();
			
		}
	}

	@Override
	public String getTypedText(WebElement ele) 
	{
		try 
		{
			String s = ele.getAttribute("value");

			reportStep("Successfully got entered text: "+ s +" on field ", "pass");
			return s;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			reportStep("Failed to get entered text " + ele, "fail");

			return null;
		}
		finally 
		{
			takeSnap();
			
		}
		
	}

	@Override
	public String getAlertText() 
	{
		Alert alert = driver.switchTo().alert();
		try 
		{
			String s = alert.getText();
			
			reportStep("Successfully retrieved Alert Text", "pass");
			return s;
		}
		catch (NoAlertPresentException e) 
		{
			reportStep("Failed to retrieve alert text", "fail");
			
			Assert.fail("Failed to retrieve alert text");
		} 
		catch (WebDriverException e) 
		{
			reportStep("Failed to retrieve alert text", "fail");
			
			Assert.fail("Failed to retrieve alert text");
		}
	
		finally 
		{
			takeSnap();
			
		}
		return null;
	}


	@Override
	public String getAttribute(WebElement ele, String data) throws IOException 
	{
		try 
		{
			String s = ele.getAttribute(data);

			reportStep("Succesfully retrieved " + s + " attribute value for " + data + "", "pass");
			return s;
		}
		catch (Exception e) 
		{
			reportStep("Failed to retrieve  attribute value for " + data + "", "fail");

			Assert.fail("Failed to retrieve  attribute value for " + data + "");
			e.printStackTrace();
		}
		finally 
		{
			takeSnap();
			
		}
		return null;
		
	}


	@Override
	public String getURL() 
	{
		try 
		{
			String s = driver.getCurrentUrl();
			
			reportStep("Successfully retrieved current URL", "pass");
			return s;
		} 
		catch (Exception e) 
		{
			reportStep("Retrieving current URL failed ", "fail");

			Assert.fail("Retriveing Current URL failed");
			e.printStackTrace();
		}
		finally 
		{
			takeSnap();
			
		}
		return null;
	}

	// ******VERIFY TEXT************

	@Override
	public boolean verifyElementHasAttribute(WebElement ele, String attribute) 
	{
		Boolean result = false;
		try 
		{
			String value = ele.getAttribute(attribute);
			if (value != null) 
			{
				result = true;

				reportStep("Element has the attribute : " + attribute, "pass");
			}
			else {
				result = false;

				reportStep("Element does not have the attribute : " + attribute, "fail");
				Assert.fail("Element does not have the attribute : " + attribute);
			}
		} 
		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable to verify attribute --> " + error, "fail");

			result = false;
			Assert.fail("Unable to verify the attribute : " + attribute);
			
		}
		return result;
	}

	@Override
	public void verifyUrl(String url) 
	{
		try 
		{
			if(driver.getCurrentUrl().equals(url)) {


				reportStep("The Expected "+url+"is matched with actual/current url ", "pass");
			}
			else {

				reportStep("The Expected "+url+"is does not match with actual/current url ", "fail");
				Assert.fail("The Expected "+url+"is does not match with actual/current url ");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			reportStep("Unable to retrieve the URL", "fail");

			Assert.fail("Unable to retrieve the URL");
		}
		finally 
		{
			takeSnap();
			
		}
	}

	@Override
	public void verifyTitle(String title) 
	{
		try 
		{
			if(driver.getTitle().equals(title)) {


				reportStep("The Expected "+title+"is matched with actual/current title ", "pass");
			}
			else {

				reportStep("The Expected "+title+"is does not match with actual/current title ", "fail");
				Assert.fail("The Expected "+title+"is does not match with actual/current utitlerl ");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			reportStep("Unable to retrieve the title", "fail");

			Assert.fail("Unable to retrieve the title");
		}
		finally 
		{
			takeSnap();
			
		}
	}

	@Override
	public void verifyExactText(WebElement ele, String expectedText) 
	{
		try 
		{
			wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOf(ele));
			if(ele.getText().equals(expectedText))
			{
				reportStep("The expected text contains the actual '" + ele.getText() +"'", "pass");

			}
			else
			{
				reportStep("The expected text does not contains the actual '" + ele.getText() +"'", "fail");

				System.out.println("Actual: '"+ele.getText()+"'");
				System.out.println("Expected: '"+expectedText+"'");
				Assert.fail("The expected text does not contains the actual '" + ele.getText() +"'");
				
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			reportStep("Unable to access the element ", "fail");

			Assert.fail("Unable to access the element");
		}
		
		finally 
		{
			takeSnap();
			
		}
	}

	@Override
	public void verifyPartialText(WebElement ele, String expectedText) 
	{
		try
		{
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(ele));
			if(ele.getText().contains(expectedText)){
				System.out.println("Actual text is"+ele.getText());

				reportStep("The expected text contains the actual " + expectedText, "pass");
			}
			else
			{
				reportStep("The expected text doesn't contain the actual " + expectedText, "fail");
				Assert.fail("The expected text doesn't contains the actual " + expectedText);


			}
		}
		catch(Exception e)
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable to Access the Element", "fail");
			Assert.fail("The expected text doesn't contain the actual " + expectedText);

		}
		finally 
		{
			takeSnap();
			
		}
	}

	@Override
	public boolean verifyExactAttribute(WebElement ele, String attribute, String value) 
	{
		try 
		{
			if (ele.getAttribute(attribute).equals(value)) 
			{

				reportStep("The expected attribute :" + attribute + " value contains the actual " + value,"pass");
				return true;
			}
			else 
			{
				reportStep("The expected attribute :" + attribute + " value does not contains the actual " + value,"fail");
				Assert.fail("The expected attribute :" + attribute + " value does not contains the actual " + value);
			}
		} 
		catch (WebDriverException e) 
		{
			reportStep("Unable to verify the attribute value","fail");

			Assert.fail("Unable to verify the attribute value");
			
		}
		return false;
	}

	@Override
	public void verifyAssociatedScreens(List<WebElement> ele, String...expected) {
		try 
		{
			ArrayList<String> Headers = new ArrayList<String>();
			ArrayList<String> expec = new ArrayList<String>();
			for (WebElement col : ele){
				Headers.add(col.getText().trim());
			}
			for(String exp : expected ){
				expec.add(exp.trim());
			}
			if (expec.equals(Headers)) 
			{

				for(String display : expected){
					reportStep("Associated Screen "+ display+" is present", "pass");
				}
			}
			else{


				reportStep("Associated Screens are not present", "fail");
				Assert.fail("Expected Associated Screens are not present");
			}
		}
		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable find Associated Screens --> " + error, "fail");

			Assert.fail("Unable to fid Associated Screens");
		}
		finally 
		{
			takeSnap();
		}

	}

	// ******VERIFY FIELDS VISIBILTY************

	@Override
	public void verifyDisplayed(WebElement ele,String elementName) throws Exception 
	{
		try 
		{
			wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOf(ele));
			if (ele.isDisplayed()==true)
			{
				reportStep("The element '"+ elementName + "' is displayed", "pass");
			}
			else
			{
				reportStep("The element '"+elementName+"' is not displayed", "fail");
			}
		}
		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable to find Element --> " + error, "fail");
			Assert.fail("Unable to find Element");
		}
		finally 
		{
			takeSnap();
		}
	}
	
	@Override
	public boolean verifyFieldIsEmpty(WebElement ele)
	{
		try
		{
			wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOf(ele));
			if (ele.getAttribute("value").isEmpty() == true)
			{
				reportStep(ele.getText() +" is Empty","pass");	
				return true;
			}
			else
			{
				reportStep(ele.getText() +" is Not Empty","fail");	
				Assert.fail(ele.getText() +" is Not Empty");
			}
		}
		catch(Exception e)
		{
			reportStep("Unable to find the field value","fail");
			Assert.fail("Unable to find the field value");
		}
		finally 
		{
			takeSnap();
		}
		return false;

	}

	@Override
	public boolean verifyFieldIsEmpty(WebElement lbl, WebElement ele)
	{
		try
		{
			wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOf(ele));
			if (ele.getAttribute("value").isEmpty() == true)
			{
				reportStep(lbl.getText() +" is Empty","pass");	
				return true;
			}
			else
			{
				reportStep(lbl.getText() +" is Not Empty","fail");	
				Assert.fail(lbl.getText() +" is Not Empty");
			}
		}
		catch(Exception e)
		{
			reportStep("Unable to find the field value","fail");
			Assert.fail("Unable to find the field value");
		}
		finally 
		{
			takeSnap();
		}
		return false;

	}
	
	

	@Override
	public boolean verifyDisappeared(WebElement ele) 
	{
		try
		{
			if(ele.isDisplayed()==true) 
			{
				reportStep("Element still appears on page", "fail");
			}
		}
		catch(NoSuchElementException e)
		{
			reportStep("Element is invisible", "pass");
		}
		catch(Exception e)
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable to access the element -->" +error, "fail");
			Assert.fail("Unable to access the element");
		}
		finally 
		{
			takeSnap();
		}
		return true;
	}

	@Override
	public boolean verifyEnabled(WebElement ele) 
	{
		try
		{
			wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOf(ele));
			if (ele.isEnabled()) 
			{

				reportStep("The element is Enabled", "pass");
				return true;
			} 
			else 
			{
				reportStep("The element is not Enabled", "fail");

				Assert.fail("The element is not Enabled");
			}
		} 
		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable to access the element-->" +error,"fail");
			Assert.fail("Unable to access the element");

			return false;
		}
		finally 
		{
			takeSnap();
		}
		return false;
	}

	@Override
	public boolean verifyDisabled(WebElement ele) 
	{
		try 
		{   
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(ele));
			String value=ele.getAttribute("disabled");
			if(value!=null && value.equals("true"))
			{
				reportStep("The expected element is disabled", "pass");
			}
			else 
			{
				reportStep("The expected element is not disabled", "fail");
				
			}
		} 
		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String str = e.toString();
			reportStep("Unable to access the element "+ str, "fail");

			
		}
		finally 
		{
			takeSnap();
		}
		return false;
	}
	
	@Override
	public boolean verifySelected(WebElement ele) 
	{
		try 
		{
			if (ele.isSelected()) 
			{
				reportStep("The element " + ele + " is selected","pass");

				return true;
			} 
			else 
			{
				reportStep("The element " + ele + " is not selected","fail");

			}
		} 
		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable to access the element-->" +error,"fail");

    		Assert.fail("Unable to access the element");
			return false;
		}
		finally 
		{
			takeSnap();
		}
		return false;
	}

	@Override
	public boolean verifyAlertNotPresent() 
	{
		try 
		{
			if (driver.switchTo().alert() != null) 
			{
				reportStep("Alert is present", "fail");

				Assert.fail("Alert is present");
				return false;
			}
			else 
			{
				reportStep("Alert is Not present", "pass");

				return true;
			}
		} 
		catch (Exception e) 
		{
			reportStep("Unable to find Alert", "fail");
			Assert.fail("Unable to find Alert");

		}
		finally 
		{
			takeSnap();
		}
		return false;
	}

	@Override
	public boolean verifyAlertPresent() 
	{
		try
		{
		if (driver.switchTo().alert() != null) 
		{
			reportStep("Alert is present", "pass");
			
			return true;
		}
		else {
			reportStep("Alert is Not present", "fail");

			Assert.fail("Alert is Not present");
		}
		}
		catch (Exception e) 
		{
			reportStep("Unable to find Alert", "fail");
			Assert.fail("Unable to find Alert");

		}
		finally 
		{
			takeSnap();
		}
		return false;
	}

	@Override
	public void verifyOptionalField(WebElement label) 
	{
		try 
		{
			if (!label.getText().contains("*")) 
			{

				reportStep("Element "+"'" + label.getText() + "'" + " is an optional field", "pass");
			}
			else 
			{
				reportStep("Element "+"'" + label.getText() + "'" + "is not an optional field", "fail");

				
			}
		} 
		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable to access element -->" +error , "fail");

			
		}
		finally 
		{
			takeSnap();
		}
	}

	@Override
	public void verifyRequiredField(WebElement label) 
	{
		try 
		{
			if (label.getText().contains("*")) 
			{
				reportStep("Element "+"'" + label.getText()+ "'" + "is a required field", "pass");

			}
			else 
			{
				reportStep("Element "+"'" + label.getText() + "'" + "is not a required field, Asterisk(*) missing", "fail");

			}
		} 
		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable to access element -->" +error , "fail");

			
		}
		finally 
		{
			takeSnap();
		}
	}

	@Override
	public void verifyElementNotChecked(WebElement ele) 
	{
		try 
		{
			if(ele.isSelected())
			{

			reportStep("Element is checked", "pass");
			}
			else
			{

				reportStep("Element is not checked", "fail");
			}
		}
		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable to access element -->" +error , "fail");

			Assert.fail("Unable to access element");
		}
		finally 
		{
			takeSnap();
		}
	}


	@Override
	public void verifyCursorFocus(WebElement ele) throws IOException, InterruptedException 
	{
		try
		{
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(ele));
		WebElement focusedElement = driver.switchTo().activeElement();
		if (focusedElement.equals(ele)) 
		{

			reportStep("Cursor focus is present in the expected element", "pass");
		} 
		else
		{

			reportStep("Cursor focus is not present in the expected element", "fail");
		}
	}
		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable to access element -->" +error , "fail");

			Assert.fail("Unable to access element");
		}
		finally 
		{
			takeSnap();
		}
	}

	@Override
	public void createHubforGrid() 
	{
		try 
		{
			File file = new File("./Resources/selenium-server-standalone-3.141.59.jar");

			String directory = file.getParent();
			directory = file.getAbsoluteFile().getParent();

			System.out.println("Selenium server location: " +directory);
			Runtime rt = Runtime.getRuntime();
			rt.exec("cmd.exe /c cd \""+directory+"\" & start java -jar selenium-server-standalone-3.141.59.jar -role hub");

			InetAddress localhost = InetAddress.getLocalHost(); 
			String hubIPAddress = localhost.getHostAddress().trim();
			System.out.println("Hub IP Address : " +hubIPAddress); 
			Process p1 = Runtime.getRuntime().exec("cmd.exe /C pushd \\\\192.168.1.184   /U rajkumarprakasam /P Seep2019   \\H: && KILL BROWSER.bat && popd");

		} 
		catch (Exception e) 
		{
			int position =e.toString().indexOf("Exception:");
			String error = e.toString().substring(0,position+10);
			reportStep("Cannot create the hub -->"+error, "fail");

			
		} 

	}

	@Override
	public void joinAsNodeforGrid() 
	{
		try 
		{
			Runtime rt = Runtime.getRuntime();
			rt.exec("cmd /c start \"D:\\NVKIDS_V1 Workspace\\NVKIDS_SeleniumFramework\\Resources\\CallBatch.bat\"");

		} 
		catch (Exception e) 
		{
			int position =e.toString().indexOf("Exception:");
			String error = e.toString().substring(0,position+10);
			reportStep("Cannot create the Node -->"+error, "fail");
			
			
		} 

	}

	@Override
	public void setupGrid()
	{
		try
		{
			String URL = "http://www.abc.com";
			String Node = "http://192.168.1.164:4444/wd/hub";
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			driver = new RemoteWebDriver(new URL(Node), cap);
		}
		catch (Exception e) 
		{
			int position =e.toString().indexOf("Exception:");
			String error = e.toString().substring(0,position+10);
			reportStep("Cannot create the Node -->"+error, "fail");

		}

	}

	@Override
	public void verifyFieldLength(WebElement ele, String data, int size) 	
	{
		int actualsize=0;
		try 
		{
			clearValue(ele);
			ele.sendKeys(data);
			String typedvalue = ele.getAttribute("value");
			actualsize = typedvalue.length();
			if(actualsize == size)
			{
				reportStep("The actual size matches the expected size " + actualsize, "pass");

			}

			else
			{
				reportStep("The actual size: "+ actualsize + " does not matches the expected size "+size , "fail");

				Assert.fail("The actual size: "+ actualsize + " does not matches the expected size "+size );

			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			reportStep("Unable to access the element", "fail");

			Assert.fail("Unable to access the element");
		}
		finally 
		{
			takeSnap();
		}

	}
	
	@Override
	public void verifyFieldLength(WebElement ele, int size) 	
	{
		int actualsize=0;
		try 
		{
			String typedvalue = ele.getAttribute("value");
			actualsize = typedvalue.length();
			if(actualsize == size)
			{
				reportStep("The actual size matches the expected size " + actualsize, "pass");

			}

			else
			{
				reportStep("The actual size: "+ actualsize + " does not matches the expected size "+size , "fail");

				Assert.fail("The actual size: "+ actualsize + " does not matches the expected size "+size );

			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			reportStep("Unable to access the element", "fail");

			Assert.fail("Unable to access the element");
		}
		finally 
		{
			takeSnap();
		}

	}
	
	public void verifyDateFieldLength(WebElement ele, String data, int size) 	
	{
		int actualsize=0;
		try 
		{
			clearValue(ele);
			ele.sendKeys(data);
			String typedvalue = ele.getAttribute("value");
			typedvalue = typedvalue.replaceAll("/", "");
			actualsize = typedvalue.length();
			if(actualsize == size)
			{
				reportStep("The actual size matches the expected size " + actualsize, "pass");

			}

			else
			{
				reportStep("The actual size: "+ actualsize + " does not matches the expected size "+size , "fail");

				Assert.fail("The actual size: "+ actualsize + " does not matches the expected size "+size );

			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			reportStep("Unable to access the element", "fail");

			Assert.fail("Unable to access the element");
		}
		finally 
		{
			takeSnap();
		}

	}

	@Override
	public String getRandomNumbers(int size) 
	{
		String NumericString = "0123456789"; 

		StringBuilder sb = new StringBuilder(size); 

		for (int i = 0; i < size; i++) 
		{ 
			int index = (int)(NumericString.length()* Math.random()); 
			sb.append(NumericString.charAt(index)); 
		} 
		return sb.toString(); 
	}
	@Override
	public String getRandomSpecial(int size) 
	{
		String SpecialCharString = "!\"#$%&'( )*+,-./:;<=>?@[\\]^_`{|}~"; 

		StringBuilder sb = new StringBuilder(size); 

		for (int i = 0; i < size; i++) 
		{ 
			int index = (int)(SpecialCharString.length()* Math.random()); 
			sb.append(SpecialCharString.charAt(index)); 
		} 
		return sb.toString(); 
	}
	
	
	@Override
	public String getRandomSpecificSpecial(int size,String value) 
	{
		String SpecialCharString = value; 

		StringBuilder sb = new StringBuilder(size); 

		for (int i = 0; i < size; i++) 
		{ 
			int index = (int)(SpecialCharString.length()* Math.random()); 
			sb.append(SpecialCharString.charAt(index)); 
		} 
		return sb.toString(); 
	}
	@Override
	public String getRandomAlphaNumericSpecialChar(int size) 
	{ 

		String allCharString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +"!\"#$%&'( )*+,-./:;<=>?@[\\]^_`{|}~"+"0123456789" +"abcdefghijklmnopqrstuvxyz"; 

		StringBuilder sb = new StringBuilder(size); 

		for (int i = 0; i < size; i++) 
		{ 
			int index = (int)(allCharString.length()* Math.random()); 
			sb.append(allCharString.charAt(index)); 
		} 
		return sb.toString(); 
	}
	
	
	@Override
	public String getRandomAlphaNumericChar(int size) 
	{ 

		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +"0123456789" +"abcdefghijklmnopqrstuvxyz"; 

		StringBuilder sb = new StringBuilder(size); 

		for (int i = 0; i < size; i++) 
		{ 
			int index = (int)(AlphaNumericString.length()* Math.random()); 
			sb.append(AlphaNumericString.charAt(index)); 
		} 
		return sb.toString(); 
	} 
	
	
	@Override
	public String getRandomAlphaChar(int size) 
	{ 

		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz"; 

		StringBuilder sb = new StringBuilder(size); 

		for (int i = 0; i < size; i++) 
		{ 
			int index = (int)(AlphaNumericString.length()* Math.random()); 
			sb.append(AlphaNumericString.charAt(index)); 
		} 
		return sb.toString(); 
	} 
	@Override
	public void pressEnterKey(WebElement ele)
	{

		try {

			if(driver.getCapabilities().getBrowserName().contains("firefox")) {
				delay(5000);
				ele.sendKeys(Keys.ENTER);
				reportStep("Tapped Enter key successfully in the element", "pass");
			}

			else {
				ele.sendKeys(Keys.ENTER);
				reportStep("Tapped Enter key successfully in the element", "pass");
			}
		}



		catch(Exception e)
		{
			reportStep("Unable to access the element", "fail");

			Assert.fail("Unable to access the element");
		}
		finally 
		{
			takeSnap();
		}
	}
	
	@Override
	public void verifyGridHeaders(List<WebElement> ele,String...expected) 
	{
		try 
		{
			ArrayList<String> Headers = new ArrayList<String>();
			ArrayList<String> expec = new ArrayList<String>();
			for (WebElement col : ele)
			{
				if(col.getAttribute("class").contains("hidden") == true )
				{
					continue;
				}
				else
				{
					String text = col.getText().trim().replace("\n", " ").replace("\r", " ");
					if(text.equals("")) {
						Headers.add("Untitled");
					}
					else {
						Headers.add(text);
					}
					
					
				}
			}
			
			for(String exp : expected )
			{
				expec.add(exp.trim());
			}

			if (expec.equals(Headers)) 
			{

				for(String display : expected)
				{
					reportStep("Grid Header "+ display  +" is present", "pass");

				}
			}
			else
			{

				reportStep("Grid Header is not present", "fail");
				Assert.fail("Grid Header is not present");
			}
		}
		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable find header --> " + error, "fail");

			Assert.fail("Unable to find headers");
		}
		finally 
		{
			takeSnap();
		}



	}

	@Override
	public void VerifyCharAllowed(WebElement ele, String data)
	{
		try
		{
			wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.clear();
			ele.sendKeys(data);
			if (ele.getAttribute("value").equals(data))
			{
				reportStep("The entered data "+data+" is allowed in the field","pass");	

			}
			else
			{
				reportStep("The entered data "+data+" is not allowed in the field","fail");

			}
		}
		catch(Exception e)
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable find element --> " + error, "fail");
			
			Assert.fail("Unable to find element");
		}
		finally 
		{
			takeSnap();
		}
	}

	@Override
	public void VerifyCharNotAllowed(WebElement ele, String data)
	{
		try
		{
			wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.clear();
			ele.sendKeys(data);
			if (ele.getAttribute("value").length()==0)
			{
				reportStep("The entered data "+data+" not allowed in the field","pass");
				
			}
			else
			{
				reportStep("The entered data "+data+" is allowed in the field","fail");	
				
			}
		}
		catch(Exception e)
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable find element --> " + error, "fail");
			
			Assert.fail("Unable to find element");
		}
		finally 
		{
			takeSnap();
		}


	}

    @Override
	public void copypaste(WebElement ele, String text) throws AWTException
	{
    	try 
		{
			int actualsize=0;
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(new StringSelection(text), null);
			ele.clear();
			ele.click();
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			String typedvalue = ele.getAttribute("value");
			actualsize = typedvalue.length();
			if(text.equals(typedvalue))
			{
				reportStep("Pasted text  matches the expected copied text " + text, "pass");

			}
			else
			{
				reportStep("Pasted text  does not matches the expected copied text, the Actual size is: " + actualsize, "fail");

				Assert.fail("Pasted text does not matches the expected copied text " + actualsize);
			}
		}
		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable find element --> " + error, "fail");
			
			Assert.fail("Unable to find element");
		}
		finally 
		{
			takeSnap();
		}
	}

    
    public  String selectQuery(String sqlQuery,String columnName) throws SQLException, ClassNotFoundException 
    { 

    	String myUserName = ReadPropertyFile.get("DatabaseUserName");
    	String myPassword = ReadPropertyFile.get("DatabasePassword");
    	String dbURL = ReadPropertyFile.get("DatabaseURL");
    	String username = myUserName;
    	String password = myPassword;
    	String result = "";
    	/* Load DB2 JDBC Driver */	
    	try 
    	{
    		Class.forName("com.ibm.db2.jcc.DB2Driver");
    		try
    		{
    			/*Creating connection to the database */
    			Connection con = DriverManager.getConnection(dbURL,username,password);
    			/*Creating statement object */
    			Statement st = con.createStatement();
    			String selectquery = sqlQuery;
    			/*Executing the SQL Query and store the results in ResultSet */
    			ResultSet rs = st.executeQuery(selectquery);
    			/*While loop to iterate through all data and print results */
    			while (rs.next()) 
    			{
    				System.out.println(rs.getString(columnName));
    				result = rs.getString(columnName);
    				System.out.println(result);
    				//return result;
    			}
    			/*Closing all Connections */
    			rs.close();
    			st.close();
    			con.close();
    		}
    		catch (SQLException e) 
    		{
    			int position = e.toString().indexOf("Exception:");
    			String error = e.toString().substring(0, position + 10);
    			reportStep("SQL Exception Found --> " + error, "fail");
    			Assert.fail("SQL Exception Found");
    		}
    	} 
    	catch (ClassNotFoundException e) 
    	{
    		int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("SQL ClassNot Found Exception Found --> " + error, "fail");
			Assert.fail("SQL ClassNot Found Exception Found");
    	}
		return result;
    }

	@Override
	public void verifyGridResult(WebElement ele,String data) 
	{
		try 
		{
			WebElement exp;
			WebDriverWait wait = new WebDriverWait(driver,25);
			wait.until(ExpectedConditions.textToBePresentInElement(ele, data));
			List<WebElement> findElements = ele.findElements(By.tagName("tr"));
			wait.until(ExpectedConditions.visibilityOfAllElements(findElements));
			outerloop:
				for (WebElement row : findElements)
				{
					List<WebElement> cells = row.findElements(By.tagName("td"));
					for(WebElement cell : cells)
					{
						String actualValue = cell.getText();
						if(actualValue.equals(data))
						{
							exp = cell;
							reportStep(actualValue + "Record  is available", "pass");

							break outerloop;
						}
						else if((findElements.get(findElements.size()-1)).equals(row))
						{
							reportStep(data + " Record is not available", "fail");

							Assert.fail(data + " Record is not available");
							break outerloop;
						}
						else 
						{
							continue;
						}
					}
				}
		}

		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable find the record --> " + error, "fail");

			Assert.fail("Unable to find the record");
		}
		finally 
		{
			takeSnap();
		}
	}
	
	
	@Override
	public void verifyGridContainsData(WebElement ele,String data) 
	{
		try 
		{
			int size=0;
			List<WebElement> findElements = ele.findElements(By.tagName("tr"));
			outerloop:
				for (WebElement row : findElements)
				{
					List<WebElement> cells = row.findElements(By.tagName("td"));
					for(WebElement cell : cells)
					{
						String actualValue = cell.getText();
						System.out.println(actualValue);
						if(actualValue.contains(data))
						{
					
							reportStep(actualValue + "Record  is available", "pass");

							break outerloop;
						}
						
						
						else if(findElements.size()==size)
						{
							reportStep(actualValue + "Record  is not available", "fail");

							break outerloop;
						}
						else 
						{
							
							continue;
						}
					}
					size++;
				}
		}

		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable find the record --> " + error, "fail");

			Assert.fail("Unable to find the record");
		}
		finally 
		{
			takeSnap();
		}
	}

	@Override
	public boolean verifyGridRecordsPresent(WebElement ele)
	{
		try
		{
		delay(5000);
		if(ele.isDisplayed()==true)
		{
			reportStep("Records are present for specified Select Filter values", "pass");
			return true;
		}
		else
		{
			reportStep("No Records found for specified Select Filter values", "fail");
		}
		}
		catch(Exception e)
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unknown exception occurred --> " + error, "fail");
			Assert.fail("Unknown exception occurred");
		}
		return false;
	}
	
	
	@Override
	public void doubleClickGridResult(WebElement ele, String data) 
	{
		try 
		{
			wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			WebElement exp;
			List<WebElement> findElements = ele.findElements(By.tagName("tr"));
			outerloop:
				for (WebElement row : findElements)
				{
					List<WebElement> cells = row.findElements(By.tagName("td"));
					for(WebElement cell : cells)
					{
						String actualValue = cell.getText();
						if(actualValue.equals(data))
						{
							exp = cell;
							doDoubleClick(cell);
							reportStep(actualValue + "Record  is available", "pass");

							break outerloop;
						}
						else if((findElements.get(findElements.size()-1)).equals(row))
						{
							reportStep(actualValue + "Record  is not available", "fail");

							Assert.fail(actualValue.toString() + " Record is not available");
							break outerloop;
						}
						else
						{
							continue;
						}
					}
				}
		}

		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable find the record --> " + error, "fail");

			Assert.fail("Unable to find the record");
		}
		finally 
		{
			takeSnap();
		}
	}

	public void verifyErrorsInPanel(String... errors) 
	{
		try 
		{
			Map<String,String> expMap=new LinkedHashMap<>();
			for(int i=0;i<errors.length;i=i+2)
			{
				expMap.put(errors[i],errors[i+1]);
			}
			Map<String,String> actMap=new LinkedHashMap<>();
		    List<WebElement> allPanelMessages = driver.findElementByXPath("//div[contains(@class,'errorInfoPanel')]").findElements(By.tagName("div"));
			List<WebElement> indivPanelMsgs = driver.findElementsByXPath("//div[contains(@class,'errorInfoPanelItem')]//div[contains(@class,'p-col-12 no-pad')]");
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOfAllElements(indivPanelMsgs));
			for(int i=0;i<indivPanelMsgs.size();i=i+2)
			{
				for(int j=1;j<indivPanelMsgs.size();j=j+2)
				{	
					actMap.put(indivPanelMsgs.get(i).getText().substring(7),indivPanelMsgs.get(j).getText().substring(7));
				}
			}
			for (Entry<String,String> data : expMap.entrySet()) 
			{
				if(!actMap.containsKey(data.getKey()) || !actMap.containsValue(data.getValue()))
				{
					reportStep("'"+data.getKey()+" : " +data.getValue()+"'"+ " --> missing in error panel","fail");
					Assert.fail();	
				}
				else if(actMap.containsKey(data.getKey()) && actMap.containsValue(data.getValue()))
				{
					reportStep("'"+data.getKey()+" : " +data.getValue()+"'"+ " --> is present in error panel","pass");
				}
			}
		}

		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable to access the error panel --> " + error, "fail");

			Assert.fail("Unable to access the error panel");
		}
		finally 
		{
			takeSnap();
		}
	}

	@Override
	public void verifyGridOptions(List<WebElement> ele,String... data) 
	{
		try 
		{   
			wait =new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfAllElements(ele));
			ArrayList<String> GridOptions = new ArrayList<String>();
			ArrayList<String> expec = new ArrayList<String>();
			for (WebElement col : ele)
			{
				String s = col.getText().trim().replaceAll("[^a-z A-Z]", "");
				GridOptions.add(s.trim());
			}
			for(String exp : data )
			{
				expec.add(exp.trim());
			}
			if (expec.equals(GridOptions)) 
			{

				for(String display : data)
				{
					System.out.println(display);
					reportStep("Grid Options "+ display  +" is present", "pass");
				}
			}
			else
			{

				reportStep("Grid Options are not Matching", "fail");
			}
		}
		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable find grid options --> " + error, "fail");

			Assert.fail("Unable to find grid options");
		}
		finally 
		{
			takeSnap();
		}
	}

	@Override
	public void CheckShowFilters(WebElement ele) 
	{
		try 
		{   
			wait =new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(ele));
			String s = ele.getText().trim().replaceAll("[^a-z A-Z]", "");
			if(s.trim().equals("Show Filters"))
			{
				reportStep("Grid Options "+ s.trim()  +" is present", "pass");
				if(!(ele.getAttribute("class").contains("ui-label-active")))
				{
					ele.click();
					if(ele.getAttribute("class").contains("ui-label-active"))
					{

						reportStep("'Show Filters' option is successfully selected & Grid Filter opened", "pass");
					}
					else
					{

						reportStep("Show Filters is not selected", "fail");
						Assert.fail("Show Filters is not selected");
					}
				}
				else if(ele.getAttribute("class").contains("ui-label-active"))
				{

					reportStep("'Show Filters' is already selected", "pass");
				}
			}
			else
			{

				reportStep("Grid Option - Show Filters is not present", "fail");
				Assert.fail("Grid option - Show Filters is not present");
			}
		}
		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable find grid options --> " + error, "fail");

			Assert.fail("Unable to find grid options");
		}
		finally 
		{
			takeSnap();
		}


	}

	@Override
	public void UnCheckShowFilters(WebElement ele) 
	{
		try 
		{   
			wait =new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(ele));
			String s = ele.getText().trim().replaceAll("[^a-z A-Z]", "");
			if(s.trim().equals("Show Filters"))
			{
				reportStep("Grid Options "+ s.trim()  +" is present", "pass");
				if(!(ele.getAttribute("class").contains("ui-label-active")))
				{
					
					reportStep("'Show Filters' option is already not selected", "pass");
				}
				else if(ele.getAttribute("class").contains("ui-label-active"))
				{
					ele.click();

					reportStep("'Show Filters' option is unchecked sucessfully", "pass");
				}
				else
				{

					reportStep("Grid Options is not present", "fail");
					Assert.fail("Grid options is not avaialbe");
				}
			}
			else
			{

				reportStep("Grid Option - 'Show Filters' is not present", "fail");
				Assert.fail("Grid option - 'Show Filters' is not present");
			}
		}
		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable to find grid options --> " + error, "fail");

			Assert.fail("Unable to find grid options");
		}
		finally 
		{
			takeSnap();
		}

	}

	@Override
	public void clickResetFilter(WebElement ele) 
	{
		try
		{
			wait =new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfAllElements(ele));
			String s = ele.getText().trim().replaceAll("[^a-z A-Z]", "");
			System.out.println(s);
			if(s.equals("Reset Filter"))
			{
				ele.click();
				reportStep("Grid Options "+ s.trim()  +" is present and Clicked", "pass");
			}
			else
			{

				reportStep("Grid Option - 'Reset Filter'is not present", "fail");
				Assert.fail("Grid Option - 'Reset Filter' is not present");
			}
		}
		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable find grid options --> " + error, "fail");

			Assert.fail("Unable to find grid options");
		}
		finally 
		{
			takeSnap();
		}


	}

	@Override
	public void verifyShowColumns(WebElement ele,String... data) 
	{
		try
		{
			ele.click();
			int count =0;
			WebElement showColumn = driver.findElementByXPath("//div[@class='ui-overlaypanel-content']/div[contains(@class,'filterItems')]/span[contains(text(),'Show Columns')]");
			wait =new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(showColumn));
			ArrayList<String> Actual = new ArrayList<String>();
			ArrayList<String> expec = new ArrayList<String>();
			ArrayList<String> ShowColumnsListVisible = new ArrayList<String>();
			ArrayList<String> ShowColumnsListHidden = new ArrayList<String>();
			Actions action = new Actions(driver);
			showColumn.click();
			action.clickAndHold(showColumn).build().perform();		
			reportStep("Show Columns  is present and clicked", "pass");
			List<WebElement> SelectCheckBox = driver.findElementsByXPath("//span[contains(text(),'Show Columns')]/following::p-checkbox/label");
			wait =new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfAllElements(SelectCheckBox));
			System.out.println("The size" + SelectCheckBox.size());

			for(WebElement col: SelectCheckBox)
			{
				Actual.add(col.getText().trim());
				System.out.println(col.getText());
				if((col.getAttribute("class").contains("ui-label-active"))==false)
				{
					System.out.println("Hidden: "+col.getText());
					ShowColumnsListHidden.add(col.getText().trim());
					count = count+1;
					continue;
				}
				else if(col.getAttribute("class").contains("ui-label-active")==true)
				{
					System.out.println("Visible: "+ col.getText());
					ShowColumnsListVisible.add(col.getText().trim());
					count = count+1;
					continue;

				}
			}
			for (String exp : data)
			{
				expec.add(exp);
			}
			if(expec.equals(Actual))
			{
				for(String visible:ShowColumnsListVisible  )
				{

					reportStep(visible+" check box enabled", "pass");

				}
				for(String hidden:ShowColumnsListHidden  )
				{

					reportStep(hidden+" is hidden/unchecked", "pass");
				}
			}
			else
			{

				reportStep("Show Column values are not matching", "fail");
				Assert.fail("Show Column values are not matching");
			}
		}
		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable find grid options --> " + error, "fail");

			Assert.fail("Unable to find grid options");
		}
		finally 
		{
			takeSnap();
		}

	}

	@Override
	public void selectShowColumn(WebElement ele,String data) {
		try{
			
			ele.click();
			WebElement showColumn = driver.findElementByXPath("//div[@class='ui-overlaypanel-content']/div[contains(@class,'filterItems')]/span[contains(text(),'Show Columns')]");
			wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOf(showColumn));				
			showColumn.click();
			reportStep("Show Columns  is present", "pass");
			List<WebElement> SelectCheckBox = driver.findElementsByXPath("//div[@class='ui-overlaypanel-content']/div[contains(@class,'filterItems')]/p-checkbox/label");
			wait.until(ExpectedConditions.visibilityOfAllElements(SelectCheckBox));
			for(WebElement col: SelectCheckBox){
				String s1 = col.getText().trim().replaceAll("[^a-z A-Z]", "");
				if(s1.equals(data)){
					if(!(col.getAttribute("class").contains("ui-label-active"))){
						col.click();

						reportStep(data +" is  selected", "pass");
						Thread.sleep(3000);
						ele.click();
						break;

					}
					else if(col.getAttribute("class").contains("ui-label-active")){


						reportStep(data + " is already selected", "fail");
						ele.click();
						Assert.fail(data+ " is already selected");
						

					}
					else{

						reportStep(data + " column is not present", "fail");
						Assert.fail(data + " column is not present");
					}
				}
			}
		}

		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable find grid options --> " + error, "fail");

			Assert.fail("Unable to find grid options");
		}
		finally 
		{
			takeSnap();
		}

	}
	@Override
	public void selectAllShowColumn(WebElement ele) {
		try{
			
			ele.click();
			WebElement showColumn = driver.findElementByXPath("//div[@class='ui-overlaypanel-content']/div[contains(@class,'filterItems')]/span[contains(text(),'Show Columns')]");
			wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOf(showColumn));				
			showColumn.click();
			reportStep("Show Columns  is present", "pass");
			List<WebElement> SelectCheckBox = driver.findElementsByXPath("//div[@class='ui-overlaypanel-content']/div[contains(@class,'filterItems')]/p-checkbox/label");
			wait.until(ExpectedConditions.visibilityOfAllElements(SelectCheckBox));
			for(WebElement col: SelectCheckBox){
				String s1 = col.getText().trim().replaceAll("[^a-z A-Z]", "");
					if(!(col.getAttribute("class").contains("ui-label-active")) && !(s1.contains("Show Filters"))){
						String colname = col.getText().trim().replaceAll("[^a-z A-Z]", "");
						col.click();

						reportStep(colname +" is  selected", "pass");

					}
						
			}
			Thread.sleep(3000);
			ele.click();

		}

		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable find grid options --> " + error, "fail");

			Assert.fail("Unable to find grid options");
		}
		finally 
		{
			takeSnap();
		}

	}
	
	
	

	@Override
	public void UnselectShowColumn(WebElement ele, String data) {
		try{
			
			ele.click();
			WebElement showColumn = driver.findElementByXPath("//div[@class='ui-overlaypanel-content']/div[contains(@class,'filterItems')]/span[contains(text(),'Show Columns')]");
			wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOf(showColumn));				
			showColumn.click();
			reportStep("Show Columns  is present", "pass");
			List<WebElement> SelectCheckBox = driver.findElementsByXPath("//div[@class='ui-overlaypanel-content']/div[contains(@class,'filterItems')]/p-checkbox/label");
			wait.until(ExpectedConditions.visibilityOfAllElements(SelectCheckBox));
			for(WebElement col: SelectCheckBox){
				String s1 = col.getText().trim().replaceAll("[^a-z A-Z]", "");
				if(s1.equals(data)){
					if(!(col.getAttribute("class").contains("ui-label-active"))){


						reportStep(data+ " is already not selected", "fail");
						ele.click();
						Assert.fail(data+ " is already not selected");

					}
					else if(col.getAttribute("class").contains("ui-label-active")){
						col.click();

						reportStep(data + "is unselected", "pass");
						ele.click();
						break;

					}
					else{

						reportStep(data + " column is not present", "fail");
						Assert.fail(data + " column is not present");
					}
				}
			}


		}

		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable find grid options --> " + error, "fail");

			Assert.fail("Unable to find grid options");
		}
		finally 
		{
			takeSnap();
		}

	}

	@Override
	public void ClickExpandAll() {
		try{
			int count =0;
			WebElement eleGridOptionsIcon = driver.findElement(By.xpath("//span[@title='Grid Options']"));
			eleGridOptionsIcon.click();
			WebElement ExpandAll = driver.findElementByXPath("//span[text()='Expand All']");
			wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.elementToBeClickable(ExpandAll));
			delay(2000);
			ExpandAll.click();
		    reportStep("Grid Expanded Sucessfully", "pass");

		}
		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Could not expand the Grid --> " + error, "fail");

			Assert.fail("Could not expand the Grid");
		}
		finally 
		{
			takeSnap();
		}


	}

	@Override
	public void ClickCollapseAll() {
		try{
			int count =0;
			WebElement eleGridOptionsIcon = driver.findElement(By.xpath("//span[@title='Grid Options']"));
			eleGridOptionsIcon.click();
			WebElement CollapseAll = driver.findElementByXPath("//div[@class='ui-overlaypanel-content']/div[contains(@class,'filterItems')]/descendant::span[text()='Collapse All']");
			wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.elementToBeClickable(CollapseAll));
			CollapseAll.click();
			reportStep("Grid Collapsed Sucessfully", "pass");

		}
		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable find & Could not collapse the Grid --> " + error, "fail");

			Assert.fail("Unable to find & Could not collapse the Grid");
		}
		finally 
		{
			takeSnap();
		}

	}

	@Override
	public void verifyDownloadFileOptions(WebElement ele,String... data) {
		try{
			
			ele.click();
			ArrayList<String> ShowColumnsListAll = new ArrayList<String>();
			ArrayList<String> expected = new ArrayList<String>();
			WebElement downloadOptions = driver.findElementByXPath("//div[@class='ui-overlaypanel-content']/div[contains(@class,'filterItems')]/span[contains(text(),'Download File')]");
			wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOf(downloadOptions));				
			downloadOptions.click();
			reportStep("DownloadFile  is present and clicked", "pass");
			List<WebElement> SelectCheckBox = driver.findElementsByXPath("//div[@class='ui-overlaypanel-content']/div[contains(@class,'filterItems')]");
			wait.until(ExpectedConditions.visibilityOfAllElements(SelectCheckBox));
			for(WebElement col: SelectCheckBox){
				String s1 = col.getText().trim().replaceAll("[^a-z A-Z]", "");
				System.out.println(s1);
				if(s1.equals("Download XLS") || s1.equals("Download PDF") ){
					ShowColumnsListAll.add(s1);

				}
				else{
					continue;
				}

			}
			for(String exp : data){
				expected.add(exp);
			}

			if(expected.equals(ShowColumnsListAll)){
				for(String s2: ShowColumnsListAll){

					reportStep(s2 + " Optional is available", "pass");

				}
			}
			else{

				reportStep("Show Column values are not matching", "fail");
				Assert.fail("Show Column values are not matching");

			}


		}

		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable find grid options --> " + error, "fail");

			Assert.fail("Unable to find grid options");
		}
		finally 
		{
			takeSnap();
		}

	}

	@Override
	public void ClickAndDownloadFile(WebElement ele,String data,String fileName) {
		try{
			
			ele.click();
			int count =0;
			WebElement downloadOptions = driver.findElementByXPath("//div[@class='ui-overlaypanel-content']/div[contains(@class,'filterItems')]/span[contains(text(),'Download File')]");
			wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOf(downloadOptions));				
			downloadOptions.click();
			reportStep("DownloadFile  is present and clicked", "pass");
			List<WebElement> SelectCheckBox = driver.findElementsByXPath("//div[@class='ui-overlaypanel-content']/div[contains(@class,'filterItems')]");
			wait.until(ExpectedConditions.visibilityOfAllElements(SelectCheckBox));

			for(WebElement col: SelectCheckBox){
				String s1 = col.getText().trim().replaceAll("[^a-z A-Z]", "");
				if(s1.equals(data)){
					col.click();

					reportStep(data + " is clicked", "pass");
					isFileDownloaded(fileName);
					break;

				}
				else if(count == (SelectCheckBox.size()-1)){

					reportStep(data + " is not found", "fail");
					Assert.fail(data + " is not found");
				}
				else{
					count = count ++;
					continue;
				}

			}

		}

		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable find grid options --> " + error, "fail");

			Assert.fail("Unable to find grid options");
		}
		finally 
		{
			takeSnap();
		}

	}

	@Override
	public void VerifyAssociatedScreensNavigatoin(String ScreenName, String SFName) {
		try 
		{
			int count=0;
			List<WebElement> GridValues = driver.findElementsByXPath("//li[contains(@class,'associatedMenuItem ')]/a/span[2]");
			wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOfAllElements(GridValues));
			for (WebElement col : GridValues){
				if(col.getText().equals(ScreenName)){
					scrollToElementPosition(col);
					executeJavaScript(col);

					reportStep(ScreenName + " is clicked to Navigate", "pass");
					verifyCurrentScreen(SFName);
					break;
				}

				else if(count == (GridValues.size()-1)){

					reportStep(ScreenName + " is not found", "fail");
					Assert.fail(ScreenName + " is not found");

				}
				else {
					count = count++;
					continue;
				}

			}

		}
		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable find Associated Screens --> " + error, "fail");

			Assert.fail();
		}
		finally 
		{
			takeSnap();
		}

	}

	@Override
	public void verifyCurrentScreen(String SFName) {
		try{
			Thread.sleep(2500);
			WebElement eleScreen = driver.findElementByXPath("//p-breadcrumb/descendant::a/span[text()='"+SFName+"']");
			System.out.println(eleScreen);
			System.out.println(eleScreen.getText());
			wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOf(eleScreen));

			verifyExactText(eleScreen, SFName);
		}
		catch(Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable find Screen Function Name --> " + error, "fail");
			
			Assert.fail();
		}
		finally 
		{
			takeSnap();
		}

	}

	@Override
	public void verifyGridHeaderPresent(List<WebElement> ele,String expected) {
		try 
		{
			int count = 0;
			wait = new WebDriverWait(driver,50);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("label")));
			for (WebElement col : ele){
				JavascriptExecutor js = driver;
				String script = js.executeScript("return arguments[0].innerHTML;", col.findElement(By.tagName("label"))).toString().trim();
				
				if(script.equals(expected) && col.getAttribute("class").contains("hidden") == false ){

					reportStep("Grid Header "+script+"  is  present", "pass");
					break;
				}
				else if( script.equals(expected.trim()) && col.getAttribute("class").contains("hidden")==true) {

					reportStep("Grid Header "+ expected +" is  hidden", "fail");
					break;			    
				}
				
				else if(count == ele.size()){

					reportStep("Grid Header " +expected+ " is not present", "fail");
					Assert.fail("Grid Header " +expected+ " is not present");
				}
				else{
					count = count+1;
					continue;
				}
			}
		}
		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable find header --> " + error, "fail");

			Assert.fail("Unable to find headers");
		}
		finally 
		{
			takeSnap();
		}

	}

	@Override
	public void verifyGridHeaderNotPresent(List<WebElement> ele, String expected) {
		try 
		{
			int count =0;
			wait = new WebDriverWait(driver,50);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("label")));
			for (WebElement col : ele){
				JavascriptExecutor js = driver;
				String script = js.executeScript("return arguments[0].innerHTML;", col.findElement(By.tagName("label"))).toString().trim();
				
				if( script.equals(expected.trim()) && col.getAttribute("class").contains("hidden")==false){


					reportStep("Grid Header "+ expected +" is visible instead of beign hidden", "fail");
					Assert.fail("Grid Header "+ expected +"  is visible instead of being hidden");

				}


				else if( script.equals(expected.trim()) && col.getAttribute("class").contains("hidden")==true) {

					reportStep("Grid Header "+ script +" is  hidden", "pass");
					break;			    
				}
				else if(count == ele.size()){


					reportStep("Grid Header "+ expected +" is not available", "pass");
					break;
				}
				else{
					count =count+1;
					continue;
				}
			}
		}
		catch (Exception e) 
		{
			
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable find "+expected+" header --> " + error, "fail");

			Assert.fail("Unable to find Grid Header "+ expected);
		}
		finally 
		{
			takeSnap();
		}
	}
	
	@Override
	public void clicktoNavigateFirstPage(WebElement ele) {
		try {
			wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.elementToBeClickable(ele));

			if(ele.getAttribute("class").contains("first") && !(ele.getAttribute("class").contains("disabled"))) {
				ele.click();

				reportStep("First pagination icon is clicked", "pass");

			}
			else if(ele.getAttribute("class").contains("first") && ele.getAttribute("class").contains("disabled")) {

				reportStep("Unable to Click First pagination icon, Please add records", "info");
			}
		}
		catch (Exception e) {
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable find First pagination icon --> " + error, "fail");

			Assert.fail("Unable find First pagination icon");
		}
		finally {
			takeSnap();
		}
	}
	
	@Override
	public void clicktoNavigatePreviousPage(WebElement ele) {
		try {
			wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.elementToBeClickable(ele));

			if(ele.getAttribute("class").contains("prev") && !(ele.getAttribute("class").contains("disabled"))) {
				ele.click();

				reportStep("Previous pagination icon is clicked", "pass");

			}
			else if(ele.getAttribute("class").contains("prev") && ele.getAttribute("class").contains("disabled")) {

				reportStep("Previous pagination to Click BackWard icon, Please add records", "info");
			}
		}
		catch (Exception e) {
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable find Previous pagination icon --> " + error, "fail");

			Assert.fail("Unable find Previous pagination icon");
		}
		finally {
			takeSnap();
		}
	}
	
	@Override
	public void clicktoNavigateNextPage(WebElement ele) {
		try {
			wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.elementToBeClickable(ele));

			if(ele.getAttribute("class").contains("next") && !(ele.getAttribute("class").contains("disabled"))) {
				ele.click();

				reportStep("Next pagination icon is clicked", "pass");

			}
			else if(ele.getAttribute("class").contains("next") && ele.getAttribute("class").contains("disabled")) {

				reportStep("Unable to Click Next pagination icon, Please add records", "info");
			}
		}
		catch (Exception e) {
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable find Next pagination icon --> " + error, "fail");

			Assert.fail("Unable find Next pagination icon");
		}
		finally {
			takeSnap();
		}
	}

	@Override
	public void clicktoNavigateLastPage(WebElement ele) {
		try {
			wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.elementToBeClickable(ele));

			if(ele.getAttribute("class").contains("last") && !(ele.getAttribute("class").contains("disabled"))) {
				ele.click();

				reportStep("Last pagination icon is clicked", "pass");

			}
			else if(ele.getAttribute("class").contains("last") && ele.getAttribute("class").contains("disabled")) {

				reportStep("Unable to Click Last pagination icon, Please add records", "info");
			}
		}
		catch (Exception e) {
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable find Last pagination icon --> " + error, "fail");

			Assert.fail("Unable find Last pagination icon");
		}
		finally {
			takeSnap();
		}
	}
	
	
	@Override
	public boolean isFileDownloaded( String fileName) throws Exception 
	{

		Thread.sleep(6000);
		String Uname = System.getProperty("user.name");
		System.out.println("C:/Users/"+Uname+"/Downloads");
		File dir = new File("C:/Users/"+Uname+"/Downloads");
		File[] dirContents = dir.listFiles();
		for (int i = 0; i < dirContents.length; i++) 
		{
			if (dirContents[i].getName().contains(fileName)) {
				reportStep("Downloaded File has been found in Preferred Location", "pass");
				return true;
			}
			else if(i== dirContents.length-1) {
				reportStep(" File Not found in Preferred Location", "fail");
				Assert.fail(" File Not found in Preferred Location");
			}
		}
		return false;
	}

	
	@Override
	public void verifyFieldSetLabels(List<WebElement> ele, String...expected) {
		try 
		{
			ArrayList<String> fields = new ArrayList<String>();
			ArrayList<String> expec = new ArrayList<String>();

			for (WebElement col : ele){
				fields.add(col.getText().trim());
				

			}
			for(String exp : expected ){
				expec.add(exp.trim());
				
			}

			if (expec.equals(fields)) 
			{

				for(String display : expected){
					
					reportStep("Accordon Field "+ display+" is present", "pass");
				}


			}
			else{


				reportStep("Accordion Fields are not present", "fail");
				Assert.fail("Accordion Fields are not present");
			}
		}
		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable find Accordion fields --> " + error, "fail");

			Assert.fail();
		}
		finally 
		{
			takeSnap();
		}

	}
}


