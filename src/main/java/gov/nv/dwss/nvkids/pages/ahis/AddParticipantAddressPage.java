package gov.nv.dwss.nvkids.pages.ahis;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class AddParticipantAddressPage extends CommonLocators
{
	public AddParticipantAddressPage(){
		PageFactory.initElements(driver, this); 
	}
	
	//Screen Function
	
		@FindBy(xpath="//p-breadcrumb/descendant::a/span[text()='Add Participant Address']") public WebElement elebcAddParticipantAddressPage;
	
	@FindBy(xpath="//label[text()='Address Type']") public WebElement elelblAddressType;
	@FindBy(xpath="//label[@for='addressTypeCode']/following-sibling::p-dropdown/descendant::label") public WebElement eleddAddressType;
	@FindBy(xpath="//label[text()='Primary']") public WebElement elelblPrimary;
	@FindBy(xpath="//label[@for='primaryInd']/following-sibling::p-dropdown/descendant::label") public WebElement eleddPrimary;
	@FindBy(xpath="//label[text()='ATTN/Care Of']") public WebElement elelblAttncare;
	@FindBy(xpath="//input[@id='attnAddr']") public WebElement eletxtAttncare;
	@FindBy(xpath="//label[text()=' Date Received ']") public WebElement elelblDateReceived;
	@FindBy(xpath="//input[@id='addressReceivedDate']") public WebElement eleicncalDateReceived;
	@FindBy(xpath="//input[@id='addressReceivedDate']/following-sibling::button") public WebElement eleicncalvalDateReceived;
	@FindBy(xpath="//label[text()='Source']") public WebElement elelblSource;
	@FindBy(xpath="//input[@id='addressSourceCode']") public WebElement eletxtSource;
	@FindBy(xpath="//input[@id='addressSourceCode']/following-sibling::button") public WebElement elelovSource;
	@FindBy(xpath="//label[text()=' Begin Date ']") public WebElement elelblBeginDate;
	@FindBy(xpath="//label[text()=' End Date ']") public WebElement elelblEndDate;
	@FindBy(xpath="//input[@id='beginDate']") public WebElement eleicncalbeginDate;
	@FindBy(xpath="//input[@id='beginDate']/following-sibling::button") public WebElement eleicncalvalbeginDate;
	@FindBy(xpath="//input[@id='endDate']") public WebElement eleicncalEndDate;
	@FindBy(xpath="//label[text()='Address Line 1']") public WebElement elelblAddress1;
	@FindBy(xpath="//label[text()='Address Line 2']") public WebElement elelblAddress2;
	@FindBy(xpath="//input[@id='line1Addr']") public WebElement eletxtaddress1;
	@FindBy(xpath="//input[@id='line2Addr']") public WebElement eletxtaddress2;
	@FindBy(xpath="//label[text()='City ']") public WebElement elelblcity;
	@FindBy(xpath="//label[text()='State']") public WebElement elelblstate;		
	@FindBy(xpath="//label[text()='Zip']") public WebElement elelblzip;		
	@FindBy(xpath="//label[text()='County']") public WebElement elelblcounty;	
	@FindBy(xpath="//label[text()='Country']") public WebElement elelblcountry;
	@FindBy(xpath="//input[@id='cityName']") public WebElement eletxtcity;
	@FindBy(xpath="//input[@id='stateCode']") public WebElement eletxtState;
	@FindBy(xpath="//input[@id='stateCode']/following-sibling::button") public WebElement elelovState;
	@FindBy(xpath="//input[@id='postCode']") public WebElement eletxtzip;
	@FindBy(xpath="//label[@for='countyCode']/following-sibling::p-dropdown/descendant::label") public WebElement eleddCounty;
	@FindBy(xpath="//input[@id='countryCode']") public WebElement eletxtCountry;
	@FindBy(xpath="//input[@id='countryCode']/following-sibling::button") public WebElement elelovCountry;
	@FindBy(xpath="//label[text()='Status']") public WebElement elelblStatus;
	@FindBy(xpath="//label[@for='addressStatusCode']/following-sibling::p-dropdown/descendant::label") public WebElement eleddstatus;
	@FindBy(xpath="//label[text()=' Status Date ']") public WebElement elelblStatusDate;
	@FindBy(xpath="//input[@id='addressStatusDate']") public WebElement eleicncalStatusDate;
	@FindBy(xpath="//label[text()='Verified By']") public WebElement elelblVerifyedby;
	@FindBy(xpath="//label[@for='addressVerifySourceCode']/following-sibling::p-dropdown/descendant::label") public WebElement eleddVerifyedBy;
	@FindBy(xpath="//label[text()=' Verified Date ']") public WebElement elelblVerifyDate;
	@FindBy(xpath="//input[@id='addressVerifiedDate']") public WebElement eletxtVerifyDate;
	@FindBy(xpath="//label[text()='Comments']") public WebElement elelblcomments;
	@FindBy(xpath="//textarea[@id='commentNote']") public WebElement eletxtcomments;
	@FindBy(xpath="//label[text()=' Updated On ']") public WebElement elelblUpdatedOn;
	@FindBy(xpath="//input[@id='beginValidityDttm']") public WebElement eletxtUpdatedOn;
	@FindBy(xpath="//label[text()='Updated By']") public WebElement elelblUpdatedBy;
	@FindBy(xpath="//input[@id='updatedByName']") public WebElement eletxtUpdatedBy;
	
	
	@FindBy(xpath="//div[contains(@class,'ui-dialog-titlebar')]/following::span[text()='Yes']") public WebElement eleicnyes;
	
	public AddParticipantAddressPage verifyAddParticipantAddressPage() throws Exception
	{
		verifyExactText(elebcAddParticipantAddressPage,"Add Participant Address");
		verifyDisplayed(eleicnClear,"Clear");
		verifyDisplayed(eleicnSave,"Save");
		verifyDisplayed(eleicnClose,"X");
		verifyDisplayed(elelblAddressType,"Address Type");
		verifyDisplayed(elelblPrimary,"Primary");
		verifyDisplayed(elelblAttncare,"Attn/Care Of");
		verifyDisplayed(elelblSource,"Source");
		verifyDisplayed(elelblBeginDate,"Begin Date");
		verifyDisplayed(elelblEndDate,"End Date");
		verifyDisplayed(elelblAddress1,"Address Line 1");
		verifyDisplayed(elelblAddress2, "Adress Line 2");
		verifyDisplayed(elelblcity,"City");
		verifyDisplayed(elelblstate,"State");
		verifyDisplayed(elelblcounty,"County");
		verifyDisplayed(elelblcountry,"Country");
		scrollToElementPosition(eletxtUpdatedBy);
		verifyDisplayed(elelblStatus,"Status");
		verifyDisplayed(elelblStatusDate,"Status Date");
		verifyDisplayed(elelblVerifyedby,"Verifyed By");
		verifyDisplayed(elelblVerifyDate,"Verify Date");
		verifyDisplayed(elelblcomments,"Comments");
		verifyDisplayed(elelblUpdatedOn,"Updated On");
		verifyDisplayed(elelblUpdatedBy,"Updated By");
		verifyAssociatedScreens(eleAssociatedScreenList,"Note Processor");
		return this;
	}
	

	public AddParticipantAddressPage verifyallrequiredfield() throws Exception
	{
		selectDropdownValue(eleddAddressType,"MAILING");
		Thread.sleep(2000);
		selectDropdownValue(eleddPrimary,"YES");
		click(elelovSource,"Source");
		Thread.sleep(2000);
		clearAndType(eleSearchBarSearch,"Select Source","COC");
		pressEnterKey(eleSearchBarSearch);
		Thread.sleep(2000);
		doDoubleClick(eleGridCells);
		Thread.sleep(2000);
		clearAndType(eletxtaddress1,"Address Line 1","AUTO DATA");
		Thread.sleep(2000);
		clearAndType(eletxtcity,"City","RENO");
		Thread.sleep(2000);
		pressEnterKey(eletxtcity);
		Thread.sleep(2000);
		click(elelovState,"State");
		clearAndType(eleSearchBarSearch,"Select State","NV");
		pressEnterKey(eleSearchBarSearch);
		Thread.sleep(2000);
		doDoubleClick(eleGridCells);
		Thread.sleep(2000);
		clearAndType(eletxtzip,"Zip","231564897");
		Thread.sleep(2000);
		click(elelovCountry,"Country");
		Thread.sleep(2000);
		clearAndType(eleSearchBarSearch,"Select Country","US");
		pressEnterKey(eleSearchBarSearch);
		Thread.sleep(2000);
		doubleClickGridResult(eleGridCells,"US");
		Thread.sleep(2000);
		scrollToElementPosition(eletxtUpdatedBy);
		Thread.sleep(2000);
		selectDropdownValue(eleddstatus,"CONFIRMED BAD");
		Thread.sleep(2000);
		setCurrentDate(eleicncalEndDate);
		Thread.sleep(2000);
		selectDropdownValue(eleddVerifyedBy,"CUSTODIAL PARENT");
		Thread.sleep(2000);
		setCurrentDate(eletxtVerifyDate);
		Thread.sleep(2000);
		click(eleicnSave,"Save");
		Thread.sleep(2000);
		click(eleicnyes,"Yes");
		verifyExactText(eleErrStatusBar,"SAVED SUCCESSFULLY");
		return this;
	}

	
	
	
}
