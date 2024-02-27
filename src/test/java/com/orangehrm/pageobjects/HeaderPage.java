package com.orangehrm.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.baseclass.BaseClass;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class HeaderPage extends BaseClass {
	
	//public static addempStaus emp;

	String headerName = "Job";
	String jobOption = "Employment Status";
	String deleteElement = "Test Emp Status";

	public HeaderPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='oxd-topbar-body-nav-tab-item']")
	List<WebElement> listofHeader;

	@FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-link']")
	List<WebElement> listofJob;

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement addEmpStatus;

	@FindBy(xpath = "//div[2]/input")
	WebElement empStatusName;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveBtn;

	@FindBy(xpath = "//div[@style='flex-basis: 80%;']")
	List<WebElement> listofElements;
	

	@FindBy(xpath = "//i[@class='oxd-icon bi-trash']")
	WebElement deleteListElement;
	Actions action = new Actions(driver);

	@FindBy(xpath = "//i[@class='oxd-icon bi-trash oxd-button-icon']")
	WebElement delete;

	
	
	public void headerList() {
		for (int i = 0; i < listofHeader.size(); i++) {
			// System.out.println(listofHeader.get(1).getText());
			if (listofHeader.get(i).getText().contains(headerName)) {
				listofHeader.get(i).click();
				break;

			}
		}

	}

	public void jobList() {
		for (int i = 0; i < listofJob.size(); i++) {
			if (listofJob.get(i).getText().contains(jobOption)) {
				listofJob.get(i).click();
			}
		}
	}

	public void addEmpStatusBtn() {
		addEmpStatus.click();
		empStatusName.sendKeys(deleteElement);
		saveBtn.click();

	}


	public void deleteElementfromList() throws InterruptedException {
		for (int i = 1; i < listofElements.size(); i++) {
			System.out.println(listofElements.get(i).getText());
			if(listofElements.get(i).getText().equals(deleteElement)) {
				System.out.println("Demooooooooooooooo" + listofElements.get(i).getText());
				driver.findElement(By.xpath("//div["+i+"]/div/div[1]/div/div/label/span/i")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//div["+i+"]/div/div[3]/div/button[1]/i")).click();
				//checkBox.click();
				Thread.sleep(4000);
				delete.click();
				
			}
		
	}
	}
}

	
	
	/*
	 * public void deleteElementfromList() throws InterruptedException { for (int i
	 * = 0; i < listofElements.size(); i++) { //if
	 * (listofElements.get(i).getText().contains(deleteElement)) {
	 * System.out.println(listofElements.get(i).getText());
	 * 
	 * // action.scrollToElement(deleteListElement).build().perform();
	 * Thread.sleep(4000);
	 * 
	 * 
	 * checkBox.click(); 	
	 * 
	 * 
	 * 
	 * delete.click();
	 * 
	 * }
	 * 
	 * 
	 * }
	 */
	
