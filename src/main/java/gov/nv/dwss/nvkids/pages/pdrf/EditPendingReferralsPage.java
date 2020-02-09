package gov.nv.dwss.nvkids.pages.pdrf;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class EditPendingReferralsPage extends CommonLocators 
{
	public EditPendingReferralsPage() 
	{
		PageFactory.initElements(driver, this);
	}	



	@FindBy(xpath="//label[text()=' Referral Date ']") WebElement eletxtReferalDate;
	@FindBy(xpath="//label[text()=' Program Case ID ']") WebElement eletxtProgramCaseID;
	@FindBy(xpath="//label[text()=' IV-D Office ']") WebElement eletxtIVDoffice;
	@FindBy(xpath="(//label[text()=' Program Type '])[1]") WebElement eletxtProgramType;

	@FindBy(xpath="(//label[text()=' Program Member ID '])[1]") WebElement eletxtProgramMemberID;
	@FindBy(xpath="(//label[text()=' Good Cause '])[1]") WebElement eletxtGoodCause;
	@FindBy(xpath="//label[text()=' Reason ']") WebElement eletxtReason;
	@FindBy(xpath="//label[text()=' Status ']") WebElement eletxtStatus;

	@FindBy(xpath="//label[@class='ng-star-inserted']") WebElement eletxtSetReferralStatus;
	@FindBy(xpath="//label[text()='Reject']") WebElement eletxtReject;
	@FindBy(xpath="(//div[contains(@class,'ui-radiobutton-box ui-widget')])[1]") WebElement eleicnReject;
	@FindBy(xpath ="(//span[@class='ui-radiobutton-icon ui-clickable'])[1]") WebElement eleclickReject;
	@FindBy(xpath="//label[text()='Decline']") WebElement eletxtDecline;
	@FindBy(xpath="(//div[contains(@class,'ui-radiobutton-box ui-widget')])[2]") WebElement eleicnDecline;

	@FindBy(xpath="//span[text()=' Case Details ']") WebElement eletxtCaseDetails;
	@FindBy(xpath="//span[text()=' Case Participant Details ']") WebElement eletxtCaseParticipantDetails;
	@FindBy(xpath="//span[text()=' Participant Additional Details ']") WebElement eletxtParticipantAdditionalDetails;
	@FindBy(xpath="//label[text()='Link Referral']") WebElement eletxtLinkReferral;
	@FindBy(xpath="(//div[contains(@class,'ui-radiobutton-box ui-widget')])[3]") WebElement eleicnLinkReferral;
	@FindBy(xpath="//label[text()='Link Referral and Update']") WebElement eletxtLinkUpdate;
	@FindBy(xpath="(//div[contains(@class,'ui-radiobutton-box ui-widget')])[4]") WebElement eleicnLinkUpdate;

	@FindBy(xpath="//label[@for='referralReasonCode']") WebElement eletxtRejectReason;
	@FindBy(xpath="//div[@class='ui-helper-hidden-accessible']/following-sibling::label[1]") WebElement eleddRejectReason;
	@FindBy(xpath="//label[text()=' Updated By ']") WebElement eletxtUpdatedBy;
	@FindBy(xpath="//label[text()=' Updated On ']") WebElement eletxtUpdatedOn;

	@FindBy(xpath="(//span[text()='Create Case'])[2]") WebElement elebtCreateCase;
	@FindBy(xpath = "(//div[@class='ui-helper-hidden-accessible']/following-sibling::label)[1]") WebElement eleddProgramType;
	@FindBy(xpath="//tbody[@class='ui-table-tbody']/tr/td/span") WebElement elegdRecord;

	@FindBy(xpath="(//label[@class='fieldLabel'])[2]") WebElement eletxtDeclineReason;
	@FindBy(xpath="//div[@class='ui-helper-hidden-accessible']/following-sibling::label[1]") WebElement eleDeclineReason;
	@FindBy(xpath="//label[@for='caseId']") WebElement elelblEnterCaseID;
	@FindBy(xpath="(//label[text()='Enter Case ID']/following::input)[1]") WebElement eleEnterCaseID;
	@FindBy(xpath="(//span[@class='ui-accordion-toggle-icon nv-chevron-up'])[2]") WebElement elePointerDown;
	@FindBy(xpath="(//a[@role='tab'])[1]") WebElement elebgcolorCaseDetails;
	@FindBy(xpath="(//label[text()=' Program Type '])[2]") WebElement elegdtxtProgramType;
	@FindBy(xpath="//label[text()=' Referral Office ']") WebElement elegdtxtReferralOffice;
	@FindBy(xpath="(//label[text()=' Good Cause '])[2]") WebElement elegdtxtGoodCause;
	@FindBy(xpath="//label[text()=' Good Cause Claim Date ']") WebElement elegdtxtGoodCauseClaimDate;
	@FindBy(xpath="//label[text()=' Conflict Indicator ']") WebElement elegdtxtConflictIndicator;
	@FindBy(xpath="//label[text()=' Confidential Indicator ']") WebElement elegdtxtConfidentialIndicator;
	@FindBy(xpath ="//label[text()=' DCFS Worker Name ']") WebElement eletxtDCFSWorkerName;
	@FindBy(xpath ="//label[text()=' DCFS Office Phone ']") WebElement eletxtDCFSOfficePhone;
	@FindBy(xpath ="//label[text()=' Support Order Eff date ']") WebElement eletxtSupportOrderEffdate;
	@FindBy(xpath="(//a[@role='tab'])[2]") WebElement elebgcolorCaseParticipantDetails;
	@FindBy(xpath ="//td//div[@class='ui-chkbox ui-widget']//div/input")List <WebElement> eleicnSel;
	@FindBy(xpath ="//tr/td//span[text()='Participant Search']")WebElement eleicnParticipantSearch;
	@FindBy(xpath= "//span[text()=' CUSTODIAL PARENT ']/following::span[text()='Participant Search']") WebElement eleicnParticipantSearchforCustodialparent;
	@FindBy(xpath= "//span[text()=' CHILD ']/following::span[text()='Participant Search']") WebElement eleicnParticipantSearchforChild;
	@FindBy(xpath="//span[text()='Participant Search']") WebElement elepopupParticipantSearch;
	@FindBy(xpath="(//span[contains(@class,'fa fa-search')])[2]") WebElement eleicnEnterCaseID;
	@FindBy(xpath="//span[text()='Select Case']") WebElement elepopSelectCase;



	//Personal Information
	@FindBy(xpath ="(//label[text()=' SSN '])[2]") WebElement eletxtSSN;
	@FindBy(xpath ="//label[text()=' SSN Status ']") WebElement eletxtSSNStatus;
	@FindBy(xpath ="//label[text()=' SSN Verification Source ']") WebElement eletxtSSNVerificationStatus;
	@FindBy(xpath ="//label[text()=' Hair Color ']") WebElement eletxtHairColor;
	@FindBy(xpath ="//label[text()=' Eyes Color ']") WebElement eletxtEyeColor;
	@FindBy(xpath ="//label[text()=' Disability Status ']") WebElement eletxtDisabilityStatus;
	@FindBy(xpath ="//label[text()=' Height ']") WebElement eletxtHeight;
	@FindBy(xpath ="//label[text()=' Weight ']") WebElement eletxtWeight;
	@FindBy(xpath ="//label[text()=' Primary Language ']") WebElement eletxtPrimaryLanguage;
	@FindBy(xpath ="//label[text()=' Birth Place ']") WebElement eletxtBirthPlace;
	@FindBy(xpath ="//label[text()=' Birth State ']") WebElement eletxtBirthState;
	@FindBy(xpath ="//label[text()=' Birth Country ']") WebElement eletxtBirthCountry;
	@FindBy(xpath ="//label[text()=' Death Date ']") WebElement eletxtDeathDate;
	//Participant Referral Information
	@FindBy(xpath ="//label[text()=' IV-D Case ID ']") WebElement eletxtIVDCaseID;
	@FindBy(xpath ="//label[text()=' IV-D Participant ID ']") WebElement eletxtIVDParticipantID;
	//@FindBy(xpath ="(//label[text()=' Program Member ID '])[3]") WebElement eletxtProgramMemberID;
	//@FindBy(xpath ="(//label[text()=' Program Case ID '])[2]") WebElement eletxtProgramCaseID;
	@FindBy(xpath ="//label[text()=' Approval Date ']") WebElement eletxtApprovalDate;
	//@FindBy(xpath ="(//label[text()=' Program Type '])[3]") WebElement eletxtProgramType;
	@FindBy(xpath ="//label[text()=' Participation Start Date ']") WebElement eletxtStartDate;
	@FindBy(xpath ="//label[text()=' Participation End Date ']") WebElement eletxtEndDate;
	@FindBy(xpath ="//label[text()=' NCP Left Date ']") WebElement eletxtNCPLeftDate;

	//Address Information
	@FindBy(xpath ="//label[text()=' Address Type ']") WebElement eletxtAddressType;
	@FindBy(xpath ="//label[text()=' ATTN/Care of ']") WebElement eletxtATTN;
	@FindBy(xpath ="(//label[text()=' Address '])[1]") WebElement eletxtAddress;
	//Contact Information
	@FindBy(xpath ="//label[text()=' Home Phone ']") WebElement eletxtHomePhone;
	@FindBy(xpath ="//label[text()=' Email ID ']") WebElement eletxtEmailID;
	@FindBy(xpath ="//label[text()=' Work Phone ']") WebElement eletxtWorkPhone;
	@FindBy(xpath ="//label[text()=' Cell Phone ']") WebElement eletxtCellPhone;
	@FindBy(xpath ="//label[text()=' Fax ']") WebElement eletxtFax;
	@FindBy(xpath ="//label[text()=' Message Phone ']") WebElement eletxtMessagePhone;
	//Marital Information
	@FindBy(xpath ="//label[text()=' NCP Marital Status ']") WebElement eletxtNCPMaritalStatus;
	@FindBy(xpath ="//label[text()=' NCP Currently Married? ']") WebElement eletxtNCPCurrentlyMarried;
	@FindBy(xpath ="//label[text()=' NCP Ever Married To The CST ']") WebElement eletxtNCPEverMarried;
	@FindBy(xpath ="//label[text()=' NCP Ever Divorced From The CST ']") WebElement eletxtNCPEverDivorced;
	@FindBy(xpath ="//label[text()=' Multiple Paternity Cases Exist For The CST? ']") WebElement eletxtPaternityCases;
	@FindBy(xpath ="//label[text()=' NCP Date Of Marriage To CST ']") WebElement eletxtDateOfMarriage;
	@FindBy(xpath ="//label[text()=' NCP Divorce Date From The CST ']") WebElement eletxtDivorceDate;
	@FindBy(xpath ="//label[text()=' NCP And CST Separated Date ']") WebElement eletxtSeperateDate;
	@FindBy(xpath ="//label[text()=' CST Marital Status ']") WebElement eletxtCSTMaritalStatus;
	@FindBy(xpath ="//label[text()=' CST Currently Married? ']") WebElement eletxtCSTCurrentlyMarried;
	//Paternity Information
	@FindBy(xpath ="//label[text()=' NCP Relationship To Child ']") WebElement eletxtNCPRelationship;
	@FindBy(xpath ="//label[text()=' CST Relationship To Child ']") WebElement eletxtCSTRelationship;
	@FindBy(xpath ="//label[text()=' Paternity Established Indicator ']") WebElement eletxtPaternityIndicator;
	@FindBy(xpath ="//label[text()=' Paternity Established Date ']") WebElement eletxtPaternityDate;
	@FindBy(xpath ="//label[text()=' Custody Date ']") WebElement eletxtCustodyDate;
	@FindBy(xpath ="//label[text()=' Paternity Affidavit Court Ordered ']") WebElement eletxtPaternityOrder;
	@FindBy(xpath ="//label[text()=' NCP Name On Birth Certificate ']") WebElement eletxtNCPBirthCertificate;
	@FindBy(xpath ="//label[text()=' Born Out Of Wedlock ']") WebElement eletxtWedlock;

	//Participant Additional Information
	@FindBy(xpath="//div[@class='p-grid HeaderHighlight']//label[1]") WebElement eleHistoryNavigation;

	@FindBy(xpath="//label[text()=' Member Name ']") WebElement eletxtMemberName;
	@FindBy(xpath="(//label[text()=' Program Member ID '])[4]") WebElement eletxtMemberID;
	@FindBy(xpath="//label[text()=' Employer ']") WebElement eletxtEmployer;
	@FindBy(xpath="(//label[text()=' Address '])[2]") WebElement eletxtaddpAddress;
	@FindBy(xpath="//label[text()=' FEIN ']") WebElement eletxtFEIN;

	@FindBy(xpath="//label[text()=' Employer Phone ']") WebElement eletxtEmployerPhone;
	@FindBy(xpath="//label[text()=' Insurance Number ']") WebElement eletxtInsuranceNumber;
	@FindBy(xpath="//label[text()=' Carrier ']") WebElement eletxtCarrier;
	@FindBy(xpath="//label[text()=' Insurance Type ']") WebElement eletxtInsuranceType;
	@FindBy(xpath="//label[text()=' Policy Holder Name ']") WebElement eletxtPolicyHolderName;
	
	@FindBy(xpath="//td/span[text()=' CUSTODIAL PARENT ']") WebElement eletxtCustodialparent;
	@FindBy(xpath ="//div[@class='search-btn-container ng-star-inserted']//p-button[1]") WebElement eletxtCreateNewParticipantID;
	@FindBy(xpath ="//span[text()='Link to Case']") WebElement elelinkToCase;
	@FindBy(xpath ="//span[text()='Complete Participant Clearance']") WebElement elecompleteclearance;
	@FindBy(xpath ="//span[text()=' NEW ']/preceding::div[@class='ui-chkbox-box ui-widget ui-state-default ui-state-active']") WebElement eleCheckboxstatusNEW;
	@FindBy(xpath ="//span[not(text()=' NEW ')]/preceding::div[@class='ui-chkbox-box ui-widget ui-state-default ui-state-active']") WebElement eleCheckboxstatusExisting;
	@FindBy(xpath="(//a[@role='tab'])[3]") WebElement elebgcolorParticipantAdditionalDetails;
	@FindBy(xpath = "(//div[@class='ui-helper-hidden-accessible']/following-sibling::label)[2]") WebElement eleddStatus;
	@FindBy(xpath = "//label[text()=' Program Member ID ']/following-sibling::span") WebElement eleProgramMemberID;
	@FindBy(xpath="//tbody[@class='ui-table-tbody']/tr/td[2]/span") WebElement eleGridValue;
	@FindBy(xpath ="//span[normalize-space(text())='CHILD']/following::span[text()='Participant Search']") WebElement eleParticipantSearchforChild;
	@FindBy(xpath ="//td/span") WebElement elegdSelectcasepopup;
	@FindBy(xpath ="//span[text()='OK']") WebElement eleOK;
	@FindBy(xpath ="//label[normalize-space(text())='Status']/following::span[normalize-space(text())='HISTORY']") WebElement eleHistoryStatus;
	@FindBy(xpath="(//span[text()='Create Case'])[2]") WebElement eleCreateCase;
	@FindBy(xpath ="(//span[text()='Create Case'])[3]") WebElement eleCreateCasepopup;
	@FindBy(xpath ="//span[text()=' Applicant Basic Information ']/preceding-sibling::span[@class='ui-accordion-toggle-icon nv-angle-down']") WebElement eleicnDownPointer;
	@FindBy(xpath ="//span[text()='1']/parent::a[@class='ui-menuitem-link ng-star-inserted ui-state-active']") WebElement eleicnApplicant;
	@FindBy(xpath="//span[text()='Confirmation']/following::*[text()='Yes']") WebElement eleconfirmationYes;
	@FindBy(xpath="//span[text()='View Applications']") WebElement eleViewApplications;
	@FindBy(xpath="//label[normalize-space(text())='Application ID']/following-sibling::span") WebElement eleApplicantID;

	public EditPendingReferralsPage verifyEditPendingReferralsFields() throws Exception
	{
		Thread.sleep(2000);
		verifyExactText(eletxtReferalDate, "Referral Date");
		verifyDisplayed(eletxtReject, "Reject");
		verifyDisplayed(eleicnReject, "Reject Radio button" );
		verifyDisplayed(eletxtDecline, "Decline");
		verifyDisplayed(eleicnDecline, "Decline Radio Button");
		verifyDisplayed(eleicnRefresh, "Refresh");
		verifyDisplayed(eleicnClose, "Close");
		verifyDisplayed(eleicnSave, "Save");
		verifyDisplayed(eletxtLinkReferral, "Link Referral");
		verifyDisplayed(eleicnLinkReferral, "Link Referral Radio Button");
		verifyDisplayed(eletxtLinkUpdate, "LinkUpdate");
		verifyDisplayed(eleicnLinkUpdate, "Link Update Radio Button");
		verifyDisplayed(eletxtUpdatedBy, "Updated By");
		verifyDisplayed(eletxtUpdatedOn, "Updated On");
		verifyDisplayed(elebtCreateCase, "Button Create Case");
		verifyExactText(eletxtCaseDetails, "Case Details");	
		verifyExactText(eletxtCaseParticipantDetails, "Case Participant Details");
		verifyExactText(eletxtParticipantAdditionalDetails, "Participant Additional Details");
		verifyAssociatedScreens(eleAssociatedScreenList, "Create and Maintain Case", "Document Processor", "Participant Program History", "Other Party Information");
		return this;

	}


	public EditPendingReferralsPage verifyRejectButton() throws InterruptedException {

		verifyEnabled(eleicnReject);
		Thread.sleep(3000);
		verifyDisabled(eleicnRefresh);
		verifyDisabled(eleicnSave);
		return this;
	}

	public EditPendingReferralsPage verifyRejectResonDisplayed() throws Exception {

		click(eleicnReject, "Reject");
		verifyDisplayed(eletxtRejectReason, "RejectReason");
		verifyDisplayed(eleddRejectReason, "Reject Reason Dropdown");
		return this;
	}


	public EditPendingReferralsPage verifyDeclineButton() throws Exception {

		click(eleicnDecline, "Decline");
		verifyDisplayed(eletxtDeclineReason, "Decline Reason");
		verifyDisplayed(eleDeclineReason, "Decline reason");
		return this;
	}

	public EditPendingReferralsPage verifyLinkReferralButton() throws Exception {

		click(eleicnLinkReferral, "Link Referral");
		verifyDisplayed(elelblEnterCaseID, "Enter Case ID ");
		verifyDisplayed(eleEnterCaseID, "Enter Case ID");

		return this;

	}

	public EditPendingReferralsPage verifyLinkUpdateReferralButton() throws Exception {

		click(eleicnLinkUpdate, "Link update");
		verifyDisplayed(elelblEnterCaseID, "Enter Case ID ");
		verifyDisplayed(eleEnterCaseID, "Enter Case ID");
		return this;

	}

	public EditPendingReferralsPage verifyEnterCaseID() throws Exception {

		click(eleicnLinkUpdate, "link update Radio button");
		click(eleicnEnterCaseID, "Enter Case Id Lov icon");
		verifyExactText(elepopSelectCase, "Select Case");
		return this;

	}

	public EditPendingReferralsPage verifyCaseDetails() throws Exception {


		Thread.sleep(2000);
		click(elebgcolorCaseDetails, "Case Details");
		verifyExactText(elegdtxtProgramType, "Program Type");
		verifyExactText(elegdtxtReferralOffice, "Referral Office");
		verifyExactText(elegdtxtGoodCause, "Good Cause");
		verifyExactText(elegdtxtGoodCauseClaimDate, "Good Cause Claim Date");
		verifyExactText(elegdtxtConflictIndicator, "Conflict Indicator");
		verifyExactText(elegdtxtConfidentialIndicator, "Confidential Indicator");
		return this;

	}

	public EditPendingReferralsPage verifyFosterCareDetails() throws Exception {



		Thread.sleep(2000);
		click(elebgcolorCaseDetails, "Case Details");
		verifyExactText(elegdtxtProgramType, "Program Type");
		verifyExactText(elegdtxtReferralOffice, "Referral Office");
		verifyExactText(eletxtDCFSWorkerName, "DCFS Worker Name");
		verifyExactText(eletxtSupportOrderEffdate, "Support Order Eff date");
		verifyExactText(elegdtxtConflictIndicator, "Conflict Indicator");
		verifyExactText(elegdtxtConfidentialIndicator, "Confidential Indicator");
		return this;

	}


	public EditPendingReferralsPage verifyEditCaseParticipantDetails() throws Exception {

		Thread.sleep(2000);
		//click(elePointerDown, "Down pointer");
		click(elebgcolorCaseParticipantDetails, "Case Participant Details");
		verifyGridHeaders(elelblGridHeaders, "Sel", "Participant ID", "Name", "Case Relationship", "Program Member ID", "SSN", "Date Of Birth", "Race", "Gender", "Untitled");
		return this;

	}

	public EditPendingReferralsPage verifyEditCaseParticipantInfo() throws Exception {

		Thread.sleep(2000);
		click(elebgcolorCaseParticipantDetails, "Case Participant Details");
		Thread.sleep(2000);
//		click(eleicnParticipantSearch, "Participant Search");
//		verifyExactText(elepopupParticipantSearch, "Participant Search");
		
		return this;
	}

//no data
	public EditPendingReferralsPage verifyParticipantSearchforCustodialParentLinkReferral() throws Exception {
		

		click(eleicnLinkReferral, "Link Referral Radio button");
		click(eleicnParticipantSearchforCustodialparent, "Participant Search");
		verifyDisabled(eletxtCreateNewParticipantID);
		verifyEnabled(elelinkToCase);
		return this;
	}

	public EditPendingReferralsPage verifyParticipantSearchforCustodialParentlinkupdate() throws Exception {
		

		click(eleicnLinkUpdate, "Link update Radio button");
//		click(eleicnParticipantSearchforCustodialparent, "Participant Search");
//		verifyDisabled(eletxtCreateNewParticipantID);
//		verifyEnabled(elelinkToCase);
		return this;
	}

	public EditPendingReferralsPage verifyParticipantSearchforChild() throws Exception {

		click(eleicnLinkUpdate, "Link update Radio button");
//		click(eleicnParticipantSearchforChild, "Participant Search");
//		verifyDisplayed(eletxtCreateNewParticipantID," Create new ParticipantID");
//		verifyEnabled(eletxtCreateNewParticipantID);
//		verifyEnabled(elelinkToCase);
		return this;
	}
	public EditPendingReferralsPage verifyParticipantSearchforChildCreateNewparticipant() throws Exception {

		click(eleicnParticipantSearchforChild, "Participant Search");
//		click(eletxtCreateNewParticipantID," Create new ParticipantID");
//		click(elecompleteclearance, "Complete Clearance");
//		verifyDisplayed(eleCheckboxstatusNEW, "Checkbox Status enabled");
		return this;
	}

	public EditPendingReferralsPage verifyParticipantSearchforChildExistingparticipant() throws Exception {

//		click(eleicnParticipantSearchforChild, "Participant Search");
//		click(elelinkToCase,"Link to Case");
//		click(elecompleteclearance, "Complete Clearance");
//		verifyDisplayed(eleCheckboxstatusExisting, "Checkbox Status enabled");
		return this;
	}

	public EditPendingReferralsPage verifyCaseParticipantDeatilsPanel() throws Exception {

		click(eletxtCaseParticipantDetails, "Case Participant Details");
		click(elePointerDown,"Down pointer");
		verifyExactText(eletxtSSN, "SSN");
		verifyExactText(eletxtSSNStatus, "SSN Status");
		verifyExactText(eletxtSSNVerificationStatus, "SSN Verification Source");
		verifyExactText(eletxtHairColor, "Hair Color");
		verifyExactText(eletxtEyeColor, "Eyes Color");
		verifyExactText(eletxtDisabilityStatus, "Disability Status");
		verifyExactText(eletxtHeight, "Height");
		verifyExactText(eletxtWeight, "Weight");
		verifyExactText(eletxtPrimaryLanguage, "Primary Language");
		verifyExactText(eletxtBirthPlace, "Birth Place");
		verifyExactText(eletxtBirthState, "Birth State");
		verifyExactText(eletxtBirthCountry, "Birth Country");
		verifyExactText(eletxtDeathDate, "Death Date");
		Thread.sleep(3000);
		scrollToElementPosition(eletxtIVDCaseID);
		verifyExactText(eletxtIVDCaseID, "IV-D Case ID");
		verifyExactText(eletxtIVDParticipantID, "IV-D Participant ID");
		verifyExactText(eletxtProgramMemberID, "Program Member ID");
		verifyExactText(eletxtProgramCaseID, "Program Case ID");
		verifyExactText(eletxtApprovalDate, "Approval Date");
		verifyExactText(eletxtProgramType, "Program Type");
		verifyExactText(eletxtStartDate, "Participation Start Date");
		verifyExactText(eletxtEndDate, "Participation End Date");
		verifyExactText(eletxtNCPLeftDate, "NCP Left Date");
		Thread.sleep(3000);
		verifyExactText(eletxtAddressType, "Address Type");
		verifyExactText(eletxtATTN, "ATTN/Care of");
		verifyExactText(eletxtAddress, "Address");
		Thread.sleep(3000);
		verifyExactText(eletxtHomePhone, "Home Phone");
		verifyExactText(eletxtEmailID, "Email ID");
		verifyExactText(eletxtWorkPhone, "Work Phone");
		verifyExactText(eletxtCellPhone, "Cell Phone");
		verifyExactText(eletxtFax, "Fax");
		verifyExactText(eletxtMessagePhone, "Message Phone");
		Thread.sleep(3000);
		verifyExactText(eletxtNCPMaritalStatus, "NCP Marital Status");
		verifyExactText(eletxtNCPCurrentlyMarried, "NCP Currently Married?");
		verifyExactText(eletxtNCPEverMarried, "NCP Ever Married To The CST");
		verifyExactText(eletxtNCPEverDivorced, "NCP Ever Divorced From The CST");
		verifyExactText(eletxtPaternityCases, "Multiple Paternity Cases Exist For The CST?");
		verifyExactText(eletxtDateOfMarriage, "NCP Date Of Marriage To CST");
		verifyExactText(eletxtDivorceDate, "NCP Divorce Date From The CST");
		verifyExactText(eletxtSeperateDate, "NCP And CST Separated Date");
		verifyExactText(eletxtCSTMaritalStatus, "CST Marital Status");
		verifyExactText(eletxtCSTCurrentlyMarried, "CST Currently Married?");
		Thread.sleep(3000);
		verifyExactText(eletxtNCPRelationship, "NCP Relationship To Child");
		verifyExactText(eletxtCSTRelationship, "CST Relationship To Child");
		verifyExactText(eletxtPaternityIndicator, "Paternity Established Indicator");
		verifyExactText(eletxtPaternityDate, "Paternity Established Date");
		verifyExactText(eletxtCustodyDate, "Custody Date");
		verifyExactText(eletxtPaternityOrder, "Paternity Affidavit Court Ordered");
		verifyExactText(eletxtNCPBirthCertificate, "NCP Name On Birth Certificate");
		verifyExactText(eletxtWedlock, "Born Out Of Wedlock");
		return this;
	}

	
	public EditPendingReferralsPage verifyAdditionalParticipantDetailsPanel() throws Exception {

		Thread.sleep(2000);
		click(elePointerDown, "Down Pointer");
		click(elebgcolorParticipantAdditionalDetails, "Paritcipant Additional details");
		verifyPartialText(eleHistoryNavigation, "Records found");
		verifyExactText(eletxtMemberName, "Member Name");
		verifyExactText(eletxtEmployer, "Employer");
		verifyExactText(eletxtFEIN, "FEIN");
		verifyExactText(eletxtEmployerPhone, "Employer Phone");
		verifyExactText(eletxtInsuranceNumber, "Insurance Number");
		verifyExactText(eletxtCarrier, "Carrier");
		verifyExactText(eletxtInsuranceType, "Insurance Type");
		verifyExactText(eletxtPolicyHolderName, "Policy Holder Name");
		return this;

	}
	
	public EditPendingReferralsPage verifySaveasRejectStatus() throws Exception {

		Thread.sleep(2000);
		String ProgamMemberID = getElementText(eleProgramMemberID);
		click(eleicnReject, "Reject Radio button");
		selectDropdownValue(eleddRejectReason, "NCP IN THE HOME");
		click(eleicnSave, "Save");
		verifyExactText(eleErrStatusBar, "SAVED SUCCESSFULLY");
		click(eleicnClose,"Close");
		click(eleicnFilter, "Filter icon");
		selectDropdownValue(eleddStatus, "REJECTED");
		click(eleicnSearch, "Search Icon");
		verifyGridContainsData(eleGridValue, ProgamMemberID);
		return this;

	}

	public EditPendingReferralsPage verifySaveasDeclineStatus() throws Exception {

		Thread.sleep(2000);
		String ProgamMemberID = getElementText(eleProgramMemberID);
		click(eleicnDecline, "Reject Radio button");
		selectDropdownValue(eleDeclineReason, "NCP DECEASED");
		click(eleicnSave, "Save");
		verifyExactText(eleErrStatusBar, "SAVED SUCCESSFULLY");
		//	verifyExactText(eleHistoryStatus, "DECLINED");
		click(eleicnClose,"Close");
		click(eleicnFilter, "Filter icon");
		selectDropdownValue(eleddStatus, "DECLINED");
		click(eleicnSearch, "Search Icon");
		verifyGridContainsData(eleGridValue, ProgamMemberID);
		return this;

	}
	
	public EditPendingReferralsPage verifySaveforExistingParticipantID() throws Exception {

		String ProgamMemberID = getElementText(eleProgramMemberID);
		click(eleicnLinkReferral, "Link referral");
//		click(eleParticipantSearchforChild, "Case Relationship as child");
//		click(elelinkToCase, "Link To case" );
//		click(elecompleteclearance, "Complete Clearance button");
		clearAndType(eleEnterCaseID, "Enter CaseID", "3200000004");
		//	click(eleEnterCaseID, "Enter Case ID- LOV");
		//	click(elegdSelectcasepopup, "Grid Record");
		//	click(eleOK, "OK");
		click(eleicnSave, "Save");
		verifyExactText(eleErrStatusBar, "SAVED SUCCESSFULLY");
		//	verifyExactText(eleHistoryStatus, "HISTORY");
		click(eleicnClose,"Close");
		click(eleicnFilter, "Filter icon");
		selectDropdownValue(eleddStatus, "HISTORY");
		click(eleicnSearch, "Search Icon");
		verifyGridContainsData(eleGridValue, ProgamMemberID);
		return this;

	}
	
	
	
	public EditPendingReferralsPage verifySaveforExistingParticipantIDwithSSN() throws Exception {

		String ProgamMemberID = getElementText(eleProgramMemberID);
		click(eleicnLinkReferral, "Link referral");
//		click(eleParticipantSearchforChild, "Case Relationship as child");
//		click(elelinkToCase, "Link To case" );
//		click(elecompleteclearance, "Complete Clearance button");
		clearAndType(eleEnterCaseID, "Enter CaseID", "3200000004");
		//	click(eleEnterCaseID, "Enter Case ID- LOV");
		//	click(elegdSelectcasepopup, "Grid Record");
		//	click(eleOK, "OK");
		click(eleicnSave, "Save");
		verifyExactText(eleErrStatusBar, "SAVED SUCCESSFULLY");
		//	verifyExactText(eleHistoryStatus, "HISTORY");
		return this;

	}

	public EditPendingReferralsPage verifySaveforExistingParticipantIDwithSameCSTnNCP() throws Exception {

		String ProgamMemberID = getElementText(eleProgramMemberID);
		click(eleicnLinkReferral, "Link referral");
//		click(eleParticipantSearchforChild, "Case Relationship as child");
//		click(elelinkToCase, "Link To case" );
//		click(elecompleteclearance, "Complete Clearance button");
		clearAndType(eleEnterCaseID, "Enter CaseID", "3200000004");
		//	click(eleEnterCaseID, "Enter Case ID- LOV");
		//	click(elegdSelectcasepopup, "Grid Record");
		//	click(eleOK, "OK");
		click(eleicnSave, "Save");
		verifyExactText(eleErrStatusBar, "SAVED SUCCESSFULLY");
		//	verifyExactText(eleHistoryStatus, "HISTORY");
		return this;

	}
	@FindBy(xpath="//span[normalize-space(text())='PUTATIVE FATHER']/following::span[text()='Participant Search']") WebElement eleparticipantSearchforputativeFather;
	@FindBy(xpath="//span[normalize-space(text())='CUSTODIAL']/following::span[text()='Participant Search']") WebElement eleparticipantSearchforCustodialParent;
	public EditPendingReferralsPage verifySaveforExistingParticipantIDwithCPNCPChild_PMID() throws Exception {

		String ProgamMemberID = getElementText(eleProgramMemberID);
		click(eleicnLinkUpdate, "Link update referral");
//		click(eleParticipantSearchforChild, "Case Relationship as child");
//		click(elelinkToCase, "Link To case" );
//		click(elecompleteclearance, "Complete Clearance button");
		click(eleicnLinkUpdate, "Link update referral");
//		click(eleparticipantSearchforputativeFather, "Case Relationship as putative father");
//		click(elelinkToCase, "Link To case" );
//		click(elecompleteclearance, "Complete Clearance button");
		click(eleicnLinkUpdate, "Link update referral");
//		click(eleparticipantSearchforCustodialParent, "Case Relationship as Custodial father");
//		click(elelinkToCase, "Link To case" );
//		click(elecompleteclearance, "Complete Clearance button");
		clearAndType(eleEnterCaseID, "Enter CaseID", "3200000004");
		//	click(eleEnterCaseID, "Enter Case ID- LOV");
		//	click(elegdSelectcasepopup, "Grid Record");
		//	click(eleOK, "OK");
		click(eleicnSave, "Save");
		verifyExactText(eleErrStatusBar, "SAVED SUCCESSFULLY");
		//	verifyExactText(eleHistoryStatus, "HISTORY");
		return this;

	}
	
	public EditPendingReferralsPage verifySaveforExistingParticipantIDwithCPNCPChild_SSN() throws Exception {

		String ProgamMemberID = getElementText(eleProgramMemberID);
		click(eleicnLinkUpdate, "Link update referral");
//		click(eleParticipantSearchforChild, "Case Relationship as child");
//		click(elelinkToCase, "Link To case" );
//		click(elecompleteclearance, "Complete Clearance button");
		click(eleicnLinkUpdate, "Link update referral");
//		click(eleparticipantSearchforputativeFather, "Case Relationship as putative father");
//		click(elelinkToCase, "Link To case" );
//		click(elecompleteclearance, "Complete Clearance button");
		click(eleicnLinkUpdate, "Link update referral");
//		click(eleparticipantSearchforCustodialParent, "Case Relationship as Custodial father");
//		click(elelinkToCase, "Link To case" );
//		click(elecompleteclearance, "Complete Clearance button");
		clearAndType(eleEnterCaseID, "Enter CaseID", "3200000004");
		//	click(eleEnterCaseID, "Enter Case ID- LOV");
		//	click(elegdSelectcasepopup, "Grid Record");
		//	click(eleOK, "OK");
		click(eleicnSave, "Save");
		verifyExactText(eleErrStatusBar, "SAVED SUCCESSFULLY");
		//	verifyExactText(eleHistoryStatus, "HISTORY");
		return this;

	}
	
	public EditPendingReferralsPage verifySaveforExistingParticipantIDwithCPNCPChild() throws Exception {

		String ProgamMemberID = getElementText(eleProgramMemberID);
		click(eleicnLinkUpdate, "Link update referral");
//		click(eleParticipantSearchforChild, "Case Relationship as child");
//		click(elelinkToCase, "Link To case" );
//		click(elecompleteclearance, "Complete Clearance button");
		click(eleicnLinkUpdate, "Link update referral");
//		click(eleparticipantSearchforputativeFather, "Case Relationship as putative father");
//		click(elelinkToCase, "Link To case" );
//		click(elecompleteclearance, "Complete Clearance button");
		click(eleicnLinkUpdate, "Link update referral");
//		click(eleparticipantSearchforCustodialParent, "Case Relationship as Custodial father");
//		click(elelinkToCase, "Link To case" );
//		click(elecompleteclearance, "Complete Clearance button");
		clearAndType(eleEnterCaseID, "Enter CaseID", "3200000004");
		//	click(eleEnterCaseID, "Enter Case ID- LOV");
		//	click(elegdSelectcasepopup, "Grid Record");
		//	click(eleOK, "OK");
		click(eleicnSave, "Save");
		verifyExactText(eleErrStatusBar, "SAVED SUCCESSFULLY");
		//	verifyExactText(eleHistoryStatus, "HISTORY");
		return this;

	}
	
	public EditPendingReferralsPage verifySaveforExistingParticipantIDwithmultipleChild() throws Exception {

		String ProgamMemberID = getElementText(eleProgramMemberID);
		clearAndType(eleEnterCaseID, "Enter CaseID", "3200000004");
		//	click(eleEnterCaseID, "Enter Case ID- LOV");
		//	click(elegdSelectcasepopup, "Grid Record");
		//	click(eleOK, "OK");
		click(eleicnLinkUpdate, "Link update referral");
//		click(eleParticipantSearchforChild, "Case Relationship as child");
//		click(elelinkToCase, "Link To case" );
//		click(elecompleteclearance, "Complete Clearance button");
		click(eleicnSave, "Save");
		verifyExactText(eleErrStatusBar, "SAVED SUCCESSFULLY");
		click(eleicnClose, "close");
		click(eleicnFilter, "Filter icon");
		selectDropdownValue(eleddStatus, "HISTORY");
		click(eleicnSearch, "Search Icon");
		verifyGridContainsData(eleGridValue, ProgamMemberID);
		doDoubleClick(driver.findElementByXPath("//span[text()='"+ProgamMemberID+"']"));
		clearAndType(eleEnterCaseID, "Enter CaseID", "3200000003");
		click(eleParticipantSearchforChild, "Case Relationship as child");
//		click(elelinkToCase, "Link To case" );
//		click(elecompleteclearance, "Complete Clearance button");
		click(eleicnSave, "Save");
		click(eleconfirmationYes, "Yes");
		verifyExactText(eleErrStatusBar, "SAVED SUCCESSFULLY");
		return this;
		
		
		
		
		
		
	}
	
	
	
	
	
	public EditPendingReferralsPage verifyCreateCase() throws Exception {

		click(eleCreateCase, "Create Case");
		verifyExactText(eleCreateCasepopup, "Create Case");
		verifyEnabled(eleicnApplicant);
		verifyDisplayed(eleicnDownPointer, "Dropdown icon");
		return this;

	}

	public EditPendingReferralsPage verifyCreateCaseWithTANF() throws Exception {

		doubleClickGridResult(eleicnGridOptions, "TANF");
		click(eleCreateCase, "Create Case");
		verifyExactText(eleCreateCasepopup, "Create Case");
		verifyEnabled(eleicnApplicant);
		click(eleicnSave, "Save");
		click(eleconfirmationYes, "Yes");
		click(eleErrStatusBar, "SAVED SUCCESSFULLY");
		String participantID = getElementText(eleApplicantID);
		click(eleViewApplications, "View Applications");
		WebElement participantStatus = driver.findElementByXPath("//span[normalize-space(text())='"+participantID+"']/following::span[normalize-space(text())='IV-A PENDING']");
		verifyExactText(participantStatus, " IV-A PENDING ");
		return this;

	}

	public EditPendingReferralsPage verifyCreateCaseWithMEDICAID() throws Exception {

		doubleClickGridResult(eleicnGridOptions, "MEDICAID");
		click(eleCreateCase, "Create Case");
		verifyExactText(eleCreateCasepopup, "Create Case");
		verifyEnabled(eleicnApplicant);
		click(eleicnSave, "Save");
		click(eleconfirmationYes, "Yes");
		click(eleErrStatusBar, "SAVED SUCCESSFULLY");
		String participantID = getElementText(eleApplicantID);
		click(eleViewApplications, "View Applications");
		WebElement participantStatus = driver.findElementByXPath("//span[normalize-space(text())='"+participantID+"']/following::span[normalize-space(text())='IV-A PENDING']");
		verifyExactText(participantStatus, " TITLE XIX PENDING ");
		return this;

	}

	public EditPendingReferralsPage verifyCreateCaseWithFosterCare() throws Exception {

		doubleClickGridResult(eleicnGridOptions, "IV-E FOSTER CARE");
		click(eleCreateCase, "Create Case");
		verifyExactText(eleCreateCasepopup, "Create Case");
		verifyEnabled(eleicnApplicant);
		click(eleicnSave, "Save");
		click(eleconfirmationYes, "Yes");
		click(eleErrStatusBar, "SAVED SUCCESSFULLY");
		String participantID = getElementText(eleApplicantID);
		click(eleViewApplications, "View Applications");
		WebElement participantStatus = driver.findElementByXPath("//span[normalize-space(text())='"+participantID+"']/following::span[normalize-space(text())='IV-A PENDING']");
		verifyExactText(participantStatus, " IV-E PENDING ");
		return this;

	}








}





