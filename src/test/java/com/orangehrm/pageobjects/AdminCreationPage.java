package com.orangehrm.pageobjects;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.baseclass.BaseClass;

public class AdminCreationPage extends BaseClass {
	String option = "Admin";
	Actions action = new Actions(driver);

	public AdminCreationPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='oxd-icon bi-chevron-left']")
	WebElement button;
	
	//Create New Admin 
	@FindBy(xpath = "//button//i[@class='oxd-icon bi-plus oxd-button-icon']")
	WebElement addBtn;

	@FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div")
	WebElement userRole;

	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	WebElement empName;

	@FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]")
	WebElement status;

	@FindBy(xpath = "//div[4]/div/div[2]/input")
	WebElement empuserName;

	@FindBy(xpath = "//div[1]/div/div[2]/input")
	WebElement emppass;

	@FindBy(xpath = "//div[2]/div/div[2]/input")
	WebElement empconfirmpassword;

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
	WebElement savebtn;
	


	public void addBtn() throws InterruptedException {
		//button.click();
		//Thread.sleep(3000);
		addBtn.click();
	}

	public void selectUserRole() {
		userRole.click();
		for (int i = 0; i < 2; i++) {
			action.sendKeys(Keys.ARROW_DOWN).build().perform();
			// action.sendKeys(Keys.ARROW_DOWN).build().perform();
			if (i == 1) {
				action.sendKeys(Keys.ENTER).build().perform();
			}
		}

	}

	public void selectEmpName(String name) throws InterruptedException {
		empName.sendKeys(name);
		
		Thread.sleep(2000);
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		action.sendKeys(Keys.ENTER).build().perform();

	}

	public void selectStatus() throws InterruptedException {
		status.click();
		for (int i = 0; i < 2; i++) {
			action.sendKeys(Keys.ARROW_DOWN).build().perform();
			// action.sendKeys(Keys.ARROW_DOWN).build().perform();
			if (i == 0) {
				System.out.println("Click");
				Thread.sleep(2000);
				action.sendKeys(Keys.ENTER).build().perform();
			}
		}

	}

	public void enterUserName(String empuname) {
		empuserName.sendKeys(empuname);
	}

	public void enteremppass(String emppassword) {
		emppass.sendKeys(emppassword);
	}

	public void enterempconpass(String empconpassword) {
		empconfirmpassword.sendKeys(empconpassword);
	}

	public void savebutton() {
		savebtn.click();
	}
	
	
}
