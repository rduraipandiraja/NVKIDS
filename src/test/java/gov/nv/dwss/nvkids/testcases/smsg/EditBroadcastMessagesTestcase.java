package gov.nv.dwss.nvkids.testcases.smsg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class EditBroadcastMessagesTestcase extends CommonLocators {
	
	@DataProvider(name="getActiveStatus")
	public static Object[][] fetchActiveStaus() throws Exception
	{
		return DataLibrary.readExcelData("SMSG_ViewBroadcastMessages_Test Data",4);
	}
	
	
	@Test(dataProvider = "getActiveStatus",testName="UIT_SMSG_01610 - Navigate to Edit Broadcast Messages screen",priority=161,description= "Navigate to Edit Broadcast Messages screen")
	public void verifyEditBroadcastMessages(String query, String fromDate, String throughDate) throws Exception
	{
		new LoginPage().login().quickNavigation_SMSG().navigateToBroadcastMessages().navigateToEditBroadcastMessages( query,  fromDate,  throughDate).verifyEditBroadcastMessagesFields();
	}

	@Test(dataProvider = "getActiveStatus",testName="UIT_SMSG_01880_Test Modify with Valid Values", priority=188,description="Test Modify with Valid Values")
	public void  testEditValidValues(String query, String fromDate, String throughDate) throws Exception
	{   
		new LoginPage().login().quickNavigation_SMSG().navigateToBroadcastMessages().navigateToEditBroadcastMessages(query,  fromDate,  throughDate).editValidValue();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
