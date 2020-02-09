package gov.nv.dwss.nvkids.testcases.demo;

import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;

public class PersonalInformationTestCase extends SeleniumBase

{

	@Test(priority=1,description="Upload Button")
	
	public void UploadButton() throws Exception 
	{
		new LoginPage().login().quickNavigation_DEMO().Upload();
	}
}
