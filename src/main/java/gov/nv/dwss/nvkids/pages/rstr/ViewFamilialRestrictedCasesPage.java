package gov.nv.dwss.nvkids.pages.rstr;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class ViewFamilialRestrictedCasesPage extends CommonLocators
{
	
	public ViewFamilialRestrictedCasesPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Screen Function
	@FindBy(xpath="//p-breadcrumb/descendant::a/span[text()='Familial Restricted Cases']") WebElement elesfFamilialRestrictedCases;
	
	//Filter Section Labels and Fields
	@FindBy(xpath ="//label[text()='Case']") WebElement elelblCase;
	@FindBy(id="caseId") WebElement eletxtCaseID;
	@FindBy(xpath ="//label[text()='Participant']") WebElement elelblParticipant;
	@FindBy(id="personId") WebElement eletxtParticipantID;
	@FindBy(xpath ="//label[text()='User']") WebElement elelblUser;
	@FindBy(id="userName") WebElement eletxtUser;
	
	//Double Click Navigate To Edit Screen Function
	@FindBy(xpath = "//tr[1]/td[1]/div/div") WebElement eleGridRow;
	

	public ViewFamilialRestrictedCasesPage verifyFieldsPresent() throws Exception
	{
		
		Thread.sleep(2000);
		verifyGridHeaders(elelblGridHeaders," Case "," Participant "," User "," Reason "," Status ");
		return this;
	}
	
	
	public ViewFamilialRestrictedCasesPage inquireWithCase(String query,String caseCol1) throws Exception
	{
		String caseId = selectQuery(query,caseCol1);
		Thread.sleep(2000);
		click(eleicnFilter, "Filter");
		click(eleicnClear,"Clear");
		clearAndType(eletxtCaseID,"Case", caseId);
	
		click(eleicnSearch,"Search");
		verifyGridContainsData(eleGridResult, caseId);
		
		return this;
	}
	
	public ViewFamilialRestrictedCasesPage inquireWithParticipant(String query,String participantCol1) throws Exception
	{
		String participantId = selectQuery(query,participantCol1);
		Thread.sleep(2000);
		click(eleicnFilter,"Filter");
		click(eleicnClear,"Clear");
		clearAndType(eletxtParticipantID,"Participant", participantId);
		
		click(eleicnSearch,"Search");
		Thread.sleep(2000);
		verifyGridContainsData(eleGridResult, participantId);
		
		return this;
	}
	
	public ViewFamilialRestrictedCasesPage inquireWithUser(String query,String userCol1,String userCol2) throws Exception
	{
		
		String userId = selectQuery(query,userCol1);
		String userName = selectQuery(query,userCol2);
		
		Thread.sleep(2000);
        
		click(eleicnFilter,"Filter");
		click(eleicnClear,"Clear");
		clearAndType(eletxtUser,"User", userId);
		
		click(eleicnSearch,"Search");
		Thread.sleep(2000);
		verifyGridContainsData(eleGridResult, userName);
		
		return this;
	}
	
	public ViewFamilialRestrictedCasesPage verifyShowColumns() throws Exception
	{
		Thread.sleep(2000);
		verifyShowColumns(eleicnGridOptions,"Case","Participant","User","Reason Code","Reason","Status");

		return this;
	}
	

	public AddFamilialRestrictedCasesPage navigateToAddFamilialRSTR() throws Exception
	{
		Thread.sleep(3000);
		click(eleicnAdd,"Add");
		Thread.sleep(4000);
		return new AddFamilialRestrictedCasesPage();
	}
	
	public EditFamilialRestrictedCasesPage navigateToEditFamilialRSTR(String query,String participantCol1) throws Exception
	{
		String participantId = selectQuery(query,participantCol1);
		
		Thread.sleep(3000);
		click(eleicnFilter, "Filter");
		click(eleicnClear,"Clear");
		clearAndType(eletxtParticipantID,"Participant", participantId);
		click(eleicnSearch,"Search");
		Thread.sleep(2000);
		doDoubleClick(eleGridRow);
		Thread.sleep(4000);
		return new EditFamilialRestrictedCasesPage();
	}
	

}
