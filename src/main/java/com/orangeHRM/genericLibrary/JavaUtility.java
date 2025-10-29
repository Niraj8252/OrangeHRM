package com.orangeHRM.genericLibrary;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
/**
 * This class is contains java specific methods
 */
public class JavaUtility {
	/**
	 * This method is used to convert String value to long data type
	 * @param value
	 * @return
	 */
	public long stringConvertToLong(String value)
	{
		return Long.parseLong(value);
	}

	/**
	 * This method is used to generate random number
	 * @param limit
	 * @return
	 */
	public int generateRandomNum(int limit)
	{
		Random r = new Random();
		return r.nextInt(limit);
	}
	
	/**
	 * This method is used to generate random string
	 * @param limit
	 * @return
	 */
	public String generateRandomString(int limit) {
		String generatedString =	RandomStringUtils.randomAlphabetic(limit);
		return generatedString;
	}

	/**
	 * This method is used to validate the TestCase
	 * @param actualResult
	 * @param expectedResult
	 * @param testCaseName
	 */
	public void assertionThroughIfCondition(String actualResult, String expectedResult, String testCaseName) {
		System.out.println("=============***===========");
		System.out.println("Actual result : "+actualResult);
		System.out.println("Expected result : "+expectedResult);
		System.out.println("=============***===========");

		if (actualResult.contains(expectedResult)) {
			System.out.println(testCaseName + " : is pass");
		}
	}
	/**
	 * This method is used for custum wait (thread.sleep)
	 * @param element
	 * @param pollingtime
	 * @param duration
	 */
	public void customWait(WebElement element, long pollingtime,int duration)
	{
		int count=0;
		while(count<=duration)
			try {
				element.click();
				break;
			}
		catch(Exception e) {
			try {
				Thread.sleep(pollingtime);
				count++;
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	/**
	 * This method is used to change date and time format
	 * @return
	 */
	public String dateTimeInFormat()
	{
		return new SimpleDateFormat("yyyy_MM_dd_mm_sss").format(new Date());
	}
	public void getCurrentDate() {
		// here we are only capturing current date, which you can use for your automated scripts.
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
	    //get current date time with Date()
		Date date = new Date();
		// Now format the date
		String date1= dateFormat.format(date);
	}
}
