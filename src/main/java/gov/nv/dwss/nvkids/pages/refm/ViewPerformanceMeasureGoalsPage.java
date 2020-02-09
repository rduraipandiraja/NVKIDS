package gov.nv.dwss.nvkids.pages.refm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.testcases.refm.EditPerformanceMeasureGoalsTestcase;

public class ViewPerformanceMeasureGoalsPage extends CommonLocators
{
	public ViewPerformanceMeasureGoalsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	ViewReferencePercentagesPage rp=new ViewReferencePercentagesPage();
	//Select Filter section
	@FindBy(xpath="//label[text()='Case Action']") WebElement elelblsfCaseAction;
	@FindBy(xpath="//label[text()='Case Action']/following-sibling::p-dropdown/div") WebElement eleddsfCaseAction;
	@FindBy(xpath="(//p-dropdown//div[contains(@class,'dropdown-trigger')])[2]") WebElement eleicnCaseAction;
	
	//Grid Section
	@FindBy(xpath="//label[text()=' Case Action ']") WebElement elelblCaseAction;
	@FindBy(xpath="//label[text()=' Goal Percentage ']") WebElement elelblGoalPercentage;
	@FindBy(xpath="//label[text()=' Begin Date ']") WebElement elelblBeginDate;
	@FindBy(xpath="//label[text()=' End Date ']") WebElement elelblEndDate;
	@FindBy(xpath="//label[text()=' Updated On ']") WebElement elelblUpdatedOn;
	@FindBy(xpath="//label[text()=' Updated By ']") WebElement elelblUpdatedBy;
	@FindBy(xpath="//label[text()=' Case Action ']/following::div[1]") WebElement elegsfdsoCaseAction;
	@FindBy(id="goalPct") WebElement elegsftxtGoalPercentage;
	@FindBy(id="beginDate") WebElement elegsftxtBeginDate;
	@FindBy(id="endDate") WebElement elegsftxtEndDate;
	@FindBy(id="beginValidityDttm") WebElement elegsftxtUpdatedOn;
	@FindBy(id="updatedByName") WebElement elegsftxtUpdatedBy;
	
		
	@FindBy(xpath="(//tbody[@class='ui-table-tbody']/tr/td[3]/descendant::span)[1]") WebElement eleGridBeginDate;
	@FindBy(xpath="(//tbody[@class='ui-table-tbody']/tr/td[4]/descendant::span)[1]") WebElement eleGridEndDate;
	@FindBy(xpath="//tbody[@class='ui-table-tbody']/tr/td[3]/descendant::span") List<WebElement> eleGridAllBeginDate;
	@FindBy(xpath="//tbody[@class='ui-table-tbody']/tr/td[4]/descendant::span") List<WebElement> eleGridAllEndDate;
	@FindBy(xpath="//label[text()=' Updated On ']/following::i[contains(@class,'ui-sortable-column-icon')][1]") WebElement eleSortUpdatedOn;
	@FindBy(xpath="//label[text()=' Updated On ']") WebElement elegridUpdatedOn;
	@FindBy(xpath="//input[@id='goalPct']/following::td[2]/span") WebElement elegdataGoalPercentage;
	@FindBy(xpath="//input[@id='beginDate']/following::td[3]/span") WebElement elegdataBeginDate;
	@FindBy(xpath="//input[@id='endDate']/following::td[4]/span") WebElement elegdataEndDate;
	@FindBy(xpath="//input[@id='beginValidityDttm']/following::td[5]/span") WebElement elegdataUpdatedOn;
	@FindBy(xpath="//input[@id='updatedByName']/following::td[6]/span") WebElement elegdataUpdatedBy;
	@FindBy(xpath="//lib-label-value/descendant::label") List<WebElement> elealbls;
	@FindBy(xpath="//label[text()=' Case Action ']/following::td[1]") WebElement elegrddataCaseAction;
	
	static String beginDate,endDate;
	
	public AddRevisionPerformanceMeasureGoalsPage navigatetoAddRevisionPerformanceMeasureGoals(String caseAction) throws Exception
	{
		inquireWithValidValues(caseAction);
		Thread.sleep(3000);
		click(elegrddataCaseAction,"Grid Row");
		Thread.sleep(2000);
		click(rp.eleicnAddRevision,"Add Revision");
		return new AddRevisionPerformanceMeasureGoalsPage();
	}
	
	public AddRevisionPerformanceMeasureGoalsPage navigatetoAddRevPerfMeasureGoalsWithSecondGridRow() throws InterruptedException
	{
		Thread.sleep(3000);
		beginDate=eleGridBeginDate.getText().trim().toString();
		endDate=eleGridEndDate.getText().trim().toString();
		click(rp.eleGridSecondRow,"Grid Row");
		click(rp.eleicnAddRevision,"Add Revision");
		return new AddRevisionPerformanceMeasureGoalsPage();
	}
	
	public EditPerformanceMeasureGoalsPage navigatetoEditPerfMeasureGoalsWithFirstGridRow(String caseAction) throws Exception
	{
		inquireWithValidValues(caseAction);
		click(elegrddataCaseAction,"Grid Row");
		Thread.sleep(2000);
		doDoubleClick(elegrddataCaseAction);	
		return new EditPerformanceMeasureGoalsPage();
	}
	
	public EditPerformanceMeasureGoalsPage navigatetoEditPerfMeasureGoals() throws InterruptedException
	{
		click(elegrddataCaseAction,"Grid Row");
		doDoubleClick(elegrddataCaseAction);	
		return new EditPerformanceMeasureGoalsPage();
	}
	
	public ViewPerformanceMeasureGoalsPage sortByUpdatedOn() throws InterruptedException
	{
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(elegridUpdatedOn));
		Actions build = new Actions(driver);
		build.moveToElement(elegridUpdatedOn).build().perform();
		Thread.sleep(2000);
		if(eleSortUpdatedOn.isDisplayed())
		{
			click(eleSortUpdatedOn,"Sort Icon");
		}
		else
		{
			click(elegridUpdatedOn,"Updated On");
		}
		return this;
	}
	
	public ViewPerformanceMeasureGoalsPage verifyFields()
	{
		verifyGridHeaders(elelblGridHeaders, "Case Action","Goal Percentage","Begin Date","End Date","Updated On","Updated By");
		return this;
	}
	
	public ViewPerformanceMeasureGoalsPage verifyFilterSectionFields() throws Exception
	{
		click(eleicnFilter,"Filter");
		verifyDisplayed(elelblsfCaseAction, "Case Action");
		return this;
	}
	
	public ViewPerformanceMeasureGoalsPage verifyAccordionFields()
	{
		click(eleicnFilter,"Filter");
		selectDropdownValue(eleddsfCaseAction, "Arrear Collections");
		click(eleicnSearch, "Search");
		click(eleicnOpenAccordion, "Open Accordion");
		verifyFieldSetLabels(elealbls, "Case Action","Goal Percentage","Begin Date","End Date","Updated On","Updated By");
		return this;
	}
	
	public ViewPerformanceMeasureGoalsPage inquireWithValidValues(String caseAction) throws Exception
	{
		click(eleicnFilter,"Filter");
		selectDropdownValue(eleddsfCaseAction, caseAction);
		click(eleicnSearch, "Search");
		Thread.sleep(9000);
		verifyGridResult(eleGridResult, caseAction);
		return new ViewPerformanceMeasureGoalsPage();
	}
	
	public EditPerformanceMeasureGoalsPage selectFutureEnddateAndNavigate() throws ParseException
	{
		try
		{
			Thread.sleep(3000);
			for (WebElement val : eleGridAllEndDate) 
			{
				String eDate = val.getText();
				System.out.println(eDate);
				SimpleDateFormat dt = new SimpleDateFormat("MM/dd/yyyy");
				Date pastDate = dt.parse(eDate);
				Date currentDate = new Date();
				String curDate = dt.format(currentDate);
				Date cDate = dt.parse(curDate);
				if(pastDate.compareTo(cDate)==1)
				{
					click(val,"Grid row");
					doDoubleClick(val);
					break;
				}
				else if(eDate==null)
				{
					click(val,"Grid row");
					doDoubleClick(val);
					break;
				}
								
			}
		}
		catch(Exception e)
		{

		}
		return new EditPerformanceMeasureGoalsPage();
	}
	
	public EditPerformanceMeasureGoalsPage selectPastBegindateAndNavigate() throws ParseException
	{
		try
		{
			Thread.sleep(3000);
			for (WebElement val : eleGridAllBeginDate) 
			{
				String bDate = val.getText();
				System.out.println(bDate);
				SimpleDateFormat dt = new SimpleDateFormat("MM/dd/yyyy");
				Date pastDate = dt.parse(bDate);
				Date currentDate = new Date();
				String curDate = dt.format(currentDate);
				Date cDate = dt.parse(curDate);
				if(pastDate.compareTo(cDate)==-1)
				{
					click(val,"Grid Row");
					doDoubleClick(val);
					break;
				}
				else if(pastDate.toString()==null)
				{
					break;
				}
								
			}
		}
		catch(Exception e)
		{

		}
		return new EditPerformanceMeasureGoalsPage();
	}
	
	public EditPerformanceMeasureGoalsPage selectEndDatedRecordAndNavigate() throws ParseException
	{
		try
		{
			Thread.sleep(5000);
			for (WebElement val : eleGridAllEndDate) 
			{
				String eDate = val.getText();
				System.out.println(eDate);
				SimpleDateFormat dt = new SimpleDateFormat("MM/dd/yyyy");
				Date pastDate = dt.parse(eDate);
				Date currentDate = new Date();
				String curDate = dt.format(currentDate);
				Date cDate = dt.parse(curDate);
				if(pastDate.compareTo(cDate)==-1)
				{
					click(val,"Grid Row");
					doDoubleClick(val);
					break;
				}
				else 
				{
					continue;
				}
												
			}
		}
		catch(Exception e)
		{

		}
		return new EditPerformanceMeasureGoalsPage();
	}
	
		
	public ViewPerformanceMeasureGoalsPage inquireWithShowFilterGoalPercentage() throws Exception
	{
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		String goalPercentage = elegdataGoalPercentage.getText();
		clearAndType(elegsftxtGoalPercentage, "Goal Percentage", goalPercentage);
		pressEnterKey(elegsftxtGoalPercentage);
		verifyGridResult(eleGridResult, goalPercentage);
		return this;
	}
	
	public ViewPerformanceMeasureGoalsPage inquireWithShowFilterBeginDate() throws Exception
	{
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		String beginDate = elegdataBeginDate.getText();
		clearAndType(elegsftxtBeginDate, "Begin Date", beginDate);
		pressEnterKey(elegsftxtBeginDate);
		Thread.sleep(2000);
		verifyGridResult(eleGridResult, beginDate);
		return this;
	}
	
	public ViewPerformanceMeasureGoalsPage inquireWithShowFilterEndDate() throws Exception
	{
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		String endDate = elegdataEndDate.getText();
		clearAndType(elegsftxtEndDate, "End Date", endDate);
		pressEnterKey(elegsftxtEndDate);
		Thread.sleep(2000);
		verifyGridResult(eleGridResult, endDate);
		return this;
	}
	
	public ViewPerformanceMeasureGoalsPage inquireWithShowFilterUpdatedOn() throws Exception
	{
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		String updatedOn = elegdataUpdatedOn.getText().substring(0,10);
		clearAndType(elegsftxtUpdatedOn, "Updated On", updatedOn);
		pressEnterKey(elegsftxtUpdatedOn);
		Thread.sleep(2000);
		verifyGridContainsData(eleGridResult, updatedOn);
		return this;
	}
	
	
	public ViewPerformanceMeasureGoalsPage inquireWithShowFilterUpdatedBy() throws Exception
	{
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		String updatedBy = elegdataUpdatedBy.getText();
		clearAndType(elegsftxtUpdatedBy,"Updated By", updatedBy);
		pressEnterKey(elegsftxtUpdatedBy);
		Thread.sleep(2000);
		verifyGridResult(eleGridResult, updatedBy);
		return this;
	}
	
	public ViewPerformanceMeasureGoalsPage checkShowColumnsOption() throws Exception
	{
		Thread.sleep(2000);
		verifyShowColumns(eleicnGridOptions, "Case Action","Goal Percentage","Begin Date","End Date","Updated On","Updated By");
		return this;
	}
}
