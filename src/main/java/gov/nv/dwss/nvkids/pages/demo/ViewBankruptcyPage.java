package gov.nv.dwss.nvkids.pages.demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;

public class ViewBankruptcyPage  extends SeleniumBase 
{
	
	public ViewBankruptcyPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="") WebElement ele;


}
