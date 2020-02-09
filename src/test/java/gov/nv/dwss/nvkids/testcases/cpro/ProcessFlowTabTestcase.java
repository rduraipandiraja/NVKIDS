package gov.nv.dwss.nvkids.testcases.cpro;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class ProcessFlowTabTestcase extends CommonLocators

{

	@DataProvider(name="getCaseID")
    public static Object[][] getCaseID() throws Exception
	{
		return DataLibrary.readExcelData("CPRO_ProcessFlowTab_Test Data",0);
	}
	@Test(dataProvider = "getCaseID",testName="UIT_CPRO_00850 - Veirfy Start New Process Popup",priority=7,description="Check Start New Process Popup")
	public void verifyStartNewProcessPopup(String query,String col1) throws Exception 
	{
			new LoginPage().login().quickNavigation_CPRO().navigateToProcessFlowTabbyInquire(query, col1).verifyTab();
	}
}
