package gov.nv.dwss.nvkids.pages.ahis;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import gov.nv.dwss.nvkids.pages.proc.MaintainProcessDetails;
import gov.nv.dwss.nvkids.pages.proc.ViewDocumentsAssociatedPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class ViewParticipantAddressPage extends CommonLocators

{
	
	public ViewParticipantAddressPage() 
	{
		PageFactory.initElements(driver, this); 
	}
    
	//Screen Function
	
	@FindBy(xpath="//p-breadcrumb/descendant::a/span[text()='View Participant Address']") public WebElement elebcViewParticipantAddress;
			
	//Filter Section
			
	@FindBy(xpath="//label[text()='Participant ID']") public WebElement elelblParticipantid;
	@FindBy(xpath="//label[text()='Participant ID']/following::input[contains(@class,'ui-inputtext')]") public WebElement eletxtParticipantid;
	@FindBy(xpath="//span[text()='ui-btn']/preceding-sibling::span[contains(@class,'fa-search')]") public WebElement eleicnlovParticipantid;
	@FindBy(xpath="//label[text()='Verification Status']") public WebElement elelblVerificationStatus;
	@FindBy(xpath="//label[@for='addressStatusCode']/following-sibling::p-dropdown/descendant::label") public WebElement eleddVerificationStatus;
	@FindBy(xpath="//label[text()='Primary']") public WebElement elelblPrimary;
	@FindBy(xpath="//label[@for='primaryInd']/following-sibling::p-dropdown/descendant::label") public WebElement eleddPrimary;
	
	@FindBy(xpath="//label[@for='lastName']") public WebElement elelbllastname;
	@FindBy(xpath="//input[@id='lastName']") public WebElement eletxtlastname;
	
	@FindBy(xpath="//div[contains(@class,'ui-dialog-content')]/descendant::button/span[text()='Search']") public WebElement elebtnPopupSerch;	
	@FindBy(xpath="//div[contains(@class,'ui-dialog-content')]/descendant::tbody/tr[1]") public WebElement elePopupGrid;	
	@FindBy(xpath="//tbody/tr[1]/td[3]/span[@class='ng-star-inserted']") public WebElement eleGridval;
	
	
	//Grid Section
	
	@FindBy(xpath="//label[text()=' Primary ']") public WebElement elehdrPrimary;
	@FindBy(xpath="//label[text()=' Address Type Code ']") public WebElement elehdrAddressTypeCode;
	@FindBy(xpath="//label[text()=' Address Type ']") public WebElement elehdrAddressType;
	@FindBy(xpath="//label[text()=' Verification Status Code ']") public WebElement elehdrVerificationStatusCode;		
	@FindBy(xpath="//label[text()=' Verification Status ']") public WebElement elehdrVerificationStatus;		
	@FindBy(xpath="//label[text()=' Source Code ']") public WebElement elehdrSourceCode;	
	@FindBy(xpath="//label[text()=' Source ']") public WebElement elehdrSource;
	@FindBy(xpath="//label[text()=' Status Date ']") public WebElement elehdrStatusDate;
	@FindBy(xpath="//label[text()=' Begin Date ']") public WebElement elehdrBeginDate;
	@FindBy(xpath="//label[text()=' End Date ']") public WebElement elehdrEndDate;
	@FindBy(xpath="//th//label[@for='primaryInd']/following-sibling::p-dropdown/descendant::label") public WebElement eleddGridPrimary;
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
	@FindBy(xpath="//span[text()='Participant Federal Tax Address']") public WebElement elelblmenunavigate;
	
	
	/***********************************************************/
	
	public void selectAllShowCol(WebElement ele) {
		try{
			
			click(ele,"Grid Options");
			WebElement showColumn = driver.findElementByXPath("//div[@class='ui-overlaypanel-content']/div[contains(@class,'filterItems')]/span[contains(text(),'Show Columns')]");
			wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOf(showColumn));				
			click(showColumn,"Show Column");
			scrollToElementPosition(elelblshowpanel);
			reportStep("Show Columns  is present", "pass");
			List<WebElement> SelectCheckBox = driver.findElementsByXPath("//div[@class='ui-overlaypanel-content']/div[contains(@class,'filterItems')]/p-checkbox/label");
			wait.until(ExpectedConditions.visibilityOfAllElements(SelectCheckBox));
			for(WebElement col: SelectCheckBox){
				String s1 = col.getText().trim().replaceAll("[^a-z A-Z]", "");
					if(!(col.getAttribute("class").contains("ui-label-active")) && !(s1.contains("Show Filters"))){
						String colname = col.getText().trim().replaceAll("[^a-z A-Z]", "");
						click(col,"Column");
						
						reportStep(colname +" is  selected", "pass");

					}
						
			}
			Thread.sleep(3000);
			click(ele,"");

		}

		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable find grid options --> " + error, "fail");
			
			Assert.fail("Unable to find grid options");
		}
		finally 
		{
			takeSnap();
		}
	}
	
	
	public AddParticipantAddressPage navigateToAddParticipantAddressPage() throws InterruptedException 
	{
		click(eleicnFilter,"Filter");
		clearAndType(eletxtParticipantid,"Participant ID","1000000014");
	    Thread.sleep(2000);
	    click(eleicnSearch,"Search");
	    Thread.sleep(2000);
	    click(eleicnAdd,"Add");
	    Thread.sleep(2000);
		return new AddParticipantAddressPage();
	}
	public EditParticipantAddressPage navigateToEditParticipantAddressPage() throws InterruptedException 
	{
		click(eleicnFilter,"Filter");
		clearAndType(eletxtParticipantid,"Participant ID","1000000006");
	    Thread.sleep(2000);
	    click(eleicnSearch,"Search");
	    Thread.sleep(2000);
	    doDoubleClick(eleGridval);
		Thread.sleep(2000);
		return new EditParticipantAddressPage();
	}
	public ViewParticipantFederalTaxAddressPage navigateToMenuNavigation() throws InterruptedException 
	{
		click(elelblmenunavigate,"Menu Navigation");
		Thread.sleep(2000);
		return new ViewParticipantFederalTaxAddressPage();
	}
	public ViewParticipantAddressPage verifyViewParticipantAddress() throws Exception
	{
		verifyExactText(elebcViewParticipantAddress,"View Participant Address");
		verifyDisplayed(eleicnFilter,"Filter");
		verifyGridHeaders(elelblGridHeaders," Primary "," Address Type "," Address "," Verification Status "," Source "," Status Date "," Begin Date "," End Date ");
		verifyAssociatedScreens(eleAssociatedScreenList,"Note Processor");
		return this;
	}
	
	public ViewParticipantAddressPage verifyFilter() throws Exception
	{
		click(eleicnFilter,"Filter");
		verifyDisplayed(elelblParticipantid,"Participant ID");
		verifyDisplayed(elelblVerificationStatus,"Verification Status");
		verifyDisplayed(elelblPrimary,"Primary");
		return this;
	}
	
	public ViewParticipantAddressPage verifyGridres() throws Exception
	{
		click(eleicnFilter,"Filter");
		Thread.sleep(2000);
		clearAndType(eletxtParticipantid,"Participant ID","1000000001");
	    Thread.sleep(2000);
	    click(eleicnSearch,"Search");
	    Thread.sleep(2000);
	    verifyGridContainsData(eleGridResult,"SAFETY ADDRESS");
		return this;
	}
	
	
	
	
}
