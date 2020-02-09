package gov.nv.dwss.nvkids.testcases.logn;


import java.io.IOException;

import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;

public class LoginTestcase extends SeleniumBase {

	
	//@Test(priority=1,groups={"smoke","sanity"})
	public void VerifyLogin() throws IOException {
		System.out.println("going to start firsttestcase");
		//testcaseName = "TC001_Test Login functionality";
		testcaseDec = "InquiryandValidate";
		//category = "smoke";
		
		report();
		new LoginPage().login();	
		

	}
	
	
	//@Test(priority=2,groups={"sanity","regression"})
	public void verifyInvalidUsernameAndPassword() throws IOException {
		
		testcaseDec = "verifyInvalidUsernameAndPassword";
		report();
		
	}
	
	@Test(priority=3)
	public void verifyNullUsernameAndPassword() throws IOException {
		
		
		testcaseDec = "verify login with null username and password";
		report();
	}
	}
	
	
	
