package gov.nv.dwss.nvkids.pages.psoi;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import gov.nv.dwss.nvkids.pages.demo.PersonalInformationPage;
import gov.nv.dwss.nvkids.pages.smsg.ViewSystemMessagesPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class ViewParticipantSourceOfIncomePage extends CommonLocators
{

	public ViewParticipantSourceOfIncomePage()
	{
		PageFactory.initElements(driver, this);
	}

	//Screen  Functions
	@FindBy(xpath="//span[text()='View Participant Source Of Income']") WebElement elesfViewParticipantSourceOfIncome;
	//@FindBy(xpath="//h5[@class='ng-star-inserted']" WebElement elesfViewParticipantSourceOfIncome;
	@FindBy(xpath="//div[@class='p-col-12 participantHeader relative']")WebElement eleribCaseSummaryRibbon;



	@FindBy(xpath="//label[text()=' Verification Status ']") WebElement eleglblVerificationStatus;
	@FindBy(xpath="//label[text()='  Income Type  ']") WebElement eleglblIncomeType;
	@FindBy(xpath="//label[text()=' Source of Income ID ']") WebElement eleglblSourceOfIncomeId;
	@FindBy(xpath="//label[text()=' Source of Income ']") WebElement eleglblSourceOfIncome;
	@FindBy(xpath="//label[text()=' Status Date ']") WebElement eleglblStatusDate;
	@FindBy(xpath="//label[text()=' SOI Begin Date ']") WebElement eleglblSoiBeginDate;
	@FindBy(xpath="//label[text()=' SOI End Date ']") WebElement eleglblSoiEndDate;
	//associated screen
	@FindBy(xpath="(//span[text()='Participant Address'])[3]") WebElement eleAssociatedScreenPartAddress;
	@FindBy(xpath="(//span[text()='Participant Demographics'])[2]") WebElement eleAssociatedScreenPartDemographic;
	@FindBy(xpath="//span[text()='Note Processor']") WebElement eleAssociatedScreenNoteProcessor;
	@FindBy(xpath="//span[text()='Create and Maintain Case']") WebElement eleAssociatedScreenCreateAndMaintainCase;
	@FindBy(xpath="//span[text()='Source of Income Information']") WebElement eleAssociatedScreenSourceOfIncomeInformation;

	//filter screen 
	@FindBy(xpath = "//label[text()='Participant ID']") WebElement elelblParticipantID;
	@FindBy(xpath = "//label[text()='Participant ID']/following-sibling::input") WebElement eleddParticipantID;
	@FindBy(xpath = "//span[@class='fa fa-search ui-clickable ui-button-icon-left ng-star-inserted']") WebElement elelovParticipantID;

	@FindBy(xpath = "//label[text()='Verification Status']") WebElement elelblVerificationStatus;
	@FindBy(xpath = "//label[text()='Verification Status']/following::div") WebElement eleddVerificationStaus;
	@FindBy(xpath = "(//span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-chevron-down'])[2]") WebElement elelovVerificationStatus;

	@FindBy(xpath = "(//label[@class='fieldLabel'])[4]") WebElement elelblPrimary;
	@FindBy(xpath = "(//span[text()='--SELECT--'])[2]") WebElement eleddPrimary;
	@FindBy(xpath = "((//div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[3]") WebElement elelovPrimary;
	//table data
	@FindBy(xpath = "//tbody[@class='ui-table-tbody']/tr/td[2]/span") WebElement eletdVerificationStatus;
	@FindBy(xpath = "(//tbody[@class='ui-table-tbody']/tr/td[2]/span)[1]") WebElement eletdVerification;
	//selecting verification status from grid option
	@FindBy(xpath = "(//span[@class='ng-star-inserted'])[2]") WebElement eleddVeriStatusGrid;
	@FindBy(xpath = "(//span[@class='ng-star-inserted'])[3]") WebElement eleddIncomeTypeCode;
	@FindBy(xpath = "(//span[@class='ng-star-inserted'])[4]") WebElement eleddIncomeType;
	@FindBy(xpath = "//input[@id='otherPartyName']") WebElement eletbSourceOfIncome;
	@FindBy(xpath = "//label[text()=' Source of Income ']") WebElement elelblSourceOfIncome;
	@FindBy(xpath = "//input[@id='otherPartyId']") WebElement eletbSourceOfIncomeID;
	@FindBy(xpath = "//label[text()=' Source of Income ID ']") WebElement elelblSourceOfIncomeID;
	@FindBy(xpath = "//input[@id='psoiStatusDate']") WebElement eletbStatusDate;
	@FindBy(xpath = "//label[@for='psoiStatusDate']") WebElement elelblStatusDate;
	@FindBy(xpath = "//input[@id='psoiBeginDate']") WebElement eletbSOIDate;
	@FindBy(xpath = "//label[text()=' SOI Begin Date ']") WebElement elelblSOIDate;
	@FindBy(xpath = "//input[@id='psoiEndDate']") WebElement eletbSOIEDate;
	@FindBy(xpath = "(//label[@for='psoiEndDate'])[1]") WebElement elelblSOIEDate;
	@FindBy(xpath = "//tbody[@class='ui-table-tbody']/tr/td[9]/span") WebElement eleTDRSOIEDate;
	@FindBy(xpath = "//tbody[@class='ui-table-tbody']/tr/td[8]/span") WebElement eleTDRSOIBDate;
	@FindBy(xpath = "//tbody[@class='ui-table-tbody']/tr/td[7]/span") WebElement eleTDRStatusDate;
	@FindBy(xpath = "//tbody[@class='ui-table-tbody']/tr/td[5]/span") WebElement eleTDRSourceofIncomeID;
	@FindBy(xpath = "//tbody[@class='ui-table-tbody']/tr/td[6]/span") WebElement eleTDRSourceofIncome;
	@FindBy(xpath = "//tbody[@class='ui-table-tbody']/tr/td[4]/span") WebElement eleTDRIncomeType;
	@FindBy(xpath = "//tbody[@class='ui-table-tbody']/tr/td[3]/span") WebElement eleTDRIncomeTypeCode;
	@FindBy(xpath = "(//div[@class='ui-helper-hidden-accessible']/following-sibling::label)[5]") WebElement eletbPrimry;
	

	public ViewParticipantSourceOfIncomePage VerifyViewParticipantSourceOfIncome() throws Exception
	{
		Thread.sleep(2000);
		verifyExactText(elesfViewParticipantSourceOfIncome, "View Participant Source Of Income");
		verifyGridHeaders(elelblGridHeaders," Verification Status ", "  Income Type  "," Source of Income ID "," Source of Income "," Status Date  "," SOI Begin Date "," SOI End Date ");
		verifyDisabled(eleicnAdd);
		verifyDisplayed(eleicnFilter,"Filter");
		verifyExactText(elesfViewParticipantSourceOfIncome, "View Participant Source Of Income");
		verifyAssociatedScreens(eleAssociatedScreenList,"Participant Address","Participant Demographics","Note Processor","Create and Maintain Case","Source of Income Information");

		return this;
	}


	
	public  ViewParticipantSourceOfIncomePage verifySelectFilters() throws Exception
	{
		Thread.sleep(2000);
		click(eleicnFilter,"Filter");
		Thread.sleep(2000);
		verifyDisplayed(elelblParticipantID, "Participant label");
		verifyDisplayed(eleddParticipantID, "Participant dropdown");
		
		verifyDisplayed(elelblVerificationStatus, "Verification Status label");
		verifyDisplayed(eleddVerificationStaus, "Verification Status dropdown");
		verifyDisplayed(elelovVerificationStatus, "Verification Status icon");
	    verifyDisplayed(elelblPrimary, "Primary label");
		verifyDisplayed(eleddPrimary, "Primary dropdown");
		



		return this;
	}


	public ViewParticipantSourceOfIncomePage InquireWithPartId(String query,String Data)throws IOException, InterruptedException, ClassNotFoundException, SQLException
	{ 
		click(eleicnFilter,"Filter");
		String selectQuery = selectQuery(query, Data);
		clearAndType(eleddParticipantID,"Participant ID label", selectQuery);
		pressEnterKey(eleddParticipantID);
        Thread.sleep(3000); 
        WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(eletdVerificationStatus));
        return this; 
	}

	//both Participant ID and Verification Status are selected 
	public ViewParticipantSourceOfIncomePage InquireWithPartIdandVerificationStatus(String query,String Data)throws IOException, InterruptedException, ClassNotFoundException, SQLException
	{ 
		click(eleicnFilter,"Filter");
		String selectQuery = selectQuery(query, Data);
		clearAndType(eleddParticipantID,"Participant ID label" , selectQuery);
        selectDropdownValue(eleddVerificationStaus,"CONFIRMED GOOD") ;
        click(eleicnSearch,"Search");
        Thread.sleep(3000); 
		verifyGridResult(eleGridResult,"CONFIRMED GOOD");
		return this; 
	}

	public ViewParticipantSourceOfIncomePage InquireWithPartIdandPrimary(String query,String Data)throws IOException, InterruptedException, ClassNotFoundException, SQLException
	{ 
		click(eleicnFilter,"Filter");
		String selectQuery = selectQuery(query, Data);
		clearAndType(eleddParticipantID,"Participant ID label", selectQuery);
        selectDropdownValue(eleddPrimary,"YES") ;
		click(eleicnSearch,"Search");
		doDoubleClick(eletdVerificationStatus);
		Thread.sleep(2000);
		verifyExactText(eletbPrimry, "YES");
        return this; 
	}






	public ViewParticipantSourceOfIncomePage verifyShowFiltersFields(String query,String Data) throws Exception
	{
		click(eleicnFilter,"Participant ID label");
		String selectQuery = selectQuery(query, Data);
		clearAndType(eleddParticipantID,"Participant ID label" , selectQuery);
		pressEnterKey(eleddParticipantID);
		verifyShowColumns(eleicnGridOptions,"Verification Status Code","Verification Status","Income Type Code","Income Type","Source of Income ID","Source of Income","Status Date","SOI Begin Date","SOI End Date");
		Thread.sleep(1000);
		click(eleicnGridOptions,"Grid Options");
		return this;

}
	//click both show filters and show columns
	
	public AddParticipantSourceofIncomePage clickAdd(String query,String ParticipantID) throws Exception
	{   click(eleicnFilter,"Filter");
	String selectQuery = selectQuery(query, ParticipantID);
		clearAndType(eleddParticipantID,"Participant ID label", selectQuery);
		pressEnterKey(eleddParticipantID);
		Thread.sleep(2000);
		click(eleicnAdd,"Add");
		return new AddParticipantSourceofIncomePage();


	}
	
	public EditParticipantSourceofIncomePage clickEdit(String ParticipantID) throws Exception
	{   click(eleicnFilter,"Filter");
		clearAndType(eleddParticipantID,"Participant ID label" , ParticipantID);
		pressEnterKey(eleddParticipantID);
		Thread.sleep(2000);
		verifyGridResult(eleGridResult, "VERIFICATION PENDING");
		doDoubleClick(eletdVerificationStatus);	
		return new EditParticipantSourceofIncomePage();
}
	@FindBy(xpath = "//tbody[@class='ui-table-tbody']/tr/td[2]") List<WebElement> eleTablecolumn;
	public EditParticipantSourceofIncomePage clicktable(String ParticipantID) throws Exception
	{   
		click(eleicnFilter,"Filter");
	clearAndType(eleddParticipantID,"Participant ID label" , ParticipantID);
	pressEnterKey(eleddParticipantID);
	Thread.sleep(2000);
	for (WebElement we : eleTablecolumn) {
		String text = we.getText();
		System.out.println(text);
		if (!(text.equals("CONFIRMED BAD"))) {
			doDoubleClick(we);
			System.out.println("clicked it");
			break;
		}
	}
	
	return new EditParticipantSourceofIncomePage() ;
	
	}

}
