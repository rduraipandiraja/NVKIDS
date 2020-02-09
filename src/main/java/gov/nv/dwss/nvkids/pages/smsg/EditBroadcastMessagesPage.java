package gov.nv.dwss.nvkids.pages.smsg;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import gov.nv.dwss.nvkids.pages.fips.EditFIPSInformationPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class EditBroadcastMessagesPage extends CommonLocators {
	public EditBroadcastMessagesPage() {
		PageFactory.initElements(driver, this);
	}


	@FindAll({ @FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='View Broadcast Messages']"),
		@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='Edit Broadcast Messages']") }) 	public WebElement elebcComHeaderPanel;



	@FindBy(xpath="//label[@for='broadcastTitleName']") public WebElement elelblTitle;
	@FindBy(id="broadcastTitleName") public WebElement eledsoTitle;
	@FindBy(xpath="//label[@for='broadcastDesc']") public WebElement elelblDescription;
	@FindBy(id="broadcastDesc") public WebElement eledsoDescription;
	@FindBy(xpath="//label[@for='createdUserName']") public WebElement elelblCreatedBy;
	@FindBy(id="createdUserName") public WebElement eledsoCreatedBy;


	@FindBy(xpath="//label[@for='startDate']") public WebElement elelblBroadcastFrom;
	@FindBy(xpath="//input[@id='startDate']") public WebElement eledsoBroadcastFrom;
	@FindBy(xpath="//input[@id='startDate']/following-sibling::button") public WebElement eleicnlovBroadcastFrom;
	//@FindBy(xpath="//label[text()='Broadcast Through']") public WebElement elelblBroadcastThrough;
	@FindBy(xpath="//label[contains(text(),'Broadcast Through')]")public WebElement elelblBroadcastThrough; /*Temp*/
	@FindBy(xpath="//input[@id='endDate']") public WebElement eletxtBroadcastThrough;
	@FindBy(xpath="//input[@id='endDate']/following-sibling::button") public WebElement eleicncalBroadcastThrough;
	@FindBy(xpath="//label[text()='Visible To']") public WebElement elelblVisibleTo;
	@FindBy(id="roleCode") public WebElement eletxtVisibleTo;
	@FindBy(xpath="//input[@id='roleCode']/following-sibling::button") public WebElement eleicnlovVisibleTo;

	public EditBroadcastMessagesPage verifyEditBroadcastMessagesFields() throws Exception{
		verifyDisplayed(eleicnRefresh,"Refresh Icon");
		verifyDisplayed(eleicnSave,"Save Icon");
		verifyDisplayed(eleicnClose,"Close Icon");
		verifyDisplayed(elelblTitle, "Title");
		verifyDisplayed(elelblDescription, "Description");
		verifyDisplayed(elelblCreatedBy, "Created By");
		verifyDisplayed(elelblBroadcastFrom, "Broadcast From");
		verifyDisplayed(elelblBroadcastThrough, "Broadcast Through");
		verifyAssociatedScreens(eleAssociatedScreenList,"Note Processor");
		return this;
	}
	

	
	public EditBroadcastMessagesPage editValidValue() throws InterruptedException {
		
		clearValue(eletxtBroadcastThrough);
		clearAndType(eletxtBroadcastThrough, "Broadcast Through", addDaysToDate(eledsoBroadcastFrom, 21));
		click(eleicnSave,"Save Icon");
		verifyExactText(eleErrStatusBar,"SAVED SUCCESSFULLY");
		return this;
	}


	public EditBroadcastMessagesPage confirmationPopup(String Title, String Content) throws Exception {
		verifyExactText(eleCnfPopUpTitle, Title);
		verifyDisplayed(eleicnPopUpClose,"Close Icon");
		verifyExactText(eleinfPopUp, Content);
		verifyDisplayed(eleicnPopUpYes,"Yes Icon");
		verifyDisplayed(eleicnPopUpNo,"No Icon");
		return this;
	}

	public EditBroadcastMessagesPage acceptConfirmationPopUp() {
		click(eleicnPopUpYes,"Yes Icon");
		reportStep("Successfully Accepted ", "pass");
		return this;
	}

	public EditBroadcastMessagesPage declineConfirmationPopUp() {
		click(eleicnPopUpNo, "No Icon");
		reportStep("Successfully Declined ", "pass");
		return this;
	}

	public EditBroadcastMessagesPage closeConfirmationPopUp() {
		click(eleicnPopUpClose, "Close Icon");
		return this;
	}

	public EditBroadcastMessagesPage verifyValuePresent(WebElement ele,String value) {
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






























}
