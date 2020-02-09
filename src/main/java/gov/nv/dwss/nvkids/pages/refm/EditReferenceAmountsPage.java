package gov.nv.dwss.nvkids.pages.refm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class EditReferenceAmountsPage extends CommonLocators 
{
	public EditReferenceAmountsPage()
	{
		PageFactory.initElements(driver, this);
	}

	ViewReferencePercentagesPage rp=new ViewReferencePercentagesPage();
	ViewReferenceAmountsPage ra=new ViewReferenceAmountsPage();
	AddRevisionReferencePercentagesPage arp=new AddRevisionReferencePercentagesPage();
	@FindBy(xpath = "//label[text()='Amount Code']") WebElement elelblAmountCode;
	@FindBy(id = "amountTypeCode") WebElement eledsoAmountCode;
	@FindBy(xpath = "//label[text()='Amount Type']") WebElement elelblAmountType;
	@FindBy(id = "amountTypeDesc") WebElement eletxtAmountType;
	@FindBy(xpath = "//label[text()='Amount']") WebElement elelblAmount;
	@FindBy(id = "feeAmt") WebElement eletxtAmount;
	@FindBy(xpath = "//label[text()='Frequency']") WebElement elelblFrequency;
	@FindBy(xpath = "//label[text()='Frequency']/following-sibling::p-dropdown") WebElement eleddFrequency;
	@FindBy(xpath = "//label[text()='Begin Date']/preceding::span[1]") WebElement eleicnFrequency;	
	@FindBy(xpath = "//label[text()='Begin Date']") WebElement elelblBeginDate;
	@FindBy(id = "beginDate") WebElement eledsoBeginDate;
	@FindBy(xpath = "//label[text()='End Date']") WebElement elelblEndDate;
	@FindBy(id = "endDate") WebElement eletxtEndDate;   
	@FindBy(xpath = "(//label[text()='End Date']/following::button)[1]") WebElement eleicnEndDate;		   
	@FindBy(xpath = "//label[text()='Updated On']") WebElement elelblUpdatedOn;	
	@FindBy(id = "beginValidityDttm") WebElement eledsoUpdatedOn;  
	@FindBy(xpath = "//label[text()='Updated By']") WebElement elelblUpdatedBy;
	@FindBy(id = "updatedByName") WebElement eledsoUpdatedBy;      
	  
	@FindAll(
			{
			@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='Edit Reference Amounts']"),
			@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='View Reference Amounts']")
			}) public WebElement eleComHeaderPanel;
	
	
	public ViewReferencePercentagesPage verifySuccessfulEdit()
	{
		clearAndType(eletxtAmount, "Amount", getRandomNumbers(5));
		click(eleicnSave, "Save");
		verifyExactText(eleErrStatusBar, "SAVED SUCCESSFULLY");
		return new ViewReferencePercentagesPage();
	}
	
	public AddRevisionReferenceAmountsPage navigatetoAddRevisionReferenceAmounts() throws InterruptedException
	{
		Thread.sleep(4000);
		click(rp.eleGridFirstRow,"Grid Row");
		click(rp.eleicnAddRevision,"Add Revision");
		return new AddRevisionReferenceAmountsPage();
	}
}
