package gov.nv.dwss.nvkids.pages.pdrf;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class ViewPendingReferralsPage extends CommonLocators 
{
	public ViewPendingReferralsPage() 
	{
		PageFactory.initElements(driver, this);
	}	
	//---------Screen functions---------------
	@FindBy(xpath="//span[text()='Maintain Pending Referrals']") WebElement elelnkPDRF_maintainpendingreferrals;
	@FindBy(xpath = "//span[text()='Process Pending Referrals']") WebElement eleViewPendingReferrals;		
	@FindBy(xpath = "//span[text()='View Pending Referrals']") WebElement eletxtViewPendingReferrals;
	//---------------Filter Section-------------
	@FindBy(xpath = "//span[@class='fa fa-angle-double-down downIcon']")  WebElement eleicnSelectFilter;	
	@FindBy(xpath="//a[@class='pull-right bold text-dark-blue selectFilterbtn ng-star-inserted'][contains(text(),'Filter')]") WebElement elelblSelectFilter;

	//Program Type
	@FindBy(xpath="//label[text()='Program Type']") WebElement elelblProgramType;
	@FindBy(xpath = "(//div[@class='ui-helper-hidden-accessible']/following-sibling::label)[1]") WebElement eleddProgramType;

	//IV-D Office
	@FindBy(xpath = "//label[text()='IV-D Office']") WebElement elelbIVDOffice;
	@FindBy(id="ivdOfficeCode") WebElement eletxtIVDOffice;
	@FindBy(xpath = "//span[@class='ui-button-icon-left ui-clickable fa fa-search']") WebElement elelovIVDOffice;

	//Status
	@FindBy(xpath="//label[text()='Status']") WebElement elelbStatus;
	@FindBy(xpath = "(//div[@class='ui-helper-hidden-accessible']/following-sibling::label)[2]") WebElement eleddStatus;

	//From Date
	@FindBy(xpath ="//label[text()=' From Date ']") WebElement elelblFromDate;
	@FindBy(id = "fromDate") WebElement eletxtFromDate;
	@FindBy(xpath = "(//span[contains(@class,'ui-button-icon-left ui-clickable')])[4]") WebElement eledtFromDate;

	//Through Date
	@FindBy(xpath ="//label[text()=' Through Date ']") WebElement elelblThroughDate;
	@FindBy(id="toDate") WebElement eletxtThroughDate;
	@FindBy(xpath = "(//span[contains(@class,'ui-button-icon-left ui-clickable')])[5]") WebElement eledtThroughDate;

	@FindBy(xpath = "(//span[contains(@class,'ui-dropdown-trigger-icon ui-clickable')])[2]") WebElement eleicnProgramType;
	@FindBy(xpath = "(//div[contains(@class,'ui-dropdown-trigger ui-state-default')])[3]") WebElement eleicnStatus;

	//--------------Grid Section-----------------------------
	@FindBy(xpath="//label[text()='Referral Date']") WebElement elehdrReferralDate;
	@FindBy(xpath="//label[text()='Program Case ID']") WebElement elehdrProgramCaseID;
	@FindBy(xpath="//label[text()='CST Name']") WebElement elehdrCSTName;
	@FindBy(xpath="//label[text()='NCP Name']") WebElement elehdrNCPName;
	@FindBy(xpath="//label[text()='IV-D Office]") WebElement elehdrIVDOffice;
	@FindBy(xpath="//label[text()='Program Type']") WebElement elehdrProgramType;
	@FindBy(xpath="//label[text()='Program Member ID']") WebElement elehdrProgramMemberID;
	@FindBy(xpath="//label[text()='Good Cause']") WebElement elehdrGoodCause;
	@FindBy(xpath="//label[text()='Reason']") WebElement elehdrReason;
	@FindBy(xpath="//label[text()='Status']") WebElement elehdrStatus;
	@FindBy(xpath="//tr/td/span") WebElement eleGridValue;	

	//-------------Grid Accordion section----------------------
	@FindBy(id="ui-accordiontab-0") WebElement elepnlCaseDetails;
	@FindBy(id = "ui-accordiontab-1") WebElement elepnlCaseParticipantDetails;
	@FindBy(id = "ui-accordiontab-2") WebElement elepnlParticipantAdditionalDetails;

	//-------------Grid Accordion section - Case Details panel----------------------
	@FindBy(xpath="//div[contains('/div/app-case-details/div/div[1]/lib-label-value[3]/div/span']") WebElement eledsoProgramType;
	@FindBy(xpath="//span[contains('#ui-accordiontab-0-content > div > app-case-details > div > div:nth-child(1) > lib-label-value:nth-child(2) > div > span']") WebElement eledsoReferralOffice;
	@FindBy(id="referralDate") WebElement elegsfReferralDate;	
	@FindBy(xpath="(//label[@for='referralDate'])[1]") WebElement eleghReferralDate;
	@FindBy(xpath="(//button[@type='button']//span)[5]") WebElement elegicnReferralDate;
	@FindBy(id="nomadsIciNumb") WebElement elegsfProgramCaseID;	
	@FindBy(xpath="(//label[@for='nomadsIciNumb'])[1]") WebElement eleghProgramCaseID;
	@FindBy(id="ivdOfficeCode") WebElement elegsfIVDOfficeCode;	
	@FindBy(xpath="(//label[@for='ivdOfficeCode'])[1]") WebElement eleghIVDOfficeCode;
	@FindBy(id="ivdOfficeName") WebElement elegsfIVDOffice;	
	@FindBy(xpath="(//label[@for='ivdOfficeName'])[1]") WebElement eleghIVDOffice;

	@FindBy(xpath="(//span[@class='ng-star-inserted'])[1]") WebElement elegsfProgramTypeCode;	
	@FindBy(xpath="(//span[@class='ng-star-inserted'])[2]") WebElement elegsfProgramType;	
	@FindBy(xpath="//input[@id='programPersonNumb']") WebElement elegsfProgramMemberID;	
	@FindBy(xpath="(//label[@for='programPersonNumb'])[1]") WebElement eleghProgramMemberID;	
	@FindBy(xpath="(//span[@class='ng-star-inserted'])[3]") WebElement elegsfGoodCauseCode;	
	@FindBy(xpath="(//span[@class='ng-star-inserted'])[4]") WebElement elegsfGoodCause;	
	@FindBy(xpath="//label[text()=' Good Cause ']") WebElement eleghGoodCause;	

	@FindBy(id="referralReasonCode") WebElement elegsfReasonCode;	
	@FindBy(xpath="//label[text()=' Reason Code ']") WebElement eleghReasonCode;	
	@FindBy(id="referralReasonDesc") WebElement elegsfReason;	
	@FindBy(xpath="//label[text()=' Reason ']") WebElement eleghReason;	
	@FindBy(xpath="(//div[@class='ui-helper-hidden-accessible']/following-sibling::label)[5]") WebElement elegsfStateCode;	
	@FindBy(xpath="//label[text()=' Status Code ']") WebElement eleghStateCode;	
	@FindBy(xpath="(//span[text()='--ALL--'])[2]") WebElement elegsfState;	
	@FindBy(xpath="(//label[@for='referralStatusDesc'])[1]") WebElement eleghState;	

	@FindBy(xpath="//i[@class='pi pi-chevron-up']") WebElement elePointerUp;
	@FindBy(xpath="(//i[@class='pi pi-chevron-down'])[1]") WebElement elePointerDown;
	@FindBy(xpath="//span[text()=' Case Details ']") WebElement eletxtCaseDetails;
	@FindBy(xpath="//span[text()=' Case Participant Details ']") WebElement eletxtCaseParticipantDetails;
	@FindBy(xpath="//span[text()=' Participant Additional Details ']") WebElement eletxtParticipantAdditionalDetails;
	@FindBy(xpath="(//a[@role='tab'])[1]") WebElement elebgcolorCaseDetails;
	@FindBy(xpath="(//a[@role='tab'])[2]") WebElement elebgcolorCaseParticipantDetails;
	@FindBy(xpath="(//a[@role='tab'])[3]") WebElement elebgcolorParticipantAdditionalDetails;
	@FindBy(xpath="(//label[text()=' Program Type '])[2]") WebElement elegdtxtProgramType;
	@FindBy(xpath="//label[text()=' Referral Office ']") WebElement elegdtxtReferralOffice;
	@FindBy(xpath="(//label[text()=' Good Cause '])[2]") WebElement elegdtxtGoodCause;
	@FindBy(xpath="//label[text()=' Good Cause Claim Date ']") WebElement elegdtxtGoodCauseClaimDate;
	@FindBy(xpath="//label[text()=' Conflict Indicator ']") WebElement elegdtxtConflictIndicator;
	@FindBy(xpath="//label[text()=' Confidential Indicator ']") WebElement elegdtxtConfidentialIndicator;
	@FindBy(xpath ="//label[text()=' DCFS Worker Name ']") WebElement eletxtDCFSWorkerName;
	@FindBy(xpath ="//label[text()=' DCFS Office Phone ']") WebElement eletxtDCFSOfficePhone;
	@FindBy(xpath ="//label[text()=' Support Order Eff date ']") WebElement eletxtSupportOrderEffdate;
	@FindBy(xpath ="(//span[text()='Participant Search'])[1]") WebElement eletxtParticipantSearch;
	@FindBy(xpath ="//label[text()='Last Name']") WebElement elelblLastName;
	@FindBy(id ="lastName") WebElement elesfLastName;
	@FindBy(xpath ="//label[text()='First Name']") WebElement elelblFirstName;
	@FindBy(id ="firstName") WebElement elesfFirstName;
	@FindBy(xpath ="//label[text()='Middle Name']") WebElement elelblMiddleName;
	@FindBy(id ="middleName") WebElement elesfMiddleName;
	@FindBy(xpath ="//label[text()='Suffix Name']") WebElement elelblSuffixName;
	@FindBy(xpath ="(//div[@class='ui-helper-hidden-accessible']/following-sibling::label)[1]") WebElement eleddSuffixName;
	@FindBy(xpath ="(//div[contains(@class,'ui-dropdown-trigger ui-state-default')])[2]") WebElement eleicnSuffixName;

	@FindBy(xpath ="//label[text()='Search Within']") WebElement elelblSearchWithin;
	@FindBy(xpath ="//span[@class='ui-multiselect-label ui-corner-all']") WebElement eleddSearchWithin;
	@FindBy(xpath ="//div[@class='ui-multiselect-label-container']/following-sibling::div[1]") WebElement eleicnSearchWithin;


	@FindBy(xpath ="(//label[@for='birthDate'])[2]") WebElement elelblDateofBirth;
	@FindBy(id ="birthDate") WebElement elesfDateofBirth;
	@FindBy(xpath ="(//button[@type='button']//span)[5]") WebElement eleicnDateofBirth;

	@FindBy(xpath ="//label[text()='Age Range From']") WebElement elelblAgeRangeFrom;
	@FindBy(id ="ageFromNumb") WebElement elesfAgeRangeFrom;

	@FindBy(xpath ="//label[text()='Age Range To']") WebElement elelblAgeRangeTo;	
	@FindBy(id ="ageToNumb") WebElement elesfageRangeTo;

	@FindBy(xpath ="(//label[text()='SSN'])[1]") WebElement elelblSSN;
	@FindBy(id ="ssnNumb") WebElement elesfSSN;

	@FindBy(xpath ="(//label[text()='Gender'])[1]") WebElement elelblGender;	
	@FindBy(xpath ="(//div[@class='ui-helper-hidden-accessible']/following-sibling::label)[2]") WebElement eleddGender;
	@FindBy(xpath ="(//span[contains(@class,'ui-dropdown-trigger-icon ui-clickable')])[3]") WebElement eleicnGender;


	@FindBy(xpath ="(//label[text()='Race'])[1]") WebElement elelblRace;	
	@FindBy(xpath ="(//div[@class='ui-helper-hidden-accessible']/following-sibling::label)[3]") WebElement eleddRace;
	@FindBy(xpath ="(//span[contains(@class,'ui-dropdown-trigger-icon ui-clickable')])[4]") WebElement eleicnRace;

	@FindBy(xpath ="(//label[text()='Participant ID'])[1]") WebElement elelblParticipantID;	
	@FindBy(id ="personId") WebElement eleParticipantID;
	@FindBy(xpath ="//label[text()='Docket Number']") WebElement elelblDocketNumber;
	@FindBy(id ="docketIdc") WebElement elesfDocketNumber;	
	@FindBy(xpath ="//label[@for='officeCode']") WebElement elelblOfficeCode;
	@FindBy(id ="officeCode") WebElement elesfOfficeCode;
	@FindBy(xpath ="//button[contains(@class,'searchBtn ui-button-warn')]//span[1]") WebElement eleicnOfficeCode;	
	@FindBy(xpath ="//div[@class='search-btn-container ng-star-inserted']//p-button[1]") WebElement eletxtCreateNewParticipantID;
	@FindBy(xpath ="//h6[text()=' NVKIDS ']") WebElement eletxtNVKIDS;
	@FindBy(xpath ="ui-tabpanel-19-label") WebElement eletxtResult;
	@FindBy(xpath ="(//div[contains(@class,'text-center marginTop10')]//p-button)[1]") WebElement eletxtReviewResult;

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
	@FindBy(xpath ="(//label[text()=' Program Member ID '])[3]") WebElement eletxtProgramMemberID;
	@FindBy(xpath ="(//label[text()=' Program Case ID '])[2]") WebElement eletxtProgramCaseID;
	@FindBy(xpath ="//label[text()=' Approval Date ']") WebElement eletxtApprovalDate;
	@FindBy(xpath ="(//label[text()=' Program Type '])[3]") WebElement eletxtProgramType;
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
	@FindBy(xpath="//tbody[@class='ui-table-tbody']/tr/td/span") WebElement elegdRecord;
	
	@FindBy(xpath ="(//td//span[text()='Participant Search'])[1]")WebElement eleicngParticipantSearch;
	@FindBy(xpath="(//thead[@class='ui-table-thead'])[3]//th/label") List <WebElement> elepsGridHeaders;

	public ViewPendingReferralsPage verifypendingReferralInformationScreen() throws Exception {

		verifyExactText(eletxtViewPendingReferrals, "View Pending Referrals");
		verifyDisplayed(eleicnFilter, "Filter icon");
		Thread.sleep(2000);
		verifyGridHeaders(elelblGridHeaders, "Referral Date", "Program Case ID", "CST Name", "NCP Name", "IV-D Office", "Program Type", "Program Member ID", "Good Cause", "Reason", "Status");
		verifyAssociatedScreens(eleAssociatedScreenList, "Create and Maintain Case", "Document Processor","Participant Program History","Other Party Information");

		return this;
	}



	public ViewPendingReferralsPage verifysearchFilterScreen() throws Exception {

		click(eleicnFilter, "Filter");
		verifyDisplayed(elelblProgramType, "Program type Label");
		verifyDisplayed(eleddProgramType, "Program Type dropdown Box");
		verifyDisplayed(eleicnProgramType, "Program Type dropdown Icon");
		verifyDisplayed(elelbIVDOffice, "IV D Office label");
		verifyDisplayed(eletxtIVDOffice, "IV D Office text box");
		verifyDisplayed(elelovIVDOffice, "IV D Office LOV icon");
		verifyDisplayed(elelbStatus, "Status label");
		verifyDisplayed(eleddStatus, "Status Dropdown");
		verifyDisplayed(eleicnStatus, "Status icon");
		verifyDisplayed(elelblFromDate, "From Date label");
		verifyDisplayed(eletxtFromDate, "From Date Picker box");
		verifyDisplayed(eledtFromDate, "From Date picker icon");
		verifyDisplayed(elelblThroughDate, "Through date label");
		verifyDisplayed(eletxtThroughDate, "Through date box");
		verifyDisplayed(eledtThroughDate, "Thorugh date picker icon");
		verifyDisplayed(eleicnClear,"clear icon");
		verifyDisplayed(eleicnSearch," Search icon");
		return this;
	}
	public ViewPendingReferralsPage verifyInquiryStatus() throws Exception {

		click(eleicnFilter,"Filter");
		selectDropdownValue(eleddProgramType, "TANF");
		clearAndType(eletxtIVDOffice, "IV Office", "01");
		selectDropdownValue(eleddStatus, "REJECTED");
		clearAndType(eletxtFromDate, "From Date", "01/01/2019");
		clearAndType(eletxtThroughDate, "Through Date", "01/27/2020");
		click(eleicnSearch, "Search");

		wait.until(ExpectedConditions.visibilityOf(eleGridValue));
		try {
			if(eleGridValue.isDisplayed()==true){
				reportStep("Records are displayed in grid", "pass");
			}
		}catch(Exception e){
			reportStep("Records are not displayed in Grid", "fail");
		}
		return this;
	}

	public ViewPendingReferralsPage verifyShowColumnFields() throws Exception {

		verifyShowColumns(eleicnGridOptions, "Referral Date", "Program Case ID", "CST Name", "NCP Name", "IV-D Office Code", "IV-D Office","Program Type Code", "Program Type",
				"Program Member ID","Good Cause Code", "Good Cause", "Reason Code", "Reason", "Status Code" , "Status");

		return this;

	}	

	
	public ViewPendingReferralsPage verifyAdditionalRecordDetails() throws Exception {

		Thread.sleep(2000);
		click(elePointerDown, "Down Pointer");
		verifyExactText(eletxtCaseDetails, "Case Details");
		verifyExactText(eletxtCaseParticipantDetails,"Case Participant Details");
		verifyExactText(eletxtParticipantAdditionalDetails, "Participant Additional Details");
		click(elebgcolorCaseDetails, "Case Details");
		String color = getBackgroundColor(elebgcolorCaseDetails);
		System.out.println(color);
		if(color.equals("rgba(0, 0, 0, 1)")){
			System.out.println("Background color is green");
		}
		return this;

	}

	public ViewPendingReferralsPage verifyCaseDetailsforTANF() throws Exception {

		click(eleicnFilter, "Filter");
		selectDropdownValue(eleddProgramType, "TANF");
		click(eleicnSearch, "Search");
		wait.until(ExpectedConditions.visibilityOf(eleGridValue));
		try {
			if(eleGridValue.isDisplayed()==true){
				reportStep("Records are displayed in grid", "pass");
			}
		}catch(Exception e){
			reportStep("Records are not displayed in Grid", "fail");
		}

		Thread.sleep(2000);
		click(elePointerDown, "Down Pointer");
		click(elebgcolorCaseDetails, "Case Details");
		verifyExactText(elegdtxtProgramType, "Program Type");
		verifyExactText(elegdtxtReferralOffice, "Referral Office");
		verifyExactText(elegdtxtGoodCause, "Good Cause");
		verifyExactText(elegdtxtGoodCauseClaimDate, "Good Cause Claim Date");
		verifyExactText(elegdtxtConflictIndicator, "Conflict Indicator");
		verifyExactText(elegdtxtConfidentialIndicator, "Confidential Indicator");
		return this;


	}

	public ViewPendingReferralsPage verifyTanfDetails() throws Exception {
		click(eleicnFilter, "Filter");
		selectDropdownValue(eleddProgramType, "TANF");
		click(eleicnSearch, "Search");
		wait.until(ExpectedConditions.visibilityOf(eleGridValue));
		try {
			if(eleGridValue.isDisplayed()==true){
				reportStep("Records are displayed in grid", "pass");
			}
		}catch(Exception e){
			reportStep("Records are not displayed in Grid", "fail");
		}
		return this;
		
	}

	public ViewPendingReferralsPage verifyCaseDetailsforFosterCare() throws Exception {

		click(eleicnFilter, "Filter");
		selectDropdownValue(eleddProgramType, "IV-E FOSTER CARE");
		click(eleicnSearch, "Search");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(eleGridValue));
		try {
			if(eleGridValue.isDisplayed()==true){
				reportStep("Records are displayed in grid", "pass");
			}
		}catch(Exception e){
			reportStep("Records are not displayed in Grid", "fail");
		}

		Thread.sleep(2000);
		click(elePointerDown, "Down Pointer");
		click(elebgcolorCaseDetails, "Case Details");
		verifyExactText(elegdtxtProgramType, "Program Type");
		verifyExactText(elegdtxtReferralOffice, "Referral Office");
		verifyExactText(eletxtDCFSWorkerName, "DCFS Worker Name");
		verifyExactText(eletxtDCFSOfficePhone, "DCFS Office Phone");
		verifyExactText(eletxtSupportOrderEffdate, "Support Order Eff date");
		verifyExactText(elegdtxtConflictIndicator, "Conflict Indicator");
		verifyExactText(elegdtxtConfidentialIndicator, "Confidential Indicator");
		return this;


	}
	
	public ViewPendingReferralsPage verifyCaseDetailsforFosterChild() throws Exception{
		click(eleicnFilter, "Filter");
		selectDropdownValue(eleddProgramType, "IV-E FOSTER CARE");
		click(eleicnSearch, "Search");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(eleGridValue));
		try {
			if(eleGridValue.isDisplayed()==true){
				reportStep("Records are displayed in grid", "pass");
			}
		}catch(Exception e){
			reportStep("Records are not displayed in Grid", "fail");
		}
		return this;
	}

	public ViewPendingReferralsPage verifyCaseParticipantDetails() throws Exception {


		Thread.sleep(2000);
		click(elePointerDown, "Down pointer");
		click(elebgcolorCaseParticipantDetails, "Case Participant Details");
		verifyGridHeaders(elelblInnerGridHeaders, "Participant ID","Name", "Case Relationship", "Program Member ID", "SSN", "Date Of Birth", "Race", "Gender", "Untitled");
		verifyDisplayed(eleicngParticipantSearch, "Participant Search");
		return this;


	}

	public ViewPendingReferralsPage verifyParticipantSearchFilters() throws Exception {


		Thread.sleep(2000);
		click(elePointerDown, "Down pointer");
		click(elebgcolorCaseParticipantDetails, "Case Participant Details");
		click(eletxtParticipantSearch,"Participant Search");
		verifyDisplayed(elelblLastName, "LastName label");
		verifyDisplayed(elesfLastName, "LastName Text box");
		verifyDisplayed(elelblFirstName, "FirstName label");
		verifyDisplayed(elesfFirstName, "FirstName text box");
		verifyDisplayed(elelblMiddleName, "Middle Name Label");
		verifyDisplayed(elesfMiddleName, "MiddleNmae text box");
		verifyDisplayed(elelblSuffixName, "Suffix Name dropdown label");
		verifyDisplayed(eleddSuffixName, "Suffix Name dropdown box");
		verifyDisplayed(eleicnSuffixName, "Suffix Name dropdown icon");
		verifyDisplayed(elelblSearchWithin, "Search Within Dropdown label");
		verifyDisplayed(eleddSearchWithin, "Search Within Dropdown box");
		verifyDisplayed(eleicnSearchWithin, "Search Within Dropdown icon");
		verifyDisplayed(elelblDateofBirth, "Date of Birth label");
		verifyDisplayed(elesfDateofBirth, "Date of Birth box");
		verifyDisplayed(eleicnDateofBirth, "Date of Birth date picker icon");
		verifyDisplayed(elelblAgeRangeFrom, "Age Range From label");
		verifyDisplayed(elesfAgeRangeFrom, "Age Range From text box");
		verifyDisplayed(elelblAgeRangeTo, "Age Range To label");
		verifyDisplayed(elesfageRangeTo, "Age Range To Text box");
		verifyDisplayed(elelblSSN, "SSN label");
		verifyDisplayed(elesfSSN, "SSN Text Box");
		verifyDisplayed(elelblGender, "Gender label");
		verifyDisplayed(eleddGender, "Gender Dropdown box");
		verifyDisplayed(eleicnGender, "Gender Dropdown icon");
		verifyDisplayed(elelblRace, "Race label");
		verifyDisplayed(eleddRace, "Race Dropdwon Box");
		verifyDisplayed(eleicnRace, "Race Dropdwon icon");
		verifyDisplayed(elelblParticipantID, "Participant ID label");
		verifyDisplayed(eleParticipantID, "Participant Id Text box");
		verifyDisplayed(elelblDocketNumber, "Docker number label");
		verifyDisplayed(elesfDocketNumber, "Docket Number text box");
		verifyDisplayed(elelblOfficeCode, "Office code label");
		verifyDisplayed(elesfOfficeCode, "Office Code text box");
		verifyDisplayed(eleicnOfficeCode, "Office Code lov icon");
		verifyDisabled(eletxtResult);
		verifyDisabled(eletxtCreateNewParticipantID);
		verifyDisplayed(eletxtNVKIDS, "NVKIDS TAB");
		verifyGridHeaders(elepsGridHeaders, "Untitled", "Restricted Case", "Name", "Name Type / Reliability", "SSN / Date of Birth", "Gender Code","Gender", "Participant ID / Program Member ID","Address");
		verifyDisabled(eletxtReviewResult);

		return this;


	}


	public ViewPendingReferralsPage verifyCaseParticipantInformation() throws Exception {


		Thread.sleep(2000);
		click(elePointerDown, "Down Pointer");
		click(elebgcolorCaseParticipantDetails, "Case Participant Details");
		click(elePointerDown, "Down Pointer");
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

	public ViewPendingReferralsPage verifyAdditionalParticipantInfo() throws Exception {


		Thread.sleep(2000);
		click(elePointerDown, "Down Pointer");
		click(elebgcolorParticipantAdditionalDetails, "Paritcipant Additional details");
		verifyPartialText(eleHistoryNavigation, "Records found");
		verifyExactText(eletxtMemberName, "Member Name");
//		verifyExactText(eletxtMemberID, "Program Member ID");
		verifyExactText(eletxtEmployer, "Employer");
//		verifyExactText(eletxtaddpAddress, "Address");
		verifyExactText(eletxtFEIN, "FEIN");
		verifyExactText(eletxtEmployerPhone, "Employer Phone");
		verifyExactText(eletxtInsuranceNumber, "Insurance Number");
		verifyExactText(eletxtCarrier, "Carrier");
		verifyExactText(eletxtInsuranceType, "Insurance Type");
		verifyExactText(eletxtPolicyHolderName, "Policy Holder Name");

		return this;

	}

	public EditPendingReferralsPage verifyNavigateToEditPendingReferralScreen() throws Exception {

		click(eleicnFilter, "Filter icon");
		selectDropdownValue(eleddStatus, "PENDING");
		doDoubleClick(elegdRecord);


		return new EditPendingReferralsPage();

	}
	
	public EditPendingReferralsPage verifyNavigateToEditPendingParticipantInformationforRejected() throws Exception {

		click(eleicnFilter, "Filter icon");
		selectDropdownValue(eleddStatus, "REJECTED");
		click(eleicnSearch, "Search Icon");
		doDoubleClick(elegdRecord);
	


		return new EditPendingReferralsPage();

	}
	
	public EditPendingReferralsPage verifyNavigateToEditPendingParticipantInformationforDeclined() throws Exception {

		click(eleicnFilter, "Filter icon");
		selectDropdownValue(eleddStatus, "DECLINED");
		click(eleicnSearch, "Search Icon");
		doDoubleClick(elegdRecord);
	


		return new EditPendingReferralsPage();

	}
	

	
	





}
