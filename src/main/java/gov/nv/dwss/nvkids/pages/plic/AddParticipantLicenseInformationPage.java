package gov.nv.dwss.nvkids.pages.plic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class AddParticipantLicenseInformationPage extends CommonLocators

{

	public AddParticipantLicenseInformationPage() {
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//span[text()='Add Participant License Information']") WebElement elesfAddParticipantLicenseInformation;
	@FindBy(xpath = "//label[@for='othpAgentId']") WebElement elelblOtherPartyID;
	@FindBy(xpath = "(//label[text()='Other Party ID']/following::input)[1]") WebElement elesfOtherPartyID;
	@FindBy(xpath = "(//span[contains(@class,'fa fa-search')])[2]") WebElement eleicnOtherPartyID;
	@FindBy(xpath = "//label[@for='licenseTypeCode']") WebElement elelblLicenseType;
	@FindBy(id = "licenseTypeCode") WebElement elesfLicenseType;
	@FindBy(xpath = "(//button[@type='button']//span)[5]") WebElement eleicnLicenseType;
	@FindBy(xpath = "//label[text()='License Description']") WebElement elelblLicenseDescription;
	@FindBy(id= "licenseDescriptionTypeDesc") WebElement elesfLicenseDescription;
	@FindBy(xpath = "//label[text()='License Number']") WebElement elelblLicenseNumber;
	@FindBy(id = "licenseIdc") WebElement elesfLicenseNumber;
	@FindBy(xpath = "//label[text()='Gaming Registration Number']") WebElement elelblGamingNumber;
	@FindBy(id = "gamingRegistrationIdc") WebElement elesfGamingNumber;
	@FindBy(xpath = "//label[text()='Permit Type']") WebElement elelblPrimaryType;
	@FindBy(xpath = "(//div[@class='ui-helper-hidden-accessible']/following-sibling::label)[1]") WebElement elesfPrimaryType;
	@FindBy(xpath = "(//span[contains(@class,'ui-dropdown-trigger-icon ui-clickable')])[2]") WebElement eleicnPrimaryType;
	@FindBy(xpath = "//label[text()='License Class']") WebElement elelblLicenseClass;
	@FindBy(xpath = "(//div[@class='ui-helper-hidden-accessible']/following-sibling::label)[2]") WebElement elesfLicenseClass;
	@FindBy(xpath = "(//div[contains(@class,'ui-dropdown-trigger ui-state-default')]//span)[3]") WebElement eleicnLicenseClass;
	@FindBy(xpath = "//label[text()='License Status']") WebElement elelblLicenseStatus;
	@FindBy(xpath = "(//div[@class='ui-helper-hidden-accessible']/following-sibling::label)[3]") WebElement elesfLicenseStatus;
	@FindBy(xpath = "(//span[contains(@class,'ui-dropdown-trigger-icon ui-clickable')])[4]") WebElement eleicnLicenseStatus;
	@FindBy(xpath = "//label[text()=' Expiration Date ']") WebElement elelblExpirationDate;
	@FindBy(id = "expirationDate") WebElement elesfExpirationDate;
	@FindBy(xpath = "(//span[contains(@class,'ui-button-icon-left ui-clickable')])[4]") WebElement eleicnExpirationDate;
	@FindBy(xpath = "//label[text()=' Renewal Date ']") WebElement elelblRenewalDate;
	@FindBy(id = "renewalDate") WebElement elesfRenewalDate;
	@FindBy(xpath = "(//button[contains(@class,'ui-datepicker-trigger ui-calendar-button')]//span)[3]") WebElement eleicnRenewalDate;
	@FindBy(xpath = "//label[@for='issuingStateCode']") WebElement elelblIssuingStateCode;
	@FindBy(id = "issuingStateCode") WebElement elesfIssuingStateCode;
	@FindBy(xpath = "(//button[contains(@class,'searchBtn ui-button-warn')]//span)[3]") WebElement eleicnIssueingDate;
	@FindBy(xpath = "//label[text()=' Suspended Date ']") WebElement elelblSuspendedDate;
	@FindBy(id = "suspensionDate") WebElement elesfSuspendedDate;
	@FindBy(xpath = "(//span[@class='ui-button-text ui-clickable'])[12]") WebElement eleicnSuspendedDate;
	@FindBy(xpath = "//label[text()=' Issue Date ']") WebElement elelblIssueDate;
	@FindBy(id = "issuingDate") WebElement elesfIssueDate;
	@FindBy(xpath = "(//button[contains(@class,'ui-datepicker-trigger ui-calendar-button')]//span)[5]") WebElement eleicnIssueDate;
	@FindBy(xpath = "//label[@for='licenseSurrenderStateCode']") WebElement elelblSurrenderedState;
	@FindBy(id = "licenseSurrenderStateCode") WebElement elesfSurrenderedState;
	@FindBy(xpath = "(//button[contains(@class,'searchBtn ui-button-warn')]//span)[5]") WebElement eleicnSurrenderedState;
	@FindBy(xpath = "//label[@for='licenseSurrenderDate']") WebElement elelblSurrenderedDate;
	@FindBy(id = "licenseSurrenderDate") WebElement elesfSurrenderedDate;
	@FindBy(xpath = "(//span[@class='ui-button-text ui-clickable'])[14]") WebElement eleicnSurrenderedDate;
	@FindBy(xpath = "(//div[@class='ui-helper-hidden-accessible']/following-sibling::label)[5]") WebElement eleddVerificationStatus;
	@FindBy(xpath = "(//span[text()='--SELECT--'])[4]") WebElement eleddVerificationSource;

	public AddParticipantLicenseInformationPage verifyAddParticipantLicenseInformation() throws Exception {
		Thread.sleep(2000);
		verifyExactText(elesfAddParticipantLicenseInformation, "Add Participant License Information");
		verifyDisplayed(eleicnClear, "Clear icon");
		verifyDisplayed(eleicnSave, "Save icon");
		verifyDisplayed(eleicnClose, "Close icon");
		verifyDisplayed(elelblOtherPartyID, "Other party Id label");
		verifyDisplayed(elesfOtherPartyID,"Other Party ID box");
		verifyDisplayed(eleicnOtherPartyID, "Other Party ID LOV icon");
		verifyDisplayed(elelblLicenseType, "license type label");
		verifyDisplayed(elesfLicenseType, "License type box");
		verifyDisplayed(eleicnLicenseType, "License Type Lov icon");
		verifyDisplayed(elelblLicenseDescription, "License description label");
		verifyDisplayed(elesfLicenseDescription, "License description text box");
		verifyDisplayed(elelblLicenseNumber, "License Number Label");
		verifyDisplayed(elesfLicenseNumber, "License Number Text box");
		verifyDisplayed(elelblGamingNumber, "Gaming Number Label");
		verifyDisplayed(elesfGamingNumber, "Gaming Number Text box");
		verifyDisplayed(elelblPrimaryType, "Primary type label");
		verifyDisplayed(elesfPrimaryType, "Primary type dropdown box");
		verifyDisplayed(eleicnPrimaryType, "Primary type Dropdown icon");
		verifyDisplayed(elelblLicenseClass, "license Class Dropdown label");
		verifyDisplayed(elesfLicenseClass, "License Class Dropdown box");
		verifyDisplayed(eleicnLicenseClass, "License Class Dropdown icon");
		verifyDisplayed(elelblLicenseStatus, "License Status Dropdown label");
		verifyDisplayed(elesfLicenseStatus, "License status Dropdown box");
		verifyDisplayed(eleicnLicenseStatus, "License status Dropdown icon");
		verifyDisplayed(elelblExpirationDate, "Expiration date Label");
		verifyDisplayed(elesfExpirationDate, "Expiration Date field");
		verifyDisplayed(eleicnExpirationDate, "Expiration Date picker icon");
		verifyDisplayed(elelblRenewalDate, "Renewal Date picker label");
		verifyDisplayed(elesfRenewalDate, "Renewal Date picker box");
		verifyDisplayed(eleicnRenewalDate, "Renewal Date picker icon");
		verifyDisplayed(elelblIssuingStateCode, "Issuing state code label");
		verifyDisplayed(elesfIssuingStateCode, "Issuing state code text box");
		verifyDisplayed(elelblIssueDate, "Issue date Label");
		verifyDisplayed(elesfIssueDate, "Issue date text box");
		verifyDisplayed(eleicnIssueDate, "Issue date date picker icon");
		verifyDisplayed(elelblSuspendedDate, "Suspended date label");
		verifyDisplayed(elesfSuspendedDate, "Suspended date Box");
		verifyDisplayed(eleicnSuspendedDate, "Suspended Date datepicker icon");
		verifyDisplayed(elelblSurrenderedState, "Surrendered state label");
		verifyDisplayed(elesfSurrenderedState, "Surrendered state text box");
		verifyDisplayed(eleicnSurrenderedState, "Surrendered state LOV icon");
		verifyDisplayed(elelblSurrenderedDate, "Surrendered date label");
		verifyDisplayed(elesfSurrenderedDate, "Surrendered date box");
		verifyDisplayed(eleicnSurrenderedDate, "Surrendered date picker icon");
		return this;
	}


	public AddParticipantLicenseInformationPage verifySaveData() throws Exception {

		Thread.sleep(2000);
		clearAndType(elesfOtherPartyID, "other Party ID", "1000000004");
		clearAndType(elesfLicenseType, "License Type", "008");
		String Licensenumber = getRandomNumbers(4);
		clearAndType(elesfLicenseNumber, "License Number", Licensenumber);
		selectDropdownValue(eleddVerificationStatus, "NO ACTION TAKEN");
		selectDropdownValue(eleddVerificationSource, "CASE WORKER");
		click(eleicnSave, "Save");
		wait.until(ExpectedConditions.visibilityOf(eleErrStatusBar));
		verifyExactText(eleErrStatusBar, "SAVED SUCCESSFULLY");
		return this;
	}






























}
