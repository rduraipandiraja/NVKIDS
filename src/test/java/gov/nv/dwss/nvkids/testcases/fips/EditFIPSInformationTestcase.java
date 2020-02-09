package gov.nv.dwss.nvkids.testcases.fips;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class EditFIPSInformationTestcase extends CommonLocators  {
	
	
	@DataProvider(name="getFIPSData")
	public static Object[][] fetchFIPSData() throws Exception
	{
		return DataLibrary.readExcelData("FIPS_EditFIPSCodeInformation_Test Data",0);
	}
	
	
	@Test(priority=117,description="Verify Add FIPS Info fields ",testName="UIT_FIPS_01170_Verify Edit FIPS Information Screen Appearance")
	public void checkAddFIPSInfoAppearance() throws Exception
	{   
		new LoginPage().login().quickNavigation_FIPS().navigateToEditFIPSInformation().verifyScreenFields();
	}
	
	@Test(dataProvider = "getFIPSData",priority=118,description="Verify modifying new  FIPS Information",testName="UIT_FIPS_01180_Edit FIPS Information")
	public void modifyFIPSData(String fipsType,String fipsSubType, String fipsName,String address , String  address2,
			 String city, String zip, String contactName, String contactEmail, String phoneCode, String phoneNumber,String ext, String fax, String comment) throws Exception
	{   
		new LoginPage().login().quickNavigation_FIPS().navigateToEditFIPSInformation().modifyFIPSCodeInfo(fipsType, fipsSubType,  fipsName, address ,   address2,
				  city,  zip,  contactName,  contactEmail,  phoneCode,  phoneNumber, ext,  fax,  comment);
	}
	

	
	
	
	
	
	
	
}
