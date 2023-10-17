//package com.portal.test;
//
//import java.time.Duration;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.chromium.ChromiumDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeOptions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//
//public class Base {
//	public static WebDriver driver;
//	
//	
//	public void startbrowser() {
//		
//		//EdgeOptions options = new EdgeOptions();
//		ChromeOptions options =new ChromeOptions();
//		
//		options.addArguments("--remote-allow-origins=*");
//		// System.setProperty("Webdriver.edge.driver","C:\\Users\\noorb\\eclipse-workspace\\NOORBASHA\\src\\msedgedriver.exe");
//		//driver = new EdgeDriver(options);
//		driver =new ChromeDriver();
//		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
//		
//	}
//
//	public void enbrowser() {
//		//driver.close();
//	}
//
//}
