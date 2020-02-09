package gov.nv.dwss.nvkids.testcases.proc;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class EditDocumentsAssociatedTestCases extends CommonLocators
{
	@DataProvider(name="validDocuments")
	public static Object[][] fetchdocs() throws IOException
	{
		return DataLibrary.readExcelData("PROC_ViewDocumentAssociated_Test Data",1);
	}
	
	@DataProvider(name="getvaliddata")
    public static Object[][] fetchData() throws Exception
	{
		return DataLibrary.readExcelData("PROC_EditDocumentAssociated_Test Data", 0);
		
	}
	
	@DataProvider(name="getvaliddataForInquiry")
    public static Object[][] fetchDateRange() throws Exception
	{
		return DataLibrary.readExcelData("PROC_EditDocumentAssociated_Test Data", 1);
		
	} 
	
	
	@Test(dataProvider = "validDocuments",priority=15,description = "Navigate to Edit Document Associated Screen verify the Edit Fields", testName="UIT_PROC_01240_verify the Edit Fields")
		public  void ViewEditDocEditField(String query,String documents) throws Exception{
			
			new LoginPage().login().quickNavigation_PROC().navigateToViewDocumentAssociatedScreen(query,documents).navigateToEditDocumentsAssociatedScreen().VerifyEditField();
		}
	
	@Test(dataProvider = "getvaliddata",priority=16,description = "Navigate to Edit Document Associated Screen and Verify Valid data for Required Fields", testName="UIT_PROC_01320_verify Valid data for Required Fields")
	public  void ViewEditDocVerifyValidData(String query,String documents,String print, String delivery) throws Exception
	{
		new LoginPage().login().quickNavigation_PROC().navigateToViewDocumentAssociatedScreen(query,documents).navigateToEditDocumentsAssociatedScreen().VerifyValidData(print,delivery);
	}
	
	@Test(dataProvider = "getvaliddataForInquiry",priority=17,description = "Navigate to Edit Document Associated Screen and Verify Matched data for Required Fields", testName="UIT_PROC_01360_verify Matched data for Required Fields")
	public  void ViewEditDocVerifyMatchedData(String query,String documents,String printMethod, String deliverMethod) throws Exception
	{
		new LoginPage().login().quickNavigation_PROC().navigateToViewDocumentAssociatedScreen(query,documents).navigateToEditDocumentsAssociatedScreen().VerifyMatchDataField(printMethod,deliverMethod);
	}
	
	@Test(dataProvider = "validDocuments",priority=18,description = "Navigate to Edit Document Associated Screen and Verify Add More Recipient Fields", testName="UIT_PROC_01370_verify Add More Recipient Fields")
	public  void ViewEditDocEditMoreReceipient(String query,String documents) throws Exception
	{
		new LoginPage().login().quickNavigation_PROC().navigateToViewDocumentAssociatedScreen(query,documents).navigateToEditDocumentsAssociatedScreen().VerifyAddMoreReceipient();
	}

	@Test(dataProvider = "validDocuments",priority=19,description = "Navigate to Edit Document Associated Screen Verify Edit In Required Field", testName="UIT_PROC_01510_Verify the Edit In Required Field")
	public  void ViewAddDocEditRequired(String query,String documents) throws Exception{
		
		new LoginPage().login().quickNavigation_PROC().navigateToViewDocumentAssociatedScreen(query,documents).navigateToEditDocumentsAssociatedScreen().VerifyEditRequired();
	}
	
	@Test(dataProvider = "validDocuments",priority=20,description = "Navigate to Edit Document Associated Screen Verify Edit Add More In Required Field", testName="UIT_PROC_01530_Verify the Edit Add More In Required Field")
	public  void ViewAddDocEditAddmoreRequiredField(String query,String documents) throws Exception{
		
		new LoginPage().login().quickNavigation_PROC().navigateToViewDocumentAssociatedScreen(query,documents).navigateToEditDocumentsAssociatedScreen().VerifyEditAddmoreRequiredField();
	}
}
