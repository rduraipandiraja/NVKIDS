package gov.nv.dwss.nvkids.testcases.ahis;

import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class AddParticipantAddressTestCase extends CommonLocators
{
	@Test(priority=4,description = "Navigate to Add Participant Address Screen and verify Add Fields", testName="UIT_AHIS_00650_verify the Add Fields")
	public  void ViewAddDocVerifyAddField() throws Exception{
		
		new LoginPage().login().quickNavigation_AHIS().navigateToAddParticipantAddressPage().verifyAddParticipantAddressPage();
	}
	
	@Test(priority=5,description = "Navigate to Add Participant Address Screen and Verify Matched data for Required Fields", testName="UIT_AHIS_00840_verify Matched data for Required Fields")
	public  void ViewAddDocMatchedDataField() throws Exception
	{
		new LoginPage().login().quickNavigation_AHIS().navigateToAddParticipantAddressPage().verifyallrequiredfield();
	}
}
