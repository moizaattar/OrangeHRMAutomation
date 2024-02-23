package com.orangehrm.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.baseclass.BaseClass;

public class LoginPage extends BaseClass {
	
	String option = "Admin";

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="username")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement logIn;
	
	@FindBy(xpath = "//li[@class='oxd-main-menu-item-wrapper']")
	List<WebElement> listOfAllElements;

	
	public void uName(String name) {
		userName.sendKeys(name);
	}
	
	public void uPassword(String pass) {
		password.sendKeys(pass);

	}
	
	public void logInBtn() {
		logIn.click();
	}
	
	
	public void allElements() {
		for (int i = 0; i < listOfAllElements.size(); i++) {
			if (listOfAllElements.get(i).getText().contains(option)) {
				listOfAllElements.get(i).click();
				break;

			}
		}
	}
	

}


