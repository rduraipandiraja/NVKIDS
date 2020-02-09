package gov.nv.dwss.nvkids.pages.refm;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class ViewReferencePercentagesPage extends CommonLocators
{
	public ViewReferencePercentagesPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Select Filter section
	@FindBy(xpath="//label[text()='Percentage Code']") WebElement elelblsfPercentageCode;
	@FindBy(xpath="//label[text()='Percentage Description']") WebElement elelblsfPercentageDescription;
	@FindBy(xpath="//label[text()=' From Date ']") WebElement elelblsfFromDate;
	@FindBy(xpath="//label[text()=' Through Date ']") WebElement elelblsfThroughDate;
	@FindBy(xpath="//label[text()='User']") WebElement elelblsfUser;
	@FindBy(xpath="//input[@id='percentageTypeCode']") WebElement eletxtsfPercentageCode;
	@FindBy(xpath="//input[@id='percentageTypeDesc']") WebElement eledsosfPercentageDescription;
	@FindBy(xpath="//input[@id='fromDate']") WebElement eletxtsfFromDate;
	@FindBy(xpath="(//label[text()=' From Date ']/following::button)[1]") WebElement eleicnFromDate;
	@FindBy(xpath="//input[@id='toDate']") WebElement eletxtsfThroughDate;
	@FindBy(xpath="(//label[text()=' Through Date ']/following::button)[1]") WebElement eleicnThroughDate;
	@FindBy(xpath="//input[@id='updatedByName']") WebElement eletxtsfUser;
	@FindBy(xpath="(//label[text()='User']/following::button)[1]") WebElement eleicnUser;
	@FindBy(xpath="//label[text()='Percentage Code']/following::span[1]") WebElement eleicnPercentageCode;
	@FindBy(xpath="//label[text()=' Code ']/following::td[2]") WebElement eleLOVValuePercentageCode;
	@FindBy(xpath="//label[text()=' Percentage Description ']/following::td[2]/span") WebElement elegrdPercentageDescription;
	@FindBy(xpath="//span[text()='Add New']") WebElement eleicnAddNew;
	@FindBy(xpath="//span[text()='Add Revision']") WebElement eleicnAddRevision;
	@FindBy(xpath="//tbody[@class='ui-table-tbody']/tr/td[5]/descendant::span") List<WebElement> eleGridDatas;
	
	
	
	//Grid Section
	@FindBy(xpath="//label[text()=' Percentage Code ']") WebElement elelblPercentageCode;
	@FindBy(xpath="//label[text()=' Percentage Description ']") WebElement elelblPercentageDescription;
	@FindBy(xpath="//label[text()=' Percentage % ']") WebElement elelblPercentage;
	@FindBy(xpath="//label[text()=' Begin Date ']") WebElement elelblBeginDate;
	@FindBy(xpath="//label[text()=' End Date ']") WebElement elelblEndDate;
	@FindBy(xpath="//label[text()=' Updated On ']") WebElement elelblUpdatedOn;
	@FindBy(xpath="//label[text()=' Updated By ']") WebElement elelblUpdatedBy;
	@FindBy(xpath="//label[text()='Percentage Code']/preceding::div[1]") WebElement elechkPercentageCode;
	@FindBy(xpath="//tbody[@class='ui-table-tbody']/tr[1]") WebElement eleGridFirstRow;
	@FindBy(xpath="//tbody[@class='ui-table-tbody']/tr[2]") WebElement eleGridSecondRow;
	@FindBy(xpath="(//tbody[@class='ui-table-tbody']/tr/td[4]/descendant::span)[1]") WebElement eleGridBeginDate;
	@FindBy(xpath="(//tbody[@class='ui-table-tbody']/tr/td[5]/descendant::span)[1]") WebElement eleGridEndDate;
	
	@FindBy(id="percentageTypeCode") WebElement elegsfdsoPercentageCode;
	@FindBy(id="percentageTypeDesc") WebElement elegsfdsoPercentageDescription;
	@FindBy(id="referencePct") WebElement elegsftxtPercentage;
	@FindBy(id="beginDate") WebElement elegsftxtBeginDate;
	@FindBy(id="endDate") WebElement elegsftxtEndDate;
	@FindBy(id="beginValidityDttm") WebElement elegsftxtUpdatedOn;
	@FindBy(id="updatedByName") WebElement elegsftxtUpdatedBy;
	@FindBy(xpath="//input[@id='referencePct']/following::td[3]/span") WebElement elegdataPercentage;
	@FindBy(xpath="//input[@id='beginDate']/following::td[4]/span") WebElement elegdataBeginDate;
	@FindBy(xpath="//input[@id='endDate']/following::td[5]/span") WebElement elegdataEndDate;
	@FindBy(xpath="//input[@id='beginValidityDttm']/following::td[6]/span") WebElement elegdataUpdatedOn;
	@FindBy(xpath="//input[@id='updatedByName']/following::td[7]/span") WebElement elegdataUpdatedBy;
	@FindBy(xpath="//label[text()=' Updated On ']/following::i[contains(@class,'ui-sortable-column-icon')][1]") WebElement eleSortUpdatedOn;
	@FindBy(xpath="//label[text()=' Updated On ']") WebElement elegridUpdatedOn;
	
	//Accordion Grid Section
	@FindBy(xpath="(//label[text()=' Percentage Code '])[2]") WebElement eleaccdnPercentageCode;
	@FindBy(xpath="(//label[text()=' Percentage Description '])[2]") WebElement eleaccdnPercentageDescription;
	@FindBy(xpath="(//label[text()=' Percentage % '])[2]") WebElement eleaccdnPercentage;
	@FindBy(xpath="(//label[text()=' Begin Date '])[2]") WebElement eleaccdnBeginDate;
	@FindBy(xpath="(//label[text()=' End Date '])[2]") WebElement eleaccdnEndDate;
	@FindBy(xpath="(//label[text()=' Updated On '])[2]") WebElement eleaccdnUpdatedOn;
	@FindBy(xpath="(//label[text()=' Updated By '])[2]") WebElement eleaccdnUpdatedBy;
	@FindBy(xpath="//lib-label-value/descendant::label") List<WebElement> elealbls;
	
	static String beginDate,endDate;
			
	public ViewReferencePercentagesPage verifyViewReferencePercentagesFields() throws Exception
	{
		verifyGridHeaders(elelblGridHeaders, "Percentage Description","Percentage %","Begin Date","End Date","Updated On","Updated By");
		return this;
	}

	public ViewReferencePercentagesPage verifySelectFilterFields() throws Exception
	{
		click(eleicnFilter,"Filter");
		verifyDisplayed(elelblsfPercentageCode,"Percentage Code");
		verifyDisplayed(elelblsfPercentageDescription,"Percentage Description");
		verifyDisplayed(elelblsfFromDate,"From Date");
		verifyDisplayed(elelblsfThroughDate,"Through Date");
		verifyDisplayed(elelblsfUser, "User");
		return this;
	}
	
	public ViewReferencePercentagesPage inquireWithValidValues(String percentageCode) throws Exception
	{
		click(eleicnFilter,"Filter");
		clearAndType(eletxtsfPercentageCode, "Percentage Code", percentageCode);
		pressEnterKey(eletxtsfPercentageCode);
		Thread.sleep(5000);
		verifyExactText(elegrdPercentageDescription, "INTEREST ON ARREARS"); 
		return this;
	}
	
		
	public AddReferencePercentagesPage navigatetoAddReferencePercentages() throws Exception
	{
		click(eleicnAddNew,"Add New");
		return new AddReferencePercentagesPage();
	}
	
	public EditReferencePercentagesPage inquireAndNavigatetoEditReferencePercentages(String percentageCode)
	{
		click(eleicnFilter,"Filter");
		clearAndType(eletxtsfPercentageCode, "Percentage Code", percentageCode);
		pressEnterKey(eletxtsfPercentageCode);
		String perDesc = elegrdPercentageDescription.getText();
		verifyExactText(elegrdPercentageDescription, perDesc); 
		doubleClickGridResult(eleGridResult,perDesc);	
		return new EditReferencePercentagesPage();
	}
	
	public AddRevisionReferencePercentagesPage navigatetoAddRevisionReferencePercentages(String percentageCode) throws Exception
	{
		inquireWithValidValues(percentageCode);
		Thread.sleep(3000);
		//elegrdPercentageDescription.click();
		click(elegrdPercentageDescription,"Grid Row");
		Thread.sleep(2000);
		click(eleicnAddRevision,"Add Revision");
		return new AddRevisionReferencePercentagesPage();
	}
	
	public EditReferencePercentagesPage clickEndDatedRecord() throws Exception
	{
		for (WebElement ele : eleGridDatas) 
		{
			if(ele.getText()!="")
			{
				String actdate=ele.getText().toString();
				SimpleDateFormat dt = new SimpleDateFormat("MM/dd/yyyy"); 
				Date date = new Date();
				String currentDate = dt.format(date);
				Date act = dt.parse(actdate);
				Date cur = dt.parse(currentDate);
				if(act.compareTo(cur)==-1)
				{
					 click(ele,"Grid Row");
					 doDoubleClick(ele);
					 break;
				} 
				else 
				{
					continue;
				}
			}
		}
		return new EditReferencePercentagesPage();
	}
	
		
	public EditReferencePercentagesPage navigateToEditReferencePercentages() throws InterruptedException
	{
		click(elegrdPercentageDescription,"Grid Row");
		doDoubleClick(elegrdPercentageDescription);
		return new EditReferencePercentagesPage();
	}
	
			
	public EditReferencePercentagesPage navigateToEditRefPerWithSecondGridRow() throws InterruptedException
	{
		Thread.sleep(4000);
		beginDate=eleGridBeginDate.getText().trim().toString();
		endDate=eleGridEndDate.getText().trim().toString();
		click(eleGridSecondRow,"Grid Row");
		doDoubleClick(eleGridSecondRow);
		return new EditReferencePercentagesPage();
	}
	
	public AddRevisionReferencePercentagesPage navigateToAddRevRefPerWithSecondGridRow() throws InterruptedException
	{
		Thread.sleep(4000);
		beginDate=eleGridBeginDate.getText().trim().toString();
		endDate=eleGridEndDate.getText().trim().toString();
		click(eleGridSecondRow,"Grid Row");
		click(eleicnAddRevision,"Add Revision");
		return new AddRevisionReferencePercentagesPage();
	}
	
	public ViewReferencePercentagesPage verifyClearIcon() throws Exception
	{
		click(eleicnFilter,"Filter");
		clearAndType(eletxtsfPercentageCode,"Percentage Code", getRandomAlphaChar((4)));
		clearAndType(eletxtsfFromDate,"From Date", "01012019");
		clearAndType(eletxtsfThroughDate,"Through Date", "02022019");
		clearAndType(eletxtsfUser, "User", getRandomAlphaChar(6));
		click(eleicnClear, "Clear");
		verifyFieldIsEmpty(eletxtsfPercentageCode);
		verifyFieldIsEmpty(eletxtsfFromDate);
		verifyFieldIsEmpty(eletxtsfThroughDate);
		verifyFieldIsEmpty(eletxtsfUser);
		return this;
	}
	
	public ViewReferencePercentagesPage verifyShowFilterFields() throws Exception
	{
      	selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		verifyDisplayed(elelblPercentageCode, "Percentage Code");
		verifyDisplayed(elelblPercentageDescription, "Percentage Description");
		verifyDisplayed(elelblPercentage,"Percentage");
		verifyDisplayed(elelblBeginDate, "Begin Date");
		verifyDisplayed(elelblEndDate, "End Date");
		verifyDisplayed(elelblUpdatedOn, "Updated On");
		verifyDisplayed(elelblUpdatedBy, "Updated By");
		return this;
	}
	
	public ViewReferencePercentagesPage inquireWithShowFilterPercentage() throws Exception
	{
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		String percentage = elegdataPercentage.getText();
		clearAndType(elegsftxtPercentage, "Percentage", percentage);
		pressEnterKey(elegsftxtPercentage);
		Thread.sleep(2000);
		verifyGridResult(eleGridResult, percentage);
		return this;
	}
	
	public ViewReferencePercentagesPage inquireWithShowFilterBeginDate() throws Exception
	{
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		String beginDate = elegdataBeginDate.getText();
		clearAndType(elegsftxtBeginDate, "Begin Date", beginDate);
		pressEnterKey(elegsftxtBeginDate);
		verifyGridResult(eleGridResult, beginDate);
		return this;
	}
	
	
	public ViewReferencePercentagesPage inquireWithShowFilterEndDate() throws Exception
	{
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		String endDate = elegdataEndDate.getText();
		clearAndType(elegsftxtEndDate, "End Date", endDate);
		pressEnterKey(elegsftxtEndDate);
		Thread.sleep(1000);
		verifyGridResult(eleGridResult, endDate);
		return this;
	}
	
	
	public ViewReferencePercentagesPage inquireWithShowFilterUpdatedOn() throws Exception
	{
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		String updatedOn = elegdataUpdatedOn.getText().substring(0,10);
		clearAndType(elegsftxtUpdatedOn, "Updated On", updatedOn);
		pressEnterKey(elegsftxtUpdatedOn);
		verifyGridResult(eleGridResult, updatedOn);
		return this;
	}
	
	public ViewReferencePercentagesPage inquireWithShowFilterUpdatedBy() throws Exception
	{
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		String updatedBy = elegdataUpdatedBy.getText();
		clearAndType(elegsftxtUpdatedBy, "Updated By", updatedBy);
		pressEnterKey(elegsftxtUpdatedBy);
		verifyGridResult(eleGridResult, updatedBy);
		return this;
	}
	
	public ViewReferencePercentagesPage testResetFilter() throws Exception
	{
		Thread.sleep(2000);
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		String percentage = elegdataPercentage.getText();
		clearAndType(elegsftxtPercentage, "Percentage", percentage);
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
		verifyFieldIsEmpty(elegsftxtPercentage);
		verifyFieldIsEmpty(elegsftxtBeginDate);
		verifyFieldIsEmpty(elegsftxtEndDate);
		verifyFieldIsEmpty(elegsftxtUpdatedOn);
		verifyFieldIsEmpty(elegsftxtUpdatedBy);
		return this;
	}
	
	public ViewReferencePercentagesPage checkShowColumnsOption() throws Exception
	{
		Thread.sleep(2000);
		verifyShowColumns(eleicnGridOptions, "Percentage Code","Percentage Description","Percentage %","Begin Date","End Date","Updated On","Updated By");
		return this;
	}
	
	public ViewReferencePercentagesPage sortByUpdatedOn() throws InterruptedException
	{
		wait = new WebDriverWait(driver, 20);
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
}

