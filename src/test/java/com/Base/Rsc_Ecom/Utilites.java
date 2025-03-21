package com.Base.Rsc_Ecom;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilites {
	public static WebDriver driver;
	public static ChromeOptions option;
	public static WebDriverWait Waits;
	public static JavascriptExecutor js;
	
	public static void BrowserLaucher(String Laucher) {
		option = new ChromeOptions();
		option.addArguments("start-maximized");
		option.addArguments("disable-popups");
		option.addArguments("disable-notification");
	   driver = new ChromeDriver(option);
	   driver.get(Laucher);
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	}

}
