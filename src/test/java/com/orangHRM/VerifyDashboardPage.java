package com.orangHRM;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangeHRM.genericLibrary.BaseClass;

public class VerifyDashboardPage extends BaseClass {
	
	@Test
	public void verifyDashboardPage() {
		
		String dashboardText = excelFileUtility.getDataFromExcelFile("OrangeHRM", 1, 0);
		Assert.assertEquals(dashboardText, dashboardPage.getDashboardText().trim());
	}

}
