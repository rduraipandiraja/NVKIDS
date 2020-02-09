package gov.nv.dwss.nvkids.pages.rstr;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.nv.dwss.nvkids.pages.dref.AddDocumentAttributesPage;
import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class AddHighProfileRestrictedCasesPage extends CommonLocators
{
	
	public AddHighProfileRestrictedCasesPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	//Screen Function
	@FindBy(xpath = "//span[text()='Add High Profile Restricted Cases']") WebElement elesfAddHighProfileRestrictedCases;
	
	//Labels
	@FindBy(xpath = "//label[text()='Case']") WebElement elelblCase;
	@FindBy(xpath = "//label[text()='Participant']") WebElement elelblParticipant;
	@FindBy(xpath = "//label[text()='Reason']") WebElement elelblReason;
	
	//Enter or Selection Of Fields
	@FindBy(id="caseId") WebElement eletxtCase;
	@FindBy(id="personId") WebElement eletxtParticipant;
	@FindBy(xpath = "//label[text()='Reason']/following::div[1]") WebElement eleddReason;
	
	//DropDown Case and Participant Fields
	@FindBy(xpath= "//label[text()='Case']/following::div[1]")WebElement eleddCase;
	@FindBy(xpath= "//label[text()='Participant']/following::div[1]")WebElement eleddParticipant;
	
	//Case and Participant Drop-down CheckBox
	@FindBy(xpath = "//span[@class='ui-multiselect-label ui-corner-all']") WebElement eleddCaseParticipant;
	
	//MultiSelect CheckBox for Case/Participant and Close Button
	@FindBy(xpath = "//p-multiselectitem[1]/li/div") WebElement elecbCaseParticipant;
	//@FindBy(xpath = "//a[@class='ui-multiselect-close ui-corner-all']/span") WebElement eleicnCloseCaseParticipant;
	
	//For Screen Function Name Check
	@FindAll(
			{
				@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='View High Profile Restricted Cases']"),
				@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='Add High Profile Restricted Cases']")
			}) public WebElement eleComHeaderPanel;
	
	
	public AddHighProfileRestrictedCasesPage verifyFieldsPresent() throws Exception
	{
		verifyExactText(elesfAddHighProfileRestrictedCases, "Add High Profile Restricted Cases");
		verifyDisplayed(elelblCase,"Case");
		verifyRequiredField(elelblCase);
		verifyDisplayed(elelblParticipant,"Participant");
		verifyRequiredField(elelblParticipant);
		verifyDisplayed(elelblReason,"Reason");
		verifyRequiredField(elelblReason);
		verifyDisplayed(eleicnClear,"Clear");
		verifyDisplayed(eleicnSave,"Save");
		verifyDisplayed(eleicnClose,"Close");
		return this;
		
	}
	

	public AddHighProfileRestrictedCasesPage addWithMultiParticipant(String query,String caseCol1) throws Exception
	{

		String caseId = selectQuery(query,caseCol1);
		clearAndType(eletxtCase,"Case",caseId);
	    setFocus(elelblParticipant, eletxtParticipant);
	    Thread.sleep(1500);
	    click(eleddCaseParticipant,"Participant");
	    Thread.sleep(1500);
	    click(elecbCaseParticipant,"Checkbox");
	    
	    
	    selectRandomDropdownValue(eleddReason);
	    
	    click(eleicnSave, "Save");
	    Thread.sleep(1000);
	    verifyExactText(eleErrStatusBar, "SAVED SUCCESSFULLY");
	    return this;
	    
	}
	
	public AddHighProfileRestrictedCasesPage addWithMultiCase(String query,String participantCol1) throws Exception
	{
		String participantId = selectQuery(query,participantCol1);
	    clearAndType(eletxtParticipant,"Participant",participantId);
	    setFocus(elelblCase, eletxtCase);
	    Thread.sleep(1500);
	    click(eleddCaseParticipant,"Case");
	    Thread.sleep(1500);
	    click(elecbCaseParticipant,"Checkbox");
	    
	    selectRandomDropdownValue(eleddReason);
	   
	    click(eleicnSave, "Save");
	    Thread.sleep(1000);
	    verifyExactText(eleErrStatusBar, "SAVED SUCCESSFULLY");
	    return this;
	    
	}
	
	
}
