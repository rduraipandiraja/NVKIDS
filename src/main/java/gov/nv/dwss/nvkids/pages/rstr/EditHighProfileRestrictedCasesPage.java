package gov.nv.dwss.nvkids.pages.rstr;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class EditHighProfileRestrictedCasesPage extends CommonLocators

{
	public EditHighProfileRestrictedCasesPage() 
	{
		PageFactory.initElements(driver, this);
	}

	//Screen Function Name
	@FindBy(xpath = "//span[text()='Edit High Profile Restricted Cases']") WebElement elesfEditHighProfileRestrictedCases;
	
	//Labels
	@FindBy(xpath = "//label[text()='Active']") WebElement elelblActive;
	@FindBy(xpath = "//label[text()='Inactive']") WebElement elelblInactive;
	
	//Info Panel
	@FindBy(xpath = "//div[@class='p-col-12 HeaderHighlight']/div/lib-label-value/div/label") List <WebElement> eleEditInforPanel;
	
	//Radio Buttons
	@FindBy(xpath = "//label[text()='Active']/preceding::span[1][contains(@class,'radiobutton')]")  WebElement elerbActive;
	@FindBy(xpath = "//label[text()='Inactive']/preceding::span[1][contains(@class,'radiobutton')]")  WebElement elerbInactive;
	
	
	
	public EditHighProfileRestrictedCasesPage verifyFieldsPresent() throws Exception
	{
		
		verifyExactText(elesfEditHighProfileRestrictedCases, "Edit High Profile Restricted Cases");
	    verifyFieldSetLabels(eleEditInforPanel," Case "," Participant "," Reason Code "," Reason ");
		verifyDisplayed(elelblActive,"Active");
		verifyDisplayed(elelblInactive,"Inactive");
		
		verifyDisplayed(eleicnRefresh,"Refresh");
		verifyDisplayed(eleicnSave,"Save");
		verifyDisplayed(eleicnClose,"Close");
	    return this;
	}
	

	public EditHighProfileRestrictedCasesPage editStatus() throws Exception
	{
    click(elerbInactive,"Inactive");
    click(eleicnSave, "Save");
    verifyExactText(eleErrStatusBar, "SAVED SUCCESSFULLY");
    return this;
	}
	
	
	
	
	
	
}
