package gov.nv.dwss.nvkids.pages.psoi;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class EditParticipantSourceofIncomePage extends CommonLocators{
	
	public EditParticipantSourceofIncomePage()
	{
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//label[@for='psoiVerificationStatusCode']") WebElement elelblVerificationStatus;
	@FindBy(xpath="//input[@id='psoiVerificationStatusCode']/following::label") WebElement eleddVerificationStatus;
	@FindBy(xpath="//input[@id='psoiVerificationSourceCode']/following::label") WebElement eleddVerifiedBy;
	@FindBy(xpath="//label[@for='psoiVerificationSourceCode']") WebElement elelblVerifiedBy;
	@FindBy(xpath="(//div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[3]") WebElement eleIcnVerifiedBy;
	@FindBy(xpath="//input[@id='psoiVerifiedDate']") WebElement eleddVerifiedDate;
	@FindBy(xpath="//label[@for='psoiVerifiedDate']") WebElement elelblVerifiedDate;
	@FindBy(xpath="//input[@id='psoiVerifiedDate']/following-sibling::button") WebElement eledpVerifiedDate;
	@FindBy(xpath="//label[@for='psoiOccupationDesc']") WebElement elelblOccupation;
	@FindBy(xpath="//input[@id='psoiOccupationDesc']") WebElement eletbOccupation;
	@FindBy(xpath=" //input[@id='psoiTradeSkillDesc']") WebElement eletbTradeSkill;
	@FindBy(xpath="//label[@for='psoiScheduledShiftCode']") WebElement elelblScheduledShift;
	@FindBy(xpath="//input[@id='psoiScheduledShiftCode']/following::label") WebElement eleddScheduledShift;
	@FindBy(xpath="//input[@id='psoiScheduleShiftOtherDesc']") WebElement eleUntitledField;
	@FindBy(xpath="//input[@id='psoiPrimaryInd']/following::label") WebElement eleddPrimary;
	@FindBy(xpath="//input[@id='psoiSourceCode']") WebElement eleSource;
	@FindBy(xpath="//span[text()='Save']") WebElement eleIcnSave;

	
	

	
	
	public EditParticipantSourceofIncomePage EditPageVerifyBYDateEnables() throws Exception
	{
		Thread.sleep(2000);
		selectDropdownValue(eleddVerificationStatus,"CONFIRMED GOOD");
		verifyEnabled(eleddVerifiedBy );
		verifyEnabled(eleddVerifiedDate );
		verifyDisplayed(elelblVerifiedBy, "Verified by label");
		verifyDisplayed(eleddVerifiedBy, "Verified by dropdown");
		verifyDisplayed(eleIcnVerifiedBy, "Verified by Icon");
		verifyDisplayed(elelblVerifiedDate, "Verified Date label");
		verifyDisplayed(eleddVerifiedDate, "Verified Date dropdown");
		verifyDisplayed(eledpVerifiedDate, "Verified Date Picker");
		return this;
	}
	
	public EditParticipantSourceofIncomePage EditPageVerifyBYDateEnable() throws Exception
	{
		Thread.sleep(2000);
		selectDropdownValue(eleddVerificationStatus,"CONFIRMED BAD");
		verifyEnabled(eleddVerifiedBy );
		verifyEnabled(eleddVerifiedDate );
		verifyDisplayed(elelblVerifiedBy, "Verified by label");
		verifyDisplayed(eleddVerifiedBy, "Verified by dropdown");
		verifyDisplayed(eleIcnVerifiedBy, "Verified by Icon");
		verifyDisplayed(elelblVerifiedDate, "Verified Date label");
		verifyDisplayed(eleddVerifiedDate, "Verified Date dropdown");
		verifyDisplayed(eledpVerifiedDate, "Verified Date Picker");
		
		return this;
	}
	
	public EditParticipantSourceofIncomePage EditPageVerifyTradeSkillEnable() throws Exception
	{
		Thread.sleep(2000);
		clearAndType(eletbOccupation, "Occupation label", "Engineer");
		pressEnterKey(eletbOccupation);
		Thread.sleep(2000);
		verifyEnabled(eletbTradeSkill);
		return this;
	}
	
	public EditParticipantSourceofIncomePage EditPageVerifyUnionMembershipEnable() throws Exception
	{
		Thread.sleep(2000);
		clearAndType(eletbOccupation, "Occupation label", "Engineer");
		pressEnterKey(eletbOccupation);
		Thread.sleep(2000);
		verifyEnabled(eletbTradeSkill);
		return this;
	}
	public EditParticipantSourceofIncomePage EditPageVerifyUntitledfield() throws Exception
	{
		Thread.sleep(2000);
	selectDropdownValue(eleddScheduledShift, "OTHER");
	pressEnterKey(elelblScheduledShift);
	verifyEnabled(eleUntitledField);
	
		return this;
	}
	public EditParticipantSourceofIncomePage EditPageEnterRequiredField() throws Exception
	{
		Thread.sleep(2000);
		selectDropdownValue(eleddVerificationStatus,"CONFIRMED BAD");
		selectDropdownValue(elelblVerifiedBy, "CUSTODIAN");
		Thread.sleep(2000);
		clearAndType(eleddVerifiedDate, "Verified date label", "01/23/2020");
		selectDropdownValue(eleddPrimary, "YES");
		selectDropdownValue(eleSource, "COURT ORDER");
		click(eleIcnSave,"Save");
		return this;
	}
	

	
	
	
}
