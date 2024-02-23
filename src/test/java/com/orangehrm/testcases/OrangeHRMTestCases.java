package com.orangehrm.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.orangehrm.baseclass.BaseClass;
import com.orangehrm.pageobjects.AdminCreationPage;
import com.orangehrm.pageobjects.AdminSearchPage;
import com.orangehrm.pageobjects.HeaderPage;
import com.orangehrm.pageobjects.LoginPage;

public class OrangeHRMTestCases extends BaseClass {

	public OrangeHRMTestCases() throws IOException {
		super();
	}

	@BeforeTest
	public void setUp() throws IOException {
		initialization();
	}

	@Test
	public void loginPageTestCase() throws IOException, InterruptedException {
		LoginPage lp = new LoginPage();
		AdminCreationPage ap = new AdminCreationPage();
		AdminSearchPage asp = new AdminSearchPage();

		// Login Functionality
		lp.uName(prop.getProperty("username"));
		lp.uPassword(prop.getProperty("password"));
		lp.logInBtn();
		Thread.sleep(3000);
		lp.allElements();

		// Create new Admin
		ap.addBtn();
		Thread.sleep(3000);
		ap.selectUserRole();
		Thread.sleep(5000);
		ap.selectEmpName(prop.getProperty("empname"));
		Thread.sleep(2000);
		ap.selectStatus();
		ap.enterUserName(prop.getProperty("empusername"));
		Thread.sleep(2000);
		ap.enteremppass(prop.getProperty("empPass"));
		Thread.sleep(2000);
		ap.enterempconpass(prop.getProperty("empPass"));
		Thread.sleep(2000);
		ap.savebutton();
		Thread.sleep(2000);

		// asp.searchuName(prop.getProperty("empusername"));
		asp.searchuName(prop.getProperty("empusername"));
		asp.searchuRole();
		asp.searchEmpName(prop.getProperty("empname"));
		asp.searchEmpStatus();
		asp.searchBtn();
		Thread.sleep(5000);
		
		//sasp.allTableRecords();
		asp.editRecord(prop.getProperty("updatedPassword"), prop.getProperty("updatedPassword"));
	}

	
	
	// Search for newly created Admin
	@Test
	public void searchcreateddAdmin() throws IOException, InterruptedException {
		LoginPage lp = new LoginPage();
		AdminSearchPage asp = new AdminSearchPage();

		lp.uName(prop.getProperty("username"));
		lp.uPassword(prop.getProperty("password"));
		lp.logInBtn();
		Thread.sleep(3000);
		lp.allElements();

		asp.searchuName(prop.getProperty("empusername"));
		asp.searchuRole();
		asp.searchEmpName(prop.getProperty("empname"));
		asp.searchEmpStatus();
		asp.searchBtn();
		Thread.sleep(5000);
		
		//sasp.allTableRecords();
		asp.editRecord(prop.getProperty("updatedPassword"), prop.getProperty("updatedPassword"));
	}

	@Test
	public void headerAdmin() throws InterruptedException {
		LoginPage lp = new LoginPage();
		HeaderPage hp = new HeaderPage();
		
		lp.uName(prop.getProperty("username"));
		lp.uPassword(prop.getProperty("password"));
		lp.logInBtn();
		Thread.sleep(3000);
		lp.allElements();

		hp.headerList();
		hp.jobList();
		hp.addEmpStatusBtn(prop.getProperty("empStatus"));
	}
}