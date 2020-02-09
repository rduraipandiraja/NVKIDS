package gov.nv.dwss.nvkids.pages.smsg;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import gov.nv.dwss.nvkids.selenium.utils.CommonLocators;

public class ViewBroadcastMessagesPage extends CommonLocators {

	public ViewBroadcastMessagesPage() {
		PageFactory.initElements(driver, this);
	}

  /* Select Filter */
	@FindBy(xpath="//label[text()='Created By']") public WebElement elelblCreatedBy;
	@FindBy(id="createdUserName") public WebElement eletxtCreatedBy;
	@FindBy(xpath="//input[@id='createdUserName']/following-sibling::button") public WebElement eleicnlovCreatedBy;
	
	@FindBy(xpath="//label[@aria-label='Broadcast From']") public WebElement elelblBroadcastFrom;
	@FindBy(xpath="//input[@id='startDate']") public WebElement eletxtBroadcastFrom;
	@FindBy(xpath="//input[@id='startDate']/following-sibling::button") public WebElement eleicncalBroadcastFrom;
	//@FindBy(xpath="//label[text()='Broadcast Through']") public WebElement elelblBroadcastThrough;
	@FindBy(xpath="//label[contains(text(),'Broadcast Through')]")public WebElement elelblBroadcastThrough; /*Temp*/
	
	@FindBy(xpath="//input[@id='endDate']") public WebElement eletxtBroadcastThrough;
	@FindBy(xpath="//input[@id='endDate']/following-sibling::button") public WebElement eleicncalBroadcastThrough;
	/*Grid Header ShowFilter */
	@FindBy(xpath="//label[text()=' Title ']") public WebElement elelblShowFilterTitle;
	@FindBy(id="broadcastTitleName") public WebElement eletxtShowFilterTitle;
	@FindBy(xpath="//label[text()=' Description ']") public WebElement elelblShowFilterDescription;
	@FindBy(id="broadcastDesc") public WebElement eletxtShowFilterDescription;
	@FindBy(xpath="//label[text()=' Visible To ']") public WebElement elelblShowFilterVisibleTo;
	@FindBy(id="roleCode") public WebElement eletxtShowFilterVisibleTo;
	@FindBy(xpath="//input[@id='roleCode']/following-sibling::button") public WebElement eleicnlovShowFilterVisibleTo;
	@FindBy(xpath="//label[text()=' Created By ']") public WebElement elelblShowFilterCreatedBy;
	@FindBy(id="createdUserName") public WebElement eletxtShowFilterCreatedBy;
	@FindBy(xpath="//label[text()=' Current Status ']") public WebElement elelblShowFilterCurrentStatus;
	@FindBy(xpath="//input[@id='currentStatusCode']/ancestor::p-dropdown/descendant::label") public WebElement eleddShowFilterCurrentStatus;
	@FindBy(xpath="//label[text()=' Broadcast From ']") public WebElement elelblShowFilterBroadcastFrom;
	@FindBy(id="startDate") public WebElement eledsoShowFilterBroadcastFrom;
	@FindBy(xpath="//th[7][contains(@class,'resizable')]") public WebElement elelblShowFilterBroadcastThrough;
	@FindBy(id="endDate") public WebElement eledsoShowFilterBroadcastThrough;
	


	/* Screen Function */
	@FindBy(xpath="(//span[text()='System Messages'])[2]") public WebElement elelinkSystemMessages;
	
	
	public AddBroadcastMessagesPage navigateToAddBroadcastMessages() throws IOException, InterruptedException
	{   
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.elementToBeClickable(eleicnAdd));
		click(eleicnAdd,"Add Icon");
		return  new AddBroadcastMessagesPage();
	}
   

	public EditBroadcastMessagesPage navigateToEditBroadcastMessages(String query, String fromDate, String throughDate) throws IOException, InterruptedException, ClassNotFoundException, SQLException
	{   
		Thread.sleep(3000);
		click(eleicnFilter,"Filter icon");
		String fDate = formatDate(selectQuery(query, fromDate));
		String tDate = formatDate(selectQuery(query, throughDate));
		
		clearAndType(eletxtBroadcastFrom, "Broadcast From", fDate);
		clearAndType(eletxtBroadcastThrough, "Broadcast Through", tDate);
		eletxtBroadcastThrough.sendKeys(Keys.TAB);
		click(eleicnSearch,"Search Icon");
		Thread.sleep(3000);
		doubleClickGridResult(eleGridResult,"ACTIVE");
		return  new EditBroadcastMessagesPage();
	}
	
	public EditBroadcastMessagesPage NavigateToEditByClickFutureFromDt() throws IOException, InterruptedException
	{   
		Thread.sleep(3000);
		click(eleicnFilter,"Filter Icon");
		setFutureDate(eletxtBroadcastFrom);
		setFutureDate(eletxtBroadcastThrough, 85);
		click(eleicnSearch,"Search Icon");
		Thread.sleep(3000);
		doubleClickGridResult(eleGridResult,"ACTIVE");
		return  new EditBroadcastMessagesPage();
	}
	
	
	
	public ViewBroadcastMessagesPage openSelectFilter() {
		click(eleicnFilter,"Filter Icon");
		return this;
	}
	
	public ViewBroadcastMessagesPage clickSearch() {
		click(eleicnSearch,"Search Icon");
		return this;
	}
	public ViewBroadcastMessagesPage clickClear() {
		click(eleicnClear,"Clear Icon");
		return this;
	}
	public ViewBroadcastMessagesPage enterCreateBy(String data) {
		clearAndType(eletxtCreatedBy, "Created By", data);
		return this;
	}
	public ViewBroadcastMessagesPage selectCreateBy(String data) {
		click(eleicnlovCreatedBy,"Created By LOV");
		clearAndType(eleSearchBarSearch, "Search text Box", data);
		click(eleSearchBarSearch,"Search Icon");
		doubleClickGridResult(eleGridCells, data);
		return this;
	}
	public ViewBroadcastMessagesPage enterBroadcastFrom(String data) {
		clearAndType(eletxtBroadcastFrom, "Broadcast From", data);
		return this;
	}

	public ViewBroadcastMessagesPage enterBroadcastThrough(String data) {
		clearAndType(eletxtBroadcastThrough, "Broadcast Through", data);
		return this;
	}

	

	public ViewBroadcastMessagesPage verifyViewBroadcastMesagesApprearnce() throws Exception{
		verifyDisplayed(eleicnFilter,"Filter Icon");
		verifyGridHeaders(elelblGridHeaders," Title ", " Description "," Created By "," Current Status "," Broadcast From "," Broadcast Through ");
		verifyAssociatedScreens(eleAssociatedScreenList,"Note Processor");
		return this;
	}

	
	
	public  ViewBroadcastMessagesPage verifySelecFilters() throws Exception{
		Thread.sleep(2000);
		click(eleicnFilter,"Filter Icon");
		Thread.sleep(2000);
		
		verifyDisplayed(elelblCreatedBy, "Created By");
		verifyDisplayed(elelblBroadcastFrom, "Broadcast From");
		verifyDisplayed(elelblBroadcastThrough, "Broadcast Through");
		verifyDisplayed(eleicnClear,"Clear Icon");
		verifyDisplayed(eleicnSearch,"Search Icon");

		return this;
	}
	
	
	
	
	public ViewBroadcastMessagesPage inquireValidCreatedBy(String query, String userName,String fromDate, String throughDate) throws InterruptedException, ClassNotFoundException, SQLException {
		openSelectFilter();
		String uName = selectQuery(query, userName);
		enterCreateBy(uName);
		String fDate = formatDate(selectQuery(query, fromDate));
		String tDate = formatDate(selectQuery(query, throughDate));
		enterBroadcastFrom(fDate);
		enterBroadcastThrough(tDate);
		clickSearch();
		Thread.sleep(2500);
		verifyGridResult(eleGridResult,uName);
		return this;
	}
	

	public ViewBroadcastMessagesPage inquireValidDateRange(String query, String userName,String fromDate, String throughDate) throws InterruptedException, ClassNotFoundException, SQLException {
		openSelectFilter();
		String uName = selectQuery(query, userName);
		String fDate = formatDate(selectQuery(query, fromDate));
		String tDate = formatDate(selectQuery(query, throughDate));
		enterCreateBy(uName);
		enterBroadcastFrom(fDate);
		enterBroadcastThrough(tDate);
		clickSearch();
		Thread.sleep(2500);
		return this;
	}
	
	public ViewBroadcastMessagesPage inquireValidTitle(String query, String fromDate, String throughDate, String title) throws InterruptedException, ClassNotFoundException, SQLException {
		openSelectFilter();
		String fDate = formatDate(selectQuery(query, fromDate));
		String tDate = formatDate(selectQuery(query, throughDate));
		String titleName = selectQuery(query, title);
		enterBroadcastFrom(fDate);
		enterBroadcastThrough(tDate);
		clickSearch();
		Thread.sleep(2500);
		selectAllShowColumn(eleicnGridOptions);
		click(eleicnGridOptions,"Grid Options Icon");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options Icon");
		clearAndType(eletxtShowFilterTitle, "Title", titleName);
		pressEnterKey(eletxtShowFilterTitle);
		Thread.sleep(2500);
		verifyGridResult(eleGridResult,titleName);
		return this;
	}
	
	public ViewBroadcastMessagesPage inquireValidDescription(String query, String fromDate, String throughDate, String desc) throws InterruptedException, ClassNotFoundException, SQLException {
		openSelectFilter();
		String fDate = formatDate(selectQuery(query, fromDate));
		String tDate = formatDate(selectQuery(query, throughDate));
		String description = selectQuery(query, desc);
		enterBroadcastFrom(fDate);
		enterBroadcastThrough(tDate);
		clickSearch();
		Thread.sleep(2500);
		selectAllShowColumn(eleicnGridOptions);
		click(eleicnGridOptions,"Grid Options Icon");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options Icon");
		clearAndType(eletxtShowFilterDescription, "Description", description);
		pressEnterKey(eletxtShowFilterDescription);
		Thread.sleep(2500);
		verifyGridResult(eleGridResult,description);
		return this;
	}
	
	public ViewBroadcastMessagesPage inquireValidVisibleTo(String query, String fromDate, String throughDate, String role,String roleCode) throws InterruptedException, ClassNotFoundException, SQLException {
		openSelectFilter();
		String fDate = formatDate(selectQuery(query, fromDate));
		String tDate = formatDate(selectQuery(query, throughDate));
		String roleName = selectQuery(query, role);
		String rCode = selectQuery(query, roleCode);
		enterBroadcastFrom(fDate);
		enterBroadcastThrough(tDate);
		clickSearch();
		Thread.sleep(2500);
		selectAllShowColumn(eleicnGridOptions);
		click(eleicnGridOptions,"Grid Options Icon");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options Icon");
		clearAndType(eletxtShowFilterVisibleTo, "Visible To", rCode);
		pressEnterKey(eletxtShowFilterVisibleTo);
		Thread.sleep(2500);
		verifyGridResult(eleGridResult,roleName);
		return this;
	}
	
	public ViewBroadcastMessagesPage inquireValidSFCreatedBy(String query, String userName , String fromDate, String throughDate) throws InterruptedException, ClassNotFoundException, SQLException {
		openSelectFilter();
		String fDate = formatDate(selectQuery(query, fromDate));
		String tDate = formatDate(selectQuery(query, throughDate));
		String createdBy = selectQuery(query, userName);
		enterBroadcastFrom(fDate);
		enterBroadcastThrough(tDate);
		clickSearch();
		Thread.sleep(2500);
		selectAllShowColumn(eleicnGridOptions);
		click(eleicnGridOptions,"Grid Options Icon");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options Icon");
		clearAndType(eletxtShowFilterCreatedBy, "Created By", createdBy);
		pressEnterKey(eletxtShowFilterCreatedBy);
		Thread.sleep(2500);
		verifyGridResult(eleGridResult,createdBy);
		return this;
	}
	
	public ViewBroadcastMessagesPage selectValidSFStatus(String query, String fromDate, String throughDate, String status) throws InterruptedException, ClassNotFoundException, SQLException {
		openSelectFilter();
		String fDate = formatDate(selectQuery(query, fromDate));
		String tDate = formatDate(selectQuery(query, throughDate));
		String statusValue = selectQuery(query, status);
		enterBroadcastFrom(fDate);
		enterBroadcastThrough(tDate);
		clickSearch();
		Thread.sleep(2500);
		selectAllShowColumn(eleicnGridOptions);
		click(eleicnGridOptions,"Grid Options Icon");
		CheckShowFilters(eleGridShowFilters);
		click(eleicnGridOptions,"Grid Options Icon");
		selectDropdownValue(eleddShowFilterCurrentStatus,statusValue );
		Thread.sleep(2500);
		verifyGridResult(eleGridResult,statusValue);
		return this;
	}
	
	
	
	public ViewBroadcastMessagesPage verifyShowColoumnValues(String query, String userName , String fromDate, String throughDate) throws Exception{
		openSelectFilter();
		String fDate = formatDate(selectQuery(query, fromDate));
		String tDate = formatDate(selectQuery(query, throughDate));
		enterBroadcastFrom(fDate);
		enterBroadcastThrough(tDate);
		clickSearch();
		Thread.sleep(3000);
		verifyShowColumns(eleicnGridOptions,"Title","Description","Visible To","Created By","Current Status","Broadcast From","Broadcast Through");
		return this;
	}

	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


  

}
