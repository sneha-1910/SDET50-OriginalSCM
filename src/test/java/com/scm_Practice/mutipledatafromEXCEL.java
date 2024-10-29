 package com.scm_Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class mutipledatafromEXCEL {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
     FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\SNEHA.xlsx");
		
		
		Workbook book=WorkbookFactory.create(fis);
		
		Sheet sh=book.getSheet("addretailer");
		int l=sh.getLastRowNum();
		Row r=sh.getRow(0);
		//short m = r.getLastCellNum();
		for(int i = 0;i<=sh.getLastRowNum();i++)
		{	
			for(int j=0;j<=r.getLastCellNum()-1;j++)
			{
				
	
	String value = sh.getRow(i).getCell(j).toString();
				System.out.println(value);
			}
		}
				book.close();
		
	}

}
