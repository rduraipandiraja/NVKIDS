package gov.nv.dwss.nvkids.testcases.fips;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class ViewCSENetInformationTestcase extends CommonLocators{
	
	@DataProvider(name="getAgecnyCode")
    public static Object[][] fetchAgencyCode() throws Exception
	{
		return DataLibrary.readExcelData("FIPS_ViewCSTNetInformation_Test Data",0);
	}
	
	@Test(priority=140,description = "Navigate to the ViewCSENetInformation screen", testName="UIT_FIPS_01400_Navigate to ViewCSENetInformation")
	public  void verifyViewCSENetInformationScreen() throws Exception{
		new LoginPage().login().quickNavigation_FIPS().navigateToViewCSENetInformation().verifyViewCSENetInformation();
	}
	
	
	
	@Test(priority=144,description = "Verify Select Filters", testName="UIT_FIPS_01440_Verify Select Filters")
	public  void verifySelecFilters() throws Exception{
		new LoginPage().login().quickNavigation_FIPS().navigateToViewCSENetInformation().verifySelecFilters();
	}
	
	@Test(priority=145,dataProvider = "getAgecnyCode", description = "Inquire to check the result in the grid", testName="UIT_FIPS_01450_Inquire to check the result in the grid")
	public  void InquireValidValue(String query, String agencyCode, String agencyDesc) throws Exception{
		new LoginPage().login().quickNavigation_FIPS().navigateToViewCSENetInformation().inquireValidValue(query,agencyCode,agencyDesc);
	}
	
	
	
	@Test(priority=150,description = "Verify Show Columns values list", testName="UIT_FIPS_01500_Verify Show Columns values list")
	public  void verifyShowColumns_list() throws IOException, InterruptedException, Exception {
		new LoginPage().login().quickNavigation_FIPS().navigateToViewCSENetInformation().verifyShowColumnsFIPS();
	}
	



}
