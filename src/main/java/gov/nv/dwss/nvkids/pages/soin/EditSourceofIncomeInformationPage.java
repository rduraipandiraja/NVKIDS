package gov.nv.dwss.nvkids.pages.soin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class EditSourceofIncomeInformationPage extends CommonLocators {
	
	public EditSourceofIncomeInformationPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[normalize-space(text())='ACTIVE']") WebElement eleResultActive;
	@FindBy(xpath="(//span[text()='ui-btn']/parent::button)[2]") WebElement elebtnClose;
	@FindBy(xpath="//label[@for='otherPartyTypeCode']") WebElement elelblSourceofIncomeType;
	@FindBy(xpath="//input[@id='otherPartyTypeCode']/following::label") WebElement eleddSourceofIncomeType;
	@FindBy(xpath="(//span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-chevron-down'])[2]/parent::div") WebElement elelovsourceofincometype;
	@FindBy(xpath="//label[@for='otherPartyId']") WebElement elelblSourceofIncomeId;
	@FindBy(xpath="//label[@for='verifiedByName']") WebElement elelblVerifiedBy;
	@FindBy(xpath="//label[@for='otherPartyName']") WebElement elelblName;
	@FindBy(xpath="//input[@id='otherPartyName']") WebElement eletbName;
	@FindBy(xpath="//label[@for='feinNumb']") WebElement elelblFein;
	@FindBy(xpath="//label[@for='verifiedDate']") WebElement elelblVerifiedDate;
	@FindBy(xpath="//label[@for='nsfInd']") WebElement elelblBadCheckIndicator;
	@FindBy(xpath="//label[@for='othpSoiSourceCode']") WebElement elelblSource;
	@FindBy(xpath="//input[@id='othpSoiSourceCode']") WebElement eletbSource;
	@FindBy(xpath="//label[@for='seinNumb']") WebElement elelblSEIN;
	@FindBy(xpath="//label[@for='othpSoiVerifSourceCode']") WebElement elelblVerifiedSource;
	@FindBy(xpath="//label[@for='doingBusinessAsName']") WebElement elelblDoingBusinessAs;
	@FindBy(xpath="//label[@for='businessTypeDesc']") WebElement elelbBusinessType;
	@FindBy(xpath="//label[@for='insuranceProvidedCode']") WebElement elelblProvidesHealthInsuranceCoverage;
	@FindBy(xpath="//span[text()='Add more']/parent::button") WebElement elelblAddMore;
	@FindBy(xpath="(//span[text()='ui-btn'])[2]") WebElement elelblx;
	@FindBy(xpath="//input[@id='line1Addr']") WebElement eletbAddressLine1;
	@FindBy(xpath="//input[@id='cityName']") WebElement eletbCity;
	@FindBy(xpath="//input[@id='stateCode']") WebElement eletbState;
	@FindBy(xpath="//input[@id='postCode']") WebElement eletbZip;
	@FindBy(xpath="//input[@id='countryCode']") WebElement eletbCountryCode;
	@FindBy(xpath="//span[text()='Yes']") WebElement elebtnYes;
	@FindBy(xpath="//label[text()='Related Source of Income']") WebElement elebtnRelativeSource;
	
	public EditSourceofIncomeInformationPage EditVerifyScreen() throws Exception
	{
		
	doubleClickGridResult(eleGridResult, "ACTIVE");
	verifyDisplayed(eleicnSave, "Save");
	verifyDisplayed(eleicnRefresh, "Refresh");
	verifyDisplayed(elebtnClose, "Close");
	verifyDisplayed(elelblSourceofIncomeType, "Source of Income Type");
	verifyDisplayed(elelblSourceofIncomeId, "Source of Income ID");
	verifyDisplayed(elelblVerifiedBy, "Verified By");
	verifyDisplayed(elelblName, "Name");
	verifyDisplayed(elelblFein, "FEIN");
	verifyDisplayed(elelblVerifiedDate, "VerifiedDate");
	verifyDisplayed(elelblBadCheckIndicator, "Bad Check Indicator");
	verifyDisplayed(elelblSource, "Source");
	verifyDisplayed(elelblSEIN, "SEIN");
	verifyDisplayed(elelblVerifiedSource, "Verified Source");
	verifyDisplayed(elelblDoingBusinessAs, "Doing Business As");
	verifyDisplayed(elelbBusinessType, "Buiness type");
	verifyDisplayed(elelblProvidesHealthInsuranceCoverage, "Health Insurance Coverage");
	verifyDisplayed(eleicnRefresh,"Save");
	verifyDisplayed(eleicnSave,"Save");
	verifyDisplayed(elelblx, "X");
	return this;	
		
		}
	
	public EditSourceofIncomeInformationPage EditScreenAddDataandSave() throws Exception
	{
		
	doubleClickGridResult(eleGridResult, "ACTIVE");
	clearAndType(eletbName, "NAME", "HILARY");
	
	click(eleicnSave, "Save");
	click(elebtnYes,"yes");
	//verifyExactText(eleErrStatusBar, "SAVED SUCCESSFULLY");
	return this;	
		
		}
	
	public EditSourceofIncomeInformationPage EditScreenVerifyRelatedSource() throws Exception
	{
	click(elebtnRelativeSource, "Relative source of income button");	
	doubleClickGridResult(eleGridResult, "ACTIVE");
	verifyDisplayed(eleicnSave, "Save");
	verifyDisplayed(eleicnRefresh, "Refresh");
	verifyDisplayed(elebtnClose, "Close");
	verifyDisplayed(elelblSourceofIncomeType, "Source of Income Type");
	verifyDisplayed(elelblSourceofIncomeId, "Source of Income ID");
	verifyDisplayed(elelblVerifiedBy, "Verified By");
	verifyDisplayed(elelblName, "Name");
	verifyDisplayed(elelblFein, "FEIN");
	verifyDisplayed(elelblVerifiedDate, "VerifiedDate");
	verifyDisplayed(elelblBadCheckIndicator, "Bad Check Indicator");
	verifyDisplayed(elelblSource, "Source");
	verifyDisplayed(elelblSEIN, "SEIN");
	verifyDisplayed(elelblVerifiedSource, "Verified Source");
	verifyDisplayed(elelblDoingBusinessAs, "Doing Business As");
	verifyDisplayed(elelbBusinessType, "Buiness type");
	verifyDisplayed(elelblProvidesHealthInsuranceCoverage, "Health Insurance Coverage");
	verifyDisplayed(eleicnRefresh,"Save");
	verifyDisplayed(eleicnSave,"Save");
	verifyDisplayed(elelblx, "X");
	return this;	
		
		}
	
	public EditSourceofIncomeInformationPage EditScreenAddDataandSaveinRelatedSource() throws Exception
	{
		click(elebtnRelativeSource, "Relative source of income button");
	doubleClickGridResult(eleGridResult, "ACTIVE");
	clearAndType(eletbName, "NAME", "CHRISTINA");
	click(eleicnSave, "Save");
	click(elebtnYes,"yes");
	//verifyExactText(eleErrStatusBar, "SAVED SUCCESSFULLY");
	return this;	
		
		}
	
	
}
