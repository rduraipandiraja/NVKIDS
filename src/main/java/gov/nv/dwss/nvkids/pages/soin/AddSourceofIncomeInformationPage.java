package gov.nv.dwss.nvkids.pages.soin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class AddSourceofIncomeInformationPage extends CommonLocators {
	
	
	public AddSourceofIncomeInformationPage()
	{
		PageFactory.initElements(driver, this);
	}
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
	@FindBy(xpath="//span[text()='Yes']") WebElement elebtnSave;
	@FindBy(xpath="//span[text()='Add more']/parent::button") WebElement elebtnAddMore;
	@FindBy(xpath= "//div[text()=' NEWVILLE, PA, US ']")	WebElement elecity;
	@FindBy(id="verifiedDate") WebElement eleVerifiedDate;
	@FindBy(xpath="(//span[@class='ng-star-inserted']/parent::label)[2]") WebElement eleVerifiedSource;
	@FindBy(xpath="//span[text()='--SELECT--']") WebElement eleddverified;
	
	//Fields in related source of income
	@FindBy(xpath="//label[text()='Related Source of Income']") WebElement elelblFRelatedSourceofIncome;

	public AddSourceofIncomeInformationPage AddVerifyScreen() throws Exception
	{
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
		verifyDisplayed(elelblAddMore, "Add More");
		verifyDisplayed(eleicnClear, "Clear");
		verifyDisplayed(eleicnSave,"Save");
		verifyDisplayed(elelblx, "X");
		return this;
		
		
	}
	
	public AddSourceofIncomeInformationPage AddDataandSave() throws Exception
	{
		Thread.sleep(2000);
		selectDropdownValue(elelovsourceofincometype,"EMPLOYER");
		clearAndType(eletbName, "Name", "Laurel");
		clearAndType(eletbSource, "Source", "CPS");
		pressEnterKey(eletbSource);
		clearAndType(eletbAddressLine1, "Address Line1", "2ND CROSS ROAD");
		Thread.sleep(2000);
		clearAndType(eletbCity, "City", "NEWVILL");
		Actions action = new Actions(driver);
		action.moveToElement(elecity).click().perform();
		pressEnterKey(eletbCity);
		clearAndType(eletbZip, "ZIP", "333333333");
		Date date= new Date();
		DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String currentDate = sdf.format(date);
		System.out.println(currentDate);
		System.out.println(date);
		clearAndType(eleVerifiedDate, "Verified Date", currentDate);
		Thread.sleep(2000);
		selectDropdownValue(eleddverified,"AGENCY INTERFACE PARTNER");
		click(eleicnSave, "Save");
		click(elebtnSave, "Yes");
		Thread.sleep(2000);
		verifyExactText(eleddSourceofIncomeType, "EMPLOYER");
		verifyEnabled(elebtnAddMore);
		verifyDisabled(eleicnSave);
		
		return this;
		
		
	}
	
	public AddSourceofIncomeInformationPage AddVerifyScreenwithRelatedSourceofIncome() throws Exception
	{
		click(elelblFRelatedSourceofIncome, "Related Source of Income");
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
		verifyDisplayed(elelblAddMore, "Add More");
		verifyDisplayed(eleicnClear, "Clear");
		verifyDisplayed(eleicnSave,"Save");
		verifyDisplayed(elelblx, "X");
		return this;
		
		
	}
	
	public AddSourceofIncomeInformationPage AddDataandSaveRelatedSourceofIncome() throws Exception
	{
		Thread.sleep(2000);
		click(elelblFRelatedSourceofIncome, "Related Source of Income");
		selectDropdownValue(elelovsourceofincometype,"CORPORATE ADDRESS");
		clearAndType(eletbName, "Name", "Laurel");
		clearAndType(eletbSource, "Source", "CPS");
		pressEnterKey(eletbSource);
		clearAndType(eletbAddressLine1, "Address Line1", "2ND CROSS ROAD");
		Thread.sleep(2000);
		clearAndType(eletbCity, "City", "NEWVILL");
		Actions action = new Actions(driver);
		action.moveToElement(elecity).click().perform();
		pressEnterKey(eletbCity);
		clearAndType(eletbZip, "ZIP", "333333333");
		Date date= new Date();
		DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String currentDate = sdf.format(date);
		System.out.println(currentDate);
		System.out.println(date);
		clearAndType(eleVerifiedDate, "Verified Date", currentDate);
		Thread.sleep(2000);
		selectDropdownValue(eleddverified,"AGENCY INTERFACE PARTNER");
		click(eleicnSave, "Save");
		click(elebtnSave, "Yes");
		Thread.sleep(2000);
		verifyExactText(eleddSourceofIncomeType, "CORPORATE ADDRESS");
		verifyEnabled(elebtnAddMore);
		verifyDisabled(eleicnSave);
		
		return this;
		
		
	}
	
	
	
	
}
