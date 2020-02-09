package gov.nv.dwss.nvkids.testcases.plic;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class EditParticipantLicenseInformationTestcase extends CommonLocators  {

	@DataProvider(name="ParticipantID")
	public static Object[][] fetchDataParticipantID() throws Exception
	{
		return DataLibrary.readExcelData("PLIC_ParticipantID_Test Data",0);
	}


	@Test(dataProvider="ParticipantID", testName="UIT_PLIC_01700 - Verify Edit license information screen",priority=1,description="Verify Edit License information screen from view page in PLIC Screen")
	public void verifyClickEdit(String ParticipantID, String colName) throws Exception
	{
		new LoginPage().login().quickNavigation_PLIC().verifyInquiryParticipantID(ParticipantID, colName).verifyClickEdit().verifyEditParticipantLicenseInformation();
	}

	@Test(dataProvider="ParticipantID", testName="UIT_PLIC_02380 - Verify save data screen",priority=2,description="Verify save data for a participant from view page in PLIC Screen")
	public void verifySaveParticipantInfo(String ParticipantID, String colName) throws Exception
	{
		new LoginPage().login().quickNavigation_PLIC().verifyInquiryParticipantID(ParticipantID, colName).verifyClickEdit().verifySaveParticipantLicenseInformation();
	}

}
