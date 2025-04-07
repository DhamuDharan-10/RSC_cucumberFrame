package com.Base.Rsc_Ecom;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilites implements Iutility{
	public static WebDriver driver;
	public static ChromeOptions option;
	public static WebDriverWait Waits;
	public static JavascriptExecutor js;
	public static Actions action;
	public static Select drops;
	public static Utilites utils = null;
	private Utilites() {}
	public static Utilites getSingle() {
		if(utils == null) {
			utils = new Utilites();
		}
		return utils;
	}
	public static void BrowserLaucher() {
		File f = new File (".\\src\\test\\resources\\Rsc.properties");
		Properties prop;
		String ProdUrl = null;
		try {
			FileInputStream Fi = new FileInputStream(f);
			prop = new Properties();
			prop.load(Fi);
			ProdUrl = prop.getProperty("prod");
			FileOutputStream Fo = new FileOutputStream(f);
			prop.setProperty("name", "DD");
			prop.save(Fo, "provided the name");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		option = new ChromeOptions();
		option.addArguments("start-maximized");
		option.addArguments("disable-popups");
		option.addArguments("disable-notification");
	   driver = new ChromeDriver(option);
	   driver.get(ProdUrl);
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	}
	

	@Override
	public String returncurrentUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}

	@Override
	public String returnTitle() {
		String Title = driver.getTitle();
		return Title;
	}

	@Override
	public void passkeys(WebElement ele, String input) {
		ele.sendKeys(input);
		
	}

	@Override
	public void button(WebElement ele) {
		ele.click();
		
	}

	@Override
	public String returnText(String Text) {
		return Text;
	}

	@Override
	public String returnAttributename(WebElement ele, String attributename) {
		String Attribute = ele.getAttribute(attributename);
		return Attribute;
	}

	@Override
	public String returnAttributevalue(String attributevalue, WebElement ele) {
		String Attributevalue = ele.getAttribute(attributevalue);
		return Attributevalue;
	}

	@Override
	public boolean returnEnable(WebElement ele) {
		boolean enable = ele.isEnabled();
		return enable;
	}

	@Override
	public boolean returnDisplay(WebElement ele) {
		boolean Display = ele.isDisplayed();
		return Display;
	}

	@Override
	public boolean returnSelected(WebElement ele) {
		boolean Select = ele.isSelected();
		return Select;
	}

	@Override
	public void mouseOverToElement(WebElement ele) {
		action = new Actions(driver);
		action.moveToElement(ele).build().perform();
		
	}

	@Override
	public void button(int a ,WebElement ele) {
		action = new Actions(driver);
		action.click(ele).build().perform();;
		
	}

	@Override
	public void DoubleClick(WebElement ele) {
		action = new Actions(driver);
		action.doubleClick().build().perform();
		
	}

	@Override
	public void rightClick(WebElement ele) {
		action = new Actions(driver);
		action.contextClick().build().perform();
		
	}

	@Override
	public void passkeys(String input, WebElement ele) {
		action = new Actions(driver);
		action.sendKeys(ele, input);
		
	}

	@Override
	public void dragAndDrop(WebElement ele1, WebElement ele2) {
		action = new Actions(driver);
		action.dragAndDrop(ele1, ele2);
		
	}

	@Override
	public void capture(String name) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File Dest = new File ("./target/"+name+".png");
		try {
			FileUtils.copyFile(source, Dest);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void childWindow(String parent) {
		Set <String> child = driver.getWindowHandles();
		List <String> childs = new ArrayList<String>(child);
		for(String ch : childs) {
			if(!parent.equals(childs)) {
					driver.switchTo().window(ch);
				}
		    }
		}

	@Override
	public void parentWindow(String parent) {
		driver.switchTo().window(parent);
    }

	@Override
	public void mainFrame() {
		driver.switchTo().defaultContent();
		
	}

	@Override
	public void childFrame(WebElement ele) {
		driver.switchTo().frame(ele);
		
	}

	@Override
	public void parentFrame(WebElement ele) {
		driver.switchTo().frame(ele);
		
	}

	@Override
	public void byVisibleText(WebElement ele, String input) {
		drops = new Select (ele);
		drops.selectByVisibleText(input);
		
	}

	@Override
	public void byIndex(WebElement position, int index) {
		drops = new Select (position);
		drops.selectByIndex(index);
		
	}

	@Override
	public void byVisibleValue(String value, WebElement ele) {
		drops = new Select (ele);
		drops.selectByValue(value);
		}

	@Override
	public List<WebElement> listOptions(WebElement ele) {
		drops = new Select (ele);
		List<WebElement> options = drops.getAllSelectedOptions();
		return options;
	}

	@Override
	public List<WebElement> allSelectOptions(WebElement ele) {
		drops = new Select (ele);
		List<WebElement> SelectOptions = drops.getAllSelectedOptions();
		return SelectOptions;
	}

	@Override
	public String returnfirstSelectOption(WebElement ele) {
		drops = new Select (ele);
		WebElement firstselect = drops.getFirstSelectedOption();
		return firstselect.getText();
	}

	@Override
	public boolean returnMultiple(WebElement ele) {
		drops = new Select (ele);
		boolean multiple = drops.isMultiple();
		return multiple;
	}

	@Override
	public String returnCssValue(WebElement ele, String cssvalue) {
		String cssname = ele.getCssValue(cssvalue);
		return cssname;
	}

	@Override
	public void scrollDown(WebElement ele) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoview(true)", ele);
		
	}

	@Override
	public void scrollup(WebElement ele) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoview(false)", ele);
		
	}

	@Override
	public void passkeys(WebElement ele, String input, int j) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','"+input+"')",ele);
		
	}

	@Override
	public void button(WebElement ele , int j) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",ele);
		
	}

	@Override
	public String returnText(WebElement ele, int j) {
		js = (JavascriptExecutor) driver;
		js.executeScript("return arguments[0].getAttribute('value')",ele);
		return null;
	}

	@Override
	public void implicityWait(WebElement ele, int Timeout) {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Timeout));
		
	}

	@Override
	public void webDriverWait(WebDriver driver, By locator, int timeout) {
		Waits = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		Waits.until(ExpectedConditions.presenceOfElementLocated(locator));
		
	}

	@Override
	public void AlertAccept(Alert alert) {
		alert.accept();
		
	}

	@Override
	public void Alertdismiss(Alert alert) {
		alert.dismiss();
		
	}

	@Override
	public void passKeys(Alert alert, String input) {
		alert.sendKeys(input);
		
	}

	@Override
	public String returnText(Alert alert) {
		String alertText = alert.getText();
		return alertText;
	}

	@Override
	public void deselectevalue(WebElement ele, String value) {
		drops = new Select (ele);
		drops.deselectByValue(value);
	}

	@Override
	public void deselectIndex(WebElement ele, int index) {
		drops = new Select (ele);
		drops.deselectByIndex(index);
		
	}

	@Override
	public void deselectvisibleText(WebElement ele, String name) {
		drops = new Select (ele);
		drops.deselectByVisibleText(name);
		
	}

	@Override
	public void deselectOption(WebElement ele) {
		drops = new Select (ele);
		drops.deselectAll();
		
	}

	@Override
	public void BrowserClose() {
		driver.quit();
		
	}

	@Override
	public void CurrentTabclose() {
		driver.close();
		
	}
	@Override
	public String returnText(WebElement ele) {
		String text = ele.getText();
		return text;
	}
	public List<Map<String,String>> sql() {
		Connection con = null;
		List<Map<String,String>> li = new ArrayList();
		Map<String,String> map = new HashMap<String, String>();
		try {
			Class.forName(".\\org.Rsc_Ecom\\Driver\\mysql-connector-j-9.2.0.jar");
		    String connectionString ="localhost:4299/username:user/password:pass/";
		    try {
		    	con = DriverManager.getConnection(connectionString);
		    	System.out.println("Databaseconnection");
		    	Statement stmt = con.createStatement();
		    	ResultSet rt = stmt.executeQuery(connectionString);
		        while(rt.next()) {
		        	String name = rt.getString("username");
		        	map.put("username", name);
		        	String pass =rt.getString("password");
		        	map.put("password", pass);
		        }
		    }catch(Exception e) {
		    	e.printStackTrace();
		    }
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		return li;
		
	}

}
