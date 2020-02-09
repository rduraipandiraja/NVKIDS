package gov.nv.dwss.nvkids.testcases.refm;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class AddRevisionReferencePercentagesTestcase extends CommonLocators 
{
	@DataProvider(name="getPercentageCode")
    public static Object[][] getPercentageCode() throws Exception
	{
		return DataLibrary.readExcelData("REFM_Add Revision Reference Percentages_Test Data",0);
	}
	
	@Test(dataProvider = "getPercentageCode",testName = "UIT_REFM_01930_Navigate to Add Revision Reference Percentages & Verify",priority=26,description="Navigate to Add Revision Reference Percentages screen function and verify fields present")
	public void navigateToAddReferencePercentages(String percentageCode) throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewReferencePercentages().navigatetoAddRevisionReferencePercentages(percentageCode).verifyFields();
	}
	
	@Test(dataProvider = "getPercentageCode",testName = "UIT_REFM_02060_Add With Valid Values",priority=27,description="Verify that a successful message displays when adding with valid values")
	public void AddWithValidValues(String percentageCode) throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewReferencePercentages().navigatetoAddRevisionReferencePercentages(percentageCode).addRevisionRecords();
	}
}
