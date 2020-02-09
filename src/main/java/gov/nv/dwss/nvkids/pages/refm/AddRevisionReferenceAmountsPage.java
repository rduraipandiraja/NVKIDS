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

public class AddRevisionReferenceAmountsPage extends CommonLocators
{
	public AddRevisionReferenceAmountsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	ViewReferenceAmountsPage ra=new ViewReferenceAmountsPage();
	@FindBy(xpath = "//label[text()='Amount Code']") WebElement elelblAmountCode;
	@FindBy(id = "amountTypeCode") WebElement eletxtAmountCode;
	@FindBy(xpath = "//label[text()='Amount Type']") WebElement elelblAmountType;
	@FindBy(id = "amountTypeDesc") WebElement eletxtAmountType;
	@FindBy(xpath = "//label[text()='Amount']") WebElement elelblAmount;
	@FindBy(id = "feeAmt") WebElement eletxtAmount;
	@FindBy(xpath = "//label[text()='Frequency']") WebElement elelblFrequency;
	@FindBy(xpath = "//label[text()='Frequency']/following-sibling::p-dropdown") WebElement eleddFrequency;
	@FindBy(xpath = "//label[text()=' Begin Date ']/preceding::span[1]") WebElement eleicnFrequency;	
	@FindBy(xpath="//label[text()=' Begin Date ']") WebElement elelblBeginDate;
	@FindBy(id="beginDate") WebElement eletxtBeginDate;
	@FindBy(xpath = "(//label[text()=' Begin Date ']/following::button)[1]") WebElement eleicnBeginDate;
	@FindBy(xpath="//label[text()=' End Date ']") WebElement elelblEndDate;
	@FindBy(id="endDate") WebElement eletxtEndDate;
	@FindBy(xpath = "(//label[text()=' End Date ']/following::button)[1]") WebElement eleicnEndDate;
	@FindBy(xpath = "//label[text()=' Updated On ']") WebElement elelblUpdatedOn;	
	@FindBy(id = "beginValidityDttm") WebElement eledsoUpdatedOn;  
	@FindBy(xpath = "//label[text()='Updated By']") WebElement elelblUpdatedBy;
	@FindBy(id = "updatedByName") WebElement eledsoUpdatedBy;   
	
	@FindAll(
			{
			@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='Add Revision Reference Amounts']"),
			@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='View Reference Amounts']")
			}) public WebElement eleComHeaderPanel;

	public ViewReferenceAmountsPage addRevisionRecords() throws ParseException, InterruptedException
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
				clearAndType(eletxtBeginDate, "Begin Date", futureDate);
				clearAndType(eletxtEndDate,"End Date", addDaysToDate(eletxtBeginDate, 3));
				click(eleicnSave, "Save");
				verifyExactText(eleErrStatusBar, "SAVED SUCCESSFULLY");
				Thread.sleep(2000);
				click(eleicnClose,"");
				
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
		return new ViewReferenceAmountsPage();
	}
	
	public AddRevisionReferenceAmountsPage verifyFields() throws Exception
	{
		verifyDisplayed(elelblAmountCode,"Amount Code");
		verifyDisplayed(elelblAmountType,"Amount Type");
		verifyDisplayed(elelblAmount,"Amount");
		verifyDisplayed(elelblFrequency,"Frequency");
		verifyDisplayed(elelblBeginDate,"Begin Date");
		verifyDisplayed(elelblEndDate,"End Date");
		verifyDisplayed(elelblUpdatedOn, "Updated On");
		verifyDisplayed(elelblUpdatedBy, "Updated By");
		return this;
	}
	
	public ViewReferencePercentagesPage verifySuccessMessage() throws Exception
	{
		verifyExactText(eleErrStatusBar, "SAVED SUCCESSFULLY");
		return new ViewReferencePercentagesPage();
	}
}
