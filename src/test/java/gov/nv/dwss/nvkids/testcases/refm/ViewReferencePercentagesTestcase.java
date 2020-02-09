package gov.nv.dwss.nvkids.testcases.refm;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class ViewReferencePercentagesTestcase extends CommonLocators
{	
	@DataProvider(name="getPercentageCode")
    public static Object[][] getPercentageCode() throws Exception
	{
		return DataLibrary.readExcelData("REFM_View Reference Percentages_Test Data",0);
	}
	
	@Test(testName = "UIT_REFM_00900_Navigate to View Reference Percentages screen",priority=13,description="Navigate to View Reference Percentages screen and verify fields")
	public void navigateToViewReferenceCodes() throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewReferencePercentages().verifyViewReferencePercentagesFields();
	}
	
	@Test(testName = "UIT_REFM_00910_Verify Filter Fields",priority=14,description="Verify the fields present in Select Filter section")
	public void verifySelectFilterFields() throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewReferencePercentages().verifySelectFilterFields();
	}
	
	@Test(dataProvider = "getPercentageCode",testName = "UIT_REFM_01030_Inquire With Valid Values",priority=15,description="Inquire with valid values")
	public void inquireWithValidValues(String percentageCode) throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewReferencePercentages().inquireWithValidValues(percentageCode);
	}
	
	@Test(dataProvider = "getPercentageCode",testName = "UIT_REFM_01090_Inquire With Percentage",priority=16,description="Inquire with Percentage field in Show Filters")
	public void inquireWithPercentage(String percentageCode) throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewReferencePercentages().navigatetoAddRevisionReferencePercentages(percentageCode).addRevisionRecords().inquireWithShowFilterPercentage();
	}
	
	@Test(dataProvider = "getPercentageCode",testName = "UIT_REFM_01140_Inquire With Begin Date",priority=17,description="Verify records are shown in the grid on inquiring with valid Begin Date")
	public void inquireWithBeginDate(String percentageCode) throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewReferencePercentages().navigatetoAddRevisionReferencePercentages(percentageCode).addRevisionRecords().inquireWithShowFilterBeginDate();
	}
	
	@Test(dataProvider = "getPercentageCode",testName = "UIT_REFM_01190_Inquire With End Date",priority=18,description="Verify records are shown in the grid on inquiring with valid End Date")
	public void inquireWithEndDate(String percentageCode) throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewReferencePercentages().navigatetoAddRevisionReferencePercentages(percentageCode).addRevisionRecords().inquireWithShowFilterEndDate();
	}
	
	@Test(dataProvider = "getPercentageCode",testName = "UIT_REFM_01240_Inquire With Updated On",priority=19,description="Verify records are shown in the grid on inquiring with existing Updated Date")
	public void inquireWithUpdatedOn(String percentageCode) throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewReferencePercentages().navigatetoAddRevisionReferencePercentages(percentageCode).addRevisionRecords().inquireWithShowFilterUpdatedOn();
	}
	
	@Test(dataProvider = "getPercentageCode",testName = "UIT_REFM_01280_Inquire With Updated By",priority=20,description="Verify records are shown in the grid on inquiring with existing Updated User")
	public void inquireWithUpdatedBy(String percentageCode) throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewReferencePercentages().navigatetoAddRevisionReferencePercentages(percentageCode).addRevisionRecords().inquireWithShowFilterUpdatedBy();
	}
	
	@Test(testName = "UIT_REFM_01330_Check Show Columns Options",priority=21,description="Verify that all grid header columns are shown in the Show Columns option")
	public void checkShowColumnsOptions() throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewReferencePercentages().checkShowColumnsOption();
	}
}
