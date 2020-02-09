package gov.nv.dwss.nvkids.pages.inex;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class AddExpenseInformationPage extends CommonLocators
{
	public AddExpenseInformationPage() {
		PageFactory.initElements(driver,this);
	}
	
	
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
		

		public AddExpenseInformationPage InquireAddExpensefield() throws Exception
		{
			verifyCurrentScreen("Add Expense Information");
			verifyDisplayed(eleicnClear,"Clear");
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

		public AddExpenseInformationPage InquireAddExpenseField() throws InterruptedException, IOException
		{
			
			selectRandomDropdownValue(eleddExpenseType);
			clearAndType(eletxtAmount,"Amount","100");
			selectDropdownValue(eleddFrequency,"MONTHLY");
			selectRandomDropdownValue(eleddsource);
			setPastDate(eleicncalbeginDate,1);
			setCurrentDate(eleicncalEndDate);
			Thread.sleep(2000);
			click(eleicnSave,"Save");
			verifyExactText(eleErrStatusBar,"SAVED SUCCESSFULLY");
			return this;
		}
}
