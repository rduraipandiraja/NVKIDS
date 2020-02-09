package gov.nv.dwss.nvkids.testcases.refm;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class EditPerformanceMeasureGoalsTestcase extends CommonLocators
{
	@DataProvider(name="getCaseAction")
    public static Object[][] getCaseAction() throws Exception
	{
		return DataLibrary.readExcelData("REFM_Add Performance Measure Goals_Test Data",0);
	}
	
	@Test(dataProvider = "getCaseAction",testName = "UIT_REFM_04030_Navigate to Edit Performance Measure Goals screen",priority=54,description="Navigate to Edit Performance Measure Goals screen and verify fields")
	public void navigateToViewReferenceCodes(String caseAction) throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewPerformanceMeasureGoals().navigatetoEditPerfMeasureGoalsWithFirstGridRow(caseAction).verifyFields();
	}
	
	@Test(dataProvider = "getCaseAction",testName = "UIT_REFM_04150_Verify Successful Edit",priority=55,description="Verify that an informational message displays after a successful Edit")
	public void verifySuccessfulEdit(String caseAction) throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewPerformanceMeasureGoals().navigatetoAddRevisionPerformanceMeasureGoals(caseAction).addRevisionRecords().navigatetoEditPerfMeasureGoals().verifySuccessfulEdit();
	}
}
