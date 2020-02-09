package gov.nv.dwss.nvkids.pages.insr;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class AddParticipantInsurancePage extends CommonLocators {
	public AddParticipantInsurancePage(){
		PageFactory.initElements(driver, this); 
	}
	@FindBy(xpath="//h5") WebElement elelblPageHeader;
	//policy holder
	@FindBy(xpath="//label[@for='orderedPartyRelationCode']") WebElement elelblRelationshiptoordpar;
	@FindBy(xpath="//label[@for='policyHolderName']") WebElement elelblName;
	@FindBy(xpath="//label[@for='policyholderSsnNumb']") WebElement elelblSSN;
	@FindBy(xpath="//label[@for='policyholderBirthDate']") WebElement elelblDOB;
	//Insurance
	@FindBy(xpath="//label[@for='insuranceOthpId']") WebElement elelblInsuranceCo;
	@FindBy(xpath="//label[@for='employerId']") WebElement elelblEmployer;
	@FindBy(xpath="//label[@for='insuranceStatusCode']") WebElement elelblVerificationStatus;
	@FindBy(xpath="//label[@for='insuranceSourceVerifiedCode']") WebElement elelblVerificationSource;
	@FindBy(xpath="//label[@for='insuranceStatusDate']") WebElement elelblStatusDate;
	@FindBy(xpath="//label[@for='memberIdc']") WebElement elelblMemberNumber;
	@FindBy(xpath="//label[@for='insurancePolicyIdc']") WebElement elelblPolicyNo;
	@FindBy(xpath="//label[@for='insuranceGroupIdc']") WebElement elelblGroupNo;
	@FindBy(xpath="//label[@for='privateMedicalCoverageInd']") WebElement elelblPrivateMedicalCoverage;
	@FindBy(xpath="//label[@for='outOfStateCoverageInd']") WebElement elelblOutofStateCoverage;
	@FindBy(xpath="//label[@for='medicaidCoverageInd']") WebElement elelblMedicaidCoverage;
	@FindBy(xpath="//label[@for='monthlyPremiumAmt']") WebElement elelblMonthlyCost;
	@FindBy(xpath="//label[@for='insuranceEffectiveDate']") WebElement elelblInsuranceEffectiveDate;
	@FindBy(xpath="//label[@for='beginValidityDttm']") WebElement elelblUpdatedOn;
	@FindBy(xpath="//label[@for='updatedByName']") WebElement elelblUpdatedBy;
	//Insurance Coverage Types
	@FindBy(xpath="//label[@for='dentalInsuranceInd']") WebElement elelblDental;
	@FindBy(xpath="//label[@for='medicalInsuranceInd']") WebElement elelblMedical;
	@FindBy(xpath="//label[@for='visionInsuranceInd']") WebElement elelblVision;
	@FindBy(xpath="//label[@for='mentalInsuranceInd']") WebElement elelblBehavioralHealth;
	@FindBy(xpath="//label[@for='prescriptionInsuranceInd']") WebElement elePrescriptionDrug;
	@FindBy(xpath="//label[text()='Other']") WebElement elelblOther;
	//After clicking arrow
	@FindBy(xpath="//i[@class='pi pi-chevron-down']") WebElement eledownArrow;
	@FindBy(xpath="//i[@class='pi pi-chevron-up']") WebElement eleUpArrow;
	@FindBy(xpath="(//label[@for='dentalInsuranceInd'])[2]") WebElement eledental1;
	@FindBy(xpath="(//label[@for='medicalInsuranceInd'])[2]") WebElement elelblMedical1;
	@FindBy(xpath="(//label[@for='visionInsuranceInd'])[2]") WebElement elelblVision1;
	@FindBy(xpath="(//label[@for='mentalInsuranceInd'])[2]") WebElement elelblBehavioralHealth1;
	@FindBy(xpath="(//label[@for='prescriptionInsuranceInd'])[2]") WebElement elePrescriptionDrug1;
	
	
	
	
	public void AddscreenlabelVerification() throws Exception
	{
		verifyDisplayed(eleicnClear, "Clear");
		verifyDisplayed(eleicnSave, "Save");
		verifyDisplayed(eleicnClose, "Close");
		verifyDisplayed(elelblPageHeader, "Add Participant Insurance");
		verifyDisplayed(elelblRelationshiptoordpar, "Relationship to ordered Party");
		verifyDisplayed(elelblName, "Name");
		verifyDisplayed(elelblSSN, "SSN");
		verifyDisplayed(elelblDOB, "DOB");
		verifyDisplayed(elelblInsuranceCo, "Insurance company");
		verifyDisplayed(elelblEmployer, "Employer");
		verifyDisplayed(elelblVerificationStatus, "Verification Status");
		verifyDisplayed(elelblVerificationSource, "Verification Source");
		verifyDisplayed(elelblStatusDate, "Status Date");
		verifyDisplayed(elelblMemberNumber, "Member Number");
		verifyDisplayed(elelblPolicyNo, "Policy no");
		verifyDisplayed(elelblGroupNo, "Group no");
		verifyDisplayed(elelblPrivateMedicalCoverage, "Private medical coverage");
		verifyDisplayed(elelblOutofStateCoverage, "Out Of state Coverage");
		verifyDisplayed(elelblMedicaidCoverage, "Medicaid Coverage");
		verifyDisplayed(elelblMonthlyCost, "Monthly cost");
		verifyDisplayed(elelblInsuranceEffectiveDate, "Insurance Effective date");
		verifyDisplayed(elelblUpdatedOn, "Updated on");
		verifyDisplayed(elelblUpdatedBy, "Updated By");
		verifyDisplayed(elelblDental, "Dental");
		verifyDisplayed(elelblMedical, "Medical");
		verifyDisplayed(elelblVision, "Vision");
		verifyDisplayed(elelblBehavioralHealth, "Behavioural health");
		verifyDisplayed(elePrescriptionDrug, "Prescription Drug");
		verifyDisplayed(elelblOther, "Other");
		click(eledownArrow, "Down Arrow");
		verifyDisplayed(eleUpArrow, "Up Arrow");
		verifyDisplayed(eledental1, "Dental1");
		verifyDisplayed(elelblMedical1, "Medical1 ");
		verifyDisplayed(elelblVision, "Vision1");
		verifyDisplayed(elelblBehavioralHealth, "Behavioural health1");
		verifyDisplayed(elePrescriptionDrug, "Prescription Drug1");
	}

}
