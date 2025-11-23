package com.orangHRM;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangeHRM.genericLibrary.BaseClass;

public class VerifyTheTitleTest extends BaseClass {
@Test
	
	public void verifyTheTitleTest() {
		
		System.out.println("After Login Title is : "+driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	

}
