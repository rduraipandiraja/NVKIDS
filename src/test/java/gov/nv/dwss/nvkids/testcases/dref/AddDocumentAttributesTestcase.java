package gov.nv.dwss.nvkids.testcases.dref;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class AddDocumentAttributesTestcase extends CommonLocators
{
	@DataProvider(name="getDocumentID")
    public static Object[][] getDocumentID() throws Exception
	{
		return DataLibrary.readExcelData("DREF_Add Document Attributes_Test Data",0);
	}
	
	@DataProvider(name="getDocumentIDWithoutCC")
    public static Object[][] getDocumentIDWithoutCC() throws Exception
	{
		return DataLibrary.readExcelData("DREF_Add Document Attributes_Test Data",1);
	}
	
@Test(dataProvider = "getDocumentID",testName="UIT_DREF_00570_Navigate to Add Document Attributes screen function",priority=16,description="Navigate to Add Document Attributes screen function")
	
public void navigateToAddDocumentAttributes(String query,String documentID) throws Exception 
{
	new LoginPage().login().quickNavigation_DREF().navigateToAddDREF(query,documentID).verifyFieldsPresent();
}

@Test(dataProvider = "getDocumentIDWithoutCC",testName="UIT_DREF_00690_Add with valid values",priority=17,description="Pressing Save icon with valid values in all required fields displays a successful message.")

public void addWithValidValues(String query,String documentID,String recipientType) throws Exception 
{
	new LoginPage().login().quickNavigation_DREF().navigateToAddDREFWithoutReceipientCC(query,documentID).addWithValidValues(recipientType);
}

}
