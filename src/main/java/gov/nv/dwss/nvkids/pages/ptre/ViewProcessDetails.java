package gov.nv.dwss.nvkids.pages.ptre;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import gov.nv.dwss.nvkids.pages.fips.ViewFIPSInformationPage;
import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.pages.proc.MaintainProcessDetails;
import gov.nv.dwss.nvkids.pages.refm.ViewReferenceCodesPage;
import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class ViewProcessDetails extends CommonLocators

{

	public ViewProcessDetails() 
	{
		PageFactory.initElements(driver, this);
	}

	/*Screen functions Navigation */
	@FindBy(xpath="//span[ text()='Task Details']") public WebElement elelinkTaskDetails;


	/*Select Filers: */
	@FindBy(xpath="//label[text()='Process']") public WebElement elelblProcessID;
	@FindBy(xpath="//input[@id='processCode']") public WebElement eletxtProcessID;
	@FindBy(xpath="//input[@id='processCode']/following-sibling::button") public WebElement eleicnlovProcess;
	@FindBy(xpath="//tbody[@class='ui-table-tbody']") public WebElement eleLOVTable;


	/*Grid show Filters Fields */
	@FindBy(xpath="//label[text()=' Process ID ']") public WebElement elelblShowFilterProcessID;
	@FindBy(xpath="//input[@id='processCode']") public WebElement eletxtShowFilterProcessID;
	@FindBy(xpath="//input[@id='processCode']/following-sibling::button") public WebElement eleicnlovShowFilterProcessID;
	@FindBy(xpath="//label[text()=' Process ']") public WebElement elelblShowFilterProcess;
	@FindBy(xpath="//input[@id='processName']") public WebElement eletxtShowFilterProcess;
	@FindBy(xpath="//label[text()=' Category Code ']") public WebElement elelblShowFilterCategoryCode;
	@FindBy(xpath="//label[@for='processSubsystemCode']/following-sibling::p-dropdown/descendant::label") public WebElement eleddShowFilterCategoryCode;
	@FindBy(xpath="//label[text()=' Category ']") public WebElement elelblShowFilterCategory;
	@FindBy(xpath="//label[@for='processSubsystemDesc']/following-sibling::p-dropdown/descendant::label") public WebElement eleddShowFilterCategory;
	@FindBy(xpath="//label[text()=' Manual Start Code ']") public WebElement elelblShowFilterManualStartCode;
	@FindBy(xpath="//label[@for='manualStartCode']/following-sibling::p-dropdown/descendant::label") public WebElement eleddShowFilterManualStartCode;
	@FindBy(xpath="//label[text()=' Manual Start ']") public WebElement elelblShowFilterManualStart;
	@FindBy(xpath="//label[@for='manualStartDesc']/following-sibling::p-dropdown/descendant::label") public WebElement eleddShowFilterManualStart;
	@FindBy(xpath="//label[text()=' Updated On ']") public WebElement elelblShowFilterUpdatedOn;
	@FindBy(xpath="//input[@id='beginValidityDttm']") public WebElement eletxtShowFilterUpdatedOn;
	@FindBy(xpath="(//input[@id='beginValidityDttm']/following-sibling::button/span)[1]") public WebElement eleicncalShowFilterUpdatedOn;
	@FindBy(xpath="//label[text()=' Updated By ']") public WebElement elelblShowFilterUpdatedBy;
	@FindBy(xpath="//input[@id='updatedByName']") public WebElement eletxtShowFilterUpdatedBy;
	
	@FindBy(xpath="//table[contains(@class,'datepicker')]/descendant::td[contains(@class,'today') or contains(@class,'current')]") public WebElement elecalValTodayUpdatedOn;
	

	public ViewProcessDetails quickNavigation_PTREagain() throws IOException
	{
		
		
		click(eleQuickNavigation, "Quick Navigation");
		clearAndType(eletxtQuickNavigationText,"Quick Navigation", "PTRE");
		pressEnterKey(eletxtQuickNavigationText);
		return  this;
	}

	public EditProcessDetails navigateToEditProcessDetails(String query, String processCode) throws IOException, InterruptedException, ClassNotFoundException, SQLException
	{   

		openFilter();
		String data = selectQuery(query, processCode);
		enterProcessID(data);
		clickSearch();
		Thread.sleep(3000);
		doubleClickGridResult(eleGridResult,data);
		Thread.sleep(3000);
		return  new EditProcessDetails();
	}

	public ViewTaskDetails navigateToViewTaskDetails() throws IOException, InterruptedException
	{   
		click(elelinkTaskDetails, "Task Details");
		return  new ViewTaskDetails();
	}
	
	

	public ViewProcessDetails openFilter(){

		click(eleicnFilter, "Filter Icon");
         return this;
	}
  
	
	public ViewProcessDetails enterProcessID(String data){
		clearAndType(eletxtProcessID, "Process ID", data);
		
		return this;
	}

	public ViewProcessDetails clickSearch(){

		click(eleicnSearch, "Search Icon");
		return this;
	}

	public void  clickClear(){
		click(eleicnClear, "Clear Icon");

	}
	public ViewProcessDetails viewStatusBar(String expectedText){
		verifyExactText(eleErrStatusBar, expectedText);
		return this;

	}


	public void verifyScreenFields() throws Exception
	{
		Thread.sleep(3000);
		
		verifyAssociatedScreens(eleAssociatedScreenList,"Maintain Process","Case Processor");
		verifyDisplayed(eleicnFilter, "Filter Icon");
		verifyGridHeaders(elelblGridHeaders,"Process ID","Process","Category","Manual Start","Updated On","Updated By");
	}

	public void verifySelectFilters() throws Exception{

		Thread.sleep(3000);
		openFilter();
		Thread.sleep(3000);
		verifyDisplayed(eleicnSearch, "Search Icon");
		verifyDisplayed(eleicnClear, "Clear Icon");
		verifyDisplayed(elelblProcessID,"Process ID");
	}


	
	public ViewProcessDetails InquireValidValue(String query, String processCode, String processDec) throws Exception{


		Thread.sleep(3000);
		openFilter();
		String value = selectQuery(query, processCode);
		enterProcessID(value);
		clickSearch();
		Thread.sleep(3000);
		verifyGridResult(eleGridResult,value);
        return new ViewProcessDetails();

	}

	public void verifyShowColumnsPTRE() throws InterruptedException{
		Thread.sleep(2000);
		verifyShowColumns(eleicnGridOptions,"Process ID","Process","Category Code","Category","Manual Start Code","Manual Start","Updated On","Updated By");
	}

	

	public void inquirewithNoValue(String query, String processCode) throws Exception{


		Thread.sleep(3000);
		openFilter();
		Thread.sleep(1000);
		clickSearch();
		Thread.sleep(3000);
		String value = selectQuery(query, processCode);
		verifyGridResult(eleGridResult,value);
	}
	

	public void  inquireValidValueinSFProcessID(String query, String processCode)  throws InterruptedException, ClassNotFoundException, SQLException {
		click(eleicnGridOptions, "Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions, "Grid Options");
		String data = selectQuery(query, processCode);
		clearAndType(eletxtShowFilterProcessID, "Process ID", data);
		Thread.sleep(1500);
		verifyGridResult(eleGridResult, data);
	}
	public void inquireValidValueinSFProcess (String query, String process) throws InterruptedException, ClassNotFoundException, SQLException {
		click(eleicnGridOptions, "Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions, "Grid Options");
		String data = selectQuery(query, process);
		clearAndType(eletxtShowFilterProcess, "Process ", data);
		Thread.sleep(1500);
		verifyGridResult(eleGridResult, data);

	}

	public void inquireSelectingSFCategoryCode(String Query, String categorycode) throws InterruptedException, ClassNotFoundException, SQLException {
		selectShowColumn(eleicnGridOptions,"Category Code");
		click(eleicnGridOptions, "Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions, "Grid Options");
		String value = selectQuery(Query, categorycode);
		selectDropdownValue(eleddShowFilterCategoryCode, value);
		Thread.sleep(1500);
		verifyGridResult(eleGridResult, value);


	}
	
	// done

	public void inquireSelectingSFCategory(String query , String categoryDesc) throws InterruptedException, ClassNotFoundException, SQLException {

		Thread.sleep(3000);
		click(eleicnGridOptions, "Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions, "Grid Options");
		String value = selectQuery(query, categoryDesc);
		selectDropdownValue(eleddShowFilterCategory, value);
		Thread.sleep(1500);
		verifyGridResult(eleGridResult,value);
	}
	public void inquireSelectingSFManualStartCode(String query, String manualCode ) throws InterruptedException, ClassNotFoundException, SQLException {
		selectShowColumn(eleicnGridOptions,"Manual Start Code");
		Thread.sleep(2500);
		click(eleicnGridOptions, "Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions, "Grid Options");
		String data = selectQuery(query, manualCode);
		selectDropdownValue(eleddShowFilterManualStartCode, data);
		Thread.sleep(2500);
		verifyGridResult(eleGridResult, data);
	}
	public void inquireSelectingSFManualStart(String query, String manualDesc) throws InterruptedException, ClassNotFoundException, SQLException {

		click(eleicnGridOptions, "Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions, "Grid Options");
		String data = selectQuery(query, manualDesc);
		selectDropdownValue(eleddShowFilterManualStart, data);
		Thread.sleep(2500);
		verifyGridResult(eleGridResult, data);
	}

	public void inquireValidValuInUpdatedOn(String query, String updatedOn) throws ClassNotFoundException, SQLException {
		click(eleicnGridOptions, "Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions, "Grid Options");
		String formatDate = formatDate(selectQuery(query, updatedOn));
		clearAndType(eletxtShowFilterUpdatedOn, "Updated On", formatDate);
		verifyGridContainsData(eleGridResult, formatDate);
	}

	public void inquireValidValuInUpdatedBy(String query, String udatedBy) throws ClassNotFoundException, SQLException {
		click(eleicnGridOptions, "Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions, "Grid Options");
		String data = selectQuery(query, udatedBy);
		clearAndType(eletxtShowFilterUpdatedBy, "Updated By", data);
		pressEnterKey(eletxtShowFilterUpdatedBy);
		verifyGridResult(eleGridResult,data );
	}
	
	public void verifyFieldDisappeared(WebElement lbl , WebElement ele) {
		try {
			if(ele.isDisplayed()==false) {
				reportStep("The element:"+lbl.getText()+" is Disappeared", "pass");
			}
			else if(ele.isDisplayed()==true) {
				reportStep("The element:"+lbl.getText()+" Show Filter is Still appeared", "fail");
			}
		}
		catch(Exception e) 
		{
			reportStep("The element:"+lbl.getText()+" Show Filter is Disappeared", "pass");
		}
		finally {
			takeSnap();
		}

	}


}
