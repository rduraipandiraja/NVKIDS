package gov.nv.dwss.nvkids.testcases.inex;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.nv.dwss.nvkids.pages.login.LoginPage;
import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;
import gov.nv.dwss.nvkids.selenium.utils.DataLibrary;

public class ViewOtherIncomeInformationTestCases extends CommonLocators
{
	
	@DataProvider(name="viewotherincome")
	public static Object[][] verifyrecord() throws IOException
	{
		return DataLibrary.readExcelData("INEX_View other Information_Test Data",0);
	}


	@Test(priority=1,description = "Navigate to INEX screen using Quick Navigation and verify field appearance", testName="UIT_INEX_00010_Quick Navigation to INEX")
	public  void verifyViewAHISInformationScreen() throws Exception{
		new LoginPage().login().quickNavigation_INEX().InquireScreen();
	}
	
	@Test(priority=2,description = " Select Filters popup displays  Filter fields by clicking  Filter icon",testName="UIT_INEX_00080_Verify Select Filters Fields")
	public  void verifySelecFilters() throws Exception{
		new LoginPage().login().quickNavigation_INEX().InquireFilter();
	}
	
	@Test(dataProvider ="viewotherincome",priority=3,description = "verify  Grid Records in view Other Income Information Page", testName="UIT_INEX_00140_verify Grid Records")
	public void InquireGridResult(String query,String participantid) throws Exception{
		new LoginPage().login().quickNavigation_INEX().InquireGridData(query,participantid);
	}
	
	@Test(priority=4,description = "verify ShowColumns in view Other Income Information Page", testName="UIT_INEX_00430_verify ShowColumns")
	public void InquireShowColumn() throws Exception{
		new LoginPage().login().quickNavigation_INEX().verifyShowColumn();
	}
	
}
