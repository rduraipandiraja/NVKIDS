package gov.nv.dwss.nvkids.testcases.fips;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class EditCSENetInformationTestcase extends CommonLocators {
	
	@DataProvider(name="getAgecnyCode")
    public static Object[][] fetchAgencyCode() throws Exception
	{
		return DataLibrary.readExcelData("FIPS_ViewCSTNetInformation_Test Data",0);
	}

	@Test(priority=156,dataProvider =  "getAgecnyCode",description="NavigateToEditCSENet Information and Verify the fields in  screen",testName="UIT_FIPS_01560_Verify Edit CSENet Information screen fields")
	public void verifyEditProcessDetailsAppearance(String query, String agencyCode, String agencyDesc) throws Exception
	{
		new LoginPage().login().quickNavigation_FIPS().navigateToViewCSENetInformation().navigateToEditCSENetInformation( query,  agencyCode,  agencyDesc).verifyEditProcessDetailsAppearance();

	}

	@Test(priority=157,dataProvider =  "getAgecnyCode",description="Edit with making any changes",testName="UIT_FIPS_01570_Save with changes")
	public void verifyUpdateWithChanges(String query, String agencyCode, String agencyDesc) throws Exception
	{   

		new LoginPage().login().quickNavigation_FIPS().navigateToViewCSENetInformation().navigateToEditCSENetInformation( query,  agencyCode,  agencyDesc).verifyUpdateWithChanges();
	}

	

	

}
