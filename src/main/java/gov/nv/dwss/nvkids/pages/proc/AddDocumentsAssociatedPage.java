package gov.nv.dwss.nvkids.pages.proc;

import java.sql.SQLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;


public class AddDocumentsAssociatedPage extends CommonLocators
{
	public AddDocumentsAssociatedPage() 
	{
		PageFactory.initElements(driver, this); 
	}
    
	@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='View Documents Associated ']") WebElement elebcViewDocumentsAssociated;
	@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='Add Documents Associated']") WebElement elebcAddDocumentsAssociated;
	
	//Document Details Section
	@FindBy(xpath="//label[text()='Document ID']") WebElement elelblDocumentID;
	@FindBy(xpath="//input[@id='documentIdc']") WebElement eletxtDocumentID;
	@FindBy(xpath="//input[@id='documentIdc']/following-sibling::button") WebElement elelovDocumentID;
	@FindBy(xpath="//input[@id='documentDesc']") WebElement eletxtDocumentDescription;
	@FindBy(xpath="//label[text()='Document Description']") WebElement elelblDocumentDescription;
	//Select Recipients Section
	@FindBy(xpath="//input[@id='recipientCode']") WebElement eletxtRecipientType;
	@FindBy(xpath="(//input[@id='recipientCode'])[2]") WebElement eletxtmoreRecipientType;
	@FindBy(xpath="//label[text()='Recipient Type']") WebElement elelblRecipientType;
	@FindBy(xpath="//input[@id='recipientCode']/following-sibling::button") WebElement elelovRecipientType;
	//@FindBy(xpath="//label[@for='printMethodCode']/following-sibling::p-dropdown/descendant::label") WebElement eleddPrintMethod;
	@FindBy(xpath="//label[@for='printMethodCode']/following-sibling::p-dropdown/div") WebElement eleddPrintMethod;
	@FindBy(xpath="(//label[@for='printMethodCode']/following-sibling::p-dropdown/div)[2]") WebElement eleddmorePrintMethod;
	//@FindBy(xpath="//label[@for='deliveryMethodCode']/following-sibling::p-dropdown/descendant::label") WebElement eleddDeliveryMethod;
	@FindBy(xpath="//label[@for='deliveryMethodCode']/following-sibling::p-dropdown/div") WebElement eleddDeliveryMethod;
	@FindBy(xpath="(//label[@for='deliveryMethodCode']/following-sibling::p-dropdown/div)[2]") WebElement eleddMoreDeliveryMethod;
	@FindBy(xpath="//span[text()='Add More Recipients']") WebElement elebtnAddMoreRecipients;
	@FindBy(xpath="//label[text()='Print Method']") WebElement elelblPrintMethod;
	@FindBy(xpath="//label[text()='Delivery Method']") WebElement elelblDeliveryMethod;
	//Error Panel
    @FindBy(xpath = "//div[@class='p-grid']/div/app-status-bar/div/span[2]")  public WebElement eleErrorPanel;	
	@FindBy(xpath = "//app-core/app-layout//div/div/app-status-bar/div/span")  public WebElement eleErrorPanelNoMatch;
	
	@FindBy(xpath="//tbody/tr[1]/td[2]/span") WebElement eleadataDocumentId;
	
	public AddDocumentsAssociatedPage selectdata() throws InterruptedException, ClassNotFoundException, SQLException 
	{
		
		Thread.sleep(2000);
		pressEnterKey(eleSearchBarSearch);
		Thread.sleep(2000);
		doDoubleClick(eleGridCells);
	    Thread.sleep(2000);
	    return this;
	}
	
	public AddDocumentsAssociatedPage VerifyAddField() throws Exception
	{
		verifyExactText(elebcAddDocumentsAssociated,"Add Documents Associated");
		verifyDisplayed(elelblDocumentID,"Document ID");
		verifyDisplayed(elelblDocumentDescription,"Document Description");
		verifyDisplayed(elelblRecipientType,"Recipient Type");
		verifyDisplayed(elelblPrintMethod,"Print Method");
		verifyDisplayed(elelblDeliveryMethod,"Delivery Method");
		return this;
	}
	

	
	
	
	public AddDocumentsAssociatedPage VerifyMatchDataField(String Query,String documentid) throws Exception
	{
		String DocumentID = selectQuery(Query,documentid);
		clearAndType(eletxtDocumentID,"Select Document ID",DocumentID);
		clearAndType(eletxtRecipientType,"Recipient Type","FC");
		selectDropdownValue(eleddPrintMethod,"ELECTRONIC");
		selectDropdownValue(eleddDeliveryMethod,"CUSTOMER PORTAL");
		Thread.sleep(2000);
		click(eleicnSave,"Save");
		Thread.sleep(2000);
		verifyExactText(eleErrStatusBar,"SAVED SUCCESSFULLY");
		return this;
	}
	public AddDocumentsAssociatedPage VerifyMoreAddReceipient() throws Exception
	{
		click(elebtnAddMoreRecipients,"Add More Recipients");
		verifyDisplayed(elelblRecipientType,"Recipient Type");
		verifyDisplayed(elelblPrintMethod,"Print Method");
		verifyDisplayed(elelblDeliveryMethod,"Delivery Method");
		return this;
	}

	public AddDocumentsAssociatedPage VerifySaveValidDataField(String Query,String documentid) throws Exception
	{
		String DocumentID = selectQuery(Query,documentid);
		clearAndType(eletxtDocumentID,"Select Document ID",DocumentID);
		clearAndType(eletxtRecipientType,"Recipient Type","CC");
		selectDropdownValue(eleddPrintMethod,"ELECTRONIC");
		selectDropdownValue(eleddDeliveryMethod,"EMPLOYER PORTAL");
		Thread.sleep(2000);
		click(eleicnSave,"Save");
		Thread.sleep(2000);
		verifyExactText(eleErrStatusBar,"SAVED SUCCESSFULLY");
		return this;
	}
	
	public AddDocumentsAssociatedPage adddocs(String Query,String documentid) throws Exception
	{
		String DocumentID = selectQuery(Query,documentid);
		clearAndType(eletxtDocumentID,"Select Document ID",DocumentID);
		clearAndType(eletxtRecipientType,"Recipient Type","CA");
		selectDropdownValue(eleddPrintMethod,"CENTRAL OFFICE");
		selectDropdownValue(eleddDeliveryMethod,"PERSONAL SERVICE");
		Thread.sleep(2000);
		click(eleicnSave,"Save");
		Thread.sleep(2000);
		verifyExactText(eleErrStatusBar,"SAVED SUCCESSFULLY");
		click(eleicnClose,"Close");
		Thread.sleep(2000);
		click(eleicnAdd,"Add");
		return this;
	}
	public ViewDocumentsAssociatedPage adddata(String Query,String documentid) throws Exception
	{
		String AddDocID = selectQuery(Query,documentid);
		clearAndType(eletxtDocumentID,"Select Document ID",AddDocID);
		clearAndType(eletxtRecipientType,"Recipient Type","FC");
		selectDropdownValue(eleddPrintMethod,"FIELD OFFICE");
		selectDropdownValue(eleddDeliveryMethod,"CERTIFIED MAIL");
		Thread.sleep(2000);
		click(eleicnSave,"Save");
		Thread.sleep(2000);
		verifyExactText(eleErrStatusBar,"SAVED SUCCESSFULLY");
		click(eleicnClose,"Close");
		return new ViewDocumentsAssociatedPage();
	}
}