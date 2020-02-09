package gov.nv.dwss.nvkids.pages.refm;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class EditReferenceCodesPage extends CommonLocators
{
	public EditReferenceCodesPage()
	{
		PageFactory.initElements(driver, this);
	}
	
		
	@FindBy(xpath="//label[text()='Reference Entity']") WebElement elelblReferenceEntity;
	@FindBy(id="entityName") WebElement eledsoReferenceEntity;
	@FindBy(xpath="//label[text()='Reference Attribute']") WebElement elelblReferenceAttribute;
	@FindBy(id="attributeName") WebElement eledsoReferenceAttribute;
	@FindBy(xpath="//label[text()='Reference Description']") WebElement elelblReferenceDescription;
	@FindBy(id="attributeDesc") WebElement eledsoReferenceDescription;
	@FindBy(xpath="//label[text()='Code']") WebElement elelblCode;
	@FindBy(id="referenceCode") WebElement eledsoCode;
	@FindBy(xpath="//label[text()='Code Description']") WebElement elelblCodeDescription;
	@FindBy(id="referenceDesc") WebElement eletxtCodeDescription;
	
	@FindAll(
			{
			@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='View Reference Codes']"),
			@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='Edit Reference Codes']")
			}) public WebElement eleComHeaderPanel;
	
	public EditReferenceCodesPage verifyEditReferenceCodeFields() throws Exception
	{
		verifyDisplayed(elelblReferenceEntity,"Reference Entity");
		verifyDisplayed(elelblReferenceAttribute,"Reference Attribute");
		verifyDisplayed(elelblReferenceDescription,"Reference Description");
		verifyDisplayed(elelblCode,"Code");
		verifyDisplayed(elelblCodeDescription,"Code Description");
		return this;
	}
	
		
	public ViewReferenceCodesPage verifyEditWithValidValues() throws Exception
	{
		clearAndType(eletxtCodeDescription,"Code Description",getRandomAlphaChar(7));
		click(eleicnSave, "Save");
		verifyExactText(eleErrStatusBar, "SAVED SUCCESSFULLY");
		return new ViewReferenceCodesPage();
		
	}
}
