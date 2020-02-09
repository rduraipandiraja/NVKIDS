package gov.nv.dwss.nvkids.testcases.rstr;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class AddHighProfileRestrictedCasesTestCase extends SeleniumBase
{
	
	@DataProvider(name="getCaseID")
    public static Object[][] getCaseID() throws Exception
	{
		return DataLibrary.readExcelData("RSTR_Add High Profile Restricted Cases_Test Data",0);
	}
	
	@DataProvider(name="getParticipantID")
    public static Object[][] getParticipantID() throws Exception
	{
		return DataLibrary.readExcelData("RSTR_Add High Profile Restricted Cases_Test Data",1);
	}
	
	@Test(testName="UIT_RSTR_00250_Navigate to Add High Profile Restricted Cases Screen Function ",priority=5,description="Navigates to Add High Profile Restricted Cases screen function in RSTR Screen by clicking the Add icon in High Profile Restricted Cases screen function.")
	
	public void navigateToAddHighProfileRestrictedCases() throws Exception 
	{
		new LoginPage().login().quickNavigation_RSTR().navigateToAddHighRSTR().verifyFieldsPresent();
	}
	
   
   @Test(dataProvider = "getCaseID",testName="UIT_RSTR_00370_Add with CASE and Multiple PARTICIPANT's",priority=6,description="On adding with a value in the CASE and PARTICIPANT fields, the system restricts the case ID and the selected participant ID's in all the screens functions.")
	
	public void addWithMultiParticipant(String query,String caseCol1) throws Exception 
	{
		new LoginPage().login().quickNavigation_RSTR().navigateToAddHighRSTR().addWithMultiParticipant(query,caseCol1);
		
		
	}
	
  @Test(dataProvider = "getParticipantID",testName="UIT_RSTR_00380_Add with PARTICIPANT and Multiple CASE's",priority=7,description="On adding with a value in the PARTICIPANT and CASE fields, the system restricts the participant ID and the selected case ID's in all the screens functions.")

   public void addWithMultiCase(String query,String participantCol1) throws Exception 
   {
	new LoginPage().login().quickNavigation_RSTR().navigateToAddHighRSTR().addWithMultiCase(query,participantCol1);
    }

   
 
	    
    
    
    
}
