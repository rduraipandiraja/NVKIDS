package gov.nv.dwss.nvkids.pages.refm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.math3.util.ContinuedFraction;
import org.apache.poi.ss.formula.functions.EDate;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class ViewReferenceAmountsPage extends CommonLocators
{
	public ViewReferenceAmountsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	ViewReferencePercentagesPage rp=new ViewReferencePercentagesPage();
	
	//Select Filter section
	@FindBy(xpath="//label[text()='Amount Code']") WebElement elelblsfAmountCode;
	@FindBy(id="amountTypeCode") WebElement eletxtsfAmountCode;
	@FindBy(xpath="(//label[text()='Amount Code']/following::button)[1]") WebElement eleicnAmountCode;
	@FindBy(xpath="//label[text()='Description']") WebElement elelblsfDescription;
	@FindBy(id="amountTypeDesc") WebElement eledsosfDescription;
	@FindBy(xpath="//label[text()=' From Date ']") WebElement elelblsfFromDate;
	@FindBy(id="fromDate") WebElement eletxtsfFromDate;
	@FindBy(xpath="(//label[text()='From Date']/following::button)[1]") WebElement eleicnFromDate;
	@FindBy(xpath="//label[text()=' Through Date ']") WebElement elelblsfThroughDate;
	@FindBy(id="toDate") WebElement eletxtsfThroughDate;
	@FindBy(xpath="(//label[text()='Through Date']/following::button)[1]") WebElement eleicnThroughDate;
	@FindBy(xpath="//label[text()='User']") WebElement elelblsfUser;
	@FindBy(id="updatedByName") WebElement eletxtsfUser;
	@FindBy(xpath="(//label[text()='User']/following::button)[1]") WebElement eleicnUser;
	@FindBy(xpath="//label[text()='Frequency']") WebElement elelblsfFrequency;
	@FindBy(xpath="//label[text()='Frequency']/following-sibling::p-dropdown") WebElement eleddsfFrequency;
	@FindBy(xpath="(//p-dropdown//div[contains(@class,'dropdown-trigger')])[2]") WebElement eleicnFrequency;
	@FindBy(xpath="//tbody[@class='ui-table-tbody']/tr/td[5]/descendant::span") List<WebElement> eleGridAllBeginDate;
	@FindBy(xpath="//tbody[@class='ui-table-tbody']/tr/td[6]/descendant::span") List<WebElement> eleGridAllEndDate;
	@FindBy(xpath="(//tbody[@class='ui-table-tbody']/tr/td[5]/descendant::span)[1]") WebElement eleGridBeginDate;
	@FindBy(xpath="(//tbody[@class='ui-table-tbody']/tr/td[6]/descendant::span)[1]") WebElement eleGridEndDate;
	@FindBy(xpath="//label[text()=' Updated On ']/following::i[contains(@class,'ui-sortable-column-icon')][1]") WebElement eleSortUpdatedOn;
	@FindBy(xpath="//label[text()=' Updated On ']") WebElement elegridUpdatedOn;
	@FindBy(xpath="//input[@id='feeAmt']/following::td[3]/span") WebElement elegdataAmount;
	@FindBy(xpath="//input[@id='amountFrequencyCode']/following::td[4]/span") WebElement elegdataFrequency;
	@FindBy(xpath="//input[@id='beginDate']/following::td[5]/span") WebElement elegdataBeginDate;
	@FindBy(xpath="//input[@id='endDate']/following::td[6]/span") WebElement elegdataEndDate;
	@FindBy(xpath="//input[@id='beginValidityDttm']/following::td[7]/span") WebElement elegdataUpdatedOn;
	@FindBy(xpath="//input[@id='updatedByName']/following::td[8]/span") WebElement elegdataUpdatedBy;
	
	//Grid Section	
	@FindBy(xpath="//label[text()=' Amount Code ']") WebElement elelblAmountCode;
	@FindBy(xpath="//label[text()=' Amount Type ']") WebElement elelblAmountType;
	@FindBy(xpath="//label[text()=' Amount ']") WebElement elelblAmount;
	@FindBy(xpath="//label[text()=' Frequency ']") WebElement elelblFrequency;
	@FindBy(xpath="//label[text()=' Begin Date ']") WebElement elelblBeginDate;
	@FindBy(xpath="//label[text()=' End Date ']") WebElement elelblEndDate;
	@FindBy(xpath="//label[text()=' Updated On ']") WebElement elelblUpdatedOn;
	@FindBy(xpath="//label[text()=' Updated By ']") WebElement elelblUpdatedBy;
	@FindBy(id="amountTypeCode") WebElement elegsfdsoAmountCode;
	@FindBy(id="amountTypeDesc") WebElement elegsfdsoAmountType;
	@FindBy(id="feeAmt") WebElement elegsftxtAmount;
	@FindBy(xpath="//label[text()=' Frequency ']/following::p-dropdown") WebElement elegsfddFrequency;
	@FindBy(id="beginDate") WebElement elegsftxtBeginDate;
	@FindBy(id="endDate") WebElement elegsftxtEndDate;
	@FindBy(id="beginValidityDttm") WebElement elegsftxtUpdatedOn;
	@FindBy(id="updatedByName") WebElement elegsftxtUpdatedBy;
	@FindBy(xpath="//label[text()=' Amount Type ']/following::td[2]/span") WebElement elegrddataAmountType;
	
		
	//Grid Accordion Section
	
	@FindBy(xpath="//lib-label-value/descendant::label") List<WebElement> elealbls;
	
	static String beginDate,endDate;
						
	public AddReferenceAmountsPage navigatetoAddReferenceAmounts()
	{
		click(rp.eleicnAddNew, "Add New");
		return new AddReferenceAmountsPage();
	}
	
	public AddRevisionReferenceAmountsPage navigatetoAddRevisionReferenceAmounts(String amountCode) throws Exception
	{
		inquireWithValidValues(amountCode);
		Thread.sleep(4000);
		click(elegrddataAmountType,"Grid Row");
		Thread.sleep(3000);
		click(rp.eleicnAddRevision,"Add Revision");
		return new AddRevisionReferenceAmountsPage();
	}
	
	
	public EditReferenceAmountsPage navigatetoEditReferenceAmounts(String amountCode) throws Exception
	{
		inquireWithValidValues(amountCode);
		String amtType = elegrddataAmountType.getText();
		doubleClickGridResult(eleGridResult,amtType);	
		return new EditReferenceAmountsPage();
	}
	
	public EditReferenceAmountsPage navigatetoEditReferenceAmountsWithFirstGridRow() throws Exception
	{
		
		click(elegrddataAmountType,"Grid Row");
		doDoubleClick(elegrddataAmountType);	
		return new EditReferenceAmountsPage();
	}
	
	public EditReferenceAmountsPage navigatetoEditReferenceAmountsWithSecondGridRow() throws InterruptedException
	{
		Thread.sleep(3000);
		beginDate=eleGridBeginDate.getText().trim().toString();
		endDate=eleGridEndDate.getText().trim().toString();
		click(rp.eleGridSecondRow,"Grid Row");
		doDoubleClick(rp.eleGridSecondRow);	
		return new EditReferenceAmountsPage();
	}
	
	public AddRevisionReferenceAmountsPage navigatetoAddRevReferenceAmountsWithSecondGridRow() throws InterruptedException
	{
		Thread.sleep(3000);
		beginDate=eleGridBeginDate.getText().trim().toString();
		endDate=eleGridEndDate.getText().trim().toString();
		click(rp.eleGridSecondRow,"Grid Row");
		click(rp.eleicnAddRevision,"Add Revision");
		return new AddRevisionReferenceAmountsPage();
	}
	
	public ViewReferenceAmountsPage sortByUpdatedOn() throws InterruptedException
	{
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(elegridUpdatedOn));
		Actions build = new Actions(driver);
		build.moveToElement(elegridUpdatedOn).build().perform();
		Thread.sleep(2000);
		if(eleSortUpdatedOn.isDisplayed())
		{
			click(eleSortUpdatedOn,"Updated On");
		}
		else
		{
			click(elegridUpdatedOn,"Updated On");
		}
		return this;
	}
	
	public EditReferenceAmountsPage selectPastBegindateAndNavigate() throws ParseException
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
		return new EditReferenceAmountsPage();
	}
	
	public EditReferenceAmountsPage selectFutureEnddateAndNavigate() throws ParseException
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
					click(val,"Grid Row");
					doDoubleClick(val);
					break;
				}
				else if(eDate==null)
				{
					click(val,"Grid Row");
					doDoubleClick(val);
					break;
				}
								
			}
		}
		catch(Exception e)
		{

		}
		return new EditReferenceAmountsPage();
	}
	
	public EditReferenceAmountsPage selectNonEndDatedRecordAndNavigate() throws ParseException
	{
		try
		{
			Thread.sleep(3000);
			for (WebElement val : eleGridAllEndDate) 
			{
				String bDate = val.getText();
				SimpleDateFormat dt = new SimpleDateFormat("MM/dd/yyyy");
				Date pastDate = dt.parse(bDate);
				Date currentDate = new Date();
				String curDate = dt.format(currentDate);
				Date cDate = dt.parse(curDate);
				if(pastDate.compareTo(cDate)==1)
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
		return new EditReferenceAmountsPage();
	}
	
	public EditReferenceAmountsPage selectEndDatedRecordAndNavigate() throws ParseException
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
				if(pastDate.compareTo(cDate)==-1)
				{
					click(val,"Grid Row");
					doDoubleClick(val);
					break;
				}
				else if(eDate==null)
				{
					click(val,"Grid Row");
					doDoubleClick(val);
					break;
				}
								
			}
		}
		catch(Exception e)
		{

		}
		return new EditReferenceAmountsPage();
	}
	
	public ViewReferenceAmountsPage navigateToLastGridPage() throws Exception
	{
		try
		{
			if(eleicnLastPagination.isEnabled())
			{
				click(eleicnLastPagination,"Last Page Icon");
				Thread.sleep(3000);
			}
		}
		catch(Exception e)
		{
			
		}
		return this;
	}
	
	public ViewReferenceAmountsPage verifyFilterSectionFields() throws Exception
	{
		click(eleicnFilter,"Filter");
		verifyDisplayed(elelblsfAmountCode, "Amount Code");
		verifyDisplayed(elelblsfDescription,"Description");
		verifyDisplayed(elelblsfFromDate, "From Date");
		verifyDisplayed(elelblsfThroughDate,"Through Date");
		verifyDisplayed(elelblsfUser,"User");
		verifyDisplayed(elelblsfFrequency, "Frequency");
		return this;
	}
	
	public ViewReferenceAmountsPage verifyGridFields() throws Exception
	{
		verifyGridHeaders(elelblGridHeaders, "Amount Type","Amount","Frequency","Begin Date","End Date","Updated On","Updated By");
		return this;
	}
	
	public ViewReferenceAmountsPage inquireWithValidValues(String amountCode) throws Exception
	{
		click(eleicnFilter,"Filter");
		clearAndType(eletxtsfAmountCode, "Amount Code", amountCode);
		pressEnterKey(eletxtsfAmountCode);
		Thread.sleep(2000);
		String amtCode = elegrddataAmountType.getText();
		verifyGridResult(eleGridResult, amtCode);
		return new ViewReferenceAmountsPage();
	}
	
	public ViewReferenceAmountsPage verifyClearIcon() throws Exception
	{
		click(eleicnFilter,"Filter");
		clearAndType(eletxtsfAmountCode,"Amount Code", getRandomAlphaChar((4)));
		clearAndType(eletxtsfFromDate,"From Date", "01012019");
		clearAndType(eletxtsfThroughDate,"Through Date", "02022019");
		clearAndType(eletxtsfUser, "User", getRandomAlphaChar(6));
		selectRandomDropdownValue(eleddsfFrequency);
		click(eleicnClear, "Clear");
		verifyFieldIsEmpty(eletxtsfAmountCode);
		verifyFieldIsEmpty(eletxtsfFromDate);
		verifyFieldIsEmpty(eletxtsfThroughDate);
		verifyFieldIsEmpty(eletxtsfUser);
		verifyExactText(eleddsfFrequency, "--Select--");
		return this;
	}
	
	public ViewReferenceAmountsPage verifyShowFilterFields() throws Exception
	{
      	selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		verifyDisplayed(elelblAmountCode, "Amount Code");
		verifyDisplayed(elelblAmountType, "Amount Type");
		verifyDisplayed(elelblAmount, "Amount");
		verifyDisplayed(elelblFrequency, "Frequency");
		verifyDisplayed(elelblBeginDate, "Begin Date");
		verifyDisplayed(elelblEndDate, "End Date");
		verifyDisplayed(elelblUpdatedOn, "Updated On");
		verifyDisplayed(elelblUpdatedBy, "Updated By");
		return this;
	}
	
	public ViewReferenceAmountsPage inquireWithShowFilterAmount() throws Exception
	{
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		String amount = elegdataAmount.getText();
		clearAndType(elegsftxtAmount, "Amount", amount);
		pressEnterKey(elegsftxtAmount);
		Thread.sleep(2000);
		verifyGridResult(eleGridResult, amount);
		return this;
	}
	
	public ViewReferenceAmountsPage inquireWithShowFilterFrequency() throws Exception
	{
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		String frequency = elegdataFrequency.getText();
		selectDropdownValue(elegsfddFrequency, frequency);
		Thread.sleep(2000);
		verifyGridResult(eleGridResult, frequency);
		return this;
	}
	
	public ViewReferenceAmountsPage inquireWithShowFilterBeginDate() throws Exception
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
	
	public ViewReferenceAmountsPage inquireWithShowFilterEndDate() throws Exception
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
	
	public ViewReferenceAmountsPage inquireWithShowFilterUpdatedOn() throws Exception
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
	
	public ViewReferenceAmountsPage inquireWithShowFilterUpdatedBy() throws Exception
	{
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		String updatedBy = elegdataUpdatedBy.getText().substring(0,10);
		clearAndType(elegsftxtUpdatedBy, "Updated By", updatedBy);
		pressEnterKey(elegsftxtUpdatedBy);
		Thread.sleep(2000);
		verifyGridResult(eleGridResult, updatedBy);
		return this;
	}
	
	public ViewReferenceAmountsPage testResetFilter() throws Exception
	{
		Thread.sleep(2000);
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		String amount = elegdataAmount.getText();
		clearAndType(elegsftxtAmount, "Amount", amount);
		String frequency = elegdataFrequency.getText();
		selectDropdownValue(elegsfddFrequency, frequency);
		String beginDate = elegdataBeginDate.getText().substring(0,9);
		clearAndType(elegsftxtBeginDate, "Begin Date", beginDate);
		String endDate = elegdataEndDate.getText().substring(0,9);
		clearAndType(elegsftxtEndDate, "End Date", endDate);
		String updatedOn = elegdataUpdatedOn.getText().substring(0,9);
		clearAndType(elegsftxtUpdatedOn, "Updated On", updatedOn);
		String updatedBy = elegdataUpdatedBy.getText().substring(0,9);
		clearAndType(elegsftxtUpdatedBy, "Updated By", updatedBy);
		pressEnterKey(elegsftxtUpdatedBy);
		click(eleicnGridOptions,"Grid Options");
		clickResetFilter(eleGridResetFilters);
		click(eleicnGridOptions,"Grid Options");
		verifyFieldIsEmpty(elegsftxtAmount);
		verifyFieldIsEmpty(elegsfddFrequency);
		verifyFieldIsEmpty(elegsftxtBeginDate);
		verifyFieldIsEmpty(elegsftxtEndDate);
		verifyFieldIsEmpty(elegsftxtUpdatedOn);
		verifyFieldIsEmpty(elegsftxtUpdatedBy);
		return this;
	}
	
	public ViewReferenceAmountsPage checkShowColumnsOption() throws Exception
	{
		Thread.sleep(2000);
		verifyShowColumns(eleicnGridOptions, "Amount Code","Amount Type","Amount","Frequency","Begin Date","End Date","Updated On","Updated By");
		return this;
	}
}
