package gov.nv.dwss.nvkids.pages.rstr;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class AddFamilialRestrictedCasesPage extends CommonLocators
{
	
	public AddFamilialRestrictedCasesPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Screen Function
	@FindBy(xpath = "//span[text()='Add Familial Restricted Cases']") WebElement elesfAddFamilialRestrictedCases;
	
	//Labels
	@FindBy(xpath = "//label[text()='Case']") WebElement elelblCase;
	@FindBy(xpath = "//label[text()='Participant']") WebElement elelblParticipant;
	@FindBy(xpath = "//label[text()='Reason']") WebElement elelblReason;
	@FindBy(xpath = "//label[text()='User ID']") WebElement elelblUser;
	
	//Enter or Selection Of Fields
	@FindBy(id="caseId") WebElement eletxtCase;
	@FindBy(id="personId") WebElement eletxtParticipant;
	@FindBy(xpath = "//label[text()='Reason']/following::div[1]") WebElement eleddReason;
	@FindBy(id="userName") WebElement eletxtUserID;
	
	//DropDown Case and Participant Fields
	@FindBy(xpath= "//label[text()='Case']/following::div[1]")WebElement eleddCase;
	@FindBy(xpath= "//label[text()='Participant']/following::div[1]")WebElement eleddParticipant;
	
	//Case and Participant Drop-down CheckBox
	@FindBy(xpath = "//span[@class='ui-multiselect-label ui-corner-all']") WebElement eleddCaseParticipant;
	
	//MultiSelect CheckBox for Case/Participant and Close Button
	@FindBy(xpath = "//p-multiselectitem[1]/li/div") WebElement elecbCaseParticipant;
	@FindBy(xpath = "//a[@class='ui-multiselect-close ui-corner-all']/span") WebElement eleicncloseCaseParticipant;
	
	//For Screen Function Name Check
	@FindAll(
			{
				@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='View Familial Restricted Cases']"),
				@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='Add Familial Restricted Cases']")
			}) public WebElement eleComHeaderPanel;
	
	
	public AddFamilialRestrictedCasesPage verifyFieldsPresent() throws Exception
	{

		verifyExactText(elesfAddFamilialRestrictedCases, "Add Familial Restricted Cases");
		verifyDisplayed(elelblCase,"Case");
		verifyRequiredField(elelblCase);
		verifyDisplayed(elelblParticipant,"Participant");
		verifyRequiredField(elelblParticipant);
		verifyDisplayed(elelblUser,"User ID");
		verifyRequiredField(elelblUser);
		verifyDisplayed(elelblReason,"Reason");
		verifyRequiredField(elelblReason);
		
		return this;
		
	}
	

	public AddFamilialRestrictedCasesPage addWithMultiParticipant(String query,String caseCol1,String query2,String userCol2) throws Exception
	{
		String caseId = selectQuery(query,caseCol1);
		String userId = selectQuery(query2,userCol2);
	    clearAndType(eletxtCase,"Case",caseId);
	    setFocus(elelblParticipant, eletxtParticipant);
	    Thread.sleep(1500);
	    click(eleddCaseParticipant,"Participant");
	    Thread.sleep(1500);
	    click(elecbCaseParticipant,"Checkbox");
	    
	    click(eletxtUserID,"User ID");
	    clearAndType(eletxtUserID,"User ID",userId);
	    
	    selectRandomDropdownValue(eleddReason);
	    
	    click(eleicnSave, "Save");
	    Thread.sleep(1000);
	    verifyExactText(eleErrStatusBar, "SAVED SUCCESSFULLY");
	    return this;
	    
	}
	
	public AddFamilialRestrictedCasesPage addWithMultiCase(String query,String participantCol1,String query2,String userCol2) throws Exception
	{
		String participantId = selectQuery(query,participantCol1);
		String userId = selectQuery(query2,userCol2);
	    clearAndType(eletxtParticipant,"Participant",participantId);
	    setFocus(elelblCase, eletxtCase);
	    Thread.sleep(1500);
	    click(eleddCaseParticipant,"Case");
	    Thread.sleep(1500);
	    click(elecbCaseParticipant,"Checkbox");
	    
	    
	    clearAndType(eletxtUserID,"User ID",userId);
	    
	   
	    selectRandomDropdownValue(eleddReason);
	    
	    click(eleicnSave, "Save");
	    Thread.sleep(1000);
	    verifyExactText(eleErrStatusBar, "SAVED SUCCESSFULLY");

	 
	    return this;
	    
	}
	
}
