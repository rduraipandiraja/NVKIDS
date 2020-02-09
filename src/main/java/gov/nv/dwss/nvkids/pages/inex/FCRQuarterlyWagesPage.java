package gov.nv.dwss.nvkids.pages.inex;

import java.sql.SQLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class FCRQuarterlyWagesPage extends CommonLocators
{
  public FCRQuarterlyWagesPage()
  {
	  PageFactory.initElements(driver,this);
  }
  	//Screen Function
	@FindBy(xpath="//p-breadcrumb/descendant::a/span[text()='FCR Quarterly Wages']") public WebElement elebcFCRQuarterlyWages;
	
	//Filter Section
	@FindBy(xpath="//label[text()='Participant ID']") public WebElement elelblParticipantid;
	@FindBy(xpath="//label[text()='Participant ID']/following::input[contains(@class,'ui-inputtext')]") public WebElement eletxtParticipantid;
	@FindBy(xpath="//span[text()='ui-btn']/preceding-sibling::span[contains(@class,'fa-search')]") public WebElement eleicnlovParticipantid;
	
	@FindBy(xpath="//span[text()='Participant Source of Income']") public WebElement elelinkpsoi;
	
	
  
	public FCRQuarterlyWagesPage verifyFCRQWagesField()
	{
		verifyExactText(elebcFCRQuarterlyWages,"FCR Quarterly Wages");
		verifyGridHeaders(elelblGridHeaders," Reporting State "," Address Type Description "," Wage Amount "," FEIN "," SSN Match Description "," Reporting Quarter "," Reporting Agency "," DoD Agency Status Description "," SEIN "," Participant Type ");
		scrollToElementPosition(elelinkpsoi);
		verifyAssociatedScreens(eleAssociatedScreenList,"Note Processor","Guideline Calculation","Participant Source of Income");
		return this;
	}
	
	public FCRQuarterlyWagesPage InquireFilterFields() throws Exception
	{
		click(eleicnFilter,"Filter");
		verifyDisplayed(eleicnClear,"Clear");
		verifyDisplayed(eleicnSearch,"Search");
		verifyDisplayed(elelblParticipantid,"Participant ID");
		return this;
	}
	
	public FCRQuarterlyWagesPage verifyShowColumn()
	{
		verifyShowColumns(eleicnGridOptions,"Reporting State Code","Reporting State","Address Type Code","Address Type Description","Wage Amount","FEIN","SSN Match Code","SSN Match Description","Reporting Quarter","Reporting Agency ID","Reporting Agency","DoD Agency Status Code","DoD Agency Status Description","SEIN","Participant Type Code","Participant Type");
		return this;
	}
	
	public FCRQuarterlyWagesPage verifyFCRQWGrid(String query,String fcrparticipantid) throws ClassNotFoundException, SQLException
	{
		click(eleicnFilter,"Filter");
		String FCRParticipantID = selectQuery(query,fcrparticipantid);
		clearAndType(eletxtParticipantid,"Participant ID",FCRParticipantID);
		click(eleicnSearch,"Search");
		verifyGridRecordsPresent(eleGridRecord);
		return this;
	}
}
