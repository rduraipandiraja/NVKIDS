package gov.nv.dwss.nvkids.pages.dref;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;


public class EditDocumentAttributesPage extends CommonLocators
{
	public EditDocumentAttributesPage() 
	{
		PageFactory.initElements(driver, this);
	}
	

	//Edit Document Attributes Page

	@FindBy(xpath="//label[text()='Recipient Type']") WebElement elelblRecipientType;
	@FindBy(xpath="//input[@id='recipientCode']") WebElement elelovRecipientType;
	
	@FindBy(xpath="//label[text()='Print Method']/following::div[1]") WebElement eleddPrintMethod;
	@FindBy(xpath="//label[text()='Print Method']") WebElement elelblPrintMethod;
	
	@FindBy(xpath="//label[text()='Delivery Method']/following::div[1]") WebElement eleddDeliveryMethod;
	@FindBy(xpath="//label[text()='Delivery Method']") WebElement elelblDeliveryMethod;
	 
    @FindBy(xpath="//span[text()='Edit Document Attributes']") WebElement elesfEditDocumentAttributes;
    
    
	public EditDocumentAttributesPage verifyFieldsPresent() throws Exception
	{
		verifyDisplayed(elelblRecipientType, "Recipient Type");
		verifyDisplayed(elelblPrintMethod,"Print Method");
		verifyRequiredField(elelblPrintMethod);
		verifyDisplayed(elelblDeliveryMethod,"Delivery Method");
		verifyRequiredField(elelblDeliveryMethod);
		
		verifyDisplayed(eleicnRefresh,"Refresh");
		verifyDisplayed(eleicnSave,"Save");
		verifyDisplayed(eleicnClose,"Close");
		return this;
	}
	
	
	public EditDocumentAttributesPage editWithValidValues(String printMethod,String deliveryMethod) throws Exception
	{
		
		selectDropdownValue(eleddPrintMethod, printMethod);
		selectDropdownValue(eleddDeliveryMethod, deliveryMethod);
	    click(eleicnSave, "Save");
	    Thread.sleep(4000);
	    verifyExactText(eleErrStatusBar, "SAVED SUCCESSFULLY");
	   
	    return this;
	    
	}
	
}
