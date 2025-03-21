package org.Rsc_Ecom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Base.Rsc_Ecom.Utilites;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class logo extends Utilites{
//	@Then("validate the logo Background color")
//	public void validate_the_logo_background_color() {
//	    String Actualfamily= logo.getCssValue("font-family");
//	    System.out.println("font-family: "+Actualfamily);
//	}
	@Then("validate the font weight")
	public void validate_the_font_weight() {
	 WebElement logo = driver.findElement(By.xpath("//img[@id='rsc-main-page-logo']"));
	 String Actualweight = logo.getCssValue("font-height");
	
	 String ExceptFontHeight = "700";
	 if (ExceptFontHeight.equals(Actualweight)) {
		 System.out.println("Excepted font-weight except: "+Actualweight);
	 }else {
		 System.out.println("Excepted font-weight not except: "+Actualweight);
	 }
	}
	@Then("validate the font size in the app")
	public void validate_the_font_size_in_the_app() {
		 WebElement logo = driver.findElement(By.xpath("//img[@id='rsc-main-page-logo']"));
		 String ActualSize = logo.getCssValue("font-size");
		
		 String ExceptFontsize = "36px";
		 if (ExceptFontsize.equals(ActualSize)) {
			 System.out.println("Excepted font-size except: "+ActualSize);
		 }else {
			 System.out.println("Excepted font-size not except: "+ActualSize);
		 } 
	}
	@Then("validate the font color in the app")
	public void validate_the_font_color_in_the_app() {
		 WebElement logo = driver.findElement(By.xpath("//img[@id='rsc-main-page-logo']"));
		 String Actualcolor = logo.getCssValue("color");  
		 System.out.println("color: "+Actualcolor);
		 String Exceptcolor = "36px";
		 if (Exceptcolor.equals(Exceptcolor)) {
			 System.out.println("Excepted font-color except: "+Exceptcolor);
		 }else {
			 System.out.println("Excepted font-color not except: "+Exceptcolor);
		 } 
	}
}
