
package gov.nv.dwss.nvkids.testcases.bstl;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;


public class ViewBatchErrorsTestcase extends CommonLocators 
{
	@DataProvider(name="getProcessDate")
    public static Object[][] fetchDateRange() throws Exception
	{
		return DataLibrary.readExcelData("BSTL_Batch Errors_Test Data",0);
	}
	
	@DataProvider(name="getJobID")
    public static Object[][] fetchDataJobID() throws Exception
	{
		return DataLibrary.readExcelData("BSTL_Batch Errors_Test Data",1);
	}

	@DataProvider(name="getJobDesc")
    public static Object[][] fetchDataStartTime() throws Exception
	{
		return DataLibrary.readExcelData("BSTL_Batch Errors_Test Data",2);
	}
	
	@DataProvider(name="getBatchName")
    public static Object[][] fetchJobDesc() throws Exception
	{
		return DataLibrary.readExcelData("BSTL_Batch Errors_Test Data",3);
	}
	
	@DataProvider(name="getMsgTypeCode")
    public static Object[][] fetchBatchName() throws Exception
	{
		return DataLibrary.readExcelData("BSTL_Batch Errors_Test Data",4);
	}
	
	@DataProvider(name="getMsgType")
    public static Object[][] fetchStartTime() throws Exception
	{
		return DataLibrary.readExcelData("BSTL_Batch Errors_Test Data",5);
	}
	
	@DataProvider(name="getCreateTime")
    public static Object[][] fetchEndTime() throws Exception
	{
		return DataLibrary.readExcelData("BSTL_Batch Errors_Test Data",6);
	}
	
	@Test(testName="UIT_BSTL_00910_Navigate and Verify Fields",priority=14,description="Navigate to Batch Errors screen and verify the fields ")
	public void navigatetoViewBatchErrors() throws Exception
	{
		new LoginPage().login().quickNavigation_BSTL().navigatetoBatchErrors().verifyFieldsPresent();
	}
	
	@Test(testName="UIT_BSTL_00930_Verify Filter Section Fields",priority=15,description="Navigate to Batch Errors screen and verify the fields ")
	public void verifyFilterSectionFields() throws Exception
	{
		new LoginPage().login().quickNavigation_BSTL().navigatetoBatchErrors().verifySelectFilterFields();
	}
	
	
	@Test(dataProvider = "getProcessDate",testName="UIT_BSTL_01010_Perform Successful Inquiry",priority=16,description="Verify Successful inquiry is done")
	public void verifySuccessfulInquiry(String processDate,String colName) throws Exception
	{
		new LoginPage().login().quickNavigation_BSTL().navigatetoBatchErrors().inquireWithValidValues(processDate,colName);
	}
	
	
	@Test(dataProvider = "getJobID",testName="UIT_BSTL_01170_Inquire With valid Job ID",priority=17,description="Inquire With valid Job ID")
	public void inquireWithValidJobID(String processDate,String colName,String jobID,String colName1) throws Exception
	{
		new LoginPage().login().quickNavigation_BSTL().navigatetoBatchErrors().inquireWithValidValues(processDate,colName).inquireWithShowFilterJobID(jobID,colName1);
	}
	
	@Test(dataProvider = "getJobDesc",testName="UIT_BSTL_01230_Inquire With valid Job Description",priority=18,description="Inquire With valid Job Description")
	public void inquireWithValidJobDescription(String jobDesc,String colName1,String colName2) throws Exception
	{
		new LoginPage().login().quickNavigation_BSTL().navigatetoBatchErrors().inquireWithValidValues(jobDesc,colName1).inquireWithShowFilterJobDescription(jobDesc,colName2);
	}
	
	@Test(dataProvider = "getBatchName",testName="UIT_BSTL_01290_Inquire With valid Batch Name",priority=19,description="Inquire With valid Batch Name")
	public void inquireWithValidBatchName(String batchName,String colName1,String colName2) throws Exception
	{
		new LoginPage().login().quickNavigation_BSTL().navigatetoBatchErrors().inquireWithValidValues(batchName,colName1).inquireWithShowFilterBatchName(batchName,colName2); 
	}
	
	@Test(dataProvider = "getMsgTypeCode",testName="UIT_BSTL_01310_Inquire With valid Message Type Code",priority=20,description="Inquire With valid MessageTypeCode")
	public void inquireWithValidMessageTypeCode(String processDate,String colName,String msgTypecode,String colName1) throws Exception
	{
		new LoginPage().login().quickNavigation_BSTL().navigatetoBatchErrors().inquireWithValidValues(processDate,colName).inquireWithShowFilterMessageTypeCode(msgTypecode,colName1);
	}
	
	
	@Test(dataProvider = "getMsgType",testName="UIT_BSTL_01330_Inquire With valid Message Type",priority=21,description="Inquire With valid MessageType")
	public void inquireWithValidMessageType(String processDate,String colName,String msgType,String colName1) throws Exception
	{
		new LoginPage().login().quickNavigation_BSTL().navigatetoBatchErrors().inquireWithValidValues(processDate,colName).inquireWithShowFilterMessageType(msgType,colName1);
	}
	
	
	@Test(dataProvider = "getCreateTime",testName="UIT_BSTL_01400_Inquire With valid Create Time",priority=22,description="Inquire With valid Create Time")
	public void inquireWithValidCreateTime(String processDate,String colName,String createTime,String colName1) throws Exception
	{
		new LoginPage().login().quickNavigation_BSTL().navigatetoBatchErrors().inquireWithValidValues(processDate,colName).inquireWithShowFilterCreateTime(createTime,colName1);
	}
	
	@Test(testName="UIT_BSTL_01470_Verify Show Column Fields",priority=23,description="Verify Show Column Fields")
	public void verifyShowColumnFields() throws Exception
	{
		new LoginPage().login().quickNavigation_BSTL().navigatetoBatchErrors().checkShowColumnsOption();
	}
}



