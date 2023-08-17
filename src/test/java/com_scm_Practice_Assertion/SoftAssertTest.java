package com_scm_Practice_Assertion;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {

	 SoftAssert sa=new SoftAssert();
	@Test
	public void softAssert()
	{
		System.out.println("----step1----");
        System.out.println("----step2----");
       
        sa.assertEquals("a", "b", "Values mismatch");
        System.out.println("----step3----");
        sa.fail();
        System.out.println("---step7----");
	}
	

	@Test
	public void Assertnull() 
	{ 
		    System.out.println("----step4----");
		       int a=10;
	          sa.assertNull(a);
	          System.out.println("----step5----");
	          System.out.println("----step6----");	
	}
}
