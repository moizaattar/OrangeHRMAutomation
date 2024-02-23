package com.orangehrm.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.baseclass.BaseClass;

public class HeaderPage extends BaseClass{
	
	String headerName = "Job";
	String jobOption = "Employment Status";
	

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
	
	
	public void headerList() {
		for (int i=0; i<listofHeader.size(); i++) {
			//System.out.println(listofHeader.get(1).getText());
			if (listofHeader.get(i).getText().contains(headerName)) {
				listofHeader.get(i).click();
				break;
			
		}
	}

}
	
	public void jobList() {
		for(int i=0; i<listofJob.size(); i++) {
			if(listofJob.get(i).getText().contains(jobOption)) {
				listofJob.get(i).click();
			}
		}
	}
	
	public void addEmpStatusBtn(String addempStaus) {
		addEmpStatus.click();
		empStatusName.sendKeys(addempStaus);
		
	}
}