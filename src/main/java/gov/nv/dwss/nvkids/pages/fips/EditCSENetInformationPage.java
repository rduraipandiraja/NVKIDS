package gov.nv.dwss.nvkids.pages.fips;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class EditCSENetInformationPage extends CommonLocators {

	public EditCSENetInformationPage(){
		PageFactory.initElements(driver, this);
	}


	/* Edit Screen function Name - BreadCrumb */
	@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='View CSENet IV-D Agency Agreements']") public WebElement eleViewBreadCrumbHeader;
	@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='Edit CSENet IV-D Agency Agreements']") public WebElement eleEditBreadCrumbHeader;

	@FindAll(
			{
				@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='View CSENet IV-D Agency Agreements']"),
				@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='Edit CSENet IV-D Agency Agreements']")
			}) public WebElement eleComHeaderPanel;

	/*  Edit Screen Detail section - Controls */
	@FindAll(value = { @FindBy(xpath="//lib-label-value/descendant::label") }) public List <WebElement> eleHeaderPanel; //labeltext - Field Naem,getTExt = value


	/* Edit section field set: */
	@FindBy(xpath="//legend[text()='CSENet Functions']") WebElement eleFieldSetHeader;
	@FindBy(xpath="//lib-label[@text='COL - Collections']") WebElement elelblCOLCollections;
	@FindBy(xpath="//lib-label[@text='COL - Collections']/following-sibling::*/descendant::label[text()='Yes ']") WebElement eleCOLYesrad;
	@FindBy(xpath="//lib-label[@text='COL - Collections']/following-sibling::*/descendant::label[text()='No ']") WebElement eleCOLNorad;

	@FindBy(xpath="//lib-label[@text='LO1 - Quick Locate']") WebElement elelblLO1QuickLocate;
	@FindBy(xpath="//lib-label[@text='LO1 - Quick Locate']/following-sibling::*/descendant::label[text()='Yes ']") WebElement eleLO1QuickLocateYesRad;
	@FindBy(xpath="//lib-label[@text='LO1 - Quick Locate']/following-sibling::*/descendant::label[text()='No ']") WebElement eleLO1QuickLocateNoRad;

	@FindBy(xpath="//lib-label[@text='CSI - Case Summary Information']") WebElement elelblCSI_CaseSummarInformation;
	@FindBy(xpath="//lib-label[@text='CSI - Case Summary Information']/following-sibling::*/descendant::label[text()='Yes ']") WebElement eleCSI_CaseSummarInformationYesRad;
	@FindBy(xpath="//lib-label[@text='CSI - Case Summary Information']/following-sibling::*/descendant::label[text()='No ']") WebElement eleCSI_CaseSummarInformationNoRad;


	@FindBy(xpath="//lib-label[@text='MSC - Managing State Cases']") WebElement elelblMSC_ManagingStateCases;
	@FindBy(xpath="//lib-label[@text='MSC - Managing State Cases']/following-sibling::*/descendant::label[text()='Yes ']") WebElement eleMSC_ManagingStateCasesYesRad;
	@FindBy(xpath="//lib-label[@text='MSC - Managing State Cases']/following-sibling::*/descendant::label[text()='No ']") WebElement eleMSC_ManagingStateCasesNoRad;

	@FindBy(xpath="//lib-label[@text='EST - Establishment']") WebElement elelblEST_Establishment;
	@FindBy(xpath="//lib-label[@text='EST - Establishment']/following-sibling::*/descendant::label[text()='Yes ']") WebElement eleEST_EstablishmentYesRad;
	@FindBy(xpath="//lib-label[@text='EST - Establishment']/following-sibling::*/descendant::label[text()='No ']") WebElement eleEST_EstablishmentNoRad;

	@FindBy(xpath="//lib-label[@text='PAT - Paternity']") WebElement elelblPAT_Paternity;
	@FindBy(xpath="//lib-label[@text='PAT - Paternity']/following-sibling::*/descendant::label[text()='Yes ']") WebElement elePAT_PaternityYesRad;
	@FindBy(xpath="//lib-label[@text='PAT - Paternity']/following-sibling::*/descendant::label[text()='No ']") WebElement elePAT_PaternityNoRad;


	@FindBy(xpath="//lib-label[@text='ENF - Enforcement']") WebElement elelblENF_Enforcement;
	@FindBy(xpath="//lib-label[@text='ENF - Enforcement']/following-sibling::*/descendant::label[text()='Yes ']") WebElement eleENF_EnforcementYesRad;
	@FindBy(xpath="//lib-label[@text='ENF - Enforcement']/following-sibling::*/descendant::label[text()='No ']") WebElement eleENF_EnforcementNoRad;



	/*Edit Screen Controls */

	@FindBy(xpath = "//span[text()='Refresh']") public WebElement eleRefresh;
	@FindBy(xpath = "//span[text()='Save']") public WebElement eleSave;
	@FindBy(xpath = "//lib-button/descendant::button/span[contains(@class,'close')]") public WebElement eleCloseIcon;
	@FindBy(xpath="//div[contains(@class,'errorContainer')]/div/span") public WebElement eleEditCSENetStatusBar;
	@FindBy(xpath="//div[contains(@class,'errorContainer')]/span") public WebElement eleEditCSENetStatusBarDone;



	
	
	
	
	public EditCSENetInformationPage verifyEditProcessDetailsAppearance() throws Exception
	{
        verifyFieldSetLabels(eleHeaderPanel, "FIPS IV-D Agency Code");
		verifyExactText(eleFieldSetHeader, "CSENet Functions");
		verifyDisplayed(eleSave,"Save Icon");
		verifyDisplayed(eleRefresh,"Refresh Icon");
		verifyDisplayed(eleCloseIcon, "Close Icon");

		verifyExactText(elelblCOLCollections,"COL - Collections");
		verifyDisplayed(eleCOLYesrad,"'Collections - Yes' Radio button");
		verifyDisplayed(eleCOLNorad,"'Collections - No' Radio button");

		verifyExactText(elelblLO1QuickLocate,"LO1 - Quick Locate");
		verifyDisplayed(eleLO1QuickLocateYesRad,"'Quick Locate - Yes' Radio button");
		verifyDisplayed(eleLO1QuickLocateNoRad,"'Quick Locate - No' Radio button");

		verifyExactText(elelblCSI_CaseSummarInformation,"CSI - Case Summary Information");
		verifyDisplayed(eleCSI_CaseSummarInformationYesRad,"'Case Summary Information - Yes' Radio button");
		verifyDisplayed(eleCSI_CaseSummarInformationNoRad,"'Case Summary Information - No' Radio button");


		verifyExactText(elelblMSC_ManagingStateCases,"MSC - Managing State Cases");
		verifyDisplayed(eleMSC_ManagingStateCasesYesRad,"'Managing State Cases- Yes' Radio button");
		verifyDisplayed(eleMSC_ManagingStateCasesNoRad,"'Managing State Cases- No' Radio button");

		verifyExactText(elelblEST_Establishment,"EST - Establishment");
		verifyDisplayed(eleEST_EstablishmentYesRad,"'Establishment - Yes' Radio button");
		verifyDisplayed(eleEST_EstablishmentNoRad,"'Establishment - No' Radio button");


		verifyExactText(elelblPAT_Paternity,"PAT - Paternity");
		verifyDisplayed(elePAT_PaternityYesRad,"'Paternity - Yes' Radio button");
		verifyDisplayed(elePAT_PaternityNoRad,"'Paternity - No' Radio button");

		verifyExactText(elelblENF_Enforcement,"ENF - Enforcement");
		verifyDisplayed(eleENF_EnforcementYesRad,"'Enforcement - Yes' Radio button");
		verifyDisplayed(eleENF_EnforcementNoRad,"'Enforcement - Yes' Radio button");
       return this;

	}

	

	public EditCSENetInformationPage verifyUpdateWithChanges() throws Exception
	{   


		if(eleCOLYesrad.getAttribute("class").contains("ui-label-active") == true){
			click(eleCOLNorad,"'Collection - No' Radio button");
		}
		else{
			click(eleCOLYesrad,"'Collection - Yes' Radio button");
		}

		click(eleicnSave,"Save Icon");
		verifyExactText(eleErrStatusBar, "SAVED SUCCESSFULLY");
		return this;
	}

	

}
