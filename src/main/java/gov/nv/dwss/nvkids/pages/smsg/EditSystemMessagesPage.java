package gov.nv.dwss.nvkids.pages.smsg;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class EditSystemMessagesPage extends CommonLocators

{
	public EditSystemMessagesPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Screen Functions
    @FindBy(xpath="(//span[text()='Edit System Messages'])") WebElement elesfEditSystemMessages;
	
    //Fields
    @FindBy(xpath = "//label[text()='Description']") WebElement elelblDescription;
	@FindBy(id = "errorDesc") WebElement eletxtDescription;
	
	
	@FindBy(xpath = "//div[@class='p-col-12 HeaderHighlight']/div/lib-label-value/div/label") List <WebElement> eleEditInforPanel;
	
	//For Screen Function Name Check
			@FindAll(
					{
						@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='View System Messages']"),
						@FindBy(xpath = "//p-breadcrumb/descendant::a/span[text()='Edit System Messages']")
					}) public WebElement eleComHeaderPanel;
	
	public EditSystemMessagesPage verifyFields() throws Exception
		{
			Thread.sleep(2000);
				
			verifyExactText(elesfEditSystemMessages, "Edit System Messages");
			verifyFieldSetLabels(eleEditInforPanel," Message ID "," Message Type "," Updated By "," Updated On ");
			verifyDisplayed(elelblDescription, "Description");

			verifyDisplayed(eleicnRefresh,"Refresh");
			verifyDisplayed(eleicnSave,"Save");
			verifyDisplayed(eleicnClose,"Close");
			verifyAssociatedScreens(eleAssociatedScreenList,"Note Processor");
				return this;
			}
			

	public  EditSystemMessagesPage editMessages() throws Exception
	{
		Thread.sleep(2000);
		clearValue(eletxtDescription);
		clearAndType(eletxtDescription, "Description", getRandomAlphaChar(20));
		click(eleicnSave,"Save");
	    verifyExactText(eleErrStatusBar, "SAVED SUCCESSFULLY");
		return this;
	}
	
	

}
