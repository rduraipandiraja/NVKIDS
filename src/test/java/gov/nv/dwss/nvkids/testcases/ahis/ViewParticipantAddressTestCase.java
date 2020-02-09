package gov.nv.dwss.nvkids.testcases.ahis;

import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class ViewParticipantAddressTestCase extends CommonLocators
{
	
	@Test(priority=1,description = "Navigate to  AHIS screen using Quick Navigation and verify field appearance", testName="UIT_AHIS_00010_Quick Navigation to AHIS")
	public  void verifyViewAHISInformationScreen() throws Exception{
		new LoginPage().login().quickNavigation_AHIS().verifyViewParticipantAddress();
	}
	
	@Test(priority=2,description = " Select Filters popup displays  Filter fields by clicking  Filter icon",testName="UIT_AHIS_00060_Verify Select Filters Fields	")
	public  void verifySelecFilters() throws Exception{
		new LoginPage().login().quickNavigation_AHIS().verifyFilter();
	}
	
	@Test(priority=3,description = "verify  Grid Records in view participant address", testName="UIT_AHIS_00110_verify Grid Records")
	public void InquireGridResult() throws Exception{
		new LoginPage().login().quickNavigation_AHIS().verifyGridres();
	}
	
}

