package com.orangHRM;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangeHRM.genericLibrary.BaseClass;

public class VerifyDashboardPageTest extends BaseClass {
	
	@Test
	public void verifyDashboardPageTest() {
		
		String dashboardText = excelFileUtility.getDataFromExcelFile("OrangeHRM", 1, 0);
		System.out.println(dashboardPage.getDashboardText());
		Assert.assertEquals(dashboardText, dashboardPage.getDashboardText());
	}

}
