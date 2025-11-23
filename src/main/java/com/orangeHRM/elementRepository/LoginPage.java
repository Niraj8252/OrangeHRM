package com.orangeHRM.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;


	//Constructor
		public LoginPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		//Xpaths and locators
		@FindBy(name="username")
		private WebElement userNameInputField;
		@FindBy(name="password")
		private WebElement passwordInputField;
		@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")
		private WebElement signInButtonElement;
		
		
		//Business library/Methods
		public void loginAction(String email, String password) {
			userNameInputField.sendKeys(email);
			passwordInputField.sendKeys(password);
			signInButtonElement.click();
		}

}
