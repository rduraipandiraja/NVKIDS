package gov.nv.dwss.nvkids.testcases.insr;

import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class ViewParticipantInsuranceTestCase extends CommonLocators{
	
	@Test(testName="UIT_INSR_00010 - Navigate to INSR screen",priority=1,description="Entering the screen acronym INSR in the Quick Navigation pop-up, verifying the INRS screen.")
	public void viewINSRPage() throws Exception
	{
		new LoginPage().login().quickNavigation_INSR().viewINSRpage();		

	}
	

	@Test(testName="UIT_INSR_00070 - Navigate to INSR screen",priority=2,description="Entering the screen acronym INSR in the Quick Navigation pop-up, verifying the INRS screen filter option.")
	public void viewINSRFilterFields() throws Exception
	{
		new LoginPage().login().quickNavigation_INSR().viewandVerifyFilterOptions();		

	}
	
	@Test(testName="UIT_INSR_000130 - Navigate to INSR screen",priority=3,description="Entering the screen acronym INSR in the Quick Navigation pop-up, verifying the Grid with participant id entered in the filter")
	public void viewINSRwithParticipantID() throws Exception
	{
		new LoginPage().login().quickNavigation_INSR().viewFileterOptionwithParticipantID();		

	}

	@Test(testName="UIT_INSR_000140 - Navigate to INSR screen",priority=4,description="Entering the screen acronym INSR in the Quick Navigation pop-up, verifying the Grid withpolicy verfication Status entered in the filter")
	public void viewINSRwithPolicyVer() throws Exception
	{
		new LoginPage().login().quickNavigation_INSR().viewFileterOptionwithPolicyStatus();		

	}
	@Test(testName="UIT_INSR_000460 - Navigate to INSR screen",priority=5,description="Entering the screen acronym INSR in the Quick Navigation pop-up, verifying the Grid filter option")
	public void viewGridFilterOption() throws Exception
	{
		new LoginPage().login().quickNavigation_INSR().viewGridFileterOption();		

	}
	@Test(testName="UIT_INSR_000520 - Navigate to INSR screen",priority=6,description="Entering the screen acronym INSR in the Quick Navigation pop-up, verifying the Grid details after clicking on the arrow")
	public void viewGridlabels() throws Exception
	{
		new LoginPage().login().quickNavigation_INSR().viewRecordinGrid();		

	}

}
