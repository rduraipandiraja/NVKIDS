package gov.nv.dwss.nvkids.testcases.smsg;

import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class AddBroadcastMessagesTestcase  extends CommonLocators {

	@Test(testName="UIT_SMSG_01340 - Navigate to Add Broadcast Messages screen",priority=134,description= "Navigate to Add Broadcast Messages screen")
	public void verifyAddBroadcastMessages() throws Exception
	{
		new LoginPage().login().quickNavigation_SMSG().navigateToBroadcastMessages().navigateToAddBroadcastMessages().verifyAddBroadcastMessagesFields();
	}

	@Test(testName="UIT_SMSG_01600_Test Add with Valid Values", priority=159,description="Test Add with Valid Values")
	public void  testAddValidValues() throws Exception
	{   
		new LoginPage().login().quickNavigation_SMSG().navigateToBroadcastMessages().navigateToAddBroadcastMessages().addValidValue();
	}

























}
