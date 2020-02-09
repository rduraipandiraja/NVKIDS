package gov.nv.dwss.nvkids.pages.fips;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class AddFIPSInformationPage extends CommonLocators {

	public AddFIPSInformationPage() {
		PageFactory.initElements(driver, this);
	}

	/* Add Screen function Name - BreadCrumb */
	@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='View FIPS Code Information']") 	public WebElement eleViewFIPSCodeInfoBreadCrumbHeader;
	@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='Add FIPS Code Information']") 	public WebElement eleAddFIPSCodeInfoBreadCrumbHeader;

	@FindAll({ @FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='View FIPS Code Information']"),
		@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='Add FIPS Code Information']") }) 	public WebElement elebcComHeaderPanel;

	/* Fieldset section - Headers */
	@FindBy(xpath = "//legend[text()='FIPS Information']") 	public WebElement eleFieldSetFIPSInfo;
	@FindBy(xpath = "//legend[text()='Address Information']") 	public WebElement eleFieldSetAddressInfo;
	@FindBy(xpath = "//legend[text()='Contact Information']") 	public WebElement eleFieldSetContactInfo;

	/* Add - FIPS Information section field set: */
	@FindBy(xpath = "//label[text()='FIPS Type']") 	public WebElement elelblFIPSType;
	@FindBy(xpath = "//label[text()='FIPS Type']/following-sibling::p-dropdown/div") 	public WebElement eleddFIPSType;

	@FindBy(xpath = "//label[text()='FIPS Sub Type']") public	WebElement elelblFIPSSubType;
	@FindBy(xpath = "//input[@id='fipsSubtypeCode']") public 	WebElement eletxtFIPSSubType;
	@FindBy(xpath = "//input[@id='fipsSubtypeCode']/following-sibling::button/span") 	public WebElement eleicnlovFIPSSubType;

	@FindBy(xpath = "//label[text()='FIPS IV-D Agency Code']") public 	WebElement elelblFIPSIVDAgencyCode;
	@FindBy(xpath = "//input[@id='stateFipsCode']") public	WebElement eletxtFIPSIVDAgencyCode;
	@FindBy(xpath = "//input[@id='stateFipsCode']/following-sibling::button/span") 	public WebElement eleicnlovFIPSIVDAgencyCode;

	@FindBy(xpath = "//label[text()='FIPS County Code']") public	WebElement elelblFIPSCountyCode;
	@FindBy(xpath = "//input[@id='countyFipsCode']")  public	WebElement eletxtFIPSCountyCode;
	@FindBy(xpath = "//input[@id='countyFipsCode']/following-sibling::button/span") 	public WebElement eleicnlovFIPSCountyCode;

	@FindBy(xpath = "//label[text()='FIPS Office Code']") 	public WebElement elelblFIPSOfficeCode;
	@FindBy(xpath = "//input[@id='officeFipsCode']") 	public WebElement eletxtFIPSOfficeCode;

	@FindBy(xpath = "//label[text()='FIPS Name']") 	public WebElement elelblFIPSName;
	@FindBy(xpath = "//input[@id='fipsName']") 	public WebElement eletxtFIPSName;

	/* Add - Address Information section field set: */
	@FindBy(xpath = "//label[text()='Address']") 	public WebElement elelblAddress;
	@FindBy(xpath = "//input[@id='line1Addr']") 	public WebElement eletxtAddress;

	@FindBy(xpath = "//label[text()='Address Line 2']") 	public WebElement elelblAddressLine2;
	@FindBy(xpath = "//input[@id='line2Addr']") 	public WebElement eletxtAddressLine2;

	@FindBy(xpath = "//label[text()='City ']") 	public WebElement elelblCity;
	@FindBy(xpath = "//input[@id='cityName']") 	public WebElement eletxtCity;

	@FindBy(xpath = "//label[text()='State']") 	public WebElement elelblState;
	@FindBy(xpath = "//input[@id='stateCode']") 	public WebElement eletxtState; 
	@FindBy(xpath = "//input[@id='stateCode']/following-sibling::button/span") 	public WebElement eleicnlovState;

	@FindBy(xpath = "//label[text()='ZIP']") 	public WebElement elelblZip;
	@FindBy(xpath = "//input[@id='postCode']") 	public WebElement eletxtZip;

	@FindBy(xpath = "//label[text()='Country']") 	public WebElement elelblCountry;
	@FindBy(xpath = "//input[@id='countryCode']") 	public WebElement eledsoCountry;

	// Add - Contact Information section field set:

	@FindBy(xpath = "//label[text()='Contact Name']") 	public WebElement elelblContactName;
	@FindBy(xpath = "//input[@id='contactTitleName']") 	public WebElement eletxtContactName;

	@FindBy(xpath = "//label[text()='Contact Email']") 	public WebElement elelblContactEmail;
	@FindBy(xpath = "//input[@id='contactEml']") 	public WebElement eletxtContactEmail;

	@FindBy(xpath = "//label[text()='Phone']") 	public WebElement elelblPhone;
	@FindBy(xpath = "//input[@id='countryStdNumb']") 	public WebElement eletxtPhoneCountryCode;
	@FindBy(xpath = "//input[@id='phoneNumb']") 	public WebElement eletxtPhoneNumb;

	@FindBy(xpath = "//label[text()='Ext']") 	public WebElement elelblPhoneExt;
	@FindBy(xpath = "//input[@id='phoneExtnNumb']") 	public WebElement eletxtPhoneExt;

	@FindBy(xpath = "//label[text()='Fax']") 	public WebElement elelblFax;
	@FindBy(xpath = "//input[@id='faxNumb']") 	public WebElement eletxtFax;

	@FindBy(xpath = "//label[text()='Comments']") 	public WebElement elelblComments;
	@FindBy(xpath = "//textarea[@id='commentNote']") 	public WebElement eletxtComments;
	@FindBy(xpath ="//span[text()='View Error Details']") public WebElement elelinkErrorPanel;


	public AddFIPSInformationPage selectFIPSType(String value) {
		selectDropdownValue(eleddFIPSType, value);
		return this;
	}

	public AddFIPSInformationPage selectFIPSSubType(String value) throws InterruptedException {
		click(eleicnlovFIPSSubType, "FIPS Sub Type LOV");
		clearAndType(eleSearchBarSearch, "Search text box", value);
		pressEnterKey(eleSearchBarSearch);
		doubleClickGridResult(eleGridCells, value);
		return this;
	}

	public AddFIPSInformationPage enterFIPSSubType(String data) {
		clearAndType(eletxtFIPSSubType, "FIPS SubType", data);
		return this;
	}

	public AddFIPSInformationPage selectFIPSAgencyCode(String value) throws InterruptedException {
		click(eleicnlovFIPSIVDAgencyCode,"FIPS IV-D Agency Code");
		clearAndType(eleSearchBarSearch, "Search text box", value);
		pressEnterKey(eleSearchBarSearch);
		doubleClickGridResult(eleGridCells, value);

		return this;
	}

	public AddFIPSInformationPage enterFIPSAgencyCode(String data) {
		clearAndType(eletxtFIPSIVDAgencyCode, "FIPS IV-E Agency Code", data);
		return this;
	}

	public AddFIPSInformationPage selectFIPSCountyCode(String value) throws InterruptedException {
		click(eleicnlovFIPSCountyCode, "FIPS County Code");
		clearAndType(eleSearchBarSearch, "Search text box", value);
		pressEnterKey(eleSearchBarSearch);
		doubleClickGridResult(eleGridCells, value);

		return this;
	}

	public AddFIPSInformationPage enterFIPSCountyCode(String data) {
		clearAndType(eletxtFIPSCountyCode, "FIPS County Code", data);
		return this;
	}

	public AddFIPSInformationPage enterOfficeCode(String data) {
		clearAndType(eletxtFIPSOfficeCode, "FIPFS Office Code", data);
		return this;
	}

	public AddFIPSInformationPage enterFIPSName(String data) {
		clearAndType(eletxtFIPSName, "FIPS Name", data);
		return this;
	}

	public AddFIPSInformationPage enterAddress(String data) {
		clearAndType(eletxtAddress, "Addres", data);
		return this;
	}

	public AddFIPSInformationPage enterAddressLine2(String data) {
		clearAndType(eletxtAddressLine2, "Address line 2", data);
		return this;
	}

	public AddFIPSInformationPage enterCity(String data) {
		clearAndType(eletxtAddressLine2, "Address line 2", data);
		return this;
	}

	public AddFIPSInformationPage selectState(String value) throws InterruptedException {
		click(eleicnlovState, "State");
		clearAndType(eleSearchBarSearch, "Search text box", value);
		pressEnterKey(eleSearchBarSearch);
		doubleClickGridResult(eleGridCells, value);
		return this;
	}

	public AddFIPSInformationPage enterState(String data) throws InterruptedException {
		clearValue(eletxtState);
		clearAndType(eletxtState, "State", data);
		return this;
	}

	public AddFIPSInformationPage enterZIP(String data) {
		clearAndType(eletxtZip, "ZIP", data);
		return this;
	}

	public AddFIPSInformationPage enterContactName(String data) {
		clearAndType(eletxtContactName, "Contact Name", data);
		return this;
	}

	public AddFIPSInformationPage enterContactEmail(String data) {
		clearAndType(eletxtContactEmail, "Contact Email", data);
		return this;
	}

	public AddFIPSInformationPage enterPhoneCountryCode(String data) {
		clearAndType(eletxtPhoneCountryCode, "Phone Country Code", data);
		return this;
	}

	public AddFIPSInformationPage enterPhoneNumber(String data) {
		clearAndType(eletxtPhoneNumb, "Phone Number", data);
		return this;
	}

	public AddFIPSInformationPage enterPhoneExt(String data) {
		clearAndType(eletxtPhoneExt, "Phone Ext", data);
		return this;
	}

	public AddFIPSInformationPage enterFax(String data) {
		clearAndType(eletxtFax, "Fax", data);
		return this;
	}

	public AddFIPSInformationPage enterComments(String data) {
		clearAndType(eletxtComments, "Comments", data);
		return this;
	}

	public AddFIPSInformationPage clickClear() {
		click(eleicnClear,"Clear icon");
		return this;
	}

	public AddFIPSInformationPage clickSave() {
		click(eleicnSave, "Save icon");
		return this;
	}

	public AddFIPSInformationPage clickClose() {
		click(eleicnClose, "Close Icon");
		return this;

	}



	public AddFIPSInformationPage acceptConfirmationPopUp() {
		click(eleicnPopUpYes, "Yes Icon");
		reportStep("Successfully Accepted ", "pass");
		return this;
	}

	public AddFIPSInformationPage declineConfirmationPopUp() {
		click(eleicnPopUpNo, "No Icon");
		reportStep("Successfully Declined ", "pass");
		return this;
	}

	public AddFIPSInformationPage closeConfirmationPopUp() {
		click(eleicnPopUpClose, "Close Icon");
		return this;
	}

	public AddFIPSInformationPage verifyStatusBarInfo(String info) {
		verifyExactText(eleErrStatusBar, info);
		return this;
	}

	public AddFIPSInformationPage verifyScreenFields() throws Exception {

		Thread.sleep(2000);
		verifyDisplayed(eleicnClear, "Clear icon");
		verifyDisplayed(eleicnSave, "Save icon");
		verifyDisplayed(eleicnClose, "Close Icon");

		verifyDisplayed(elelblFIPSType, "FIPS Type");
		verifyDisplayed(elelblFIPSSubType, "FIPS Sub Type");
		verifyDisplayed(elelblFIPSIVDAgencyCode, "FIPS IV-D Agency Code" );
		verifyDisplayed(elelblFIPSCountyCode, "FIPS County Code");
		verifyDisplayed(elelblFIPSOfficeCode, "FIPS Office Code");
		verifyDisplayed(elelblFIPSName, "FIPS Name");

		verifyDisplayed(elelblAddress, "Address");
		verifyDisplayed(elelblAddressLine2, "Address line two");
		verifyDisplayed(elelblCity, "City");
		verifyDisplayed(elelblState, "State");
		verifyDisplayed(elelblZip, "ZIP");
		verifyDisplayed(elelblCountry, "Country");

		verifyDisplayed(elelblContactName, "Contact Name");
		verifyDisplayed(elelblContactEmail, "Contact Email");
		verifyDisplayed(elelblPhone, "Phone Country Code");
		verifyDisplayed(elelblPhone, "Phone Number");
		verifyDisplayed(elelblPhoneExt, "Phone Ext");
		verifyDisplayed(elelblFax, "Fax");
		verifyDisplayed(elelblComments, "Comments");


		return this;
	}

	public AddFIPSInformationPage addFIPSCodeInfo(String fipsType,String fipsSubType,String agencyCode,String countyCode,String officeCode, String fipsName,String address , String  address2,
			 String city, String zip, String contactName, String contactEmail, String phoneCode, String phoneNumber,String ext, String fax, String comments) throws Exception {

		Thread.sleep(2000);
		selectFIPSType(fipsType);
		selectFIPSSubType(fipsSubType);
		enterFIPSAgencyCode(agencyCode);
		enterFIPSCountyCode(countyCode);
		enterOfficeCode(officeCode);
		enterFIPSName(fipsName);
		enterAddress(address);
		enterAddressLine2(address2);
		autoSelectCity(city, city);
		enterZIP(zip);
		enterContactName(contactName);
		enterContactEmail(contactEmail);
		enterPhoneCountryCode(phoneCode);
		enterPhoneNumber(phoneNumber);
		enterPhoneExt(ext);
		enterFax(fax);
		enterComments(comments);
		clickSave();
		verifyStatusBarInfo("SAVED SUCCESSFULLY");
		return this;

	}





	public AddFIPSInformationPage autoSelectCity(String value, String Expected) {

		clearAndType(eletxtCity, "City", value);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfAllElements(elelistAutoFill));
		String[] act;
		outerloop:
			for (WebElement ele : elelistAutoFill) {
				String actual = ele.getText().trim();
				if (actual.contains(Expected)) {
					act = actual.split(",");
					for (int i = 0; i < act.length; i++) {
						System.out.println("'" + act[i] + "'");
						if (act[i].trim().contains(Expected)) {
							Actions action = new Actions(driver);
							action.moveToElement(ele);
							ele.click();
							reportStep("City is clicked", "Pass");
							break outerloop;
						}
					}

				}
			}

		return this;

	}

	public AddFIPSInformationPage verifyValuePresent(WebElement ele,String value) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOf(ele));
			String actual = ele.getAttribute("value");
			if(actual.equals(value)) {
				reportStep("The Expected Value '"+value+"' present in the Field", "pass");
			}
			else {
				reportStep("The Expected Value '"+value+"' Not present in the Field", "pass");
			}
		}
		catch(Exception e)
		{
			reportStep("Unable to find the field value","fail");
			Assert.fail("Unable to find the field value");
		}

		return this;
	}

	public void selectRandomFIPSType(WebElement ele) 
	{
		try 
		{	
			wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
			List<WebElement> options = driver.findElements(By.xpath("//li[@role='option']/span[not(contains(text(),'--SELECT--') or contains(text(),'FEDERAL'))]"));
			int dropdownsize = options.size();
			int randnMumber = ThreadLocalRandom.current().nextInt(0, dropdownsize);
			options.get(randnMumber).click();
			if(!options.get(randnMumber).getText().equals(""))
			{
				reportStep("The dropdowntext '" + options.get(randnMumber).getText() + "'is successfully selected", "pass");
			}
			else
			{
				reportStep("The dropdowntext '" + options.get(randnMumber).getText() + "'is not selected", "fail");
				Assert.fail();				
			}

		}
		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable to access the element " , "fail");
			Assert.fail();	
		} 
		finally 
		{
			takeSnap();
		}

	}

}
