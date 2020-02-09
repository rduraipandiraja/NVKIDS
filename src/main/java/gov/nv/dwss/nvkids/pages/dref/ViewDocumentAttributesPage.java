package gov.nv.dwss.nvkids.pages.dref;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class ViewDocumentAttributesPage extends CommonLocators 
{
	public ViewDocumentAttributesPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Filter Section	
	@FindBy(xpath="//input[@id='documentIdc']") WebElement eletxtDocumentID;	
	@FindBy(xpath="//label[text()='Document ID']") WebElement elelblDocumentID;
	@FindBy(xpath="//input[@id='documentDesc']") WebElement eletxtDocumentName;	
	@FindBy(xpath="//label[text()='Document Name']") WebElement elelblDocumentName;
	@FindBy(xpath="//label[text()='Search By Code']") WebElement  elelblUntitledSearchBy;
	@FindBy(xpath="//label[text()='Search By Code']/following::div[1]/label") WebElement eleddUntitledSearchBy;
	@FindBy(xpath="//label[text()='Category']/following::div[1]/label") WebElement eleddCategory;
	@FindBy(xpath="//label[text()='Category']") WebElement elelblCategory;
	@FindBy(xpath="//label[text()='Type']/following::div[1]/label") WebElement eleddType;
	@FindBy(xpath="//label[text()='Type']") WebElement elelblType;
	@FindBy(xpath="//button/span[text()='Search']") WebElement elebtnSearch;
	@FindBy(xpath="//button/span[text()='Clear']") WebElement elebtnClear;
	
	//Grid Header Section
	@FindBy(xpath="//label[text()=' Document ID ']") WebElement eleglblDocumentID;	
	@FindBy(xpath="//label[text()=' Document Name ']") WebElement eleglblDocumentName;
	@FindBy(xpath="//label[text()=' Category Code ']") WebElement eleglblCategoryCode;
	@FindBy(xpath="//label[text()=' Category ']") WebElement eleglblCategory;
	@FindBy(xpath="//label[text()=' Notice Type Code ']") WebElement eleglblNoticeTypeCode;
	@FindBy(xpath="//label[text()=' Type ']") WebElement eleglblType;	
	
	//Grid Show filter fields
	@FindBy(xpath="//input[@id='documentIdc']") WebElement elegsftxtDocumentID;
	@FindBy(xpath="//input[@id='documentDesc']") WebElement elegsftxtDocumentName;
	@FindBy(xpath="//label[@for='documentSubsystemCode']/following-sibling::p-dropdown/descendant::label" ) WebElement elegsfddCategoryCode;
	@FindBy(xpath="//label[@for='documentSubsystemDesc']/following-sibling::p-dropdown/descendant::label") WebElement elegsfddCategory;
	@FindBy(xpath="//label[@for='documentTypeCode']/following-sibling::p-dropdown/descendant::label") WebElement elegsfddNoticeTypeCode;
	@FindBy(xpath="//label[@for='documentTypeDesc']/following-sibling::p-dropdown/descendant::label") WebElement elegsfddType;
	
	
	//Accordion icon
	@FindBy(xpath = "(//i[contains(@class,'pi pi-chevron-down')])[1]") WebElement eleicnAccordion;
	
		
    //Navigate to Add screen function
	@FindBy(xpath = "//span[text()='Add Recipients']") WebElement eleicnAddRecipients;
	
	
	//Double click on grid to naviagate edit screen function
	@FindBy(xpath = "//tr[@title='Double click any row for edit']/td[3]") WebElement eleGrid;
	
	
	
	//Delete and its Confirmation box 
	@FindBy(xpath="//tr[1]/td[1]/p-tablecheckbox") WebElement elegridCheckbox;
	@FindBy(xpath ="//tr[@class='cursorPointer ui-selectable-row ng-star-inserted']/td[1]") List<WebElement> elegridCheckboxes;
	@FindBy(xpath="//p-button/following::button") WebElement eleicnDelete;
	
   @FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='View Document Attributes']") WebElement elesfViewDocumentAttributes;
    
	
	public ViewDocumentAttributesPage verifyFieldsPresent() throws Exception
	{
		verifyGridHeaders(elelblGridHeaders," Document ID "," Document Name "," Category "," Type ");
		verifyAssociatedScreens(eleAssociatedScreenList, "Maintain Process","Case Processor","Note Processor","Document Processor");
		return this;
	}
	
	public ViewDocumentAttributesPage verifyScreen() throws Exception
	{
		verifyExactText(elesfViewDocumentAttributes, "View Document Attributes");
		return this;
	}
	
	public ViewDocumentAttributesPage verifyFilterFields() throws Exception
	{
		click(eleicnFilter,"Filter");
		verifyDisplayed(eletxtDocumentID,"Document ID");
		verifyDisplayed(eletxtDocumentName,"Document Name");
		verifyDisplayed(eleddUntitledSearchBy,"Untitled Search By");
		verifyDisplayed(eleddCategory,"Category");
		verifyDisplayed(eleddType,"Type");

		return this;
	}
	
	
	public ViewDocumentAttributesPage verifyShowColumns() throws Exception
	{
		 verifyShowColumns(eleicnGridOptions,"Document ID","Document Name","Category Code","Category","Notice Type Code","Type");

		return this;
	}
	


	
	public ViewDocumentAttributesPage inquireValidValuesDocumentID(String query , String documentID) throws Exception
	{
		 String docID = selectQuery(query,documentID);
		 click(eleicnFilter,"Filter");
		 clearAndType(eletxtDocumentID, "Document ID",docID );
		 click(eleicnSearch,"Search");
		 Thread.sleep(5000);
		 verifyGridResult(eleGridResult, docID);
		return this;
	}
	
	public ViewDocumentAttributesPage inquireValidValuesShowFiltersDocumentID(String query , String documentID) throws Exception
	{
		String docID = selectQuery(query,documentID);
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		clearAndType(elegsftxtDocumentID, "Document ID", docID);
		pressEnterKey(elegsftxtDocumentID);
		Thread.sleep(5000);
		verifyGridResult(eleGridResult, docID);
		return this;
	}
	

	
	public ViewDocumentAttributesPage enterDocumentNameExact(String query , String documentName) throws Exception
	{
		
		String docName = selectQuery(query,documentName);
		click(eleicnFilter,"Filter");
		clearAndType(eletxtDocumentName, "Document Name", docName);
		selectDropdownValue(eleddUntitledSearchBy,"EXACT");
		click(eleicnSearch,"Search");
		Thread.sleep(5000);
		verifyGridResult(eleGridResult,docName);
		return this;
	}
	
	

	public ViewDocumentAttributesPage enterShowFiltersDocumentName(String query , String documentName) throws Exception
	{
		String docName = selectQuery(query,documentName);
		Thread.sleep(2000);
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		clearAndType(elegsftxtDocumentName, "Document Name", docName);
		pressEnterKey(elegsftxtDocumentName);
		Thread.sleep(5000);
		verifyGridResult(eleGridResult,docName);
		return this;
	}
	
	public ViewDocumentAttributesPage selectCategory(String query, String selectCategory) throws Exception
	{
		String category = selectQuery(query,selectCategory);
		click(eleicnFilter,"Filter");
		selectDropdownValue(eleddCategory,category);
		click(eleicnSearch,"Search");
		Thread.sleep(5000);
		verifyGridResult(eleGridResult,category);
		return this;
		
	}
	
	public ViewDocumentAttributesPage selectShowFilterCategoryCode(String query,String selectCategoryCode) throws Exception
	{
		String categoryCode = selectQuery(query,selectCategoryCode);
		Thread.sleep(2000);
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		selectDropdownValue(elegsfddCategoryCode,categoryCode);
		Thread.sleep(5000);
		verifyGridResult(eleGridResult,categoryCode);
		return this;
		
	}
	
	
	public ViewDocumentAttributesPage selectShowFilterCategory(String query,String selectCategory) throws Exception
	{
		String category = selectQuery(query,selectCategory);
		Thread.sleep(2000);
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		selectDropdownValue(elegsfddCategory,category);
		Thread.sleep(5000);
		verifyGridResult(eleGridResult,category);
		return this;
		
	}
	
	public ViewDocumentAttributesPage selectShowFilterNoticeTypeCode(String query,String selectNoticeCode) throws Exception
	{
		
		String noticeCode = selectQuery(query,selectNoticeCode);
		Thread.sleep(2000);
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		selectDropdownValue(elegsfddNoticeTypeCode,noticeCode);
		verifyGridResult(eleGridResult,noticeCode);
		return this;
		
	}
	
	public ViewDocumentAttributesPage selectShowFilterType(String query,String selectType) throws Exception
	{
		String type = selectQuery(query,selectType);
		Thread.sleep(2000);
		selectAllShowColumn(eleicnGridOptions);
		Thread.sleep(2000);
		click(eleicnGridOptions,"Grid Options");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options");
		selectDropdownValue(elegsfddType,type);
		Thread.sleep(1000);
		verifyGridResult(eleGridResult,type);
		return this;
		
	}
	
	
	public ViewDocumentAttributesPage selectType(String query,String selectType) throws Exception
	{
		String type = selectQuery(query,selectType);
		click(eleicnFilter,"Filter");
		selectDropdownValue(eleddType,type);
		click(eleicnSearch,"Search");
		verifyGridResult(eleGridResult,type);
		return this;
		
	}
	
	
	
	public ViewDocumentAttributesPage verifyAccordionGridHeaders() throws Exception
	{
		Thread.sleep(2000);
		click(eleicnAccordion, "Accordion");
		Thread.sleep(2000);
		verifyGridHeaders(elelblInnerGridHeaders,"Recipient Type "," Print Method "," Delivery Method "," Updated By "," Updated On ");
		return this;
	}
	
	public ViewDocumentAttributesPage verifyShowColumnsAccordion() throws Exception
	{
	
		Thread.sleep(2000);
		click(eleicnAccordion, "Accordion");
		verifyShowColumns(eleicnAccGridOptions,"Recipient Type Code","Recipient Type","Print Method Code","Print Method","Delivery Method Code","Delivery Method","Updated By","Updated On");

		return this;
	}
	
	
	public AddDocumentAttributesPage navigateToAddDREF(String query , String documentID) throws Exception
	{
		String docID = selectQuery(query,documentID);
		Thread.sleep(2000);
		click(eleicnFilter,"Filter");
		clearAndType(eletxtDocumentID, "Document ID", docID);
		click(eleicnSearch,"Search");
		Thread.sleep(5000);
		verifyGridResult(eleGridResult,docID);
		Thread.sleep(5000);
		click(eleicnAccordion, "Accordion");
		click(eleicnAddRecipients,"Add Recipients");
		Thread.sleep(5000);
		return new AddDocumentAttributesPage();
	}
	
	public AddDocumentAttributesPage navigateToAddDREFWithoutReceipientCC(String query , String documentID) throws Exception
	{
		String docID = selectQuery(query,documentID);
		Thread.sleep(2000);
		click(eleicnFilter,"Filter");
		clearAndType(eletxtDocumentID, "Document ID", docID);
		click(eleicnSearch,"Search");
		Thread.sleep(5000);
		verifyGridResult(eleGridResult,docID);
		Thread.sleep(5000);
		click(eleicnAccordion, "Accordion");
		click(eleicnAddRecipients,"Add Recipients");
		Thread.sleep(5000);
		return new AddDocumentAttributesPage();
	}
	
	public EditDocumentAttributesPage navigateToEditDREF(String query , String documentID) throws Exception
	{
		String docID = selectQuery(query,documentID);
		Thread.sleep(2000);
		click(eleicnFilter,"Filter");
		clearAndType(eletxtDocumentID, "Document ID", docID);
		click(eleicnSearch,"Search");
		Thread.sleep(2000);
		verifyGridResult(eleGridResult,docID);
		Thread.sleep(2000);
		click(eleicnAccordion, "Accordion");
		Thread.sleep(2000);
		doDoubleClick(eleGrid);
		Thread.sleep(5000);
		return new EditDocumentAttributesPage();
	}
	
	public ViewDocumentAttributesPage verifyDeleteConfirmation(String query , String documentID) throws Exception
	{
		String docID = selectQuery(query,documentID);
		click(eleicnFilter,"Filter");
		clearAndType(eletxtDocumentID, "Document ID", docID);
		click(eleicnSearch,"Search");
		Thread.sleep(2000);
		verifyGridResult(eleGridResult,docID);
		Thread.sleep(2000);
		click(eleicnAccordion, "Accordion");
		Thread.sleep(2000);
		click(elegridCheckbox,"Check Box");
		click(eleicnDelete,"Delete");
		verifyExactText(eleCnfPopUpTitle, "Delete Confirmation");
		verifyExactText(eleinfPopUp, "You have selected 1 record(s) to delete. Are you sure you want to proceed?");
		Thread.sleep(2000);
		return this;
	}
	
	public ViewDocumentAttributesPage verifyDeleteConfirmationYes(String query,String documentID) throws Exception
	{
		verifyDeleteConfirmation(query,documentID);
		click(eleicnPopUpYes,"Yes");
		Thread.sleep(1000);
		verifyExactText(eleErrStatusBar, "DELETED SUCCESSFULLY");
		return this;
	}
	
	
}
