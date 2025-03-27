package com.Base.Rsc_Ecom;

import java.util.List;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface Iutility {
     public String returncurrentUrl();
     public String returnTitle();
     public void passkeys(WebElement ele,String input);
     public void button(WebElement ele);
     public String returnText(String Text);
     public String returnText(WebElement ele);
     public String returnAttributename(WebElement ele , String attributename);
     public String returnAttributevalue(String attributevalue , WebElement ele);
     public boolean returnEnable(WebElement ele);
     public boolean returnDisplay(WebElement ele);
     public boolean returnSelected(WebElement ele);
     public void mouseOverToElement(WebElement ele);
     public void button(int a , WebElement ele);
     public void DoubleClick(WebElement ele);
     public void rightClick(WebElement ele);
     public void passkeys(String input,WebElement ele);
     public void dragAndDrop(WebElement ele1,WebElement ele2);
     public void capture(String name);
     public void childWindow(String parent);
     public void parentWindow(String parent);
     public void mainFrame();
     public void childFrame(WebElement ele);
     public void parentFrame(WebElement ele);
     public void byVisibleText(WebElement ele , String input);
     public void byIndex(WebElement position , int index);
     public void byVisibleValue(String value , WebElement els);
     public List<WebElement> listOptions(WebElement ele);
     public List<WebElement> allSelectOptions(WebElement ele);
     public String returnfirstSelectOption(WebElement ele);
     public boolean returnMultiple(WebElement ele);
     public void deselectevalue(WebElement ele , String value);
     public void deselectIndex(WebElement ele , int index);
     public void deselectvisibleText(WebElement ele , String name);
     public void deselectOption(WebElement ele);
     public String returnCssValue(WebElement ele , String cssvalue);
     public void scrollDown(WebElement ele);
     public void scrollup(WebElement ele);
     public void passkeys(WebElement ele , String input , int j);
     public void button(WebElement ele , int j);
     public String returnText(WebElement ele , int j);
     public void implicityWait(WebElement ele , int Timeout);
     public void webDriverWait(WebDriver driver, By locator, int timeout);
     public void AlertAccept(Alert alert);
     public void Alertdismiss(Alert alert);
     public void passKeys(Alert alert , String input);
     public String returnText(Alert alert);
     public void BrowserClose();
     public void CurrentTabclose();
}
