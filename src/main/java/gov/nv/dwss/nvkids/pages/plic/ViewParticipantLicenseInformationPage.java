package gov.nv.dwss.nvkids.pages.plic;

import java.sql.SQLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class ViewParticipantLicenseInformationPage extends CommonLocators

{

	public ViewParticipantLicenseInformationPage() {
		PageFactory.initElements(driver, this);
	}

	// Screen Functions
	@FindBy(xpath = "(//span[text()='View Participant License Information'])[1]") WebElement elesfViewParticipantLicenseInformation;
	@FindBy(xpath = "//h5[@class='ng-star-inserted']") WebElement elegfViewParticipantLicenseInformation;
	// Filter Section
	@FindBy(xpath = "//label[text()='Participant ID']") WebElement elelblParticipantID;
	@FindBy(xpath = "//label[text()='Participant ID']/following-sibling::input") WebElement elesfParticipantID;
	@FindBy(xpath = "//label[text()='License Type']") WebElement elelblLicenseType;
	@FindBy(id = "licenseTypeCode") WebElement elesfLicenseType;
	@FindBy(xpath = "//button[@icon='fa fa-search']") WebElement eleicnLicenseType;
	@FindBy(xpath = "//span[@class='fa fa-search ui-clickable ui-button-icon-left ng-star-inserted']") WebElement eleicnParticipantID;
	@FindBy(xpath="//span[text()='Participant Source of Income']") WebElement participantSourceofincome;
	// Grid Headers and Show Filters Fields
	@FindBy(xpath = "//label[@for='licenseTypeDesc']") WebElement eleglblLicenseType;
	@FindBy(xpath = "//label[@for='otherPartyName']") WebElement eleglblAgencyName;
	@FindBy(xpath = "//label[@for='licenseIdc']") WebElement eleglblLicenseNumber;
	@FindBy(xpath = "//label[@for='issuingDate']") WebElement eleglblIssueDate;
	@FindBy(xpath = "//label[@for='suspensionDate']") WebElement eleglblSuspensionDate;
	@FindBy(xpath = "//label[@for='gamingRegistrationIdc']") WebElement eleglblGamingRegistrationID;
	//Table data
	@FindBy(xpath="//tbody[@class='ui-table-tbody']/tr/td[2]/span") WebElement eleGridValue;
	@FindBy(xpath ="//input[@id='licenseTypeDesc']") WebElement elegsfLicensetype;
	@FindBy(id="otherPartyName") WebElement elegsftxtAgencyName;
	@FindBy(id ="licenseIdc") WebElement elegsftxtLicenseNumber;
	@FindBy(id ="gamingRegistrationIdc") WebElement elegsftxtGamingNumber;
	@FindBy(id ="issuingDate") WebElement elegsftxtIssueDate;
	@FindBy(id ="suspensionDate") WebElement elegsftxtSuspensionDate;
	@FindBy(xpath="//tbody[@class='ui-table-tbody']/tr/td[2]/span") WebElement elegdLicenseType;
	@FindBy(xpath="//tbody[@class='ui-table-tbody']/tr/td[3]/span") WebElement elegdAgencyNumber;
	@FindBy(xpath="//tbody[@class='ui-table-tbody']/tr/td[4]/span") WebElement elegdLicenseNumber;
	@FindBy(xpath="//tbody[@class='ui-table-tbody']/tr/td[5]/span") WebElement elegdGamingNumber;
	@FindBy(xpath="//tbody[@class='ui-table-tbody']/tr/td[6]/span") WebElement elegdIssueDate;
	@FindBy(xpath="//tbody[@class='ui-table-tbody']/tr/td[7]/span") WebElement elegdSuspensionDate;
	@FindBy(xpath="//label[text()=' DOB ']") WebElement elelblDOB;
	@FindBy(xpath="(//label[text()=' SSN '])[2]") WebElement elelbSSN;
	@FindBy(xpath="//label[text()=' Gender ']") WebElement elelblGender;
	@FindBy(xpath="(//label[text()=' Address '])[1]") WebElement elelblAddress;
	@FindBy(xpath="(//label[text()=' Phone Number '])[2]") WebElement elelblPhoneNumber;
	@FindBy(xpath="//label[text()=' Race ']") WebElement elelblRace;
	@FindBy(xpath="//label[text()=' Height ']") WebElement elelblHeight;
	@FindBy(xpath="//label[text()=' Weight ']") WebElement elelblWeight;
	@FindBy(xpath="//label[text()=' Hair Color ']") WebElement elelblHairColor;
	@FindBy(xpath="//label[text()=' Eye Color ']") WebElement elelblEyeColor;
	@FindBy(xpath="//label[text()=' Other Party ID ']") WebElement elelblOtherPartyID;
	@FindBy(xpath="//label[text()=' Licensing Agency ']") WebElement elelblLicensingAgency;
	@FindBy(xpath="(//label[text()=' Address '])[2]") WebElement elelblAddressofAgency;
	@FindBy(xpath="//label[text()=' Phone ']") WebElement elelblPhoneNo;
	@FindBy(xpath="//label[text()=' Fax ']") WebElement elelblFax;
	@FindBy(xpath="//lib-label[@type='block']//div[1]") WebElement eleHistoryNavigation;
	@FindBy(xpath="(//i[@class='pi pi-chevron-down'])[1]") WebElement elePointerDown;
	@FindBy(xpath="//i[@class='pi pi-chevron-up']") WebElement elePointerUp;

	public ViewParticipantLicenseInformationPage verifyViewParticipantLicenseInformation() throws Exception {
		Thread.sleep(2000);
		verifyExactText(elesfViewParticipantLicenseInformation, "View Participant License Information");
		verifyGridHeaders(elelblGridHeaders, " License Type ", " Agency Name ", " License Number ", " Gaming Registration Number ", " Issue Date ", " Suspended Date ");
		Thread.sleep(3000);
		verifyDisabled(eleicnAdd);
		verifyDisplayed(eleicnFilter, "Fileter icon");
		return this;
	}

	public ViewParticipantLicenseInformationPage verifyScreen() throws Exception {
		Thread.sleep(2000);
		verifyExactText(elesfViewParticipantLicenseInformation, "View Participant License Information");
		return this;
	}

	public ViewParticipantLicenseInformationPage viewAssociatedScreens() throws Exception {
		Thread.sleep(2000);
		scrollToElementPosition(participantSourceofincome);
		verifyAssociatedScreens(eleAssociatedScreenList, "Note Processor", "Participant Address","Case Processor","Participant Demographics","Participant Source of Income" );
		return this;
	}

	public ViewParticipantLicenseInformationPage verifySelectFilters() throws Exception {
		Thread.sleep(2000);
		click(eleicnFilter, "Filter");
		Thread.sleep(2000);
		verifyDisplayed(elelblParticipantID, "ParticipantID Label");
		verifyDisplayed(elesfParticipantID, "ParticipantID Text Box");
		verifyDisplayed(eleicnParticipantID, "ParticipantID LOV icon");
		verifyDisplayed(elelblLicenseType, "License Type label");
		verifyDisplayed(elesfLicenseType, "License Type Text box");
		verifyDisplayed(eleicnLicenseType, "License Type LOV icon");
		verifyDisplayed(eleicnClear,"clear");
		verifyEnabled(eleicnSearch);
		return this;
	}

	public ViewParticipantLicenseInformationPage verifyInquiryParticipantID(String ParticipantID,String colName1) throws InterruptedException, ClassNotFoundException, SQLException { 
		Thread.sleep(2000); 
		click(eleicnFilter,"Filter");
		String Participant = selectQuery(ParticipantID, colName1);
		clearAndType(elesfParticipantID, "ParticipantID", Participant );
		pressEnterKey(elesfParticipantID);
		wait.until(ExpectedConditions.visibilityOf(eleGridValue));
		try {
			if(eleGridValue.isDisplayed()==true){
				reportStep("Grid data for Participant ID is displayed", "pass");
			}
		}catch(Exception e){
			reportStep("Grid data for Participant ID is not displayed", "fail");
		}
		return this;
	}

	public ViewParticipantLicenseInformationPage verifyInquiryParticipantIDandLicensetype (String ParticipantID,String colName1, String LicenseType, String colName2) throws InterruptedException, ClassNotFoundException, SQLException {
		Thread.sleep(2000);
		click(eleicnFilter,"Filter");
		String participantid = selectQuery(ParticipantID, colName1);
		System.out.println(participantid);
		String licensetype = selectQuery(LicenseType, colName2);
		clearAndType(elesfParticipantID,"ParticipantID" , participantid);
		clearAndType(elesfLicenseType, "LicenseType", licensetype);
		Thread.sleep(2000);
		click(eleicnSearch, "Search");

		wait.until(ExpectedConditions.visibilityOf(eleGridValue));
		try {
			if(eleGridValue.isDisplayed()==true){
				reportStep("Grid data for Participant ID and License type is displayed", "pass");
			}
		}catch(Exception e){
			reportStep("Grid data for Participant ID and License type is not displayed", "fail");
		}
		return this;
	}

	public ViewParticipantLicenseInformationPage verifyShowColumnFilters() throws InterruptedException {

		selectAllShowColumn(eleicnGridOptions);
		click(eleicnGridOptions,"grid options");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(eleGridValue));
		try {
			if(eleGridValue.isDisplayed()==true){
				reportStep("Records are displayed in Grid data", "pass");
			}
		}catch(Exception e) {
			reportStep("Records are not displayed in Grid data", "fail");
		}

		return this;
	}

	public ViewParticipantLicenseInformationPage verifyViewEachResult() throws Exception {

		click(elePointerDown, "Down Pointer");
		verifyPartialText(eleHistoryNavigation, "Showing most recent ");
		verifyExactAttribute(elePointerUp, "class", "pi pi-chevron-up");
		verifyExactText(elelblDOB, "DOB");
		verifyExactText(elelbSSN, "SSN");
		verifyExactText(elelblGender, "Gender");
		verifyExactText(elelblAddress, "Address");
		verifyExactText(elelblPhoneNumber, "Phone Number");
		verifyExactText(elelblRace, "Race");
		verifyExactText(elelblHeight, "Height");
		verifyExactText(elelblWeight, "Weight");
		verifyExactText(elelblHairColor, "Hair Color");
		verifyExactText(elelblEyeColor, "Eye Color");
		Thread.sleep(3000);
		scrollToElementPosition(elelblOtherPartyID);
		verifyExactText(elelblOtherPartyID, "Other Party ID");
		verifyExactText(elelblLicensingAgency, "Licensing Agency");
		verifyExactText(elelblAddressofAgency, "Address");
		verifyExactText(elelblPhoneNo, "Phone");
		verifyExactText(elelblFax, "Fax");

		return this;
	}

	public AddParticipantLicenseInformationPage verifyClickAdd() throws Exception {

		click(eleicnAdd, "ADD");

		return new AddParticipantLicenseInformationPage();
	}

	public EditParticipantLicenseInformationPage verifyClickEdit() throws Exception {

		doDoubleClick(elegdLicenseType);

		return new EditParticipantLicenseInformationPage();
	}






}
