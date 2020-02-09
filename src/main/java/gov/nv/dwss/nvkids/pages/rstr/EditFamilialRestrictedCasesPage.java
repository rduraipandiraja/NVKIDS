package gov.nv.dwss.nvkids.pages.rstr;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.nv.dwss.nvkids.pages.dref.EditDocumentAttributesPage;
import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class EditFamilialRestrictedCasesPage extends CommonLocators

{
	public EditFamilialRestrictedCasesPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	//Screen Function Name
	@FindBy(xpath = "//span[text()='Edit Familial Restricted Cases']") WebElement elesfEditFamilialRestrictedCases;
	
	//Labels
	@FindBy(xpath = "//label[text()='Active']") WebElement elelblActive;
	@FindBy(xpath = "//label[text()='Inactive']") WebElement elelblInactive;
	
	//Info Panel
	@FindBy(xpath = "//div[@class='p-col-12 HeaderHighlight']/div/lib-label-value/div/label") List <WebElement> eleEditInforPanel;
	
	//Radio Buttons
	@FindBy(xpath = "//label[text()='Active']/preceding::span[1][contains(@class,'radiobutton')]")  WebElement elerbActive;
	@FindBy(xpath = "//label[text()='Inactive']/preceding::span[1][contains(@class,'radiobutton')]")  WebElement elerbInactive;
	
	//For Screen Function Name Check
	@FindAll(
			{
				@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='View Familial Restricted Cases']"),
				@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='Edit Familial Restricted Cases Status']")
			}) public WebElement eleComHeaderPanel;
	
	
	public EditFamilialRestrictedCasesPage verifyFieldsPresent() throws Exception
	{
		
		
		verifyExactText(elesfEditFamilialRestrictedCases, "Edit Familial Restricted Cases");
		verifyFieldSetLabels(eleEditInforPanel," Case "," Participant "," User "," Reason Code "," Reason ");
		
		verifyDisplayed(elelblActive,"Active");
		verifyDisplayed(elelblInactive,"Inactive");
		
		verifyDisplayed(eleicnRefresh,"Refresh");
		verifyDisplayed(eleicnSave,"Save");
		verifyDisplayed(eleicnClose,"Close");
		
		return this;
	}
	

	public EditFamilialRestrictedCasesPage editStatus() throws Exception
	{
		
	
    click(elerbInactive,"Inactive");
    click(eleicnSave, "Save");
    verifyExactText(eleErrStatusBar, "SAVED SUCCESSFULLY");

		return this;
	}
	
	
	
	
}
