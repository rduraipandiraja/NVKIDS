package gov.nv.dwss.nvkids.pages.fips;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class ViewFIPSInformationPage extends CommonLocators
{
	public ViewFIPSInformationPage() 
	{
		PageFactory.initElements(driver, this);
	}


	/* Select Filers: */

	@FindBy(xpath="//label[text()='FIPS Type']") public WebElement elelblFIPSType;
	@FindBy(xpath="//label[text()='FIPS Type']/following-sibling::p-dropdown/descendant::label") public WebElement eleddFIPSType;
	@FindBy(xpath="//label[text()='FIPS Sub Type']") public WebElement elelblFIPSSubType;
	@FindBy(xpath="//input[@id='fipsSubtypeCode']") public WebElement eletxtFIPSSubType;
	@FindBy(xpath="//input[@id='fipsSubtypeCode']/following-sibling::button") public WebElement eleicnlovFIPSSubType;
	@FindBy(xpath="//label[text()='FIPS IV-D Agency Code']") public WebElement elelblFIPSIVDAgencyCode;
	@FindBy(xpath="//input[@id='stateFipsCode']") public WebElement eletxtFIPSIVDAgencyCode;
	@FindBy(xpath="//input[@id='stateFipsCode']/following-sibling::button") public WebElement eleicnlovFIPSIVDAgencyCode;
	@FindBy(xpath="//label[text()='FIPS County Code']") public WebElement elelblFIPSCountyCode;
	@FindBy(xpath="//input[@id='countyFipsCode']") public WebElement eletxtFIPSCountyCode;
	@FindBy(xpath="//input[@id='countyFipsCode']/following-sibling::button") public WebElement eleicnlovFIPSCountyCode;
	@FindBy(xpath="//label[text()='FIPS Office Code']") public WebElement elelblFIPSOfficeCode;
	@FindBy(xpath="//input[@id='officeFipsCode']")public WebElement eletxtFIPSOfficeCode;
	@FindBy(xpath="//input[@id='officeFipsCode']/following-sibling::button")public WebElement eleicnlovFIPSOfficeCode;

	/* Grid show column: */
	@FindBy(xpath="//th/descendant::label[text()=' State Code ']") public WebElement elelblShowFilterStateCode;
	@FindBy(xpath="//th/descendant::input[@id='stateFipsCode']") public WebElement eledsoShowFilterStateCode;
	@FindBy(xpath="//th/descendant::label[text()=' County Code ']") public WebElement elelblShowFilterCountyCode;
	@FindBy(xpath="//th/descendant::input[@id='countyFipsCode']") public WebElement eletxtShowFilterCountyCode;
	@FindBy(xpath="//th/descendant::input[@id='countyFipsCode']/following-sibling::button") public WebElement eleicnlovShowFilterCountyCode; 
	@FindBy(xpath="//th/descendant::label[text()=' Office Code ']") public WebElement elelblShowFilterOfficeCode; 
	@FindBy(xpath="//th/descendant::input[@id='officeFipsCode']") public WebElement eletxtShowFilterOfficeCode; 
	@FindBy(xpath="//th/descendant::label[text()=' State ']") public WebElement elelblShowFilterState;
	@FindBy(xpath="//th/descendant::input[@id='stateName']") public WebElement eledsoShowFilterState; 
	@FindBy(xpath="//th/descendant::label[text()=' FIPS Name ']") public WebElement elelblShowFilterFIPSName;
	@FindBy(xpath="//th/descendant::input[@id='fipsName']") public WebElement eletxtShowFilterFIPSName; 
	@FindBy(xpath="//th/descendant::label[text()=' Contact Name ']") public WebElement elelblShowFilterContactName; 
	@FindBy(xpath="//th/descendant::input[@id='contactTitleName']") public WebElement eletxtShowFilterContactName; 
	@FindBy(xpath="//th/descendant::label[text()=' FIPS Type Code '] ") public WebElement elelblShowFilterFIPSTypeCode;
	@FindBy(xpath="//th/descendant::input[@id='fipsTypeCode']/ancestor::p-dropdown") public WebElement eleddShowFilterFIPSTypeCode;
	@FindBy(xpath="//th/descendant::label[text()=' FIPS Type ']") public WebElement elelblShowFilterFIPSType; 
	@FindBy(xpath="//th/descendant::input[@id='fipsTypeDesc']/ancestor::p-dropdown/descendant::label") public WebElement eleddShowFilterFIPSType; 
	@FindBy(xpath="//th/descendant::label[text()=' FIPS Sub Type Code ']") public WebElement elelblShowFilterFIPSSubTypeCode;
	@FindBy(xpath="//th/descendant::input[@id='fipsSubtypeCode']") public WebElement eletxtShowFilterFIPSSubTypeCode;
	@FindBy(xpath="//th/descendant::input[@id='fipsSubtypeCode']/following-sibling::button") public WebElement eleicnlovShowFilterFIPSSubTypeCode;
	@FindBy(xpath="//th/descendant::label[text()=' FIPS Sub Type ']") public WebElement elelblShowFilterFIPSSubType;
	@FindBy(xpath="//th/descendant::input[@id='fipsSubtypeDesc']") public WebElement eletxtShowFilterFIPSSubType;
	@FindBy(xpath="//th/descendant::input[@id='fipsSubtypeDesc']/following-sibling::button") public WebElement eleicnlovShowFilterFIPSSubType;


	@FindBy(xpath="//tr[1]/td/a/i") public WebElement eleicnAccrodion;


	/*Accordion fields: - FIPS Information section field set: */

	@FindBy(xpath="//legend[text()='FIPS Information']") WebElement elelblFIPSInformation;

	/* Address Information section field set: */
	@FindBy(xpath="//fieldset/legend[text()='FIPS Information']/following-sibling::div/descendant::label") public List<WebElement> elelblFIPSInfofields;

	/* Accordion fields: - CSENet Agreement section field set: */
	@FindBy(xpath="//legend[text()='CSENET Agreement']") WebElement elelblCSENetAgreement;
	@FindBy(xpath="//fieldset/legend[text()='CSENET Agreement']/following-sibling::div/descendant::label") public List<WebElement> elelblCSENetAgreementfields;

	/* Add Button */
	@FindBy(xpath="//span[text()='Add']") public WebElement eleicnAdd;

	/* Screen Function */
	@FindBy(xpath="//span[text()='CSENet IV-D Agency Agreements']") public WebElement elelinkCSENetScreen;

	
	


	public ViewCSENetInformationPage navigateToViewCSENetInformation() throws IOException, InterruptedException
	{   
		click(elelinkCSENetScreen, "View CSENET Screen function");
		return  new ViewCSENetInformationPage();
	}

	public AddFIPSInformationPage navigateToAddFIPSInformation() throws IOException, InterruptedException
	{   
		click(eleicnAdd, "Add Icon");
		return  new AddFIPSInformationPage();
	}


	public EditFIPSInformationPage navigateToEditFIPSInformation() throws IOException, InterruptedException
	{   
		Thread.sleep(3000);
		click(eleicnFilter, "Filter Icon");
		selectDropdownValue(eleddFIPSType, "COUNTY/LOCAL");

		setFocus(eletxtFIPSIVDAgencyCode);
		clearAndType(eletxtFIPSIVDAgencyCode, "FIPS IV-D Agency Code", "01");
		eletxtFIPSIVDAgencyCode.sendKeys(Keys.TAB);
		click(eleicnSearch, "Search Icon");
		Thread.sleep(3000);
		doubleClickGridResult(eleGridResult,"ALABAMA");
		return  new EditFIPSInformationPage();
	}


	public void verifyViewFIPSCodeInfo() throws Exception{
		verifyDisplayed(eleicnFilter, "Filter Icon");
		verifyGridHeaders(elelblGridHeaders," State Code ", " County Code "," Office Code "," State "," FIPS Name "," Contact Name "," FIPS Type "," FIPS Sub Type ");
		verifyAssociatedScreens(eleAssociatedScreenList,"Note Processor","Intergovernmental Correspondence","Order Wizard");
	}



	public  ViewFIPSInformationPage verifySelecFilters() throws Exception{
		Thread.sleep(2000);
		click(eleicnFilter, "Filter Icon");
		Thread.sleep(2000);
		verifyDisplayed(elelblFIPSType, "FIPS Type");
		verifyDisplayed(elelblFIPSSubType, "FIPS Sub Type");
		verifyDisplayed(elelblFIPSIVDAgencyCode, "FIPS IV-D Agency Code");
		verifyDisplayed(elelblFIPSCountyCode, "FIPS County Code");
		verifyDisplayed(elelblFIPSOfficeCode, "FIPS Office Code");
		verifyDisplayed(eleicnClear, "Clear Icon");
		verifyDisplayed(eleicnSearch, "Search Icon");

		return this;
	}

	public void InquireValidValueTypeAndAgencyCode(String sqlQuery , String FIPSType, String AgencyCode) throws InterruptedException, ClassNotFoundException, SQLException {


		Thread.sleep(3000);
		click(eleicnFilter, "Filter Icon");
		selectDropdownValue(eleddFIPSType, selectQuery(sqlQuery,FIPSType) );
		setFocus(eletxtFIPSIVDAgencyCode);
		clearAndType(eletxtFIPSIVDAgencyCode, "FIPS IV-D Agency Code", selectQuery(sqlQuery,AgencyCode));
		click(eleicnSearch, "Search Icon");
		Thread.sleep(3000);
		verifyGridResult(eleGridResult,selectQuery(sqlQuery,FIPSType));

	}
	public void InquireValidValueSubTypeAndAgencyCode(String query, String FIPSType, String SubType,String SubTypeDec, String AgencyCode) throws InterruptedException, ClassNotFoundException, SQLException, IOException {
		Thread.sleep(3000);
		click(eleicnFilter, "Filter Icon");
		selectDropdownValue(eleddFIPSType, FIPSType );
		click(eleicnlovFIPSSubType, "FIPS Sub Type LOV");
		clearAndType(eleSearchBarSearch, "Search text box " ,selectQuery(query,SubType));
		delay(3000);
		pressEnterKey(eleSearchBarSearch);
		doubleClickGridResult(eleGridCells, selectQuery(query,SubType));		
		setFocus(eletxtFIPSIVDAgencyCode);
		clearAndType(eletxtFIPSIVDAgencyCode, "FIPS IV-D Agency Code", selectQuery(query,AgencyCode));
		click(eleicnSearch, "Search Icon");
		Thread.sleep(3000);
		verifyGridResult(eleGridResult,selectQuery(query,SubTypeDec));
	
	}



	public void InquireValidValueinFIPSAgencyCode(String query, String AgencyCode , String AgencyDesc) throws InterruptedException, ClassNotFoundException, SQLException {


		Thread.sleep(3000);
		click(eleicnFilter, "Filter Icon");
		//selectDropdownValue(eleddFIPSType, FIPSType );
		click(eleicnlovFIPSIVDAgencyCode, "FIPS IV-D Agency Code LOV");
		String agencyCode = selectQuery(query, AgencyCode);
		clearAndType(eleSearchBarSearch, "Search Text box" ,agencyCode);
		pressEnterKey(eleSearchBarSearch);
		Thread.sleep(3000);
		doubleClickGridResult(eleGridCells,agencyCode);
		click(eleicnSearch, "Search Icon");
		Thread.sleep(3000);
		verifyGridResult(eleGridResult,agencyCode);

	}



	public void InquireValidValueinFIPSCountyCode(String query,String agencyCode, String countyCode) throws InterruptedException, ClassNotFoundException, SQLException {


		Thread.sleep(3000);
		click(eleicnFilter, "Filter Icon");
		setFocus(eletxtFIPSIVDAgencyCode);
		String agency = selectQuery(query, agencyCode);
		String county = selectQuery(query, countyCode);
		
		clearAndType(eletxtFIPSIVDAgencyCode, "FIPS IV-D Agency Code", agency);
		setFocus(eletxtFIPSCountyCode);
		clearAndType(eletxtFIPSCountyCode, "FIPS County Code", county);
		click(eleicnSearch, "Search Icon");
		Thread.sleep(3000);
		verifyGridResult(eleGridResult,county);
	}


	public ViewFIPSInformationPage inquireValidValuesinFIPSOfficeCode(String query,String agencyCode, String countyCode,String officeCode) throws InterruptedException, AWTException, ClassNotFoundException, SQLException, IOException{
		Thread.sleep(2000);
		click(eleicnFilter, "Filter Icon");
		setFocus(eletxtFIPSIVDAgencyCode);
		String agency = selectQuery(query, agencyCode);
		String county = selectQuery(query, countyCode);
		String office = selectQuery(query, officeCode);
		delay(3000);
		clearAndType(eletxtFIPSIVDAgencyCode, "FIPS IV-D Agency Code", agency);
		setFocus(eletxtFIPSCountyCode);
		clearAndType(eletxtFIPSCountyCode, "FIPS County Code", county);
		setFocus(eletxtFIPSOfficeCode);
		clearAndType(eletxtFIPSOfficeCode,"FIPS Office Code", office);
		click(eleicnSearch, "Search Icon");
		Thread.sleep(4000);
		verifyGridResult(eleGridResult, office);
		return this;
	}




	public  ViewFIPSInformationPage searchSelectFilters(String query, String agencyCode) throws InterruptedException, ClassNotFoundException, SQLException {
		Thread.sleep(3000);
		click(eleicnFilter, "Filter Icon");
		setFocus(eletxtFIPSIVDAgencyCode);
		String agencyValue = selectQuery(query, agencyCode);
		clearAndType(eletxtFIPSIVDAgencyCode, "FIPS IV-D Agency Code", agencyValue);
		click(eleicnSearch, "Search Icon");
		Thread.sleep(3000);

		return this;
	}

	public void checkShowFiltersFIPS(String query, String agencyCode) throws Exception{
		searchSelectFilters(query, agencyCode);
		click(eleicnGridOptions, "Grid Options Icon");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions, "Grid Options Icon");
		verifyDisplayed(elelblShowFilterStateCode,"FIPS State Code");
		verifyDisplayed(elelblShowFilterCountyCode, "FIPS County Code");
		verifyDisplayed(elelblShowFilterOfficeCode, "FIPS Office Code");
		verifyDisplayed(elelblShowFilterState, "State");
		verifyDisplayed(elelblShowFilterFIPSName, "FIPS Name");
		verifyDisplayed(elelblShowFilterContactName, "Contact Name");
		verifyDisplayed(elelblShowFilterFIPSType, "FIPS Type");
		verifyDisplayed(elelblShowFilterFIPSSubType, "FIPS Sub Type");

	}


	public void InquireValidValueinSFCountyCode(String query,String agencyCode,String countyCode ) throws InterruptedException, ClassNotFoundException, SQLException {

		searchSelectFilters(query, agencyCode);
		click(eleicnGridOptions, "Grid Options Icon");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions, "Grid Options Icon");
		Thread.sleep(3000);
		String countyValue = selectQuery(query, countyCode);
		clearAndType(eletxtShowFilterCountyCode, "County Code", countyValue);
		eletxtShowFilterCountyCode.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		verifyGridResult(eleGridResult,countyValue);		
	}


	

	public void InquireValidValueinSFOfficeCode(String query,String agencyCode,String countyCode, String officeCode) throws InterruptedException, ClassNotFoundException, SQLException {

		searchSelectFilters(query,agencyCode );
		click(eleicnGridOptions, "Grid Options Icon");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions, "Grid Options Icon");
		Thread.sleep(3000);
		String countyValue = selectQuery(query, countyCode);
		String officeValue = selectQuery(query, officeCode);
		clearAndType(eletxtShowFilterCountyCode, "County Code", countyValue);
		setFocus(eletxtShowFilterOfficeCode);
		clearAndType(eletxtShowFilterOfficeCode, "Office Code", officeValue);
		eletxtShowFilterCountyCode.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		verifyGridResult(eleGridResult,officeValue);		
	}


	

	public void InquireValidValueinSFFIPSName(String query,String agencyCode,String fipsName) throws InterruptedException, ClassNotFoundException, SQLException {

		searchSelectFilters(query, agencyCode);
		click(eleicnGridOptions, "Grid Options Icon");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions, "Grid Options Icon");
		Thread.sleep(3000);
		setFocus(eletxtShowFilterFIPSName);
		String fName = selectQuery(query, fipsName);
		System.out.println(fName +"FIPS NAME Displayed");
		clearAndType(eletxtShowFilterFIPSName, "FIPS Name", fName);
		pressEnterKey(eletxtShowFilterFIPSName);
		Thread.sleep(1000);
		verifyGridContainsData(eleGridResult, fName);
			
	}


	
	public void InquireValidValueinSFContactName(String query,String agencyCode,String contact) throws InterruptedException, ClassNotFoundException, SQLException {

		searchSelectFilters(query,agencyCode);
		click(eleicnGridOptions, "Grid Options Icon");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions, "Grid Options Icon");
		Thread.sleep(3000);
		String cName = selectQuery(query, contact);
		System.out.println(cName + "Contact Name Displayed");
		clearAndType(eletxtShowFilterContactName, "Contact Name", cName);
		pressEnterKey(eletxtShowFilterContactName);
		Thread.sleep(2000);
		verifyGridResult(eleGridResult,cName);		
	}


	

	public ViewFIPSInformationPage verifySelectingFIPSTypeCode(String query,String agencyCode,String fipsTypeCode) throws InterruptedException, ClassNotFoundException, SQLException {
		searchSelectFilters(query,agencyCode);

		selectShowColumnFIPS("FIPS Type Code");
		click(eleicnGridOptions, "Grid Options Icon");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions, "Grid Options Icon");
		Thread.sleep(3000);
		String fTypeCode = selectQuery(query, fipsTypeCode);
		selectDropdownValue(eleddShowFilterFIPSTypeCode, fTypeCode);
		verifyGridResult(eleGridResult,fTypeCode);		
		return this;

	}
	

	public ViewFIPSInformationPage verifySelectingFIPSType(String query,String agencyCode,String fipsTypeDesc) throws InterruptedException, ClassNotFoundException, SQLException {
		searchSelectFilters(query,agencyCode);
		selectShowColumnFIPS("FIPS Type Code");
		click(eleicnGridOptions, "Grid Options Icon");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions, "Grid Options Icon");
		String fTypeDesc = selectQuery(query, fipsTypeDesc);
		selectDropdownValue(eleddShowFilterFIPSType, fTypeDesc);
		verifyGridResult(eleGridResult,fTypeDesc);		
		return this;

	}

	

	public void InquireValidValueinSFFIPSSubTypeCode(String query,String agencyCode,String fipsSubTypeCode) throws InterruptedException, ClassNotFoundException, SQLException {

		searchSelectFilters(query,agencyCode);
		selectShowColumnFIPS("FIPS Sub Type Code");
		click(eleicnGridOptions, "Grid Options Icon");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions, "Grid Options Icon");
		Thread.sleep(3000);
		String fSubTypeCode = selectQuery(query, fipsSubTypeCode);
		clearAndType(eletxtShowFilterFIPSSubTypeCode, "Sub Type Code", fSubTypeCode);
		eletxtShowFilterFIPSSubTypeCode.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		verifyGridResult(eleGridResult,fSubTypeCode);		
	}


	
	public void InquireValidValueinSFFIPSSubType(String query,String agencyCode,String fipsSubTypeCode , String fipsSubTypeDesc) throws InterruptedException, ClassNotFoundException, SQLException {
		searchSelectFilters(query,agencyCode);
		click(eleicnGridOptions, "Grid Options Icon");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions, "Grid Options Icon");
		Thread.sleep(3000);
		String fSubTypeCode = selectQuery(query, fipsSubTypeCode);
		String fSubTypeDesc = selectQuery(query, fipsSubTypeDesc);
		clearAndType(eletxtShowFilterFIPSSubType, "FIPS Sub Type", fSubTypeCode);
		eletxtShowFilterFIPSSubType.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		verifyGridResult(eleGridResult,fSubTypeDesc);		
	}


	

	
	public void verifyFieldDisappeared(WebElement lbl , WebElement ele) {
		try {
			if(ele.isDisplayed()==false) {
				reportStep("The element:"+lbl.getText()+" is Disappeared", "pass");
			}
			else if(ele.isDisplayed()==true) {
				reportStep("The element:"+lbl.getText()+" Show Filter is Still appeared", "fail");
			}
		}
		catch(Exception e) 
		{
			reportStep("The element:"+lbl.getText()+" Show Filter is Disappeared", "pass");
		}
		finally {
			takeSnap();
		}

	}

	


	public void verifyShowColumnsFIPS(String query, String agencyCode ) throws Exception{
		searchSelectFilters(query,agencyCode);
		verifyShowColumns(eleicnGridOptions,"State Code","County Code","Office Code","State","FIPS Name","Contact Name","FIPS Type Code","FIPS Type","FIPS Sub Type Code","FIPS Sub Type");
	}

	public void selectShowColumnFIPS(String column) throws InterruptedException{

		Thread.sleep(3000);
		selectShowColumn(eleicnGridOptions,column);
	}

	
		


	public ViewFIPSInformationPage verifyAccordionFields(String query, String agencyCode) throws InterruptedException, ClassNotFoundException, SQLException {
		searchSelectFilters(query,agencyCode);
		click(eleicnAccrodion, "Accordion icon");
		verifyFieldSetLabels(elelblFIPSInfofields, " Address "," Phone "," Reciprocity with the United States " ," Fax "," Comments "," Contact Email ");
		verifyFieldSetLabels(elelblCSENetAgreementfields, " Collections "," Quick Locate "," Case Summary Information "," Managing State Cases "," Establishment "," Paternity "," Enforcement ");
		verifyAccordionicondisplay(eleicnAccrodion);
		return this;
	}

	
	

	

	public void verifyAccordionicondisplay(WebElement ele) {
		try {


			if(ele.getAttribute("class").contains("chevron-up")) {
				reportStep("Accordion icon is pointed Up", "pass");

			}
			else if(ele.getAttribute("class").contains("chevron-down")) {
				reportStep("Accordion icon is pointed down", "pass");
			}
		}
		catch (Exception e) {
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable find Accordion icon --> " + error, "fail");
			Assert.fail("Unable to find Accordion icon");
		}
		finally {
			takeSnap();
		}
	}




}
