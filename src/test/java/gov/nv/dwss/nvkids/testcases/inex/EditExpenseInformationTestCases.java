package gov.nv.dwss.nvkids.testcases.inex;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class EditExpenseInformationTestCases extends CommonLocators
{
	@DataProvider(name="editexpense")
	public static Object[][] verifyrecord() throws IOException
	{
		return DataLibrary.readExcelData("INEX_Edit Expense Information_Test Data",0);
	}
	@Test(dataProvider ="editexpense",priority=15,description = "Navigate to Edit Expense Information Screen and Verify Field for Edit Expense Information", testName="UIT_INEX_01770_verify Field for Edit Expense Information Screen")
	public  void InquireEditotherIncomeField(String query,String expparticipantid) throws Exception
	{
		new LoginPage().login().quickNavigation_INEX().navigateToViewExpenseInformationPage().navigateToEditExpenseInformationPage( query, expparticipantid).verifyEditExpenseInfofield();
	}
	
	@Test(dataProvider ="editexpense",priority=16,description = "Navigate to Edit Expense Information Screen and Verify Field for Edit Expense Information", testName="UIT_INEX_01930_verify Field for Edit Expense Information Screen")
	public  void EditotherIncomeInformationField(String query,String expparticipantid) throws Exception
	{
		new LoginPage().login().quickNavigation_INEX().navigateToViewExpenseInformationPage().navigateToEditExpenseInformationPage( query, expparticipantid).EditExpenseInfoField();
	}
}
