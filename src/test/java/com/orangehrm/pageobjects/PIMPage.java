package com.orangehrm.pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.orangehrm.baseclass.BaseClass;



public class PIMPage extends BaseClass{
	String option = "PIM";
	String configdropdownoption = "Data Import";
	String empList = "Employee List";
	
	Actions action = new Actions(driver);
	

	public PIMPage() {
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath = "//li[@class='oxd-main-menu-item-wrapper']")
	List<WebElement> listOfAllElements;
	
	@FindBy(xpath = "//span[@class='oxd-topbar-body-nav-tab-item']")
	WebElement configOption;
	
	@FindBy(xpath = "//a[@role='menuitem']")
	List<WebElement> allConfigOptions;
	
	@FindBy(xpath = "//div[@class='oxd-file-button']")
	WebElement browserbtn;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement uploadbtn;
	
	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--text']")
	WebElement okbtn;
	
	@FindBy(xpath ="//a[@class='oxd-topbar-body-nav-tab-item']")
	List<WebElement> emptablist;
	
	@FindBy(xpath = "//div/div[1]/div/div[2]/div/div/input")
	WebElement empName;
	
	@FindBy(xpath = "//div[2]/input[@class='oxd-input oxd-input--active']")
	WebElement empId;
	
	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
	WebElement searchbtn;
	
	@FindBy(xpath = "//div[3]/div/div[2]/div[1]/div/div[2]/div")
	WebElement clickOnSearchRecord;
	
	@FindBy(xpath = "//img[@class='employee-image']")
	WebElement profilePicture;
	
	
	public void allElements() {
		for (int i = 0; i < listOfAllElements.size(); i++) {
			if (listOfAllElements.get(i).getText().contains(option)) {
				listOfAllElements.get(i).click();
				break;

			}
		}
	}
	
	public void configuration() {
		configOption.click();
		for(int i=0; i<allConfigOptions.size(); i++) {
			if(allConfigOptions.get(i).getText().contains(configdropdownoption)) {
				allConfigOptions.get(i).click();
			}
		} 
	}
	
	public void importData() throws AWTException, InterruptedException {
		browserbtn.click();
		Robot robot = new Robot();
		StringSelection str = new StringSelection("C:\\Users\\moiza.attar\\importData - importData.csv.csv");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	
		Thread.sleep(3000);
		uploadbtn.click();
		okbtn.click();
	}
	
	
	public void employeeListTab(String ename, String empnum) throws InterruptedException {
		for(int i=0; i<emptablist.size(); i++) {
			if(emptablist.get(i).getText().contains(empList)) {
				emptablist.get(i).click();
				empName.sendKeys(ename);
				Thread.sleep(2000);
				action.sendKeys(Keys.ARROW_DOWN).build().perform();
				action.sendKeys(Keys.ENTER).build().perform();
				empId.sendKeys(empnum);
				searchbtn.click();
				Thread.sleep(3000);
				action.moveToElement(clickOnSearchRecord).click().build().perform();
				profilePicture.click();
	
			}
		}
	}
	
}
