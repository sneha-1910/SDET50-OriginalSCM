package com.crm.GenericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class iListernerImplement_ExtendReport_Class implements ITestListener{

	ExtentReports report ;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		test=report.createTest(MethodName);
		Reporter.log(MethodName+" Test Execution started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
	    test.log(Status.PASS, MethodName+"Passed");
	    Reporter.log(MethodName+"---->TestScript passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//JavaUtility jLib=new JavaUtility();
		
		String FScript=result.getMethod().getMethodName();
	
		String FailedScript=FScript+new JavaUtility().getSystemDateFormat();
		
		EventFiringWebDriver eDriver=new EventFiringWebDriver(BaseClass_TESTNG.sdriver);
		File src=eDriver.getScreenshotAs(OutputType.FILE);
		File dst=new File("./Screenshot/"+FailedScript+".png");
		try {
			FileUtils.copyFile(src, dst);
			
	} 	
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		test.log(Status.FAIL,FScript+"---->failed testscript");
		test.log(Status.FAIL, result.getThrowable());
		Reporter.log(FScript+"----->TestScript Failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+"--->Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(MethodName+"---->TestScript Skipped");
		
		
	}

	@Override
	public void onStart(ITestContext context) {
	
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./ExtentReport/report.html");
		htmlreport.config().setDocumentTitle("SDET50");
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setReportName("SCM");
		
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("Base-url", "http://localhost:8888");
		report.setSystemInfo("reporter Name", "Sneha");
		
	
	}

	@Override
	public void onFinish(ITestContext context) {
		//consolidate the report
		report.flush();
		
		
	}

	
	
}
