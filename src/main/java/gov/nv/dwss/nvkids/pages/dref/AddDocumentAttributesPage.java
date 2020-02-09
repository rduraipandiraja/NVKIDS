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

public class AddDocumentAttributesPage extends CommonLocators
{
	
	public AddDocumentAttributesPage() 
	{
		PageFactory.initElements(driver, this);
	}
		
	
	// Add Recipients Page
	
	@FindBy(xpath="//label[text()='Recipient Type']") WebElement elelblRecipientType;
	@FindBy(xpath="//div/input[@id='recipientCode']") WebElement elelovRecipientType;
	@FindBy(xpath="//input[@id='recipientCode']/following-sibling::button/span") WebElement eleicnlovRecipientType;
	
	@FindBy(xpath="//label[text()='Print Method']/following::div[1]") WebElement eleddPrintMethod;

	@FindBy(xpath="//label[text()='Print Method']") WebElement elelblPrintMethod;
	
	@FindBy(xpath="//label[text()='Delivery Method']/following::div[1]") WebElement eleddDeliveryMethod;
	@FindBy(xpath="//label[text()='Delivery Method']") WebElement elelblDeliveryMethod;
	
	    
	
	public AddDocumentAttributesPage verifyFieldsPresent() throws Exception
	{
		
		verifyDisplayed(elelblRecipientType, "RecipientType");
		verifyRequiredField(elelblRecipientType);
		verifyDisplayed(elelblPrintMethod,"Print Method");
		verifyRequiredField(elelblPrintMethod);
		verifyDisplayed(elelblDeliveryMethod,"Delivery Method");
		verifyRequiredField(elelblDeliveryMethod);
		
		verifyDisplayed(eleicnClear,"Clear");
		verifyDisplayed(eleicnSave,"Save");
		verifyDisplayed(eleicnClose,"Close");
		
		verifyAssociatedScreens(eleAssociatedScreenList, "Maintain Process","Case Processor","Note Processor","Document Processor");
	
		return this;
	}
	
	public void selectRandomPrintDelivery(WebElement ele) 
	{
		try 
		{	
			wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
			List<WebElement> options = driver.findElements(By.xpath("//li[@role='option']/span[not(contains(text(),'--SELECT--') or contains(text(),'CUSTOMER PORTAL') or contains(text(),'EMPLOYER PORTAL') or contains(text(),'ELECTRONIC'))]"));
			int dropdownsize = options.size();
			int randnMumber = ThreadLocalRandom.current().nextInt(0, dropdownsize);
			options.get(randnMumber).click();
			if(!options.get(randnMumber).getText().equals(""))
			{
				reportStep("The dropdowntext '" + options.get(randnMumber).getText() + "'is successfully selected", "pass");
			}
			else
			{
				reportStep("The dropdowntext '" + options.get(randnMumber).getText() + "'is not selected", "fail");
				Assert.fail();				
			}

		}
		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			reportStep("Unable to access the element " , "fail");
			Assert.fail();	
		} 
		finally 
		{
			takeSnap();
		}

	}
	
	public AddDocumentAttributesPage addWithValidValues(String recipientType) throws Exception
	{
		
		clearAndType(elelovRecipientType, "Recipient Type", recipientType);
		selectRandomPrintDelivery(eleddPrintMethod);
		selectRandomPrintDelivery(eleddDeliveryMethod);
	    click(eleicnSave, "Save");
	    Thread.sleep(4000);
	    verifyExactText(eleErrStatusBar, "SAVED SUCCESSFULLY");
	    return this;
	    
	}
	

	
}
