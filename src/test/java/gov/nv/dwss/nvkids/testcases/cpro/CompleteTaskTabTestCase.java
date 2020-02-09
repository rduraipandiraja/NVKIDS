package gov.nv.dwss.nvkids.testcases.cpro;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class CompleteTaskTabTestCase extends CommonLocators
{
@DataProvider(name="getCaseID")
public static Object[][] getCaseID() throws Exception
{
	return DataLibrary.readExcelData("CPRO_ProcessFlowTab_Test Data",0);
}
@Test(dataProvider = "getCaseID",testName="Verify Process Flow",priority=8,description="Verify Process Flow")
public void verifyStartNewProcessPopup(String query,String col1) throws Exception 
{
		new LoginPage().login().quickNavigation_CPRO().navigateToProcessFlowTabbyInquire(query, col1).verifyTab().navigatetoCompleteTask().verifyCompleteTask().processGoodCauseflow1();
}

}