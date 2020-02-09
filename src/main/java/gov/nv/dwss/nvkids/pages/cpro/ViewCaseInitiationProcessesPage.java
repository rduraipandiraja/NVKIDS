package gov.nv.dwss.nvkids.pages.cpro;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class ViewCaseInitiationProcessesPage extends CommonLocators 

{
	public ViewCaseInitiationProcessesPage() 
	{
		PageFactory.initElements(driver, this);
	}
	

	    //Screen Function Name
	    @FindBy(xpath = "//span[text()='View Case Initiation Processes']") WebElement elesfViewCaseInitiationProcesses;
	
	    //Filter Section	
		@FindBy(xpath="//label[text()='Case ID']") WebElement elelblCaseID;
		@FindBy(xpath="(//label[text()='Case ID']/following::input)[1]") WebElement eletxtCaseID;	
		@FindBy(xpath="//label[text()='Process']") WebElement elelblProcess;
		@FindBy(xpath="//label[text()='Process']/following::div[1]/label") WebElement eleddProcess;
		
		//Actions button
		@FindBy(xpath="//span[@class='ui-button-icon-left ui-clickable pi pi-chevron-down']") WebElement eleddActions;
		@FindBy(xpath="//span[text()='Start a Process']") WebElement eleddStartProcess;
		
		//Start New Process Popup

		@FindBy(xpath="//label[text()='Case ID']") WebElement elepplblCaseID;
		@FindBy(id="caseId") WebElement elepptxtCaseID;
		@FindBy(xpath="//label[text()='Docket Number']") WebElement elepplblDocket;
		@FindBy(xpath="//label[text()='Category']") WebElement elepplblCategory;
		@FindBy(xpath="//label[text()='Category']/following::div[1]/label") WebElement eleppddCategory;
		@FindBy(xpath="//label[text()='Process']") WebElement elepplblProcess;
		@FindBy(xpath="//label[text()='Process']/following::div[1]/label") WebElement eleppddProcess;
		@FindBy(xpath="//label[text()='Source Type']") WebElement elepplblSourceType;
		@FindBy(xpath="//label[text()='Source Type']/following::div[1]/label") WebElement eleppddSourceType;
		@FindBy(xpath="//label[text()='Source Name']") WebElement elepplblSourceName;
		@FindBy(xpath="//label[text()='Reference Type']") WebElement elepplblReferenceType;
		@FindBy(xpath="//label[text()='Reference ID']") WebElement elepplblReferenceID;
		@FindBy(xpath="//span[text()='Start Process']") public WebElement eleicnStartProcess;
		
		//Double click on grid to naviagate process flow view
		@FindBy(xpath = "(//tr[@title='Double click any row for edit'])[1]") WebElement eleGrid;
		
		public ViewCaseInitiationProcessesPage verifyFieldsPresent() throws Exception
		{
			verifyExactText(elesfViewCaseInitiationProcesses, "View Case Initiation Processes");
			verifyGridHeaders(elelblGridHeaders," Select "," Process "," Latest Task "," Process Status ", " Source Type ", " Source Name "," Created On "," Created By "," Updated On ");
			verifyAssociatedScreens(eleAssociatedScreenList, "Create and Maintain Case","Event Log","Document Processor","Schedule Processor","Search for Cases","Worklist");
			return this;
		}
		
		public ViewCaseInitiationProcessesPage verifyFilterFields() throws Exception
		{
			
			click(eleicnFilter,"Filter");
			delay(2000);
			
			verifyDisplayed(elelblCaseID, "Case ID");
			verifyDisplayed(elelblProcess, "Process");
			

			verifyDisplayed(eleicnClear,"Clear");
			verifyDisplayed(eleicnSearch,"Search");
		return this;
		}
		
		public ViewCaseInitiationProcessesPage inquireCaseID(String query,String col1) throws Exception
		{
			String caseId = selectQuery(query,col1);
			click(eleicnFilter,"Filter");
			delay(2000);
			clearAndType(eletxtCaseID, "Case ID", caseId);
			delay(2000);
			click(eleicnSearch,"Search");
			verifyGridResult(eleGridResult,"Case Assessment Process");
		return this;
		}
		
		public ViewCaseInitiationProcessesPage inquireCaseProcess(String query,String col1) throws Exception
		{
			
			String caseId = selectQuery(query,col1);
			click(eleicnFilter,"Filter");
			delay(2000);
			clearAndType(eletxtCaseID, "Case ID", caseId);
			delay(2000);
			selectDropdownValue(eleddProcess, "CASE ASSESSMENT PROCESS");
			click(eleicnSearch,"Search");
			verifyGridResult(eleGridResult, "Case Assessment Process");
			
		return this;
		}
		
		public ViewCaseInitiationProcessesPage verifyShowColumns() throws Exception
		{
			delay(2000);
			verifyShowColumns(eleicnGridOptions,"Process","Latest Task","Process Status", "Source Type", "Source Name","Reference Type","Reference ID","Created On","Created By","Updated On");
			return this;
		}
		
		public ViewCaseInitiationProcessesPage verifyStartNewProcessPopup() throws Exception
		{
			delay(2000);
		    click(eleddActions,"Actions");
		    click(eleddStartProcess,"Start a Process");
		    
		    verifyDisplayed(elepplblCaseID, "Case ID");
		    verifyDisplayed(elepplblDocket, "Docket");
		    verifyDisplayed(elepplblCategory, "Category");
		    verifyDisplayed(elepplblProcess, "Process");
		    verifyDisplayed(elepplblSourceType, "Source Type");
		    verifyDisplayed(elepplblSourceName, "Source Name");
		    verifyDisplayed(elepplblReferenceType, "Reference Type");
		    verifyDisplayed(elepplblReferenceID, "Reference ID");
		    
		    verifyDisplayed(eleicnClear,"Clear");
		    verifyDisplayed(eleicnStartProcess,"Start Process");
		    
			return this;
		}
		
		
		public ProcessFlowTabPage navigateToProcessFlowTabbyStartProcesspopup(String query,String col1) throws Exception
		{
			String enterCase = selectQuery(query,col1);
			verifyStartNewProcessPopup();
			clearAndType(elepptxtCaseID, "Case ID", enterCase);
			selectDropdownValue(eleppddCategory, "CASE INITIATION");
			selectDropdownValue(eleppddProcess, "CASE ASSESSMENT PROCESS");
			selectDropdownValue(eleppddSourceType, "CUSTODIAN");
			delay(2000);
			click(eleicnStartProcess,"Start Process");
			delay(2000);
			return new ProcessFlowTabPage();
		}
		
		public ProcessFlowTabPage navigateToProcessFlowTabbyInquire(String query,String col1) throws Exception
		{
			
			String caseId = selectQuery(query,col1);
			click(eleicnFilter,"Filter");
			delay(2000);
			clearAndType(eletxtCaseID, "Case ID", caseId);
			delay(2000);
			click(eleicnSearch,"Search");
			delay(2000);
			verifyGridResult(eleGridResult, "Case Assessment Process");
			doDoubleClick(eleGrid);
			return new ProcessFlowTabPage();
		
		}
		
		
}
