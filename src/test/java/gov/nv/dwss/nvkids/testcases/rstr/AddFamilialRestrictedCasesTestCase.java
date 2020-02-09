package gov.nv.dwss.nvkids.testcases.rstr;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class AddFamilialRestrictedCasesTestCase extends CommonLocators
{

	@DataProvider(name="getCaseIDUser")
    public static Object[][] getCaseID() throws Exception
	{
		return DataLibrary.readExcelData("RSTR_Add Familial Restricted Cases_Test Data",0);
	}
	
	@DataProvider(name="getParticipantIDUser")
    public static Object[][] getParticipantID() throws Exception
	{
		return DataLibrary.readExcelData("RSTR_Add Familial Restricted Cases_Test Data",1);
	}
	
	
	@Test(testName="UIT_RSTR_00680_Navigate to Add Familial Restricted Cases screen function",priority=15,description="Navigate to Add Familial Restricted Cases screen function")
	
		public void navigateToAddFamilialRestrictedCases() throws Exception 
		{
			new LoginPage().login().quickNavigation_RSTR().navigateToFamilialScreenFunction().navigateToAddFamilialRSTR().verifyFieldsPresent();
		}
		

	    @Test(dataProvider = "getCaseIDUser",testName="UIT_RSTR_00810_Add with CASE and Multiple PARTICIPANT's",priority=16,description="Add with CASE and Multiple PARTICIPANT's")
		
		public void addWithMultiParticipant(String query,String caseCol1,String query2,String userCol2) throws Exception 
		{
			new LoginPage().login().quickNavigation_RSTR().navigateToFamilialScreenFunction().navigateToAddFamilialRSTR().addWithMultiParticipant(query,caseCol1,query2,userCol2);
			
		}
		
	 @Test(dataProvider = "getParticipantIDUser",testName="UIT_RSTR_00820_Add with PARTICIPANT and Multiple CASE's",priority=17,description="Add with PARTICIPANT and Multiple CASE's")

	   public void addWithMultiCase(String query,String participantCol1,String query2,String userCol2) throws Exception 
	   {
		new LoginPage().login().quickNavigation_RSTR().navigateToFamilialScreenFunction().navigateToAddFamilialRSTR().addWithMultiCase(query,participantCol1,query2,userCol2);
	    }
	  
	  
}
