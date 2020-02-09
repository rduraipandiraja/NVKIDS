package gov.nv.dwss.nvkids.testcases.soin;

import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class ViewSourceofIncomeInformationTestCase extends CommonLocators {
	@Test(testName="UIT_SOIN_00010 - Navigate to SOIN screen",priority=1,description="Entering the SOIN Screen ")
	public void VerifyViewParticipantSourceOfIncome() throws Exception
	{
		new LoginPage().login().quickNavigation_SOIN(). VerifyViewParticipantSourceOfIncome();		

	}
	@Test(testName="UIT_SOIN_00040 - Navigate to SOIN screen and verify Grid Filter",priority=2,description="Entering the SOIN Screenverify Grid Filter option ")
	public void VerifyGridOptions() throws Exception
	{
		new LoginPage().login().quickNavigation_SOIN(). VerifyFilters();		

	}
	@Test(testName="UIT_SOIN_00050 - Navigate to SOIN screen and verify Grid Filter with Related source of income",priority=3,description="Entering the SOIN Screenverify Grid Filter optionwith Related source of income ")
	public void VerifyGridOptionswithRelatedSourceofIncome() throws Exception
	{
		new LoginPage().login().quickNavigation_SOIN(). VerifyFiltersRelatedSourceofIncome();		

	}
	@Test(testName="UIT_SOIN_000100 - Navigate to SOIN screen and verify Grid Filter with Source of income type",priority=4,description="Entering the SOIN Screenverify Grid Filter optionwithsource of income Type")
	public void VerifyGridOptionswithSourceofIncomeType() throws Exception
	{
		new LoginPage().login().quickNavigation_SOIN(). VerifyFiltersSourceofIncomeType() ;		

	}
	@Test(testName="UIT_SOIN_000220 - Navigate to SOIN screen and verify Grid Filter with Status",priority=5,description="Entering the SOIN Screenverify Grid Filter optionwith Status")
	public void VerifyGridOptionswithStatus() throws Exception
	{
		new LoginPage().login().quickNavigation_SOIN().  VerifyFiltersStatus() ;		

	}

	@Test(testName="UIT_SOIN_000240 - Navigate to SOIN screen and verify Grid Filter with Name and Exact in untitled",priority=6,description="Entering the SOIN Screenverify Grid Filter optionwith  Name and Exact in untitled")
	public void VerifyGridOptionswithName() throws Exception
	{
		new LoginPage().login().quickNavigation_SOIN().VerifyFilterName() ;		

	}
	@Test(testName="UIT_SOIN_000550 - Navigate to SOIN screen and verify Grid Filter with basic details",priority=7,description="Entering the SOIN Screenverify Grid Filter optionwith  basic details")
	public void VerifyGridOptionswithAllvalue() throws Exception
	{
		new LoginPage().login().quickNavigation_SOIN().VerifyFilterwithAllvalues() ;		

	}
	@Test(testName="UIT_SOIN_000320 - Navigate to SOIN screen a",priority=9,description="Entering the SOIN Screenverify verify Participant linked to Source of Income")
	public void VerifYDoingBusinessAs() throws Exception
	{
		new LoginPage().login().quickNavigation_SOIN().VerifyFilterNameinUntitled1() ;		

	}
	
	@Test(testName="UIT_SOIN_0007010 - Navigate to SOIN screen and verify Participant linked to Source of Income",priority=10,description="Entering the SOIN Screenverify verify Participant linked to Source of Income")
	public void VerifyPartcipantLinkedTosourceofIncome() throws Exception
	{
		new LoginPage().login().quickNavigation_SOIN().VerifyParticipantLinkedtoSourceofIncome() ;		

	}
	
	
	
}
