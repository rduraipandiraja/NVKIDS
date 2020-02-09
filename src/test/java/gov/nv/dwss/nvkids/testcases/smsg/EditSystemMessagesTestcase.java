package gov.nv.dwss.nvkids.testcases.smsg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class EditSystemMessagesTestcase extends CommonLocators

{
	
	@DataProvider(name="getError")
    public static Object[][] getError() throws Exception
	{
		return DataLibrary.readExcelData("SMSG_View System Messages_Test Data",0);
	}
	
	@Test(dataProvider = "getError",testName="UIT_SMSG_00580_Navigate to Edit System Messages Screen Function ",priority=11,
			description="Navigate to Edit System Messages Screen Function ")
	public void verifyFields(String query,String col1) throws Exception 
    {
		new LoginPage().login().quickNavigation_SMSG().navigateToEditSystemMessages(query, col1).verifyFields();
    }

    @Test(dataProvider = "getError",testName="UIT_SMSG_00710_Modify the system messages",priority=12,
    		description="Modify the system messages")
    public void editMessages(String query,String col1) throws Exception 
    {
    	new LoginPage().login().quickNavigation_SMSG().navigateToEditSystemMessages(query, col1).editMessages();
    }
    

}
