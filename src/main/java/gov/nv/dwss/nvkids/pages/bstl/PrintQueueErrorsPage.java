package gov.nv.dwss.nvkids.pages.bstl;

import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class PrintQueueErrorsPage extends CommonLocators 
{

	public PrintQueueErrorsPage() 
	{
		PageFactory.initElements(driver, this);
	}

	
	// Filter Section
	@FindBy(xpath = "//span[text()='Batch Status Logs and Errors']") WebElement elelinkBatchstatuslogs;
	@FindBy(xpath = "(//label[text()=' Process Date '])[2]") WebElement elelblsfProcessDate;
	@FindBy(id = "effectiveRunDate")  WebElement eletxtsfProcessDate;
	@FindBy(xpath="//label[text()=' Process Date ']/following::button[1]") WebElement eleicnProcessDate;
	@FindBy(xpath = "//label[text()='Case ID']") WebElement elelblsfCaseID;
	@FindBy(id = "caseId") WebElement eletxtsfCaseID;
	@FindBy(xpath = "(//label[text()='Document ID'])[1]") WebElement elelblsfDocumentID;
	@FindBy(id = "documentIdc") WebElement eletxtsfDocumentID;
	@FindBy(id = "noticeName") WebElement eledsosfDocumentName;
	
	//Grid Section
	@FindBy(xpath="//label[text()=' Process Date ']") WebElement elelblProcessDate;
	@FindBy(xpath="//label[text()=' Job ID ']") WebElement elelblJobID;
	@FindBy(xpath="//label[text()=' Job Description ']") WebElement elelblJobDescription;
	@FindBy(xpath="//label[text()=' Batch Name ']") WebElement elelblBatchName;
	@FindBy(xpath="//label[text()=' Message Type Code ']") WebElement elelblMessageTypeCode;
	@FindBy(xpath="//label[text()=' Message Type ']") WebElement elelblMessageType;
	@FindBy(xpath="//label[text()=' Create Time ']") WebElement elelblCreateTime;
	
	// Grid Accordion section
	@FindBy(xpath = "//label[text()=' Key Values ']") WebElement elealblKeyValues;
	@FindBy(xpath = "//label[text()=' Error Description ']")WebElement elealblErrorDescription;
	
	
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
	@FindBy(xpath = "//span[text()='View Print Queue Errors']/following::td[1]/span") WebElement elegdataProcessDate;
	@FindBy(xpath = "//span[text()='View Print Queue Errors']/following::td[2]/span") WebElement elegdataJobID;
	@FindBy(xpath = "//span[text()='View Print Queue Errors']/following::td[3]/span") WebElement elegdataJobDescription;
	@FindBy(xpath = "//span[text()='View Print Queue Errors']/following::td[4]/span") WebElement elegdataBatchName;
	@FindBy(xpath = "//span[text()='View Print Queue Errors']/following::td[5]/span") WebElement elegdataMessageTypeCode;
	@FindBy(xpath = "//span[text()='View Print Queue Errors']/following::td[6]/span") WebElement elegdataMessageType;
	@FindBy(xpath = "//span[text()='View Print Queue Errors']/following::td[7]/span") WebElement elegdataCreateTime;

	
	

	public PrintQueueErrorsPage verifyFieldspresent() throws Exception 
	{
		verifyGridHeaders(elelblGridHeaders,"Process Date","Job Description","Batch Name","Message Type","Create Time");
		return this;
	}

	public PrintQueueErrorsPage verifySelectFilterFields() throws Exception
	{
		click(eleicnFilter, "Filter");
		verifyDisplayed(elelblsfProcessDate, "Process Date");
		verifyDisplayed(elelblsfCaseID, "Case ID");
		verifyDisplayed(elelblsfDocumentID,"Document ID");
		verifyDisplayed(elelblsfDocumentID,"Document Name");
		return this;
	}
	
	public PrintQueueErrorsPage inquirewithProcessDate(String processDate,String colName) throws InterruptedException, ClassNotFoundException, SQLException 
	{
		click(eleicnFilter, "Filter");
		String pDate = formatDate(selectQuery(processDate, colName));
		clearAndType(eletxtsfProcessDate, "Process Date",pDate );
		click(eleicnSearch,"Search");
		Thread.sleep(5000);
		return this;
	}

	public PrintQueueErrorsPage verifySucessfulInquiry(String processDate,String colName) throws ClassNotFoundException, SQLException 
	{
		click(eleicnFilter, "Filter");
		String pDate = formatDate(selectQuery(processDate, colName));
		clearAndType(eletxtsfProcessDate, "Process Date", pDate);
		click(eleicnSearch,"Search");
		verifyGridRecordsPresent(eleGridRecord);
		return this;
	}
	
	public PrintQueueErrorsPage inquireWithShowFilterJobID(String processDate, String colName,String jobID) throws Exception
	{
		inquirewithProcessDate(processDate, colName);
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		String jID = selectQuery(processDate, jobID);
		clearAndType(elegsftxtJobID, "JobID",jID );
		pressEnterKey(elegsftxtJobID);
		Thread.sleep(2000);
		verifyGridResult(eleGridResult, jID);
		return this;
	}
	
	public PrintQueueErrorsPage inquireWithShowFilterJobDescription(String processDate, String colName,String jobDesc) throws Exception
	{
		inquirewithProcessDate(processDate, colName);
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		String jobDescription = selectQuery(processDate, jobDesc);
		clearAndType(elegsftxtJobDescription,"Job Description", jobDescription);
		pressEnterKey(elegsftxtJobDescription);
		Thread.sleep(2000);
		verifyGridResult(eleGridResult, jobDescription);
		return this;
	}
	
	public PrintQueueErrorsPage inquireWithShowFilterBatchName(String processDate, String colName,String batchName) throws Exception
	{
		inquirewithProcessDate(processDate, colName);
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		String bName = selectQuery(processDate, batchName);
		clearAndType(elegsftxtBatchName, "Batch Name",bName );
		pressEnterKey(elegsftxtBatchName);
		Thread.sleep(2000);
		verifyGridResult(eleGridResult, bName);
		return this;
	}
	
	public PrintQueueErrorsPage inquireWithShowFilterMessageTypeCode(String processDate, String colName,String msgTypeCode) throws Exception
	{
		inquirewithProcessDate(processDate, colName);
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		String msTyCode = selectQuery(processDate, msgTypeCode);
		selectDropdownValue(elegsfddMessageTypeCode,msTyCode );
		Thread.sleep(2000);
		verifyGridResult(eleGridResult, msTyCode);
		return this;
	}
	
	public PrintQueueErrorsPage inquireWithShowFilterMessageType(String processDate, String colName,String msgType) throws Exception
	{
		inquirewithProcessDate(processDate, colName);
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		String mType = selectQuery(processDate, msgType);
		selectDropdownValue(elegsfddMessageType,mType );
		Thread.sleep(2000);
		verifyGridResult(eleGridResult, mType);
		return this;
	}
	
	public PrintQueueErrorsPage inquireWithShowFilterCreateTime(String processDate, String createTime) throws Exception
	{
		inquirewithProcessDate(processDate, createTime);
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		String cTime = formatDate(selectQuery(processDate, createTime));
		clearAndType(elegsftxtCreateTime, "Create Time", cTime);
		pressEnterKey(elegsftxtCreateTime);
		Thread.sleep(2000);
		verifyGridResult(eleGridResult, cTime);
		return this;
	}
	
	public PrintQueueErrorsPage checkShowColumnsOption() throws Exception
	{
		Thread.sleep(2000);
		verifyShowColumns(eleicnGridOptions, "Process Date","Job ID","Job Description","Batch Name","Message Type Code","Message Type","Create Time");
		return this;
	}
}
