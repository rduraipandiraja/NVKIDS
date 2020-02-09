package gov.nv.dwss.nvkids.pages.fips;

import java.awt.Desktop.Action;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class EditFIPSInformationPage extends CommonLocators{

	public EditFIPSInformationPage(){
		PageFactory.initElements(driver, this);
	}


	// Edit Screen function Name - BreadCrumb
	@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='View FIPS Code Information']") public WebElement elebcViewFIPSCodeInfo;
	@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='Edit FIPS Code Information']") public WebElement elebcEditFIPSCodeInfo;

	@FindAll(
			{
				@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='View FIPS Code Information']"),
				@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='Edit FIPS Code Information']")
			}) public WebElement elebcComHeaderPanel;

	// Fieldset section - Headers
	@FindBy(xpath="//legend[text()='FIPS Information']") public WebElement eleFieldSetFIPSInfo;
	@FindBy(xpath="//legend[text()='Address Information']") public WebElement eleFieldSetAddressInfo;
	@FindBy(xpath="//legend[text()='Contact Information']") public WebElement eleFieldSetContactInfo;


	//Edit - FIPS Information section field set:


	@FindBy(xpath="//label[text()='FIPS Name']") WebElement elelblFIPSName;
	@FindBy(xpath="//input[@id='fipsName']") WebElement eletxtFIPSName;

	//Edit - Address Information section field set:
	@FindBy(xpath="//label[text()='Address']") WebElement elelblAddress;
	@FindBy(xpath="//input[@id='line1Addr']") WebElement eletxtAddress;

	@FindBy(xpath="//label[text()='Address Line 2']") WebElement elelblAddressLine2;
	@FindBy(xpath="//input[@id='line2Addr']") WebElement eletxtAddressLine2;

	@FindBy(xpath="//label[text()='City ']") WebElement elelblCity;
	@FindBy(xpath="//input[@id='cityName']") WebElement eletxtCity;

	@FindBy(xpath="//label[text()='State']") WebElement elelblState;
	@FindBy(xpath="//input[@id='stateCode']") WebElement eledsoState;
	@FindBy(xpath="//input[@id='stateCode']/following-sibling::button/span") WebElement eleStateIcon;

	@FindBy(xpath="//label[text()='ZIP']") WebElement elelblZip;
	@FindBy(xpath="//input[@id='postCode']") WebElement eletxtZip;

	@FindBy(xpath="//label[text()='Country']") WebElement elelblCountry;
	@FindBy(xpath="//input[@id='countryCode']") WebElement eledsoCountry;


	//Edit - Contact Information section field set:

	@FindBy(xpath="//label[text()='Contact Name']") WebElement elelblContactName;
	@FindBy(xpath="//input[@id='contactTitleName']") WebElement eletxtContactName;

	@FindBy(xpath="//label[text()='Contact Email']") WebElement elelblContactEmail;
	@FindBy(xpath="//input[@id='contactEml']") WebElement eletxtContactEmail;

	@FindBy(xpath="//label[text()='Phone']") WebElement elelblPhone;
	@FindBy(xpath="//input[@id='countryStdNumb']") WebElement eletxtPhoneCountryCode;
	@FindBy(xpath="//input[@id='phoneNumb']") WebElement eletxtPhoneNumb;

	@FindBy(xpath="//label[text()='Ext']") WebElement elelblPhoneExt;
	@FindBy(xpath="//input[@id='phoneExtnNumb']") WebElement eletxtPhoneExt;

	@FindBy(xpath="//label[text()='Fax']") WebElement elelblFax;
	@FindBy(xpath="//input[@id='faxNumb']") WebElement eletxtFax;

	@FindBy(xpath="//label[text()='Comments']") WebElement elelblComments;
	@FindBy(xpath="//textarea[@id='commentNote']") WebElement eletxtComments;

	@FindBy(xpath ="//span[text()='View Error Details']") public WebElement elelinkErrorPanel;

	public EditFIPSInformationPage enterFIPSName(String data) {
		clearAndType(eletxtFIPSName, "FIPS Name", data);
		return this;
	}

	public EditFIPSInformationPage enterAddress(String data) {
		clearAndType(eletxtAddress, "Address", data);
		return this;
	}

	public EditFIPSInformationPage enterAddressLine2(String data) {
		clearAndType(eletxtAddressLine2, "Address Line 2", data);
		return this;
	}

	public EditFIPSInformationPage enterCity(String data) {
		clearAndType(eletxtCity, "City", data);
		return this;
	}



	public EditFIPSInformationPage enterZIP(String data) {
		clearAndType(eletxtZip, "ZIP", data);
		return this;
	}

	public EditFIPSInformationPage enterContactName(String data) {
		clearAndType(eletxtContactName, "Contact Name", data);
		return this;
	}

	public EditFIPSInformationPage enterContactEmail(String data) {
		clearAndType(eletxtContactEmail, "Contact Email", data);
		return this;
	}

	public EditFIPSInformationPage enterPhoneCountryCode(String data) {
		clearAndType(eletxtPhoneCountryCode, "Phone Country Code", data);
		return this;
	}

	public EditFIPSInformationPage enterPhoneNumber(String data) {
		clearAndType(eletxtPhoneNumb, "Phone Number", data);
		return this;
	}

	public EditFIPSInformationPage enterPhoneExt(String data) {
		clearAndType(eletxtPhoneExt, "Phone Ext", data);
		return this;
	}

	public EditFIPSInformationPage enterFax(String data) {
		clearAndType(eletxtFax, "Fax", data);
		return this;
	}

	public EditFIPSInformationPage enterComments(String data) {
		clearAndType(eletxtComments, "Comments", data);
		return this;
	}

	public EditFIPSInformationPage clickRefresh() {
		click(eleicnRefresh,"Refresh Icon");
		return this;
	}

	public EditFIPSInformationPage clickSave() {
		click(eleicnSave, "Save Icon");
		return this;
	}

	public EditFIPSInformationPage clickClose() {
		click(eleicnClose,"Close Icon");
		return this;
	}



	public EditFIPSInformationPage acceptConfirmationPopUp() {
		click(eleicnPopUpYes, "Yes Icon");
		reportStep("Successfully Accepted ", "pass");
		return this;
	}

	public EditFIPSInformationPage declineConfirmationPopUp() {
		click(eleicnPopUpNo, "No Icon");
		reportStep("Successfully Declined ", "pass");
		return this;
	}

	public EditFIPSInformationPage closeConfirmationPopUp() {
		click(eleicnPopUpClose, "Close Icon");
		return this;
	}

	public EditFIPSInformationPage verifyStatusBarInfo(String info) {
		verifyExactText(eleErrStatusBar, info);
		return this;
	}

	public EditFIPSInformationPage verifyScreenFields() throws Exception {

		Thread.sleep(2000);
		verifyDisplayed(eleicnRefresh,"Refresh Icon");
		verifyDisplayed(eleicnSave,"Save Icon");
		verifyDisplayed(eleicnClose, "Close Icon");
		verifyDisplayed(elelblFIPSName, "FIPS Name");
		verifyDisplayed(elelblAddress, "Address Line one");
		verifyDisplayed(elelblAddressLine2, "Address Line 2");
		verifyDisplayed(elelblCity, "City");
		verifyDisplayed(elelblState, "State");
		verifyDisplayed(elelblZip, "ZIP");
		verifyDisplayed(elelblCountry, "Country");
		verifyDisplayed(elelblContactName, "Contact Name");
		verifyDisplayed(elelblContactEmail, "Email");
		verifyDisplayed(elelblPhone, "Phone Country Code");
		verifyDisplayed(elelblPhone, "Phone Number");
		verifyDisplayed(elelblPhoneExt, "Phone Ext");
		verifyDisplayed(elelblFax, "Fax");
		verifyDisplayed(elelblComments, "Comments");

		return this;
	}

	public EditFIPSInformationPage modifyFIPSCodeInfo(String fipsType,String fipsSubType, String fipsName,String address , String  address2,
			 String city, String zip, String contactName, String contactEmail, String phoneCode, String phoneNumber,String ext, String fax, String comment) throws Exception {

		Thread.sleep(2000);
		enterFIPSName(fipsName);
		enterAddress(address);
		autoSelectCity(city, city);
		Actions action = new Actions(driver);
		action.moveToElement(eletxtZip).sendKeys(Keys.CONTROL,"a").build().perform();
		enterZIP(zip);
		clickSave();
		verifyStatusBarInfo("SAVED SUCCESSFULLY");
		return this;

	}




	public EditFIPSInformationPage modifywithoutChanges() throws Exception {

		Thread.sleep(2000);

		clickSave();
		verifyStatusBarInfo("NO VALUE WAS CHANGED, ADDED OR DELETED");
		return this;
	}




	public EditFIPSInformationPage autoSelectCity(String value, String Expected) {

		clearAndType(eletxtCity, "City", value);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElements(elelistAutoFill));
		String[] act;
		outerloop:
			for (WebElement ele : elelistAutoFill) {
				String actual = ele.getText().trim();
				if (actual.contains(Expected)) {
					act = actual.split(",");
					for (int i = 0; i < act.length; i++) {
						System.out.println("'" + act[i] + "'");
						if (act[i].trim().equals(Expected)) {
							ele.click();
							reportStep("Element is clicked", "pass");
							break outerloop;
						}
					}

				}
			}

		return this;

	}




}
