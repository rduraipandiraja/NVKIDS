package gov.nv.dwss.nvkids.selenium.api.design;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

public interface Element {


	/**
	 * This method will click the element and take snap
	 * @param ele   - The Webelement (button/link/element) to be clicked
	 * @see locateElement method in Browser Class
	 * @author 
	 * @throws StaleElementReferenceException
	 */
	public void click(WebElement ele,String label);


	/**
	 * This method will enter the value in the given text field 
	 * @param ele   - The Webelement (text field) in which the data to be entered
	 * @param data  - The data to be sent to the webelement
	 * @see locateElement method in Browser Class
	 * @author 
	 * @throws ElementNotInteractable,IllegalArgumentException(throws if keysToSend is null)	
	 */

	public void clear(WebElement ele,String label);

	/**
	 * This method will clear and type the value in the given text field 
	 * @param ele   - The Webelement (text field) in which the data to be entered
	 * @param data  - The data to be sent to the webelement
	 * @see locateElement method in Browser Class
	 * @author Santhosh
	 * @throws ElementNotInteractable,IllegalArgumentException(throws if keysToSend is null)		 
	 */
	public void clearAndType(WebElement ele,String label,String data);

	/**
	 * This method will get the visible text of the element
	 * @param ele   - The Webelement (button/link/element) in which text to be retrieved
	 * @author 
	 * @see locateElement method in Browser Class
	 */
	public String getElementText(WebElement ele);	

	/**
	 * This method will get the Color values of the element
	 * @param ele   - The Webelement (button/link/element) in which text to be retrieved
	 * @see locateElement method in Browser Class
	 * @author Santhosh
	 * @return The visible text of this element.
	 */
	public String getBackgroundColor(WebElement ele);

	/**
	 * This method will get the text of the element textbox
	 * @param ele   - The Webelement (button/link/element) in which text to be retrieved
	 * @see locateElement method in Browser Class
	 * @author 
	 * @return The attribute/property's current value (or) null if the value is not set.
	 */
	public String getTypedText(WebElement ele);
	
	/**
	 * This method will verify exact given text with actual text on the given element
	 * @param ele   - The Webelement in which the text to be need to be verified
	 * @param expectedText  - The expected text to be verified
	 * @author 
	 * @see locateElement method in Browser Class
	 * @return true if the given object represents a String equivalent to this string, false otherwise
	 */
	public void verifyExactText(WebElement ele, String expectedText);

	/**
	 * This method will verify given text contains actual text on the given element
	 * @param ele   - The Webelement in which the text to be need to be verified
	 * @param expectedText  - The expected text to be verified
	 * @author 
	 * @see locateElement method in Browser Class
	 * @return true if this String represents the same sequence of characters as the specified string, false otherwise
	 */
	public void verifyPartialText(WebElement ele, String expectedText);

	/**
	 * This method will verify exact given attribute's value with actual value on the given element
	 * @param ele   - The Webelement in which the attribute value to be need to be verified
	 * @param attribute  - The attribute to be checked (like value, href etc)
	 * @param value  - The value of the attribute
	 * @author 
	 * @see locateElement method in Browser Class
	 * @return true if this String represents the same sequence of characters as the specified value, false otherwise
	 */
	public boolean verifyExactAttribute(WebElement ele, String attribute, String value);

	

	/**
	 * This method will verify if the element is visible in the DOM
	 * @param ele   - The Webelement to be checked
	 * @author 
	 * @see locateElement method in Browser Class
	 * @return true if the element is displayed or false otherwise
	 * @throws Exception 
	 */
	public void verifyDisplayed(WebElement ele,String elementName) throws Exception;

	/**
	 * This method will check the element to be visible along with type of field
	 * @param ele   - The Web element to be checked
	 * @author 
	 * @see locateElement method in Browser Class
	 */
	public boolean verifyDisappeared(WebElement ele);	

	/**
	 * This method will verify if the input element is Enabled
	 * @param ele   - The Webelement (Radio button, Checkbox) to be verified
	 * @return true - if the element is enabled else false
	 * @author 
	 * @since 3rd Jun 2019
	 * @see locateElement method in Browser Class
	 * @return True if the element is enabled, false otherwise.
	 */
	public boolean verifyEnabled(WebElement ele);	
	public boolean verifyDisabled(WebElement ele);	
	/**
	 * This method will verify if the element (Radio button, Checkbox) is selected
	 * @param ele   - The Webelement (Radio button, Checkbox) to be verified
	 * @author 
	 * @since 3rd Jun 2019
	 * @see locateElement method in Browser Class
	 * @return True if the element is currently selected or checked, false otherwise.
	 */
	public boolean verifySelected(WebElement ele);


	void verifyRequiredField(WebElement label);


	void verifyOptionalField(WebElement ele);


	String decode(String data);


	void clickOffset(WebElement ele, int xOffset, int yOffset);


	void doDoubleClick(WebElement ele);
	
	/**
	 * This method will verify if the element (Icon which has text) is focused
	 * @param ele   - The Webelement (Icon - e.g: Save, Refresh, Cancel) to be verified
	 * @author 
	 * @since 3rd Jun 2019
	 * @see locateElement method in Browser Class
	 * @return .
	 */
    
	public void setFocus(WebElement ele);
	
	/**
	 * This method will verify if the element focused and corresponding label text will be printed for confirmation.
	 * @param label -> Field label name associated with the element to be focused. ele   - The Webelement (Icon - e.g: Radio button, Checkbox, LOV , Text Box) to be verified
	 * @author 
	 * @since 28 Nov 2019
	 * @see locateElement method in Browser Class
	 * @return .
	 */
	public void setFocus(WebElement label, WebElement ele);


	void getElementWidth(WebElement ele);


	void getElementHeight(WebElement ele);


	boolean verifyElementHasAttribute(WebElement ele, String attribute);


	String setCurrentDate(WebElement element);


	public String setFutureDate(WebElement ele);
	public String setFutureDate(WebElement ele, int days); 


	String setPastDate(WebElement element,int days);


	void uploadFile(String path) throws IOException;


	void pressKey(WebElement ele, String key) throws IOException;


	void delay(int waittime) throws IOException, InterruptedException;


	void closeBrowser();


	void deleteAllcookies();


	void executeJavaScript(WebElement element);


	void forward();


	void refresh();
	
	public void verifyFieldLength(WebElement ele, String data, int size);
	public void verifyFieldLength(WebElement ele, int size); 	

	void scrolltoPosition(String value);


	void scrollToElementPosition(WebElement element);


	void deselectAlloptions(int waittime, WebElement[] elements);


	void doRightClick(WebElement ele);


	String getAttribute(WebElement ele, String data) throws IOException;


	String getURL();


	boolean verifyAlertNotPresent();


	boolean verifyAlertPresent();


	void verifyElementNotChecked(WebElement ele);


	void verifyCursorFocus(WebElement ele) throws IOException, InterruptedException;


	void selectDateFromCalendar(WebElement ele, int date);


	void createHubforGrid();


	void joinAsNodeforGrid();


	void setupGrid();

	public String getRandomNumbers(int size);
	public String getRandomSpecial(int size); 
	public String getRandomSpecificSpecial(int size,String value); 
	public String getRandomAlphaNumericSpecialChar(int size); 
	public String getRandomAlphaNumericChar(int size); 
	public String getRandomAlphaChar(int size); 


	void verifyBorderColor(WebElement... elements);


	void verifyGridHeaders(List<WebElement> ele,String...expected);


	void verifyAssociatedScreens(List<WebElement> ele,String... expected);


	boolean verifyFieldIsEmpty(WebElement ele);
	public boolean verifyFieldIsEmpty(WebElement lbl, WebElement ele);


	void selectDropdownValue(WebElement ele,String value);

	void selectRandomDropdownValue(WebElement ele);
	
	public void deselectDropdownValue(WebElement ele);

	public void doubleClickGridResult(WebElement ele, String data); 

		
	/**
	 * This method will verify the list of options available inside Grid Options.
	 * @param String...data --> List of String Data can be passed as parameter using comma separator.
	 * @author Protech
	 * @since 19th Nov 2019
	 * @see GridOptions
	 * @return null.
	 */
	public void verifyGridOptions(List<WebElement> ele,String... data); 
	/**
	 * This method will check Show Filters checkbox if it is unchecked.
	 * @param N/A
	 * @author Protech
	 * @since 19th Nov 2019
	 * @see GridOptions
	 * @return null.
	 */
	public void CheckShowFilters(WebElement ele); 	

	/**
	 * This method will uncheck Show Filters checkbox if it is checked before.
	 * @param N/A
	 * @author Protech
	 * @since 19th Nov 2019
	 * @see GridOptions
	 * @return null.
	 */
	public void UnCheckShowFilters(WebElement ele);

	/**
	 * This method used to click on 'Reset Filter' inside the Grid Options when 'Show Filter' is checked.
	 * @param N/A
	 * @author Protech
	 * @since 19th Nov 2019
	 * @see GridOptions
	 * @return null.
	 */
	public void clickResetFilter(WebElement ele);
	/**
	 * This method used to verify list of Columns and their visibility(Hidden/Visible).
	 * @param String...data --> List of String Data can be passed as parameter using comma separator.
	 * @author Protech
	 * @since 19th Nov 2019
	 * @see GridOptions
	 * @return null.
	 */
	public void verifyShowColumns(WebElement ele,String...data);

	/**
	 * This method used to select Show Column check boxes to make it as visible.
	 * @param String data --> Column name which is to be changed as visible.
	 * @author Protech
	 * @since 19th Nov 2019
	 * @see GridOptions
	 * @return null.
	 */
	public void selectShowColumn(WebElement ele,String data);

	/**
	 * This method used to unselect Show Column check boxes to make it as hidden.
	 * @param String data --> Column name which is to be changed as hidden.
	 * @author Protech
	 * @since 19th Nov 2019
	 * @see GridOptions
	 * @return null.
	 */

	public void UnselectShowColumn(WebElement ele, String data);

	/**
	 * This method used to click and expand all rows to view Accordian grid details.
	 * @param N/A.
	 * @author Protech
	 * @since 19th Nov 2019
	 * @see GridOptions
	 * @return null.
	 */
	public void ClickExpandAll();
	/**
	 * This method used to click and Collapse all rows to dock Accordian grid details.
	 * @param N/A.
	 * @author Protech
	 * @since 19th Nov 2019
	 * @see GridOptions
	 * @return null.
	 */
	public void ClickCollapseAll();
	/**
	 * This method used to verify options available to download grid results in desired format.
	 * @param  String...data --> List of String Data can be passed as parameter using comma separator.
	 * @author Protech
	 * @since 19th Nov 2019
	 * @see GridOptions
	 * @return null.
	 */

	public void verifyDownloadFileOptions(WebElement ele,String...data);

	/**
	 * This method used to select an option to download grid results in desired format.
	 * @param  String data -->  Data - format name in which the result to be printed.
	 * @author Protech
	 * @since 19th Nov 2019
	 * @see GridOptions
	 * @return null.
	 */
	public void ClickAndDownloadFile(WebElement ele, String data , String fileName);

	/**
	 * This method used to verify the screen navigation by clicking any of the Associated Screen section link.
	 * @param  String ScreenName -->  ScreenName - Name of the Screen to which the navigation to be happened 
	 *                                SFName --> name of the default screen function name.
	 * @author Protech
	 * @since 19th Nov 2019
	 * @see verifyCurrenScreen
	 * @return null.
	 */
	public void VerifyAssociatedScreensNavigatoin(String ScreenName , String SFName);
	/**
	 * This method used to verify the Current Screen Name.
	 * @param  String ScreenName -->  ScreenName - Name of the current screen.
	 * @author Protech
	 * @since 19th Nov 2019
	 * @see verifyCurrenScreen
	 * @return null.
	 */

	public void verifyCurrentScreen(String ScreenName);
	/**
	 * This method used to verify the given column is present in the Grid header or not.
	 * @param  String expected -->  Column header name which is expected to be present.
	 * @author Protech
	 * @since 21st Nov 2019
	 * @see 
	 * @return null.
	 */
	
	public void verifyGridHeaderPresent(List<WebElement> ele,String expected);
	/**
	 * This method used to verify the given column is not present in the Grid header.
	 * @param  String ScreenName --> Column header name which is expected not to be present.
	 * @author Protech
	 * @since 21st Nov 2019
	 * @see 
	 * @return null.
	 */
	
	public void verifyGridHeaderNotPresent(List<WebElement> ele,String expected);


	void copypaste(WebElement ele, String text) throws AWTException;
	
	
	/**
	 * This method used to click on the FirstPage Navigation icon in the Grid.
	 * @param  WebElement ele --> The Webelement (pagination icon) to be clicked.
	 * @author Protech
	 * @since 04th Dec 2019
	 * @see 
	 * @return null.
	 */
	public void clicktoNavigateFirstPage(WebElement ele);
	
	/**
	 * This method used to click on the Previous Page Navigation icon in the Grid.
	 * @param  WebElement ele --> The Webelement (pagination icon) to be clicked.
	 * @author Protech
	 * @since 04th Dec 2019
	 * @see 
	 * @return null.
	 */
	public void clicktoNavigatePreviousPage(WebElement ele) ;

	/**
	 * This method used to click on the Next Page Navigation icon in the Grid.
	 * @param  WebElement ele --> The Webelement (pagination icon) to be clicked.
	 * @author Protech
	 * @since 04th Dec 2019
	 * @see 
	 * @return null.
	 */
	public void clicktoNavigateNextPage(WebElement ele);
	
	/**
	 * This method used to click on the Last Page Navigation icon in the Grid.
	 * @param  WebElement ele --> The Webelement (pagination icon) to be clicked.
	 * @author Protech
	 * @since 04th Dec 2019
	 * @see 
	 * @return null.
	 */
	public void clicktoNavigateLastPage(WebElement ele);
	
	/**
	 * This method used to verify fields present in display only accordion, header info panels.
	 * @param  List<WebElement> ele --> The List of elements to be verified.
	 * @author Protech
	 * @since 04th Dec 2019
	 * @see 
	 * @return null.
	 */
	public void verifyFieldSetLabels(List<WebElement> ele, String...expected);

	public void pressEnterKey(WebElement ele);
	public void VerifyCharAllowed(WebElement ele, String data);
	public void VerifyCharNotAllowed(WebElement ele, String data);
	public void verifyGridResult(WebElement ele, String data); 
	public String addDaysToDate(WebElement ele,int days);
	public String subtractDaysFromDate(WebElement ele,int days);

	public boolean isFileDownloaded( String fileName) throws Exception;
	public void selectAllShowColumn(WebElement ele);
	public void clearValue(WebElement ele) throws InterruptedException;
	
	
	public void verifyGridContainsData(WebElement ele,String data) ;
	public boolean verifyGridRecordsPresent(WebElement ele) ;
	
	
}
