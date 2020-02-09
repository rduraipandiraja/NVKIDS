package gov.nv.dwss.nvkids.pages.inex;

import java.sql.SQLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class NVQuarterlyWagesPage extends CommonLocators
{
	public NVQuarterlyWagesPage() {
		PageFactory.initElements(driver,this);
	}
	
	//Screen Function
	@FindBy(xpath="//p-breadcrumb/descendant::a/span[text()='NV Quarterly Wages']") public WebElement elebcNVQuarterlyWages;
	
	//Filter Section
	@FindBy(xpath="//label[text()='Participant ID']") public WebElement elelblParticipantid;
	@FindBy(xpath="//label[text()='Participant ID']/following::input[contains(@class,'ui-inputtext')]") public WebElement eletxtParticipantid;
	@FindBy(xpath="//span[text()='ui-btn']/preceding-sibling::span[contains(@class,'fa-search')]") public WebElement eleicnlovParticipantid;
	
	@FindBy(xpath="//label[text()=' DWSS Case ID ']") public WebElement elelblDwssCaseID;
	@FindBy(xpath="//label[text()=' Employer DBA Name ']") public WebElement elelblEmployerDBAName;
	@FindBy(xpath="//label[text()=' Employer Mailing Address ']") public WebElement elelblEmployerMailAddress;
	@FindBy(xpath="//label[text()=' DWSS Participant ID ']") public WebElement elelblDwssParticipantId;
	@FindBy(xpath="//label[text()=' Employer Business Contact Name ']") public WebElement elelblEmpBusContactName ;
	@FindBy(xpath="//label[text()=' Employer Foreign Mailing Address ']") public WebElement elelblEmpForeighMailAddress;
	@FindBy(xpath="//label[text()=' File Generation Date ']") public WebElement elelblFileGenrationDate;
	@FindBy(xpath="//label[text()=' Employer Phone Number ']") public WebElement elelblEmpPhNumber;
	@FindBy(xpath="//label[text()=' Employer Operations Address ']") public WebElement elelblEmpOperationAddress;
	@FindBy(xpath="//label[text()=' File Generation Time ']") public WebElement elelblFileGenrationTime;
	@FindBy(xpath="//label[text()=' Employer Email Address ']") public WebElement elelblEmpEmailAddress;
	//@FindBy(xpath="") public WebElement elelbl;
	
	@FindBy(xpath="//span[text()='Participant Source of Income']") public WebElement elelinkpsoi;
	
	
	public NVQuarterlyWagesPage verifyNVQWagesField()
	{
		verifyExactText(elebcNVQuarterlyWages,"NV Quarterly Wages");
		verifyGridHeaders(elelblGridHeaders," Employer Name "," FEIN "," Employment Start Date "," Employment End Date "," Reporting Quarter "," Quarterly Wages "," Employee’s Quarterly Tip Amount ");
		scrollToElementPosition(elelinkpsoi);
		verifyAssociatedScreens(eleAssociatedScreenList,"Note Processor","Guideline Calculation","Participant Source of Income");
		return this;
	}
	public NVQuarterlyWagesPage InquireFilterFields() throws Exception
	{
		click(eleicnFilter,"Filter");
		verifyDisplayed(eleicnClear,"Clear");
		verifyDisplayed(eleicnSearch,"Search");
		verifyDisplayed(elelblParticipantid,"Participant ID");
		return this;
	}
	
	public NVQuarterlyWagesPage verifyNVQWGrid(String query,String nvqparticipantid) throws InterruptedException, ClassNotFoundException, SQLException
	{
		click(eleicnFilter,"Filter");
		String NVQParticipantID = selectQuery(query,nvqparticipantid);
		clearAndType(eletxtParticipantid,"Participant ID",NVQParticipantID);
		click(eleicnSearch,"Search");
		Thread.sleep(2000);
		verifyGridRecordsPresent(eleGridRecord);
		return this;
	}
	
	public NVQuarterlyWagesPage verifyShowColumn()
	{
		verifyShowColumns(eleicnGridOptions,"Employer ID","Employer Name","FEIN","Employment Start Date","Employment End Date","Reporting Quarter","Quarterly Wages","Employee’s Quarterly Tip Amount");
		return this;
	}
	
	public NVQuarterlyWagesPage InquireExpandNVQWGrid(String query,String nvqparticipantid) throws Exception
	{
		click(eleicnFilter,"Filter");
		String NVQParticipantID = selectQuery(query,nvqparticipantid);
		clearAndType(eletxtParticipantid,"Participant ID",NVQParticipantID);
		click(eleicnSearch,"Search");
		click(eleicnOpenAccordion,"Expand Accordian");
		verifyDisplayed(elelblDwssCaseID,"DWSS Casse ID");
		verifyDisplayed(elelblEmployerDBAName,"Employer DBA Name");
		verifyDisplayed(elelblEmployerMailAddress,"Employer Mail Address");
		verifyDisplayed(elelblDwssParticipantId,"DWSS Participant ID");
		verifyDisplayed(elelblEmpBusContactName,"Employer Business Contact Name");
		verifyDisplayed(elelblEmpForeighMailAddress,"Employer Foreigh Mail Address");
		verifyDisplayed(elelblFileGenrationDate,"File Genration Date");
		verifyDisplayed(elelblEmpPhNumber,"Employer Phone Number");
		verifyDisplayed(elelblEmpOperationAddress,"Employer Operation Address");
		verifyDisplayed(elelblFileGenrationTime,"File Genration Time");
		verifyDisplayed(elelblEmpEmailAddress,"Employer Mail Address");
		return this;
	}
	
	
}
