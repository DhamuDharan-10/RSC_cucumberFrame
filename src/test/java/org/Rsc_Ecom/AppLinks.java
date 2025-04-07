package org.Rsc_Ecom;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Base.Rsc_Ecom.Utilites;

import cucumber.api.java.en.Then;

public class AppLinks {
	
	Utilites utils = Utilites.getSingle();
	static WebDriver driver;
	@Then("validate the url is working or not")
	public void validate_the_url_is_working_or_not() {
		driver = utils.driver;
	   List <WebElement> Links = driver.findElements(By.tagName("a"));
	   for (int i=0; i <= Links.size()-1; i++) {
		   String link = Links.get(i).getAttribute("href");
		   if(link == null || link.isEmpty()) {
			   System.err.println("Url is empty");
			   continue;
		   }
		   if (!link.startsWith("http://") && !link.startsWith("https://")) {
               System.err.println("Skipping non-http link: " + link);
               continue;
           }
		   else {
			   try {
				   HttpURLConnection Urls = (HttpURLConnection) (new URL(link).openConnection());
				   Urls.setRequestMethod("HEAD");
				   Urls.setInstanceFollowRedirects(true);
				   Urls.connect();
				   int num = Urls.getResponseCode();
				   if (num >=200 && num < 300) {
					   System.out.println(Urls+"is not a broken Link");
				   }else if (num >=300 && num < 400) {
					   System.err.println(Urls+"redirecting to other application");
				   } else if(num >= 400 && num <500) {
					   System.err.println(Urls+"Application related Issue");
				   }else {
					   System.err.println(Urls+"Internal Server Issue");
				   }
			   }catch (Exception e) {
				   e.printStackTrace();
			   }
			   }
			 
	   }
	}

}
