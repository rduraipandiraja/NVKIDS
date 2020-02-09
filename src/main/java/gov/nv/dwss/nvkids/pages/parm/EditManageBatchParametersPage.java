package gov.nv.dwss.nvkids.pages.parm;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.nv.dwss.nvkids.pages.rstr.EditFamilialRestrictedCasesPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class EditManageBatchParametersPage extends CommonLocators 

{
	public EditManageBatchParametersPage() 
	{
		PageFactory.initElements(driver, this);
	}

	//Screen Function Name
    @FindBy(xpath = "//span[text()='Edit Manage Batch Parameters']") WebElement elesfEditManageBatchParameters;


	//Update Screen function
	@FindBy(xpath="//input[@id='commitFreqNumb']") WebElement eletxtCommitFrequency;
	@FindBy(xpath="//input[@id='exceptionThresholdNumb']") WebElement eletxtExceptionThreshold;
	@FindBy(xpath="//input[@id='serverPathName']") WebElement eletxtAgencyFilePath;
	@FindBy(xpath="//input[@id='fileName']") WebElement eletxtFileName;
	
	@FindBy(xpath="//label[text()='Commit Frequency']") WebElement elelblCommitFrequency;
	@FindBy(xpath="//label[text()='Exception Threshold']") WebElement elelblExceptionThreshold;
	@FindBy(xpath="//label[text()='Agency File Path']") WebElement elelblAgencyFilePath;
	@FindBy(xpath="//label[text()='File Name']") WebElement elelblFileName;
	
	@FindBy(xpath = "//div[@class='p-col-12 HeaderHighlight']/div/lib-label-value/div/label") List <WebElement> eleEditInforPanel;
	

	public EditManageBatchParametersPage verifyFields() throws Exception
	{
		Thread.sleep(2000);
		
		verifyExactText(elesfEditManageBatchParameters, "Edit Manage Batch Parameters");
	    verifyFieldSetLabels(eleEditInforPanel," Job ID "," Job Description "," Job Name "," Run Frequency ", " Run Date "," File I/O Type");
	    
		verifyDisplayed(elelblCommitFrequency, "Commit Frequency");
		verifyDisplayed(elelblExceptionThreshold, "Exception Threshold");
		verifyDisplayed(elelblAgencyFilePath, "Agency File Path");
		verifyDisplayed(elelblFileName, "File Name");
		
		verifyDisplayed(eleicnRefresh,"Refresh");
		verifyDisplayed(eleicnSave,"Save");
		verifyDisplayed(eleicnClose,"Close");
		
		return this;
	}

	public EditManageBatchParametersPage editParamterData() throws Exception
	{
		
		clearAndType(eletxtExceptionThreshold, "Exception Threshold", getRandomNumbers(2));
		clearAndType(eletxtCommitFrequency, "Commit Frequency", getRandomNumbers(2));
		clearAndType(eletxtAgencyFilePath, "Agency File Path", getRandomAlphaNumericChar(10));
		clearAndType(eletxtFileName,"FileName",getRandomAlphaChar(10));
        click(eleicnSave,"Save");
		
		verifyExactText(eleErrStatusBar, "SAVED SUCCESSFULLY");
		
		return this;
		
	}
	


}
