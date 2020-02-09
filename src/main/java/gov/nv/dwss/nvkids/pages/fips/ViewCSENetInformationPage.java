package gov.nv.dwss.nvkids.pages.fips;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class ViewCSENetInformationPage extends CommonLocators {
	public ViewCSENetInformationPage() 
	{
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//label[text()='FIPS IV-D Agency Code']") public WebElement elelblFIPSIVDAgencyCode;
	@FindBy(xpath="//input[@id='stateFipsCode']") public WebElement eletxtFIPSIVDAgencyCode;
	@FindBy(xpath="//input[@id='stateFipsCode']/following-sibling::button") public WebElement eleicnlovFIPSIVDAgencyCode;



	/* Screen Function */
	@FindBy(xpath="//span[text()='FIPS Code Information']") public WebElement eleFPSCodeInfoScreen;
	
	public EditCSENetInformationPage navigateToEditCSENetInformation(String query, String agencyCode, String agencyDesc) throws IOException, InterruptedException, ClassNotFoundException, SQLException
	{   
		Thread.sleep(3000);
		click(eleicnFilter, "Filter Icon");
		setFocus(elelblFIPSIVDAgencyCode,eletxtFIPSIVDAgencyCode);
		String agencyCodeValue = selectQuery(query, agencyCode);
		clearAndType(eletxtFIPSIVDAgencyCode, "FIPS IV-D Agency Code", agencyCodeValue);
		click(eleicnSearch,"Search Icon");
		Thread.sleep(3000);
		doubleClickGridResult(eleGridResult,agencyCodeValue);
		return  new EditCSENetInformationPage();
	}
	
	public ViewFIPSInformationPage navigateToViewFIPSInformation() throws IOException, InterruptedException
	{   
		click(eleFPSCodeInfoScreen, "FIPS Code Information screen function");
		return  new ViewFIPSInformationPage();
	}
	
	

	
	
	public void verifyViewCSENetInformation() throws Exception{
		verifyDisplayed(eleicnFilter,"Filter Icond");
		verifyGridHeaders(elelblGridHeaders," State Code ", " State "," Collections "," Quick Locate "," Case Summary Information "," Managing State Cases "," Establishment "," Paternity "," Enforcement ");
		verifyAssociatedScreens(eleAssociatedScreenList,"Note Processor","Intergovernmental Correspondence","Order Wizard");
	}
	
	public  ViewCSENetInformationPage verifySelecFilters() throws Exception{
		Thread.sleep(2000);
		click(eleicnFilter, "Filter Icon");
		Thread.sleep(2000);
		verifyDisplayed(elelblFIPSIVDAgencyCode, "FIPS IV-D Agency Code");
		verifyDisplayed(eleicnClear, "Clear Icon");
		verifyDisplayed(eleicnSearch, "Search Icon");
		
		return this;
	}
	
	

	public ViewCSENetInformationPage inquireValidValue(String query, String agencyCode, String agencyDesc) throws InterruptedException, ClassNotFoundException, SQLException {


		Thread.sleep(3000);
		click(eleicnFilter, "Filter Icon");
		setFocus(eletxtFIPSIVDAgencyCode);
		String agencyCodeValue = selectQuery(query, agencyCode);
		
		clearAndType(eletxtFIPSIVDAgencyCode, "FIPS IV-D Agency Code", agencyCodeValue);
		click(eleicnSearch,"Search Icon");
		Thread.sleep(3000);
		verifyGridResult(eleGridResult,agencyCodeValue);
		return this;


	}
	

	
	public void verifyShowColumnsFIPS() throws Exception{
		Thread.sleep(3000);
		click(eleicnFilter, "Filter Icon");
		setFocus(eletxtFIPSIVDAgencyCode);
		clearAndType(eletxtFIPSIVDAgencyCode, "FIPS IV-D Agency Code", "01");
		click(eleicnSearch,"Search Icon");
		Thread.sleep(3000);
		verifyShowColumns(eleicnGridOptions,"State Code","State","Collections","Quick Locate","Case Summary Information","Managing State Cases","Establishment","Paternity","Enforcement");
	}

	
	

}
