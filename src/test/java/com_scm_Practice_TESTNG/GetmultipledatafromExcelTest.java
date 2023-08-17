package com_scm_Practice_TESTNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericUtility.IpathConstants;

public class GetmultipledatafromExcelTest {
      @Test(dataProvider="getDataFromExcel")
      public void fetchData(String S_Id,String S_name,String S_branch,String S_place )
      {
    	System.out.println("S_Id--"+S_Id+  "    S_name---"+S_name+  "    S_branch ---"+S_branch+  "   S_place--- "+S_place);  
      }
      
      
	@DataProvider
	public Object[][] getDataFromExcel() throws Throwable
  {
		FileInputStream fis = new FileInputStream(IpathConstants.Excelpath);
       Workbook book = WorkbookFactory.create(fis);
       Sheet sh=book.getSheet("DataProvider");
       int LastRow=sh.getLastRowNum();
       int LastCell=sh.getRow(0).getLastCellNum();
       
       Object[][] obj=new Object[LastRow+1][LastCell];
       for (int i = 0; i <=LastRow ; i++) 
       {
		for (int j = 0; j < LastCell; j++) 
		{
		 obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();	
		}
	}
    	return obj;	   
       
  }
	















}
