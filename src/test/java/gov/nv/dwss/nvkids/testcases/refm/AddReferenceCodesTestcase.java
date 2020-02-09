package gov.nv.dwss.nvkids.testcases.refm;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class AddReferenceCodesTestcase extends CommonLocators
{
	@DataProvider(name="getReferenceEntityAndAttribute")
    public static Object[][] getReferenceEntityAndAttribute() throws Exception
	{
		return DataLibrary.readExcelData("REFM_Add Reference Codes_Test Data",0);
	}
	
	@Test(testName = "UIT_REFM_00570_Navigate to Add Reference Codes screen",priority=9,description="Navigate to Add Reference Codes screen function and verify fields present")
	public void navigateToAddReferenceCodes() throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoAddReferenceCodes().verifyAddReferenceCodesFields();
	}
	
	@Test(dataProvider = "getReferenceEntityAndAttribute",testName = "UIT_REFM_00710_Verify Successful Add",priority=10,description="Verify that an informational message displays after a Successful Add")
	public void verifySuccessfulAdd(String refEntity,String refAttrib) throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoAddReferenceCodes().verifySuccessfulAdd(refEntity,refAttrib);
	}
	
}

