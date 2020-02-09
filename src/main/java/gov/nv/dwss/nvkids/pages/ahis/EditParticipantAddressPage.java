package gov.nv.dwss.nvkids.pages.ahis;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class EditParticipantAddressPage extends CommonLocators
{
public EditParticipantAddressPage(){
	PageFactory.initElements(driver, this); 
}

//Screen Function

	@FindBy(xpath="//p-breadcrumb/descendant::a/span[text()='Edit Participant Address']") public WebElement elebcEditParticipantAddressPage;

	@FindBy(xpath="//label[text()='Address Type']") public WebElement elelblAddressType;
	@FindBy(xpath="//label[text()='Primary']") public WebElement elelblPrimary;
	@FindBy(xpath="//label[text()='ATTN/Care Of']") public WebElement elelblAttncare;
	@FindBy(xpath="//label[text()=' Date Received ']") public WebElement elelblDateReceived;
	@FindBy(xpath="//label[text()='Source']") public WebElement elelblSource;
	@FindBy(xpath="//input[@id='addressSourceCode']/following-sibling::button") public WebElement elelovSource;
	@FindBy(xpath="//label[text()=' Begin Date ']") public WebElement elelblBeginDate;
	@FindBy(xpath="//label[text()=' End Date ']") public WebElement elelblEndDate;
	@FindBy(xpath="//label[text()='Address Line 1']") public WebElement elelblAddress1;
	@FindBy(xpath="//label[text()='Address Line 2']") public WebElement elelblAddress2;
	@FindBy(xpath="//label[text()='City ']") public WebElement elelblcity;
	@FindBy(xpath="//label[text()='State']") public WebElement elelblstate;		
	@FindBy(xpath="//label[text()='Zip']") public WebElement elelblzip;		
	@FindBy(xpath="//label[text()='County']") public WebElement elelblcounty;	
	@FindBy(xpath="//label[text()='Country']") public WebElement elelblcountry;
	@FindBy(xpath="//label[text()='Status']") public WebElement elelblStatus;
	@FindBy(xpath="//label[@for='addressStatusCode']/following-sibling::p-dropdown/descendant::label") public WebElement eleddstatus;
	@FindBy(xpath="//label[text()=' Status Date ']") public WebElement elelblStatusDate;
	@FindBy(xpath="//label[text()='Verified By']") public WebElement elelblVerifyedby;
	@FindBy(xpath="//label[text()=' Verified Date ']") public WebElement elelblVerifyDate;
	@FindBy(xpath="//input[@id='addressVerifiedDate']") public WebElement eletxtVerifyDate;
	@FindBy(xpath="//label[text()='Comments']") public WebElement elelblcomments;
	@FindBy(xpath="//label[text()=' Updated On ']") public WebElement elelblUpdatedOn;
	@FindBy(xpath="//label[text()='Updated By']") public WebElement elelblUpdatedBy;
	@FindBy(xpath="//input[@id='updatedByName']") public WebElement eletxtUpdatedBy;
	@FindBy(xpath="//span[text()='Generate Postmaster Letter']/parent::button") public WebElement elebtngenerate;
	@FindBy(xpath="//span[text()='Copy Address']") public WebElement elebtncopy;
	@FindBy(xpath="//span[text()='Normalize Address']/parent::button") public WebElement elebtnnormalize;
	@FindBy(xpath="//span[text()='Refresh']/parent::button") public WebElement eleicnRef;
	@FindBy(xpath="//span[text()='Save']/parent::button") public WebElement eleiconsave;

	public EditParticipantAddressPage verifyEditParticipantAddress() throws Exception
	{
		verifyExactText(elebcEditParticipantAddressPage,"Edit Participant Address");
		verifyDisplayed(eleicnRef,"Refresh");
		verifyDisplayed(eleiconsave,"Save");
		verifyDisplayed(eleicnClose,"Close");
		verifyDisplayed(elebtngenerate,"Genrate Postmaster Letter");
		verifyDisplayed(elebtncopy,"Copy Address");
		verifyDisplayed(elebtnnormalize,"Normalize Address");
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
}
