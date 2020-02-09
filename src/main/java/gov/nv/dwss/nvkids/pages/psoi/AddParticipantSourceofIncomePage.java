package gov.nv.dwss.nvkids.pages.psoi;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class AddParticipantSourceofIncomePage extends CommonLocators {
	public AddParticipantSourceofIncomePage()
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//label[text()='Participant ID']") WebElement elelblParticipantID;
	@FindBy(xpath = "//label[text()='Participant ID']/following-sibling::input") WebElement eleddParticipantID;
	@FindBy(xpath="//h5[@class='ng-star-inserted']") WebElement elehAddPartSourceofIncome;
	@FindBy(xpath="//legend[text()='Source Of Income Address Details']") WebElement elehSourceofIncomeAddDetails;
	@FindBy(xpath="//label[@for='otherPartyId']") WebElement elelblSourceofIncome;
	@FindBy(xpath="//label[@for='otherPartyId']/following-sibling::input") WebElement eletbSourceofIncome;
	@FindBy(xpath="(//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only'])[2]") WebElement eleIcnSourceofIncome;
	@FindBy(xpath="//label[@for='otherPartyName']") WebElement elelblName;
	@FindBy(xpath="//label[@for='attnAddr']") WebElement elelblAttn;
	@FindBy(xpath="//label[@for='line1Addr']") WebElement elelblAddressLine1;
	@FindBy(xpath="//label[@for='line2Addr']") WebElement elelblAddressLine2;
	@FindBy(xpath="//label[@for='cityName']") WebElement elelblCity;
	@FindBy(xpath="//label[@for='stateCode']") WebElement elelblState;
	@FindBy(xpath="//label[@for='postCode']") WebElement elelblzip;
	@FindBy(xpath="//label[@for='countyCode']") WebElement elelblCounty;
	@FindBy(xpath="//label[@for='countryCode']") WebElement elelblCountry;
	@FindBy(xpath="//label[@for='phoneNumb']") WebElement elelblPhone;
	@FindBy(xpath="//label[@for='faxNumb']") WebElement elelblFax;
	@FindBy(xpath="//label[@for='Email']") WebElement elelblEmail;
	@FindBy(xpath="//label[@for='seinNumb']") WebElement elelblSein;
	@FindBy(xpath="//label[@for='psoiVerificationStatusCode']") WebElement elelblVerificationStatus;
	@FindBy(xpath="//div[@class='ui-helper-hidden-accessible']/following-sibling::label") WebElement eleddVerificationStatus;
	@FindBy(xpath="(//div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[2]") WebElement eleIcnVerificationStatus;
	@FindBy(xpath="//label[@for='psoiStatusDate']") WebElement elelblStatusDate;
	@FindBy(xpath="//label[@for='psoiVerificationSourceCode']") WebElement elelblVerifiedBY;
	@FindBy(xpath="//input[@id='psoiVerificationSourceCode']/following::label") WebElement eleddVerifiedBY;
	@FindBy(xpath="//label[@for='psoiVerifiedDate']") WebElement elelblVerifiedDate;
	@FindBy(xpath="//input[@id='psoiVerifiedDate']") WebElement eledpVerifiedDate;
	@FindBy(xpath="(//div[@class='ui-helper-hidden-accessible']/following-sibling::label)[3]") WebElement eleddStatus;
	@FindBy(xpath="//input[@id='psoiClaimAccountNumb']") WebElement eletbClaimAccountNo;
	@FindBy(xpath="//input[@id='psoiBeneficiaryIdc']") WebElement eletbBenificiaryIdentificationAccNo;
	@FindBy(xpath="//input[@id='militaryNumb']") WebElement eletbMilitaryId;
	@FindBy(xpath="//label[@for='militaryNumb']") WebElement elelblMilitaryId;
	@FindBy(xpath="//label[@for='militaryBranchCode']") WebElement elelblBranchofService;
	@FindBy(xpath="//span[@class='ng-star-inserted defaultOption']") WebElement eleddBranchofServices;
	@FindBy(xpath="(//div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[7]") WebElement eleIcnBranchofServices;
	@FindBy(xpath="//label[@for='militaryBenefitTypeCode']") WebElement elelblBenifitType;
	@FindBy(xpath="//input[@id='militaryBenefitTypeCode']/following::label") WebElement eleddBenifitType;
	@FindBy(xpath="//input[@id='militaryBenefitTypeCode']/following::label/following-sibling::div") WebElement eleIcnBenifitType;
	@FindBy(xpath="//label[text()='Benefit Status']") WebElement elelblBenifitStatus;
	@FindBy(xpath="//input[@id='militaryBenefitStatusCode']/following::label") WebElement eleddBenifitStatus;
	@FindBy(xpath="//label[@for='vaServiceNumb']") WebElement elelblServiceNo;
	@FindBy(xpath="//input[@id='vaServiceNumb']") WebElement eletbServiceNo;
	@FindBy(xpath="//label[@for='dischargeDate']") WebElement elelblDischargeDate;
	@FindBy(xpath="//input[@id='dischargeDate']") WebElement eletbDischargeDate;
	@FindBy(xpath="(//span[text()='ui-btn'])[8]") WebElement eleDpDischargeDate;
	@FindBy(xpath="//input[@id='psoiOccupationDesc']") WebElement eletbOccupation;
	@FindBy(xpath="//label[@for='psoiOccupationDesc']") WebElement elelblOccupation;
	@FindBy(xpath="//input[@id='psoiTradeSkillDesc']") WebElement eletbTradeSkill;
	@FindBy(xpath="//input[@id='psoiUnionMembershipDesc']") WebElement eletbUnionMembership;
	@FindBy(xpath="//label[@for='psoiPrimaryInd']") WebElement elelblPrimary;
	@FindBy(xpath="(//label[contains(@class,'ui-dropdown-label ui-inputtext ui-corner-all ng-star-inserted')])[5]") WebElement eleddPrimary;
	@FindBy(xpath="//label[@for='psoiBeginDate']") WebElement elelblSoiBeginDate;
	@FindBy(xpath="//input[@id='psoiBeginDate']") WebElement eledpSoiBeginDate;
	@FindBy(xpath="//label[@for='psoiSourceCode']") WebElement elelblSource;
	@FindBy(xpath="//input[@id='psoiSourceCode']") WebElement eleddlSource;
	@FindBy(xpath="//span[text()='Save']") WebElement eleIcnSave;
	@FindBy(xpath="//label[text()='Income Type']") WebElement elelblIncometype;
	
	
	
	
	
	
	//Select Add page 
	@FindBy(xpath="(//div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[17]") WebElement eleIcnSourceofIncomeType;
	@FindBy(xpath="(//span[text()='Search'])[2]") WebElement eleIcnSearc;
	@FindBy(xpath="(//span[text()='Search'])[2]") WebElement eleTdVerification;
	@FindBy(xpath="//span[text()='OK']") WebElement eleIcnOk;
	@FindBy(xpath="//input[@id='psoiIncomeTypeCode']/following::label") WebElement eleddIncomeType;
	@FindBy(xpath="//label[@for='psoiScheduledShiftCode']") WebElement elelblScheduledShift;
	@FindBy(xpath="(//div[@class='ui-helper-hidden-accessible']/following-sibling::label)[11]") WebElement eleddScheduledShift;
	@FindBy(xpath="//input[@id='psoiScheduleShiftOtherDesc']") WebElement eletbUnnamed;
	
	
	
	public AddParticipantSourceofIncomePage VerifyAddPage() throws Exception
	{   
		Thread.sleep(2000);
		verifyExactText(elelblName, "Name");
		verifyExactText(elelblAttn, "ATTN");
		verifyExactText(elelblAddressLine1, "Address Line 1");
		verifyExactText(elelblAddressLine2, "Address Line 2");
		verifyExactText(elelblCity, "City");
		verifyExactText(elelblState, "State");
		verifyExactText(elelblzip, "ZIP");
		verifyExactText(elelblCounty, "County");
		verifyExactText(elelblCountry, "Country");
		verifyExactText(elelblPhone, "Phone");
		verifyExactText(elelblFax, "Fax");		
	//verifyExactText(elelblEmail, "Email");
		verifyExactText(elelblSein, "SEIN");
		verifyDisplayed(elelblVerificationStatus, "Verification status label");
		verifyDisplayed(eleddVerificationStatus, "Verification status dropdown");
		verifyDisplayed(eleIcnVerificationStatus, "Verification status icon");
		verifyExactText(elelblStatusDate, "Status Date");
		verifyExactText(elelblVerifiedBY, "Verified By");
		verifyExactText(elelblVerifiedDate, "Verified Date");
		verifyDisplayed(elelblSourceofIncome, "Source of income label");
		verifyDisplayed(eletbSourceofIncome, "Source of income");
		//verifyDisplayed(elelblSourceofIncome, eletbSourceofIncome,eleIcnSourceofIncome,"required","LOV");
	return this;
	}
	
	public AddParticipantSourceofIncomePage AddpageVerifyStatusEnabled() throws Exception
	{   
		Thread.sleep(2000);
		click(eleIcnSourceofIncome,"Source of income");
		selectDropdownValue(eleIcnSourceofIncomeType,"SOCIAL SECURITY");
		click(eleIcnSearc,"Search");
		click(eleIcnOk,"OK");
		Thread.sleep(2000);
		verifyEnabled(eleddStatus );
		return this;
		
	}
	
	public AddParticipantSourceofIncomePage AddpageVerifyClaimACNoEnabled() throws Exception
	{   
		Thread.sleep(2000);
		click(eleIcnSourceofIncome,"Source of income");
		selectDropdownValue(eleIcnSourceofIncomeType,"SOCIAL SECURITY");
		click(eleIcnSearc,"Search");
		Thread.sleep(2000);
		click(eleIcnOk,"Ok");
		Thread.sleep(2000);
		selectDropdownValue(eleddIncomeType,"SOCIAL SECURITY BENEFITS");
		Thread.sleep(2000);
		scrollToElementPosition(eletbClaimAccountNo);
		verifyEnabled(eletbClaimAccountNo );
		verifyEnabled(eletbBenificiaryIdentificationAccNo );
		
		
		return this;
		
	}
	
	public AddParticipantSourceofIncomePage AddpageVerifyMilitaryDetails() throws Exception
	{   
		Thread.sleep(2000);
		click(eleIcnSourceofIncome,"Source of income");
		selectDropdownValue(eleIcnSourceofIncomeType,"MILITARY");
		click(eleIcnSearc,"Search");
		click(eleIcnOk,"Ok");
		selectDropdownValue(eleddIncomeType,"MILITARY ACTIVE");
		Thread.sleep(2000);
		scrollToElementPosition(elelblMilitaryId);
		verifyEnabled(elelblMilitaryId );
		verifyEnabled(elelblBranchofService );
		verifyEnabled(elelblBenifitType );
		verifyEnabled(elelblBenifitStatus );
		verifyEnabled(elelblServiceNo );
		verifyEnabled(elelblDischargeDate );
		
		
		
		return this;
		
	}
	
	public AddParticipantSourceofIncomePage AddpageVerifyTradeSkillEnables() throws Exception
	{   
		Thread.sleep(2000);
		clearAndType(eletbOccupation, "Occupation label", "ENGINEER");
		pressEnterKey(eletbOccupation);
		Thread.sleep(2000);
		verifyEnabled(eletbTradeSkill);
		
		
		
		return this;
		
	}
	public AddParticipantSourceofIncomePage AddpageverifyUnionMemberShipEnables() throws Exception
	{   
		Thread.sleep(2000);
		click(eleIcnSourceofIncome,"Source of income");
		selectDropdownValue(eleIcnSourceofIncomeType,"UNION BENEFITS");
		click(eleIcnSearc,"Search");
		click(eleIcnOk,"Ok");
		Thread.sleep(2000);
		scrollToElementPosition(eletbUnionMembership);
		verifyEnabled(eletbUnionMembership );
		
		
		
		return this;
		
	}
	
	public AddParticipantSourceofIncomePage AddpageverifyScheduledShft() throws Exception
	{   
		Thread.sleep(2000);
		selectDropdownValue(eleddScheduledShift,"OTHER");
		Thread.sleep(2000);
		verifyEnabled(eletbUnnamed );
		
		
		
		return this;
		
	}
	
	
	public AddParticipantSourceofIncomePage AddpageSave() throws Exception
	{   
		Thread.sleep(2000);
		click(eleIcnSourceofIncome,"Source of income");
		selectDropdownValue(eleIcnSourceofIncomeType,"SOCIAL SECURITY");
		click(eleIcnSearc,"Search");
		Thread.sleep(2000);
		click(eleIcnOk,"Ok");
		Thread.sleep(2000);
		scrollToElementPosition(eleddVerificationStatus);
		selectDropdownValue(eleddVerificationStatus,"CONFIRMED GOOD");
		
		selectDropdownValue(eleddVerifiedBY,"AGENCY INTERFACE PARTNER");
		
		selectDropdownValue(eleddIncomeType,"SOCIAL SECURITY BENEFITS");
		clearAndType(eledpVerifiedDate, "Verified date label","01/27/2020");
		
		selectDropdownValue(eleddPrimary,"YES");
		
		clearAndType(eledpSoiBeginDate, "SOI begin date label","01/27/2020");
		clearAndType(eleddlSource, "Source label","ATY");
		pressEnterKey(eleddlSource);
		click(eleIcnSave,"Save");
	    return this;
		
	}
	

}
