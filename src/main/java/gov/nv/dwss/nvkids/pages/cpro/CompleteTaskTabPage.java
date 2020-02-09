package gov.nv.dwss.nvkids.pages.cpro;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class CompleteTaskTabPage extends CommonLocators

{
	public CompleteTaskTabPage() 
	{
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//h6[text()=' Complete Task']") WebElement elelblCompleteTask;
	@FindBy(xpath="//label[text()='Paternity/Marital Birth Status Reviewed ~ Check If Good Cause Requested']//preceding::div[(contains(@class,'ui-radiobutton-box'))]") WebElement eleicnrbPaternity;


	public CompleteTaskTabPage verifyCompleteTask() throws Exception
	{
		verifyExactText(elelblCompleteTask, "Complete Task");
		return this;
	}
	
	public CompleteTaskTabPage startGoodCause() throws Exception
	{
		verifyDisplayed(eleicnrbPaternity, "Radio Button in Paternity/Marital Birth Status Reviewed");
		selectReason(eleicnrbPaternity);
		return this;
	}

	public ProcessFlowTabPage selectReason(WebElement ele) throws Exception
	{
		click(ele, "Reason");
		click(eleicnSave,"Save");
		verifyExactText(eleErrStatusBar, "SAVED SUCCESSFULLY");
		delay(3000);
		return new ProcessFlowTabPage();
	}
	






}
