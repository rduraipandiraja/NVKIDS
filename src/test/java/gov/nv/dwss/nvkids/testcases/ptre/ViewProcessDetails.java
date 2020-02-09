package gov.nv.dwss.nvkids.testcases.ptre;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Rotatable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class ViewProcessDetails extends CommonLocators 

{   

	@DataProvider(name="getProcessCode")
	public static Object[][] fetchProcess() throws Exception
	{
		return DataLibrary.readExcelData("PTRE_ViewProcessDetails_Test Data",0);
	}
	
	@DataProvider(name="getCategoryCode")
	public static Object[][] fetchCategory() throws Exception
	{
		return DataLibrary.readExcelData("PTRE_ViewProcessDetails_Test Data",1);
	}

	
	@DataProvider(name="getManualStartCode")
	public static Object[][] fetchManualStart() throws Exception
	{
		return DataLibrary.readExcelData("PTRE_ViewProcessDetails_Test Data",2);
	}
	
	@DataProvider(name="getUpdatedBy")
	public static Object[][] fetchUpdatedBy() throws Exception
	{
		return DataLibrary.readExcelData("PTRE_ViewProcessDetails_Test Data",3);
	}


	@Test(priority=1,description = "Navigate to the View Process Details screen using Quick Navigation and verify field appearance", testName="UIT_PTRE_00010_Quick Menu Navigation to PTRE")
	public  void verifyViewPTREInformationScreen() throws Exception{
		new LoginPage().login().quickNavigation_PTRE().verifyScreenFields();
	}



	@Test(priority=3,description="Undock Filter Section and verify fields" , testName = "UIT_PTRE_00030 Verify Select Filters fields")
	public void testVerifySelectFilters() throws Exception{
		new LoginPage().login().quickNavigation_PTRE().verifySelectFilters();
	}



	@Test(priority=9,dataProvider = "getProcessCode",description = "Inquire records by selecting a Process ID, which has associated records, from the Process ID  in the Select Filters", testName="UIT_PTRE_0090_Inquiry with the Process ID in the Select Filters")
	public  void InquireValidValuePTREType(String query, String processCode, String processDec) throws Exception{
		new LoginPage().login().quickNavigation_PTRE().InquireValidValue( query,  processCode,  processDec);
	}

	@Test(priority=10,description="Click on the Show Columns from Grid Options views all the columns in the grid header.", testName="UIT_PTRE_0100 Test Show Columns in the Grid Options")
	public void verifyShowColumns() throws Exception{
		new LoginPage().login().quickNavigation_PTRE().verifyShowColumnsPTRE();
	}


	@Test(priority=13,dataProvider = "getProcessCode",description="Inquire records by without selecting a Process ID", testName ="UIT_PTRE_0130 Inquire No valid values in select Filters")
	public void inquirewithNoValue(String query, String processCode, String processDec) throws Exception{
		new LoginPage().login().quickNavigation_PTRE().inquirewithNoValue(query,processCode);
	}


	@Test(priority=18,dataProvider = "getProcessCode", description = "Inquiry with a Show Filters Process ID  that does exist in NVKIDS", testName="UIT_PTRE_0180_Inquiry with a Show Filters Process ID that does exist in NVKIDS")
	public void inquireValidValueInShowFiltersProcessID (String Query, String processCode, String processDesc) throws Exception    
	{
		new LoginPage().login().quickNavigation_PTRE().inquireValidValueinSFProcessID( Query, processCode);
	} 
	@Test(priority=18, dataProvider = "getProcessCode", description = "Inquiry with a Show Filters Process   that does exist in NVKIDS", testName="UIT_PTRE_0180_AInquiry with a Show Filters Process  that does exist in NVKIDS")
	public void inquireValidValueInShowFiltersProcess (String Query, String processCode, String processDesc) throws Exception    
	{
		new LoginPage().login().quickNavigation_PTRE().inquireValidValueinSFProcess(Query ,processDesc );
	} 



	@Test(priority=20, dataProvider = "getCategoryCode", description = "Filter the grid records with category Code Show Filters field in the grid", testName="UIT_PTRE_0200 Filter the grid records with category Code Show Filters field in the grid")  
	public void  inquireSelectingShowFiltersCategoryCode (String Query, String categoyCode, String categoryDesc) throws InterruptedException, AWTException, IOException, ClassNotFoundException, SQLException   
	{
		new LoginPage().login().quickNavigation_PTRE().inquireSelectingSFCategoryCode(Query,categoyCode);
	}  


	@Test(priority=21,dataProvider = "getCategoryCode", description = "Filter the grid records with category Show Filters field in the grid", testName="UIT_PTRE_0210 Filter the grid records with category Show Filters field in the grid")  
	public void  inquireSelectingShowFiltersCategory (String Query, String categoyCode, String categoryDesc) throws InterruptedException, AWTException, IOException, ClassNotFoundException, SQLException   
	{
		new LoginPage().login().quickNavigation_PTRE().inquireSelectingSFCategory(Query,categoryDesc);
	}  

	@Test(priority=22, dataProvider = "getManualStartCode" , description = "Filter the grid records with Manual Start Code Show Filters field in the grid", testName="UIT_PTRE_0220 Filter the grid records with Manual Start Code Show Filters field in the grid")  
	public void  inquireSelectingShowFiltersManualStartCode (String query, String manualCode, String manualDesc) throws InterruptedException, AWTException, IOException, ClassNotFoundException, SQLException   
	{
		new LoginPage().login().quickNavigation_PTRE().inquireSelectingSFManualStartCode( query,  manualCode);
	}  

	@Test(priority=23,  dataProvider = "getManualStartCode" , description = "Filter the grid records with Manual Start  Show Filters field in the grid", testName="UIT_PTRE_0230 Filter the grid records with Manual Start Show Filters field in the grid")  
	public void  inquireSelectingShowFiltersManualStart (String query, String manualCode, String manualDesc) throws InterruptedException, AWTException, IOException, ClassNotFoundException, SQLException   
	{
		new LoginPage().login().quickNavigation_PTRE().inquireSelectingSFManualStart( query, manualDesc);
	} 

	@Test(priority=24, dataProvider = "getUpdatedBy", description = "Filter the grid records with Updated On  Show Filters field in the grid", testName="UIT_PTRE_0240 Filter the grid records with Updated On Show Filters field in the grid")  
	public void  inquireSelectingShowFiltersUpdatedOn (String query, String updatedOn, String updatedBy) throws InterruptedException, AWTException, IOException, ClassNotFoundException, SQLException   
	{
		new LoginPage().login().quickNavigation_PTRE().inquireValidValuInUpdatedOn(query, updatedOn);
	} 
	@Test(priority=25,dataProvider = "getUpdatedBy",description = "Filter the grid records with Updated By  Show Filters field in the grid", testName="UIT_PTRE_0250 Filter the grid records with Updated By Show Filters field in the grid")  
	public void  inquireSelectingShowFiltersUpdatedBy(String query, String updatedOn, String updatedBy) throws InterruptedException, AWTException, IOException, ClassNotFoundException, SQLException   
	{
		new LoginPage().login().quickNavigation_PTRE().inquireValidValuInUpdatedBy(query, updatedBy);
	} 
















































}