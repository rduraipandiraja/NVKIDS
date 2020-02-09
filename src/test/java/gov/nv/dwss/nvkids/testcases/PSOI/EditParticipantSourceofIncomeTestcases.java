package gov.nv.dwss.nvkids.testcases.PSOI;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class EditParticipantSourceofIncomeTestcases extends CommonLocators  {
	
	@DataProvider(name="ParticipantID")
	public static Object[][] fetchParticipantID() throws Exception
	{
		return DataLibrary.readExcelData("PSOI_EditSourceofIncome_Test Data",0);
	}

	@Test(dataProvider = "ParticipantID",testName="UIT_PSOI_002790 - Navigate to Edit participant source of income",priority=1,description="Inquiry using verification status  as Verification Pending in PSOI page and modifying the verification status for verifying enable of verified by and verified date")
	public void VerifyEditPage(String ParticipantID) throws Exception
	{
		new LoginPage().login().quickNavigation_PSOI().clickEdit(ParticipantID).EditPageVerifyBYDateEnables();		

	}
    @Test(dataProvider = "ParticipantID",testName="UIT_PSOI_002800 - Navigate to Edit participant source of income",priority=2,description="Inquiry using verification status  as Verification Pending in PSOI page and modifying the verification status for verifying enable of verified by and verified date with verification status as confirm bad")
	public void VerifyEditPageVerificationStatus(String ParticipantID) throws Exception
	{
		new LoginPage().login().quickNavigation_PSOI().clickEdit(ParticipantID).EditPageVerifyBYDateEnable();		

	}
     @DataProvider(name="ParticipantIDConfirmedBad")
 	public static Object[][] fetchParticipantIDwithConfirmedBad() throws Exception
 	{
 		return DataLibrary.readExcelData("PSOI_EditSourceofIncome_Test Data",1);
 	}
     
   @Test(dataProvider = "ParticipantIDConfirmedBad",testName="UIT_PSOI_003190 - Navigate to Edit participant source of income",priority=3,description="Inquiry using verification status  as Verification Pending in PSOI page and modifying the verification status for verifying enable of verified by and verified date with verification status as confirm bad")
 	public void VerifyEditPageVerificationTradeSkilleneble(String ParticipantID) throws Exception
 	{
 		new LoginPage().login().quickNavigation_PSOI().clicktable(ParticipantID).EditPageVerifyTradeSkillEnable();		

 	}
   @Test(dataProvider = "ParticipantIDConfirmedBad",testName="UIT_PSOI_003230 - Navigate to Edit participant source of income",priority=4,description="Inquire untitle field enable after selecting others ")
  	public void VerifyEditPageVerificationUntitleeneble(String ParticipantID) throws Exception
  	{
  		new LoginPage().login().quickNavigation_PSOI().clicktable(ParticipantID).EditPageVerifyUntitledfield();		

  	}
 	
     @Test(dataProvider = "ParticipantIDConfirmedBad",testName="UIT_PSOI_003520 - Navigate to Edit participant source of income",priority=5,description="Check edit data saved successfully ")
   	public void VerifyEditPageVerifyDataSaved(String ParticipantID) throws Exception
   	{
   		new LoginPage().login().quickNavigation_PSOI().clicktable(ParticipantID).EditPageEnterRequiredField();		

   	}
}
