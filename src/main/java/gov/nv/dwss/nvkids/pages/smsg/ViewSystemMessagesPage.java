package gov.nv.dwss.nvkids.pages.smsg;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class ViewSystemMessagesPage extends CommonLocators

{
	
	public ViewSystemMessagesPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Screen Functions
	@FindBy(xpath="(//span[text()='View System Messages'])[1]") WebElement elesfViewSystemMessages;
	
	//Filter Section
	@FindBy(xpath = "//label[text()='Message Type']") WebElement elelblMessageType;
	@FindBy(xpath = "//label[text()='Message Type']/following::div[1]") WebElement eleddMessageType;
	
	@FindBy(xpath = "//label[text()='Message ID']") WebElement elelblMessageID;
	@FindBy(id = "errorCode") WebElement eletxtMessageID;
	@FindBy(xpath="//input[@id='errorCode']/following-sibling::button") WebElement eleicnMessageID;
	
	@FindBy(xpath = "//label[text()='Description']") WebElement elelblDescription;
	@FindBy(id = "errorDesc") WebElement eletxtDescription;
	
	@FindBy(xpath="//label[@for='searchByCode']/following::div[1]") WebElement eleddUntitledSearchBy;
	
	//Grid Headers and Show Filters Fields
	
	@FindBy(xpath="//label[text()=' Message ID ']")WebElement eleglblMessageID;
	@FindBy(xpath="//input[@id='errorCode']") WebElement elegsftxtMessageID;
	
	@FindBy(xpath="//label[text()=' Description ']")WebElement eleglblDescription;
	@FindBy(xpath="//input[@id='errorDesc']") WebElement elegsftxtDescription;
		
	@FindBy(xpath="//label[text()=' Message Type Code ']") WebElement eleglblMessageTypeCode;
	@FindBy(xpath="//label[@for='errorTypeCode']/following-sibling::p-dropdown/descendant::label") WebElement elegsfddMessageTypeCode;
		
	@FindBy(xpath="//label[text()=' Message Type ']") WebElement eleglblMessageType;
	@FindBy(xpath="//label[@for='errorTypeDesc']/following-sibling::p-dropdown/descendant::label") WebElement elegsfddMessageType;
		
		
	@FindBy(xpath="//label[text()=' Updated On ']")  WebElement eleglblUpdatedOn;
	@FindBy(xpath="//input[@id='beginValidityDttm']") WebElement elegsftxtUpdatedOn;
		
		
	@FindBy(xpath="//label[text()=' Updated On ']")  WebElement eleglblUpdatedBy;
	@FindBy(xpath="//input[@id='updatedByName']") WebElement elegsftxtUpdatedBy;
		
	@FindBy(xpath = "(//tr[contains(@class,'accordion')])[1]/descendant::label") List<WebElement> eleAccLabels;
	
	@FindBy(xpath="//p-panelmenusub/descendant::span[text()='Broadcast Messages']") public WebElement elelinkBroadcastMessages;

	
	public ViewSystemMessagesPage verifyViewSystemMessages() throws Exception
	{
		Thread.sleep(2000);
		verifyExactText(elesfViewSystemMessages, "View System Messages");
		verifyGridHeaders(elelblGridHeaders,"  Message ID  ", "  Description  ","  Message Type  ","  Updated On  ","  Updated By  ");
		verifyAssociatedScreens(eleAssociatedScreenList,"Note Processor");
		return this;
	}
	

	public  ViewSystemMessagesPage verifySelectFilters() throws Exception
	{
		Thread.sleep(2000);
		click(eleicnFilter,"Filter");
		Thread.sleep(2000);
		verifyDisplayed(elelblMessageType, "Message Type");
		verifyDisplayed(elelblMessageID, "MessageID");
		verifyDisplayed(elelblDescription, "Description");
		verifyDisplayed(eleddUntitledSearchBy,"Untitled SearchBy");
		
		verifyDisplayed(eleicnClear,"Clear");
		verifyDisplayed(eleicnSearch,"Search");
		return this;
	}
	
	public  ViewSystemMessagesPage inquireMessageType() throws Exception
	{
		Thread.sleep(2000);
		click(eleicnFilter,"Filter");
		Thread.sleep(2000);
		selectRandomDropdownValue(eleddMessageType);
	    String messageType = eleddMessageType.getText();
	    System.out.println(messageType);
	    click(eleicnSearch,"Search");
	    Thread.sleep(2000);
	    verifyGridResult(eleGridResult, messageType);
		return this;
	}
	
	public  ViewSystemMessagesPage inquireMessageID(String query,String col1) throws Exception
	{
		String messageId = selectQuery(query,col1);
		//String messageDesc =  selectQuery(query,col2);
		Thread.sleep(2000);
		click(eleicnFilter,"Filter");
		Thread.sleep(3000);
	    clearAndType(eletxtMessageID, "Message ID", messageId);
	    pressEnterKey(eletxtMessageID);
	    Thread.sleep(3000);
	    verifyGridResult(eleGridResult, messageId.trim());
		return this;
	}
	
	
	public  ViewSystemMessagesPage inquireBySearchBy(String query,String col1) throws Exception
	{
		String desc = selectQuery(query,col1);
		Thread.sleep(2000);
		click(eleicnFilter,"Filter");
		Thread.sleep(2000);
		selectDropdownValue(eleddUntitledSearchBy, "EXACT");
	    clearAndType(eletxtDescription, "Description", desc);
	    click(eleicnSearch,"Search");
	    Thread.sleep(2000);
	    verifyGridContainsData(eleGridResult, desc);
		return this;
	}
	
	public  ViewSystemMessagesPage inquireMessageIDShowFilters(String query,String col1) throws Exception
	{
		String messageId = selectQuery(query,col1);
		//String messageDesc = selectQuery(query,col2);
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		Thread.sleep(2000);
	    clearAndType(elegsftxtMessageID, "MessageID", messageId.trim());
	    Thread.sleep(2000);
	    eletxtMessageID.sendKeys(Keys.TAB);
	    pressEnterKey(elegsftxtMessageID);
	    Thread.sleep(2000);
	    verifyGridResult(eleGridResult, messageId.trim());
		return this;
	}
	
	
	public  ViewSystemMessagesPage inquireDescriptionShowFilters(String query,String col1) throws Exception
	{
		String desc = selectQuery(query,col1);
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		Thread.sleep(2000);
	    clearAndType(eletxtDescription, "Description", desc);
	    pressEnterKey(eletxtDescription);
	    Thread.sleep(2000);
	    verifyGridResult(eleGridResult, desc);
		return this;
	}
	
	
	public  ViewSystemMessagesPage inquireUpdatedOnShowFilters(String query,String col1) throws Exception
	{
		String date = formatDate(selectQuery(query,col1));
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		Thread.sleep(2000);
		clearAndType(elegsftxtUpdatedOn, "Updated On", date);
		pressEnterKey(elegsftxtUpdatedOn);
		Thread.sleep(5000);
	    verifyGridContainsData(eleGridResult, date);
		return this;
	}
	

	public  ViewSystemMessagesPage inquireUpdatedByShowFilters(String query,String col1) throws Exception
	{
		
		String user =  selectQuery(query,col1);
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		Thread.sleep(2000);
	    clearAndType(elegsftxtUpdatedBy, "Updated By", user);
	    pressEnterKey(elegsftxtUpdatedBy);
	    Thread.sleep(2000);
	    verifyGridResult(eleGridResult, user);
		return this;
	}
	

	public ViewSystemMessagesPage testShowColumnsShowFilters() throws Exception
	{   
		Thread.sleep(2000);
		verifyShowColumns(eleicnGridOptions,"Message ID","Description","Message Type Code","Message Type","Updated On","Updated By");
		return this;
	}

	//Navigate to Edit System Messages Screen Function
	public EditSystemMessagesPage navigateToEditSystemMessages(String query,String col1) throws Exception
	{
		String errCode =  selectQuery(query,col1);
		Thread.sleep(2000);
		click(eleicnFilter,"Filter");
		click(eleicnMessageID,"Message ID");
		
		clearAndType(eleSearchBarSearch, "Search" ,errCode.trim());
		pressEnterKey(eleSearchBarSearch);
		Thread.sleep(2000);
		doubleClickGridResult(eleGridCells, errCode.trim());
		click(eleicnSearch,"Search");
		Thread.sleep(10000);
	
		doubleClickGridResult(eleGridResult,errCode.trim());
		Thread.sleep(2000);
		return new EditSystemMessagesPage();
	}
	
	//Navigate to View Broadcast Messages Screen Function
    public ViewBroadcastMessagesPage navigateToBroadcastMessages() 
    
    {
       WebDriverWait wait = new WebDriverWait(driver,50);
       wait.until(ExpectedConditions.elementToBeClickable(elelinkBroadcastMessages));
	   click(elelinkBroadcastMessages,"Broadcast Messages Link");
	   return new ViewBroadcastMessagesPage();
   }
}
