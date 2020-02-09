package gov.nv.dwss.nvkids.testcases.insr;

import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class AddParticipantInsuranceTestCase extends CommonLocators {
	@Test(testName="UIT_INSR_000580 - Navigate to INSR screen",priority=1,description="Entering the screen acronym INSR in the Quick Navigation pop-up, verifying the Add screen.")
	public void viewINSRPage() throws Exception
	{
		new LoginPage().login().quickNavigation_INSR().AddParticipantInsurance().AddscreenlabelVerification();		

	}

}
