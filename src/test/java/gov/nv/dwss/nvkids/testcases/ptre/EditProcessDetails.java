package gov.nv.dwss.nvkids.testcases.ptre;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.pages.ptre.ViewProcessDetails;
import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class EditProcessDetails extends CommonLocators  {


	@DataProvider(name="getProcessCode")
	public static Object[][] fetchProcess() throws Exception
	{
		return DataLibrary.readExcelData("PTRE_ViewProcessDetails_Test Data",0);
	}

	@Test(priority=44,dataProvider = "getProcessCode", description="NavigateToViewProcessDetails and Verify the fields in Edit Process Details screen",testName="UIT_PTRE_0440 Verify Edit Process Details fields")
	public void verifyEditProcessDetailsAppearance(String query, String procesCode, String processDesc) throws Exception
	{
		new LoginPage().login().quickNavigation_PTRE().navigateToEditProcessDetails(query,procesCode ).verifyEditProcessDetailsAppearance();

	}
	

	@Test(priority=48,dataProvider = "getProcessCode", description="Test Save Icon with change" ,testName="UIT_PTRE_0480 Save with changes")
	public void verifyUpdateWithChanges(String query, String procesCode, String processDesc) throws Exception
	{   
		new LoginPage().login().quickNavigation_PTRE().navigateToEditProcessDetails(query,procesCode).verifyUpdateWithChanges();
	}

	

	



}