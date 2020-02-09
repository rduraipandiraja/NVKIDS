package gov.nv.dwss.nvkids.testcases.cpro;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class ViewCaseInitiationProcessesTestCase extends CommonLocators

{
	
	@DataProvider(name="getCaseID")
    public static Object[][] getCaseID() throws Exception
	{
		return DataLibrary.readExcelData("CPRO_ViewCaseInitiationProcesses_Test Data",0);
	}

	@Test(testName="UIT_CPRO_00010 - Navigate to CPRO screen",priority=1,description="Entering the screen acronym CPRO in the Quick Navigation pop-up, navigates to the DREF screen.")
	public void navigateToCPRO() throws Exception 
	{
			new LoginPage().login().quickNavigation_CPRO().verifyFieldsPresent();
	}
	
	@Test(testName="UIT_CPRO_00160 - View Filter fields",priority=2,description="The Select Filters pop-up displays the Filter fields by clicking the FILTER icon at the top right corner of the screen.")
	public void verifyFilterFields() throws Exception 
	{
			new LoginPage().login().quickNavigation_CPRO().verifyFilterFields();
	}

	@Test(dataProvider ="getCaseID",testName="UIT_CPRO_00220 - Inquire Case ID",priority=3,description="Inquiry with a Case ID that does exist in NVKIDS in the CASE ID field in the Select Filters pop-up")
	public void inquireCaseID(String query,String col1) throws Exception 
	{
			new LoginPage().login().quickNavigation_CPRO().inquireCaseID(query,col1);
	}
	

	@Test(dataProvider ="getCaseID",testName="UIT_CPRO_00230 - Inquire Case ID and Process",priority=4,description="Inquiry with a Case ID and Process that does exist in NVKIDS in the CASE ID field in the Select Filters pop-up")
	public void inquireCaseProcess(String query,String col1) throws Exception 
	{
			new LoginPage().login().quickNavigation_CPRO().inquireCaseProcess(query,col1);
	}
	
	
	@Test(testName="UIT_CPRO_00740 - Verify Show Columns",priority=5,description="Test Show Columns in the Grid Options to view the list of column")
	public void verifyShowColumns() throws Exception 
	{
			new LoginPage().login().quickNavigation_CPRO().verifyShowColumns();
	}
	
	@Test(testName="UIT_CPRO_00850 - Veirfy Start New Process Popup",priority=6,description="Check Start New Process Popup")
	public void verifyStartNewProcessPopup() throws Exception 
	{
			new LoginPage().login().quickNavigation_CPRO().verifyStartNewProcessPopup();
	}
	

	
}
