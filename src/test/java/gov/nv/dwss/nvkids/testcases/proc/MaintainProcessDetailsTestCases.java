package gov.nv.dwss.nvkids.testcases.proc;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class MaintainProcessDetailsTestCases extends CommonLocators
{
	@DataProvider(name="Processname")
	public static Object[][] fetchprocessname() throws IOException
	{
		return DataLibrary.readExcelData("PROC_MaintainProcessDetails_Test Data",0);
	}
	
	
	@Test(priority=1,description = "Navigate to the PROC screen using Quick Navigation and verify field appearance", testName="UIT_PROC_00010_Quick Navigation to PROC")
	public  void verifyViewPROCInformationScreen() throws Exception{
		new LoginPage().login().quickNavigation_PROC().verifyViewPROCInfo();
	}
	
	@Test(priority=2,description = "The Select Filters pop-up displays the Filter fields by clicking the Filter icon",testName="UIT_PROC_00060_Verify Select Filters Fields	")
	public  void verifySelecFilters() throws Exception{
		new LoginPage().login().quickNavigation_PROC().verifySelecFilters();
	}
	
	@Test(dataProvider = "Processname",priority=3,description = "verify Select Filters fields when Valid Value selected from LOV Field in the Select Filter", testName="UIT_PROC_00130_verify Valid Value selected Filters fields")
	public void InquireProcessName(String query,String processname) throws Exception{
		new LoginPage().login().quickNavigation_PROC().verifyValidProcessName(query,processname);
	}
	
	@Test(priority=4,description = "verify Show Columns Fields from Grid Options in the Process Field", testName="UIT_PROC_00150_verify Show Columns Fields from Grid Options")
	public void verifyShowcolumn() throws Exception{
		new LoginPage().login().quickNavigation_PROC().Inquireshowncolumns();
	}

}

