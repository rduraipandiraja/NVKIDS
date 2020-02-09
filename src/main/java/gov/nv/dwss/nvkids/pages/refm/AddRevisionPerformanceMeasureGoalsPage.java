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

import gov.nv.dwss.nvkids.pages.dref.EditDocumentAttributesPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class AddRevisionPerformanceMeasureGoalsPage extends CommonLocators
{
	public AddRevisionPerformanceMeasureGoalsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	ViewPerformanceMeasureGoalsPage gp=new ViewPerformanceMeasureGoalsPage();
	@FindBy(xpath="//label[text()='Case Action']") WebElement elelblCaseAction;
	@FindBy(xpath="//label[text()='Case Action']/following-sibling::p-dropdown") WebElement eleddCaseAction;
	@FindBy(xpath="//label[text()='Goal Percentage']") WebElement elelblGoalPercentage;
	@FindBy(id="goalPct") WebElement eletxtGoalPercentage;
	@FindBy(xpath="//label[text()=' Begin Date ']") WebElement elelblBeginDate;
	@FindBy(id="beginDate") WebElement eletxtBeginDate;
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
			@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='View Performance Measure Goals']"),
			@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='Add Revision Performance Measure Goals']")
			}) public WebElement eleComHeaderPanel;
	 
	public AddRevisionPerformanceMeasureGoalsPage verifyFields() throws Exception
	{
		verifyDisplayed(elelblCaseAction, "Case Action");
		verifyDisplayed(elelblGoalPercentage, "Goal Percentage");
		verifyDisplayed(elelblBeginDate, "Begin Date");
		verifyDisplayed(elelblEndDate, "End Date");
		verifyDisplayed(elelblUpdatedOn, "Updated On");
		verifyDisplayed(elelblUpdatedBy, "Updated By");
		return this;
	}
	
	public ViewPerformanceMeasureGoalsPage addRevisionRecords() throws ParseException, InterruptedException
	{
		try
		{
			if(!eletxtEndDate.getAttribute("value").isEmpty())
			{
				SimpleDateFormat dt = new SimpleDateFormat("MM/dd/yyyy");
				String actEndDate = eletxtEndDate.getAttribute("value").toString();
				Date endDate = dt.parse(actEndDate);
				Calendar c = Calendar.getInstance();
				c.setTime(endDate);
				c.add(Calendar.DATE, 3);
				Date fDate = c.getTime();
				String futureDate = dt.format(fDate);
				clearAndType(eletxtBeginDate,"Begin Date", futureDate);
				clearAndType(eletxtEndDate, "End Date", addDaysToDate(eletxtBeginDate, 3));
				click(eleicnSave, "Save");
				verifyExactText(eleErrStatusBar, "SAVED SUCCESSFULLY");
				Thread.sleep(2000);
				click(eleicnClose,"Close");
				
			}
			else if(eletxtEndDate.getAttribute("value").isEmpty())
			{
				SimpleDateFormat dt = new SimpleDateFormat("MM/dd/yyyy"); 
				String actBeginDate = eletxtBeginDate.getAttribute("value").toString();
				Date beginDate = dt.parse(actBeginDate);
				Date currentDate = new Date();
				String curDate = dt.format(currentDate);
				Calendar c = Calendar.getInstance();
				c.setTime(currentDate);
				if(beginDate.compareTo(currentDate)>0)
				{
					c.setTime(beginDate);
					c.add(Calendar.DATE, 3);
					Date fDate = c.getTime();
					String futureDate = dt.format(fDate);
					clearAndType(eletxtBeginDate, "Begin Date", futureDate);
				}
				else
				{
					c.add(Calendar.DATE, 3);
					Date fDate = c.getTime();
					String futureDate = dt.format(fDate);
					clearAndType(eletxtBeginDate, "Begin Date", futureDate);
					
				}
				clearAndType(eletxtEndDate, "End Date", addDaysToDate(eletxtBeginDate, 5));
				click(eleicnSave, "Save");
				verifyExactText(eleErrStatusBar, "SAVED SUCCESSFULLY");
				Thread.sleep(2000);
				click(eleicnClose,"Close");
			}
		}
		catch(Exception e)
		{
			reportStep("Unable to access the Element", "fail");
		}
		return new ViewPerformanceMeasureGoalsPage();
	}
}
