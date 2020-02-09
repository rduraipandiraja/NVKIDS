package gov.nv.dwss.nvkids.testcases.rstr;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class EditFamilialRestrictedCasesTestCase extends CommonLocators

{

	@DataProvider(name="getParticipantID")
    public static Object[][] getParticipantID() throws Exception
	{
		return DataLibrary.readExcelData("RSTR_View Familial Restricted Cases_Test Data",1);
	}
	
	@Test(dataProvider = "getParticipantID",testName="UIT_RSTR_00830_Navigate to Edit Familial Restricted Cases screen function",priority=18,description="Navigate to Edit Familial Restricted Cases screen function")
	public void navigateToEditFamilialRestrictedCases(String query,String participantCol1) throws Exception 
	{
			new LoginPage().login().quickNavigation_RSTR().navigateToFamilialScreenFunction().navigateToEditFamilialRSTR(query,participantCol1).verifyFieldsPresent();
	}

	@Test(dataProvider = "getParticipantID",testName="UIT_RSTR_00900_Change Status to Inactive",priority=19,description="Change Status to Inactive")
	public void editStatus(String query,String participantCol1) throws Exception 
	{
			new LoginPage().login().quickNavigation_RSTR().navigateToFamilialScreenFunction().navigateToEditFamilialRSTR(query,participantCol1).editStatus();
	}

}
