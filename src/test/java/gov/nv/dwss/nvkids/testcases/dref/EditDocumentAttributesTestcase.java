package gov.nv.dwss.nvkids.testcases.dref;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class EditDocumentAttributesTestcase extends CommonLocators
{
	@DataProvider(name="getDocumentID")
    public static Object[][] getDocumentID() throws Exception
	{
		return DataLibrary.readExcelData("DREF_Edit Document Attributes_Test Data",0);
	}
	
	@Test(dataProvider = "getDocumentID",testName="UIT_DREF_00770_Navigate to Edit Document Attributes screen function",priority=18,description="Navigates to Edit Document Attributes Information screen function in the DREF Screen when double-clicking the recipient record row in the accordion grid of the View Document Attributes screen function")
	
	public void navigateToEditDocumentAttributes(String query,String documentID,String printMethod,String deliveryMethod) throws Exception 
	{
		new LoginPage().login().quickNavigation_DREF().navigateToEditDREF(query,documentID).verifyFieldsPresent();
	}
	
   
  
   @Test(dataProvider = "getDocumentID",testName="UIT_DREF_00830_Edit with valid Values",priority=19,description="Edit with valid Values")
	
	public void editWithValidValues(String query,String documentID,String printMethod,String deliveryMethod) throws Exception 
	{
		new LoginPage().login().quickNavigation_DREF().navigateToEditDREF(query,documentID).editWithValidValues(printMethod,deliveryMethod);
	}

  
	

}
