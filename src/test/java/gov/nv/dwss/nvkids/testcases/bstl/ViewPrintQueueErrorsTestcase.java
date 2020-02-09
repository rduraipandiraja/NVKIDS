package gov.nv.dwss.nvkids.testcases.bstl;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class ViewPrintQueueErrorsTestcase extends CommonLocators
{
	@DataProvider(name="getProcessDate")
    public static Object[][] fetchDateRange() throws Exception
	{
		return DataLibrary.readExcelData("BSTL_Print Queue Errors_Test Data",0);
	}
	
	@DataProvider(name="getJobID")
    public static Object[][] fetchDataJobID() throws Exception
	{
		return DataLibrary.readExcelData("BSTL_Print Queue Errors_Test Data",1);
	}

	@DataProvider(name="getJobDesc")
    public static Object[][] fetchDataStartTime() throws Exception
	{
		return DataLibrary.readExcelData("BSTL_Print Queue Errors_Test Data",2);
	}
	
	@DataProvider(name="getBatchName")
    public static Object[][] fetchJobDesc() throws Exception
	{
		return DataLibrary.readExcelData("BSTL_Print Queue Errors_Test Data",3);
	}
	
	@DataProvider(name="getMsgTypeCode")
    public static Object[][] fetchBatchName() throws Exception
	{
		return DataLibrary.readExcelData("BSTL_Print Queue Errors_Test Data",4);
	}
	
	@DataProvider(name="getMsgType")
    public static Object[][] fetchStartTime() throws Exception
	{
		return DataLibrary.readExcelData("BSTL_Print Queue Errors_Test Data",5);
	}
	
	@DataProvider(name="getCreateTime")
    public static Object[][] fetchEndTime() throws Exception
	{
		return DataLibrary.readExcelData("BSTL_Print Queue Errors_Test Data",6);
	}
		
	@Test(testName="UIT_BSTL_01590_Navigate to Print Queue Errors",priority=24, description="Navigate to Print Queue Errors screen and verify the fields present")
	public void verifyfieldspresent() throws Exception
	{
		new LoginPage().login().quickNavigation_BSTL().navigatetoPrintQueueErrors().verifyFieldspresent();
	}
		
	@Test(testName="UIT_BSTL_01610_Verify Select Filter Fields",priority=25, description="Verify Select Filter Fields")
	public void verifyNumericCharAllowance() throws Exception
	{
		new LoginPage().login().quickNavigation_BSTL().navigatetoPrintQueueErrors().verifySelectFilterFields();
	}
	
	@Test(dataProvider = "getProcessDate",testName="UIT_BSTL_01790_Verify Successful Inquiry",priority=26,description="Verify Successful Inquiry is done")
	public void verifySuccessfulInquiry(String processDate,String colName) throws Exception
	{
		new LoginPage().login().quickNavigation_BSTL().navigatetoPrintQueueErrors().verifySucessfulInquiry(processDate,colName);
	}
	
	@Test(dataProvider = "getJobID",testName="UIT_BSTL_01950_Inquire With valid Job ID",priority=27,description="Inquire With valid Job ID")
	public void inquireWithValidJobID(String processDate,String colName,String jobID) throws Exception
	{
		new LoginPage().login().quickNavigation_BSTL().navigatetoPrintQueueErrors().inquireWithShowFilterJobID(processDate,colName,jobID);
	}
	
	@Test(dataProvider = "getJobDesc",testName="UIT_BSTL_02010_Inquire With Job Description",priority=28,description="Inquire With Job Description")
	public void inquireWithJobDescription(String processDate,String colName,String jobDesc) throws Exception
	{
		new LoginPage().login().quickNavigation_BSTL().navigatetoPrintQueueErrors().inquireWithShowFilterJobDescription(processDate,colName,jobDesc);
	}
	
	@Test(dataProvider = "getBatchName",testName="UIT_BSTL_02070_Inquire With valid Batch Name",priority=29,description="Inquire With valid Batch Name")
	public void inquireWithValidBatchName(String processDate,String colName,String batchName) throws Exception
	{
		new LoginPage().login().quickNavigation_BSTL().navigatetoPrintQueueErrors().inquireWithShowFilterBatchName(processDate,colName,batchName);
	}
	
	@Test(dataProvider = "getMsgTypeCode",testName="UIT_BSTL_02090_Inquire With valid Message Type Code",priority=30,description="Inquire With valid MessageTypeCode")
	public void inquireWithValidMessageTypeCode(String processDate,String colName,String msgTypeCode) throws Exception
	{
		new LoginPage().login().quickNavigation_BSTL().navigatetoPrintQueueErrors().inquireWithShowFilterMessageTypeCode(processDate,colName,msgTypeCode);
	}
	
	@Test(dataProvider = "getMsgType",testName="UIT_BSTL_02110_Inquire With valid Message Type",priority=31,description="Inquire With valid MessageType")
	public void inquireWithValidMessageType(String processDate,String colName,String msgType) throws Exception
	{
		new LoginPage().login().quickNavigation_BSTL().navigatetoPrintQueueErrors().inquireWithShowFilterMessageType(processDate,colName,msgType);
	}
	
	@Test(dataProvider = "getCreateTime",testName="UIT_BSTL_02180_Inquire With valid Create Time",priority=32,description="Inquire With valid Create Time")
	public void inquireWithValidCreateTime(String processDate,String createTime) throws Exception
	{
		new LoginPage().login().quickNavigation_BSTL().navigatetoPrintQueueErrors().inquireWithShowFilterCreateTime(processDate,createTime);
	}
	
	@Test(testName="UIT_BSTL_02250_Verify Show Column Fields",priority=33,description="Verify Show Column Fields")
	public void verifyShowColumnFields() throws Exception
	{
		new LoginPage().login().quickNavigation_BSTL().navigatetoPrintQueueErrors().checkShowColumnsOption();
	}
}
