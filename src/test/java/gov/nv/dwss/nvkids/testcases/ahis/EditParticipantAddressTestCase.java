package gov.nv.dwss.nvkids.testcases.ahis;

import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class EditParticipantAddressTestCase extends CommonLocators
{
	@Test(priority=6,description = "Navigate to Edit Participant Address Screen and Verify verify Field for Edit Participant Address", testName="UIT_AHIS_00910_verify Field for Edit Participant Address Screen")
	public  void ViewEditParticipantField() throws Exception
	{
		new LoginPage().login().quickNavigation_AHIS().navigateToEditParticipantAddressPage().verifyEditParticipantAddress();
	}

}
