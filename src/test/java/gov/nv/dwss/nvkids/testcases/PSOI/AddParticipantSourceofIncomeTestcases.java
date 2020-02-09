package gov.nv.dwss.nvkids.testcases.PSOI;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class AddParticipantSourceofIncomeTestcases extends CommonLocators {
	@DataProvider(name="ParticipantID")
	public static Object[][] fetchParticipantIDForADD() throws Exception
	{
		return DataLibrary.readExcelData("PSOI_ViewSourceofIncome_Test Data",0);
	}

	@Test(dataProvider = "ParticipantID",testName="UIT_PSOI_000780 - Navigate to Add Screen",priority=1,description="Navigate to ADD screen")
	public void VerifyClickAdd1(String query,String ParticipantID) throws Exception
	{
		new LoginPage().login().quickNavigation_PSOI().clickAdd(query,ParticipantID).VerifyAddPage();		

	}
	
	@Test(dataProvider = "ParticipantID",testName="UIT_PSOI_000990 - Navigate to Add Screen",priority=2,description="Navigate to ADD screen and select the source of income type as social security in source of income ID")
	public void VerifyStatusEnabled(String query,String ParticipantId) throws Exception
	{
		new LoginPage().login().quickNavigation_PSOI().clickAdd(query,ParticipantId).AddpageVerifyStatusEnabled();		

	}
	
	@Test(dataProvider = "ParticipantID",testName="UIT_PSOI_0001110 - Navigate to Add Screen",priority=3,description="Navigate to ADD screen and select the source of income type as social security in source of income ID and verify if BAn number text box is enabled")
	public void VerifyBANEnabled(String query,String ParticipantId) throws Exception
	{
		new LoginPage().login().quickNavigation_PSOI().clickAdd(query,ParticipantId).AddpageVerifyClaimACNoEnabled();		

	}
	@Test(dataProvider = "ParticipantID",testName="UIT_PSOI_0001360 - Navigate to Add Screen",priority=4,description="Navigate to ADD screen and select the source of income type as Military in source of income ID and verify if Military Id and other related boxes are enebled")
	public void VerifyMilitaryIDEnabled(String query,String ParticipantId) throws Exception
	{
		new LoginPage().login().quickNavigation_PSOI().clickAdd(query,ParticipantId). AddpageVerifyMilitaryDetails();		

	}
	@Test(dataProvider = "ParticipantID",testName="UIT_PSOI_01490 - Navigate to Add Screen",priority=5,description="Navigate to ADD screen and type occupation details")
	public void VerifyTradeSkillEnabled(String query,String ParticipantId) throws Exception
	{
		new LoginPage().login().quickNavigation_PSOI().clickAdd(query,ParticipantId). AddpageVerifyTradeSkillEnables();		

	}
	@Test(dataProvider = "ParticipantID",testName="UIT_PSOI_01510 - Navigate to Add Screen",priority=6,description="Navigate to ADD screen andselect the source of income type as Union Benifits in source of income ID and verify if Union Membership text box is enebled")
	public void VerifyUnionMembershipEnabled(String query,String ParticipantId) throws Exception
	{
		new LoginPage().login().quickNavigation_PSOI().clickAdd(query,ParticipantId).AddpageverifyUnionMemberShipEnables();		

	}
	@Test(dataProvider = "ParticipantID",testName="UIT_PSOI_01530 - Navigate to Add Screen",priority=7,description="Navigate to ADD screen andselect is enebled")
	public void VerifyUnnamedtextboxEnabled(String query,String ParticipantId) throws Exception
	{
		new LoginPage().login().quickNavigation_PSOI().clickAdd(query,ParticipantId).AddpageverifyScheduledShft();		

	}
	@Test(dataProvider = "ParticipantID",testName="UIT_PSOI_01820 - Navigate to Add Screen",priority=7,description="Navigate to ADD screen and save the data successfully")
	public void AddPageSaveSuccessfully(String query,String ParticipantId) throws Exception
	{
		new LoginPage().login().quickNavigation_PSOI().clickAdd(query,ParticipantId).AddpageSave();		

	}

}
