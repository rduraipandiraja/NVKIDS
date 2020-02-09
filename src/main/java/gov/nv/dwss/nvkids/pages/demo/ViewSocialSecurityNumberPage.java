package gov.nv.dwss.nvkids.pages.demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;

public class ViewSocialSecurityNumberPage  extends SeleniumBase 
{
	
	public ViewSocialSecurityNumberPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="") WebElement ele;
	

}
