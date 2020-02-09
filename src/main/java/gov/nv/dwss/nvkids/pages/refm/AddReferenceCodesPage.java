package gov.nv.dwss.nvkids.pages.refm;


import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class AddReferenceCodesPage extends CommonLocators
{
	public AddReferenceCodesPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	ViewReferenceCodesPage v=new ViewReferenceCodesPage();
	
	@FindBy(xpath="//label[text()='Reference Entity']") WebElement elelblReferenceEntity;
	@FindBy(xpath="//input[@id='entityName']") WebElement eletxtReferenceEntity;
	@FindBy(xpath="//input[@id='entityName']/following::button[1]") WebElement eleicnReferenceEntity;
	@FindBy(xpath="//label[text()=' Entity Name ']/following::td[1]/span") WebElement elelovvalReferenceEntity;
	@FindBy(xpath="//label[text()='Reference Attribute']") WebElement elelblReferenceAttribute;
	@FindBy(id="attributeName") WebElement eletxtReferenceAttribute;
	@FindBy(xpath="//input[@id='attributeName']/following::button[1]") WebElement eleicnReferenceAttribute;
	@FindBy(xpath="//label[text()=' Attribute Name ']/following::td[1]") WebElement elelovvalReferenceAttribute;
	@FindBy(xpath="//label[text()='Reference Description']") WebElement elelblReferenceDescription;
	@FindBy(id="attributeDesc") WebElement eledsoReferenceDescription;
	@FindBy(xpath="//label[text()='Code']") WebElement elelblCode;
	@FindBy(id="referenceCode") WebElement eletxtCode;
	@FindBy(xpath="//label[text()='Code Description']") WebElement elelblCodeDescription;
	@FindBy(id="referenceDesc") WebElement eletxtCodeDescription;
	
	@FindBy(xpath="//lib-panel/descendant::input[not(@disabled)]") List<WebElement> eletxtAddFields;
	
	@FindAll(
			{
			@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='View Reference Codes']"),
			@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='Add Reference Codes']")
			}) public WebElement eleComHeaderPanel;
	
	
	public AddReferenceCodesPage verifyAddReferenceCodesFields() throws Exception
	{
		verifyDisplayed(elelblReferenceEntity,"ReferenceEntity");
		verifyDisplayed(elelblReferenceAttribute,"ReferenceAttribute");
		verifyDisplayed(elelblReferenceDescription,"ReferenceDescription");
		verifyDisplayed(elelblCode,"Code");
		verifyDisplayed(elelblCodeDescription,"CodeDescription");
		return this;
	}
	
	public AddReferenceCodesPage selectReferenceEntityFromLOV() throws InterruptedException
	{
		Thread.sleep(2000);
		click(eleicnReferenceEntity,"Reference Entity");
		Thread.sleep(3000);
		doDoubleClick(elelovvalReferenceEntity);
		return this;
	}


	public AddReferenceCodesPage selectReferenceAttributeFromLOV() throws InterruptedException
	{
		Thread.sleep(3000);
		click(eleicnReferenceAttribute,"Reference Attribute");
		Thread.sleep(3000);
		doDoubleClick(elelovvalReferenceAttribute);
		return this;
	}

	public ViewReferenceCodesPage verifySuccessfulAdd(String refEntity,String refAttrib) throws InterruptedException 
	{
		clearAndType(eletxtReferenceEntity,"Reference Entity", refEntity);
		Thread.sleep(1000);
		setFocus(eletxtReferenceAttribute);
		Thread.sleep(3000);
		clearAndType(eletxtReferenceAttribute,"Reference Attribute", refAttrib);
		Thread.sleep(2000);
		clearAndType(eletxtCode,"Code", getRandomAlphaNumericChar(5));
		Thread.sleep(2000);
		clearAndType(eletxtCodeDescription,"CodeDescription", getRandomAlphaNumericChar(7));
		click(eleicnSave,"Save");
		verifyExactText(eleErrStatusBar, "SAVED SUCCESSFULLY");
		return new ViewReferenceCodesPage();
	}
	
}
