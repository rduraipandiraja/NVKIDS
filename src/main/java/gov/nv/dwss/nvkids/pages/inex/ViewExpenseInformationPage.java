package gov.nv.dwss.nvkids.pages.inex;

import java.sql.SQLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class ViewExpenseInformationPage extends CommonLocators
{
	public ViewExpenseInformationPage() {
		PageFactory.initElements(driver,this);
	}
	
	//Screen Function
	@FindBy(xpath="//p-breadcrumb/descendant::a/span[text()='View Expense Information']") public WebElement elebcViewExpenseInformation;
	
	//Filter Section
	@FindBy(xpath="//label[text()='Participant ID']") public WebElement elelblParticipantid;
	@FindBy(xpath="//label[text()='Participant ID']/following::input[contains(@class,'ui-inputtext')]") public WebElement eletxtParticipantid;
	@FindBy(xpath="//span[text()='ui-btn']/preceding-sibling::span[contains(@class,'fa-search')]") public WebElement eleicnlovParticipantid;
	
	//Grid Section
	@FindBy(xpath="//th//label[@for='incomeTypeCode']/following-sibling::p-dropdown/descendant::label") public WebElement eleddIncomeTypeCode;
	@FindBy(xpath="//th//label[@for='incomeTypeDesc']/following-sibling::p-dropdown/descendant::label") public WebElement eleddIncomeType;
	@FindBy(xpath="//input[@id='incomeAmt']") public WebElement eletxtAmount;
	@FindBy(xpath="//th//label[@for='frequencyCode']/following-sibling::p-dropdown/descendant::label") public WebElement eleddFrequencyCode;
	@FindBy(xpath="//th//label[@for='frequencyDesc']/following-sibling::p-dropdown/descendant::label") public WebElement eleddFrequency;
	@FindBy(xpath="//th//label[@for='sourceIncomeCode']/following-sibling::p-dropdown/descendant::label") public WebElement eleddSourceCode;
	@FindBy(xpath="//th//label[@for='sourceIncomeDesc']/following-sibling::p-dropdown/descendant::label") public WebElement eleddsource;
	@FindBy(xpath="//input[@id='beginDate']") public WebElement eleicncalbeginDate;
	@FindBy(xpath="//input[@id='beginDate']/following-sibling::button") public WebElement eleicncalvalbeginDate;
	@FindBy(xpath="//input[@id='endDate']") public WebElement eleicncalEndDate;
	@FindBy(xpath="//input[@id='endDate']/following-sibling::button") public WebElement eleicncalvalEndDate;
	@FindBy(xpath="//span[text()='Participant Source of Income']") public WebElement elelinkpsoi;
	@FindBy(xpath="//tbody/tr[1]/td[2]/span") WebElement eleclickdata;
	
	
	
	
	
	public EditExpenseInformationPage navigateToEditExpenseInformationPage(String query,String expparticipantid) throws InterruptedException, ClassNotFoundException, SQLException
	{
		click(eleicnFilter,"Filter");
		String EditParticipantID = selectQuery(query,expparticipantid);
		clearAndType(eletxtParticipantid,"Participant ID",EditParticipantID);
		click(eleicnSearch,"Search");
		doDoubleClick(eleclickdata);
		Thread.sleep(2000);
		return new EditExpenseInformationPage();
	}
	
	public AddExpenseInformationPage navigateToAddExpenseInformationPage(String query,String addparticipantid) throws ClassNotFoundException, SQLException
	{
		click(eleicnFilter,"Filter");
		String AddParticipantID = selectQuery(query,addparticipantid);
		clearAndType(eletxtParticipantid,"Participant ID",AddParticipantID);
		click(eleicnSearch,"Search");
		click(eleicnAdd,"Add");
		return new AddExpenseInformationPage();
	}
	
	public ViewExpenseInformationPage InquireFieldAppearence() throws Exception 
	{
		verifyExactText(elebcViewExpenseInformation,"View Expense Information");
		verifyDisplayed(eleicnAdd,"Add");
		verifyGridHeaders(elelblGridHeaders," Expense Type "," Amount "," Frequency "," Source "," Begin Date "," End Date ");
		scrollToElementPosition(elelinkpsoi);
		verifyAssociatedScreens(eleAssociatedScreenList,"Note Processor","Guideline Calculation","Participant Source of Income");
		return this;
	}
	
	public ViewExpenseInformationPage InquireFilterIcon() throws Exception
	{
		click(eleicnFilter,"Filter");
		verifyDisplayed(eleicnClear,"Clear");
		verifyDisplayed(eleicnSearch,"Search");
		verifyDisplayed(elelblParticipantid,"Participant ID");
		return this;
	}
	
	public ViewExpenseInformationPage verifyGridresult(String query,String expparticipantid) throws ClassNotFoundException, SQLException
	{
		click(eleicnFilter,"Filter");
		String ExpParticipantID = selectQuery(query,expparticipantid);
		clearAndType(eletxtParticipantid,"Participant ID",ExpParticipantID);
		click(eleicnSearch,"Search");
		verifyGridRecordsPresent(eleGridRecord);
		return this;
	}
	
	public ViewExpenseInformationPage verifyShowColumn()
	{
		verifyShowColumns(eleicnGridOptions,"Expense Type Code","Expense Type","Amount","Frequency Code","Frequency","Source Code","Source","Begin Date","End Date");
		return this;
	}
	
}
