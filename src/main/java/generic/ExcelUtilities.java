package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilities {
	
	private String filePath;
	
	public ExcelUtilities(String filePath)
	{
		this.filePath = filePath;
	}
	
	public String readData(String sheetName, int rowNumber, int cellNumber)
	{
		String value = null;
		
		try
		{
			File file = new File(filePath); 
			FileInputStream fis = new FileInputStream(file);
			Workbook workBook = WorkbookFactory.create(fis);
			Sheet sheet = workBook.getSheet(sheetName);
			Row row = sheet.getRow(rowNumber);
			Cell cell = row.getCell(cellNumber);
			
			CellType cellType = cell.getCellType();
			
			switch(cellType)
			{
			case STRING:
				value = cell.getStringCellValue();
				break;
				
			case NUMERIC:
				if(DateUtil.isCellDateFormatted(cell))
				{
					Date date = cell.getDateCellValue();
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					value = sdf.format(date);
				}
				else
				{
					Long numericValue = (long)cell.getNumericCellValue();
					value = numericValue.toString();	
				}
				break;
				
			case BOOLEAN:
				Boolean booleanValue = cell.getBooleanCellValue();
				value = booleanValue.toString();
				break;
				
			default:
				break;
			}
			
		}
		catch(FileNotFoundException fnfEx)
		{
			fnfEx.printStackTrace();
		}
		catch(IOException ioEx)
		{
			ioEx.printStackTrace();
		}
		catch(EncryptedDocumentException edeEx)
		{
			edeEx.printStackTrace();
		}
		
		return value;
	}

}
