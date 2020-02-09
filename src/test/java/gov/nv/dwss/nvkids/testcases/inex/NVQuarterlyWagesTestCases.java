package gov.nv.dwss.nvkids.testcases.inex;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class NVQuarterlyWagesTestCases extends CommonLocators
{
	@DataProvider(name="NVQWages")
	public static Object[][] verifyrecord() throws IOException
	{
		return DataLibrary.readExcelData("INEX_NV Quarterly Wages_Test Data",0);
	}
	
	@Test(priority=17,description = "Navigate to NVQuarterly Wages Screen to Verify Field for NV Quarterly Wages", testName="UIT_INEX_02010_verify Field for NV Quarterly Wages Screen")
	public  void verifyNCQWScreenFieldAppearence() throws Exception
	{
		new LoginPage().login().quickNavigation_INEX().navigateToNVQuarterlyWagesPage().verifyNVQWagesField();
	}
	
	@Test(priority=18,description = "Navigate to NVQuarterly Wages Screen to Verify Filter Field for NV Quarterly Wages", testName="UIT_INEX_02070_verify Filter Field for NV Quarterly Wages Screen")
	public  void FilterFileldAppearence() throws Exception
	{
		new LoginPage().login().quickNavigation_INEX().navigateToNVQuarterlyWagesPage().InquireFilterFields();
	}
	@Test(dataProvider ="NVQWages",priority=19,description = "Navigate to NVQuarterly Wages Screen to Verify grid data for NV Quarterly Wages", testName="UIT_INEX_02130_verify Grid Result for NV Quarterly Wages Screen")
	public  void  verifyNCQWGridData(String query,String nvqparticipantid) throws Exception
	{
		new LoginPage().login().quickNavigation_INEX().navigateToNVQuarterlyWagesPage().verifyNVQWGrid(query,nvqparticipantid);
	}
	
	@Test(priority=20,description = "verify ShowColumns in view  NVQuarterly Wages Page", testName="UIT_INEX_02670_verify ShowColumns")
	public void InquireShowColumn() throws Exception{
		new LoginPage().login().quickNavigation_INEX().navigateToNVQuarterlyWagesPage().verifyShowColumn();
	}
	
	@Test(dataProvider ="NVQWages",priority=21,description = "Navigate to NVQuarterly Wages Screen to Verify Expand Grid Result Field for NV Quarter Wages", testName="UIT_INEX_02730_verify Expand Grid Result for NVQuarterly Wages Screen")
	public  void VerifyExpandfield(String query,String nvqparticipantid) throws Exception
	{
		new LoginPage().login().quickNavigation_INEX().navigateToNVQuarterlyWagesPage().InquireExpandNVQWGrid(query,nvqparticipantid);
	}
}
