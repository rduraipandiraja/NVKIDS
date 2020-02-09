package gov.nv.dwss.nvkids.pages.soin;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import gov.nv.dwss.nvkids.pages.psoi.ViewParticipantSourceOfIncomePage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class ViewSourceofIncomeInformationpage extends CommonLocators {
	public ViewSourceofIncomeInformationpage()
	{
		PageFactory.initElements(driver, this);
	}

	//Screen  Functions
	@FindBy(xpath="//h5[@class='ng-star-inserted']") WebElement elePageHeader;
	@FindBy(xpath="//label[text()='Source of Income']") WebElement elelblSourceofIncome;
	@FindBy(xpath="//span[@class='ui-radiobutton-icon ui-clickable pi pi-circle-on']") WebElement elebtnSourceofIncome;
	@FindBy(xpath="//label[text()='Related Source of Income']") WebElement elelblRelatedSourceofIncome;
	@FindBy(xpath="//span[@class='ui-radiobutton-icon ui-clickable']") WebElement elebtnRelatedSourceofIncome;
	@FindBy(xpath="//i[@class='pi pi-chevron-down']") WebElement elePointerUp;
	@FindBy(xpath="(//label[text()=' Name '])[2]") WebElement eleName;
	@FindBy(xpath="(//label[text()=' FEIN '])[2]") WebElement eleFein;
	@FindBy(xpath="(//label[text()=' Verified By '])") WebElement eleVerified;
	//filter options
	@FindBy(xpath="(//label[text()='Source of Income'])[2]") WebElement elelblGSourceofIncome;
	@FindBy(xpath="(//div[@class='ui-radiobutton-box ui-widget ui-state-default ui-state-active'])[2]") WebElement elebtnGRelatedSourceofIncome;
	@FindBy(xpath="(//label[text()='Related Source of Income'])[2]") WebElement elelblGRelatedSourceofIncome;
	@FindBy(xpath="(//div[@class='ui-radiobutton-box ui-widget ui-state-default'])[2]") WebElement elebtnGSourceofIncome;
	@FindBy(xpath="(//label[@for='otherPartyId'])[2]") WebElement elelblSourceofIncomeId;
	@FindBy(xpath="//input[@id='otherPartyId']") WebElement eletbSourceofIncomeId;
	@FindBy(xpath="(//label[@for='otherPartyTypeCode'])[2]") WebElement elelblSourceofIncomeType;
	@FindBy(xpath="//input[@id='otherPartyTypeCode']/following::label") WebElement eleddSourceofIncomeType;
	@FindBy(xpath="(//div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[2]") WebElement elelovSourceofIncomeType;
	@FindBy(xpath="//label[@for='feinNumb']") WebElement elelblFein;
	@FindBy(xpath="//input[@class='ui-inputtext ui-corner-all ui-state-default ui-widget']") WebElement eletbFein;
	@FindBy(xpath="//label[@for='seinNumb']") WebElement elelblSein;
	@FindBy(xpath="(//input[@class='ui-inputtext ui-corner-all ui-state-default ui-widget'])[2]") WebElement eletbSein;
	@FindBy(xpath="//label[@for='verifiedByName']") WebElement elelblVerifiedBy;
	@FindBy(xpath="//input[@id='verifiedByName']") WebElement eleddVerifiedBy;
	@FindBy(xpath="//span[@class='ui-button-icon-left ui-clickable fa fa-search']/parent::button") WebElement elelovVerifiedBy;
	@FindBy(xpath="(//label[@for='othpSoiStatusCode'])[2]") WebElement elelblStatus;
	@FindBy(xpath="//input[@id='othpSoiStatusCode']/following::label") WebElement eleddStatus;
	@FindBy(xpath="(//div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[3]") WebElement elelovStatus;
	@FindBy(xpath="(//label[@for='otherPartyName'])[2]") WebElement elelblName;
	@FindBy(xpath="//input[@id='otherPartyName']") WebElement eletbName;
	@FindBy(xpath="//input[@id='searchOptionNameText']/following::label") WebElement eleddUntitled;
	@FindBy(xpath="//input[@id='searchOptionNameText']/following::label/following::div") WebElement elelovUntitled;
	@FindBy(xpath="//label[@for='doingBusinessAsName']") WebElement elelblDoingBusinssAs;
	@FindBy(xpath="//input[@id='doingBusinessAsName']") WebElement eletbDoingBusinssAs;
	@FindBy(xpath="//input[@id='searchOptionBusinessNameText']/following::label") WebElement eleddUntitled1;
	@FindBy(xpath="(//div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[5]") WebElement elelovUntitled1;
	@FindBy(xpath="(//label[@for='line1Addr'])[2]") WebElement elelblAddressLine1;
	@FindBy(xpath="//input[@id='line1Addr']") WebElement eletbAddressLine1;
	@FindBy(xpath="(//label[@for='line2Addr'])[2]") WebElement elelblAddressLine2;
	@FindBy(xpath="//input[@id='line2Addr']") WebElement eletbAddressLine2;
	@FindBy(xpath="(//label[@for='cityName'])[2]") WebElement elelblCity;
	@FindBy(xpath="//input[@id='cityName']") WebElement eletbCity;
	@FindBy(xpath="(//label[@for='stateCode'])[2]") WebElement elelblState;
	@FindBy(xpath="//input[@id='stateCode']") WebElement eleddState;
	@FindBy(xpath="(//span[@class='ui-button-icon-left ui-clickable fa fa-search']/parent::button)[2]") WebElement elelovState;
	@FindBy(xpath="(//label[@for='postCode'])[2]") WebElement elelblZip;
	@FindBy(xpath="//input[@id='postCode']") WebElement eletbZip;
	// filter related source of income options
        @FindBy(xpath="(//label[@for='otherPartyId'])[2]") WebElement elelblRelatedSourceofIncomeId;
		@FindBy(xpath="//input[@id='otherPartyId']") WebElement eletbRelatedSourceofIncomeId;
		@FindBy(xpath="(//label[@for='otherPartyTypeCode'])[2]") WebElement elelblRelatedSourceofIncomeType;
		@FindBy(xpath="//input[@id='otherPartyTypeCode']/following::label") WebElement eleddRelatedSourceofIncomeType;
		@FindBy(xpath="(//div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[2]") WebElement elelovRelatedSourceofIncomeType;
		@FindBy(xpath="(//label[@for='feinNumb'])[2]") WebElement elelblRFein;
		@FindBy(xpath="//input[@class='ui-inputtext ui-corner-all ui-state-default ui-widget']") WebElement eletbRFein;
		@FindBy(xpath="(//label[@for='seinNumb'])") WebElement elelblRSein;
		@FindBy(xpath="(//input[@class='ui-inputtext ui-corner-all ui-state-default ui-widget'])[2]") WebElement eletbRSein;
		@FindBy(xpath="//label[@for='verifiedByName']") WebElement elelblRVerifiedBy;
		@FindBy(xpath="//input[@id='verifiedByName']") WebElement eleddRVerifiedBy;
		@FindBy(xpath="//button[@class='searchBtn ui-button-warn ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only ng-star-inserted']") WebElement elelovRVerifiedBy;
		@FindBy(xpath="(//label[@for='othpSoiStatusCode'])[2]") WebElement elelblRStatus;
		@FindBy(xpath="//input[@id='othpSoiStatusCode']/following::label") WebElement eleddRStatus;
		@FindBy(xpath="(//div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[3]") WebElement elelovRStatus;
		@FindBy(xpath="(//label[@for='otherPartyName'])[2]") WebElement elelblRName;
		@FindBy(xpath="//input[@id='otherPartyName']") WebElement eletbRName;
		@FindBy(xpath="//input[@id='searchOptionNameText']/following::label") WebElement eleddRUntitled;
		@FindBy(xpath="(//div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[4]") WebElement elelovRUntitled;
		@FindBy(xpath="//label[@for='doingBusinessAsName']") WebElement elelblRDoingBusinessAs;
		@FindBy(xpath="//input[@id='doingBusinessAsName']") WebElement eletbRDoingBusinessAs;	
		@FindBy(xpath="//input[@id='searchOptionBusinessNameText']/following::label") WebElement eleddRUntitled1;
		@FindBy(xpath="(//div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[5]") WebElement elelovRUntitled1;
		@FindBy(xpath="(//label[@for='line1Addr'])[2]") WebElement elelblRAddressLine1;
		@FindBy(xpath="//input[@id='line1Addr']") WebElement eletbRAddressLine1;
		@FindBy(xpath="(//label[@for='line2Addr'])[2]") WebElement elelblRAddressLine2;
		@FindBy(xpath="//input[@id='line2Addr']") WebElement eletbRAddressLine2;
		@FindBy(xpath="(//label[@for='cityName'])[2]") WebElement elelblRCity;
		@FindBy(xpath="//input[@id='cityName']") WebElement eletbRCity;
		@FindBy(xpath="(//label[@for='stateCode'])[2]") WebElement elelblRState;
		@FindBy(xpath="//input[@id='stateCode']") WebElement eleddRState;
		@FindBy(xpath="(//span[@class='ui-button-icon-left ui-clickable fa fa-search']/parent::button)[2]") WebElement elelovRState;
		
		//Grid filter Xpath
		@FindBy(xpath="//label[@for='otherPartyName']") WebElement elelblGName;
		@FindBy(xpath="//input[@id='otherPartyName']") WebElement eletbGName;
		@FindBy(xpath="//label[@for='otherPartyId']") WebElement elelblGSourceofincomeID;
		@FindBy(xpath="//input[@id='otherPartyId']") WebElement eletbGSourceofincomeID;
		@FindBy(xpath="//input[@id='otherPartyTypeCode']/following::label") WebElement eleddGSourceofincometype;
		@FindBy(xpath="(//input[contains(@class,'ui-inputtext')])[4]") WebElement eletbgFein;
		@FindBy(xpath="//input[@id='othpBeginDate']") WebElement eledpBeginDate;
		@FindBy(xpath="//input[@id='othpSoiStatusCode']/following::label") WebElement eleddGStatus;
		@FindBy(xpath="//input[@id='cityName']") WebElement eleddGCity;
		@FindBy(xpath="//input[@id='stateCode']") WebElement eleddGState;
		@FindBy(xpath="//input[@id='postCode']") WebElement eleddGZip;
		@FindBy(xpath="//input[@id='countryCode']") WebElement eleddGCountry;
		@FindBy(xpath="//input[@id='otherPartyId']") WebElement eletbGRSourceofincomeID;
		@FindBy(xpath="//label[@for='otherPartyId']") WebElement elelblGRSourceofincomeID;
		@FindBy(xpath="//input[@id='otherPartyTypeCode']/following::label") WebElement elelblGRRelatedSourceofincomeType;
		@FindBy(xpath="//span[text()='Participants Linked To Source of Income']") WebElement elelblParticipntSourceofIncome;
		@FindBy(xpath="//h5") WebElement elelblPageHeader;
		//Participant linked to source of income
		@FindBy(xpath="//h5[@class='ng-star-inserted']") WebElement elelblViewParticipantLinkedToSourceOfIncome;
		@FindBy(xpath="//label[text()=' Name ']") WebElement elelblParticipantName;
		@FindBy(xpath="//label[text()=' Source of Income ID ']") WebElement elelblPartcipantSourceofIncomeID;
		@FindBy(xpath="//label[text()=' Source of Income Type ']") WebElement elelblParticipntSourceofIncomeType;
		@FindBy(xpath="//label[text()=' FEIN ']") WebElement elelblParticipantFein;
		@FindBy(xpath="//label[text()=' SEIN ']") WebElement elelblPartcipantSEIN;
		@FindBy(xpath="//label[text()=' Address ']") WebElement elelblParticipntAddress;
		
		

		
	public ViewSourceofIncomeInformationpage VerifyViewParticipantSourceOfIncome() throws Exception
	{
		Thread.sleep(2000);
		verifyExactText(elePageHeader, "View Source of Income Information");
		verifyGridHeaders(elelblGridHeaders," Name ", " Source of Income ID "," Source of Income Type "," FEIN "," Address "," Begin Date "," Status ");
		verifyDisplayed(eleicnFilter,"Filter");
		verifyDisplayed(eleicnAdd,"Add");
	    verifyDisplayed(elelblSourceofIncome, "Source of income label");
		verifyDisplayed(elebtnSourceofIncome, "Source of income button");
		verifyDisplayed(elebtnRelatedSourceofIncome, "Related Source of income Label");
		verifyDisplayed(elebtnSourceofIncome, "Related Source of income button");
		click(elePointerUp,"Pointer up");
		verifyExactText(eleName, "Name");
		verifyExactText(eleFein, "FEIN");
		verifyExactText(eleVerified, "Verified By");
		return this;
	}
	
	public ViewSourceofIncomeInformationpage VerifyFilters() throws Exception
	{
		Thread.sleep(2000);
		click(eleicnFilter,"Filter");
		Thread.sleep(2000);
		verifyDisplayed(elelblGRelatedSourceofIncome, "grid Source of income Label");
		verifyDisplayed(elelblSourceofIncomeId, "Source of income Id Label");
		verifyDisplayed(eletbSourceofIncomeId, "Source of income text box");
		verifyDisplayed(elelblSourceofIncomeType, "Source of income type Label");
		verifyDisplayed(eleddSourceofIncomeType, "Source of income type drop down");
		verifyDisplayed(elelovSourceofIncomeType, "Source of income type icon");
		verifyDisplayed(elelblFein, "Fein label");
		verifyDisplayed(eletbFein, "Fein text box");
		verifyDisplayed(elelblSein, "Sein label");
		verifyDisplayed(eletbSein, "Sein text box");
		verifyDisplayed(elelblVerifiedBy, "Verified bylabel");
		verifyDisplayed(eleddVerifiedBy, "Verified by dropdown");
		verifyDisplayed(elelovVerifiedBy, "Verified by icon");
		verifyDisplayed(elelblStatus, "Statuslabel");
		verifyDisplayed(eleddStatus, "Status dropdown");
		verifyDisplayed(elelovStatus, "Status lov ");
		verifyDisplayed(elelblName, "Name label");
		verifyDisplayed(eletbName, "Name dropdown");
		verifyDisplayed(eleddUntitled, "Untitled dropdown ");
		verifyDisplayed(elelovUntitled, "Untitled lov");
		verifyDisplayed(elelblDoingBusinssAs, "Doing business label");
		verifyDisplayed(eletbDoingBusinssAs, "Doing business as text box");
		verifyDisplayed(eleddUntitled1, "Untitled1 dropdown");
		verifyDisplayed(elelovUntitled1, "Untitled1 lov");
		verifyDisplayed(elelblAddressLine1, "Addressline1 label");
		verifyDisplayed(eletbAddressLine1, "Addresslin1 textbox");
		verifyDisplayed(elelblAddressLine2, "Addressline2 label");
		verifyDisplayed(eletbAddressLine2, "Addresslin2 textbox");
		verifyDisplayed(elelblCity, "City label");
		verifyDisplayed(eletbCity, "City textbox");
		verifyDisplayed(elelblState, "State label");
		verifyDisplayed(eleddState, "State dropdown");
		verifyDisplayed(elelovState, "State lov");
		verifyDisplayed(elelblZip, "Zip label");
		verifyDisplayed(eletbZip, "Zip textbox");
		
		verifyDisplayed(eleicnSearch,"Search");
		verifyDisplayed(eleicnClear,"clear");
		return this;
	}
	public ViewSourceofIncomeInformationpage VerifyFiltersRelatedSourceofIncome() throws Exception
	{
		Thread.sleep(2000);
		click(eleicnFilter,"Filter");
		Thread.sleep(2000);
		click(elelblGRelatedSourceofIncome,"G related source of income");
		verifyDisplayed(elelblRelatedSourceofIncomeId, "Related Source of income ID");
		verifyDisplayed(eletbRelatedSourceofIncomeId, "Related Source of income ID Text Box");
		verifyDisplayed(elelblRelatedSourceofIncomeType, "Related Source of income");
		verifyDisplayed(eleddRelatedSourceofIncomeType, "Related Source of income dropdown");
		verifyDisplayed(elelovRelatedSourceofIncomeType, "Related Source of income icon");
		verifyDisplayed(elelblRFein, "RFein");
		verifyDisplayed(eletbRFein, "RFein Text box");
		verifyDisplayed(elelblRSein, "RSein");
		verifyDisplayed(eletbRSein, "RSein text box");
		verifyDisplayed(elelblRVerifiedBy, "RVerified");
		verifyDisplayed(eleddRVerifiedBy, "RVerified dropdown");
		verifyDisplayed(elelovRVerifiedBy, "RVerified icon");
		verifyDisplayed(elelblRStatus, "RStatus");
		verifyDisplayed(eleddRStatus, "RStatus dropdown");
		verifyDisplayed(elelovRStatus, "RStatus icon");
		verifyDisplayed(elelblRName, "RName");
		verifyDisplayed(eletbRName, "RName text Box");
		verifyDisplayed(eleddRUntitled, "RUntitled dropdown");
		verifyDisplayed(elelovRUntitled, "RUntitled lov");
		verifyDisplayed(elelblRDoingBusinessAs, "RDoingBusiness");
		verifyDisplayed(eletbRDoingBusinessAs, "RDoingBusiness");
		verifyDisplayed(eleddRUntitled1, "RUntitled1 dropdown");
		verifyDisplayed(elelovRUntitled1, "RUntitled1 icon");
		verifyDisplayed(elelovRelatedSourceofIncomeType, "Zip textbox");
		verifyDisplayed(elelblRAddressLine1, "RAddressLine1");
		verifyDisplayed(eletbRAddressLine1, "RAddressLine1");
		verifyDisplayed(elelblRAddressLine2, "RAddress");
		verifyDisplayed(eletbRAddressLine2, "RAddress TextBox");
		verifyDisplayed(elelblRCity, "RCity");
		verifyDisplayed(eletbRCity, "RCity Text box");
		verifyDisplayed(elelblRState, "RState");
		verifyDisplayed(eleddRState, "RState dropdown");
		verifyDisplayed(elelovRState, "RState icon");
		
		return this;
	}
	public ViewSourceofIncomeInformationpage VerifyFiltersSourceofIncomeType() throws Exception
	{
		Thread.sleep(2000);
		click(eleicnFilter,"Filter");
		Thread.sleep(2000);
		selectDropdownValue(eleddSourceofIncomeType, "EMPLOYER");
		click(eleicnSearch,"Search");
		Thread.sleep(2000);
		verifyGridResult(eleGridResult,"EMPLOYER");
		return this;
	}
	public ViewSourceofIncomeInformationpage VerifyFiltersStatus() throws Exception
	{
		Thread.sleep(2000);
		click(eleicnFilter,"Filter");
		Thread.sleep(2000);
		selectDropdownValue(eleddStatus, "ACTIVE");
		click(eleicnSearch,"Search");
		Thread.sleep(2000);
		verifyGridResult(eleGridResult,"ACTIVE");
	    return this;
	}
	
	public ViewSourceofIncomeInformationpage VerifyFilterName() throws Exception
	{
		Thread.sleep(2000);
		click(eleicnFilter,"Filter");
		Thread.sleep(2000);
		clearAndType(eletbName, "Name label", "DIANA");
		selectDropdownValue(eleddUntitled, "EXACT");
		click(eleicnSearch,"Search");
		Thread.sleep(2000);
		verifyGridResult(eleGridResult,"DIANA");
	   return this;
	}
	public ViewSourceofIncomeInformationpage VerifyFilterNameinUntitled1() throws Exception
	{
		Thread.sleep(2000);
		click(eleicnFilter,"Filter");
		Thread.sleep(2000);
		clearAndType(eletbName, "Name label", "DIANA");
		selectDropdownValue(eleddUntitled1, "EXACT");
		click(eleicnSearch,"Search");
		Thread.sleep(2000);
		verifyGridResult(eleGridResult,"DIANA");
	   return this;
	}
	public ViewSourceofIncomeInformationpage VerifyFilterwithAllvalues() throws Exception
	{
		Thread.sleep(2000);
		click(eleicnFilter,"Filter");
		Thread.sleep(2000);
		clearAndType(eletbSourceofIncomeId, "Source of income id label", "1000000026");
		selectDropdownValue(eleddSourceofIncomeType, "UNION BENEFITS");
		selectDropdownValue(eleddStatus, "ACTIVE");
		clearAndType(eletbName, "Name label", "DIANA");
		selectDropdownValue(eleddUntitled, "EXACT");
		click(eleicnSearch,"Search");
		Thread.sleep(2000);
		verifyGridResult(eleGridResult,"DIANA");
		return this;
	}
	
	
	public AddSourceofIncomeInformationPage Addpage() throws Exception
	{
		
		click(eleicnAdd, "ADD");
		return new AddSourceofIncomeInformationPage();
	}
	
	public EditSourceofIncomeInformationPage Editpage() throws Exception
	{
		
		
		return new EditSourceofIncomeInformationPage();
	}
	@FindBy(xpath="//th/label") List<WebElement> elegheaders;
	public ViewSourceofIncomeInformationpage VerifyParticipantLinkedtoSourceofIncome() throws Exception
	{
		Thread.sleep(2000);
		click(elelblParticipntSourceofIncome,"Participant Linked to  Source of Income ");
		Thread.sleep(2000);
		verifyExactText(elelblPageHeader, "View Participants Linked to Source of Income");
		verifyDisplayed(elelblParticipantName, "Participant Name");
		verifyDisplayed(elelblPartcipantSourceofIncomeID, "Source of income Id Label");
		verifyDisplayed(elelblParticipntSourceofIncomeType, "Source of income type");
		verifyDisplayed(elelblParticipantFein, "FEIN");
		verifyDisplayed(elelblPartcipantSEIN, "SEIN");
		verifyDisplayed(elelblParticipntAddress, "Participant Address");

		verifyGridHeaders(elegheaders," Participant ID "," Participant Name ","  SSN  "," Docket Number "," County "," Case ID "," Active IWO ");
		
		verifyAssociatedScreens(eleAssociatedScreenList, "Note Processor");
		return this;
	}
	
	
	
	
	
}
