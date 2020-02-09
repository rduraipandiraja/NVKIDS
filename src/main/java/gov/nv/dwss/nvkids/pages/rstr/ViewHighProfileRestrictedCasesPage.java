package gov.nv.dwss.nvkids.pages.rstr;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import gov.nv.dwss.nvkids.pages.bstl.BatchStatusLogsPage;
import gov.nv.dwss.nvkids.pages.dref.ViewDocumentAttributesPage;
import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class ViewHighProfileRestrictedCasesPage extends CommonLocators
{
	
	public ViewHighProfileRestrictedCasesPage() 
	{
		PageFactory.initElements(driver, this);
	}
	

	//Screen Function
    @FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='High Profile Restricted Cases']") WebElement elesfHighProfileRestrictedCases;
	
    //Filter Section Labels and Fields
	@FindBy(xpath ="//label[text()='Case']") WebElement elelblCase;
	@FindBy(id="caseId") WebElement eletxtCaseID;
	@FindBy(xpath ="//label[text()='Participant']") WebElement elelblParticipant;
	@FindBy(id="personId") WebElement eletxtParticipantID;
	
	
	@FindBy(xpath="//tr[@class='ng-star-inserted']/following::tbody") public WebElement elegridStatusCell;
	
	//Double Click Navigate To Edit Screen Function
	@FindBy(xpath = "//tr[1]/td[1]/div/div") WebElement eleGridRow;
	
	//Navigate to Familial Restricted Cases
	@FindBy(xpath = "//span[text()='Familial Restricted Cases']") WebElement elelinkFamilialRestrictedCase;
	


	public ViewHighProfileRestrictedCasesPage verifyFieldsPresent() throws Exception
	{
		verifyGridHeaders(elelblGridHeaders," Case "," Participant "," Reason "," Status ");
		verifyAssociatedScreens(eleAssociatedScreenList,"Note Processor");
		
		return this;
	}
	
	public ViewHighProfileRestrictedCasesPage verifyScreen() throws Exception
	{
		verifyExactText(elesfHighProfileRestrictedCases, "High Profile Restricted Cases");
		return this;
	}
	
	
	
	public ViewHighProfileRestrictedCasesPage inquireWithCase(String query,String caseCol1) throws Exception
	{

		String caseId = selectQuery(query,caseCol1);
		Thread.sleep(2000);
		click(eleicnFilter, "Filter");
		clearAndType(eletxtCaseID,"Case", caseId);
		click(eleicnSearch,"Search");
		Thread.sleep(2000);
		verifyGridContainsData(eleGridResult, caseId);
		
		return this;
	}
	
	public ViewHighProfileRestrictedCasesPage inquireWithParticipant(String query,String participantCol1) throws Exception
	{
		String participantId = selectQuery(query,participantCol1);
		Thread.sleep(2000);
		click(eleicnFilter, "Filter");
		clearAndType(eletxtParticipantID,"Participant", participantId);
		click(eleicnSearch,"Search");
		Thread.sleep(4000);
		verifyGridContainsData(eleGridResult, participantId);
		
		return this;
	}
	
	public ViewHighProfileRestrictedCasesPage verifyShowColumns() throws Exception
	{
		Thread.sleep(2000);
		verifyShowColumns(eleicnGridOptions,"Case","Participant","Reason Code","Reason","Status");

		return this;
	}
	
	public AddHighProfileRestrictedCasesPage navigateToAddHighRSTR() throws Exception
	{
		Thread.sleep(3000);
		click(eleicnAdd,"Add");
		Thread.sleep(4000);
		return new AddHighProfileRestrictedCasesPage();
	}
	
	public EditHighProfileRestrictedCasesPage navigateToEditHighRSTR(String query,String participantCol1) throws Exception
	{
		String participantId = selectQuery(query,participantCol1);
		Thread.sleep(2000);
		click(eleicnFilter, "Filter");
		clearAndType(eletxtParticipantID,"Participant", participantId);
		click(eleicnSearch,"Search");
		Thread.sleep(2000);
		doDoubleClick(eleGridRow);
		Thread.sleep(4000);
		return new EditHighProfileRestrictedCasesPage();
	}
	
	public ViewFamilialRestrictedCasesPage navigateToFamilialScreenFunction() throws Exception
	{
		click(elelinkFamilialRestrictedCase,"Familial Restricted Case Screen Function");
		return new ViewFamilialRestrictedCasesPage();
	}
	
	
}

