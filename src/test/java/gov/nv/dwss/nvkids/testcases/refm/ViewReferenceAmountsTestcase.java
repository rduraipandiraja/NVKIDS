package gov.nv.dwss.nvkids.testcases.refm;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class ViewReferenceAmountsTestcase  extends CommonLocators
{
	@DataProvider(name="getAmountCode")
    public static Object[][] getPercentageCode() throws Exception
	{
		return DataLibrary.readExcelData("REFM_View Reference Amounts_Test Data",0);
	}
	
	@Test(dataProvider = "getAmountCode",testName = "UIT_REFM_02130_Navigate to View Reference Amounts & Verify",priority=28,description="Navigate to Add Reference Amounts screen function and verify fields present")
	public void navigateToAddReferenceAmounts() throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewReferenceAmounts().verifyGridFields();
	}
	
	@Test(dataProvider = "getAmountCode",testName = "UIT_REFM_02140_Verify Filter Section Fields",priority=29,description="Verify the fields present in the select filters section")
	public void verifyFilterSectionFields() throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewReferenceAmounts().verifyFilterSectionFields();
	}
	
	@Test(dataProvider = "getAmountCode",testName = "UIT_REFM_02190_Verify Successful Inquiry",priority=30,description="Verify Successful Inquiry")
	public void verifySuccessfulInquiry(String amountCode) throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewReferenceAmounts().inquireWithValidValues(amountCode);
	}
	
	@Test(dataProvider = "getAmountCode",testName = "UIT_REFM_02320_Inquire With Amount",priority=31,description="Inquire With grid filter - Amount and verify")
	public void inquireWithAmount(String amountCode) throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewReferenceAmounts().navigatetoAddRevisionReferenceAmounts(amountCode).addRevisionRecords().inquireWithShowFilterAmount();
	}
	
	
	@Test(dataProvider = "getAmountCode",testName = "UIT_REFM_02340_Inquire With Frequency",priority=32,description="Inquire With grid filter - Frequency and verify")
	public void inquireWithFrequency(String amountCode) throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewReferenceAmounts().navigatetoAddRevisionReferenceAmounts(amountCode).addRevisionRecords().inquireWithShowFilterFrequency();
	}
	
		
	@Test(dataProvider = "getAmountCode",testName = "UIT_REFM_02390_Inquire With Begin Date",priority=33,description="Inquire With grid filter - Begin Date and verify")
	public void inquireWithBeginDate(String amountCode) throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewReferenceAmounts().navigatetoAddRevisionReferenceAmounts(amountCode).addRevisionRecords().inquireWithShowFilterBeginDate();
	}
	
		
	@Test(dataProvider = "getAmountCode",testName = "UIT_REFM_02440_Inquire With End Date",priority=34,description="Inquire With grid filter - End Date and verify")
	public void inquireWithEndDate(String amountCode) throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewReferenceAmounts().navigatetoAddRevisionReferenceAmounts(amountCode).addRevisionRecords().inquireWithShowFilterEndDate();
	}
	
		
	@Test(dataProvider = "getAmountCode",testName = "UIT_REFM_02490_Inquire With Updated On",priority=35,description="Inquire With grid filter - Updated On and verify")
	public void inquireWithUpdatedOn(String amountCode) throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewReferenceAmounts().navigatetoAddRevisionReferenceAmounts(amountCode).addRevisionRecords().inquireWithShowFilterUpdatedOn();
	}
	
	@Test(dataProvider = "getAmountCode",testName = "UIT_REFM_02530_Inquire With Updated By",priority=36,description="Inquire With grid filter - Updated By and verify")
	public void inquireWithUpdatedBy(String amountCode) throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewReferenceAmounts().navigatetoAddRevisionReferenceAmounts(amountCode).addRevisionRecords().inquireWithShowFilterUpdatedBy();
	}
	
	@Test(testName = "UIT_REFM_02580_Check Show Columns Options",priority=37,description="Verify that all grid columns are displayed in show columns options")
	public void checkShowColumnsOptions() throws Exception 
	{
		new LoginPage().login().quickNavigation_REFM().navigatetoViewReferenceAmounts().checkShowColumnsOption();
	}
}
