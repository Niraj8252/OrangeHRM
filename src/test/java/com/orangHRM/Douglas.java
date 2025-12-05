package com.orangHRM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Douglas {
	public static void main(String[] args) throws InterruptedException {
//		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		
		driver.get("https://www.douglas.de/de");

		
		WebElement shadowhost = driver.findElement(By.id("usercentrics-root"));
		SearchContext shadowroot = shadowhost.getShadowRoot();
		String text = shadowroot.findElement(By.cssSelector("#uc-heading-title")).getText();
		System.out.println(text);
		shadowroot.findElement(By.cssSelector("[data-testid='uc-accept-all-button']")).click();
		Thread.sleep(2000);
		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//li[@data-uid='AppParfumNavNode']//a[text()='Parfum']"))).perform();
		
		Thread.sleep(3000);

		List<WebElement> list = driver.findElements(By.xpath("//div[@class='navigation-backdrop']//div[@data-testid='navigation-main-column']//ul[@id='Navigation_Flyout_Content']//li[@data-testid='navigation-link-container']//a"));
		for(WebElement item : list) {
//			System.out.println(item.getText());
			if(item.getText().equalsIgnoreCase("Deodorants")) {
				Thread.sleep(2000);
				item.click();
				break;
			}
		}
		String s= "Deo & Deostick für Damen";
		String str = driver.findElement(By.cssSelector("[data-testid='product-overview-headline']")).getText();

		Assert.assertEquals(str.toUpperCase(), s.toUpperCase());
		System.out.println("passs");
		
		driver.findElement(By.cssSelector("[data-testid='menu-button-facets']")).click();
		Thread.sleep(2000);
		
		List<WebElement> eles = driver.findElements(By.cssSelector(".main-facet"));
		for(WebElement wb : eles) {
			System.out.println(wb.getText());
			String st = "Sortieren nach";
			if(wb.getText().equalsIgnoreCase(st)) {
				wb.click();
				break;
			}
		}
		
		List<WebElement> radios = driver.findElements(By.cssSelector("[data-testid='RadioButton']"));
		
		if(radios.isEmpty()) {
			driver.findElement(By.xpath("//h3[@class='facets-mobile-template__header-title facets-mobile-template__header-title--with-back-button']/ancestor::div[@class='facets-mobile-template']/descendant::button[@data-testid='button-primary']")).click();
			
		}
		else {
			for(WebElement rad:radios) {
				if(rad.getText().equalsIgnoreCase("Preis aufsteigend")) {
					rad.click();
					driver.findElement(By.xpath("//h3[@class='facets-mobile-template__header-title facets-mobile-template__header-title--with-back-button']/ancestor::div[@class='facets-mobile-template']/descendant::button[@data-testid='button-primary']")).click();
					break;
				}
			}
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Schliessen']")).click();
		Thread.sleep(2000);
		
		
		List<WebElement> allItem = driver.findElements(By.xpath("//div[@class='cms-container']/descendant::div[@class='text top-brand']"));
		
		if(allItem.isEmpty()) {
			
			System.out.println("No item found");
		}
		else {
			for(WebElement item:allItem) {
				if(item.getText().equalsIgnoreCase("MUGLER")) {
					Assert.assertEquals(item.getText(), "MUGLER");
					System.out.println("Item : " +item.getText() + " : is present");
					break;
				}
			}
		}
	}

}
