package gov.nv.dwss.nvkids.testcases.rstr;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class ViewFamilialRestrictedCaseTestCase extends CommonLocators

{
	@DataProvider(name="getCaseID")
    public static Object[][] getCaseID() throws Exception
	{
		return DataLibrary.readExcelData("RSTR_View Familial Restricted Cases_Test Data",0);
	}
	
	@DataProvider(name="getParticipantID")
    public static Object[][] getParticipantID() throws Exception
	{
		return DataLibrary.readExcelData("RSTR_View Familial Restricted Cases_Test Data",1);
	}

	@DataProvider(name="getUserID")
    public static Object[][] getUserID() throws Exception
	{
		return DataLibrary.readExcelData("RSTR_View Familial Restricted Cases_Test Data",2);
	}
	
	
	@Test(testName="UIT_RSTR_00410_Navigate to RSTR - Familial Restricted Cases screen",priority=10,description="Navigates to 'RSTR - Restricted Case / Participant' Screen using the Quick Navigation pop-up.")
	public void navigateToViewHighProfileRestrictedCases() throws Exception 
	{
			new LoginPage().login().quickNavigation_RSTR().navigateToFamilialScreenFunction().verifyFieldsPresent();
	}
	
	
	@Test(dataProvider = "getCaseID",testName="UIT_RSTR_00550_Inquire CASE field - With Records",priority=11,description="Upon inquiring with values in the CASE field, the system populates the grid.")
	public void inquireWithCase(String query,String caseCol1) throws Exception 
	{
		new LoginPage().login().quickNavigation_RSTR().navigateToFamilialScreenFunction().inquireWithCase(query,caseCol1);
	}
	
	@Test(dataProvider = "getParticipantID",testName="UIT_RSTR_00560_Inquire PARTICIPANT field - With Records",priority=12,description="Upon inquiring with values in the PARTICIPANT field, the system populates the grid.")
	public void inquireWithParticipant(String query,String participantCol1) throws Exception 
	{
		new LoginPage().login().quickNavigation_RSTR().navigateToFamilialScreenFunction().inquireWithParticipant(query,participantCol1);
	}
	
	@Test(dataProvider = "getUserID",testName="UIT_RSTR_00570_Inquire with values in USER field present in the Select Filters. - With Records",priority=13,description="Inquire with values in USER field present in the Select Filters. - With Records")
	public void inquireWithUser(String query,String userCol1,String userCol2) throws Exception 
	{
		new LoginPage().login().quickNavigation_RSTR().navigateToFamilialScreenFunction().inquireWithUser(query,userCol1,userCol2);
	}
	
	
   @Test(testName="UIT_RSTR_00580_Test Show Columns in Grid Options to view list of columns",priority=14,description="Clicking on the Show Columns from Grid Options list to view all the columns in the grid header.")
	public void verifyShowColumns() throws Exception 
	{
		new LoginPage().login().quickNavigation_RSTR().navigateToFamilialScreenFunction().verifyShowColumns();
	}
	
	

}
