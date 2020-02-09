package gov.nv.dwss.nvkids.testcases.plic;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class ViewParticipantLicenseInformationTestcase extends CommonLocators  {
	
	@DataProvider(name="ParticipantID")
    public static Object[][] fetchDataParticipantID() throws Exception
	{
		return DataLibrary.readExcelData("PLIC_ParticipantID_Test Data",0);
	}
	
	@DataProvider(name="ParticipantIDandLicenseType")
	public static Object[][] fetchDataParticipantIDandLicenseType() throws Exception
	{
		return DataLibrary.readExcelData("PLIC_ParticipantID_Test Data",1);
	}

	
	@Test(testName="UIT_PLIC_00010 - Verify Participant license Information and associatedScreens",priority=1,description="Verifying Participant license Information and associatedScreens in PLIC Screen.")
	public void verifyViewParticipantLicenseInformation() throws Exception
	{
		new LoginPage().login().quickNavigation_PLIC().verifyViewParticipantLicenseInformation().viewAssociatedScreens();
	}

	@Test(testName="UIT_PLIC_00110 - Verify Select Filter",priority=2,description="Verify Select Filter in PLIC Screen")
	public void verifySelectFilters() throws Exception
	{
		new LoginPage().login().quickNavigation_PLIC().verifySelectFilters();
	}
	
	@Test(dataProvider="ParticipantID", testName="UIT_PLIC_00170 - Verify ParticipantID grid data",priority=3,description="Verify ParticipantID grid data in PLIC Screen")
	public void verifyInquiryParticipantID(String query, String participantID) throws Exception
	{
		new LoginPage().login().quickNavigation_PLIC().verifyInquiryParticipantID(query, participantID);
	}
	
	@Test(dataProvider="ParticipantIDandLicenseType", testName="UIT_PLIC_00220 - Verify ParticipantID and License type grid Data",priority=4,description="Verify ParticipantID and License type grid Data in PLIC Screen")
	public void verifyInquiryParticipantIDandLicensetype(String ParticipantID,String colName1, String LicenseType, String colName2) throws Exception
	{
		new LoginPage().login().quickNavigation_PLIC().verifyInquiryParticipantIDandLicensetype(ParticipantID, colName1, LicenseType, colName2);
	}
	
	@Test(dataProvider="ParticipantID", testName="UIT_PLIC_00650 - Verify ShowFilter and Show Column",priority=6,description="Verify ShowFilter and Show Column filter in PLIC Screen")
	public void verifyShowColumnFilters(String ParticipantID, String colName) throws Exception
	{
		new LoginPage().login().quickNavigation_PLIC().verifyInquiryParticipantID(ParticipantID,colName).verifyShowColumnFilters();
	}
	
	
	@Test(dataProvider="ParticipantID", testName="UIT_PLIC_00710 - Verify Navigation History",priority=7,description="Verify navigation History in PLIC Screen")
	public void verifyEachResult(String ParticipantID, String colName) throws Exception
	{
		new LoginPage().login().quickNavigation_PLIC().verifyInquiryParticipantID(ParticipantID,colName).verifyViewEachResult();
	}
	
	

}
