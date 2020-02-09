package gov.nv.dwss.nvkids.pages.refm;

import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.nv.dwss.nvkids.pages.bstl.PrintQueueErrorsPage;
import gov.nv.dwss.nvkids.pages.dref.ViewDocumentAttributesPage;
import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class ViewReferenceCodesPage extends CommonLocators
{
	public ViewReferenceCodesPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	//Associated screens section
	@FindBy(xpath="//span[text()='Note Processor']") WebElement elelinkNoteProcessor;
	
	//screen functions
	@FindBy(xpath="//span[text()='Reference Percentages']") WebElement elelinkReferencePercentages;
	@FindBy(xpath="//span[text()='Reference Amounts']") WebElement elelinkReferenceAmounts;
	@FindBy(xpath="//span[text()='Performance Measure Goals']") WebElement elelinkPerformanceMeasureGoals;
	
	//Select Filter section
	@FindBy(xpath="//label[text()='Reference Entity']") WebElement elelblsfReferenceEntity;
	@FindBy(xpath="//input[@id='entityName']") WebElement eletxtReferenceEntity;
	@FindBy(xpath="//input[@id='entityName']/following::button[1]") WebElement eleicnReferenceEntity;
	@FindBy(xpath="//label[text()=' Entity Name ']/following::td[1]/span") WebElement elelovvalReferenceEntity;
	@FindBy(xpath="//label[text()='Reference Attribute']") WebElement elelblsfReferenceAttribute;
	@FindBy(id="attributeName") WebElement eletxtReferenceAttribute;
	@FindBy(xpath="//input[@id='attributeName']/following::button[1]") WebElement eleicnReferenceAttribute;
	@FindBy(xpath="//label[text()=' Attribute Name ']/following::td[1]") WebElement elelovvalReferenceAttribute;
	@FindBy(xpath="//label[text()='Reference Description']") WebElement elelblsfReferenceDescription;
	@FindBy(xpath="//input[@id='attributeDesc']") WebElement eledsoReferenceDescription;
	@FindBy(xpath="//label[text()=' From Date ']") WebElement elelblsfFromDate;
	@FindBy(xpath="//input[@id='fromDate']") WebElement eletxtFromDate;
	@FindBy(xpath="(//label[text()=' From Date ']/following::button)[1]") WebElement eleicnFromDate;
	@FindBy(xpath="//label[text()=' Through Date ']") WebElement elelblsfThroughDate;
	@FindBy(xpath="//input[@id='toDate']") WebElement eletxtThroughDate;
	@FindBy(xpath="(//label[text()=' Through Date ']/following::button)[1]") WebElement eleicnThroughDate;
	@FindBy(xpath="//span[text()='Select Reference Entity']/following::input") WebElement eletxtsearchReferenceEntity;
	@FindBy(xpath="//span[text()='Select Reference Attribute']/following::input") WebElement eletxtsearchReferenceAttribute;
	
	
		
	//Grid section
	@FindBy(xpath="//label[text()=' Reference Entity ']") WebElement elelblReferenceEntity;
	@FindBy(xpath="//label[text()=' Reference Attribute ']") WebElement elelblReferenceAttribute;
	@FindBy(xpath="//label[text()=' Reference Description ']") WebElement elelblReferenceDescription;
	@FindBy(xpath="//label[text()=' Code ']") WebElement elelblCode;
	@FindBy(xpath="//label[text()=' Code Description ']") WebElement elelblCodeDescription;
	@FindBy(xpath="//label[text()=' Updated On ']") WebElement elelblUpdatedOn;
	@FindBy(xpath="//label[text()=' Updated By ']") WebElement elelblUpdatedBy;
	@FindBy(xpath="//label[text()=' Reference Entity ']/following::td[1]") WebElement eledsoReferenceEntity;
	@FindBy(xpath="//label[text()=' Reference Entity ']/following::td[2]") WebElement eledsoReferenceAttribute;
	@FindBy(id="entityName") WebElement elegsfdsoReferenceEntity;
	@FindBy(id="attributeName") WebElement elegsfdsoReferenceAttribute;
	@FindBy(id="attributeDesc") WebElement elegsfdsoReferenceDescription;
	@FindBy(id="referenceCode") WebElement elegsftxtCode;
	@FindBy(id="referenceDesc") WebElement elegsftxtCodeDescription;
	@FindBy(id="beginValidityDttm") WebElement elegsftxtUpdatedOn;
	@FindBy(id="updatedByName") WebElement elegsftxtUpdatedBy;
	@FindBy(xpath="//span[text()='View Reference Codes']/following::td[4]/span") WebElement elegdataCode;
	@FindBy(xpath="//span[text()='View Reference Codes']/following::td[5]/span") WebElement elegdataCodeDescription;
	@FindBy(xpath="//span[text()='View Reference Codes']/following::td[6]/span") WebElement elegdataUpdatedOn;
	@FindBy(xpath="//span[text()='View Reference Codes']/following::td[7]/span") WebElement elegdataUpdatedBy;
		
	
	@FindBy(xpath="(//label[text()=' Reference Entity '])[2]") WebElement eleaccdnReferenceEntity;
	@FindBy(xpath="(//label[text()=' Reference Attribute '])[2]") WebElement eleaccdnReferenceAttribute;
	@FindBy(xpath="(//label[text()=' Reference Description '])[2]") WebElement eleaccdnReferenceDescription;
	@FindBy(xpath="(//label[text()=' Code '])[2]") WebElement eleaccdnCode;
	@FindBy(xpath="(//label[text()=' Code Description '])[2]") WebElement eleaccdnCodeDescription;
	@FindBy(xpath="(//label[text()=' Updated On '])[2]") WebElement eleaccdnUpdatedOn;
	@FindBy(xpath="(//label[text()=' Updated By '])[2]") WebElement eleaccdnUpdatedBy;
	
	@FindBy(xpath="//lib-label-value/descendant::label") List<WebElement> elealbls;
	@FindBy(xpath="//span[text()='View Reference Codes']") WebElement elebrdScreenFunctionName;
	
	String referenceEntityValue="";
	
	public ViewReferenceCodesPage verifyFieldsPresent() throws Exception
	{
		verifyExactText(elebrdScreenFunctionName,"View Reference Codes");
		verifyGridHeaders(elelblGridHeaders,"Reference Entity","Reference Attribute","Reference Description","Code","Code Description","Updated On","Updated By");
		verifyAssociatedScreens(eleAssociatedScreenList,"Note Processor");
		return this;
	}
	
	public ViewReferenceCodesPage verifyScreenFunction() throws Exception
	{
		verifyExactText(elebrdScreenFunctionName,"View Reference Codes");
		return this;
	}
	
	public ViewReferenceCodesPage verifySelectFilterFields() throws Exception
	{
		click(eleicnFilter,"Filter");
		verifyDisplayed(elelblsfReferenceEntity,"Reference Entity");
		verifyDisplayed(elelblsfReferenceAttribute,"Reference Attribute");
		verifyDisplayed(elelblsfReferenceDescription,"Reference Description");
		verifyDisplayed(elelblsfFromDate,"From Date");
		verifyDisplayed(elelblsfThroughDate,"Through Date");
		return this;
	}
	
	public ViewReferenceCodesPage inquireWithShowFilterCode(String query,String colName1,String colName2,String refCode,String colName) throws Exception
	{
		inquireWithValidValues(query,colName1,colName2);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		String referenceCode = selectQuery(refCode, colName).trim();
		clearAndType(elegsftxtCode, "Code", referenceCode);
		pressEnterKey(elegsftxtCode);
		Thread.sleep(2000);
		verifyGridResult(eleGridResult, referenceCode);
		return this;
	}
	
		
	
	
	public ViewReferenceCodesPage inquireWithShowFilterCodeDescription(String query,String colName1,String colName2,String codeDesc,String colName) throws Exception
	{
		inquireWithValidValues(query,colName1,colName2);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		String codeDescription = selectQuery(codeDesc, colName);
		clearAndType(elegsftxtCodeDescription, "Code Description", codeDescription);
		pressEnterKey(elegsftxtCodeDescription);
		Thread.sleep(2000);
		verifyGridResult(eleGridResult, codeDescription);
		return this;
	}
	
		
	public ViewReferenceCodesPage inquireWithShowFilterUpdatedOn(String query,String colName1,String colName2,String updatedOn,String colName) throws Exception
	{
		inquireWithValidValues(query,colName1,colName2);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		String updOn = formatDate(selectQuery(updatedOn, colName));
		clearAndType(elegsftxtUpdatedOn, "Updated On", updOn);
		pressEnterKey(elegsftxtUpdatedOn);
		Thread.sleep(2000);
		verifyGridContainsData(eleGridResult, updOn);
		return this;
	}
	
		
	public ViewReferenceCodesPage inquireWithShowFilterUpdatedBy(String query,String colName1,String colName2,String updatedBy,String colName) throws Exception
	{
		inquireWithValidValues(query,colName1,colName2);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		String updBy = selectQuery(updatedBy, colName);
		clearAndType(elegsftxtUpdatedBy, "Updated By", updBy);
		pressEnterKey(elegsftxtUpdatedBy);
		Thread.sleep(2000);
		verifyGridResult(eleGridResult, updBy);
		return this;
	}
	
	
	public ViewReferenceCodesPage checkShowColumnsOption() throws Exception
	{
		Thread.sleep(2000);
		verifyShowColumns(eleicnGridOptions, "Reference Entity","Reference Attribute","Reference Description","Code","Code Description","Updated On","Updated By");
		return this;
	}
		
	
	public ViewReferenceCodesPage selectReferenceEntityFromLOV() throws InterruptedException
	{
		Thread.sleep(2000);
		click(eleicnReferenceEntity,"Reference Entity");
		Thread.sleep(3000);
		referenceEntityValue = elelovvalReferenceEntity.getText();
		doDoubleClick(elelovvalReferenceEntity);
		return this;
	}
	
	public ViewReferenceCodesPage selectReferenceEntityFromLOV(String referenceEntity) throws InterruptedException
	{
		Thread.sleep(3000);
		click(eleicnReferenceEntity,"Reference Entity");
		Thread.sleep(3000);
		clearAndType(eletxtsearchReferenceEntity,"Reference Entity", referenceEntity);
		pressEnterKey(eletxtsearchReferenceEntity);
		Thread.sleep(2000);
		referenceEntityValue = elelovvalReferenceEntity.getText();
		doDoubleClick(elelovvalReferenceEntity);
		return this;
	}
	
	public ViewReferenceCodesPage selectReferenceAttributeFromLOV() throws InterruptedException
	{
		Thread.sleep(3000);
		click(eleicnReferenceAttribute,"Reference Attribute");
		Thread.sleep(3000);
		doDoubleClick(elelovvalReferenceAttribute);
		return this;
	}
	
	public ViewReferenceCodesPage selectReferenceAttributeFromLOV(String referenceAttribute) throws InterruptedException
	{
		Thread.sleep(2000);
		click(eleicnReferenceAttribute,"Reference Attribute");
		Thread.sleep(3000);
		clearAndType(eletxtsearchReferenceAttribute,"Reference Attribute", referenceAttribute);
		pressEnterKey(eletxtsearchReferenceAttribute);
		doDoubleClick(elelovvalReferenceAttribute);
		return this;
	}
	
	public ViewReferenceCodesPage inquireWithValidValues(String query,String colName1,String colName2) throws InterruptedException, ClassNotFoundException, SQLException
	{
		click(eleicnFilter,"Filter");
		String entityName = selectQuery(query, colName1);
		String attribName = selectQuery(query, colName2);
		Thread.sleep(2000);
		clearAndType(eletxtReferenceEntity,"Reference Entity", entityName);
		setFocus(eletxtReferenceAttribute);
		Thread.sleep(3000);
		clearAndType(eletxtReferenceAttribute,"Reference Attribute", attribName);
		Thread.sleep(2000);
		click(eleicnSearch, "Search");
		verifyGridResult(eleGridResult, entityName);
		Thread.sleep(5000);
		return this;
	}
	
	
	
	public AddReferenceCodesPage navigatetoAddReferenceCodes() throws Exception
	{
		click(eleicnAdd,"Add");
		return new AddReferenceCodesPage();
	}
	
	public EditReferenceCodesPage navigatetoEditReferenceCodes(String query,String colName1,String colName2) throws Exception
	{
		inquireWithValidValues(query,colName1,colName2);
		Thread.sleep(5000);
		doDoubleClick(eledsoReferenceEntity);
		return new EditReferenceCodesPage();
	}
	
	public ViewReferencePercentagesPage navigatetoViewReferencePercentages() throws Exception
	{
		click(elelinkReferencePercentages,"Reference Percentages");
		return new ViewReferencePercentagesPage();
	}
	
	public ViewReferenceAmountsPage navigatetoViewReferenceAmounts() throws Exception
	{
		click(elelinkReferenceAmounts,"Reference Amounts");
		return new ViewReferenceAmountsPage();
	}
	
	public ViewPerformanceMeasureGoalsPage navigatetoViewPerformanceMeasureGoals() throws Exception
	{
		click(elelinkPerformanceMeasureGoals,"Performance Measure Goals");
		return new ViewPerformanceMeasureGoalsPage();
	}
	
}
