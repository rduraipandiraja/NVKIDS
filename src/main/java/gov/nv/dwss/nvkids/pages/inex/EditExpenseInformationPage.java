package gov.nv.dwss.nvkids.pages.inex;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.nv.dwss.nvkids.pages.proc.EditDocumentsAssociated;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class EditExpenseInformationPage extends CommonLocators
{
	public EditExpenseInformationPage() {
		PageFactory.initElements(driver,this);
	}
	
	//Screen Function
		@FindBy(xpath="//p-breadcrumb/descendant::a/span[text()='Edit Expense Information']") public WebElement elebcEditExpenseIncomeInfo;
		
		
		@FindBy(xpath="//label[text()='Expense Type']") public WebElement elelblExpenseType;
		@FindBy(xpath="//label[text()='Amount']") public WebElement elelblAmount;
		@FindBy(xpath="//label[text()='Frequency']") public WebElement elelblFrequency;
		@FindBy(xpath="//label[text()='Source']") public WebElement elelblSource;
		@FindBy(xpath="//label[text()=' Begin Date ']") public WebElement elelblBeginDate;
		@FindBy(xpath="//label[text()=' End Date ']") public WebElement elelblEndDate;
		@FindBy(xpath="//label[@for='expenseTypeCode']/following-sibling::p-dropdown/descendant::label") public WebElement eleddExpenseType;
		@FindBy(xpath="//input[@id='expenseAmt']") public WebElement eletxtAmount;
		@FindBy(xpath="//label[@for='frequencyCode']/following-sibling::p-dropdown/descendant::label") public WebElement eleddFrequency;
		@FindBy(xpath="//label[@for='sourceExpenseCode']/following-sibling::p-dropdown/descendant::label") public WebElement eleddsource;
		@FindBy(xpath="//input[@id='beginDate']") public WebElement eleicncalbeginDate;
		@FindBy(xpath="//input[@id='beginDate']/following-sibling::button") public WebElement eleicncalvalbeginDate;
		@FindBy(xpath="//input[@id='endDate']") public WebElement eleicncalEndDate;
		@FindBy(xpath="//input[@id='endDate']/following-sibling::button") public WebElement eleicncalvalEndDate;
		@FindBy(xpath="//span[text()='Add More']") public WebElement elebtnAddMore;
		@FindBy(xpath="//span[text()='Participant Source of Income']") public WebElement elelinkpsoi;
		
	
		public EditExpenseInformationPage verifyEditExpenseInfofield() throws Exception
		{
			verifyCurrentScreen("Edit Expense Information");
			verifyDisplayed(eleicnRefresh,"Refresh");
			verifyDisplayed(eleicnSave,"Save");
			verifyDisplayed(eleicnClose,"Close");
			verifyDisplayed(elelblExpenseType,"Expense Type");
			verifyDisplayed(elelblAmount,"Amount");
			verifyDisplayed(elelblFrequency,"Frequency");
			verifyDisplayed(elelblSource,"Source");
			verifyDisplayed(elelblBeginDate,"Begin Date");
			verifyDisplayed(elelblEndDate,"End Date");
			scrollToElementPosition(elelinkpsoi);
			verifyAssociatedScreens(eleAssociatedScreenList,"Note Processor","Guideline Calculation","Participant Source of Income");
			return this;
		}

		public EditExpenseInformationPage EditExpenseInfoField() throws InterruptedException, IOException
		{
			String S1="CUSTODIAN";
			String S2="NON CUSTODIAN";
			String S3="CASEWORKER";
			String val=eleddsource.getText();
			System.out.println(val);
			if(val.equals(S1)){
			selectDropdownValue(eleddsource,"NON CUSTODIAN");
			}
			else if(val.equals(S2)){
				selectDropdownValue(eleddsource,"CASEWORKER");
			}
			else if(val.equals(S3)){
				selectDropdownValue(eleddsource,"CUSTODIAN");
			}
			else {
				selectDropdownValue(eleddsource,"OTHER");
			}
			Thread.sleep(2000);
			click(eleicnSave,"Save");
			verifyExactText(eleErrStatusBar,"SAVED SUCCESSFULLY");
			return this;
		}
		
		
		
}
