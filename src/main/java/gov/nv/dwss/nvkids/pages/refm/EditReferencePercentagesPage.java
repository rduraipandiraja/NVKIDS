package gov.nv.dwss.nvkids.pages.refm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class EditReferencePercentagesPage extends CommonLocators
{
	public EditReferencePercentagesPage()
	{
		PageFactory.initElements(driver, this);
	}
	ViewReferencePercentagesPage rp=new ViewReferencePercentagesPage();
	
	@FindBy(xpath="//label[text()='Percentage Code']") WebElement elelblPercentageCode;
	@FindBy(xpath="//label[text()='Percentage Description']") WebElement elelblPercentageDescription;
	@FindBy(xpath="//label[text()='Percentage %']") WebElement elelblPercentage;
	@FindBy(xpath="//label[text()=' Begin Date ']") WebElement elelblBeginDate;
	@FindBy(xpath="//label[text()=' End Date ']") WebElement elelblEndDate;
	@FindBy(xpath="//label[text()=' Updated On ']") WebElement elelblUpdatedOn;
	@FindBy(xpath="//label[text()='Updated By']") WebElement elelblUpdatedBy;
	@FindBy(id="percentageTypeCode") WebElement eledsoPercentageCode;
	@FindBy(id="percentageTypeDesc") WebElement eletxtPercentageDescription;
	@FindBy(id="referencePct") WebElement eletxtPercentage;
	@FindBy(id="beginDate") WebElement eledsoBeginDate;
	@FindBy(id="endDate") WebElement eletxtEndDate;
	@FindBy(xpath="//label[text()='End Date']/following-sibling::p-calendar/descendant::button") WebElement eleicnEndDate;
	@FindBy(id="beginValidityDttm") WebElement eledsoUpdatedOn;
	@FindBy(id="updatedByName") WebElement eledsoUpdatedBy;
	//@FindBy(xpath="//tbody[@class='ui-table-tbody']/tr/td[5]") WebElement eleGridDatas;
	
	@FindAll(
			{
			@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='View Reference Percentages']"),
			@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='Edit Reference Percentages']")
			}) public WebElement eleComHeaderPanel;
	
	public EditReferencePercentagesPage verifyFieldsPresent() throws Exception
	{
		verifyDisplayed(elelblPercentageCode, "Percentage Code");
		verifyDisplayed(elelblPercentageDescription,"Percentage Description");
		verifyDisplayed(elelblPercentage,"Percentage");
		verifyDisplayed(elelblBeginDate, "Begin Date");
		verifyDisplayed(elelblEndDate,"End Date");
		verifyDisplayed(elelblUpdatedOn,"Updated On");
		verifyDisplayed(elelblUpdatedBy,"Updated By");
		return this;
	}
	
	public ViewReferencePercentagesPage editReferencePercentages()
	{
		clearAndType(eletxtPercentage, "Percentage", getRandomNumbers(2));
		click(eleicnSave, "Save");
		verifyExactText(eleErrStatusBar, "SAVED SUCCESSFULLY");
		return new ViewReferencePercentagesPage();
	}
}
