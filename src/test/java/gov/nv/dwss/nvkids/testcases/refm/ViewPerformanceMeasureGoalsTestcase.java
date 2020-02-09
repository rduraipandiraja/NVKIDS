package gov.nv.dwss.nvkids.testcases.refm;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class ViewPerformanceMeasureGoalsTestcase extends CommonLocators
{
	@DataProvider(name="getCaseAction")
    public static Object[][] getCaseAction() throws Exception
	{
		return DataLibrary.readExcelData("REFM_View Performance Measure Goals_Test Data",0);
	}
	
	@Test(testName = "UIT_REFM_03380_Navigate to View Performance Measure Goals and verify",priority=44,description="Navigate to View Performance Measure Goals screen and verify fields")
	public void navigateToViewPerformanceMeasureGoals() throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewPerformanceMeasureGoals().verifyFields();
	}
	
	@Test(testName = "UIT_REFM_03390_Verify Select Filter Fields",priority=45,description="Verify the fields present in Select Filter section")
	public void verifyFilterSectionFields() throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewPerformanceMeasureGoals().verifyFilterSectionFields();
	}
	
	@Test(dataProvider = "getCaseAction",testName = "UIT_REFM_03410_Inquire With Case Action",priority=46,description="Verify inquired record is shown in grid")
	public void inquireWithValidValues(String caseAction) throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewPerformanceMeasureGoals().inquireWithValidValues(caseAction);
	}
	
	
	@Test(dataProvider = "getCaseAction",testName = "UIT_REFM_03520_Inquire With Begin Date",priority=47,description="Verify that records are shown in the grid on inquiring with Begin Date field")
	public void inquireWithBeginDate(String caseAction) throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewPerformanceMeasureGoals().navigatetoAddRevisionPerformanceMeasureGoals(caseAction).addRevisionRecords().inquireWithShowFilterBeginDate();
	}
	
	
	@Test(dataProvider = "getCaseAction",testName = "UIT_REFM_03570_Inquire With End Date",priority=48,description="Verify that records are shown in the grid on inquiring with End Date field")
	public void inquireWithEndDate(String caseAction) throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewPerformanceMeasureGoals().navigatetoAddRevisionPerformanceMeasureGoals(caseAction).addRevisionRecords().inquireWithShowFilterEndDate();
	}
	
	
	@Test(dataProvider = "getCaseAction",testName = "UIT_REFM_03620_Inquire With Updated On",priority=49,description="Verify that records are shown in the grid on inquiring with Updated On field")
	public void inquireWithUpdatedOn(String caseAction) throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewPerformanceMeasureGoals().navigatetoAddRevisionPerformanceMeasureGoals(caseAction).addRevisionRecords().inquireWithShowFilterUpdatedOn();
	}
	
	@Test(dataProvider = "getCaseAction",testName = "UIT_REFM_03660_Inquire With Updated By",priority=50,description="Verify that records are shown in the grid on inquiring with Updated By field")
	public void inquireWithUpdatedBy(String caseAction) throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewPerformanceMeasureGoals().navigatetoAddRevisionPerformanceMeasureGoals(caseAction).addRevisionRecords().inquireWithShowFilterUpdatedBy();
	}
	
	
	@Test(testName = "UIT_REFM_03710_Check Show Columns Options",priority=51,description="Verify that all the grid header field is present in Show Columns")
	public void checkShowColumnsOptions() throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewPerformanceMeasureGoals().checkShowColumnsOption();
	}
}
