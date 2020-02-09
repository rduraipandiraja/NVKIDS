package gov.nv.dwss.nvkids.testcases.refm;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class EditReferencePercentagesTestcase extends CommonLocators
{
	@DataProvider(name="getPercentageCode")
    public static Object[][] getPercentageCode() throws Exception
	{
		return DataLibrary.readExcelData("REFM_Edit Reference Percentages_Test Data",0);
	}
	
	@Test(dataProvider = "getPercentageCode",testName = "UIT_REFM_01700_Navigate to Edit Reference Percentages & Verify",priority=24,description="Navigate to Edit Reference Percentages screen function and verify fields present")
	public void navigateToAddReferencePercentages(String percentageCode) throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewReferencePercentages().inquireAndNavigatetoEditReferencePercentages(percentageCode).verifyFieldsPresent();
	}
	
	@Test(dataProvider = "getPercentageCode",testName = "UIT_REFM_01860_Edit With Valid Values",priority=25,description="Edit With Valid Values")
	public void verifyEditWithValidValues(String percentageCode) throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewReferencePercentages().navigatetoAddRevisionReferencePercentages(percentageCode).addRevisionRecords().navigateToEditReferencePercentages().editReferencePercentages();
	}
}
