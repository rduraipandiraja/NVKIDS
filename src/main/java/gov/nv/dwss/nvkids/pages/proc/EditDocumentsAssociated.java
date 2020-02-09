package gov.nv.dwss.nvkids.pages.proc;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;


public class EditDocumentsAssociated extends CommonLocators 
{
	public EditDocumentsAssociated() 
	{
		PageFactory.initElements(driver, this); 
	}
    
	
		@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='View Documents Associated ']") WebElement elebcViewDocumentsAssociated;
		//Document Details Section
		@FindBy(xpath="//label[text()='Document ID']") WebElement elelblDocumentID;
		@FindBy(xpath="	//input[@id='documentIdc']") WebElement eledsoDocumentID;
		@FindBy(xpath="//input[@id='documentDesc']") WebElement eledsoDocumentDescription;
		@FindBy(xpath="//label[text()='Document Description']") WebElement elelblDocumentDescription;
		//Select Recipients Section
		@FindBy(xpath="//input[@id='recipientCode']") WebElement eledsoRecipientType;
		@FindBy(xpath="(//input[@id='recipientCode'])[2]") WebElement eledsomoreRecipientType;
		@FindBy(xpath="(//input[@id='recipientCode'])[3]") WebElement eletxtaddmoreRecipientType;
		@FindBy(xpath="//label[text()='Recipient Type']") WebElement elelblRecipientType;
		@FindBy(xpath="//input[@id='recipientCode']/following-sibling::button") WebElement elelovRecipientType;
		//@FindBy(xpath="//label[@for='printMethodCode']/following-sibling::p-dropdown/descendant::label") WebElement eleddPrintMethod;
		@FindBy(xpath="//label[@for='printMethodCode']/following-sibling::p-dropdown/div") WebElement eleddPrintMethod;
		@FindBy(xpath="(//label[@for='printMethodCode']/following-sibling::p-dropdown/div)[2]") WebElement eleddmorePrintMethod;
		@FindBy(xpath="(//label[@for='printMethodCode']/following-sibling::p-dropdown/div)[3]") WebElement eleddaddmorePrintMethod;
		//@FindBy(xpath="//label[@for='deliveryMethodCode']/following-sibling::p-dropdown/descendant::label") WebElement eleddDeliveryMethod;
		@FindBy(xpath="//label[@for='deliveryMethodCode']/following-sibling::p-dropdown/div") WebElement eleddDeliveryMethod;
		@FindBy(xpath="(//label[@for='deliveryMethodCode']/following-sibling::p-dropdown/div)[2]") WebElement eleddMoreDeliveryMethod;
		@FindBy(xpath="(//label[@for='deliveryMethodCode']/following-sibling::p-dropdown/div)[3]") WebElement eleddaddMoreDeliveryMethod;
		@FindBy(xpath="//span[text()='Add More Recipients']") WebElement elebtnAddMoreRecipients;
		@FindBy(xpath="//label[text()='Print Method']") WebElement elelblPrintMethod;
		@FindBy(xpath="//label[text()='Delivery Method']") WebElement elelblDeliveryMethod;
		
		@FindBy(xpath="//tbody/tr[1]/td[2]/span") WebElement eleadataDocumentId;
		
		@FindBy(xpath="//input[@id='recipientCode']") WebElement eletxtRecipientType;
		@FindBy(xpath="(//input[@id='recipientCode'])[2]") WebElement eletxtmoreRecipientType;
		
		@FindBy(xpath="//input[@id='recipientCode']/following-sibling::button/preceding-sibling::input") WebElement eletxtaddmoreRecepient;
		@FindBy(xpath="(//span[text()='Add More Recipients']/preceding::input[@id='recipientCode'])[3]") WebElement eletxtextraRecepient;
		
				
		@FindBy(xpath="(//input[@id='recipientCode']/following-sibling::button/following::p-dropdown/div)[1]") WebElement eleddaddmorePrint;
		@FindBy(xpath="(//input[@id='recipientCode']/following-sibling::button/following::p-dropdown/div)[2]") WebElement eleddaddmoreDelivery;
		
		public EditDocumentsAssociated addmore() throws Exception
		{
			String S="--SELECT--";
			String val=eleddPrintMethod.getText().trim();
			String val1=eleddDeliveryMethod.getText().trim();
				if(val!=S && val1!=S)
				{
					click(elebtnAddMoreRecipients,"AddMore Recipients");	
				}
			return this;
		}
		public EditDocumentsAssociated addmoreverify() throws Exception
		{
			String val=eleddPrintMethod.getText().trim();
			String val1=eleddDeliveryMethod.getText().trim();
			String P1= "FIELD OFFICE";
			String P2= "CENTRAL OFFICE";
			String P3="ELECTRONIC";
			String D1= "CERTIFIED MAIL";
			String D2= "CUSTOMER PORTAL";
			String D3="EMPLOYER PORTAL";
			String D4= "PERSONAL SERVICE";
			String D5= "REGULAR MAIL";
			
			if(P3.equals(val) && D2.equals(val1))
			{
				selectDropdownValue(eleddmorePrintMethod,"CENTRAL OFFICE");
				selectDropdownValue(eleddMoreDeliveryMethod,"PERSONAL SERVICE");
			}
			else if(P3.equals(val) && D3.equals(val1))
			{
				selectDropdownValue(eleddmorePrintMethod,"CENTRAL OFFICE");
				selectDropdownValue(eleddMoreDeliveryMethod,"REGULAR MAIL");
			}
			else if(P2.equals(val) && D5.equals(val1))
			{
				selectDropdownValue(eleddmorePrintMethod,"ELECTRONIC");
				selectDropdownValue(eleddMoreDeliveryMethod,"EMPLOYER PORTAL");
			}
			else if(P2.equals(val) && D4.equals(val1))
			{
				selectDropdownValue(eleddmorePrintMethod,"ELECTRONIC");
				selectDropdownValue(eleddMoreDeliveryMethod,"CUSTOMER PORTAL");
			}
			else if(P2.equals(val) && D1.equals(val1))
			{
				selectDropdownValue(eleddmorePrintMethod,"FIELD OFFICE");
				selectDropdownValue(eleddMoreDeliveryMethod,"REGULAR MAIL");
			}
			else if(P1.equals(val) && D5.equals(val1))
			{
				selectDropdownValue(eleddmorePrintMethod,"CENTRAL OFFICE");
				selectDropdownValue(eleddMoreDeliveryMethod,"PERSONAL SERVICE");
			}
			else if(P1.equals(val) && D4.equals(val1))
			{
				selectDropdownValue(eleddmorePrintMethod,"ELECTRONIC");
				selectDropdownValue(eleddMoreDeliveryMethod,"CUSTOMER PORTAL");
			}
			else if(P1.equals(val) && D1.equals(val1))
			{
				selectDropdownValue(eleddmorePrintMethod,"ELECTRONIC");
				selectDropdownValue(eleddMoreDeliveryMethod,"EMPLOYER PORTAL");
			}
			return this;
		}
		public EditDocumentsAssociated addverifymore() throws Exception
		{
			String val=eleddPrintMethod.getText().trim();
			String val1=eleddDeliveryMethod.getText().trim();
			String val2=eleddaddmorePrintMethod.getText().trim();
			String val3=eleddaddMoreDeliveryMethod.getText().trim();
			String P1= "FIELD OFFICE";
			String P2= "CENTRAL OFFICE";
			String P3="ELECTRONIC";
			String D1= "CERTIFIED MAIL";
			String D2= "CUSTOMER PORTAL";
			String D3="EMPLOYER PORTAL";
			String D4= "PERSONAL SERVICE";
			String D5= "REGULAR MAIL";
			
			if((P3.equals(val) && D2.equals(val1))||(P3.equals(val2) && D2.equals(val3)))
			{
				selectDropdownValue(eleddaddmorePrintMethod,"CENTRAL OFFICE");
				selectDropdownValue(eleddaddMoreDeliveryMethod,"PERSONAL SERVICE");
			}
			else if((P3.equals(val) && D3.equals(val1))||(P3.equals(val2) && D3.equals(val3)))
			{
				selectDropdownValue(eleddaddmorePrintMethod,"CENTRAL OFFICE");
				selectDropdownValue(eleddaddMoreDeliveryMethod,"REGULAR MAIL");
			}
			else if((P2.equals(val) && D5.equals(val1))||(P2.equals(val2) && D5.equals(val3)))
			{
				selectDropdownValue(eleddaddmorePrintMethod,"ELECTRONIC");
				selectDropdownValue(eleddaddMoreDeliveryMethod,"EMPLOYER PORTAL");
			}
			else if((P2.equals(val) && D4.equals(val1))||(P2.equals(val2) && D4.equals(val3)))
			{
				selectDropdownValue(eleddaddmorePrintMethod,"ELECTRONIC");
				selectDropdownValue(eleddaddMoreDeliveryMethod,"CUSTOMER PORTAL");
			}
			else if((P2.equals(val) && D1.equals(val1))||(P2.equals(val2) && D1.equals(val3)))
			{
				selectDropdownValue(eleddaddmorePrintMethod,"FIELD OFFICE");
				selectDropdownValue(eleddaddMoreDeliveryMethod,"REGULAR MAIL");
			}
			else if((P1.equals(val) && D5.equals(val1))||(P1.equals(val2) && D5.equals(val3)))
			{
				selectDropdownValue(eleddaddmorePrintMethod,"CENTRAL OFFICE");
				selectDropdownValue(eleddaddMoreDeliveryMethod,"PERSONAL SERVICE");
			}
			else if((P1.equals(val) && D4.equals(val1))||(P1.equals(val2) && D4.equals(val3)))
			{
				selectDropdownValue(eleddaddmorePrintMethod,"ELECTRONIC");
				selectDropdownValue(eleddaddMoreDeliveryMethod,"CUSTOMER PORTAL");
			}
			else if((P1.equals(val) && D1.equals(val1))||(P1.equals(val2) && D1.equals(val3)))
			{
				selectDropdownValue(eleddaddmorePrintMethod,"ELECTRONIC");
				selectDropdownValue(eleddaddMoreDeliveryMethod,"EMPLOYER PORTAL");
			}
			return this;
		}
		
		public EditDocumentsAssociated enterrecipient()
		{
			
			String S =eledsoRecipientType.getText();
			System.out.println(S);
			return this;
		}
		public EditDocumentsAssociated VerifyEditField() throws Exception
		{
			verifyDisplayed(elelblDocumentID,"Document ID");
			verifyDisplayed(elelblDocumentDescription,"Document Description");
			verifyDisplayed(elelblRecipientType,"Recipient Type");
			verifyDisplayed(elelblPrintMethod,"Print Method");
			verifyDisplayed(elelblDeliveryMethod,"Delivery Method");
			verifyDisplayed(elebtnAddMoreRecipients,"AddMore Recipients");
			return this;
		}
		
		public ViewDocumentsAssociatedPage Addmoredata() throws Exception
		{
			addmore();
			Thread.sleep(2000);
			clearAndType(eletxtaddmoreRecepient,"Recipient Type","OT");
			addmoreverify();
			Thread.sleep(2000);
			addmore();
			Thread.sleep(2000);
			clearAndType(eletxtextraRecepient,"Recipient Type","NA");
			addverifymore();
			click(eleicnSave,"Save");
			verifyExactText(eleErrStatusBar,"SAVED SUCCESSFULLY");
			click(eleicnClose,"Close");
			return new ViewDocumentsAssociatedPage();
		}
		
		public EditDocumentsAssociated VerifyValidData(String print, String delivery) throws Exception
		{
			selectDropdownValue(eleddPrintMethod,print);
			Thread.sleep(1000);
			selectDropdownValue(eleddDeliveryMethod,delivery);
			Thread.sleep(1000);
			click(eleicnSave,"Save");
			Thread.sleep(2000);
			verifyExactText(eleErrStatusBar,"SAVED SUCCESSFULLY");
			return this;
		}
		public EditDocumentsAssociated VerifyMatchDataField(String printMethod, String deliverMethod) throws Exception
		{
			selectDropdownValue(eleddPrintMethod,printMethod);
			Thread.sleep(1000);
			selectDropdownValue(eleddDeliveryMethod,deliverMethod);
			Thread.sleep(1000);
			click(eleicnSave,"Save");
			Thread.sleep(2000);
			verifyExactText(eleErrStatusBar,"SAVED SUCCESSFULLY");
			return this;
		}
		
		public EditDocumentsAssociated VerifyAddMoreReceipient() throws Exception
		{
			addmore();
			Thread.sleep(2000);
			verifyDisplayed(elelblRecipientType,"Recepient Type");
			verifyDisplayed(elelblPrintMethod,"Print Method");
			verifyDisplayed(elelblDeliveryMethod,"Delivery Method");
			return this;
		}
		
		
		public EditDocumentsAssociated VerifyEditRequired() throws Exception
		{
			selectDropdownValue(eleddPrintMethod,"ELECTRONIC");
			selectDropdownValue(eleddDeliveryMethod,"CUSTOMER PORTAL");
			Thread.sleep(2000);
			click(eleicnSave,"Save");
			Thread.sleep(2000);
			verifyExactText(eleErrStatusBar,"SAVED SUCCESSFULLY");
			return this;
		}
		
		public EditDocumentsAssociated VerifyEditAddmoreRequiredField() throws Exception
		{
			addmore();
			Thread.sleep(2000);
			clearAndType(eletxtaddmoreRecepient,"Recipient Type","NP");
			selectDropdownValue(eleddaddmorePrint,"FIELD OFFICE");
			selectDropdownValue(eleddaddmoreDelivery,"CERTIFIED MAIL");
			Thread.sleep(2000);
			click(eleicnSave,"Save");
			Thread.sleep(2000);
			verifyExactText(eleErrStatusBar,"SAVED SUCCESSFULLY");
			return this;
		}
}