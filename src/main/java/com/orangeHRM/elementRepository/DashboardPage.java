package com.orangeHRM.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	//Constructor
			public DashboardPage(WebDriver driver) {
				PageFactory.initElements(driver, this);
			}
			
			//Xpaths and locators
			@FindBy(xpath="//div[@class='oxd-topbar-header-title']//h6[text()='Dashboard']")
			private WebElement dashboardTextElement;
			@FindBy(id="txtPassword")
			private WebElement vendorPasswordInputField;
			@FindBy(xpath = "//button[text()='Sign in']")
			private WebElement vendorSignInButtonElement;
			
			
			//Business library/Methods
			public String getDashboardText() {
				return dashboardTextElement.getText();
			}


}
