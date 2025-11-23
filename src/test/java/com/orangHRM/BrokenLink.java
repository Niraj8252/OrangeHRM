package com.orangHRM;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
	        driver.get("https://www.amazon.com/");

	        List<WebElement> links = driver.findElements(By.tagName("a"));
//
	        for (WebElement link : links) {
	            String url = link.getAttribute("href");
	            if (url == null || url.startsWith("amazon")) continue;

	            try {
	                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
	                connection.setRequestMethod("HEAD");
	                connection.connect();

	                int code = connection.getResponseCode();
	                if (code >= 400) {
	                    System.out.println("❌ Broken link: " + url + " (Status: " + code + ")");
	                } else {
	                    System.out.println("✅ Valid link: " + url);
	                }

	            } catch (Exception e) {
	                System.out.println("⚠️ Error checking " + url + " : " + e.getMessage());
	            }
	        }

//	        driver.quit();
	    }


	}
	

