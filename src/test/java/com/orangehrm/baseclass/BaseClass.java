package com.orangehrm.baseclass;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public void initialization() throws IOException {
		FileReader fr = new FileReader("C:\\Users\\moiza.attar\\eclipse-workspace\\orangeHRM\\src\\test\\java\\com\\orangehrm\\config\\config.properties");
		prop = new Properties();
		prop.load(fr);
		
		String browserName = prop.getProperty("browser");
		
		
			if (browserName.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();

			} else if (browserName.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
			}

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();

			driver.get(prop.getProperty("url"));
		}
		
	}


