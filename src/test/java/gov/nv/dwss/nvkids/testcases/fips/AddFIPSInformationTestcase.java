package gov.nv.dwss.nvkids.testcases.fips;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;


public class AddFIPSInformationTestcase extends CommonLocators {


	@DataProvider(name="getFIPSData")
	public static Object[][] fetchFIPSData() throws Exception
	{
		return DataLibrary.readExcelData("FIPS_AddFIPSCodeInformation_Test Data",0);
	}
	
	

	@Test(priority=85,description="Verify Add FIPS Info fields ",testName="UIT_FIPS_00850_Verify Add FIPS Information Screen Appearance")
	public void checkAddFIPSInfoAppearance() throws Exception
	{   
		new LoginPage().login().quickNavigation_FIPS().navigateToAddFIPSInformation().verifyScreenFields();
	}



	@Test(priority=86,dataProvider = "getFIPSData" , description="Verify Adding new  FIPS Information",	  testName="UIT_FIPS_00860_Add FIPS Information")

	public void	clickRefershwithoutSavingChanges(String fipsType,String fipsSubType,String agencyCode,String countyCode,String officeCode, String fipsName,String address , String  address2,
			 String city, String zip, String contactName, String contactEmail, String phoneCode, String phoneNumber,String ext, String fax, String comments) throws Exception 
	{ 
		new	LoginPage().login().quickNavigation_FIPS().navigateToAddFIPSInformation().addFIPSCodeInfo( fipsType, fipsSubType, agencyCode, countyCode, officeCode,  fipsName, address ,   address2,
				  city,  zip,  contactName,  contactEmail,  phoneCode,  phoneNumber, ext,  fax,  comments); 
	}


	










}
