package com.scm_Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class writeDataintoExcel {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\SNEHA.xlsx");
		
		
		Workbook book=WorkbookFactory.create(fis);
		
		Sheet sh=book.getSheet("Sheet1");
		
			 Row r=sh.createRow(4);
				
			Cell c=r.createCell(1);
			c.setCellValue("branch");
		 
		
FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\SNEHA.xlsx");
		
	book.write(fos);

	}

}
