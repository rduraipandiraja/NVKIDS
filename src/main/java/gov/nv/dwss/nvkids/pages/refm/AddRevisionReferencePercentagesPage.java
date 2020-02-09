package gov.nv.dwss.nvkids.pages.refm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;


public class AddRevisionReferencePercentagesPage extends CommonLocators
{
	public AddRevisionReferencePercentagesPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	ViewReferencePercentagesPage rp=new ViewReferencePercentagesPage();
	
	@FindBy(xpath="//label[text()='Percentage Code']") WebElement elelblPercentageCode;
	@FindBy(id="percentageTypeCode") WebElement eledsoPercentageCode;
	@FindBy(xpath="//label[text()='Percentage Description']") WebElement elelblPercentageDescription;
	@FindBy(id="percentageTypeDesc") WebElement eledsoPercentageDescription;
	@FindBy(xpath="//label[text()='Percentage %']") WebElement elelblPercentage;
	@FindBy(id="referencePct") WebElement eletxtPercentage;
	@FindBy(xpath="//label[text()=' Updated On ']") WebElement elelblUpdatedOn;
	@FindBy(id="beginValidityDttm") WebElement eledsoUpdatedOn;
	@FindBy(xpath="//label[text()='Updated By']") WebElement elelblUpdatedBy;
	@FindBy(id="updatedByName") WebElement eledsoUpdatedBy;
	@FindBy(xpath="//label[text()=' Begin Date ']") WebElement elelblBeginDate;
	@FindBy(id="beginDate") WebElement eletxtBeginDate;
	@FindBy(xpath="//input[@id='beginDate']/following-sibling::button") WebElement eleicnBeginDate;
	@FindBy(xpath="//label[text()=' End Date ']") WebElement elelblEndDate;
	@FindBy(id="endDate") WebElement eletxtEndDate;
	@FindBy(xpath="//input[@id='endDate']/following-sibling::button") WebElement eleicnEndDate;
	
	@FindAll(
			{
			@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='Add Revision Reference Percentages']"),
			@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='View Reference Percentages']")
			}) public WebElement eleComHeaderPanel;
	 
	
	public ViewReferencePercentagesPage addRevisionRecords() throws ParseException, InterruptedException
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
				c.add(Calendar.DATE, 5);
				Date fDate = c.getTime();
				String futureDate = dt.format(fDate);
				clearAndType(eletxtBeginDate, "Begin Date", futureDate);
				clearAndType(eletxtEndDate, "End Date", addDaysToDate(eletxtBeginDate, 5));
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
					c.add(Calendar.DATE, 5);
					Date fDate = c.getTime();
					String futureDate = dt.format(fDate);
					clearAndType(eletxtBeginDate, "Begin Date", futureDate);
				}
				else
				{
					c.add(Calendar.DATE, 5);
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
		return new ViewReferencePercentagesPage();
	}
	
	public AddRevisionReferencePercentagesPage verifyFields() throws Exception 
	{
		verifyDisplayed(elelblPercentageCode, "Percentage Code");
		verifyDisplayed(elelblPercentageDescription,"Percentage Description");
		verifyDisplayed(elelblPercentage,"Percentage");
		verifyDisplayed(elelblBeginDate, "Begin Date");
		verifyDisplayed(elelblEndDate, "End Date");
		verifyDisplayed(elelblUpdatedOn, "Updated On");
		verifyDisplayed(elelblUpdatedBy,"Updated By");
		return this;
	}
	
	public ViewReferencePercentagesPage verifySuccessMessage() throws Exception
	{
		verifyExactText(eleErrStatusBar, "SAVED SUCCESSFULLY");
		return new ViewReferencePercentagesPage();
	}
}
