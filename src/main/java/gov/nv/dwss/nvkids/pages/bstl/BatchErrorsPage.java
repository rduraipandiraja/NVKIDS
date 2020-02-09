package gov.nv.dwss.nvkids.pages.bstl;



import java.sql.SQLException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class BatchErrorsPage extends CommonLocators 
{
	public BatchErrorsPage() 
	{
		PageFactory.initElements(driver, this);
	}
		
	//Screen functions
	@FindBy(xpath = "//span[text()='Print Queue Errors']") WebElement elelinkPrintQueueErrors;
	@FindBy(xpath = "//span[text()='Batch Status Logs']") WebElement elelinkBatchStatusLogs;
	
	
	//Filter Section
	@FindBy(id="effectiveRunDate") WebElement eletxtProcessDate;
	@FindBy(xpath="(//label[text()=' Process Date '])[2]") WebElement elelblsfProcessDate;
	@FindBy(xpath="//label[text()=' Process Date ']/following::button[1]") WebElement eleicnProcessDate;
	
	
	//Grid Section
	@FindBy(xpath="(//label[text()=' Process Date '])[1]") WebElement elelblProcessDate;
	@FindBy(xpath="//label[text()=' Job ID ']") WebElement elelblJobID;
	@FindBy(xpath="//label[text()=' Job Description ']") WebElement elelblJobDescription;
	@FindBy(xpath="//label[text()=' Batch Name ']") WebElement elelblBatchName;
	@FindBy(xpath="//label[text()=' Message Type Code ']") WebElement elelblMessageTypeCode;
	@FindBy(xpath="//label[text()=' Message Type ']") WebElement elelblMessageType;
	@FindBy(xpath="//label[text()=' Create Time ']") WebElement elelblCreateTime;
	
	
	
	//Grid Accordion section
	@FindBy(xpath="//label[text()=' Key Values ']") WebElement elealblKeyValues;
	@FindBy(xpath="//label[text()=' Error Description ']") WebElement elealblErrorDescription;
	@FindBy(id="effectiveRunDate") WebElement elegsfdsoProcessDate;
	@FindBy(id="jobCode") WebElement elegsftxtJobID;
	@FindBy(id="jobDesc") WebElement elegsftxtJobDescription;
	@FindBy(id="processName") WebElement elegsftxtBatchName;
	@FindBy(xpath="//label[text()='Message Type Code']/following-sibling::p-dropdown/div") WebElement elegsfddMessageTypeCode;
	@FindBy(xpath="//label[text()='Message Type']/following-sibling::p-dropdown/div") WebElement elegsfddMessageType;
	@FindBy(id="updateDttm") WebElement elegsftxtCreateTime;
	@FindBy(xpath="//lib-label-value/descendant::label") List<WebElement> elealbls;
	
	
	
	// Grid Data
	@FindBy(xpath = "//table/tbody/tr/td/span") WebElement eleGridData;
	@FindBy(xpath = "//span[text()='View Batch Errors']/following::td[1]/span") WebElement elegdataProcessDate;
	@FindBy(xpath = "//span[text()='View Batch Errors']/following::td[2]/span") WebElement elegdataJobID;
	@FindBy(xpath = "//span[text()='View Batch Errors']/following::td[3]/span") WebElement elegdataJobDescription;
	@FindBy(xpath = "//span[text()='View Batch Errors']/following::td[4]/span") WebElement elegdataBatchName;
	@FindBy(xpath = "//span[text()='View Batch Errors']/following::td[5]/span") WebElement elegdataMessageTypeCode;
	@FindBy(xpath = "//span[text()='View Batch Errors']/following::td[6]/span") WebElement elegdataMessageType;
	@FindBy(xpath = "//span[text()='View Batch Errors']/following::td[7]/span") WebElement elegdataCreateTime;
			
		
	public PrintQueueErrorsPage navigateToPrintQueueErrors() throws InterruptedException 
	{
		click(elelinkPrintQueueErrors,"Print Queue Errors Page");
		Thread.sleep(3000);
		return new PrintQueueErrorsPage();
	}
		
	public BatchStatusLogsPage navigateToBatchStatusLogs() throws InterruptedException 
	{
		click(elelinkBatchStatusLogs,"Batch Status Logs Page");
		Thread.sleep(3000);
		return new BatchStatusLogsPage();
	}
		
	public BatchErrorsPage verifyFieldsPresent() throws Exception
	{
		verifyGridHeaders(elelblGridHeaders,"Process Date","Job Description","Batch Name","Message Type","Create Time");
		return this;
	}
	
	public BatchErrorsPage verifySelectFilterFields() throws Exception
	{
		click(eleicnFilter,"Filter");
		verifyDisplayed(elelblsfProcessDate, "Process Date");
		return this;
	}
	
		
	public BatchErrorsPage inquireWithProcessDate() throws InterruptedException
	{
		click(eleicnFilter,"Filter");
		clearAndType(eletxtProcessDate,"Process Date", "12142019");
		click(eleicnSearch,"Search");	
		Thread.sleep(5000);
		return this;
	}
	public BatchErrorsPage inquireWithValidValues(String processDate,String colName) throws InterruptedException, ClassNotFoundException, SQLException
	{
		click(eleicnFilter,"Filter");
		String pDate = formatDate(selectQuery(processDate, colName));
		clearAndType(eletxtProcessDate,"Process Date",pDate );
		click(eleicnSearch,"Search");		
		Thread.sleep(3000);
		verifyGridResult(eleGridResult,pDate);
		return this;
	}

	public BatchErrorsPage inquireWithShowFilterJobID(String jobID,String colName1) throws Exception
	{
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		String jID = selectQuery(jobID, colName1);
		clearAndType(elegsftxtJobID, "JobID", jID);
		pressEnterKey(elegsftxtJobID);
		Thread.sleep(2000);
		verifyGridResult(eleGridResult, jID);
		return this;
	}
	
	public BatchErrorsPage inquireWithShowFilterJobDescription(String jobDesc,String colName2) throws Exception
	{
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		String jobDsc = selectQuery(jobDesc, colName2);
		clearAndType(elegsftxtJobDescription, "Job Description",jobDsc );
		pressEnterKey(elegsftxtJobDescription);
		Thread.sleep(2000);
		verifyGridResult(eleGridResult, jobDsc);
		return this;
	}
	
	public BatchErrorsPage inquireWithShowFilterBatchName(String batchName,String colName2) throws Exception
	{
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		String bName = selectQuery(batchName, colName2);
		clearAndType(elegsftxtBatchName, "Batch Name",bName );
		pressEnterKey(elegsftxtBatchName);
		Thread.sleep(2000);
		verifyGridResult(eleGridResult, bName);
		return this;
	}
	
	public BatchErrorsPage inquireWithShowFilterMessageTypeCode(String msgTypeCode,String colName1) throws Exception
	{
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		String msgTpCode = selectQuery(msgTypeCode, colName1);
		selectDropdownValue(elegsfddMessageTypeCode, msgTpCode);
		Thread.sleep(2000);
		verifyGridResult(eleGridResult, msgTpCode);
		return this;
	}
	
	public BatchErrorsPage inquireWithShowFilterMessageType(String msgType,String colName1) throws Exception
	{
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		String msType = selectQuery(msgType, colName1);
		selectDropdownValue(elegsfddMessageType, msType);
		Thread.sleep(2000);
		verifyGridResult(eleGridResult, msType);
		return this;
	}
	
	public BatchErrorsPage inquireWithShowFilterCreateTime(String createTime,String colName1) throws Exception
	{
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		String cTime = formatDate(selectQuery(createTime, colName1));
		clearAndType(elegsftxtCreateTime, "Create Time",cTime );
		pressEnterKey(elegsftxtCreateTime);
		Thread.sleep(2000);
		verifyGridResult(eleGridResult, cTime);
		return this;
	}
	
	public BatchErrorsPage checkShowColumnsOption() throws Exception
	{
		Thread.sleep(2000);
		verifyShowColumns(eleicnGridOptions, "Process Date","Job ID","Job Description","Batch Name","Message Type Code","Message Type","Create Time");
		return this;
	}
}
