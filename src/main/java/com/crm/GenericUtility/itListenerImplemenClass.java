package com.crm.GenericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class itListenerImplemenClass implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		EventFiringWebDriver eDriver=new EventFiringWebDriver(BaseClass_TESTNG.sdriver);
	//	TakeScreenShot tss=(TakeScreenShot)BaseClass_TESTNG.sdriver;//both are ok
		File src=eDriver.getScreenshotAs(OutputType.FILE);
		File dst=new File("./Screenshot/FailedScript.png");
		try {
			FileUtils.copyFile(src, dst);
			
	} 	
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}

	
	
}
