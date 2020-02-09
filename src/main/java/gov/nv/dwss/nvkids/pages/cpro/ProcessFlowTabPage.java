package gov.nv.dwss.nvkids.pages.cpro;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class ProcessFlowTabPage extends CommonLocators 
{
	public ProcessFlowTabPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h6[text()=' Process Flow View']") WebElement elelblProcessFlowView;
	
	@FindBy(xpath="//div[@class='statusBtn inprogress']") WebElement elebtnInProgress;
	
	@FindBy(xpath="//tr[@class='ng-star-inserted']/th[(contains(@class,'sortable-column'))]") List<WebElement> elelblsGridHeaders;
	
	@FindBy(xpath="//tbody/tr[contains(@class,'ui-selectable-row ui-state-highlight ng-star-inserted')]") WebElement elehgrd;
	
	
	
	public ProcessFlowTabPage verifyTab() throws Exception
	{
		
		verifyExactText(elelblProcessFlowView, "Process Flow View");
		verifyDisplayed(eleicnClose, "Close");
		verifyGridHeaders(elelblsGridHeaders," Role "," Task "," Current Status "," Evaluate ", " Outcome ", " Next Task ");
		verifyDisplayed(elebtnInProgress, "In Progress");
		verifyDisplayed(elehgrd,"Row Highlight");

		return this;
	}
	
	
	public CompleteTaskTabPage navigatetoCompleteTask() throws Exception
	{
		
		click(elebtnInProgress,"In Progress");

		return new CompleteTaskTabPage();
	}
	
}
