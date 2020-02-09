package gov.nv.dwss.nvkids.selenium.api.design;

import java.net.MalformedURLException;
import java.util.List;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

//import freemarker.core.ReturnInstruction.Return;

public interface Browser {
	
	/**
	 * This method will launch the Chrome browser and 
	 * maximise the browser and set the wait for 30 seconds 
	 * and load the url
	 * @param url - This will load the specified url  
	 * @author Protech
	 * @throws MalformedURLException 
	 */	
	
	public void startApp(String browser, String url);
	
	
	
	/**
	 * This method will switch to the Alert
	 * @author Protech
	 * @return NoAlertPresentException
	 */
	public void switchToAlert();
	/**
	 * This method will accept the alert opened
	 * @author Protech
	 * @throws NoAlertPresentException
	 */
	public void acceptAlert();
	
	/**
	 * This method will dismiss the alert opened
	 * @author Protech
	 * @throws NoAlertPresentException
	 */
	public void dismissAlert();
	
	/**
	 * This method will return the text of the alert
	 * @author Protech
	 * @throws NoAlertPresentException
	 */
	public String getAlertText();

	/**
	 * This method will enter the value in the alert
	 * @author Protech
	 * @param data- the data to be entered in alert
	 * @throws NoAlertPresentException
	*/
	public void typeAlert(String data);
	
	/**
	 * This method will switch to the Window of interest
	 * @param index The window index to be switched to. 0 -> first window 
	 * @author Protech
	 * @throws NoSuchWindowException
	 */
	public void switchToWindow(int index);
	
	/**
	 * This method will switch to the Window of interest using its title
	 * @param title The window title to be switched to first window 
	 * @author Protech
	 * @throws NoSuchWindowException
	 */
	
	public void switchToFrame(int index);	
	
	/**
	 * This method will switch to the specific frame
	 * @param ele   - The Webelement (frame) to be switched
	 * @author Protech
	 * @throws NoSuchFrameException, StaleElementReferenceException 
	 */
	public void switchToFrame(WebElement ele);

	/**
	 * This method will switch to the specific frame using Id (or) Name
	 * @param idOrName   - The String (frame) to be switched
	 * @author Protech
	 * @throws NoSuchFrameException 
	 */
	public void switchToFrame(String idOrName);
	
	/**
	 * This method will switch to the first frame on the page
	 * @author Protech
	 * @return This driver focused on the top window/first frame.
	 */
	public void defaultContent();
	
	/**
	 * This method will verify browser actual url with expected
	 * @param url   - The url to be checked
	 * @author Protech
	 * @return true if the given object represents a String equivalent to this url, false otherwise
	 */
	public void verifyUrl(String url);
	
	/**
	 * This method will verify browser actual title with expected
	 * @param title - The expected title of the browser
	 * @author Protech
	 * @return true if the given object represents a String equivalent to this title, false otherwise
	 */
	public void verifyTitle(String title);
	
	/**
	 * This method will take snapshot of the browser
	 * @author Protech
	 * @return Object in which is stored information about the screenshot.
	 * @throws WebDriverException
	 */
	public long takeSnap();
	
	/**
	 * This method will close the active browser
	 * @author Protech
	 */
	public void close();
	
	/**
	 * This method will close all the browsers
	 * @author Protech
	 */
	public void quit();
	
	
	public void switchTo_AllWindow(String title);
	

	

	
}
