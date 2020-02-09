package gov.nv.dwss.nvkids.testcases.smsg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.pages.smsg.ViewSystemMessagesPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class ViewSystemMessagesTestcase extends CommonLocators 

{
	
	@DataProvider(name="getError")
    public static Object[][] getError() throws Exception
	{
		return DataLibrary.readExcelData("SMSG_View System Messages_Test Data",0);
	}
	
	@DataProvider(name="getErrDescription")
    public static Object[][] getErrDescription() throws Exception
	{
		return DataLibrary.readExcelData("SMSG_View System Messages_Test Data",1);
	}

	@DataProvider(name="getDate")
    public static Object[][] getDate() throws Exception
	{
		return DataLibrary.readExcelData("SMSG_View System Messages_Test Data",2);
	}
	
	@DataProvider(name="getUser")
    public static Object[][] getUser() throws Exception
	{
		return DataLibrary.readExcelData("SMSG_View System Messages_Test Data",3);
	}
	
	
	@Test(testName="UIT_SMSG_00010 - Navigate to SMSG screen",priority=1,description="Entering the screen acronym SMSG in the Quick Navigation pop-up, navigates to the SMSG screen.")
	public void verifyViewSystemMessages() throws Exception
	{
		new LoginPage().login().quickNavigation_SMSG().verifyViewSystemMessages();
	}
	
	@Test(testName="UIT_SMSG_00040 - View Filter fields",priority=2,description="View Filter fields")
	public  void verifySelectFilters() throws Exception
	{
		new LoginPage().login().quickNavigation_SMSG().verifySelectFilters();
	}
	
	@Test(testName="UIT_SMSG_00060 - Inquiry with a Message Type in the MESSAGE TYPE field in the Select Filters pop-up",priority=3,description="Inquiry with a Message Type in the MESSAGE TYPE field in the Select Filters pop-up")
	public  void inquireMessageType() throws Exception
	{
		new LoginPage().login().quickNavigation_SMSG().inquireMessageType();
	}

	@Test(dataProvider = "getError",testName="UIT_SMSG_00120 - Inquiry with a Message ID in the MESSAGE ID field in the Select Filters pop-up",priority=4,description="Inquiry with a Message ID in the MESSAGE ID field in the Select Filters pop-up")
	public  void inquireMessageID(String query,String col1) throws Exception
	{
		new LoginPage().login().quickNavigation_SMSG().inquireMessageID(query, col1);
	}
	
	
	@Test(dataProvider = "getErrDescription",testName="UIT_SMSG_00190 - Inquiry with a Description in the DESCRIPTION field and UNTITLED in the Select Filters pop-up",priority=5,description="Inquiry with a Description in the DESCRIPTION field and UNTITLED in the Select Filters pop-up")
	public  void inquireBySearchBy(String query,String col1) throws Exception
	{
		new LoginPage().login().quickNavigation_SMSG().inquireBySearchBy(query, col1);
	}

	
	@Test(dataProvider = "getError",testName="UIT_SMSG_00270 - Filter the grid records with MESSAGE ID Show Filters field in the grid",priority=6,description="Filter the grid records with MESSAGE ID Show Filters field in the grid")
	public  void inquireMessageIDShowFilters(String query,String col1) throws Exception
	{
		new LoginPage().login().quickNavigation_SMSG().inquireMessageIDShowFilters(query, col1);
	}
	
	@Test(dataProvider = "getErrDescription",testName="UIT_SMSG_00320 - Filter the grid records with DESCRIPTION Show Filters field in the grid",priority=7,description="Filter the grid records with DESCRIPTION Show Filters field in the grid")
	public  void inquireDescriptionShowFilters(String query,String col1) throws Exception
	{
		new LoginPage().login().quickNavigation_SMSG().inquireDescriptionShowFilters(query, col1);
	}
	

	@Test(dataProvider ="getDate",testName="UIT_SMSG_00390 - Filter grid records with the valid value in UPDATED ON Show Filters field in the grid",priority=8,description="Filter grid records with the valid value in UPDATED ON Show Filters field in the grid")
	public  void inquireUpdatedOnShowFilters(String query,String col1) throws Exception
	{
		new LoginPage().login().quickNavigation_SMSG().inquireUpdatedOnShowFilters(query, col1);
	}
	
	
	@Test(dataProvider ="getUser",testName="UIT_SMSG_00450 - Filter the grid records with UPDATED BY Show Filters field in the grid",priority=9,description="Filter the grid records with UPDATED BY Show Filters field in the grid")
	public  void inquireUpdatedByShowFilters(String query,String col1) throws Exception
	{
		new LoginPage().login().quickNavigation_SMSG().inquireUpdatedByShowFilters(query, col1);
	}

	
	@Test(testName="UIT_SMSG_00480 - Test Show Columns in the Grid Options to view the list of columns",priority=10,description="Test Show Columns in the Grid Options to view the list of columns")
	public void testShowColumnsShowFilters() throws Exception
	{   
		new LoginPage().login().quickNavigation_SMSG().testShowColumnsShowFilters();
	}


	
}

