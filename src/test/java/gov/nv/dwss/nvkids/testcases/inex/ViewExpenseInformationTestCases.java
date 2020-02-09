package gov.nv.dwss.nvkids.testcases.inex;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class ViewExpenseInformationTestCases extends CommonLocators
{

	@DataProvider(name="viewexpense")
	public static Object[][] verifyrecord() throws IOException
	{
		return DataLibrary.readExcelData("INEX_View Expense Information_Test Data",0);
	}
	
	@Test(priority=9,description = "Navigate to INEX screen using Quick Navigation and verify field appearance", testName="UIT_INEX_01010_Quick Navigation to INEX")
	public  void verifyExpenseInformationField() throws Exception{
		new LoginPage().login().quickNavigation_INEX().navigateToViewExpenseInformationPage().InquireFieldAppearence();
	}
	
	@Test(priority=10,description = " Select Filters popup displays Filter fields by clicking  Filter icon",testName="UIT_INEX_01070_Verify Select Filters Fields")
	public  void verifySelectFilterIcon() throws Exception{
		new LoginPage().login().quickNavigation_INEX().navigateToViewExpenseInformationPage().InquireFilterIcon();
	}
	
	@Test(dataProvider ="viewexpense",priority=11,description = "verify  Grid Records in view Expense Information Page", testName="UIT_INEX_01130_verify Grid Records")
	public void InquireGridData(String query,String expparticipantid) throws Exception{
		new LoginPage().login().quickNavigation_INEX().navigateToViewExpenseInformationPage().verifyGridresult(query, expparticipantid);
	}
	
	@Test(priority=12,description = "verify ShowColumns in view Expense Information Page", testName="UIT_INEX_01420_verify ShowColumns")
	public void InquireShowColumn() throws Exception{
		new LoginPage().login().quickNavigation_INEX().navigateToViewExpenseInformationPage().verifyShowColumn();
	}
}
