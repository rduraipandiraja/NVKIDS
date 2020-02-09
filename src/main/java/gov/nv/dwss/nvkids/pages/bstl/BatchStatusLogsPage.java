package gov.nv.dwss.nvkids.pages.bstl;


import java.sql.SQLException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import gov.nv.dwss.nvkids.pages.refm.ViewReferencePercentagesPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class BatchStatusLogsPage extends CommonLocators 
{
	public BatchStatusLogsPage() 
	{
		PageFactory.initElements(driver, this);
	}
		
	
	//Filter Section
			
	@FindBy(xpath="//span[text()='Batch Status Logs and Errors']")  WebElement elelinkBatchStatusLogs;		
	@FindBy(xpath="//label[text()=' From Date ' ]") WebElement elelblsfFromDate;
	@FindBy(id="fromDate") WebElement eletxtFromDate;
	@FindBy(xpath="(//label[text()=' From Date ']/following::button)[1]") WebElement eleicnFromDate;
	@FindBy(xpath="//label[text()=' Through Date ' ]") WebElement elelblsfThroughDate;
	@FindBy(id="toDate")  WebElement eletxtThroughDate;	
	@FindBy(xpath="(//label[text()=' Through Date ']/following::button)[1]") WebElement eleicnThroughDate;
	
	//Grid Section
	@FindBy(xpath="//label[text()=' Process Date ']")  WebElement elelblProcessDate;		
	@FindBy(xpath="//label[text()=' Job ID ']") WebElement elelblJobID;
	@FindBy(xpath="//label[text()=' Job Description ']") WebElement elelblJobDescription;
	@FindBy(xpath="//label[text()=' Batch Name ']") WebElement elelblBatchName;
	@FindBy(xpath="//label[text()=' Start Time ']") WebElement elelblStartTime;
	@FindBy(xpath="//label[text()=' End Time ']")  WebElement elelblEndTime;	
	@FindBy(xpath="//label[text()=' Record Count ']") WebElement elelblRecordCount;
	@FindBy(xpath="//label[text()=' Batch Status Code ']") WebElement elelblBatchStatusCode;
	@FindBy(xpath="//label[text()=' Batch Status ']") WebElement elelblBatchStatus;
	@FindBy(xpath="//label[text()=' Process Date ']/following::i[contains(@class,'ui-sortable-column-icon')][1]") WebElement eleSortProcessDate;
	
	//Grid Accordion section
	@FindBy(xpath="//label[text()=' Procedure Name ']") WebElement elealblProcedureName;
	@FindBy(xpath="//label[text()=' Error/Seq ']") WebElement elealblErrorSeq;
	@FindBy(xpath="//label[text()=' Worker ']") WebElement elealblWorker;
	@FindBy(xpath="//label[text()=' Cursor Location ']") WebElement elealblCursorLocation;
	@FindBy(xpath="//label[text()=' Execution Location ']") WebElement elealblExecutionLocation;
	@FindBy(xpath="//label[text()=' Key Values ']") WebElement elealblKeyValues;
	@FindBy(xpath="//label[text()=' Error Description ']") WebElement elealblErrorDescription;
	
	@FindBy(id="effectiveRunDate") WebElement elegsftxtProcessDate;
	@FindBy(id="jobCode") WebElement elegsftxtJobID;
	@FindBy(id="jobDesc") WebElement elegsftxtJobDescription;
	@FindBy(id="processName") WebElement elegsftxtBatchName;
	@FindBy(id="jobStartDttm") WebElement elegsftxtStartTime;
	@FindBy(id="jobEndDttm") WebElement elegsftxtEndTime;
	@FindBy(id="processedRecordCountNumb") WebElement elegsftxtRecordCount;
	@FindBy(xpath="//label[text()='Batch Status']/following-sibling::p-dropdown/div") WebElement elegsfddBatchStatus;
	@FindBy(xpath="//label[text()='Batch Status Code']/following-sibling::p-dropdown/div") WebElement elegsfddBatchStatusCode;
	
	//Screen Functions
	@FindBy(xpath = "//span[text()='Batch Errors']") WebElement elelinkBatchErrors;	
	@FindBy(xpath = "//span[text()='Print Queue Errors']") WebElement elelinkPrintQueueErrors;
	
	
	// Grid Data
	@FindBy(xpath = "//table/tbody/tr/td/span") WebElement EleGridData;
	@FindBy(xpath="//lib-label-value/descendant::label") List<WebElement> elealbls;
	@FindBy(xpath="(//span[text()='View Batch Status Logs'])[1]") WebElement elebrdScreenFunctionName;
	@FindBy(xpath="//span[text()='View Batch Status Logs']/following::td[1]/span") WebElement elegdataProcessDate;
	@FindBy(xpath="//span[text()='View Batch Status Logs']/following::td[2]/span") WebElement elegdataJobID;
	@FindBy(xpath="//span[text()='View Batch Status Logs']/following::td[3]/span") WebElement elegdataJobDescription;
	@FindBy(xpath="//span[text()='View Batch Status Logs']/following::td[4]/span") WebElement elegdataBatchName;
	@FindBy(xpath="//span[text()='View Batch Status Logs']/following::td[5]/span") WebElement elegdataStartTime;
	@FindBy(xpath="//span[text()='View Batch Status Logs']/following::td[6]/span") WebElement elegdataEndTime;
	@FindBy(xpath="//span[text()='View Batch Status Logs']/following::td[7]/span") WebElement elegdataRecordCount;
	@FindBy(xpath="//span[text()='View Batch Status Logs']/following::td[8]/span") WebElement elegdataBatchStatusCode;
	@FindBy(xpath="//span[text()='View Batch Status Logs']/following::td[9]/span") WebElement elegdataBatchStatus;
	
	
	public BatchErrorsPage navigatetoBatchErrors() throws InterruptedException 
	{
		click(elelinkBatchErrors,"Batch Errors");
		Thread.sleep(3000);
		return new BatchErrorsPage();
	}
	
	
	public PrintQueueErrorsPage navigatetoPrintQueueErrors() throws InterruptedException 
	{
		click(elelinkPrintQueueErrors,"Print Queue Errors");
		Thread.sleep(3000);
		return new PrintQueueErrorsPage();
	}
	
	public BatchStatusLogsPage verifyFieldsPresent() throws Exception
	{
		verifyGridHeaders(elelblGridHeaders,"Process Date","Job Description","Batch Name","Start Time","End Time","Record Count","Batch Status");
		return this;
	}
	
	public BatchStatusLogsPage verifySelectFilterFields() throws Exception
	{
		click(eleicnFilter,"Filter");
		verifyDisplayed(elelblsfFromDate,"From Date");
		verifyDisplayed(elelblsfThroughDate,"Through Date");
		return this;
	}
	
	public BatchStatusLogsPage verifyScreenFunction() throws Exception
	{
		verifyExactText(elebrdScreenFunctionName,"View Batch Status Logs");
		return this;
	}
	
	public BatchStatusLogsPage inquirewithFromDate()
	{
		clearAndType(elelblsfFromDate,"From Date", "10312019");
		setPastDate(eletxtThroughDate,2);
		click(eleicnSearch,"Search");
		return this;
	}

	public BatchStatusLogsPage inquireWithValidValues(String fDate, String colName1,String tDate, String colName2) throws InterruptedException, ClassNotFoundException, SQLException
	{
		Thread.sleep(2000);
		click(eleicnFilter,"Filter");
		String fromDate = formatDate(selectQuery(fDate, colName1));
		String throughDate = formatDate(selectQuery(tDate, colName2));
		clearAndType(eletxtFromDate, "From Date",fromDate);
		clearAndType(eletxtThroughDate, "Through Date",throughDate);
		Thread.sleep(3000);
		click(eleicnSearch,"Search");
		Thread.sleep(5000);
		return this;
	}
	
	public BatchStatusLogsPage verifySuccessfulInquiry(String fDate,String colName1,String tDate,String colName2) throws InterruptedException, ClassNotFoundException, SQLException
	{
		Thread.sleep(2000);
		click(eleicnFilter, "Filter");
		String fromDate = formatDate(selectQuery(fDate, colName1));
		String throughDate = formatDate(selectQuery(tDate, colName2));
		clearAndType(eletxtFromDate, "From Date",fromDate);
		clearAndType(eletxtThroughDate, "Through Date",throughDate);
		click(eleicnSearch,"Search");
		verifyGridRecordsPresent(eleGridRecord);
		return this;
	}
	
	public BatchStatusLogsPage verifyResult(String processDate) throws InterruptedException
	{
		try
		{
			click(eleicnGridOptions,"Grid Options");
			CheckShowFilters(eleGridShowFilters);
			click(eleicnGridOptions,"Grid Options");
			clearAndType(elegsftxtProcessDate,"Process Date",processDate);
			pressEnterKey(elegsftxtProcessDate);
			Thread.sleep(3000);
			if(!elegdataProcessDate.getText().replace("/", "").equals(processDate)) 
			{
				reportStep("Records are displayed correctly within the given date ranges ", "pass");
				clear(elegsftxtProcessDate,"Process Date");
			}
			else
			{
				reportStep("Records are displayed outside the given date ranges", "fail");
				clear(elegsftxtProcessDate,"Process Date");
			}
		}
		catch(Exception e)
		{
			String str = e.toString();
			reportStep("Unable to access the element - " + str, "fail");
		}
		return this;
	}
	
	public BatchStatusLogsPage inquireWithShowFilterProcessDate(String fDate, String colName1,String tDate, String colName2) throws Exception
	{
		System.out.println(formatDate(selectQuery(fDate, colName1).toString()));
		inquireWithValidValues(fDate,colName1,tDate,colName2);
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		String processDate = formatDate(selectQuery(fDate, colName1));
		clearAndType(elegsftxtProcessDate,"Process Date", processDate);
		pressEnterKey(elegsftxtProcessDate);
		Thread.sleep(2000);
		verifyGridResult(eleGridResult, processDate);
		return this;
	}
	
	public BatchStatusLogsPage inquireWithShowFilterJobID(String fDate, String colName1,String tDate, String colName2,String colName3) throws Exception
	{
		inquireWithValidValues(fDate,colName1,tDate,colName2);
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		String jobID = selectQuery(fDate, colName3);
		clearAndType(elegsftxtJobID, "Job ID", jobID);
		pressEnterKey(elegsftxtJobID);
		Thread.sleep(2000);
		verifyGridResult(eleGridResult, jobID);
		return this;
	}
	
	public BatchStatusLogsPage inquireWithShowFilterJobDescription(String fDate, String colName1,String tDate, String colName2,String jobDesc, String colName3) throws Exception
	{
		inquireWithValidValues(fDate,colName1,tDate,colName2);
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions, "Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		String jobDescription = selectQuery(jobDesc, colName3);
		clearAndType(elegsftxtJobDescription, "Job Description", jobDescription);
		pressEnterKey(elegsftxtJobDescription);
		Thread.sleep(2000);
		verifyGridResult(eleGridResult, jobDescription);
		return this;
	}
	
	public BatchStatusLogsPage inquireWithShowFilterBatchName(String fDate, String colName1,String tDate, String colName2,String batchName,String colName3) throws Exception
	{
		inquireWithValidValues(fDate,colName1,tDate,colName2);
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		String batchNm = selectQuery(batchName, colName3);
		clearAndType(elegsftxtBatchName, "Batch Name",batchNm );
		pressEnterKey(elegsftxtBatchName);
		Thread.sleep(2000);
		verifyGridResult(eleGridResult, batchNm);
		return this;
	}
	
	public BatchStatusLogsPage inquireWithShowFilterStartTime(String fDate, String colName1,String tDate, String colName2,String startTime,String colName3) throws Exception
	{
		inquireWithValidValues(fDate,colName1,tDate,colName2);
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		String stTime = formatDate(selectQuery(startTime, colName3));
		clearAndType(elegsftxtStartTime, "Start Time", stTime);
		pressEnterKey(elegsftxtStartTime);
		Thread.sleep(2000);
		verifyGridResult(eleGridResult, stTime);
		return this;
	}
	
	public BatchStatusLogsPage inquireWithShowFilterEndTime(String fDate, String colName1,String tDate, String colName2,String endTime,String colName3) throws Exception
	{
		inquireWithValidValues(fDate,colName1,tDate,colName2);
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		String eTime = formatDate(selectQuery(endTime, colName3));
		clearAndType(elegsftxtEndTime, "End Time", eTime);
		pressEnterKey(elegsftxtEndTime);
		Thread.sleep(2000);
		verifyGridResult(eleGridResult, eTime);
		return this;
	}
	
	public BatchStatusLogsPage inquireWithShowFilterRecordCount(String fDate, String colName1,String tDate, String colName2,String recordCount,String colName3) throws Exception
	{
		inquireWithValidValues(fDate,colName1,tDate,colName2);
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		String reCount = selectQuery(recordCount, colName3);
		clearAndType(elegsftxtRecordCount, "Record Count", reCount);
		pressEnterKey(elegsftxtRecordCount);
		Thread.sleep(2000);
		verifyGridResult(eleGridResult, reCount);
		return this;
	}
	
	
	public BatchStatusLogsPage inquireWithShowFilterBatchStatusCode(String fDate, String colName1,String tDate, String colName2,String batchStatusCode,String colName3) throws Exception
	{
		inquireWithValidValues(fDate,colName1,tDate,colName2);
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		String batchStatCode = selectQuery(batchStatusCode, colName3).trim();
		selectDropdownValue(elegsfddBatchStatusCode, batchStatCode);
		Thread.sleep(2000);
		verifyGridResult(eleGridResult, batchStatCode);
		return this;
	}
	
	public BatchStatusLogsPage inquireWithShowFilterBatchStatus(String fDate, String colName1,String tDate, String colName2,String batchStatus,String colName3) throws Exception
	{
		inquireWithValidValues(fDate,colName1,tDate,colName2);
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		String batchStat = selectQuery(batchStatus, colName3);
		selectDropdownValue(elegsfddBatchStatus,batchStat );
		Thread.sleep(2000);
		verifyGridResult(eleGridResult, batchStat);
		return this;
	}
	
	public BatchStatusLogsPage checkShowColumnsOption() throws Exception
	{
		
		Thread.sleep(2000);
		verifyShowColumns(eleicnGridOptions, "Process Date","Job ID","Job Description","Batch Name","Start Time","End Time","Record Count","Batch Status Code","Batch Status");
		return this;
	}
}
