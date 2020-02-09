package gov.nv.dwss.nvkids.testcases.proc;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class ViewDocumentsAssociatedTestCases extends CommonLocators
{
	@DataProvider(name="ZeroDocument")
	public static Object[][] fetchzerodocs() throws IOException
	{
		return DataLibrary.readExcelData("PROC_ViewDocumentAssociated_Test Data",0);
	}
	
	@DataProvider(name="validDocuments")
	public static Object[][] fetchdocs() throws IOException
	{
		return DataLibrary.readExcelData("PROC_ViewDocumentAssociated_Test Data",1);
	}
	
	@DataProvider(name="addDocuments")
	public static Object[][] fetchadddocs() throws IOException
	{
		return DataLibrary.readExcelData("PROC_ViewDocumentAssociated_Test Data",2);
	}
	
	@Test(priority=5,dataProvider = "ZeroDocument",description = "Navigate to the PROC screen verify the grid result and navigate to view doc associated screen without Record", testName="UIT_PROC_00560_Navigate to View Document Associated without Record")
	public  void ViewDocAssociatedwithoutrecord(String query,String document) throws Exception{
		
		new LoginPage().login().quickNavigation_PROC().navigateToViewDocumentAssociated(query,document).verifyWithoutRecord();
	}
	@Test(priority=6,dataProvider = "validDocuments",description = "Navigate to the PROC screen verify the grid result and navigate to view doc associated screen with Record", testName="UIT_PROC_00570_Navigate to View Document Associated with Record")
	public  void ViewDocAssociatedwithrecord(String query,String documents) throws Exception{
		
		new LoginPage().login().quickNavigation_PROC().navigateToViewDocumentAssociatedScreen(query,documents).verifyWithRecord();
	}
	@Test(priority=7,dataProvider = "validDocuments",description = "Navigate to the PROC screen verify the grid result and navigate to view doc associated screen verify the Inner Grid Headers ", testName="UIT_PROC_00580_Navigate to View Document Associated verify the Inner Grid Headers")
	public  void ViewDocAssociatedverifyInnerField(String query,String documents) throws Exception{
		
		new LoginPage().login().quickNavigation_PROC().navigateToViewDocumentAssociatedScreen(query,documents).verifyInnerField();
	}
	@Test(priority=8,dataProvider = "validDocuments",description = "Navigate to the PROC screen verify the grid result and navigate to view doc associated screen verify the Grid Options ", testName="UIT_PROC_00590_Navigate to View Document Associated verify the Grid Options")
	public  void ViewDocAssociatedverifyGridOptions(String query,String documents) throws Exception{
		
		new LoginPage().login().quickNavigation_PROC().navigateToViewDocumentAssociatedScreen(query,documents).verifyGridOptions();
	}
	
	@Test(priority=9,dataProvider = "addDocuments",description="Navigate to View Document Associated and Click Delete the Multiple Record and verify the Confirmation Yes Icon PopUp ",testName="UIT_PROC_00810_Verify Delete Multiple Record and Confirmation Yes Icon PopUp")
	public void verifyConfirYesMultipleRecord(String query,String documents,String Query,String documentid) throws Exception 
	{
		new LoginPage().login().quickNavigation_PROC().navigateToViewDocumentAssociatedScreen(query,documents).navigateToAddDocumentsAssociatedScreen().adddocs(Query,documentid).adddata(Query,documentid).verifyMultipleRecConYesIcon();
	}
	
	@Test(priority=10,dataProvider = "validDocuments",description="Navigate to View Document Associated and Click Accordion Delete the Multiple Record and verify the Confirmation Yes Icon PopUp ",testName="UIT_PROC_00860_Verify Delete Accordion Multiple Record and Confirmation Yes Icon PopUp")
	public void verifyAccordianYesMultipleRecord(String query,String documents) throws Exception 
	{
		new LoginPage().login().quickNavigation_PROC().navigateToViewDocumentAssociatedScreen(query,documents).navigateToEditDocumentsAssociatedScreen().Addmoredata().verifyAccordianMulRecordYesIcon();
	}
	
}
