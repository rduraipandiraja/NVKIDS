package gov.nv.dwss.nvkids.testcases.refm;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class EditReferenceCodesTestcase extends CommonLocators
{
	@DataProvider(name="getReferenceEntityAndAttribute")
    public static Object[][] getReferenceEntityAndAttribute() throws Exception
	{
		return DataLibrary.readExcelData("REFM_Edit Reference Codes_Test Data",0);
	}
		
	@Test(dataProvider = "getReferenceEntityAndAttribute",testName = "UIT_REFM_00780_Navigate to Edit Reference Codes screen",priority=11,description="Navigate to Edit Reference Codes screen function and verify Fields")
	public void navigateToViewReferenceCodes(String query,String colName1,String colName2) throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoEditReferenceCodes(query,colName1,colName2).verifyEditReferenceCodeFields();
	}
	
	@Test(dataProvider = "getReferenceEntityAndAttribute",testName = "UIT_REFM_00830_Verify Successful Edit",priority=12,description="Verify that an informational message displays after a successful Edit")
	public void verifyEditWithValidValues(String query,String colName1,String colName2) throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoEditReferenceCodes(query,colName1,colName2).verifyEditWithValidValues();
	}
}
