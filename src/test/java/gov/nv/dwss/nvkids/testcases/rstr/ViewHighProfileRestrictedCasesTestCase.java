package gov.nv.dwss.nvkids.testcases.rstr;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class ViewHighProfileRestrictedCasesTestCase extends CommonLocators

{
	@DataProvider(name="getCaseID")
    public static Object[][] getCaseID() throws Exception
	{
		return DataLibrary.readExcelData("RSTR_View High Profile Restricted Cases_Test Data",0);
	}
	
	@DataProvider(name="getParticipantID")
    public static Object[][] getParticipantID() throws Exception
	{
		return DataLibrary.readExcelData("RSTR_View High Profile Restricted Cases_Test Data",1);
	}

	
	@Test(testName="UIT_RSTR_00010_Navigate to RSTR Screen using Quick Navigation",priority=1,description="Navigates to 'RSTR - Restricted Case / Participant' Screen using the Quick Navigation pop-up.")
	public void navigateToViewHighProfileRestrictedCases() throws Exception 
	{
			new LoginPage().login().quickNavigation_RSTR().verifyFieldsPresent();
	}
	
	
	@Test(dataProvider = "getCaseID",testName="UIT_RSTR_000130_Inquire CASE field - With Records",priority=2,description="Upon inquiring with values in the CASE field, the system populates the grid.")
	public void inquireWithCase(String query,String caseCol1) throws Exception 
	{
		new LoginPage().login().quickNavigation_RSTR().inquireWithCase(query,caseCol1);
	}
	
	@Test(dataProvider = "getParticipantID",testName="UIT_RSTR_000140_Inquire PARTICIPANT field - With Records",priority=3,description="Upon inquiring with values in the PARTICIPANT field, the system populates the grid.")
	public void inquireWithParticipant(String query,String participantCol1) throws Exception 
	{
		new LoginPage().login().quickNavigation_RSTR().inquireWithParticipant(query,participantCol1);
	}
	
	@Test(testName="UIT_RSTR_000150_Test Show Columns in Grid Options to view list of columns",priority=4,description="Clicking on the Show Columns from Grid Options list to view all the columns in the grid header.")
	public void verifyShowColumns() throws Exception 
	{
		new LoginPage().login().quickNavigation_RSTR().verifyShowColumns();
	}
	
	
}

