package gov.nv.dwss.nvkids.pages.ptre;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class EditProcessDetails extends CommonLocators {

	public EditProcessDetails(){
		PageFactory.initElements(driver, this);
	}


	/* Edit Screen function Name - BreadCrumb */
	@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='View Process Details']") public WebElement elebcViewProcessDetails;
	@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='Edit Process Details']") public WebElement elebcEditProcessDetails;

	@FindAll(
			{
				@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='View Process Details']"),
				@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='Edit Process Details']")
			}) public WebElement elebcComHeaderPanel;

	/* Edit Screen Detail section - Controls */
	@FindAll(value = { @FindBy(xpath="//div[@class='p-col-12 HeaderHighlight']/descendant::label") }) public List <WebElement> eleHeaderPanel; //labeltext - Field Naem,getTExt = value
	@FindBy(xpath = "//label[text()='Manual Start']") public WebElement elelblManualStart;
	@FindBy(xpath = "//label[text()='Manual Start']/following-sibling::lib-radio-input/descendant::label[text()='Allowed']") public WebElement elerbAllowed;
	@FindBy(xpath = "//label[text()='Manual Start']/following-sibling::lib-radio-input/descendant::label[text()='Not Allowed']") public WebElement elerbNotAllowed;


	public void selectAllowed(){

		click(elerbAllowed, "'Allowed'Radio button");
	}

	public void selectNotAllowed(){

		click(elerbNotAllowed, "'Not Allowed' Radio button");
	}


	public ViewProcessDetails clickSave(){
		click(eleicnSave, "Save Icon");
		return new ViewProcessDetails();
	}
	public void clickRefersh(){
		click(eleicnRefresh, "Refresh Icon");
	}

	public ViewProcessDetails clickCloseIcon() throws InterruptedException{
		Actions actions = new Actions(driver); 
		actions.moveToElement(eleicnClose);
		Thread.sleep(1500);
		click(eleicnClose, "Close Icon");
		return new ViewProcessDetails();
	}
	public void selRadioBtn(WebElement ele){
		click(ele,"Radio button");
	}

	public void verifyEditProcessDetailsAppearance() throws Exception
	{
		verifyFieldSetLabels(eleHeaderPanel,"Process ID","Process","Category","Updated On","Updated By");
		verifyDisplayed(elelblManualStart,"'Allowed' Radio button");
		verifyDisplayed(elelblManualStart,"'Not Allowed' Radio button");
		verifyDisplayed(eleicnSave, "Save Icon");
		verifyDisplayed(eleicnRefresh, "Refresh Icon");
		verifyDisplayed(eleicnClose, "Close Icon");

	}
	//done
	

	public void verifyUpdateWithChanges() throws Exception
	{   


		if(elerbAllowed.getAttribute("class").contains("ui-label-active") == true){
			selectNotAllowed();
		}
		else{
			selectAllowed();
		}

		clickSave();
		verifyExactText(eleErrStatusBar, "SAVED SUCCESSFULLY");
	}

	

}