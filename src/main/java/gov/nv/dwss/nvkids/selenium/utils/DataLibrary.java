package gov.nv.dwss.nvkids.selenium.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataLibrary {

	public static Object[][] readExcelData(String excelfileName , int sheetNo) throws IOException {
		
		DataFormatter formatter = new DataFormatter();
		XSSFWorkbook wbook = 
				new XSSFWorkbook("./data/"+excelfileName+".xlsx");
		XSSFSheet sheet = wbook.getSheetAt(sheetNo);
		int rowCount = sheet.getLastRowNum();
		System.out.println("Row Count is: "+rowCount);
		int colCount = sheet.getRow(0).getLastCellNum();
		System.out.println("Col Count is: "+colCount);
		Object[][] data = new Object[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < colCount; j++) {
				XSSFCell cell = row.getCell(j);
				String stringCellValue = formatter.formatCellValue(cell);

				data[i-1][j] = stringCellValue;
				System.out.println(stringCellValue);
			} 
		}
		return data;
	}
	
	
	public static Object[][] readExcelRowData(String excelfileName , int sheetNo , int rowNo) throws IOException {
		
		DataFormatter formatter = new DataFormatter();
		XSSFWorkbook wbook = 
				new XSSFWorkbook("./data/"+excelfileName+".xlsx");
		XSSFSheet sheet = wbook.getSheetAt(sheetNo);
	
		int colCount = sheet.getRow(rowNo).getLastCellNum();
		System.out.println("Col Count is: "+colCount);
		Object[][] data = new Object[rowNo][colCount];
		
			XSSFRow row = sheet.getRow(rowNo);
			for (int j = 0; j < colCount; j++) {
				XSSFCell cell = row.getCell(j);
				
				String stringCellValue = formatter.formatCellValue(cell);
				data[0][j] = stringCellValue;
				System.out.println(stringCellValue);
			} 
		
		return data;
	}	
	
	
	
	
	
public String readCelldata(String excelfileName, int Sheetno, int rowno, int colno) throws IOException {
		
		System.out.println("ENTERED READ EXCEL");
		DataFormatter formatter = new DataFormatter();
		XSSFWorkbook wbook = 
				new XSSFWorkbook("./data/"+excelfileName+".xlsx");
				
		XSSFSheet sheet = wbook.getSheetAt(Sheetno);
		int rowCount = sheet.getLastRowNum();
		System.out.println("Row Count is: "+rowCount);
		int colCount = sheet.getRow(1).getLastCellNum();
		System.out.println("---------------------");
		System.out.println("Col Count is: "+colCount);
	
			XSSFRow row = sheet.getRow(rowno);
			XSSFCell cell = row.getCell(colno);
			String stringCellValue = formatter.formatCellValue(cell);
				System.out.println(stringCellValue);
				return stringCellValue;
								
			
		
	}

public static class ExcelUtils 
{
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;

	//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method

	public static void setExcelFile(String Path,String SheetName) throws Exception 
	{
		try 
		{
			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(Path);
			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		} 
		catch (Exception e)
		{
			throw (e);
		}
	}

	public static Object[][] getTableArray(String FilePath, String SheetName, int iTestCaseRow)    throws Exception
	{   
		String[][] tabArray = null;
		try
		{
			FileInputStream ExcelFile = new FileInputStream(FilePath);
			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			XSSFRow row = ExcelWSheet.getRow(iTestCaseRow);
			short totalColumns = row.getLastCellNum();
			int startCol = 1;
			int ci=0,cj=0;
			int totalRows = 1;
			//int totalCols = 2;
			tabArray=new String[totalRows][totalColumns];
			for (int j=startCol;j<=totalColumns;j++, cj++)
			{
				tabArray[ci][cj]=getCellData(iTestCaseRow,j);
				System.out.println(tabArray[ci][cj]);
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}
		catch (IOException e)
		{
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}
		return(tabArray);
	}

	//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num

	public static String getCellData(int RowNum, int ColNum) throws Exception
	{
		try
		{
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
		}
		catch (Exception e)
		{
			return"";
		}
	}

	public static int getRowContains(String sTestCaseName, int colNum) throws Exception
	{
		int i;
		try 
		{
			int rowCount = ExcelUtils.getRowUsed();
			for ( i=0 ; i<rowCount; i++)
			{
				if  (ExcelUtils.getCellData(i,colNum).equalsIgnoreCase(sTestCaseName)){
					break;
				}
			}
			return i;
		}
		catch (Exception e)
		{
			throw(e);
		}
	}

	public static int getRowUsed() throws Exception 
	{
		try
		{
			int RowCount = ExcelWSheet.getLastRowNum();
			return RowCount;
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			throw (e);
		}
	}
}
}







