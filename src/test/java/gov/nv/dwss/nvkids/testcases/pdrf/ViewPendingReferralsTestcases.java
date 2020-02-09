package gov.nv.dwss.nvkids.testcases.pdrf;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class ViewPendingReferralsTestcases extends CommonLocators  {
	
	@DataProvider(name="ParticipantID")
    public static Object[][] fetchDataParticipantID() throws Exception
	{
		return DataLibrary.readExcelData("PLIC_ParticipantID_Test Data",0);
	}
	
//	@Test(testName="UIT_PDRF_00010 - Verify pending Referral information screen",priority=1,description="Verify pending Referral information screen from view page in PDRF Screen")
//	public void verifypendingReferralInfoScreen() throws Exception
//	{
//		new LoginPage().login().quickNavigation_PDRF().verifypendingReferralInformationScreen();
//	}
	
//	@Test(testName="UIT_PDRF_00070 - Verify Search Filter informations",priority=2,description="Verify search filter information screens from view page in PDRF Screen")
//	public void verifySearchFilterScreenInfo() throws Exception
//	{
//		new LoginPage().login().quickNavigation_PDRF().verifysearchFilterScreen();
//	}
	
//	@Test(testName="UIT_PDRF_00280 - Verify Inquiry all Filter fields",priority=3,description="Verify Inquire records by selecting all filter fields from view page in PDRF Screen")
//	public void verifyInquiryStatusInfo() throws Exception
//	{
//		new LoginPage().login().quickNavigation_PDRF().verifyInquiryStatus();
//	}
//	
//	@Test(testName="UIT_PDRF_00310 - Verify Show Columns",priority=4,description="Verify all Show columns in grid Options from PDRF Screen")
//	public void verifyShowColumnFields() throws Exception
//	{
//		new LoginPage().login().quickNavigation_PDRF().verifyShowColumnFields();
//	}
//	
//	@Test(testName="UIT_PDRF_01160 - Verify Filter the grid records with 'Background Color '",priority=5,description="Verify the grid records with Background Color in the grid from PDRF Screen")
//	public void verifyAdditionalRecordDetails() throws Exception
//	{
//		new LoginPage().login().quickNavigation_PDRF().verifyAdditionalRecordDetails();
//	}
//	
//	@Test(testName="UIT_PDRF_01190 - Verify Filter the grid records with 'Case Details info for TANF'",priority=6,description="Verify  the case details information records for TANF in the grid from PDRF Screen")
//	public void verifyCaseDetailsforTANF() throws Exception
//	{
//		new LoginPage().login().quickNavigation_PDRF().verifyCaseDetailsforTANF();
//	}
//	
//	@Test(testName="UIT_PDRF_01200 - Verify Filter the grid records with 'Case Details info for FosterCare'",priority=7,description="Verify  the case details information records for Foster Care  in the grid from PDRF Screen")
//	public void verifyCaseDetailsforFosterCare() throws Exception
//	{
//		new LoginPage().login().quickNavigation_PDRF().verifyCaseDetailsforFosterCare();
//	}
	
//	@Test(testName="UIT_PDRF_01220 - Verify Filter the grid records with 'Case Participant Details'",priority=8,description="Verify  the case participant details information records  in the grid from PDRF Screen")
//	public void verifyCaseParticipantDetails() throws Exception
//	{
//		new LoginPage().login().quickNavigation_PDRF().verifyCaseParticipantDetails();
//	}
//	
	@Test(testName="UIT_PDRF_01230 - Verify Filter the grid records with 'Participant Search Filter' ",priority=9,description="Verify  the participant search details information records   in the grid from PDRF Screen")
	public void verifyParticipantSearchFilters() throws Exception
	{
		new LoginPage().login().quickNavigation_PDRF().verifyParticipantSearchFilters();
	}
	
//	@Test(testName="UIT_PDRF_01240 - Verify Filter the grid records with 'Case Participant information fields' ",priority=10,description="Verify  the Case Participant information fields  from PDRF Screen")
//	public void verifyCaseParticipantInformation() throws Exception
//	{
//		new LoginPage().login().quickNavigation_PDRF().verifyCaseParticipantInformation();
//	}
//	
//	@Test(testName="UIT_PDRF_01270 - Verify 'Participant Additional Information' ",priority=11,description="Verify  the Participant Additional Information  from PDRF Screen")
//		public void verifyAdditionalParticipantInfo() throws Exception
//		{
//			new LoginPage().login().quickNavigation_PDRF().verifyAdditionalParticipantInfo();
//		}
//		
		
		
	
	
	
	
}
