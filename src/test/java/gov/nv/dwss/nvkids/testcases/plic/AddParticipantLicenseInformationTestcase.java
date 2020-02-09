package gov.nv.dwss.nvkids.testcases.plic;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class AddParticipantLicenseInformationTestcase extends CommonLocators  {
	
	@DataProvider(name="ParticipantID")
    public static Object[][] fetchDataParticipantID() throws Exception
	{
		return DataLibrary.readExcelData("PLIC_ParticipantID_Test Data",0);
	}
	
	@Test(dataProvider="ParticipantID", testName="UIT_PLIC_00790 - Verify Add license information screen",priority=1,description="Verify Add License information screen from view page in PLIC Screen")
	public void verifyClickAdd(String query, String ParticipantID) throws Exception
	{
		new LoginPage().login().quickNavigation_PLIC().verifyInquiryParticipantID(query, ParticipantID).verifyClickAdd().verifyAddParticipantLicenseInformation();
	}
	
	
	@Test(dataProvider="ParticipantID", testName="UIT_PLIC_01620 - Verify data Saved for participant",priority=2,description="Verify data Saved for otherpartyid in PLIC Screen")
	public void verifySaveData(String query, String ParticipantID) throws Exception
	{
		new LoginPage().login().quickNavigation_PLIC().verifyInquiryParticipantID(query, ParticipantID).verifyClickAdd().verifySaveData();
	}
}
