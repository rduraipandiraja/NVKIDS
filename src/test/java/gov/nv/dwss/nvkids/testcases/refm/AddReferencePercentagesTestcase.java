package gov.nv.dwss.nvkids.testcases.refm;

import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class AddReferencePercentagesTestcase extends CommonLocators
{
	@Test(testName = "UIT_REFM_01450_Navigate to Add Reference Percentages & Verify",priority=22,description="Navigate to Add Reference Percentages screen function and verify fields present")
	public void navigateToAddReferencePercentages() throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewReferencePercentages().navigatetoAddReferencePercentages().verifyFieldsPresent();
	}
	
	@Test(testName = "UIT_REFM_01630_Verify Successful Add",priority=23,description="Verify that the record is added successfully")
	public void verifySuccessfulAdd() throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewReferencePercentages().navigatetoAddReferencePercentages().verifySuccessfulAdd();
	}
}

