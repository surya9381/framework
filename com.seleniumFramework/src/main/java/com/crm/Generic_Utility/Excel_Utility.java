package com.crm.Generic_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class Excel_Utility {
	/**
	 * This method is used to fetch the data from excel
	 * @param sheetname
	 * @param rownum
	 * @param celnum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * @author surya
	 * 
	 */
	public String getDataFromExcel(String sheetname,int rownum,int celnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis1=new FileInputStream(ipathConstant.EXCEL_PATH );
		Workbook book=WorkbookFactory.create(fis1);
		Sheet sh=book.getSheet(sheetname);
		Row row=sh.getRow( rownum);
	    Cell cel=row.getCell(celnum);
	    String data=cel.getStringCellValue();
	    return data;
	   /* DataFormatter format=new DataFormatter();
	    
		return format.formatCellValue(book.getSheet("sheetname").getRow(rownum).getCell(celnum)); */
	}

}
