package gov.nv.dwss.nvkids.pages.insr;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class ViewParticipantInsurancePage extends CommonLocators{
	public ViewParticipantInsurancePage(){
		PageFactory.initElements(driver, this); 
	}
	
	@FindBy(xpath="//h5") public WebElement elelblpageheader;
	@FindBy(xpath="//label[@for='personId']") WebElement elelblParticipantId;
	@FindBy(xpath="//label[@for='insuranceStatusCode']") WebElement elelblPolicyVerificationStatus;
	@FindBy(xpath="//label[@for='personId']//following-sibling::input") WebElement eletbParticipantID;
	@FindBy(xpath="//label[@class='label']/following-sibling::span") WebElement elelblstickyID;
	@FindBy(xpath="//input[@id='insuranceStatusCode']/following::label") WebElement eleddPolicyVerification;
	@FindBy(xpath="//i[@class='pi pi-chevron-down']") WebElement eledownArrow;
	@FindBy(xpath="//i[@class='pi pi-chevron-up']") WebElement eleUpArrow;
	//policy holder
	@FindBy(xpath="//legend[text()='Policy Holder']") WebElement elelblheader1;
	@FindBy(xpath="//label[text()=' Relationship to Ordered Party ']") WebElement elelblRelationshiporderedParty;
	@FindBy(xpath="//label[text()=' Name ']") WebElement elelblName;
	@FindBy(xpath="(//label[text()=' SSN '])[2]") WebElement elelblSSN;
	@FindBy(xpath="(//label[text()=' DOB '])[2]") WebElement elelblDOB;
	//Insurance
	@FindBy(xpath="//label[text()=' Insurance Co ID ']") WebElement elelblInsuranceCoID;
	@FindBy(xpath="(//label[text()=' Insurance Co Name '])[2]") WebElement elelblInsuranceCoName;
	@FindBy(xpath="//label[text()=' Employer/ Other ']") WebElement elelblEmployer;
	@FindBy(xpath="(//label[text()=' Verification Status '])[2]") WebElement elelblVerificationStatus;
	@FindBy(xpath="//label[text()=' Verification Source ']") WebElement elelblVerificationSource;
	@FindBy(xpath="(//label[text()=' Status Date '])[2]") WebElement elelblStatusDate;
	@FindBy(xpath="//label[text()=' Member Number ']") WebElement elelblMemberNumber;
	@FindBy(xpath="(//label[text()=' Policy No '])[2]") WebElement elelblPolicyNo;
	@FindBy(xpath="(//label[text()=' Group No '])[2]") WebElement elelblGroupNo;
	@FindBy(xpath="//label[text()=' Monthly Cost ']") WebElement elelblMonthlyCost;
	@FindBy(xpath="(//label[text()=' Effective Date '])[2]") WebElement elelblEffectiveDate;
	@FindBy(xpath="//label[text()=' Dental Coverage ']") WebElement elelblDentalCoverage;
	@FindBy(xpath="//label[text()=' Medical Coverage ']") WebElement elelblMedicalCoverage;
	@FindBy(xpath="//label[text()=' Vision Coverage ']") WebElement elelblVisionCoverage;
	@FindBy(xpath="(//label[text()=' End Date '])[2]") WebElement elelblEndDate;
	@FindBy(xpath="//label[text()=' Behavioral Health Coverage ']") WebElement elelblBehavioralHealthCoverage ;
	@FindBy(xpath="//label[text()=' Prescription Drug Coverage ']") WebElement elelblPrescriptionDrugCoverage ;
	@FindBy(xpath="//label[text()=' Other Coverage ']") WebElement elelblOtherCoverage ;
	@FindBy(xpath="//label[text()=' Out-Of-State Coverage ']") WebElement elelblOutOfStateCoverage  ;
	@FindBy(xpath="//label[text()=' Private Medical Coverage ']") WebElement elelblPrivateMedicalCoverage  ;
	@FindBy(xpath="//label[text()=' Medicaid Coverage ']") WebElement elelblMedicaidCoverage  ;
	
//Insurance coverage participants
	@FindBy(xpath="//label[text()=' Participant Name ']") WebElement elelblParticipantName;
	@FindBy(xpath="(//label[text()=' Participant ID '])[2]") WebElement elelblPArticipantId;
	@FindBy(xpath="(//label[text()=' SSN '])[3]") WebElement elelblSSN1 ;
	@FindBy(xpath="(//label[text()=' DOB '])[3]") WebElement elelblDOB1 ;
	@FindBy(xpath="//label[text()=' Relationship ']") WebElement elelblRelationship ;
	@FindBy(xpath="//label[text()=' Case ID ']") WebElement elelblCaseID  ;
	@FindBy(xpath="(//label[text()=' Dental Coverage '])[2]") WebElement elelblDentalCoverage1 ;
	@FindBy(xpath="(//label[text()=' Medical Coverage '])[2]") WebElement elelblMedicalCoverage1 ;
	@FindBy(xpath="(//label[text()=' Vision Coverage '])[2]") WebElement elelblVisionCoverage1  ;
	@FindBy(xpath="(//label[text()=' Behavioral Health Coverage '])[2]") WebElement elelblBehavioralHealthCoverage1	  ;
	@FindBy(xpath="(//label[text()=' Prescription Drug Coverage '])[2]") WebElement elelblPrescriptionDrugCoverage1  ;
	@FindBy(xpath="(//label[text()=' Other Coverage '])[2]") WebElement elelblOtherCoverage1  ;
	@FindBy(xpath="(//label[text()=' Monthly Cost '])[2]") WebElement elelblMonthlyCost1  ;
	@FindBy(xpath="(//label[text()=' Effective Date '])[3]") WebElement elelblEffectiveDate1  ;
	@FindBy(xpath="(//label[text()=' End Date '])[3]") WebElement elelblEndDate1;
	@FindBy(xpath="//label[text()=' Updated On ']") WebElement elelblUpdatedOn  ;
	@FindBy(xpath="//label[text()=' Updated By ']") WebElement elelblUpdatedBy;
	

	
	public ViewParticipantInsurancePage viewINSRpage() throws Exception
	{
		verifyExactText(elelblpageheader, "View Participant Insurance");
		verifyDisplayed(eleicnFilter, "Filter");
		verifyDisplayed(eleicnAdd, "Add");
		verifyGridHeaders(elelblGridHeaders, " Policy No "," Insurance Co Name "," Group No "," Verification Status "," Status Date "," Effective Date ", " End Date ");
		verifyAssociatedScreens(eleAssociatedScreenList, "Note Processor");
		return this;
		
	}

	public ViewParticipantInsurancePage viewandVerifyFilterOptions() throws Exception
	{	
		click(eleicnFilter, "Filter");
		verifyDisplayed(elelblParticipantId, "Participant ID");
		verifyDisplayed(elelblPolicyVerificationStatus, "Policy Verification Status");
		verifyDisplayed(eleicnClear, "Clear");
		verifyDisplayed(eleicnSearch, "Search");
		return this;
		
	}
	
	public ViewParticipantInsurancePage viewFileterOptionwithParticipantID() throws Exception
	{	
		click(eleicnFilter, "Filter");
		clearAndType(eletbParticipantID, "Participant ID", "1000000002");
		pressEnterKey(eletbParticipantID);
		verifyExactText(elelblstickyID, "1000000002");
		return this;
		
	}
	
	public ViewParticipantInsurancePage viewFileterOptionwithPolicyStatus() throws Exception
	{	
		click(eleicnFilter, "Filter");
		clearAndType(eletbParticipantID, "Participant ID", "1000000002");
		selectDropdownValue(eleddPolicyVerification, "CONFIRMED GOOD");
		pressEnterKey(eletbParticipantID);
		verifyGridResult(eleGridResult, "CONFIRMED GOOD");
		return this;
		
	}
	public ViewParticipantInsurancePage viewGridFileterOption() throws Exception
	{	
		click(eleicnFilter, "Filter");
		clearAndType(eletbParticipantID, "Participant ID", "1000000002");
		selectDropdownValue(eleddPolicyVerification, "CONFIRMED GOOD");
		pressEnterKey(eletbParticipantID);
		 click(eleicnGridOptions ,"Grid options");
		 Thread.sleep(2000);
		 click(eleGridShowColumns,"show columns");
		 verifyShowColumns(eleGridShowColumns,"Policy No","Insurance Co Name","Group No","Verification Status","Status Date","Effective Date","End Date");
		 return this;
		
	}
	
	public ViewParticipantInsurancePage viewRecordinGrid() throws Exception
	{	
		click(eleicnFilter, "Filter");
		clearAndType(eletbParticipantID, "Participant ID", "1000000002");
		selectDropdownValue(eleddPolicyVerification, "CONFIRMED GOOD");
		pressEnterKey(eletbParticipantID);
		click(eledownArrow, "Down Arrow");
		verifyDisplayed(eleUpArrow, "Up Arrow");
		verifyDisplayed(elelblheader1, "View Participant Insurance header");
		verifyDisplayed(elelblRelationshiporderedParty, "Relationship to ordered party");
		verifyDisplayed(elelblName, "Name");
		verifyDisplayed(elelblSSN, "SSN");
		verifyDisplayed(elelblDOB, "DOB");
		verifyDisplayed(elelblInsuranceCoID, "Insurance company ID");
		verifyDisplayed(elelblInsuranceCoName, "Insurance company name");
		verifyDisplayed(elelblEmployer, "Employer");
		verifyDisplayed(elelblVerificationStatus, "Verification status");
		verifyDisplayed(elelblVerificationSource, "VErification source");
		verifyDisplayed(elelblStatusDate, "Status DAte");
		verifyDisplayed(elelblMemberNumber, "Member Number");
		verifyDisplayed(elelblPolicyNo, "Policy no");
		verifyDisplayed(elelblGroupNo, "Group no");
		verifyDisplayed(elelblMonthlyCost, "Monthly cost");
		verifyDisplayed(elelblEffectiveDate, "Effective date");
		verifyDisplayed(elelblDentalCoverage, "Dental coverage");
		verifyDisplayed(elelblMedicalCoverage, "Medical Coverage");
		verifyDisplayed(elelblVisionCoverage, "Vision Coverage");
		verifyDisplayed(elelblEndDate, "End date");
		verifyDisplayed(elelblBehavioralHealthCoverage, "Behavioural health coverage");
		verifyDisplayed(elelblPrescriptionDrugCoverage, "Prescription drug coverage");
		verifyDisplayed(elelblOtherCoverage, "Other Coverage");
		verifyDisplayed(elelblOutOfStateCoverage, "Out of state Coverage");
		verifyDisplayed(elelblPrivateMedicalCoverage, "Private medical coverage");
		verifyDisplayed(elelblBehavioralHealthCoverage, "Behavioural health coverage");
		verifyDisplayed(elelblMedicaidCoverage, "Medicaid coverage");
//		verifyDisplayed(elelblParticipantName, "Participant Name");
//		verifyDisplayed(elelblPArticipantId, "Participant ID");
//		verifyDisplayed(elelblSSN1, "SSN1");
//		verifyDisplayed(elelblDOB1, "DOB 1");
//		verifyDisplayed(elelblRelationship, "RelationShip");
//		verifyDisplayed(elelblCaseID, "Case Id");
//		verifyDisplayed(elelblDentalCoverage1, "Dental coverage1 ");
//		verifyDisplayed(elelblMedicalCoverage1, "Medical coverage 1");
//		verifyDisplayed(elelblVisionCoverage1, "Vision coverage 1 ");
//		verifyDisplayed(elelblBehavioralHealthCoverage1, "Behavioural health coverage 1");
//		verifyDisplayed(elelblPrescriptionDrugCoverage1, "Prescription drug coverage 1");
//		verifyDisplayed(elelblEffectiveDate1, "Effective date 1");
//		verifyDisplayed(elelblEndDate1, "End date 1 ");
		verifyDisplayed(elelblUpdatedOn, "Updated on");
		verifyDisplayed(elelblUpdatedBy, "Updated by");
		 return this;
		
	}
	
	public AddParticipantInsurancePage AddParticipantInsurance() throws Exception
	{
		click(eleicnAdd,"Add");
		return new AddParticipantInsurancePage();
		
	}
	
	
	
}
