package gov.nv.dwss.nvkids.pages.demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class PersonalInformationPage extends CommonLocators 
{
	public PersonalInformationPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//label[@for='personId']") WebElement elelblParticipantID;
	@FindBy(xpath = "//lib-input[@class='allignCenter ng-pristine ng-valid ng-touched']//div[@class='paddingBottom0']//div//input[@type='text']") WebElement eletxtParticipantID;
	@FindBy(xpath = "//a[contains(@id,'ui-accordiontab-')]/span[contains(text(),'Participant Demographics')]") WebElement ParticipantDemographicsTab;
	@FindBy(xpath = "//span[@icon='pi pi-plus']") WebElement UploadBtn;
	
	
	CommonLocators cloc = new CommonLocators();
	
	public PersonalInformationPage Upload() throws Exception
	{

		click(cloc.eleicnFilter,"Filter");
		clearAndType(eletxtParticipantID, "Participant ID", "1000000001");
		click(eleicnSearch,"Search");
		click(eleicnEdit,"Edit");
		click(UploadBtn,"Upload");
		
		return this;
		
	}
	

}
