package gov.nv.dwss.nvkids.selenium.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.nv.dwss.nvkids.selenium.api.base.SeleniumBase;



public class CommonLocators extends SeleniumBase
{
	public CommonLocators()
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[@title='Quick Navigation']") public WebElement eleQuickNavigation;
	//@FindBy(xpath = "(//input[@type='text'])[2]") public WebElement eletxtQuickNavigationText;
	@FindBy(id="screenName") public WebElement eletxtQuickNavigationText;
	
	
	@FindBy(xpath="//div[contains(@class,'errorBaner')]/div") public WebElement eleErrStatusBar;
	//@FindBy(xpath="//div[contains(@class,'errorContainer')]/div") public WebElement eleErrStatusBar;
	@FindBy(xpath="//div[contains(@class,'errorContainer')]") public WebElement eleStatusBar;
	@FindBy(xpath="//span[text()='View Error Details']") public WebElement eleErrorDetailsLink;
	@FindBy(xpath="//a[contains(@class,'selectFilter')]") public WebElement eleicnFilter;
	@FindBy(xpath="//div[@class='btn-container']//span[text()='Search']") public WebElement eleicnSearch;
	@FindBy(xpath="//span[text()='Clear']") public WebElement eleicnClear;
	@FindBy(xpath="//span[text()='Refresh']/parent::button") public WebElement eleicnRefresh;
	@FindBy(xpath="//span[text()='Save']/parent::button") public WebElement eleicnSave;
	@FindBy(xpath="//span[text()='ui-btn']/preceding-sibling::span[@class='fa fa-close ui-clickable ui-button-icon-left ng-star-inserted']") public WebElement eleicnClose;
	//@FindBy(xpath = "//lib-button/descendant::button/span[contains(@class,'close')]") public WebElement eleicnClose;
	@FindBy(xpath="//span[text()='Add']/parent::button") public WebElement eleicnAdd;
	@FindBy(xpath="//span[text()='Edit']/parent::button") public WebElement eleicnEdit;
	@FindBy(xpath="(//i[@class='pi pi-chevron-down'])[1]") public WebElement eleicnOpenAccordion;
	@FindBy(xpath="//i[@class='pi pi-chevron-up'][1]") public WebElement eleicnCloseAccordion;
	@FindBy(xpath="//span[@title='Grid Options']") public  WebElement eleicnGridOptions;
	@FindBy(xpath="(//span[@title='Grid Options'])[2]") public WebElement eleicnAccGridOptions;
	@FindBy(xpath="//span[@title='Reset Filter']") public WebElement eleicnResetFilter;
	@FindBy(xpath="//*[@disabled]") public List<WebElement> eleDisabledFields;
	@FindBy(xpath="//tbody//tr[not(contains(@class,'emptyRow'))][1]") public WebElement eleGridRecord;
	
	
	
	@FindBy(xpath="//div[@class='ui-overlaypanel-content']/div[contains(@class,'filterItems')]") public List<WebElement> eleGridOptionsList;
	
	@FindBy(xpath="//span[text()='Show Columns ']") public WebElement eleicnShowColumns;
	
	/* Associated screen list webelement*/
	@FindBy(xpath="//li[contains(@class,'associatedMenuItem ')]/a/span[2]") public  List<WebElement> eleAssociatedScreenList;
	 
	
	// Search pop up
	@FindBy(xpath="//div[contains(@class,'ui-dialog-titlebar')]/span") public WebElement eleSearchBarTitle;
	@FindBy(xpath="//div[contains(@class,'ui-dialog-titlebar')]/descendant::span[contains(@class,'times')]") public WebElement eleSearchBarClose;
	@FindBy(xpath="//div[contains(@class,'ui-dialog-titlebar')]/descendant::span[contains(@class,'window-maximize')]") public WebElement eleSearchBarMaximize;
	@FindBy(xpath="//div[contains(@class,'ui-dialog-content')]/descendant::input") public WebElement eleSearchBarSearch;
	@FindBy(xpath="//div[contains(@class,'ui-dialog-content')]/descendant::button/span") public WebElement eleSearchBarSearchButton;
	@FindBy(xpath="//div[contains(@class,'ui-dialog-content')]/descendant::tbody") public WebElement eleGridCells;
	
	@FindBy(xpath="//div[contains(@class,'ui-dialog-content')]/descendant::p-paginator/descendant::a")  public List<WebElement> elePaginationControls;
	
	//Date Picker
	@FindBy(xpath="//table[@class='ui-datepicker-calendar']/descendant::td[contains(@class,'today')]/a") public WebElement eleDatePickerCurrentDate;

	
	
	// Grid 
	@FindBy(xpath="//p-paginator/descendant::a") public List<WebElement> elePaginatorGrid;
	@FindBy(xpath="//p-paginator/descendant::a[contains(@class,'first')]") public WebElement eleicnFirstPagination;
	@FindBy(xpath="//p-paginator/descendant::a[contains(@class,'prev')]") public WebElement eleicnPrevPagination;
	@FindBy(xpath="//p-paginator/descendant::a[contains(@class,'next')]") public WebElement eleicnNextPagination;
	@FindBy(xpath="//p-paginator/descendant::a[contains(@class,'last')]") public WebElement eleicnLastPagination;
		  
	@FindBy(xpath="//tr[@class='ng-star-inserted']/th[not(contains(@class,'accordion-col'))]") public List<WebElement> elelblGridHeaders;
	@FindBy(xpath="(//thead[@class='ui-table-thead'])[2]/tr[1]/descendant::label/parent::th") public List<WebElement> elelblInnerGridHeaders;
	
	
	
	@FindBy(xpath="//tr[@class='ng-star-inserted']/following::tbody") public WebElement eleGridResult;
	/* Grid show Filters */
	@FindBy(xpath="//div[@class='ui-overlaypanel-content']/div[contains(@class,'filterItems')]/p-checkbox/label") public WebElement eleGridShowFilters;
	@FindBy(xpath="//div[@class='ui-overlaypanel-content']/div[contains(@class,'filterItems')]/span[contains(text(),'Reset Filter')]") public WebElement eleGridResetFilters;
	
	@FindBy(xpath="//div[@class='ui-overlaypanel-content']/div[contains(@class,'filterItems')]/span[contains(text(),'Show Columns')]") public WebElement eleGridShowColumns;
	
	
	// Confirmation Popup:
	
	@FindBy(xpath = "//lib-confirm-dialog/descendant::a[contains(@class,'close')]") public WebElement eleicnPopUpClose;
	@FindBy(xpath = "//div[contains(@class,'confirmDialog')]/descendant::lib-label/div") public WebElement eleinfPopUp;
	@FindBy(xpath = "//span[contains(text(),'Confirmation')]") public WebElement eleCnfPopUpTitle;
	@FindBy(xpath = "//span[contains(text(),'Yes')]") public WebElement eleicnPopUpYes;
	@FindBy(xpath = "//span[@class='ui-button-text ui-clickable'][contains(text(),'No')]") public WebElement eleicnPopUpNo;
	@FindBy(xpath="//ul[contains(@class,'autocomplete')]/descendant::div") public List<WebElement> elelistAutoFill;
	
	
		   
	
	
	
	
}
