package gov.nv.dwss.nvkids.pages.refm;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class AddReferencePercentagesPage extends CommonLocators
{
	public AddReferencePercentagesPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	CommonLocators cloc=new CommonLocators();
	@FindBy(xpath="//label[text()='Percentage Code']") WebElement elelblPercentageCode;
	@FindBy(xpath="//label[text()='Percentage Description']") WebElement elelblPercentageDescription;
	@FindBy(xpath="//label[text()='Percentage %']") WebElement elelblPercentage;
	@FindBy(xpath="//label[text()=' Begin Date ']") WebElement elelblBeginDate;
	@FindBy(xpath="//label[text()=' End Date ']") WebElement elelblEndDate;
	@FindBy(xpath="//label[text()=' Updated On ']") WebElement elelblUpdatedOn;
	@FindBy(xpath="//label[text()='Updated By']") WebElement elelblUpdatedBy;
	
	@FindBy(id="percentageTypeCode") WebElement eletxtPercentageCode;
	@FindBy(id="percentageTypeDesc") WebElement eletxtPercentageDescription;
	@FindBy(id="referencePct") WebElement eletxtPercentage;
	@FindBy(id="beginDate") WebElement eletxtBeginDate;
	@FindBy(id="endDate") WebElement eletxtEndDate;
	@FindBy(id="beginValidityDttm") WebElement eledsoUpdatedOn;
	@FindBy(id="updatedByName") WebElement eledsoUpdatedBy;
		
	@FindAll(
			{
			@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='Add Reference Percentages']"),
			@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='View Reference Percentages']")
			}) public WebElement eleComHeaderPanel;
	
	@FindBy(xpath="//lib-panel/descendant::input[not(@disabled)]") List<WebElement> eletxtAddFields;
			
	public AddReferencePercentagesPage verifyFieldsPresent() throws Exception
	{
		verifyDisplayed(elelblPercentageCode, "Percentage Code");
		verifyDisplayed(elelblPercentageDescription, "Percentage Description");
		verifyDisplayed(elelblPercentage, "Percentage");
		verifyDisplayed(elelblBeginDate, "Begin Date");
		verifyDisplayed(elelblEndDate, "End Date");
		verifyDisplayed(elelblUpdatedOn, "Updated On");
		verifyDisplayed(elelblUpdatedBy, "Updated By");
		verifyRequiredField(elelblPercentageCode);
		verifyOptionalField(elelblEndDate);
		return this;
	}
	
	public AddReferencePercentagesPage verifySuccessfulAdd()
	{
		clearAndType(eletxtPercentageCode,"Percentage Code", getRandomAlphaChar(4));
		clearAndType(eletxtPercentageDescription, "Percentage Description", getRandomAlphaNumericChar(8));
		clearAndType(eletxtPercentage, "Percentage", getRandomNumbers(2));
		setFutureDate(eletxtBeginDate);
		click(eleicnSave,"Save");
		verifyExactText(eleErrStatusBar, "SAVED SUCCESSFULLY");
		return this;
	}
}
