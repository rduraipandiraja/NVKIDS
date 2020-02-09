package gov.nv.dwss.nvkids.testcases.inex;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class AddExpenseInformationTestCases extends CommonLocators
{

	@DataProvider(name="addexpense")
	public static Object[][] verifyrecord() throws IOException
	{
		return DataLibrary.readExcelData("INEX_Add Expense Information_Test Data",0);
	}
	
	
	@Test(dataProvider="addexpense",priority=13,description = "Navigate to Add Expense Information Screen and verify Add Fields", testName="UIT_INEX_01530_verify the Add Fields")
	public  void ViewAddExpenseAddField(String query,String addparticipantid) throws Exception{
		
		new LoginPage().login().quickNavigation_INEX().navigateToViewExpenseInformationPage().navigateToAddExpenseInformationPage( query, addparticipantid).InquireAddExpensefield();
	}
	
	@Test(dataProvider="addexpense",priority=14,description = "Navigate to Add Expense Information Screen and Verify Matched data for Required Fields", testName="UIT_INEX_00700_verify Matched data for Required Fields")
	public  void ViewAddExpenseMatchedData(String query,String addparticipantid) throws Exception
	{
		new LoginPage().login().quickNavigation_INEX().navigateToViewExpenseInformationPage().navigateToAddExpenseInformationPage( query, addparticipantid).InquireAddExpenseField();
	}
}
