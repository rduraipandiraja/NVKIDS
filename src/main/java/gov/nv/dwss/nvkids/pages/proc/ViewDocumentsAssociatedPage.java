package gov.nv.dwss.nvkids.pages.proc;

import java.util.List;

import org.apache.poi.hssf.record.common.UnicodeString.FormatRun;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;


public class ViewDocumentsAssociatedPage extends CommonLocators 
{
	public ViewDocumentsAssociatedPage() 
	{
		PageFactory.initElements(driver, this); 
	}
	@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='View Documents Associated ']") WebElement elebcViewDocumentsAssociated;
	@FindBy(xpath="//p-breadcrumb/descendant::a/span[text()='View Process Details']") public WebElement elebcViewProcessDetails;

	@FindBy(xpath="//span[text()='Add']") WebElement eleicnAdd;
	@FindBy(xpath="//span[text()='Delete']") WebElement eleicnDelete;


	
	@FindBy(xpath="(//tbody/descendant::a[contains(@class,'link' ) and contains(text(),'3')])[1]") public WebElement eleGridCellThreeDocs;
	@FindBy(xpath="(//tbody/descendant::a[contains(@class,'link' ) and contains(text(),'4')])[1]") public WebElement eleGridCellFourDocs;
	@FindBy(xpath="(//tbody/descendant::a[contains(@class,'link' ) and contains(text(),'6')])[1]") public WebElement eleGridCellSixDocs;
	
	//Grid section
	@FindBy(xpath="//tr[@class='ng-star-inserted']/descendant::label/parent::th") public List<WebElement> eleGridHeaderPROC;
	@FindBy(xpath="//label[text()=' Docs ']") public WebElement elehdrDocs;
	@FindBy(xpath="//input[@id='documentCountNumb']") public WebElement eletxtDocs;
	@FindBy(xpath="//label[text()=' Document ID ']") WebElement elehdrDocumentID;
	@FindBy(xpath="//label[text()=' Document Description ']") WebElement elehdrDocumentDescription;
	@FindBy(xpath = "//input[@id='documentIdc']") WebElement EletxtSFDocumentID;
	@FindBy(xpath = "//input[@id='documentIdc']/following-sibling::button") WebElement EleicnSFLOVDocumentID;
	@FindBy(xpath = "//input[@id='documentDesc']") WebElement EletxtSFDocumentDescription;
	

	

	//@FindBy(xpath="(//tr/th)[1]") public WebElement elehdruntitled;


	@FindBy(xpath="(//a[contains(@class,'link')]/parent::lib-link)[1]") public WebElement elelinkgridresult;
	//Accordion icon
	@FindBy(xpath = "(//i[contains(@class,'pi pi-chevron-down')])[1]") WebElement Eleicnaccordion;

	//Accordion Section
	@FindBy(xpath="//label[text()=' Recipient Type ']") WebElement elehdrRecipientType;
	@FindBy(xpath="//label[text()=' Print Method ']") WebElement elehdrPrintMethod;
	@FindBy(xpath="//label[text()=' Delivery Method ']") WebElement elehdrDeliveryMethod;
	@FindBy(xpath="//input[@id='recipientCode']") WebElement eletxtRecipientType;


	//Error Panel
	@FindBy(xpath = "//div[@class='p-grid']/div/app-status-bar/div/span[2]")  public WebElement eleErrorPanel;	
	@FindBy(xpath = "//app-core/app-layout//div/div/app-status-bar/div/span")  public WebElement eleErrorPanelNoMatch;


	@FindBy(xpath="//tr[1]/td[1]/p-tablecheckbox") public WebElement eleicnchekbox;
	@FindBy(xpath="//tr/td[1]/p-tablecheckbox") public List<WebElement> eleicncheckboxMulti;
	@FindBy(xpath="//tr[@title=''][1]/td[1]/p-tablecheckbox") public WebElement eleicnInnerchekbox;
	@FindBy(xpath="//tr[@title=''][2]/td[1]/p-tablecheckbox") public List<WebElement> eleicnMultiInnerchekbox;

	@FindBy(xpath="//tbody/tr[1]/td[2]/span") WebElement eleadataDocumentId;
	
	
	
	public AddDocumentsAssociatedPage navigateToAddDocumentsAssociatedScreen() throws InterruptedException 
	{
		click(eleicnAdd,"Add");
		Thread.sleep(3000);
		return new AddDocumentsAssociatedPage();
	}

	public EditDocumentsAssociated navigateToEditDocumentsAssociatedScreen() throws InterruptedException 
	{
		Thread.sleep(1000);
		doDoubleClick(eleadataDocumentId);
		Thread.sleep(2000);
		return new EditDocumentsAssociated();
	}
	public  ViewDocumentsAssociatedPage verifyWithoutRecord() throws Exception
	{
		verifyExactText(eleErrStatusBar,"NO MATCHING RECORDS FOUND");
		verifyExactText(elebcViewDocumentsAssociated,"View Documents Associated");
		Thread.sleep(3000);
		verifyGridHeaders(eleGridHeaderPROC," Document ID "," Document Description ");
		return this;
	}
	public  ViewDocumentsAssociatedPage verifyWithRecord() throws Exception
	{
		
		verifyExactText(elebcViewDocumentsAssociated,"View Documents Associated");
		verifyGridHeaders(eleGridHeaderPROC," Document ID "," Document Description ");
		return this;
	}

	public  ViewDocumentsAssociatedPage verifyInnerField() throws Exception
	{
	
		
		click(Eleicnaccordion,"Accordian");
		Thread.sleep(3000);
		verifyGridHeaders(elelblInnerGridHeaders," Recipient Type "," Print Method "," Delivery Method ");
		return this;
	}
	public  ViewDocumentsAssociatedPage verifyGridOptions() throws Exception
	{
		
		Thread.sleep(3000);
		verifyShowColumns(eleicnGridOptions,"Document ID","Document Description");
		return this;
	}

	public ViewDocumentsAssociatedPage verifyMultipleRecConYesIcon() throws Exception
	{
		int limit=2;
		for (WebElement chkbox : eleicncheckboxMulti) {
			if(limit>0) {
				click(chkbox,"Checkbox");
				limit--;
			}

		}
		Thread.sleep(2000);
		click(eleicnDelete,"Delete");
		Thread.sleep(2000);
		verifyExactText(eleCnfPopUpTitle,"Confirmation");
		verifyExactText(eleinfPopUp,"You have selected 2 record(s) to delete. Are you sure you want to proceed?");
		verifyDisplayed(eleicnPopUpYes,"Yes");
		verifyDisplayed(eleicnPopUpNo,"No");
		Thread.sleep(1000);
		click(eleicnPopUpYes,"Yes");
		verifyExactText(eleErrStatusBar, "DELETED SUCCESSFULLY");
		return this;
	}
	
	public ViewDocumentsAssociatedPage verifyAccordianMulRecordYesIcon() throws Exception
	{
		
		click(Eleicnaccordion,"Accordian");
		Thread.sleep(2000);
		int limit=2;
		for (WebElement Innerchkbox :eleicnMultiInnerchekbox) {
			while(limit>=0) {
				click(Innerchkbox,"Inner Checkbox");
				limit--;
			}
		}
		Thread.sleep(2000);
		click(eleicnDelete,"Delete");
		Thread.sleep(1000);
		click(eleicnPopUpYes,"Yes");
		verifyExactText(eleErrStatusBar, "DELETED SUCCESSFULLY");
		return this;
	}
	
	
	
}
