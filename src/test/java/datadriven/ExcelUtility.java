package datadriven;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	private static XSSFWorkbook ExcelWBook;
	private static XSSFSheet ExcelWSheet;
	
	public static void setExcelFile(String path, String sheetName) throws Exception
	{
		try{
			
			FileInputStream ExcelFile = new FileInputStream(path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(sheetName);
			
		}catch(Exception e)
		{
			throw(e);
		}
	}
	
	public static String[][] getTestData(String tableName)
	{
		String[][] testData = null;
		
		try{
			XSSFCell[] boundaryCells = findCells(tableName);
			XSSFCell startCell = boundaryCells[0];
			XSSFCell endCell = boundaryCells[1];
			
			int startRow = startCell.getRowIndex() + 1;
			int endRow = endCell.getRowIndex() - 1;
			int startCol = startCell.getColumnIndex() + 1;
			int endCol = endCell.getColumnIndex() - 1;
			
			testData = new String[endRow - startRow + 1][endCol - startCol + 1];
			
			for(int i = startRow; i< endRow + 1 ; i++){
				for(int j = startCol ;j<endCol + 1;j++){
					testData[i-startRow][j-startCol] = ExcelWSheet.getRow(i).getCell(j).getStringCellValue();
					}
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		return testData;
	}
	
	public static XSSFCell[] findCells(String tableName)
	{
		XSSFCell[] cells = new XSSFCell[2];
		String pos = "begin";
		
		for (Row row : ExcelWSheet)
		{
			for(Cell cell : row)
			{
				if((cell.getStringCellValue()).equals(tableName))
						{
							if(pos.equals("begin"))
							{
								cells[0]=(XSSFCell)cell;
								pos = "end";
							}else{
								cells[1]=(XSSFCell)cell;
							}
								
						}
			}
		}
		
		return cells;
	}
}
