package gov.nv.dwss.nvkids.pages.plic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class EditParticipantLicenseInformationPage extends CommonLocators

{

	public EditParticipantLicenseInformationPage() {
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//span[text()='Edit Participant License Information']") WebElement elesfEditParticipantLicenseInformation;
	@FindBy(xpath = "//label[@for='othpAgentId']") WebElement elelblOtherPartyID;
	@FindBy(xpath = "(//label[text()='Other Party ID']/following::input)[1]") WebElement elesfOtherPartyID;
	@FindBy(xpath = "(//span[contains(@class,'fa fa-search')])[2]") WebElement eleicnOtherPartyID;
	@FindBy(xpath="//label[text()=' Licensing Agency ']") WebElement elelblLicensingAgency;
	@FindBy(xpath="//label[text()=' Address ']") WebElement elelblAddressofAgency;
	@FindBy(xpath="//label[text()=' Phone ']") WebElement elelblPhoneNo;
	@FindBy(xpath="//label[text()=' Fax ']") WebElement elelblFax;
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
	@FindBy(xpath = "(//span[contains(@class,'ui-button-icon-left ui-clickable')])[3]") WebElement eleicnExpirationDate;
	@FindBy(xpath = "//label[text()=' Renewal Date ']") WebElement elelblRenewalDate;
	@FindBy(id = "renewalDate") WebElement elesfRenewalDate;
	@FindBy(xpath = "(//button[contains(@class,'ui-datepicker-trigger ui-calendar-button')]//span)[4]") WebElement eleicnRenewalDate;
	@FindBy(xpath = "//label[@for='issuingStateCode']") WebElement elelblIssuingStateCode;
	@FindBy(id = "issuingStateCode") WebElement elesfIssuingStateCode;
	@FindBy(xpath = "(//button[contains(@class,'searchBtn ui-button-warn')]//span)[3]") WebElement eleicnIssueingState;
	@FindBy(xpath = "//label[text()=' Suspended Date ']") WebElement elelblSuspendedDate;
	@FindBy(id = "suspensionDate") WebElement elesfSuspendedDate;
	@FindBy(xpath = "(//button[contains(@class,'searchBtn ui-button-warn')]//span)[4]") WebElement eleicnSuspendedDate;
	@FindBy(xpath = "//label[text()=' Issue Date ']") WebElement elelblIssueDate;
	@FindBy(id = "issuingDate") WebElement elesfIssueDate;
	@FindBy(xpath = "(//button[contains(@class,'ui-datepicker-trigger ui-calendar-button')]//span)[5]") WebElement eleicnIssueDate;
	@FindBy(xpath = "//label[@for='licenseSurrenderStateCode']") WebElement elelblSurrenderedState;
	@FindBy(id = "licenseSurrenderStateCode") WebElement elesfSurrenderedState;
	@FindBy(xpath = "(//button[contains(@class,'searchBtn ui-button-warn')]//span)[3]") WebElement eleicnSurrenderedState;
	@FindBy(xpath = "//label[@for='licenseSurrenderDate']") WebElement elelblSurrenderedDate;
	@FindBy(id = "licenseSurrenderDate") WebElement elesfSurrenderedDate;
	@FindBy(xpath = "(//span[@class='ui-button-text ui-clickable'])[14]") WebElement eleicnSurrenderedDate;
	@FindBy(xpath = "(//div[@class='ui-helper-hidden-accessible']/following-sibling::label)[5]") WebElement eleddVerificationStatus;
	@FindBy(xpath = "(//label[contains(@class,'ui-dropdown-label')])[6]") WebElement eleddVerificationSource;

	public EditParticipantLicenseInformationPage verifyEditParticipantLicenseInformation() throws Exception {

		Thread.sleep(2000);
		verifyExactText(elesfEditParticipantLicenseInformation, "Edit Participant License Information");
		verifyDisplayed(eleicnRefresh, "Refrech icon");
		verifyDisplayed(eleicnSave, "Save icon");
		verifyDisplayed(eleicnClose, "Close icon");
		verifyDisplayed(elelblOtherPartyID, "other party ID label");
		verifyDisplayed(elesfOtherPartyID, "other party ID text box");
		verifyDisplayed(eleicnOtherPartyID, "Other Party ID LOV icon");
		verifyExactText(elelblLicensingAgency, "Licensing Agency");
		verifyExactText(elelblAddressofAgency, "Address");
		verifyExactText(elelblPhoneNo, "Phone");
		verifyExactText(elelblFax, "Fax");
		verifyDisplayed(elelblLicenseType, "license type label");
		verifyDisplayed(elesfLicenseType, "license type text box");
		verifyDisplayed(elelblLicenseDescription, "License description label");
		verifyDisplayed(elesfLicenseDescription, "license Description Text box");
		verifyDisplayed(elelblLicenseNumber, "License Number");
		verifyDisplayed(elesfLicenseNumber, "License Number Text box");
		verifyDisplayed(elelblGamingNumber, "Gaming number label");
		verifyDisplayed(elesfGamingNumber, "GamingNumber Text Box");
		verifyDisplayed(elelblPrimaryType, "Primary type label ");
		verifyDisplayed(elesfPrimaryType, "Primary type dropdown icon");
		verifyDisplayed(elelblLicenseClass, "License Class label");
		verifyDisplayed(elesfLicenseClass, "License Class Dropdown box");
		verifyDisplayed(eleicnLicenseClass, "License Class Dropdown icon");
		verifyDisplayed(elelblLicenseStatus, "License Statsus label");
		verifyDisplayed(elesfLicenseStatus, "License status Dropdown box");
		verifyDisplayed(eleicnLicenseStatus, "License status Dropdown icon");
		verifyDisplayed(elelblExpirationDate, "Expiration date label");
		verifyDisplayed(elesfExpirationDate, "Expiration Date field");
		verifyDisplayed(eleicnExpirationDate,"Expiration Date picker icon");
		verifyDisplayed(elelblRenewalDate, "Renewal Date label");
		verifyDisplayed(elesfRenewalDate, "Renewal Date picker box");
		verifyDisplayed(eleicnRenewalDate, "Renewal Date picker icon");
		verifyDisplayed(elelblIssuingStateCode, "Issue state label");
		verifyDisplayed(elesfIssuingStateCode, "Issuing state code text box");
		verifyDisplayed(eleicnIssueingState, "Issuing state code icon");
		verifyDisplayed(elelblIssueDate, "Issue date label");
		verifyDisplayed(elesfIssueDate, "Issue date text box");
		verifyDisplayed(eleicnIssueDate, "Issue date date picker icon");
		scrollToElementPosition(eleicnIssueDate);
		verifyDisplayed(elelblSuspendedDate, "Suspended date label");
		verifyDisplayed(elesfSuspendedDate,"Suspended date Box");
		verifyDisplayed(eleicnSuspendedDate, "Suspended Date datepicker icon");
		verifyDisplayed(elelblSurrenderedState, "Surrendered state label");
		verifyDisplayed(elesfSurrenderedState, "Surrendered state text box");
		verifyDisplayed(eleicnSurrenderedState, "Surrendered state LOV icon");
		verifyDisplayed(elelblSurrenderedDate, "Surrendered date label");
		verifyDisplayed(elesfSurrenderedDate, "Surrendered date box");
		verifyDisplayed(eleicnSurrenderedDate, "Surrendered date picker icon");
		return this;
	}

	public String setPastDate(WebElement ele,int days) 
	{
		String pastDate="";
		try 
		{
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date currentDate = new Date();
			Calendar c = Calendar.getInstance(); /* convert date to calendar */
			c.setTime(currentDate);
			c.add(Calendar.DATE, -days);
			pastDate = dateFormat.format(c.getTime());
			pastDate=pastDate.replace("/", "");
			ele.clear();
			ele.sendKeys(pastDate);

			reportStep("Past date " +pastDate+ " successfully entered in the field", "pass");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			reportStep("Unable to set the date", "fail");

			Assert.fail("Unable to set the date");
		}
		finally 
		{
			takeSnap();

		}
		return pastDate;
	}
	public EditParticipantLicenseInformationPage verifySaveParticipantLicenseInformation() throws Exception {

		Thread.sleep(2000);
		clearAndType(elesfLicenseDescription, "License Description", "LicenseAgencyChanged");
		clearAndType(elesfGamingNumber, "gaminig Number", "986372");
		selectDropdownValue(elesfPrimaryType, "APPLICATION");
		selectDropdownValue(elesfLicenseClass, "CLASS A");
		selectDropdownValue(elesfLicenseStatus, "ACTIVE");
		Thread.sleep(3000);
		setFutureDate(elesfExpirationDate, 5);
		setPastDate(elesfIssueDate, 5);
		setPastDate(elesfRenewalDate, 4);
		setPastDate(elesfSuspendedDate, 3);
		setPastDate(elesfSurrenderedDate, 12);
		clearAndType(elesfSurrenderedState, "Surrendered State", "AR");
		clearAndType(elesfIssuingStateCode, "issuing State code", "AP");
		selectDropdownValue(eleddVerificationStatus, "CONFIRMED GOOD");
		selectDropdownValue(eleddVerificationSource, "DEPARTMENT OF WILD LIFE");
		click(eleicnSave,"Save");
		verifyExactText(eleErrStatusBar, "SAVED SUCCESSFULLY");
		return this;
	}





}
