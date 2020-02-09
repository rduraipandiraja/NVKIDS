package gov.nv.dwss.nvkids.pages.ahis;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class ViewParticipantFederalTaxAddressPage extends CommonLocators
{
public ViewParticipantFederalTaxAddressPage(){
	PageFactory.initElements(driver, this); 
}
//Screen Function

	@FindBy(xpath="//p-breadcrumb/descendant::a/span[text()='View Participant Federal Tax Address']") public WebElement elebcViewParticipantFederalTaxAddress;
			
	//Filter Section
			
	@FindBy(xpath="//label[text()='Participant ID']") public WebElement elelblParticipantid;
	@FindBy(xpath="//label[text()='Participant ID']/following::input[contains(@class,'ui-inputtext')]") public WebElement eletxtParticipantid;
	@FindBy(xpath="//span[text()='ui-btn']/preceding-sibling::span[contains(@class,'fa-search')]") public WebElement eleicnlovParticipantid;
	@FindBy(xpath="//label[text()='Verification Status']") public WebElement elelblVerificationStatus;
	@FindBy(xpath="//label[@for='addressStatusCode']/following-sibling::p-dropdown/descendant::label") public WebElement eleddVerificationStatus;
	@FindBy(xpath="//label[@for='primaryInd']/following-sibling::p-dropdown/descendant::label") public WebElement eleddPrimary;
	
	@FindBy(xpath="//label[@for='lastName']") public WebElement elelbllastname;
	@FindBy(xpath="//input[@id='lastName']") public WebElement eletxtlastname;
	
	@FindBy(xpath="//div[contains(@class,'ui-dialog-content')]/descendant::button/span[text()='Search']") public WebElement elebtnPopupSerch;	
	@FindBy(xpath="//div[contains(@class,'ui-dialog-content')]/descendant::tbody/tr[1]") public WebElement elePopupGrid;	
	@FindBy(xpath="//tbody/tr[1]/td[3]/span[@class='ng-star-inserted']") public WebElement eleGridval;
	
	//Grid Section
	

	@FindBy(xpath="//label[text()=' Address Type Code ']") public WebElement elehdrAddressTypeCode;
	@FindBy(xpath="//label[text()=' Address Type ']") public WebElement elehdrAddressType;
	@FindBy(xpath="//label[text()=' Verification Status Code ']") public WebElement elehdrVerificationStatusCode;		
	@FindBy(xpath="//label[text()=' Verification Status ']") public WebElement elehdrVerificationStatus;		
	@FindBy(xpath="//label[text()=' Source Code ']") public WebElement elehdrSourceCode;	
	@FindBy(xpath="//label[text()=' Source ']") public WebElement elehdrSource;
	@FindBy(xpath="//label[text()=' Status Date ']") public WebElement elehdrStatusDate;
	@FindBy(xpath="//label[text()=' Begin Date ']") public WebElement elehdrBeginDate;
	@FindBy(xpath="//label[text()=' End Date ']") public WebElement elehdrEndDate;
	
	@FindBy(xpath="//label[@for='addressTypeCode']/following-sibling::p-dropdown/descendant::label") public WebElement eleddAddressTypeCode;
	@FindBy(xpath="//label[@for='addressTypeDesc']/following-sibling::p-dropdown/descendant::label") public WebElement eleddAddressType;
	@FindBy(xpath="//label[text()='Verification Status Code']/following-sibling::p-dropdown/descendant::label") public WebElement eleddGridVerificationStatusCode;
	@FindBy(xpath="//th//label[text()='Verification Status']/following-sibling::p-dropdown/descendant::label") public WebElement eleddGridVerificationStatus;
	@FindBy(xpath="//input[@id='addressSourceCode']") public WebElement eletxtSourceCode;
	@FindBy(xpath="//input[@id='addressSourceCode']/following-sibling::button") public WebElement elelovSourceCode;
	@FindBy(xpath="//input[@id='addressSourceDesc']") public WebElement eletxtSource;
	@FindBy(xpath="//input[@id='addressSourceDesc']/following-sibling::button") public WebElement elelovSource;
	@FindBy(xpath="//input[@id='addressStatusDate']") public WebElement eleicncalStatusDate;
	@FindBy(xpath="//input[@id='addressStatusDate']/following-sibling::button") public WebElement eleicncalvalStatusDate;
	@FindBy(xpath="//input[@id='beginDate']") public WebElement eleicncalbeginDate;
	@FindBy(xpath="//input[@id='beginDate']/following-sibling::button") public WebElement eleicncalvalbeginDate;
	@FindBy(xpath="//input[@id='endDate']") public WebElement eleicncalEndDate;
	@FindBy(xpath="//input[@id='endDate']/following-sibling::button") public WebElement eleicncalvalEndDate;
	
	@FindBy(xpath="//input[@id='line1Addr']") public WebElement eletxtaddress1;
	@FindBy(xpath="//input[@id='line2Addr']") public WebElement eletxtaddress2;
	@FindBy(xpath="//input[@id='cityName']") public WebElement eletxtcity;
	@FindBy(xpath="//input[@id='stateCode']") public WebElement eletxtState;
	@FindBy(xpath="//input[@id='stateCode']/following-sibling::button") public WebElement elelovState;
	@FindBy(xpath="//input[@id='postCode']") public WebElement eletxtzip;
	@FindBy(xpath="//th//label[@for='countyName']/following-sibling::p-dropdown/descendant::label") public WebElement eleddCounty;
	@FindBy(xpath="//input[@id='countryCode']") public WebElement eletxtCountry;
	@FindBy(xpath="//input[@id='countryCode']/following-sibling::button") public WebElement elelovCountry;
	
	
	@FindBy(xpath="//label[text()='  Address Line 1 ']") public WebElement elehdrAddress1;
	@FindBy(xpath="//label[text()=' Address Line 2 ']") public WebElement elehdrAddress2;
	@FindBy(xpath="//label[text()=' City ']") public WebElement elehdrcity;
	@FindBy(xpath="//label[text()=' State ']") public WebElement elehdrstate;		
	@FindBy(xpath="//label[text()=' Zip ']") public WebElement elehdrzip;		
	@FindBy(xpath="//label[text()=' County ']") public WebElement elehdrcounty;	
	@FindBy(xpath="//label[text()=' Country ']") public WebElement elehdrcountry;
	
	@FindBy(xpath="//label[text()=' Country ']") public WebElement elelblshowpanel;
	@FindBy(xpath="//span[@class='ui-paginator-pages']") public WebElement elelblpagenavigate;
	
	
	
	
	public ViewParticipantFederalTaxAddressPage ViewParticipantFederalTaxAddress() throws Exception
	{
		verifyExactText(elebcViewParticipantFederalTaxAddress,"View Participant Federal Tax Address");
		verifyDisplayed(eleicnFilter,"Filter");
		verifyGridHeaders(elelblGridHeaders," Address Type "," Address "," Verification Status "," Source "," Status Date "," Begin Date ");
		verifyAssociatedScreens(eleAssociatedScreenList,"Note Processor");
		return this;
	}
	
	public ViewParticipantFederalTaxAddressPage verifyFilterSection() throws Exception
	{
		click(eleicnFilter,"Filter");
		verifyDisplayed(elelblParticipantid,"Participant ID");
		verifyDisplayed(elelblVerificationStatus,"Verification Status");
		return this;
	}
	
	public ViewParticipantFederalTaxAddressPage verifyresult() throws Exception
	{
		click(eleicnFilter,"Filter");
		clearAndType(eletxtParticipantid,"Participant ID","1000000002");
	    Thread.sleep(2000);
	    click(eleicnSearch,"Search");
	    Thread.sleep(2000);
	    verifyGridContainsData(eleGridResult,"FEDERAL TAX");
		return this;
	}
	
}




