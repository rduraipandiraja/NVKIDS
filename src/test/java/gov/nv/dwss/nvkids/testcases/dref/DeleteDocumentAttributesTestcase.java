package gov.nv.dwss.nvkids.testcases.dref;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class DeleteDocumentAttributesTestcase extends CommonLocators
{
	
	@DataProvider(name="getDocumentID")
    public static Object[][] getDocumentID() throws Exception
	{
		return DataLibrary.readExcelData("DREF_Delete Document Attributes_Test Data",0);
	}
	
	@Test(dataProvider = "getDocumentID",testName="UIT_DREF_00920_Delete a record with confirmation Yes",priority=20,description="Click the YES icon on confirmation pop-up to delete the record.")
	public void verifyDeleteConfirmationYes(String query, String documentID ) throws Exception 
	{
			new LoginPage().login().quickNavigation_DREF().verifyDeleteConfirmationYes(query,documentID);
	
	}
	
}
