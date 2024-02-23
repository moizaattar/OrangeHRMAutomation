package com.orangehrm.pageobjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.baseclass.BaseClass;

public class AdminSearchPage extends BaseClass {
	Actions action = new Actions(driver);

	public AdminSearchPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")
	WebElement searchempuname;

	@FindBy(xpath = "//form/div[1]/div/div[2]/div/div[2]/div/div/div[1]")
	WebElement searchempurole;

	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	WebElement searchempname;

	@FindBy(xpath = "//div[4]/div/div[2]/div/div/div[1]")
	WebElement searchempStatus;

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
	WebElement searchButton;

	@FindBy(xpath = "//div[@class='oxd-table-body']")
	List<WebElement> allRecords;

	@FindBy(id = "oxd-toaster_1")
	WebElement noRecordFoundMsg;

	@FindBy(xpath = "//i[@class='oxd-icon bi-pencil-fill']")
	WebElement editSearchElemnt;
	
	@FindBy(xpath = "//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']")
	WebElement clickCheckbox;

	@FindBy(xpath = "//div[1]/div/div[2]/input")
	WebElement updatedEmpPass;
	
	@FindBy(xpath = "//div[2]/div/div[2]/input")
	WebElement updatedEmpConfirmPass;
	
	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
	WebElement savebtn;

	
	public void searchuName(String searchusername) {
		searchempuname.sendKeys(searchusername);
	}

	public void searchuRole() {
		searchempurole.click();
		for (int i = 0; i < 2; i++) {
			action.sendKeys(Keys.ARROW_DOWN).build().perform();
			// action.sendKeys(Keys.ARROW_DOWN).build().perform();
			if (i == 1) {
				action.sendKeys(Keys.ENTER).build().perform();
			}
		}
	}

	public void searchEmpName(String name) throws InterruptedException {
		searchempname.sendKeys(name);
		Thread.sleep(2000);
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		action.sendKeys(Keys.ENTER).build().perform();

	}

	public void searchEmpStatus() throws InterruptedException {
		searchempStatus.click();
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

	public void searchBtn() {
		searchButton.click();
	}

	/*
	 * public void allTableRecords() { if (allRecords.size() > 1) {
	 * System.out.println("display all records"); } else {
	 * System.out.println("No rocord found" + noRecordFoundMsg.getText());
	 * 
	 * }
	 * 
	 * }
	 */

	public void editRecord(String updatedPass, String updatedConfirmPass) throws InterruptedException {
		editSearchElemnt.click();
		Thread.sleep(5000);
		clickCheckbox.click();
		updatedEmpPass.sendKeys(updatedPass);
		updatedEmpConfirmPass.sendKeys(updatedConfirmPass);
		savebtn.click();
	}
	
	
}
