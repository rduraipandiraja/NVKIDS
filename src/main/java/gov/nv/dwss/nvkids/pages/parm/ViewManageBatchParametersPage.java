package gov.nv.dwss.nvkids.pages.parm;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import gov.nv.dwss.nvkids.pages.bstl.BatchStatusLogsPage;
import gov.nv.dwss.nvkids.pages.dref.EditDocumentAttributesPage;
import gov.nv.dwss.nvkids.pages.dref.ViewDocumentAttributesPage;
import gov.nv.dwss.nvkids.pages.rstr.ViewHighProfileRestrictedCasesPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class ViewManageBatchParametersPage extends CommonLocators
{
	public ViewManageBatchParametersPage() 
	{
		PageFactory.initElements(driver, this);
	}

	//Screen Functions
	@FindBy(xpath="(//span[text()='Manage Batch Parameters'])[1]") WebElement elesfViewManageBatchParameters;
	
	//Screen Filters
	@FindBy(xpath="//label[text()='Job ID']") WebElement elelblJobID;
	@FindBy(xpath="//input[@id='jobCode']") WebElement eletxtJobID;
	@FindBy(xpath="//input[@id='jobCode']/following-sibling::button") WebElement eleicnJobID;
	
	
	//Grid Headers and Show Filters Fields
	@FindBy(xpath="//label[text()=' Job ID ']")WebElement eleglblJobID;
	@FindBy(xpath="(//input[@id='jobCode'])[1]") WebElement elegsftxtJobID;
	@FindBy(xpath="//input[@id='jobCode']/following-sibling::button") WebElement elegsficnJobID;
	
	@FindBy(xpath="//label[text()=' Job Description ']")WebElement eleglblJobDescription;
	@FindBy(xpath="//input[@id='jobDesc']") WebElement elegsftxtJobDescription;
	
	@FindBy(xpath="//label[text()=' Job Name ']") WebElement eleglblJobName;
	@FindBy(xpath="//input[@id='processName']") WebElement elegsftxtJobName;
	
	@FindBy(xpath="//label[text()=' Run Frequency ']")  WebElement eleglblRunFrequency;
	@FindBy(xpath="//label[@for='jobFrequencyDesc']/following-sibling::p-dropdown/descendant::label")  WebElement elegsfddRunFrequency;
	
	@FindBy(xpath="//label[text()=' Run Frequency Code ']")  WebElement eleglblRunFrequencyCode;
	@FindBy(xpath="//label[@for='jobFrequencyCode']/following-sibling::p-dropdown/descendant::label")  WebElement elegsfddRunFrequencyCode;
	
	@FindBy(xpath="//label[text()=' Run Date ']")  WebElement eleglblRunDate;
	@FindBy(xpath="//input[@id='runDate']")  WebElement elegsftxtRunDate;
	@FindBy(xpath="//input[@id='runDate']/following-sibling::button")  WebElement elegsficnRunDate;
	
	@FindBy(xpath = "(//tr[contains(@class,'accordion')])[1]/descendant::label") List<WebElement> eleAccLabels;



	public ViewManageBatchParametersPage verifyViewManageBatchParameters() throws Exception
	{
		Thread.sleep(2000);
		verifyDisplayed(eleicnFilter,"Filter");
		verifyGridHeaders(elelblGridHeaders,"  Job ID  ", "  Job Description  ","  Job Name  ","  Run Frequency  ","  Run Date  ");
		verifyAssociatedScreens(eleAssociatedScreenList,"Note Processor","Batch Status Logs and Errors");
		return this;
	}
	
	
	public ViewManageBatchParametersPage verifyScreen() throws Exception
	{
		verifyExactText(elesfViewManageBatchParameters, "Manage Batch Parameters");
		return this;
	}

	public  ViewManageBatchParametersPage verifySelectFilters() throws Exception
	{
		Thread.sleep(2000);
		click(eleicnFilter,"Filter");
		Thread.sleep(2000);
		verifyDisplayed(elelblJobID,"Job ID");
		verifyDisplayed(eleicnClear,"Clear");
		verifyDisplayed(eleicnSearch,"Search");
		return this;
	}

	public ViewManageBatchParametersPage inquireJobID(String query,String jobID) throws Exception
	{
		
		String job = selectQuery(query,jobID);
		Thread.sleep(1000);
		click(eleicnFilter,"Filter");
		click(eleicnJobID,"Job ID");
		
		clearAndType(eleSearchBarSearch, "Search",job);
		pressEnterKey(eleSearchBarSearch);
		Thread.sleep(2000);
		doubleClickGridResult(eleGridCells, job);
		click(eleicnSearch,"Search");
		Thread.sleep(3000);
		verifyGridResult(eleGridResult, job);
		
		return this;
	}

	public ViewManageBatchParametersPage inquireJobIDShowFilters(String query,String jobID) throws Exception
	{
		String job = selectQuery(query,jobID);
		
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnJobID,"Job ID");
		Thread.sleep(2000);
		clearAndType(eleSearchBarSearch,"Search",job);
		pressEnterKey(eleSearchBarSearch);
		Thread.sleep(2000);
		doubleClickGridResult(eleGridCells, job);
		pressEnterKey(eletxtJobID);
		Thread.sleep(5000);
		verifyGridResult(eleGridResult, job);
		return this;
	}

	public ViewManageBatchParametersPage inquireJobDescriptionShowFilters(String query,String jobDescription) throws Exception
	{
		String jobDesc = selectQuery(query,jobDescription);
		
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		clearAndType(elegsftxtJobDescription, "Job Description", jobDesc);
		pressEnterKey(elegsftxtJobDescription);
		verifyGridResult(eleGridResult, jobDesc);
		
		return this;
	}
	
	public ViewManageBatchParametersPage inquireJobNameShowFilters(String query,String jobName) throws Exception
	{
		String jbName = selectQuery(query,jobName);
		
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		clearAndType(elegsftxtJobName, "Job Name", jbName);
		pressEnterKey(elegsftxtJobName);
		verifyGridResult(eleGridResult, jbName);
		return this;
	}

	public ViewManageBatchParametersPage inquireRunFrequencyCodeShowFilters(String query,String runFrequencyCode) throws Exception
	
	{
		String runCode =  selectQuery(query,runFrequencyCode);
		
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		selectDropdownValue(elegsfddRunFrequencyCode, runCode);
		verifyGridResult(eleGridResult, runCode);
		return this;
	}

	public ViewManageBatchParametersPage inquireRunFrequencyShowFilters(String query,String runFrequency) throws Exception
	
	{
		String runFreq =  selectQuery(query,runFrequency);
		
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		selectDropdownValue(elegsfddRunFrequency, runFreq);
		verifyGridResult(eleGridResult, runFreq);
		return this;
	}

	public ViewManageBatchParametersPage inquireRunDateShowFilters(String query,String runDate) throws Exception
	{
		String Date = formatDate(selectQuery(query,runDate));
		
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		clearAndType(elegsftxtRunDate, "Run Date", Date);
		pressEnterKey(elegsftxtRunDate);
		verifyGridResult(eleGridResult, Date);
		return this;
	}

	public ViewManageBatchParametersPage testShowColumnsShowFilters() throws Exception
	{   
		verifyShowColumns(eleicnGridOptions,"Job ID","Job Description","Job Name","Run Frequency Code","Run Frequency","Run Date");
		return this;
	}

	public ViewManageBatchParametersPage verifyAccordionFields() throws Exception {
		Thread.sleep(1000);
		click(eleicnOpenAccordion,"Accordion");
		verifyFieldSetLabels(eleAccLabels, " Commit Frequency "," Exception Threshold "," Agency File Path "," File I/O Type"," File Name ");
		return this;
	}

	//Navigate to Edit Manage Batch Parameters Screen Function
	public EditManageBatchParametersPage navigateToEditPARM(String query,String jobID) throws Exception
	{
		
		String job = selectQuery(query,jobID);
		
		Thread.sleep(2000);
		click(eleicnFilter,"Filter");
		click(eleicnJobID,"Job ID");
		
		clearAndType(eleSearchBarSearch, "Search" ,job);
		pressEnterKey(eleSearchBarSearch);
		Thread.sleep(2000);
		doubleClickGridResult(eleGridCells, job);
		click(eleicnSearch, "Search");
		Thread.sleep(7000);
		doubleClickGridResult(eleGridResult, job);
	
		return new EditManageBatchParametersPage();
	}

}
