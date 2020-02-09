package gov.nv.dwss.nvkids.testcases.inex;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class EditOtherIncomeInformationTestCases extends CommonLocators
{
	@DataProvider(name="editotherincome")
	public static Object[][] verifyrecord() throws IOException
	{
		return DataLibrary.readExcelData("INEX_Edit other Information_Test Data",0);
	}

	@Test(dataProvider ="editotherincome",priority=7,description = "Navigate to Edit Other Income Information Screen and Verify Field for Edit Other Income Information", testName="UIT_INEX_00770_verify Field for Edit Other Income Information Screen")
	public  void InquireEditotherIncomeField(String query,String participantid) throws Exception
	{
		new LoginPage().login().quickNavigation_INEX().navigateToEditOtherIncomeInformationPage(query,participantid).Inquirefieldappearence();
	}
	
	@Test(dataProvider ="editotherincome",priority=8,description = "Navigate to Edit Other Income Information Screen and Verify Field for Edit Other Income Information", testName="UIT_INEX_00930_verify Field for Edit Other Income Information Screen")
	public  void EditotherIncomeInformationField(String query,String participantid) throws Exception
	{
		new LoginPage().login().quickNavigation_INEX().navigateToEditOtherIncomeInformationPage(query,participantid).EditField();
	}
}
