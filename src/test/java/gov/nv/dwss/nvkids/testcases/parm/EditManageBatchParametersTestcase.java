package gov.nv.dwss.nvkids.testcases.parm;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.pages.parm.EditManageBatchParametersPage;
import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class EditManageBatchParametersTestcase extends SeleniumBase
{
	
	@DataProvider(name="getJobID")
    public static Object[][] getJobID() throws Exception
	{
		return DataLibrary.readExcelData("PARM_View Manage Batch Parameters_Test Data",0);
	}
	
	@Test(dataProvider = "getJobID",testName="UIT_PARM_00480_Navigate to Edit Manage Batch Parameters Screen Function",priority=12,description="Navigate to Edit Manage Batch Parameters Screen Function")
	public void verifyFields(String query,String jobID) throws Exception
	{

		new LoginPage().login().quickNavigation_PARM().navigateToEditPARM(query,jobID).verifyFields();
	}
	
	@Test(dataProvider = "getJobID",testName="UIT_PARM_00650_Test editing a PARM record",priority=13,description="Test editing a PARM record")
	public void editParamterData(String query,String jobID) throws Exception
	{
		new LoginPage().login().quickNavigation_PARM().navigateToEditPARM(query,jobID).editParamterData();
		
	}
	

	
}
