package gov.nv.dwss.nvkids.testcases.refm;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class EditReferenceAmountsTestcase extends CommonLocators
{
	@DataProvider(name="getAmountCode")
    public static Object[][] getAmountCode() throws Exception
	{
		return DataLibrary.readExcelData("REFM_Edit Reference Amounts_Test Data",0);
	}
	
	@Test(dataProvider = "getAmountCode",testName = "UIT_REFM_02950_Navigate to Edit Reference Amounts",priority=40,description="Navigate to Edit Reference Amounts screen function")
	public void navigateToViewReferenceCodes(String amountCode) throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewReferenceAmounts().navigatetoEditReferenceAmounts(amountCode);
	}
	
	@Test(dataProvider = "getAmountCode",testName = "UIT_REFM_03100_Verify Successful Edit",priority=41,description="Verify that an informational message displays after a successful Edit")
	public void verifySuccessfulEdit(String amountCode) throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewReferenceAmounts().navigatetoAddRevisionReferenceAmounts(amountCode).addRevisionRecords().navigatetoEditReferenceAmountsWithFirstGridRow().verifySuccessfulEdit();
	}
}
