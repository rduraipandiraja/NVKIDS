package gov.nv.dwss.nvkids.pages.refm;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class AddReferenceAmountsPage extends CommonLocators 
{
	public AddReferenceAmountsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//label[text()='Amount Code']") WebElement elelblAmountCode;
	@FindBy(id = "amountTypeCode") WebElement eletxtAmountCode;
	@FindBy(xpath = "//label[text()='Amount Type']") WebElement elelblAmountType;
	@FindBy(id = "amountTypeDesc") WebElement eletxtAmountType;
	@FindBy(xpath = "//label[text()='Amount']") WebElement elelblAmount;
	@FindBy(id = "feeAmt") WebElement eletxtAmount;
	@FindBy(xpath = "//label[text()='Frequency']") WebElement elelblFrequency;
	@FindBy(xpath = "//label[text()='Frequency']/following-sibling::p-dropdown/div") WebElement eleddFrequency;
	@FindBy(xpath = "//label[text()=' Begin Date ']/preceding::span[1]") WebElement eleicnFrequency;	
	@FindBy(xpath = "//label[text()=' Begin Date ']") WebElement elelblBeginDate;
	@FindBy(id = "beginDate") WebElement eletxtBeginDate;
	@FindBy(xpath = "(//label[text()=' Begin Date ']/following::button)[1]") WebElement eleicnBeginDate;
	@FindBy(xpath = "//label[text()=' End Date ']") WebElement elelblEndDate;
	@FindBy(id = "endDate") WebElement eletxtEndDate;   
	@FindBy(xpath = "(//label[text()=' End Date ']/following::button)[1]") WebElement eleicnEndDate;		   
	@FindBy(xpath = "//label[text()=' Updated On ']") WebElement elelblUpdatedOn;	
	@FindBy(id = "beginValidityDttm") WebElement eledsoUpdatedOn;  
	@FindBy(xpath = "//label[text()='Updated By']") WebElement elelblUpdatedBy;
	@FindBy(id = "updatedByName") WebElement eledsoUpdatedBy;      
	  
	@FindAll(
			{
			@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='Add Reference Amounts']"),
			@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='View Reference Amounts']")
			}) public WebElement eleComHeaderPanel;
	@FindBy(xpath="//lib-panel/descendant::input[not(@disabled)and(not(@aria-haspopup))]") List<WebElement> eletxtAddFields;
	
	public AddReferenceAmountsPage verifyFields() throws Exception
	{
		verifyDisplayed(elelblAmountCode,"Amount Code");
		verifyDisplayed(elelblAmountType,"Amount Type");
		verifyDisplayed(elelblAmount,"Amount");
		verifyDisplayed(elelblFrequency,"Frequency");
		verifyDisplayed(elelblBeginDate,"Begin Date");
		verifyDisplayed(elelblEndDate,"End Date");
		verifyDisplayed(elelblUpdatedOn,"Updated On");
		verifyDisplayed(elelblUpdatedBy, "Updated By");
		return this;
	}
	
	public AddReferenceAmountsPage verifySuccessfulAdd()
	{
		clearAndType(eletxtAmountCode, "Amount Code", getRandomAlphaChar(4));
		clearAndType(eletxtAmountType,"Amount Type", getRandomAlphaChar(10));
		clearAndType(eletxtAmount, "Amount", getRandomNumbers(11));
		selectRandomDropdownValue(eleddFrequency);
		setFutureDate(eletxtBeginDate);
		click(eleicnSave,"Save");
		verifyExactText(eleErrStatusBar, "SAVED SUCCESSFULLY");
		return this;
	}
}
