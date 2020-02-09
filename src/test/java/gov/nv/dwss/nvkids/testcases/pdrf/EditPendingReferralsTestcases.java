package gov.nv.dwss.nvkids.testcases.pdrf;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class EditPendingReferralsTestcases extends CommonLocators {

	@DataProvider(name = "ParticipantID")
	public static Object[][] fetchDataParticipantID() throws Exception {
		return DataLibrary.readExcelData("PDRF_ParticipantID_Test Data", 0);
	}

//		@Test(testName="UIT_PDRF_01350 - Verify Edit Pending referral Screens Fields", priority=1, description="Verify Edit pending Referral screen fields from edit page in PDRF Screen")
	public void verifyEditPendingReferralsFieldsInfo() throws Exception {
		new LoginPage().login().quickNavigation_PDRF().verifyNavigateToEditPendingReferralScreen().verifyEditPendingReferralsFields();
	}

//		@Test(testName="UIT_PDRF_01360 - Verify Edit pending Referral screen for rejected status", priority=2 ,description="Verify Edit pending Referral fields for rejected status from edit page in PDRF Screen")
	public void verifyRejectButton() throws Exception {
		new LoginPage().login().quickNavigation_PDRF().verifyNavigateToEditPendingParticipantInformationforRejected().verifyRejectButton();
	}

//		@Test(testName="UIT_PDRF_01400 - Verify Edit Pending Referral screen for Rejected Reason field", priority=3 ,description="Verify Edit Pending Referral for Rejected Reason field after selecting reject status from edit page in PDRF Screen")
	public void verifyRejectResonFieldDisplayed() throws Exception {
		new LoginPage().login().quickNavigation_PDRF().verifyNavigateToEditPendingReferralScreen().verifyRejectResonDisplayed();
	}

//		@Test(testName="UIT_PDRF_01410 - Verify Edit Pending Referral screen for Declined button", priority=4 ,description="Verify Edit Pending Referral Decline Status from edit page in PDRF Screen")
	public void verifyDeclineButton() throws Exception {
		new LoginPage().login().quickNavigation_PDRF().verifyNavigateToEditPendingReferralScreen().verifyDeclineButton();
	}

//		@Test(testName="UIT_PDRF_01420 - Verify Edit Pending Referral screen  for Link Referral Button",priority=5,description="Verify Edit Pending Referral for Link Referral Button from edit page in PDRF Screen")
	public void verifyLinkReferralButton() throws Exception {
		new LoginPage().login().quickNavigation_PDRF().verifyNavigateToEditPendingReferralScreen().verifyLinkReferralButton();
	}

//		@Test(testName="UIT_PDRF_01430 - Verify Edit Pending Referral screen for Link Update Referral Button", priority=6 ,description="Verify Edit Pending Referral for Link Update Referral Button from edit page in PDRF Screen")
	public void verifyLinkUpdateReferralButton() throws Exception {
		new LoginPage().login().quickNavigation_PDRF().verifyNavigateToEditPendingReferralScreen().verifyLinkUpdateReferralButton();
	}

//		@Test(testName="UIT_PDRF_01480 - Verify Edit Pending Referral screen for Enter CaseID",priority=7,description="Verify Edit Pending Referral for Enter CaseID  from edit page in PDRF Screen")
	public void verifyEnterCaseIDfield() throws Exception {
		new LoginPage().login().quickNavigation_PDRF().verifyNavigateToEditPendingReferralScreen().verifyEnterCaseID();
	}

		@Test(testName="UIT_PDRF_01490 - Verify Edit Pending Referral screen for Case Details for TANF fields",priority=8,description="Verify Edit Pending Referral screen for Case Details fields from edit page in PDRF Screen")
	public void verifyCaseDetail() throws Exception {
		new LoginPage().login().quickNavigation_PDRF().verifyTanfDetails().verifyNavigateToEditPendingReferralScreen().verifyCaseDetails();
	}

//		@Test(testName="UIT_PDRF_01500 - Verify Edit Pending Referral screen for Foster Care Details status and its Case Details",priority=9,description="Verify Edit Pending Referral screen for Foster Care Details status and its Case Details fields from edit page in PDRF Screen")
//	public void verifyFosterCareDetails() throws Exception {
//		new LoginPage().login().quickNavigation_PDRF().verifyCaseDetailsforFosterChild().verifyNavigateToEditPendingReferralScreen().verifyFosterCareDetails();
//
//	}
//
//	 @Test(testName="UIT_PDRF_01520 - Verify Edit Pending Referral screen for Case Participant Details",priority=10,description="Verify Edit Pending Referral screen for Case Participant Details from edit page in PDRF Screen")
//	public void verifyEditCareParticipantDetails() throws Exception {
//		new LoginPage().login().quickNavigation_PDRF().verifyNavigateToEditPendingReferralScreen().verifyEditCaseParticipantDetails();
//
//	}

//	 @Test(testName="UIT_PDRF_01530 - Verify Edit Pending Referral screen for Case Participant Info",priority=11,description="Verify Edit Pending Referral screen for Case Participant Info from edit page in PDRF Screen")
	public void verifyEditCareParticipantInfo() throws Exception {
		new LoginPage().login().quickNavigation_PDRF().verifyCaseDetailsforFosterChild().verifyNavigateToEditPendingReferralScreen().verifyEditCaseParticipantInfo();

	}

//		@Test(testName="NEW - Verify Edit Pending Referral screen for Custodial Parent",priority=12,description="Verify Edit Pending Referral screen for Custodial Parent from edit page in PDRF Screen")
//	public void verifyParticipantSearchforCustodialParent() throws Exception {
//		new LoginPage().login().quickNavigation_PDRF().verifyNavigateToEditPendingReferralScreen().verifyParticipantSearchforCustodialParentLinkReferral();
//
//	}

//	@Test(testName="UIT_PDRF_01540 - Verify Edit Pending Referral screen for Custodial Parent link update",priority=13,description="Verify Edit Pending Referral screen for Custodial Parent link update from edit page in PDRF Screen")
//	public void verifyParticipantSearchforCustodialParentlinkupdate() throws Exception {
//		new LoginPage().login().quickNavigation_PDRF().verifyNavigateToEditPendingReferralScreen().verifyParticipantSearchforCustodialParentlinkupdate();
//
//	}
//
//
//	@Test(testName="UIT_PDRF_01560 - Verify Edit Pending Referral screen for Search for Child field",priority=14,description="Verify Edit Pending Referral for Search for Child field from edit page in PDRF Screen") 
//	public void verifyParticipantSearchforChild() throws Exception { 
//		new LoginPage().login().quickNavigation_PDRF().verifyNavigateToEditPendingReferralScreen().verifyParticipantSearchforChild();
//	}
//
//	@Test(testName="UIT_PDRF_01570 - Verify Edit Pending Referral screen for Search for Child field and CreateNewparticipant button",priority=15,description="Verify Edit Pending Referral for Search for Child field and CreateNewparticipant button from edit page in PDRF Screen") 
//	public void verifyParticipantSearchforChildCreateNewparticipant() throws Exception { 
//		new LoginPage().login().quickNavigation_PDRF().verifyNavigateToEditPendingReferralScreen().verifyParticipantSearchforChildCreateNewparticipant();
//
//	}
//
//	@Test(testName="UIT_PDRF_01580 - Verify Edit Pending Referral screen for Search for Child field for the Existing participant",priority=16,description="Verify Edit Pending Referral for Search for Child field for the Existing participant from edit page in PDRF Screen")
//	public void verifyParticipantSearchforChildExistingparticipant() throws Exception {
//		new LoginPage().login().quickNavigation_PDRF().verifyCaseDetailsforFosterChild()
//		.verifyNavigateToEditPendingReferralScreen().verifyParticipantSearchforChildExistingparticipant();
//
//	}
//
//		@Test(testName="01610 - Verify Edit Pending Referral screen for Additional Participant Details Panel",priority=17,description="Verify Edit Pending Referral screen for Additional Participant Details Panel from edit page in PDRF Screen")
//	public void verifyCaseParticipantDeatilsPanel() throws Exception {
//		new LoginPage().login().quickNavigation_PDRF().verifyNavigateToEditPendingReferralScreen()
//		.verifyCaseParticipantDeatilsPanel();
//
//	}
//
//		@Test(testName="01640 - Verify Edit Pending Referral screen for Case Participant Info",priority=18,description="Verify Edit Pending Referral screen for Case Participant Info from edit page in PDRF Screen")
//	public void verifyAdditionalParticipantDetailsPanel() throws Exception {
//		new LoginPage().login().quickNavigation_PDRF().verifyNavigateToEditPendingReferralScreen()
//		.verifyAdditionalParticipantDetailsPanel();
//
//	}
//
//	@Test(testName = "01680 - Verify Edit Pending Referral screen for Save as Reject Status", priority = 19, description = "Verify Edit Pending Referral for Save as Reject Status from edit page in PDRF Screen")
//	public void verifySaveasRejectStatus() throws Exception {
//		new LoginPage().login().quickNavigation_PDRF().verifyNavigateToEditPendingReferralScreen()
//		.verifySaveasRejectStatus();
//
//	}
//
//
//	@Test(testName = "01700 - Verify Edit Pending Referral screen for  Save as Decline Status", priority = 20, description = "Verify Edit Pending Referral screen for  Save as Decline Status from edit page in PDRF Screen")
//	public void verifySaveasDeclineStatus() throws Exception {
//		new LoginPage().login().quickNavigation_PDRF().verifyNavigateToEditPendingReferralScreen()
//		.verifySaveasDeclineStatus();
//
//	}
//	
//	@Test(testName = "01810 - Verify Save opertation for existing Participant ID in Edit PDRF Page", priority = 21, description = "Verify the 'Save' operation by linking the referral participant with existing participant ID when the 'Program Member ID' value is already exists in NVKIDS from edit page in PDRF Screen")
//	public void verifySaveforExistingParticipantID() throws Exception {
//		
//		new LoginPage().login().quickNavigation_PDRF().verifyNavigateToEditPendingReferralScreen().verifySaveforExistingParticipantID();
//
//	}
//	
//	@Test(testName = "01830 - Verify Save opertation for existing Participant ID with SSN in Edit PDRF Page", priority = 21, description = "Verify the 'Save' operation by linking the referral participant with existing participant ID with SSN when the 'Program Member ID' value is already exists in NVKIDS from edit page in PDRF Screen")
//	public void verifySaveforExistingParticipantIDwithSSN() throws Exception {
//		
//		new LoginPage().login().quickNavigation_PDRF().verifyNavigateToEditPendingReferralScreen().verifySaveforExistingParticipantIDwithSSN();
//
//	}
//	
//	@Test(testName = "01850 - Verify Save opertation for existing Participant ID with same CST and NCP in Edit PDRF Page", priority = 21, description = "Verify the 'Save' operation by linking the referral participant with existing participant ID with same CST and NCP in NVKIDS from edit page in PDRF Screen")
//	public void verifySaveforExistingParticipantIDwithSameCSTnNCP() throws Exception {
//		
//		new LoginPage().login().quickNavigation_PDRF().verifyNavigateToEditPendingReferralScreen().verifySaveforExistingParticipantIDwithSameCSTnNCP();
//
//	}
//	
//	
//	@Test(testName = "01960 - Verify Save opertation for existing Participant ID with CHILD, CP and NCP in Edit PDRF Page", priority = 21, description = "Verify the 'Save' operation by linking the referral participant with existing participant ID with CHILD, CP and NCP when the 'Program Member ID' value is already exists in NVKIDS from edit page in PDRF Screen")
//	public void verifySaveforExistingParticipantIDwithCPNCPChild_PMID() throws Exception {
//		
//		new LoginPage().login().quickNavigation_PDRF().verifyNavigateToEditPendingReferralScreen().verifySaveforExistingParticipantIDwithCPNCPChild_PMID();
//
//	}
//	
//	@Test(testName = "01980 - Verify Save opertation for existing Participant ID with CHILD, CP and NCP & SSN in Edit PDRF Page", priority = 21, description = "Verify the 'Save' operation by linking the referral participant with existing participant ID with CHILD, CP and NCP when the 'SSN' value is already exists in NVKIDS from edit page in PDRF Screen")
//	public void verifySaveforExistingParticipantIDwithCPNCPChild_SSN() throws Exception {
//		
//		new LoginPage().login().quickNavigation_PDRF().verifyNavigateToEditPendingReferralScreen().verifySaveforExistingParticipantIDwithCPNCPChild_SSN();
//
//	}
//	
//	@Test(testName = "2000 - Verify Save opertation for existing Participant ID with CHILD, CP and NCP in Edit PDRF Page", priority = 21, description = "Verify the 'Save' operation by linking the referral participant with existing participant ID with CHILD, CP and NCP when the 'Program Member ID' value is already exists in NVKIDS from edit page in PDRF Screen")
//	public void verifySaveforExistingParticipantIDwithCPNCPChild() throws Exception {
//		
//		new LoginPage().login().quickNavigation_PDRF().verifyNavigateToEditPendingReferralScreen().verifySaveforExistingParticipantIDwithCPNCPChild();
//
//	
//	}
//	
//	@Test(testName = "2000 - Verify Save opertation for existing Participant ID with multiple CHILD in Edit PDRF Page", priority = 21, description = "Verify the 'Save' operation by linking the referral participant with existing participant ID with multiple CHILD when the 'Program Member ID' value is already exists in NVKIDS from edit page in PDRF Screen")
//	public void verifySaveforExistingParticipantIDwithmultipleChild() throws Exception {
//		
//		new LoginPage().login().quickNavigation_PDRF().verifyNavigateToEditPendingReferralScreen().verifySaveforExistingParticipantIDwithmultipleChild();
//
//	
//	}
	
//	@Test(testName = "02100 - Verify 'Create Case' icon in Edit PDRF Page", priority = 22, description = "Verify the On clicking the 'Create Case' icon in the Edit Pending Referral screen function, the system navigates to the CASE screen - Create Case screen function from edit page in PDRF Screen")
	public void verifyCreateCase() throws Exception {
		
		new LoginPage().login().quickNavigation_PDRF().verifyNavigateToEditPendingReferralScreen().verifyCreateCase();

	}

//	@Test(testName = "New - Verify 'Case Creation with Program type -TANF'  in Edit PDRF Page", priority = 23, description = "Verify the on clicking the 'Create Case' icon with program type TANF  in the Edit Pending Referral screen function, the system navigates to the CASE screen - Create Case screen function from edit page in PDRF Screen")
	public void verifyCreateCaseWithTANF() throws Exception {
	
		new LoginPage().login().quickNavigation_PDRF().verifyNavigateToEditPendingReferralScreen().verifyCreateCaseWithTANF();

	}
	
//	@Test(testName = "New - Verify 'Case Creation with Program type -MEDICAID'  in Edit PDRF Page", priority = 24, description = "Verify the on clicking the 'Create Case' icon with program type MEDICAID  in the Edit Pending Referral screen function, the system navigates to the CASE screen - Create Case screen function from edit page in PDRF Screen")
	public void verifyCreateCaseWithMEDICAID() throws Exception {
	
		new LoginPage().login().quickNavigation_PDRF().verifyNavigateToEditPendingReferralScreen().verifyCreateCaseWithMEDICAID();

	}
	
//	@Test(testName = "New - Verify 'Case Creation with Program type - FosterCare'  in Edit PDRF Page", priority = 25, description = "Verify the on clicking the 'Create Case' icon with program type FosterCare  in the Edit Pending Referral screen function, the system navigates to the CASE screen - Create Case screen function from edit page in PDRF Screen")
	public void verifyCreateCaseWithFosterCare() throws Exception {
	
		new LoginPage().login().quickNavigation_PDRF().verifyNavigateToEditPendingReferralScreen().verifyCreateCaseWithFosterCare();

	}
	
	

}
