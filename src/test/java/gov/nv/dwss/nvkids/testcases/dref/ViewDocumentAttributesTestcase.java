package gov.nv.dwss.nvkids.testcases.dref;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class ViewDocumentAttributesTestcase extends CommonLocators

{
	
	@DataProvider(name="getDocumentID")
    public static Object[][] getDocumentID() throws Exception
	{
		return DataLibrary.readExcelData("DREF_View Document Attributes_Test Data",0);
	}
	
	@DataProvider(name="getDocumentName")
    public static Object[][] getDocumentName() throws Exception
	{
		return DataLibrary.readExcelData("DREF_View Document Attributes_Test Data",1);
	}
	
	@DataProvider(name="selectCategory")
    public static Object[][] selectCategory() throws Exception
	{
		return DataLibrary.readExcelData("DREF_View Document Attributes_Test Data",2);
	}
	
	@DataProvider(name="selectType")
    public static Object[][] selectType() throws Exception
	{
		return DataLibrary.readExcelData("DREF_View Document Attributes_Test Data",3);
	}
	
	@DataProvider(name="selectCategoryCode")
    public static Object[][] selectCategoryCode() throws Exception
	{
		return DataLibrary.readExcelData("DREF_View Document Attributes_Test Data",4);
	}
	
	@DataProvider(name="selectNoticeCode")
    public static Object[][] selectNoticeCode() throws Exception
	{
		return DataLibrary.readExcelData("DREF_View Document Attributes_Test Data",5);
	}
	
	
	@Test(testName="UIT_DREF_00010 - Navigate to DREF screen",priority=1,description="Entering the screen acronym DREF in the Quick Navigation pop-up, navigates to the DREF screen.")
	public void navigateToViewDocumentAttributes() throws Exception 
	{
			new LoginPage().login().quickNavigation_DREF().verifyFieldsPresent();
	}
		
 @Test(testName="UIT_DREF_00070 - View Filter Fields",priority=2,description="The Select Filters pop-up displays the Filter fields by click the Filter icon at the top right corner of the screen.")
	public void verifyFilterFields() throws Exception 
	{
	   new LoginPage().login().quickNavigation_DREF().verifyFilterFields();
	}
   
@Test(dataProvider = "getDocumentID",testName="UIT_DREF_000110 - Inquiry with a Document ID that exist in NVKIDS in the DOCUMENT ID field in the Select Filters pop-up",priority=3,description="On inquiring with a Participant ID that  exist in NVKIDS in the DOCUMENT ID field in the Select Filters pop-up, the system displays an error message.")
	public void inquireValidValuesDocumentID(String query,String documentID) throws Exception 
	{
			new LoginPage().login().quickNavigation_DREF().inquireValidValuesDocumentID(query,documentID);
	}
 
@Test(dataProvider = "getDocumentName",testName="UIT_DREF_000160_Testing the DOCUMENT NAME Search Exact Option drop-down",priority=4,description="Testing the DOCUMENT NAME Search Exact Option drop-down")
	public void enterDocumentNameExact(String query,String documentName) throws Exception 
	{
			new LoginPage().login().quickNavigation_DREF().enterDocumentNameExact(query,documentName);
	}
 
@Test(dataProvider = "selectCategory",testName="UIT_DREF_000190_Inquire with CATEGORY",priority=5,description="Inquire with CATEGORY ")
	public void selectCategory(String query,String selectCategory) throws Exception 
	{
			new LoginPage().login().quickNavigation_DREF().selectCategory(query,selectCategory);
	}
@Test(dataProvider = "selectType",testName="UIT_DREF_000200_Inquire with TYPE",priority=6,description="Inquire with TYPE")
	public void selectType(String query,String selectType) throws Exception 
	{
			new LoginPage().login().quickNavigation_DREF().selectType(query,selectType);
	}

@Test(dataProvider = "getDocumentID",testName="UIT_DREF_000270_Filter the grid records with DOCUMENT ID Show Filters field in the grid",priority=7,description="On filtering the grid records by entering a Document ID which has records in the DOCUMENT ID field, the grid displays the records associated with the Document ID entered.")
public void inquireValidValuesShowFiltersDocumentID(String query,String documentID) throws Exception 
{
		new LoginPage().login().quickNavigation_DREF().inquireValidValuesShowFiltersDocumentID(query,documentID);	
}	

@Test(dataProvider = "getDocumentName",testName="UIT_DREF_000300_Filter the grid records with DOCUMENT NAME Show Filters field in the grid",priority=8,description="On filtering the grid records by entering a Document ID which has records in the DOCUMENT NAME field, the grid displays the records associated with the Document ID entered.")
public void enterShowFiltersDocumentName(String query,String documentName) throws Exception 
{
		new LoginPage().login().quickNavigation_DREF().enterShowFiltersDocumentName(query,documentName);
}	

@Test(dataProvider = "selectCategoryCode",testName="UIT_DREF_000310_Filter the grid records with CATEGORY CODE Show Filters field in the grid",priority=9,description="On filtering the grid records by selecting a Category Code from the CATEGORY CODE drop-down, which has records in the CATEGORY CODE field, the grid displays the records associated with the selected Category Code.")
public void selectShowFilterCategoryCode(String query,String selectCategoryCode) throws Exception 
{
		new LoginPage().login().quickNavigation_DREF().selectShowFilterCategoryCode(query,selectCategoryCode);
}	

@Test(dataProvider = "selectCategory",testName="UIT_DREF_000320_Filter the grid records with CATEGORY Show Filters field in the grid",priority=10,description="On filtering the grid records by selecting a Category from the CATEGORY drop-down, which has records in the CATEGORY field, the grid displays the records associated with the selected Category.")
public void selectShowFilterCategory(String query,String selectCategory) throws Exception 
{
		new LoginPage().login().quickNavigation_DREF().selectShowFilterCategory(query,selectCategory);
}	

@Test(dataProvider="selectNoticeCode",testName="UIT_DREF_000330_Filter the grid records with NOTICE TYPE CODE Show Filters field in the grid",priority=11,description="On filtering the grid records by selecting a Notice Type Code from the NOTICE TYPE CODE drop-down, which has records in the NOTICE TYPE CODE field, the grid displays the records associated with the selected Notice Type Code.")
public void selectShowFilterNoticeTypeCode(String query,String selectNoticeCode) throws Exception 
{
		new LoginPage().login().quickNavigation_DREF().selectShowFilterNoticeTypeCode(query,selectNoticeCode);
}	

@Test(dataProvider="selectType",testName="UIT_DREF_000340_Filter the grid records with TYPE Show Filters field in the grid",priority=12,description="On filtering the grid records by selecting a Type from the TYPE drop-down, which has records in the TYPE field, the grid displays the records associated with the selected Type.")
public void selectShowFilterType(String query,String selectType) throws Exception 
{
		new LoginPage().login().quickNavigation_DREF().selectShowFilterType(query,selectType);
}	


@Test(testName="UIT_DREF_000390_Test Show Columns in the Grid Options to view the list of columnss ",priority=13,description="Clicking on the Show Columns from Grid Options views all the columns in the grid header.")
public void verifyShowColumns() throws Exception 
{
		new LoginPage().login().quickNavigation_DREF().verifyShowColumns();
}


@Test(testName="UIT_DREF_00450_Veirfy Accordion Headers Grid",priority=14,description="Verify Accordion Headers Grid")
public void verifyAccordionGridHeaders() throws Exception 
{
		new LoginPage().login().quickNavigation_DREF().verifyAccordionGridHeaders();
}


@Test(testName="UIT_DREF_00510_Test Show Columns - Accordion Grid",priority=15,description="Test Show Columns - Accordion Grid")
public void verifyShowColumnsAccordion() throws Exception 
{
		new LoginPage().login().quickNavigation_DREF().verifyShowColumnsAccordion();
}


}
