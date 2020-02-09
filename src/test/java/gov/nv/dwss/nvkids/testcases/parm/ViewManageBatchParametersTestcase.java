package gov.nv.dwss.nvkids.testcases.parm;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.pages.parm.ViewManageBatchParametersPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class ViewManageBatchParametersTestcase extends CommonLocators
{
	@DataProvider(name="getJobID")
    public static Object[][] getJobID() throws Exception
	{
		return DataLibrary.readExcelData("PARM_View Manage Batch Parameters_Test Data",0);
	}
	
	@DataProvider(name="getJobDescription")
    public static Object[][] getJobDescription() throws Exception
	{
		return DataLibrary.readExcelData("PARM_View Manage Batch Parameters_Test Data",1);
	}
	
	@DataProvider(name="getJobName")
    public static Object[][] getJobName() throws Exception
	{
		return DataLibrary.readExcelData("PARM_View Manage Batch Parameters_Test Data",2);
	}
	

	@DataProvider(name="getFrequencyCode")
    public static Object[][] getFrequencyCode() throws Exception
	{
		return DataLibrary.readExcelData("PARM_View Manage Batch Parameters_Test Data",3);
	}
	
	@DataProvider(name="getFrequency")
    public static Object[][] getFrequency() throws Exception
	{
		return DataLibrary.readExcelData("PARM_View Manage Batch Parameters_Test Data",4);
	}
	
	@DataProvider(name="getRunDate")
    public static Object[][] getRunDate() throws Exception
	{
		return DataLibrary.readExcelData("PARM_View Manage Batch Parameters_Test Data",5);
	}
	
	@Test(testName="UIT_PARM_00010_Navigate By Quick Navigation to PARM",priority=1,description="Navigate By Quick Navigation to PARM")
	public void verifyViewManageBatchParameters() throws Exception
	{
		new LoginPage().login().quickNavigation_PARM().verifyViewManageBatchParameters();
	}
	
	@Test(testName="UIT_PARM_0050_Verify Select Filter Section",priority=2,description="Verify Select Filter Section")
	public  void verifySelectFilters() throws Exception
	{
		new LoginPage().login().quickNavigation_PARM().verifySelectFilters();
	}
	
	@Test(dataProvider = "getJobID",testName="UIT_PARM_0090_Search records by Job ID",priority=3,description="Search records by Job ID")
	public void inquireJobID(String query,String jobID) throws Exception
	{
		new LoginPage().login().quickNavigation_PARM().inquireJobID(query,jobID);
	}
	
	@Test(dataProvider = "getJobID",testName="UIT_PARM_00140_Filter the grid records with JOB ID Show Filters field in the Grid ",priority=4,description="Filter the grid records with JOB ID Show Filters field in the Grid ")
	public void inquireJobIDShowFilters(String query,String jobID) throws Exception
	{
		new LoginPage().login().quickNavigation_PARM().inquireJobIDShowFilters(query,jobID);
	}

	@Test(dataProvider = "getJobDescription",testName="UIT_PARM_00170_Filter the grid records with JOB DESCRIPTION Show Filters field in the Grid",priority=5,description="Filter the grid records with JOB DESCRIPTION Show Filters field in the Grid")
	public void inquireJobDescriptionShowFilters(String query,String jobDescription) throws Exception
	{
		new LoginPage().login().quickNavigation_PARM().inquireJobDescriptionShowFilters(query,jobDescription);
	}
	
	@Test(dataProvider = "getJobName",testName="UIT_PARM_00200_Filter the grid records with JOB NAME Show Filters field in the Grid",priority=6,description="Filter the grid records with JOB NAME Show Filters field in the Grid")
	public void inquireJobNameShowFilters(String query,String jobName) throws Exception
	{
		new LoginPage().login().quickNavigation_PARM().inquireJobNameShowFilters(query,jobName);
	}
	
	@Test(dataProvider= "getFrequencyCode",testName="UIT_PARM_00230_Filter the grid records with RUN FREQUENCY CODE Show Filters field in the Grid which has matching record",priority=7,description="Filter the grid records with RUN FREQUENCY CODE Show Filters field in the Grid which has matching record")
	public void inquireRunFrequencyCodeShowFilters(String query,String runFrequencyCode) throws Exception
	
	{
		new LoginPage().login().quickNavigation_PARM().inquireRunFrequencyCodeShowFilters(query,runFrequencyCode);
	}
	
	@Test(dataProvider= "getFrequency",testName="UIT_PARM_00240_Filter the grid records with RUN FREQUENCY Show Filters field in the Grid which has no matching records",priority=8,description="Filter the grid records with RUN FREQUENCY Show Filters field in the Grid which has no matching records")
	public void inquireRunFrequencyShowFilters(String query,String runFrequency) throws Exception
	
	{
		new LoginPage().login().quickNavigation_PARM().inquireRunFrequencyShowFilters(query,runFrequency);
	}
	
	
	@Test(dataProvider= "getRunDate",testName="UIT_PARM_00310_Filter the grid records with RUN DATE Show Filters field in the Grid which has matching records",priority=9,description="Filter the grid records with RUN DATE Show Filters field in the Grid which has matching records")
	public void inquireRunDateShowFilters(String query,String runDate) throws Exception
	{
		new LoginPage().login().quickNavigation_PARM().inquireRunDateShowFilters(query,runDate);
	}

	
	@Test(testName="UIT_PARM_00360_Test Show Columns in the Grid Options to view list of columns",priority=10,description="Test Show Columns in the Grid Options to view list of columns")
	public void testShowColumnsShowFilters() throws Exception
	{
		new LoginPage().login().quickNavigation_PARM().testShowColumnsShowFilters();
	}
	

	@Test(testName="UIT_PARM_00420_View Details for a Single Record in the accordion grid ",priority=11,description="View Details for a Single Record in the accordion grid ")
	public void verifyAccordionFields() throws Exception 
	{
		new LoginPage().login().quickNavigation_PARM().verifyAccordionFields();
	}


}
