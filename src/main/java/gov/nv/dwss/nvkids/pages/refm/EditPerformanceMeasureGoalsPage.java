package gov.nv.dwss.nvkids.pages.refm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class EditPerformanceMeasureGoalsPage extends CommonLocators
{
	public EditPerformanceMeasureGoalsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	ViewPerformanceMeasureGoalsPage gp=new ViewPerformanceMeasureGoalsPage();
	@FindBy(xpath="//label[text()='Case Action']") WebElement elelblCaseAction;
	@FindBy(xpath="//label[text()='Case Action']/following-sibling::p-dropdown") WebElement eleddCaseAction;
	@FindBy(xpath="//label[text()='Goal Percentage']") WebElement elelblGoalPercentage;
	@FindBy(id="goalPct") WebElement eletxtGoalPercentage;
	@FindBy(xpath="//label[text()=' Begin Date ']") WebElement elelblBeginDate;
	@FindBy(id="beginDate") WebElement eledsoBeginDate;
	@FindBy(xpath = "//label[text()=' End Date ']") WebElement elelblEndDate;
	@FindBy(id = "endDate") WebElement eletxtEndDate;   
	@FindBy(xpath = "(//label[text()=' End Date ']/following::button)[1]") WebElement eleicnEndDate;		   
	@FindBy(xpath = "//label[text()=' Updated On ']") WebElement elelblUpdatedOn;	
	@FindBy(id = "beginValidityDttm") WebElement eledsoUpdatedOn;  
	@FindBy(xpath = "//label[text()='Updated By']") WebElement elelblUpdatedBy;
	@FindBy(id = "updatedByName") WebElement eledsoUpdatedBy;     
	
	@FindAll(
			{
			@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='View Performance Measure Goals']"),
			@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='Edit Performance Measure Goals']")
			}) public WebElement eleComHeaderPanel;
	
	public EditPerformanceMeasureGoalsPage verifyFields() throws Exception
	{
		Thread.sleep(2000);
		verifyDisplayed(elelblCaseAction,"Case Action");
		verifyDisplayed(elelblGoalPercentage,"Goal Percentage");
		verifyDisplayed(elelblBeginDate,"Begin Date");
		verifyDisplayed(elelblEndDate,"End Date");
		verifyDisplayed(elelblUpdatedOn, "Updated On");
		verifyDisplayed(elelblUpdatedBy, "Updated By");
		return this;
	}
	
	public ViewReferencePercentagesPage verifySuccessfulEdit() throws InterruptedException
	{
		Thread.sleep(2000);
		clearAndType(eletxtGoalPercentage, "Goal Percentage", getRandomNumbers(2));
		click(eleicnSave,"Save");
		verifyExactText(eleErrStatusBar, "SAVED SUCCESSFULLY");
		return new ViewReferencePercentagesPage();
	}
}
