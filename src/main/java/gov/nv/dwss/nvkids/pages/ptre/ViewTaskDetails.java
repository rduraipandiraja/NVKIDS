package gov.nv.dwss.nvkids.pages.ptre;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.fips.ViewFIPSInformationPage;
import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.pages.proc.MaintainProcessDetails;
import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class ViewTaskDetails extends CommonLocators
{

	public ViewTaskDetails() 
	{
		PageFactory.initElements(driver, this);
	}

	/* Screen functions Navigation */
	@FindBy(xpath="//span[ text()='Process Details']") public WebElement elelinkProcessDetails;


	/* Grid Column */
	@FindBy(xpath="(//tr/td[@class='text-center ng-star-inserted'])[1]/descendant::i") public WebElement eleExpandCollapse;


	/* Grid show Filters Fields  */
	@FindBy(xpath="//label[text()=' Task ID ']") public WebElement elelblShowFilterTaskID;
	@FindBy(xpath="//input[@id='taskCode']") public WebElement eletxtShowFilterTaskID;
	@FindBy(xpath="//input[@id='taskCode']/following-sibling::button") public WebElement eleicnlovShowFilterTaskID;
	@FindBy(xpath="//label[text()=' Task ']") public WebElement elelblShowFilterTask;
	@FindBy(xpath="//input[@id='taskName']") public WebElement eletxtShowFilterTask;

	@FindBy(xpath="//label[text()=' No. of Days to Complete ']") public WebElement elelblShowFilterNoOfDays;
	@FindBy(xpath="//input[@id='taskDueDayNumb']") public WebElement eletxtShowFilterNoOfDays;
	@FindBy(xpath="//label[text()=' Task Type Code ']") public WebElement elelblShowFilterTaskTypeCode;		
	@FindBy(xpath="//label[@for='taskTypeCode']/following-sibling::p-dropdown/descendant::label") public WebElement eleddShowFilterTaskTypeCode;
	@FindBy(xpath="//label[text()=' Task Type ']") public WebElement elelblShowFilterTaskType;		
	@FindBy(xpath="//label[@for='taskTypeDesc']/following-sibling::p-dropdown/descendant::label") public WebElement eleddShowFilterTaskType;
	@FindBy(xpath="//label[text()=' Updated On ']") public WebElement elelblShowFilterUpdatedOn;
	@FindBy(xpath="//input[@id='beginValidityDttm']") public WebElement eletxtShowFilterUpdatedOn;
	@FindBy(xpath="(//input[@id='beginValidityDttm']/following-sibling::button/span)[1]") public WebElement eleicncalShowFilterUpdatedOn;
	@FindBy(xpath="//label[text()=' Updated By ']") public WebElement elelblShowFilterUpdatedBy;
	@FindBy(xpath="//input[@id='updatedByName']") public WebElement eletxtShowFilterUpdatedBy;
	
	@FindBy(xpath="//table[contains(@class,'datepicker')]/descendant::td[contains(@class,'current-day')]/a") public WebElement elecalValUpdatedOn;


	/* Select Filters - fields */
	@FindBy(xpath="//label[text()='Task']") public WebElement elelblTask;
	@FindBy(xpath="//input[@id='taskCode']") public WebElement eletxtTask;
	@FindBy(xpath="//input[@id='taskCode']/following-sibling::button") public WebElement eleicnlovTask;

	public ViewTaskDetails openFilter(){
		click(eleicnFilter, "Filter Icon ");
		return this;
	}

	public ViewTaskDetails enterTask(String data){
		clearAndType(eletxtTask, "Task " , data);
		return this;
	}

	public ViewTaskDetails clickSearch(){
		click(eleicnSearch, "Search Icon");
		return this;
	}

	public ViewTaskDetails  clickClear(){
		click(eleicnClear, "Clear Icon");
		return this;

	}
	public ViewTaskDetails viewStatusBar(String expectedText){
		verifyExactText(eleErrStatusBar, expectedText);
		return this;

	}

	public MaintainProcessDetails stickyDataToPROC() {
		openFilter();
		click(eleQuickNavigation, "Quick Navigation");
		clearAndType(eletxtQuickNavigationText,"Quick Navigation", "PROC");
		pressEnterKey(eletxtQuickNavigationText);
		return new MaintainProcessDetails();
	}

	public ViewTaskDetails verifyScreenFields() throws Exception
	{


		Thread.sleep(3000);
		verifyDisplayed(eleicnFilter, "Filter Icon");
		verifyAssociatedScreens(eleAssociatedScreenList,"Maintain Process","Case Processor");
		verifyGridHeaders(elelblGridHeaders," Task ID "," Task "," No. of Days to Complete "," Task Type "," Updated On "," Updated By ");
		return this;
	}


	public ViewTaskDetails verifySelectFilters() throws Exception{


		Thread.sleep(3000);
		openFilter();
		verifyDisplayed(eleicnSearch, "Search Icon");
		verifyDisplayed(eleicnClear,"Clear Icon");
		verifyDisplayed(elelblTask,"Task Field");
		return this;
	}
	

	public ViewTaskDetails inquireValidValue(String query, String taskCode) throws Exception{
		
		openFilter();
		click(eleicnlovTask, "Task LOV Icon");
		String data = selectQuery(query, taskCode);
		clearAndType(eleSearchBarSearch, "Search Bar" ,data);
		pressEnterKey(eleSearchBarSearch);
		doubleClickGridResult(eleGridCells, data);
		click(eleicnSearch, "Search Icon");
		Thread.sleep(3000);
		verifyGridResult(eleGridResult,data);
		return this;
	}
	

	
	public ViewTaskDetails verifyShowColumnsPTRE(){

		verifyShowColumns(eleicnGridOptions,"Task ID","Task","No. of Days to Complete","Task Type Code","Task Type","Updated On","Updated By");
		return this;
	}



	
	
	public ViewTaskDetails verifyAccShowColumnsPTRE(){
		click(eleExpandCollapse, "Expand Icon");
		verifyShowColumns(eleicnAccGridOptions,"Role ID","Role","Category Code","Category","Process Code","Process");
		return this;
	}


	
	
	
	public ViewTaskDetails inquireNullValueinTask(String query, String taskCode) throws Exception{

		openFilter();
		click(eleicnSearch, "Search Icon");
		Thread.sleep(3000);
		String data = selectQuery(query, taskCode);
		verifyGridResult(eleGridResult,data);
		return this;
	}

	
	public ViewTaskDetails inquireValidValueinSFNoDaysToComplete(String query, String days) throws InterruptedException, ClassNotFoundException, SQLException{

		click(eleicnGridOptions, "Grid Options Icon");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions, "Grid Options Icon");
		Thread.sleep(3000);
		String data = selectQuery(query, days);
		clearAndType(eletxtShowFilterNoOfDays, "No of Days to Complete Field", data);
		pressEnterKey(eletxtShowFilterNoOfDays);
		verifyGridResult(eleGridResult, data);
		return this;
	}
	

	public ViewTaskDetails verifySelectingTaskTypeCode(String query, String taskTypeCode) throws InterruptedException, ClassNotFoundException, SQLException {

		Thread.sleep(3000);
		selectShowColumn(eleicnGridOptions,"Task Type Code");
		click(eleicnGridOptions, "Grid Options Icon");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions, "Grid Options Icon");
		String data = selectQuery(query, taskTypeCode);
		selectDropdownValue(eleddShowFilterTaskTypeCode, data);
		verifyGridResult(eleGridResult,"A");		
		return this;

	}

	public ViewTaskDetails verifySelectingTaskType(String query, String taskTypeCodeDesc) throws InterruptedException, ClassNotFoundException, SQLException {

		Thread.sleep(3000);
		selectShowColumn(eleicnGridOptions,"Task Type Code");
		click(eleicnGridOptions, "Grid Options Icon");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions, "Grid Options Icon");
		String data = selectQuery(query, taskTypeCodeDesc);
		System.out.println("The output value is : "+ data);
		selectDropdownValue(eleddShowFilterTaskType, data);
		verifyGridResult(eleGridResult,data);		
		return this;

	}

	public ViewTaskDetails inquireValidValuInUpdatedOn(String query, String updatedOn) throws ClassNotFoundException, SQLException {
		click(eleicnGridOptions, "Grid Options Icon");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions, "Grid Options Icon");
		String data = formatDate(selectQuery(query, updatedOn));
		clearAndType(eletxtShowFilterUpdatedOn, "Updated On",data);
		verifyGridContainsData(eleGridResult, data);
		return this;
	}

	public ViewTaskDetails inquireValidValuInUpdatedBy(String query, String updatedBy) throws ClassNotFoundException, SQLException {
		click(eleicnGridOptions, "Grid Options Icon");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions, "Grid Options Icon");
		String data = selectQuery(query, updatedBy);
		clearAndType(eletxtShowFilterUpdatedBy, "Updated By", data);
		pressEnterKey(eletxtShowFilterUpdatedBy);
		verifyGridResult(eleGridResult,data );
		return this;
	}


	
	


	

	



}
