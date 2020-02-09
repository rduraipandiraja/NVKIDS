package gov.nv.dwss.nvkids.testcases.refm;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class AddReferenceAmountsTestcase extends CommonLocators 
{
	@DataProvider(name="getAmountCode")
    public static Object[][] getPercentageCode() throws Exception
	{
		return DataLibrary.readExcelData("REFM_Add Reference Amounts_Test Data",0);
	}
	
	@Test(testName = "UIT_REFM_02700_Navigate to Add Reference Amounts",priority=38,description="Navigate to Add Reference Amounts screen function")
	public void navigateToViewReferenceCodes() throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewReferenceAmounts().navigatetoAddReferenceAmounts().verifyFields();
	}
	
	
	@Test(testName = "UIT_REFM_02880_Verify Successful Add",priority=39,description="Verify that an informational message is displayed after a successful Add")
	public void verifySuccessfulAdd() throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewReferenceAmounts().navigatetoAddReferenceAmounts().verifySuccessfulAdd();
	}
}
