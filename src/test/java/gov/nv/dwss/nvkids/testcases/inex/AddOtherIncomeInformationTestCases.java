package gov.nv.dwss.nvkids.testcases.inex;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class AddOtherIncomeInformationTestCases extends CommonLocators
{
	
	@DataProvider(name="Addotherincome")
	public static Object[][] verifyrecord() throws IOException
	{
		return DataLibrary.readExcelData("INEX_Add other Information_Test Data",0);
	}
	@Test(dataProvider ="Addotherincome",priority=5,description = "Navigate to Add Participant Address Screen and verify Add Fields", testName="UIT_INEX_00540_verify the Add Fields")
	public  void ViewAddDocVerifyAddField(String query,String norecparticipantid) throws Exception{
		
		new LoginPage().login().quickNavigation_INEX().navigateToAddOtherIncomeInformationPage(query,norecparticipantid).Inquirefieldappearence();
	}
	
	@Test(dataProvider ="Addotherincome",priority=6,description = "Navigate to Add Participant Address Screen and Verify Matched data for Required Fields", testName="UIT_INEX_00700_verify Matched data for Required Fields")
	public  void ViewAddDocMatchedDataField(String query,String norecparticipantid) throws Exception
	{
		new LoginPage().login().quickNavigation_INEX().navigateToAddOtherIncomeInformationPage(query,norecparticipantid).InquireField();
	}
}
