package com_scm_Practice_TESTNG;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericUtility.IpathConstants;

public class DataProvider_project_Test {

	         @Test(dataProvider = "getDataFromExcel")
		   public void fetchData1(String content,String datails )
		      {
		    	System.out.println("M--"+content+  "   M_details--"+datails);  
		      }
		      
		      
			@DataProvider
			public Object[][] getDataFromExcel() throws Throwable
		  {
				FileInputStream fis = new FileInputStream(IpathConstants.Excelpath);
		       Workbook book = WorkbookFactory.create(fis);
		       Sheet sh=book.getSheet("addmanufact");
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


