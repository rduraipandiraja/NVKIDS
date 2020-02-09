package gov.nv.dwss.nvkids.testcases.bstl;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;


public class ViewBatchStatusLogsTestcase extends CommonLocators 
{
	@DataProvider(name="getDateRangeForInquiry")
    public static Object[][] fetchDateRange() throws Exception
	{
		return DataLibrary.readExcelData("BSTL_Batch Status Logs_Test Data",0);
	}
	
	@DataProvider(name="getProcessDate")
    public static Object[][] fetchDataJobID() throws Exception
	{
		return DataLibrary.readExcelData("BSTL_Batch Status Logs_Test Data",1);
	}

	@DataProvider(name="getJobID")
    public static Object[][] fetchDataStartTime() throws Exception
	{
		return DataLibrary.readExcelData("BSTL_Batch Status Logs_Test Data",2);
	}
	
	@DataProvider(name="getJobDesc")
    public static Object[][] fetchJobDesc() throws Exception
	{
		return DataLibrary.readExcelData("BSTL_Batch Status Logs_Test Data",3);
	}
	
	@DataProvider(name="getBatchName")
    public static Object[][] fetchBatchName() throws Exception
	{
		return DataLibrary.readExcelData("BSTL_Batch Status Logs_Test Data",4);
	}
	
	@DataProvider(name="getStartTime")
    public static Object[][] fetchStartTime() throws Exception
	{
		return DataLibrary.readExcelData("BSTL_Batch Status Logs_Test Data",5);
	}
	
	@DataProvider(name="getEndTime")
    public static Object[][] fetchEndTime() throws Exception
	{
		return DataLibrary.readExcelData("BSTL_Batch Status Logs_Test Data",6);
	}
	
	@DataProvider(name="getRecordCount")
    public static Object[][] fetchRecordCount() throws Exception
	{
		return DataLibrary.readExcelData("BSTL_Batch Status Logs_Test Data",7);
	}
	
	@DataProvider(name="getBatchStatusCode")
    public static Object[][] fetchBatchStatusCode() throws Exception
	{
		return DataLibrary.readExcelData("BSTL_Batch Status Logs_Test Data",8);
	}
	
	@DataProvider(name="getBatchStatus")
    public static Object[][] fetchBatchStatus() throws Exception
	{
		return DataLibrary.readExcelData("BSTL_Batch Status Logs_Test Data",9);
	}
	
	@Test(testName="UIT_BSTL_00010_Navigate to BSTL and Verify Fields",priority=1, description="Navigate to BSTL  - Batch Status Logs screen function and verify fields")
	public void verifyfieldspresent() throws Exception
	{
		new LoginPage().login().quickNavigation_BSTL().verifyFieldsPresent();	
	}
	
	@Test(testName="UIT_BSTL_00040_Verify Filter Section Fields",priority=2, description="Verify Filter Section Fields")
	public void verifyFilterFields() throws Exception
	{
		new LoginPage().login().quickNavigation_BSTL().verifySelectFilterFields();
	}
	
	@Test(dataProvider = "getDateRangeForInquiry",testName="UIT_BSTL_00190_Verify Successful Inquiry",priority=3,description="Verify Successful Inquiry")
	public void verifySuccesfulInquiry(String fDate,String colName1,String tDate,String colName2) throws Exception
	{
		new LoginPage().login().quickNavigation_BSTL().verifySuccessfulInquiry(fDate,colName1,tDate,colName2);
	}
	
	@Test(dataProvider = "getProcessDate",testName="UIT_BSTL_00280_Inquire With Valid Process Date",priority=4, description="Verify opening and closing of Show Filters option")
	public void inquireWithProcessDate(String fDate, String colName1,String tDate, String colName2)throws Exception
	{
		new LoginPage().login().quickNavigation_BSTL().inquireWithShowFilterProcessDate(fDate,colName1,tDate,colName2);
	}
	
	@Test(dataProvider = "getJobID",testName="UIT_BSTL_00350_Inquire With valid Job ID",priority=5, description="Inquire With valid Job ID")
	public void inquireWithValidJobID(String fDate, String colName1,String tDate, String colName2,String colName3) throws Exception
	{
		new LoginPage().login().quickNavigation_BSTL().inquireWithShowFilterJobID(fDate,colName1,tDate,colName2,colName3);
	}
	
	@Test(dataProvider = "getJobDesc",testName="UIT_BSTL_00410_Inquire With Valid Job Description",priority=6, description="Verify Max Length Of Job Description")
	public void inquireWithValidJobDescription(String fDate, String colName1,String tDate, String colName2,String jobDesc, String colName3) throws Exception
	{
		new LoginPage().login().quickNavigation_BSTL().inquireWithShowFilterJobDescription(fDate,colName1,tDate,colName2,jobDesc,colName3);
	}
	
	@Test(dataProvider = "getBatchName",testName="UIT_BSTL_00470_Inquire With Valid Batch Name",priority=7, description="Verify Max Length Of Batch Name")
	public void inquireWithValidBatchName(String fDate, String colName1,String tDate, String colName2,String batchName,String colName3) throws Exception
	{
		new LoginPage().login().quickNavigation_BSTL().inquireWithShowFilterBatchName(fDate,colName1,tDate,colName2,batchName,colName3);
	}
	
	@Test(dataProvider = "getStartTime",testName="UIT_BSTL_00540_Inquire With Valid Start Time",priority=8, description="Inquire With Valid Start Time")
	public void inquireWithValidStartTime(String fDate, String colName1,String tDate, String colName2,String startTime,String colName3) throws Exception
	{
		new LoginPage().login().quickNavigation_BSTL().inquireWithShowFilterStartTime(fDate,colName1,tDate,colName2,startTime,colName3);
	}
	
	@Test(dataProvider = "getEndTime",testName="UIT_BSTL_00610_Inquire With Valid End Time",priority=9, description="Verify Max Length Of End Time ")
	public void inquireWithValidEndTime(String fDate, String colName1,String tDate, String colName2,String endTime,String colName3) throws Exception
	{
		new LoginPage().login().quickNavigation_BSTL().inquireWithShowFilterEndTime(fDate,colName1,tDate,colName2,endTime,colName3);
	}
	
	@Test(dataProvider = "getRecordCount",testName="UIT_BSTL_00680_Inquire With Valid Record Count",priority=10, description="Verify Max Length Of Record Count  ")
	public void inquireWithValidRecordCount(String fDate, String colName1,String tDate, String colName2,String recordCount,String colName3) throws Exception
	{
		new LoginPage().login().quickNavigation_BSTL().inquireWithShowFilterRecordCount(fDate,colName1,tDate,colName2,recordCount,colName3);
	}
	
	@Test(dataProvider = "getBatchStatusCode",testName="UIT_BSTL_00700_Inquire With Valid Batch Status Code",priority=11, description="Verify Max Length Of Batch Status Code  ")
	public void inquireWithValidBatchStatusCode(String fDate, String colName1,String tDate, String colName2,String batchStatusCode,String colName3) throws Exception
	{
		new LoginPage().login().quickNavigation_BSTL().inquireWithShowFilterBatchStatusCode(fDate,colName1,tDate,colName2,batchStatusCode,colName3);
	}
	
	@Test(dataProvider = "getBatchStatus",testName="UIT_BSTL_00720_Inquire With Valid Batch Status",priority=12, description="Verify Max Length Of Batch Status Code  ")
	public void inquireWithValidBatchStatus(String fDate, String colName1,String tDate, String colName2,String batchStatus,String colName3) throws Exception
	{
		new LoginPage().login().quickNavigation_BSTL().inquireWithShowFilterBatchStatus(fDate,colName1,tDate,colName2,batchStatus,colName3);
	}
	
	@Test(testName="UIT_BSTL_00790_Verify Show Column Fields",priority=13, description="Verify Show Column Fields")
	public void verifyShowColumnFields() throws Exception
	{
		new LoginPage().login().quickNavigation_BSTL().checkShowColumnsOption();
	}
}
