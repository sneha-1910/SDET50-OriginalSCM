package com.crm.GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplemenClass implements IRetryAnalyzer {

	int count=0;
	int retryLimit=3;
	
	
	@Override
	public boolean retry(ITestResult result) {
		
		if(count<retryLimit)
		{
			count++;
			return true;
		}
		return false;
	}	
}
