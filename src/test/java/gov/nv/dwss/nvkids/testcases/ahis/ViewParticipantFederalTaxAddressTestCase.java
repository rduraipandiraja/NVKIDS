package gov.nv.dwss.nvkids.testcases.ahis;

import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class ViewParticipantFederalTaxAddressTestCase extends CommonLocators
{
	
	@Test(priority=7,description = "Navigate to  AHIS screen using Quick Navigation and Inquire field appearance", testName="UIT_AHIS_01030_Quick Navigation to AHIS")
	public  void InquireViewAHISInformationScreen() throws Exception{
		new LoginPage().login().quickNavigation_AHIS().navigateToMenuNavigation().ViewParticipantFederalTaxAddress();
	}
	
	@Test(priority=8,description = " Select Filters popup displays  Filter fields by clicking  Filter icon",testName="UIT_AHIS_01070_Inquire Select Filters Fields")
	public  void InquireSelecFilters() throws Exception{
		new LoginPage().login().quickNavigation_AHIS().navigateToMenuNavigation().verifyFilterSection();
	}
	
	@Test(priority=9,description = "Inquire  Grid Records in view participant address", testName="UIT_AHIS_01120_Inquire Grid Records")
	public void InquireGridResult() throws Exception{
		new LoginPage().login().quickNavigation_AHIS().navigateToMenuNavigation().verifyresult();
	}
}


