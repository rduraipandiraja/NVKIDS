package gov.nv.dwss.nvkids.pages.proc;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;


public class MaintainProcessDetails extends CommonLocators 
{
	public MaintainProcessDetails() 
	{
		PageFactory.initElements(driver, this); 
	}
    
		//Screen Function
		@FindBy(xpath="//p-breadcrumb/descendant::a/span[text()='View Process Details']") public WebElement elebcViewProcessDetails;
		
		//Filter Section
		
		@FindBy(xpath="//label[text()='Process Name']") public WebElement elelblProcessName;
		@FindBy(xpath="//input[@id='processCode']") public WebElement eletxtProcessName;
		@FindBy(xpath="//input[@id='processCode']/following-sibling::button") public WebElement eleicnlovProcessName;

		//Grid Section
		
		@FindBy(xpath="//label[text()=' Role ']") public WebElement elehdrRole;
		@FindBy(xpath="//label[text()=' Task ']") public WebElement elehdrTask;
		@FindBy(xpath="//label[text()=' Task ID ']") public WebElement elehdrTaskId;
		@FindBy(xpath="//label[text()=' Evaluate ']") public WebElement elehdrEvaluate;		
		@FindBy(xpath="//label[text()=' Outcome ']") public WebElement elehdrOutcome;		
		@FindBy(xpath="//label[text()=' Next Task ']") public WebElement elehdrNextTask;	
		@FindBy(xpath="//label[text()=' Next Task ID ']") public WebElement elehdrNextTaskId;
		@FindBy(xpath="//label[text()=' Docs ']") public WebElement elehdrDocs;
		@FindBy(xpath="//label[@for='responseTypeCode']/following-sibling::p-dropdown/descendant::label") public WebElement eleddRole;	
		@FindBy(xpath="//input[@id='taskDesc']") public WebElement eletxtTask;	
		@FindBy(xpath="//input[@id='taskCode']") public WebElement eletxtTaskId;
		@FindBy(xpath="//input[@id='taskCode']/following-sibling::button") public WebElement eleicnlovTaskId;
		@FindBy(xpath="//input[@id='evaluationDesc']") public WebElement eletxtEvaluate;	
		@FindBy(xpath="//input[@id='outcomeDesc']") public WebElement eletxtOutcome;	
		@FindBy(xpath="//input[@id='nextTaskCode']") public WebElement eletxtNextTaskId;
		@FindBy(xpath="//input[@id='nextTaskCode']/following-sibling::button") public WebElement eleicnlovNextTaskId;
		@FindBy(xpath="//input[@id='nextTaskName']") public WebElement eletxtNextTask;		
		@FindBy(xpath="//input[@id='documentCountNumb']") public WebElement eletxtDocs;	
		
		
		
		//Grid Contains Section
		
		@FindBy(xpath="//tr/td[1]/span[@class='ng-star-inserted']") public List<WebElement> eleGridRole;
		@FindBy(xpath="//tr/td[2]/span[@class='ng-star-inserted']") public List<WebElement> eleGridTaskId;
		@FindBy(xpath="//tr/td[3]/div") public List<WebElement> eleGridTask;
		@FindBy(xpath="//tr/td[4]/span[@class='ng-star-inserted']") public List<WebElement> eleGridEvaluate;	
		@FindBy(xpath="//tr/td[5]/div[@class='ng-star-inserted']/descendant::lib-label") public List<WebElement> eleGridOutcome;
		@FindBy(xpath="//tr/td[6]/div[@class='ng-star-inserted']/descendant::lib-label") public List<WebElement> eleGridNextTaskId;	
		@FindBy(xpath="//tr/td[7]/div[@class='ng-star-inserted']/descendant::lib-label") public List<WebElement> eleGridNextTask;
		@FindBy(xpath="//tr/td[8]/div[@class='ng-star-inserted']/descendant::lib-link") public List<WebElement> eleGridDocs;	
		
		
		@FindBy(xpath="(//tbody/descendant::a[contains(@class,'link' ) and contains(text(),'0')])[1]") public WebElement eleGridCellZeroDocs;
		

		//Associated Screens

		@FindBy(xpath="(//li[contains(@class,'associatedMenuItem')]/descendant::span[text()='Process and Task Reference']") public WebElement elelinkProcessandTaskReference;
		@FindBy(xpath="(//li[contains(@class,'associatedMenuItem')]/descendant::span[text()='Note Processor'])") public WebElement elelinkNoteProcessor;
		@FindBy(xpath="(//li[contains(@class,'associatedMenuItem')]/descendant::span[text()='Document Reference'])") public WebElement elelinkDocumentReference;		
		
		@FindBy(xpath="(//tbody/descendant::a[contains(@class,'link' )])") public List<WebElement> eleGridCellDocs;
		
		
		public MaintainProcessDetails clickDOCS() throws InterruptedException
		{
	        WebDriverWait wait = new WebDriverWait(driver,50);
	        wait.until(ExpectedConditions.visibilityOfAllElements(eleGridCellDocs));
			for(WebElement ele :eleGridCellDocs)
			{
				int val=Integer.parseInt(ele.getText().trim());
				if(val>2)
				{
					click(ele,"Docs");
					break;
				}
			}
			Thread.sleep(3000);
			return this;
		}
		
		public ViewDocumentsAssociatedPage navigateToViewDocumentAssociated(String query,String document) throws InterruptedException, ClassNotFoundException, SQLException 
		{
			click(eleicnFilter,"Filter");
			String Docs = selectQuery(query,document);
			clearAndType(eletxtProcessName,"Process Name",Docs);
			pressEnterKey(eletxtProcessName);
			click(eleGridCellZeroDocs,"Zero Documents");
			Thread.sleep(2000);
			return new ViewDocumentsAssociatedPage();
		}

		public ViewDocumentsAssociatedPage navigateToViewDocumentAssociatedScreen(String query,String documents) throws InterruptedException, ClassNotFoundException, SQLException 
		{
			click(eleicnFilter,"Filter");
			String Docs = selectQuery(query,documents);
			clearAndType(eletxtProcessName,"Process Name",Docs);
			pressEnterKey(eletxtProcessName);
			clickDOCS();
			return new ViewDocumentsAssociatedPage();
		}
		
		public MaintainProcessDetails selectProcessName(String query,String processname) throws InterruptedException, ClassNotFoundException, SQLException 
		{
			click(eleicnFilter,"Filter");
			click(eleicnlovProcessName,"ProcessName LOV");
			String ProcessName = selectQuery(query,processname);
			clearAndType(eleSearchBarSearch,"Select Process Name",ProcessName);
			pressEnterKey(eleSearchBarSearch);
			doDoubleClick(eleGridCells);
		    click(eleicnSearch,"Search");
			Thread.sleep(3000);
			return this;
		}
		
		public MaintainProcessDetails verifyViewPROCInfo() throws Exception
		{
			verifyDisplayed(eleicnFilter,"Filter");
			verifyGridHeaders(elelblGridHeaders," Role ", " Task "," Evaluate "," Outcome "," Next Task "," Docs ");
			scrollToElementPosition(elelinkDocumentReference);
			Thread.sleep(2000);
			verifyAssociatedScreens(eleAssociatedScreenList,"Process and Task Reference","Note Processor","Document Reference");
			return this;
		}

		public MaintainProcessDetails verifySelecFilters() throws Exception
		{
			Thread.sleep(2000);	
			click(eleicnFilter,"Filter");	
			Thread.sleep(2000);	
			verifyDisplayed(elelblProcessName,"Process Name");
			verifyDisplayed(eleicnClear,"Clear");
			verifyDisplayed(eleicnSearch,"Search");
			return this;
		}

		
		public MaintainProcessDetails verifyValidProcessName(String query,String processname) throws InterruptedException, ClassNotFoundException, SQLException
		{
			click(eleicnFilter,"Filter");
			String ProcessCode = selectQuery(query,processname);
			clearAndType(eletxtProcessName,"Process Name",ProcessCode);
			pressEnterKey(eletxtProcessName);
			verifyGridContainsData(eleGridResult, "CASE");
			return this;
		}
		
		public MaintainProcessDetails Inquireshowncolumns() throws InterruptedException, ClassNotFoundException, SQLException
		{
			verifyShowColumns(eleicnGridOptions,"Role","Task ID","Task","Evaluate","Outcome","Next Task ID","Next Task","Docs");
			return this;
		}
		
}
	