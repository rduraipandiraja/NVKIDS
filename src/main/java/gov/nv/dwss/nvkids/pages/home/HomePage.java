package gov.nv.dwss.nvkids.pages.home;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.nv.dwss.nvkids.pages.ahis.ViewParticipantAddressPage;
import gov.nv.dwss.nvkids.pages.bstl.BatchErrorsPage;
import gov.nv.dwss.nvkids.pages.bstl.BatchStatusLogsPage;
import gov.nv.dwss.nvkids.pages.bstl.PrintQueueErrorsPage;
import gov.nv.dwss.nvkids.pages.cpro.ViewCaseInitiationProcessesPage;
import gov.nv.dwss.nvkids.pages.demo.PersonalInformationPage;
import gov.nv.dwss.nvkids.pages.dref.ViewDocumentAttributesPage;
import gov.nv.dwss.nvkids.pages.fips.ViewFIPSInformationPage;
import gov.nv.dwss.nvkids.pages.inex.ViewOtherIncomeInformationPage;
import gov.nv.dwss.nvkids.pages.insr.ViewParticipantInsurancePage;
import gov.nv.dwss.nvkids.pages.parm.ViewManageBatchParametersPage;
import gov.nv.dwss.nvkids.pages.pdrf.ViewPendingReferralsPage;
import gov.nv.dwss.nvkids.pages.plic.ViewParticipantLicenseInformationPage;
import gov.nv.dwss.nvkids.pages.proc.MaintainProcessDetails;
import gov.nv.dwss.nvkids.pages.psoi.ViewParticipantSourceOfIncomePage;
import gov.nv.dwss.nvkids.pages.ptre.ViewProcessDetails;
import gov.nv.dwss.nvkids.pages.refm.ViewReferenceCodesPage;
import gov.nv.dwss.nvkids.pages.rstr.ViewHighProfileRestrictedCasesPage;
import gov.nv.dwss.nvkids.pages.smsg.ViewSystemMessagesPage;
import gov.nv.dwss.nvkids.pages.soin.ViewSourceofIncomeInformationpage;
import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;

public class HomePage extends SeleniumBase{


	public HomePage() 
	{
		PageFactory.initElements(driver, this);
	}


	// screen & screen function name links

	@FindBy(xpath = "//span[@title='Quick Navigation']") WebElement eleQuickNavigation;
	//@FindBy(xpath = "(//input[@type='text'])[2]") WebElement eletxtQuickNavigationText;
	@FindBy(id="screenName") WebElement eletxtQuickNavigationText;
	@FindBy(xpath = "//a[@title='DREF - Document Reference']") WebElement elelinkDREF;
	@FindBy(xpath = "//a[@title='PARM - Manage Batch Parameters']") WebElement elelinkPARM;
	@FindBy(xpath = "(//a[@title='RSTR - Restricted Case / Participant'])[1]") WebElement elelinkRSTR;
	@FindBy(xpath = "(//span[text()='High Profile Restricted Cases'])[1]") WebElement elelinkHighProfileRSTR;
	@FindBy(xpath = "//span[text()='Reference Master']") WebElement elelinkREFM;
	@FindBy(xpath = "(//span[text()='Batch Status Logs and Errors'])[1]") WebElement elelinkBSTL;
	
	
	@FindBy(xpath="//span[text()='Process and Task Reference']") WebElement elelinkPTRE;
	@FindBy(xpath="//span[text()='Process Details']")  WebElement elelinkProcessDetails;
	
	@FindBy(xpath="//span[text()='Federal Information Processing Standards']") WebElement elelinkFIPS;
	@FindBy(xpath="//span[text()='FIPS Code Information']")  WebElement elelinkFIPSCodeInformation;
	
	@FindBy(xpath="(//a[@title='SMSG - System Messages'])[1]") WebElement elelinkSMSG;
	
	@FindBy(xpath="//span[contains(@class,'fa-cogs')]/parent::a") public WebElement elelinkTools;
	@FindBy(xpath="//a[contains(@class,'ui-panelmenu-header-link')]/following::span[text()='Maintain Process']") public WebElement elelinkMaintainProcess;
	
	

	public  BatchStatusLogsPage quickNavigation_BSTL() throws IOException, InterruptedException
	{

		click(eleQuickNavigation, "Quick Navigation");
		clearAndType(eletxtQuickNavigationText, "Quick Navigation", "BSTL - Batch Status Logs and Errors");
		pressEnterKey(eletxtQuickNavigationText);
		Thread.sleep(3000);
		return  new BatchStatusLogsPage();

	}
	
	public ViewReferenceCodesPage quickNavigation_REFM() throws IOException, InterruptedException
	{
		click(eleQuickNavigation, "Quick Navigation");
		clearAndType(eletxtQuickNavigationText, "Quick Navigation", "REFM");
		pressEnterKey(eletxtQuickNavigationText);
		Thread.sleep(3000);
		return  new ViewReferenceCodesPage();
	}
	
	public ViewProcessDetails quickNavigation_PTRE() throws IOException, InterruptedException
	{
		click(eleQuickNavigation, "Quick Navigation");
		clearAndType(eletxtQuickNavigationText, "Quick Navigation", "PTRE");
		pressEnterKey(eletxtQuickNavigationText);
		Thread.sleep(3000);
		return  new ViewProcessDetails();
	}

	public ViewHighProfileRestrictedCasesPage quickNavigation_RSTR() throws IOException, InterruptedException
	{
		click(eleQuickNavigation, "Quick Navigation");
		clearAndType(eletxtQuickNavigationText, "Quick Navigation", "RSTR");
		pressEnterKey(eletxtQuickNavigationText);
		Thread.sleep(4000);
		return  new ViewHighProfileRestrictedCasesPage();
	}
	
	public PersonalInformationPage quickNavigation_DEMO() throws IOException, InterruptedException
	{
		click(eleQuickNavigation, "Quick Navigation");
		clearAndType(eletxtQuickNavigationText, "Quick Navigation", "DEMO");
		pressEnterKey(eletxtQuickNavigationText);
		Thread.sleep(3000);
		return  new PersonalInformationPage();
	}

	public ViewManageBatchParametersPage quickNavigation_PARM() throws IOException, InterruptedException
	{
		click(eleQuickNavigation, "Quick Navigation");
		clearAndType(eletxtQuickNavigationText, "Quick Navigation", "PARM");
		pressEnterKey(eletxtQuickNavigationText);
		Thread.sleep(2000);
		return  new ViewManageBatchParametersPage();
	}
	
	
	public ViewDocumentAttributesPage quickNavigation_DREF() throws IOException, InterruptedException
	{
		click(eleQuickNavigation, "Quick Navigation");
		clearAndType(eletxtQuickNavigationText, "Quick Navigation", "DREF");
		pressEnterKey(eletxtQuickNavigationText);
		Thread.sleep(5000);
		return  new ViewDocumentAttributesPage ();
	}

	
	public ViewFIPSInformationPage quickNavigation_FIPS() throws IOException, InterruptedException
	{
		click(eleQuickNavigation, "Quick Navigation");
		clearAndType(eletxtQuickNavigationText, "Quick Navigation", "FIPS");
		pressEnterKey(eletxtQuickNavigationText);
		Thread.sleep(3000);
		return  new ViewFIPSInformationPage ();
	}
	

	public MaintainProcessDetails quickNavigation_PROC() throws IOException, InterruptedException
	{
		click(eleQuickNavigation, "Quick Navigation");
		clearAndType(eletxtQuickNavigationText, "Quick Navigation", "PROC");
		pressEnterKey(eletxtQuickNavigationText);
		Thread.sleep(3000);
		return  new MaintainProcessDetails ();
	}

	
	public ViewSystemMessagesPage quickNavigation_SMSG() throws IOException, InterruptedException
	{
		click(eleQuickNavigation, "Quick Navigation");
		clearAndType(eletxtQuickNavigationText, "Quick Navigation", "SMSG");
		pressEnterKey(eletxtQuickNavigationText);
		Thread.sleep(3000);
		return  new ViewSystemMessagesPage ();
	}

	
	public  ViewParticipantLicenseInformationPage quickNavigation_PLIC() throws IOException, InterruptedException
	{
		click(eleQuickNavigation, "Quick Navigation");
		clearAndType(eletxtQuickNavigationText, "Quick Navigation", "PLIC ");
		pressEnterKey(eletxtQuickNavigationText);
		Thread.sleep(3000);
		return  new ViewParticipantLicenseInformationPage();
	}

	public   ViewParticipantSourceOfIncomePage quickNavigation_PSOI() throws IOException, InterruptedException
	{
		click(eleQuickNavigation, "Quick Navigation");
		clearAndType(eletxtQuickNavigationText, "Quick Navigation", "PSOI");
		pressEnterKey(eletxtQuickNavigationText);
		Thread.sleep(3000);
		return  new ViewParticipantSourceOfIncomePage();
	}
	
	public ViewSourceofIncomeInformationpage quickNavigation_SOIN() throws IOException, InterruptedException
	{
		click(eleQuickNavigation, "Quick Navigation");
		clearAndType(eletxtQuickNavigationText, "Quick Navigation", "SOIN - Source of Income");
		pressEnterKey(eletxtQuickNavigationText);
		Thread.sleep(3000);
		return  new ViewSourceofIncomeInformationpage();
	}
	
	public  ViewPendingReferralsPage quickNavigation_PDRF() throws IOException, InterruptedException
	{
		click(eleQuickNavigation, "Quick Navigation");
		clearAndType(eletxtQuickNavigationText, "Quick Navigation", "PDRF");
		pressEnterKey(eletxtQuickNavigationText);
		Thread.sleep(3000);
		return  new ViewPendingReferralsPage();
	}
	
	public  ViewParticipantAddressPage quickNavigation_AHIS() throws IOException, InterruptedException
	{
		click(eleQuickNavigation, "Quick Navigation");
		clearAndType(eletxtQuickNavigationText, "Quick Navigation", "AHIS");
		pressEnterKey(eletxtQuickNavigationText);
		Thread.sleep(3000);
		return  new ViewParticipantAddressPage();
	}
	

	public  ViewOtherIncomeInformationPage quickNavigation_INEX() throws IOException, InterruptedException
	{
		click(eleQuickNavigation, "Quick Navigation");
		clearAndType(eletxtQuickNavigationText, "Quick Navigation", "INEX");
		pressEnterKey(eletxtQuickNavigationText);
		Thread.sleep(3000);
		return  new ViewOtherIncomeInformationPage();
	}
	
	public  ViewCaseInitiationProcessesPage quickNavigation_CPRO() throws IOException, InterruptedException
	{
		click(eleQuickNavigation, "Quick Navigation");
		clearAndType(eletxtQuickNavigationText, "Quick Navigation", "CPRO");
		pressEnterKey(eletxtQuickNavigationText);
		Thread.sleep(3000);
		return  new ViewCaseInitiationProcessesPage();
	}
	
	public  ViewParticipantInsurancePage quickNavigation_INSR() throws IOException, InterruptedException
	{
		click(eleQuickNavigation, "Quick Navigation");
		clearAndType(eletxtQuickNavigationText, "Quick Navigation", "INSR");
		pressEnterKey(eletxtQuickNavigationText);
		Thread.sleep(3000);
		return  new ViewParticipantInsurancePage();
	}
}


