package gov.nv.dwss.nvkids.testcases.refm;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class AddRevisionPerformanceMeasureGoalsTestcase extends CommonLocators 
{
	@DataProvider(name="getCaseAction")
    public static Object[][] getCaseAction() throws Exception
	{
		return DataLibrary.readExcelData("REFM_Add Revision Performance Measure Goals_Test Data",0);
	}
	
	@Test(dataProvider = "getCaseAction",testName = "UIT_REFM_03830_Navigate to Add Revision Performance Measure Goals",priority=52,description="Navigate to Add Revision Performance Measure Goals and verify fields")
	public void navigateToAddRevisionPerformanceMeasureGoals(String caseAction) throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewPerformanceMeasureGoals().navigatetoAddRevisionPerformanceMeasureGoals(caseAction).verifyFields();
	}
	
	@Test(dataProvider = "getCaseAction",testName = "UIT_REFM_03960_Verify Successful Add",priority=53,description="Verify that an informational message is displayed after a successful Add")
	public void verifySuccessfulAdd(String caseAction) throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewPerformanceMeasureGoals().navigatetoAddRevisionPerformanceMeasureGoals(caseAction).addRevisionRecords();
	}
}
