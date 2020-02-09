package gov.nv.dwss.nvkids.testcases.soin;

import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class AddSourceofIncomeInformationTestCase extends  CommonLocators {
	@Test(testName="UIT_SOIN_002620 - Navigate to SOIN Add screen",priority=1,description="Verify Add Screen ")
	public void AddVerifyScreen() throws Exception
	{
		new LoginPage().login().quickNavigation_SOIN().Addpage().AddVerifyScreen();		

	}
	@Test(testName="UIT_SOIN_003790 - Navigate to SOIN Add screen and enter mandatory field and save data",priority=2,description="Verify Add Screen and enter mandatory field and save data ")
	public void AddDataandSave() throws Exception
	{
		new LoginPage().login().quickNavigation_SOIN().Addpage().AddDataandSave();		

	}
	
	@Test(testName="UIT_SOIN_003870 - Navigate to SOIN Add screen and enter Verify field in relative source of income ",priority=3,description="Verify Add Screen and enter mandatory field and save data ")
	public void AddDataandVerifyRelatedSourceofIncome() throws Exception
	{
		new LoginPage().login().quickNavigation_SOIN().Addpage().AddVerifyScreenwithRelatedSourceofIncome();		

	}
	@Test(testName="UIT_SOIN_004740 - Navigate to SOIN Add screen and enter mandatory field in relative source of income and save data",priority=4,description="Verify Add Screen and enter mandatory field and save data ")
	public void AddDataandSaveRelatedSourceofIncome() throws Exception
	{
		new LoginPage().login().quickNavigation_SOIN().Addpage().AddDataandSaveRelatedSourceofIncome();		

	}


}
