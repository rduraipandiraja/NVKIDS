package gov.nv.dwss.nvkids.testcases.PSOI;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class ViewParticipantSourceOfIncomeTestcase extends CommonLocators  {
	@DataProvider(name="ParticipantID")
	public static Object[][] fetchParticipantID() throws Exception
	{
		return DataLibrary.readExcelData("PSOI_ViewSourceofIncome_Test Data",0);
	}

	@Test(testName="UIT_PSOI_00010 - Navigate to PSOI screen",priority=1,description="Entering the screen acronym PSOI in the Quick Navigation pop-up, navigates to the PSOI screen.")
	public void VerifyViewParticipantSourceOfIncome() throws Exception
	{
		new LoginPage().login().quickNavigation_PSOI().VerifyViewParticipantSourceOfIncome();		

	}

	

	@Test(testName="UIT_PSOI_000100 - Verify select filter",priority=2,description="verifying the Select filter details.")
	public void verifySelectFilter() throws Exception
	{
		new LoginPage().login().quickNavigation_PSOI().verifySelectFilters();

	}


	@Test(dataProvider = "ParticipantID", testName="UIT_PSOI_000170_Verify using Participant ID",priority=3,description="Verify using participant ID") 
	public void verifyParticipantId(String query,String Data) throws Exception
	{ 
		new LoginPage().login().quickNavigation_PSOI().InquireWithPartId(query,Data); 
	}

	@Test(dataProvider = "ParticipantID", testName="UIT_PSOI_000220_Verify using Participant ID and Verification Status",priority=4,description="Verify using participant ID and Participation Status") 
	public void verifyParticipantIdandVerStatus(String query,String Data) throws Exception
	{ 
		new LoginPage().login().quickNavigation_PSOI().InquireWithPartIdandVerificationStatus( query,Data); 
	}

	@Test(dataProvider = "ParticipantID", testName="UIT_PSOI_000250_Verify using Participant ID and Verification Status",priority=5,description="Verify using participant ID and Participation Status") 
	public void verifyParticipantIdandPrimary(String query,String Data) throws Exception
	{ 
		new LoginPage().login().quickNavigation_PSOI().InquireWithPartIdandPrimary(query,Data); 
	}

	@Test(dataProvider = "ParticipantID", testName="UIT_PSOI_000270_Verify using Participant ID and Verification Status",priority=6,description="Verify using participant ID and Participation Status") 
	public void verifyGridOption(String query,String Data) throws Exception
	{ 
		new LoginPage().login().quickNavigation_PSOI(). verifyShowFiltersFields(query,Data); 
	}
}
