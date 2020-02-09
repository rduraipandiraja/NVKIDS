package gov.nv.dwss.nvkids.testcases.refm;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class AddRevisionReferenceAmountsTestcase extends CommonLocators
{
	@DataProvider(name="getAmountCode")
    public static Object[][] getAmountCode() throws Exception
	{
		return DataLibrary.readExcelData("REFM_Add Revision Reference Amounts_Test Data",0);
	}
	
	@Test(dataProvider = "getAmountCode",testName = "UIT_REFM_03170_Navigate to Add Revision Reference Amounts",priority=42,description="Navigate to Add Revision Reference Amounts and verify fields")
	public void verifyEditFields(String amountCode) throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewReferenceAmounts().navigatetoAddRevisionReferenceAmounts(amountCode).verifyFields();
	}
	
	@Test(dataProvider = "getAmountCode",testName = "UIT_REFM_03310_Verify Successful Add",priority=43,description="Verify that an informational message displays after a successful Add")
	public void verifySuccessfulAdd(String amountCode) throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewReferenceAmounts().navigatetoAddRevisionReferenceAmounts(amountCode).addRevisionRecords();
	}
}
