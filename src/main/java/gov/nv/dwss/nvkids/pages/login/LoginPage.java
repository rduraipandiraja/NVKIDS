package gov.nv.dwss.nvkids.pages.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.home.HomePage;
import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;
import gov.nv.dwss.nvkids.selenium.utils.ReadPropertyFile;



public class LoginPage extends SeleniumBase {

	public LoginPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']") WebElement elelogincheckbox;
	@FindBy(how = How.XPATH, using = "//label[text()='By logging in, I accept the terms above ']") WebElement elelbllogincheckbox;
	@FindBy(how = How.ID, using = "userName") 	WebElement eleUserName;
	@FindBy(how = How.XPATH, using = "//label[text()='User Name']") 	WebElement elelblUserName;
	@FindBy(how = How.XPATH, using = "//label[text()='Password']") 	WebElement elelblPassword;
	@FindBy(how = How.ID, using = "password")	WebElement elePassWord;
	@FindBy(how = How.XPATH, using = "//span[text()='Login']") WebElement eleLogin;
	
	public HomePage login() 
	{
		click(elelogincheckbox,"Login checkbox" );
		clearAndType(eleUserName,"User Name", ReadPropertyFile.get("Username"));
		clearAndType(elePassWord,"Password", ReadPropertyFile.get("Password"));
		click(eleLogin,"Login");
		return new HomePage();
	}
	


}
