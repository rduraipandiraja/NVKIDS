package gov.nv.dwss.nvkids.pages.inex;

import java.sql.SQLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class ViewOtherIncomeInformationPage extends CommonLocators
{
	public ViewOtherIncomeInformationPage() {
		PageFactory.initElements(driver,this);
	}
	
	//Screen Function
	@FindBy(xpath="//p-breadcrumb/descendant::a/span[text()='View Other Income Information']") public WebElement elebcViewOtherIncomeInformation;
	
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
	@FindBy(xpath="//span[text()='Expense Information']/preceding-sibling::span[contains(@class,'ui-menuitem-icon')]") public WebElement eleicnnavigatetoExpense;
	@FindBy(xpath="//span[text()='NV Quarterly Wages']/preceding-sibling::span[contains(@class,'ui-menuitem-icon')]") public WebElement eleicnnavigatetoNCQW;
	@FindBy(xpath="//span[text()='FCR Quarterly Wages']/preceding-sibling::span[contains(@class,'ui-menuitem-icon')]") public WebElement eleicnnavigatetoFCRQW;
	
	
	public ViewExpenseInformationPage navigateToViewExpenseInformationPage()
	{
		click(eleicnnavigatetoExpense,"Menu Navigation");
		return new ViewExpenseInformationPage();
	}
	
	public NVQuarterlyWagesPage navigateToNVQuarterlyWagesPage()
	{
		click(eleicnnavigatetoNCQW,"Menu Navigation");
		return new NVQuarterlyWagesPage();
	}
	public FCRQuarterlyWagesPage navigateToFCRQuarterlyWagesPage()
	{
		click(eleicnnavigatetoFCRQW,"Menu Navigation");
		return new FCRQuarterlyWagesPage();
	}
	
	public EditOtherIncomeInformationPage navigateToEditOtherIncomeInformationPage(String query,String participantid) throws ClassNotFoundException, SQLException
	{
		click(eleicnFilter,"Filter");
		String ParticipantID = selectQuery(query,participantid);
		clearAndType(eletxtParticipantid,"Participant ID",ParticipantID);
		click(eleicnSearch,"Search");
		doDoubleClick(eleclickdata);
		return new EditOtherIncomeInformationPage();
	}
	
	public AddOtherIncomeInformationPage navigateToAddOtherIncomeInformationPage(String query,String norecparticipantid) throws ClassNotFoundException, SQLException
	{
		click(eleicnFilter,"Filter");
		String NoRecParticipantID = selectQuery(query,norecparticipantid);
		clearAndType(eletxtParticipantid,"Participant ID",NoRecParticipantID);
		click(eleicnSearch,"Search");
		click(eleicnAdd,"Add");
		return new AddOtherIncomeInformationPage();
	}
	
	public ViewOtherIncomeInformationPage InquireScreen() throws Exception 
	{
		verifyExactText(elebcViewOtherIncomeInformation,"View Other Income Information");
		verifyDisplayed(eleicnAdd,"Add");
		verifyGridHeaders(elelblGridHeaders," Other Income Type "," Amount "," Frequency "," Source "," Begin Date "," End Date ");
		scrollToElementPosition(elelinkpsoi);
		verifyAssociatedScreens(eleAssociatedScreenList,"Note Processor","Guideline Calculation","Participant Source of Income");
		return this;
	}
	
	public ViewOtherIncomeInformationPage InquireFilter() throws Exception
	{
		click(eleicnFilter,"Filter");
		verifyDisplayed(eleicnClear,"Clear");
		verifyDisplayed(eleicnSearch,"Search");
		verifyDisplayed(elelblParticipantid,"Participant ID");
		return this;
	}
	
	public ViewOtherIncomeInformationPage InquireGridData(String query,String participantid) throws ClassNotFoundException, SQLException
	{
		click(eleicnFilter,"Filter");
		String ParticipantID = selectQuery(query,participantid);
		clearAndType(eletxtParticipantid,"Participant ID",ParticipantID);
		click(eleicnSearch,"Search");
		verifyGridRecordsPresent(eleGridRecord);
		return this;
		
	}
	public ViewOtherIncomeInformationPage verifyShowColumn() throws Exception
	{
		verifyShowColumns(eleicnGridOptions,"Other Income Type Code","Other Income Type","Amount","Frequency Code","Frequency","Source Code","Source","Begin Date","End Date");
		return this;
	}
	
}
