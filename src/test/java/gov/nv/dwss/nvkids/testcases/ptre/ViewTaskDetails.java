package gov.nv.dwss.nvkids.testcases.ptre;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.pages.ptre.EditProcessDetails;
import gov.nv.dwss.nvkids.pages.ptre.ViewProcessDetails;
import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class ViewTaskDetails extends CommonLocators{
	
	@DataProvider(name="getTaskCode")
	public static Object[][] fetchProcess() throws Exception
	{
		return DataLibrary.readExcelData("PTRE_ViewTaskDetails_Test Data",0);
	}
	
	@DataProvider(name="getTaskTypeCode")
	public static Object[][] fetchTaskType() throws Exception
	{
		return DataLibrary.readExcelData("PTRE_ViewTaskDetails_Test Data",1);
	}
	
	@DataProvider(name="getUpdatedBy")
	public static Object[][] fetchUpdatedBy() throws Exception
	{
		return DataLibrary.readExcelData("PTRE_ViewTaskDetails_Test Data",2);
	}


	@Test(priority=52,description="NavigateToViewProcessDetails and Verify the fields in View Task Details screen" ,testName = "UIT_PTRE_0520__Verify screen fields")
	public void VerifyScreenFields() throws Exception
	{
		new LoginPage().login().quickNavigation_PTRE().navigateToViewTaskDetails().verifyScreenFields();
	}
	
	
	@Test(priority=53,description="The Select Filters pop-up displays the Filter fields by Click the Filter icon at the top-right corner of the screen.", testName="UIT_PTRE_0530_Undock Filter SEction")
	public void VerifySelectFilters() throws Exception{
		new LoginPage().login().quickNavigation_PTRE().navigateToViewTaskDetails().verifySelectFilters();
	}
	

	@Test(priority=59,dataProvider = "getTaskCode", description="Inquire with valid value in SelectFilters",testName="UIT_PTRE_0590_Inquire with valid value")
	public void InquireValidValue(String query, String taskCode, String taskDesc, String days) throws Exception{
		new LoginPage().login().quickNavigation_PTRE().navigateToViewTaskDetails().inquireValidValue(query, taskCode);

	}
	
	@Test(priority=60,description="Click on the Show Columns from Grid Options views all the columns in the grid header.", testName="UIT_PTRE_0600_Test Show Columns in the Grid Options")
	public void verifyShowColumns() throws Exception{
		new LoginPage().login().quickNavigation_PTRE().navigateToViewTaskDetails().verifyShowColumnsPTRE();

	}
	
	
	@Test(priority=63,dataProvider = "getTaskCode", description="Inquire with  No valid values in select Filters", testName ="UIT_PTRE_0630_Inquire No valid values in select Filters")
	public void inquirewithNoValue(String query, String taskCode, String taskDesc,String days) throws Exception{
		new LoginPage().login().quickNavigation_PTRE().navigateToViewTaskDetails().inquireNullValueinTask( query,  taskCode);
	}
	
	
	@Test(priority=73,dataProvider = "getTaskCode", description = " Inquire with valid value in  NoOfDaysComplete", testName="UIT_PTRE_0730 Inquire with valid value in  NoOfDaysComplete")  
	public void  testInquireWithValidValueinNoOfDaysComplete(String query, String taskCode, String taskDesc,String days) throws Exception 
	{
		new LoginPage().login().quickNavigation_PTRE().navigateToViewTaskDetails().inquireValidValueinSFNoDaysToComplete(query,days);
	}
	
	
	@Test(priority=74,dataProvider = "getTaskTypeCode" , description = "Filter the grid records with Task Type Code Show Filters field in the grid", testName="UIT_PTRE_0740 Filter the grid records with TaskType Code Show Filters field in the grid")  
	public void  inquireSelectingShowFiltersTaskTypeCode (String query, String taskTypeCode, String taskTypeCodeDesc) throws InterruptedException, AWTException, IOException, ClassNotFoundException, SQLException   
	{
		new LoginPage().login().quickNavigation_PTRE().navigateToViewTaskDetails().verifySelectingTaskTypeCode(query,taskTypeCode);
	} 
	
	
	@Test(priority=75,dataProvider = "getTaskTypeCode" , description = "Filter the grid records with Task Type  Show Filters field in the grid", testName="UIT_PTRE_0750 Filter the grid records with TaskType  Show Filters field in the grid")  
	public void  inquireSelectingShowFiltersTaskType (String query, String taskTypeCode, String taskTypeCodeDesc) throws InterruptedException, AWTException, IOException, ClassNotFoundException, SQLException   
	{
		new LoginPage().login().quickNavigation_PTRE().navigateToViewTaskDetails().verifySelectingTaskType(query,taskTypeCodeDesc);
	}  

	
	@Test(priority=76, dataProvider = "getUpdatedBy", description = "Filter the grid records with Updated On  Show Filters field in the grid", testName="UIT_PTRE_0760 Filter the grid records with Updated On Show Filters field in the grid")  
	public void  inquireSelectingShowFiltersUpdatedOn (String query, String updatedOn, String updatedBy) throws InterruptedException, AWTException, IOException, ClassNotFoundException, SQLException   
	{
		new LoginPage().login().quickNavigation_PTRE().navigateToViewTaskDetails().inquireValidValuInUpdatedOn(query, updatedOn);
	} 
	@Test(priority=77,dataProvider = "getUpdatedBy", description = "Filter the grid records with Updated By  Show Filters field in the grid", testName="UIT_PTRE_0770 Filter the grid records with Updated By Show Filters field in the grid")  
	public void  inquireSelectingShowFiltersUpdatedBy(String query, String updatedOn, String updatedBy) throws InterruptedException, AWTException, IOException, ClassNotFoundException, SQLException   
	{
		new LoginPage().login().quickNavigation_PTRE().navigateToViewTaskDetails().inquireValidValuInUpdatedBy(query, updatedBy);
	} 
	
	@Test(priority=100,description="Click on the Show Columns from Grid Options views all the columns in the grid header.", testName="UIT_PTRE_1000_Test Show Columns in the Grid Options")
	public void verifyAccShowColumns() throws Exception{
		new LoginPage().login().quickNavigation_PTRE().navigateToViewTaskDetails().verifyAccShowColumnsPTRE();

	}
	









}
