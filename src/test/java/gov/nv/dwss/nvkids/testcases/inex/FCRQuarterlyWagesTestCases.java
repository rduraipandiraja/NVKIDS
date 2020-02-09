package gov.nv.dwss.nvkids.testcases.inex;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class FCRQuarterlyWagesTestCases extends CommonLocators
{
	@DataProvider(name="FCRQWages")
	public static Object[][] verifyrecord() throws IOException
	{
		return DataLibrary.readExcelData("INEX_FCR Quarterly Wages_Test Data",0);
	}
	
	@Test(priority=22,description = "Navigate to FCR Quarter Wages Screen to Verify Field for FCR Quarter Wages", testName="UIT_INEX_02800_verify Field for FCR Quarter Wages Screen")
	public  void verifyFCRQWScreenFieldAppearence() throws Exception
	{
		new LoginPage().login().quickNavigation_INEX().navigateToFCRQuarterlyWagesPage().verifyFCRQWagesField();
	}
	
	@Test(priority=23,description = "Navigate to FCR Quarter Wages Screen to Verify Filter Field for FCR Quarter Wages", testName="UIT_INEX_02860_verify Filter Field for FCR Quarter Wages Screen")
	public  void FilterFileldAppearence() throws Exception
	{
		new LoginPage().login().quickNavigation_INEX().navigateToFCRQuarterlyWagesPage().InquireFilterFields();
	}
	@Test(dataProvider ="FCRQWages",priority=24,description = "Navigate to FCR Quarter Wages Screen to Verify grid data for FCR Quarter Wages", testName="UIT_INEX_02920_verify Grid Result for FCR Quarter Wages Screen")
	public  void  verifyFCRQWMatchedData(String query,String fcrparticipantid) throws Exception
	{
		new LoginPage().login().quickNavigation_INEX().navigateToFCRQuarterlyWagesPage().verifyFCRQWGrid(query,fcrparticipantid);
	}
	
	@Test(priority=25,description = "verify ShowColumns in view  FCRQuarterly Wages Page", testName="UIT_INEX_03540_verify ShowColumns")
	public void InquireShowColumn() throws Exception{
		new LoginPage().login().quickNavigation_INEX().navigateToFCRQuarterlyWagesPage().verifyShowColumn();
	}

}
