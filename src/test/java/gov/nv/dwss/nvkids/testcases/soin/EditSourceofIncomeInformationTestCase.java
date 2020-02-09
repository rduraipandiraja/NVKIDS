package gov.nv.dwss.nvkids.testcases.soin;

import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class EditSourceofIncomeInformationTestCase extends CommonLocators {
	@Test(testName="UIT_SOIN_004820 - Navigate to SOIN Edit screen",priority=1,description="Verify Edit Screen ")
	public void EditVerifyScreen() throws Exception
	{
		new LoginPage().login().quickNavigation_SOIN().Editpage().EditVerifyScreen();		

	}
	
	@Test(testName="UIT_SOIN_006000 - Navigate to SOIN Edit screen",priority=2,description="Edit the data with field status as ACtive ")
	public void EditData() throws Exception
	{
		new LoginPage().login().quickNavigation_SOIN().Editpage().EditScreenAddDataandSave();		

	}
	
	@Test(testName="UIT_SOIN_006070 - Navigate to SOIN Edit screen",priority=3,description="Verify Edit screen in Relative Source of income page ")
	public void EditVerifyScreenRelatedSource() throws Exception
	{
		new LoginPage().login().quickNavigation_SOIN().Editpage().EditScreenVerifyRelatedSource();		

	}
	
	@Test(testName="UIT_SOIN_006940 - Navigate to SOIN Edit screen",priority=4,description=" Edit screen in Relative Source of income page and save the data ")
	public void EditAddDatainRelativeSource() throws Exception
	{
		new LoginPage().login().quickNavigation_SOIN().Editpage().EditScreenAddDataandSaveinRelatedSource();		

	}

}
