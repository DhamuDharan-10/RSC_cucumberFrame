package org.Rsc_Ecom;

import org.pageobjectRepo.LogoLocator;
import com.Base.Rsc_Ecom.Utilites;
import cucumber.api.java.en.Then;



public class logo{
	LogoLocator fonts = new LogoLocator();
	Utilites utility =Utilites.getSingle();
//	@Then("validate the logo Background color")
//	public void validate_the_logo_background_color() {
//	    String Actualfamily= logo.getCssValue("font-family");
//	    System.out.println("font-family: "+Actualfamily);
//	}
	@Then("validate the font weight")
	public void validate_the_font_weight() {
	
	 String Actualweight = utility.returnCssValue(fonts.getLogo(), "font-weight");
	 String ExceptFontWeight = "700";
	 if (ExceptFontWeight.equals(Actualweight)) {
		 System.out.println("Excepted font-weight except: "+Actualweight);
	 }else {
		 System.out.println("Excepted font-weight not except: "+Actualweight);
	 }
	}
	@Then("validate the font size in the app")
	public void validate_the_font_size_in_the_app() {
	
		 String ActualSize = utility.returnCssValue(fonts.getLogocolor(), "font-size");
		 String ExceptFontsize = "36px";
		 if (ExceptFontsize.equals(ActualSize)) {
			 System.out.println("Excepted font-size except: "+ActualSize);
		 }else {
			 System.out.println("Excepted font-size not except: "+ActualSize);
		 } 
	}
	@Then("validate the font color in the app")
	public void validate_the_font_color_in_the_app() {
	
		 String Actualcolor = utility.returnCssValue(fonts.getLogocolor(), "color");  
		 System.out.println("color: "+Actualcolor);
		 String Exceptcolor = "36px";
		 if (Exceptcolor.equals(Exceptcolor)) {
			 System.out.println("Excepted font-color except: "+Exceptcolor);
		 }else {
			 System.out.println("Excepted font-color not except: "+Exceptcolor);
		 } 
	}
}
