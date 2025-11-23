package com.orangHRM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HiddenDropdownTest {
	
	@Test
	public void handleHiddenDropdownTest() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();

	    options.addArguments("--start-maximized");
	    options.setImplicitWaitTimeout(Duration.ofSeconds(10));

	    WebDriver driver  = new ChromeDriver(options);
//		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.fr/");
		WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
		dropdown.click();
		List<WebElement> allOptions = driver.findElements(By.tagName("option"));
		System.out.println(allOptions.size());
		
//		Select select = new Select(dropdown);
//		List<WebElement> allOptions = select.getOptions();
		
		for(WebElement option : allOptions) {
			if(option.getText().startsWith("B")) {
				System.out.println(option.getText());

			}
		}
	}
}
