package gov.nv.dwss.nvkids.testcases.proc;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class AddDocumentsAssociatedTestCases extends CommonLocators
{
	@DataProvider(name="nodocuments")
	public static Object[][] fetchnodocs() throws IOException
	{
		return DataLibrary.readExcelData("PROC_AddDocumentAssociated_Test Data",0);
	}
	
	@DataProvider(name="verifydocuments")
	public static Object[][] fetchdocs() throws IOException
	{
		return DataLibrary.readExcelData("PROC_AddDocumentAssociated_Test Data",1);
	}
	
	
	@Test(dataProvider = "nodocuments",priority=11,description = "Navigate to Add Document Associated Screen verify the Add Fields", testName="UIT_PROC_00880_verify the Add Fields")
	public  void ViewAddDocVerifyAddField(String query,String document) throws Exception{
		
		new LoginPage().login().quickNavigation_PROC().navigateToViewDocumentAssociated(query,document).navigateToAddDocumentsAssociatedScreen().VerifyAddField();
	}
	
	@Test(dataProvider = "verifydocuments",priority=12,description = "Navigate to Add Document Associated Screen and Verify Matched data for Required Fields", testName="UIT_PROC_01110_verify Matched data for Required Fields")
	public  void ViewAddDocMatchedDataField(String query,String document,String Query,String documentid) throws Exception
	{
		new LoginPage().login().quickNavigation_PROC().navigateToViewDocumentAssociated(query,document).navigateToAddDocumentsAssociatedScreen().VerifyMatchDataField(Query,documentid);
	}

	@Test(dataProvider = "nodocuments",priority=13,description = "Navigate to Add Document Associated Screen Verify Add More Recipient Field", testName="UIT_PROC_1120_Verify the Add More Recipient Field")
	public  void ViewAddDocVerifyMoreAddReceipient(String query,String document) throws Exception{
		
		new LoginPage().login().quickNavigation_PROC().navigateToViewDocumentAssociated(query,document).navigateToAddDocumentsAssociatedScreen().VerifyMoreAddReceipient();
	}
	
	@Test(dataProvider = "verifydocuments",priority=14,description = "Navigate to Add Document Associated Screen Verify Valid Data Field", testName="UIT_PROC_01220_Verify the Valid Data Field")
	public  void ViewAddDocverifyValid(String query,String document,String Query,String documentid) throws Exception{
		
		new LoginPage().login().quickNavigation_PROC().navigateToViewDocumentAssociated(query,document).navigateToAddDocumentsAssociatedScreen().VerifySaveValidDataField(Query,documentid);
	}

}
