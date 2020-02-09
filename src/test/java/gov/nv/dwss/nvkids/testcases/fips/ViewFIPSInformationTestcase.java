package gov.nv.dwss.nvkids.testcases.fips;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.fips.ViewFIPSInformationPage;
import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class ViewFIPSInformationTestcase extends CommonLocators {
	
	
	@DataProvider(name="getFIPSType")
    public static Object[][] fetchFIPSType() throws Exception
	{
		return DataLibrary.readExcelData("FIPS_ViewFIPSCodeInformation_Test Data",0);
	}
	
	@DataProvider(name="getFIPSSubType")
    public static Object[][] fetchFIPSSubType() throws Exception
	{
		return DataLibrary.readExcelData("FIPS_ViewFIPSCodeInformation_Test Data",1);
	}
	@DataProvider(name="getAgencyCode")
    public static Object[][] fetchAgencyCode() throws Exception
	{
		return DataLibrary.readExcelData("FIPS_ViewFIPSCodeInformation_Test Data",2);
	}
	
	@DataProvider(name="getSFName")
    public static Object[][] fetchShowFilterName() throws Exception
	{
		return DataLibrary.readExcelData("FIPS_ViewFIPSCodeInformation_Test Data",3);
	}
	
	
	

	@Test(priority=1,description = "Navigate to the FIPS screen using Quick Navigation and verify field appearance", testName="UIT_FIPS_00010_Quick Menu Navigation to FIPS")
	public  void verifyViewFIPSInformationScreen() throws Exception{
		new LoginPage().login().quickNavigation_FIPS().verifyViewFIPSCodeInfo();
	}

	

	@Test(priority=6,description = "The Select Filters pop-up displays the Filter fields by clicking the Filter icon", testName="UIT_FIPS_00060_Verify Select Filters Fields	")
	public  void verifySelecFilters() throws Exception{
		new LoginPage().login().quickNavigation_FIPS().verifySelecFilters();
	}

	@Test(priority=7,dataProvider = "getFIPSType",description = "Inquire records by selecting a FIPS Type, which has associated records, from the FIPS TYPE drop-down list in the Select Filters", testName="UIT_FIPS_00070_Inquiry with the FIPS Type in the Select Filters")
	public  void InquireValidValueFIPSType(String sqlQuery , String FIPSType, String AgencyCode) throws Exception{
		new LoginPage().login().quickNavigation_FIPS().InquireValidValueTypeAndAgencyCode( sqlQuery ,  FIPSType,  AgencyCode);
	}

	

	@Test(priority=13, dataProvider = "getFIPSSubType", description = "Inquire records by selecting a FIPS Sub Type, which has associated records, from the SELECT FIPS SUB TYPE pop-up", testName="UIT_FIPS_00130_Inquiry with the FIPS Sub Type in the Select Filters")
	public  void InquireValidValueFIPSTypeSubType(String query, String FIPSType, String SubType,String SubTypeDec, String AgencyCode) throws Exception{
		new LoginPage().login().quickNavigation_FIPS().InquireValidValueSubTypeAndAgencyCode( query,  FIPSType,  SubType, SubTypeDec,  AgencyCode);
	}

	

	@Test(priority=18, dataProvider = "getAgencyCode", description = "Inquire records by selecting a FIPS IV-D Agency Code, which has associated records, from the SELECT FIPS IV-D Agency Code pop-up", testName="UIT_FIPS_00180_Inquiry with the FIPS IV-D Agency Code in the Select Filters")
	public  void InquireValidValueFIPS_IVD_Agency_Code(String query, String AgencyCode , String AgencyDesc,String countyCode, String officeCode ) throws Exception{
		new LoginPage().login().quickNavigation_FIPS().InquireValidValueinFIPSAgencyCode( query,  AgencyCode ,  AgencyDesc);
	}

	


	@Test(priority=23,dataProvider = "getAgencyCode", description = "Inquiry with a FIPS County Code that does exist in NVKIDS", testName="UIT_FIPS_00230_Inquiry with a FIPS County Code that does exist in NVKIDS")
	public void inquireValidValueInFIPSCountyCode (String query, String AgencyCode , String AgencyDesc,String countyCode, String officeCode) throws InterruptedException, IOException, ClassNotFoundException, SQLException    
	{
		new LoginPage().login().quickNavigation_FIPS().InquireValidValueinFIPSCountyCode(query,AgencyCode,countyCode);
	}    
	       
	
	@Test(priority=28,dataProvider = "getAgencyCode", description = "Inquiry with a FIPS Office Code that does exist in NVKIDS", testName="UIT_FIPS_00280_Inquiry with a FIPS Office Code that does exist in NVKIDS")
	public void inquireValidValueInFIPSOfficeCode (String query, String AgencyCode , String AgencyDesc,String countyCode, String officeCode) throws InterruptedException, AWTException, IOException, ClassNotFoundException, SQLException    
	{
		new LoginPage().login().quickNavigation_FIPS().inquireValidValuesinFIPSOfficeCode(query,AgencyCode,countyCode,officeCode);
	}    
	

	@Test(priority=35,dataProvider = "getSFName", description = "Inquiry with a Show Filters County Code that does exist in NVKIDS", testName="UIT_FIPS_00350_Inquiry with a Show Filters County Code that does exist in NVKIDS")
	public void inquireValidValueInShowFiltersCountyCode (String query, String agencyCode, String countyCode, String officeCode, String fipsName, String contact, String fipsTypeCode, String fipsTypeDesc, String fipsSubCode, String fipsSubDesc) throws InterruptedException, IOException, ClassNotFoundException, SQLException    
	{
		new LoginPage().login().quickNavigation_FIPS().InquireValidValueinSFCountyCode(query,agencyCode,countyCode);
	}    
	
	@Test(priority=40,dataProvider = "getSFName", description = "Inquiry with a Show Filters Office Code that does exist in NVKIDS", testName="UIT_FIPS_00400_Inquiry with a Show Filters Office Code that does exist in NVKIDS")
	public void inquireValidValueInShowFiltersOfficeCode (String query, String agencyCode, String countyCode, String officeCode, String fipsName, String contact, String fipsTypeCode, String fipsTypeDesc, String fipsSubCode, String fipsSubDesc) throws InterruptedException, IOException, ClassNotFoundException, SQLException    
	{
		new LoginPage().login().quickNavigation_FIPS().InquireValidValueinSFOfficeCode(query,agencyCode,countyCode, officeCode);
	}    
	

	@Test(priority=45,dataProvider = "getSFName", description = "Inquiry with a Show Filters FIPS Name that does exist in NVKIDS", testName="UIT_FIPS_00450_Inquiry with a Show Filters FIPS Name that does exist in NVKIDS")
	public void inquireValidValueInShowFiltersFIPSName (String query, String agencyCode, String countyCode, String officeCode, String fipsName, String contact, String fipsTypeCode, String fipsTypeDesc, String fipsSubCode, String fipsSubDesc) throws InterruptedException, IOException, ClassNotFoundException, SQLException    
	{
		new LoginPage().login().quickNavigation_FIPS().InquireValidValueinSFFIPSName(query,agencyCode,fipsName);
	}    
	
	@Test(priority=51,dataProvider = "getSFName", description = "Inquiry with a Show Filters Contact Name that does exist in NVKIDS", testName="UIT_FIPS_00510_Inquiry with a Show Filters Contact Name that does exist in NVKIDS")
	public void inquireValidValueInShowFiltersContactName (String query, String agencyCode, String countyCode, String officeCode, String fipsName, String contact, String fipsTypeCode, String fipsTypeDesc, String fipsSubCode, String fipsSubDesc) throws InterruptedException, IOException, ClassNotFoundException, SQLException    
	{
		new LoginPage().login().quickNavigation_FIPS().InquireValidValueinSFContactName(query,agencyCode,contact);
	}    
	
	@Test(priority=57,dataProvider = "getSFName", description = "Filter the grid records with FIPS Type Code Show Filters field in the grid", testName="UIT_FIPS_00570 Filter the grid records with FIPS Type Code Show Filters field in the grid")  
	public void  inquireSelectingShowFiltersFIPSTypeCode (String query, String agencyCode, String countyCode, String officeCode, String fipsName, String contact, String fipsTypeCode, String fipsTypeDesc, String fipsSubCode, String fipsSubDesc) throws InterruptedException, AWTException, IOException, ClassNotFoundException, SQLException   
	{
		new LoginPage().login().quickNavigation_FIPS().verifySelectingFIPSTypeCode(query,agencyCode,fipsTypeCode);
	}  
	
	

	@Test(priority=59,dataProvider = "getSFName", description = "Filter the grid records with FIPS Type  Show Filters field in the grid", testName="UIT_FIPS_00590 Filter the grid records with FIPS Type  Show Filters field in the grid")  
	public void  inquireSelectingShowFiltersFIPSType (String query, String agencyCode, String countyCode, String officeCode, String fipsName, String contact, String fipsTypeCode, String fipsTypeDesc, String fipsSubCode, String fipsSubDesc) throws InterruptedException, AWTException, IOException, ClassNotFoundException, SQLException   
	{
		new LoginPage().login().quickNavigation_FIPS().verifySelectingFIPSType(query,agencyCode,fipsTypeDesc);
	} 
	
	
	@Test(priority=61, dataProvider = "getSFName", description = "Inquiry with a Show Filters FIPS Sub Type Code that does exist in NVKIDS", testName="UIT_FIPS_00610_Inquiry with a Show Filters FIPS Sub Type Code that does exist in NVKIDS")
	public void inquireValidValueInShowFiltersFIPSSubTypeCode (String query, String agencyCode, String countyCode, String officeCode, String fipsName, String contact, String fipsTypeCode, String fipsTypeDesc, String fipsSubCode, String fipsSubDesc) throws InterruptedException, IOException, ClassNotFoundException, SQLException    
	{
		new LoginPage().login().quickNavigation_FIPS().InquireValidValueinSFFIPSSubTypeCode(query,agencyCode,fipsSubCode);
	}    
	
	@Test(priority=65, dataProvider = "getSFName", description = "Inquiry with a Show Filters FIPS Sub Type that does exist in NVKIDS", testName="UIT_FIPS_00650_Inquiry with a Show Filters FIPS Sub Type that does exist in NVKIDS")
	public void inquireValidValueInShowFiltersFIPSSubType (String query, String agencyCode, String countyCode, String officeCode, String fipsName, String contact, String fipsTypeCode, String fipsTypeDesc, String fipsSubCode, String fipsSubDesc) throws InterruptedException, IOException, ClassNotFoundException, SQLException    
	{
		new LoginPage().login().quickNavigation_FIPS().InquireValidValueinSFFIPSSubType(query,agencyCode,fipsSubCode, fipsSubDesc);
	}    
	
	
	@Test(priority=73,dataProvider = "getSFName", description="Test Show Columns in the Grid Options", testName="UIT_FIPS_00730_Test Show Columns in the Grid Options")
	public void verifyShowColumns(String query, String agencyCode, String countyCode, String officeCode, String fipsName, String contact, String fipsTypeCode, String fipsTypeDesc, String fipsSubCode, String fipsSubDesc) throws Exception{
		new LoginPage().login().quickNavigation_FIPS().verifyShowColumnsFIPS(query,agencyCode);

	}
	
	@Test(priority=79 , dataProvider = "getSFName",description="Verify Accordion fields", testName="UIT_FIPS_00790 Verify Accodion Fields")
	public void checkAccordionFields(String query, String agencyCode, String countyCode, String officeCode, String fipsName, String contact, String fipsTypeCode, String fipsTypeDesc, String fipsSubCode, String fipsSubDesc) throws Exception{
		new LoginPage().login().quickNavigation_FIPS().verifyAccordionFields(query,agencyCode);
	}
	
	
	
	


	




}
