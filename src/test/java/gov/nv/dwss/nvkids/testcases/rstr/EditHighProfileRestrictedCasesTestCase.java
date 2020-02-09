package gov.nv.dwss.nvkids.testcases.rstr;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class EditHighProfileRestrictedCasesTestCase extends CommonLocators

{
	
	@DataProvider(name="getParticipantID")
    public static Object[][] getParticipantID() throws Exception
	{
		return DataLibrary.readExcelData("RSTR_View High Profile Restricted Cases_Test Data",1);
	}

	@Test(dataProvider = "getParticipantID",testName="UIT_RSTR_00390_Navigate to Edit High Profile Restricted Cases screen function",priority=8,description="Navigates to Edit  High Profile Restricted Cases Status screen function in RSTR Screen when double click a record row in grid of  High Profile Restricted Cases screen function.")
	public void navigateToEditHighProfileRestrictedCases(String query,String participantCol1) throws Exception 
	{
			new LoginPage().login().quickNavigation_RSTR().navigateToEditHighRSTR(query,participantCol1).verifyFieldsPresent();	
	}
	
	@Test(dataProvider = "getParticipantID",testName="UIT_RSTR_00400_Change Status to Inactive",priority=9,description="Upon changing the STATUS to Inactive, the system removes the restriction present on the selected case ID and participant ID.")
	public void editStatus(String query,String participantCol1) throws Exception 
	{
			new LoginPage().login().quickNavigation_RSTR().navigateToEditHighRSTR(query,participantCol1).editStatus();
	}
	
	
	
}
