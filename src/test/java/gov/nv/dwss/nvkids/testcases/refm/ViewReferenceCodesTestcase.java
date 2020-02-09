package gov.nv.dwss.nvkids.testcases.refm;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class ViewReferenceCodesTestcase extends CommonLocators
{
	@DataProvider(name="getReferenceEntityAndAttribute")
    public static Object[][] getReferenceEntityAndAttribute() throws Exception
	{
		return DataLibrary.readExcelData("REFM_View Reference Codes_Test Data",0);
	}
	
	@DataProvider(name="getCode")
    public static Object[][] getCode() throws Exception
	{
		return DataLibrary.readExcelData("REFM_View Reference Codes_Test Data",1);
	}

	@DataProvider(name="getCodeDesc")
    public static Object[][] getCodeDesc() throws Exception
	{
		return DataLibrary.readExcelData("REFM_View Reference Codes_Test Data",2);
	}
	
	@DataProvider(name="getUpdatedOn")
    public static Object[][] getUpdatedOn() throws Exception
	{
		return DataLibrary.readExcelData("REFM_View Reference Codes_Test Data",3);
	}
	
	@DataProvider(name="getUpdatedBy")
    public static Object[][] getUpdatedBy() throws Exception
	{
		return DataLibrary.readExcelData("REFM_View Reference Codes_Test Data",4);
	}
	
	@Test(testName = "UIT_REFM_00010_Navigate to REFM screen",priority=1,description="Navigate to REFM screen and verify View Reference Codes Fields")
	public void navigateToViewReferenceCodes() throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().verifyFieldsPresent();
	}
	
	@Test(testName = "UIT_REFM_00040_Verify Filter Section Fields",priority=2,description="Verify the Fields present in Select filters section")
	public void verifyFilterSectionFields() throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().verifySelectFilterFields();
	}
		
	@Test(dataProvider = "getReferenceEntityAndAttribute",testName = "UIT_REFM_00080_Inquire with valid values",priority=3,description="Inquire with valid values")
	public void inquireWithValidValues(String query,String entName,String attribName) throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().inquireWithValidValues(query,entName,attribName);
	}
	
	@Test(dataProvider = "getCode",testName = "UIT_REFM_00270_Inquire With Code",priority=4,description="Verify that records are shown in the grid when inquiring with Code field")
	public void inquireWithCode(String query,String entName,String attribName,String queryRefCode,String refCode) throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().inquireWithShowFilterCode(query,entName,attribName,queryRefCode,refCode);
	}
	
	@Test(dataProvider = "getCodeDesc",testName = "UIT_REFM_00310_Inquire With Code Description",priority=5,description="Verify that records are shown in the grid when inquiring with Code Description field")
	public void inquireWithCodeDescription(String query,String entName,String attribName,String queryRefCode,String refCodeDesc) throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().inquireWithShowFilterCodeDescription(query,entName,attribName,queryRefCode,refCodeDesc);
	}
	
		
	@Test(dataProvider = "getUpdatedOn",testName = "UIT_REFM_00360_Inquire With Updated On",priority=6,description="Verify that records are shown in grid when inquiring with Updated On Field")
	public void inquireWithUpdatedOn(String query,String entName,String attribName,String queryupdOn,String updatedOn) throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().inquireWithShowFilterUpdatedOn(query,entName,attribName,queryupdOn,updatedOn);
	}
	
		
	@Test(dataProvider = "getUpdatedBy",testName = "UIT_REFM_00400_Inquire With Updated By",priority=7,description="Verify that records are shown in grid when inquiring with Updated By Field")
	public void inquireWithUpdatedBy(String query,String entName,String attribName,String queryupdBy,String updatedBy) throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().inquireWithShowFilterUpdatedBy(query,entName,attribName,queryupdBy,updatedBy);
	}
	
	@Test(testName = "UIT_REFM_00450_Check Show Columns Options",priority=8,description="Verify that all the grid rows are closed when clicking Collapse All")
	public void checkShowColumnsOptions() throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().checkShowColumnsOption();
	}
		
}
