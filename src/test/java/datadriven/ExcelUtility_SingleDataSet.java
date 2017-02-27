package datadriven;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import utilities.Constants;

public class ExcelUtility_SingleDataSet {
	
	private static XSSFWorkbook ExcelWBook;
	private static XSSFSheet ExcelWSheet;
	private static XSSFCell Cell;
	
	public static void setExcelFile(String path, String SheetName) throws IOException
	{
		FileInputStream file = new FileInputStream(path);
		ExcelWBook = new XSSFWorkbook(file);
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
	}
	
	public static String getCellData(int rownum, int colNum) throws Exception 
	{
		String data = null;
		Cell = ExcelWSheet.getRow(rownum).getCell(colNum);
		data = Cell.getStringCellValue();
		
		return data;
	}
	
	public static String getDateCellData(int rownum, int colNum) throws Exception {
		Cell = ExcelWSheet.getRow(rownum).getCell(colNum);
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		Date date = Cell.getDateCellValue();

		return df.format(date);
	}
	
	public static void setCellData(String result, int rownum, int colNum)
			throws Exception {
		
		Cell = ExcelWSheet.getRow(rownum).getCell(colNum);
		if(Cell == null)
		{
			Cell = ExcelWSheet.getRow(rownum).createCell(colNum);
			Cell.setCellValue(result);
		}else
		{
			Cell.setCellValue(result);
		}
		
		FileOutputStream file = new FileOutputStream(Constants.File_Path + Constants.File_Name);
		ExcelWBook.write(file);
		
		file.flush();
		file.close();
	}
	
	public static void setCellData(Double result, int rownum, int colNum)
			throws Exception {
		
		Cell = ExcelWSheet.getRow(rownum).getCell(colNum);
		if(Cell == null)
		{
			Cell = ExcelWSheet.getRow(rownum).createCell(colNum);
			Cell.setCellValue(result);
		}else
		{
			Cell.setCellValue(result);
		}
		
		FileOutputStream file = new FileOutputStream(Constants.File_Path + Constants.File_Name);
		ExcelWBook.write(file);
		
		file.flush();
		file.close();
	}
	

}
