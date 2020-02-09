package gov.nv.dwss.nvkids.testcases.smsg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class ViewBroadcastMessagesTestcase extends CommonLocators  {
	
	@DataProvider(name="getUserName")
	public static Object[][] fetchProcess() throws Exception
	{
		return DataLibrary.readExcelData("SMSG_ViewBroadcastMessages_Test Data",0);
	}
	
	@DataProvider(name="getTitle")
	public static Object[][] fetchTitle() throws Exception
	{
		return DataLibrary.readExcelData("SMSG_ViewBroadcastMessages_Test Data",1);
	}
	@DataProvider(name="getRole")
	public static Object[][] fetchRole() throws Exception
	{
		return DataLibrary.readExcelData("SMSG_ViewBroadcastMessages_Test Data",2);
	}
	@DataProvider(name="getStatus")
	public static Object[][] fetchStatus() throws Exception
	{
		return DataLibrary.readExcelData("SMSG_ViewBroadcastMessages_Test Data",3);
	}
	
	
	
	
	

	@Test(testName="UIT_SMSG_00720 - Navigate to View Broadcast Messages screen",priority=72,description= "Navigate to View Broadcast Messages screen")
	public void verifyViewBroadcastMessages() throws Exception
	{
		new LoginPage().login().quickNavigation_SMSG().navigateToBroadcastMessages().verifyViewBroadcastMesagesApprearnce();
	}

	
	@Test(testName="UIT_SMSG_00740 - View Filter fields",priority=74,description="View Filter fields")
	public  void verifySelectFilters() throws Exception
	{
		new LoginPage().login().quickNavigation_SMSG().navigateToBroadcastMessages().verifySelecFilters();
	}

	
	@Test(dataProvider = "getUserName", testName="UIT_SMSG_00810 - Inquiry with valid USER ID  that does  exist in NVKIDS in the CREATED BY field in the Select Filters pop-up ",priority=81,description="Inquiry with a valid USER that does  exist in NVKIDS in the CREATED BYfield in the Select Filters pop-up")
	public  void inquireValidCreatedBy(String query, String userName , String fromDate, String throughDate) throws Exception
	{
		new LoginPage().login().quickNavigation_SMSG().navigateToBroadcastMessages().inquireValidCreatedBy(query,userName,fromDate,throughDate);
	}

	
	@Test(dataProvider="getUserName", testName="UIT_SMSG_00930 -  Inquire With valid date Range  ",priority=93,description=" Inquire With valid date Range  ")
	public  void inquireValidDateRange(String query, String userName , String fromDate, String throughDate) throws Exception
	{
		new LoginPage().login().quickNavigation_SMSG().navigateToBroadcastMessages().inquireValidDateRange(query,userName,fromDate,throughDate);
	}
	


	@Test(dataProvider = "getTitle", testName="UIT_SMSG_01000 - Inquiry with valid Title  that does  exist in NVKIDS  ",priority=100, description="Inquiry with a valid title that does  exist in NVKIDS")
	public  void inquireValidTitle(String query,String fromDate, String throughDate,String title, String descrition) throws Exception
	{
		new LoginPage().login().quickNavigation_SMSG().navigateToBroadcastMessages().inquireValidTitle(query, fromDate,throughDate,title);
	}

	


	@Test(dataProvider = "getTitle",testName="UIT_SMSG_01060 - Inquiry with valid DESCRIPTION  that does  exist in NVKIDS  ",priority=106, description="Inquiry with a valid DESCRIPTION that does  exist in NVKIDS")
	public  void inquireValidDescription(String query,String fromDate, String throughDate,String title, String descrition) throws Exception
	{
		new LoginPage().login().quickNavigation_SMSG().navigateToBroadcastMessages().inquireValidDescription(query, fromDate,throughDate,descrition);
	}

	

	@Test(dataProvider = "getRole", testName="UIT_SMSG_01130 - Inquiry with valid VISIBLE TO  that does  exist in NVKIDS  ",priority=113, description="Inquiry with a valid VISIBLE TO that does  exist in NVKIDS")
	public  void inquireValidVisibleTo(String query,String fromDate, String throughDate,String role,String roleCode) throws Exception
	{
		new LoginPage().login().quickNavigation_SMSG().navigateToBroadcastMessages().inquireValidVisibleTo(query,fromDate, throughDate,role,roleCode);
	}

	@Test(dataProvider = "getUserName", testName="UIT_SMSG_01190 - Inquiry with valid CREATED BY  that does  exist in NVKIDS  ",priority=119, description="Inquiry with a valid CREATED BY that does  exist in NVKIDS")
	public  void inquireValidSFCreatedBy(String query, String userName , String fromDate, String throughDate) throws Exception
	{
		new LoginPage().login().quickNavigation_SMSG().navigateToBroadcastMessages().inquireValidSFCreatedBy(query,userName,fromDate,throughDate);
	}

	
	
	@Test(dataProvider = "getStatus", testName="UIT_SMSG_01210 - Inquiry with valid CURRENT STATUS  that does  exist in NVKIDS  ",priority=121, description="Inquiry with a valid CURRENT STATUS that does  exist in NVKIDS")
	public  void inquireValidCurrentStatus(String query, String fromDate, String throughDate ,String status ) throws Exception
	{
		new LoginPage().login().quickNavigation_SMSG().navigateToBroadcastMessages().selectValidSFStatus(query,fromDate,throughDate,status);
	}

	
	@Test(dataProvider = "getUserName", testName="UIT_SMSG_01240 - Test Show Columns in the Grid Options to view the list of columns",priority=124,description="Test Show Columns in the Grid Options to view the list of columns")
	public void testShowColumnsShowFilters(String query, String userName , String fromDate, String throughDate) throws Exception
	{   
		new LoginPage().login().quickNavigation_SMSG().navigateToBroadcastMessages().verifyShowColoumnValues(query,userName,fromDate,throughDate);
	}

	




}
