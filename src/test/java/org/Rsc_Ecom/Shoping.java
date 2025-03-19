package org.Rsc_Ecom;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Shoping {
	static WebDriver driver;
	static ChromeOptions option;
	static WebDriverWait wait;
	static JavascriptExecutor js;
	@Given("Lauch the application RSC {string}")
	public void lauch_the_application_rsc(String laucherurl) {
		option = new ChromeOptions();
		option.addArguments("start-maximized");
		option.addArguments("disable-popups");
		option.addArguments("disable-notification");
	   driver = new ChromeDriver(option);
	   driver.get(laucherurl);
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@When("user Accept or Dismiss the cookies")
	public void user_accept_or_dismiss_the_cookies() {
	   driver.findElement(By.xpath("//button[text()='Reject All' and @id='onetrust-reject-all-handler']")).click();
	}

	@Then("Validate user lands on the Homepage")
	public void validate_user_lands_on_the_homepage() {
	   String Title = driver.getCurrentUrl();
	   if (Title.contains("https://www.rsc.org.uk/")) {
		   System.out.println("User navigate to the correct Application");
	   }else {
		   System.out.println("URl is not Working properly");
	   }
	}

	@Then("validate the Sub_Models of Shop")
	public void validate_the_sub_models_of_shop() {
	  
	   List <String> ExceptedResult = new ArrayList ();
	   ExceptedResult.add("Books");
	   ExceptedResult.add("Clothing & Accessories");
	   ExceptedResult.add("DVD, BluRay & CD");
	   ExceptedResult.add("Homeware and Gifts");
	   ExceptedResult.add("Stationery");
	   ExceptedResult.add("Toys, Games & Fun stuff");
	   ExceptedResult.add("Browse by Play");
	   ExceptedResult.add("Special Offers");
	   ExceptedResult.add("Visit Main RSC website");
	   ExceptedResult.add("RSC Gift Vouchers");
	   ExceptedResult.add("Blog");
	   wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='list-menu list-menu--inline']//descendant::span")));
	   List <WebElement> SubModels = driver.findElements(By.xpath("//ul[@class='list-menu list-menu--inline']//descendant::span"));
	   for (int i = 0; i < SubModels.size(); i++) {
		   String ActualResult = SubModels.get(i).getText().trim();
		    for (String excepted : ExceptedResult) {
		    	 if (excepted.equalsIgnoreCase(ActualResult)) {
					   System.out.println("Required Model: "+ActualResult);
				   }
		    }
		   
		   
	   }
}

	@When("User Clicks on Clothes&Accessories")
	public void user_clicks_on_clothes_accessories() {
	   driver.findElement(By.xpath("//span[text()='Clothing & Accessories']")).click();
	}

	@Then("Validate DropDown items Displayed")
	public void validate_drop_down_items_displayed() {
	   WebElement Visiblity = driver.findElement(By.xpath("//ul[@id='HeaderMenu-MenuList-2']"));
	   boolean checks = Visiblity.isDisplayed();
	   System.out.println("DropDown is visible: "+checks);
	}

	@When("User Clicks the Search functionality")
	public void user_clicks_the_search_functionality() {
	   driver.findElement(By.xpath("//details-modal[@class='header__search']")).click();
	}

	@When("User Provide the Keys one dim list")
	public void user_provide_the_keys(DataTable dataTable) { 
		List<String> value= dataTable.asList();
		String key = value.get(0);
	   WebElement Keys = driver.findElement(By.xpath("//input[@class='search__input field__input']"));
	   Keys.sendKeys(key);
	}

	@Then("validate items in the Description belongs to the Search")
	public void validate_items_in_the_description_belongs_to_the_search() {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='predictive-search__item-heading h5']")));
	   List <WebElement> SearchResult = driver.findElements(By.xpath("//p[@class='predictive-search__item-heading h5']"));
	   for (int i = 0; i < SearchResult.size(); i++) {
		   String Products = SearchResult.get(i).getText().trim();
		   if (Products.contains("Shirt")) {
			   System.out.println("Result Met With the search: "+Products);
		   }else {
			   System.out.println("Result NotMet With the search: "+Products);
		   }

	   }
	}
	 @When("User Clicks on Books HomeWare and Gifts")
	    public void user_clicks_on_books_home_ware_and_gifts() {
	        WebElement homeWare = driver.findElement(By.xpath("//summary[@id='HeaderMenu-homeware-and-gifts']"));
	        homeWare.click();
	    }
	@Then("Validate DropDown of HomeWare items Displayed")
	public void validate_drop_down_of_home_ware_items_displayed() {
	   WebElement HomeWareList = driver.findElement(By.xpath("//details[@id='Details-HeaderMenu-4']"));
	   boolean visible = HomeWareList.isDisplayed();
	   System.out.println("option is visible: "+visible);
	}
	
	@When("user clicks on All_HomeWare")
	public void user_clicks_on_all_home_ware() {
	  driver.findElement(By.xpath("//a[@id='HeaderMenu-homeware-and-gifts-all-homeware']")).click();
	}

	@Then("validate Wheather it is move to the current page")
	public void validate_wheather_it_is_move_to_the_current_page() {
	   WebElement DomText = driver.findElement(By.xpath("//div[@class='collection-hero__text-wrapper']"));
	   String text = DomText.getText();
	   System.out.println("User navigate to the Current page: "+text);
	}

	@When("user clicks on Color")
	public void user_clicks_on_color() {
	   driver.findElement(By.xpath("//details[@id='Details-3-template--14838647521367__product-grid']")).click();
	}

	@Then("Validate the CheckBoxes is Multiple")
	public void validate_the_check_boxes_is_multiple() {
	 int Selected = 0;
	  List <WebElement> CheckBoxes = driver.findElements(By.xpath("//div[@id='Facet-3-template--14838647521367__product-grid']//descendant::input[contains(@id,'Filter-filter.v.option.colour')]"));
         for (int i = 0; i < CheckBoxes.size(); i++) {
        	 WebElement CheckBox = CheckBoxes.get(i);
        	 js = (JavascriptExecutor) driver;
        	 js.executeScript("arguments[0].click()", CheckBox);
        	 if(CheckBox.isSelected()) {
        		 Selected++;
        	 }
         }
         if (Selected >= 2) {
        	 System.out.println("CheckBox is Multiple");
         }else {
        	 System.out.println("CheckBox is Not Multiple");
         }
         
	}
	
	@When("User Clicks the Shop Module one dim map")
	public void user_clicks_the_shop_module_one_dim_map(DataTable Text) {
		Map <String,String> value =Text.asMap(String.class, String.class);
		String Keys = value.get("value1");
		 WebElement values = driver.findElement(By.xpath("//a[text()='"+Keys+"']"));
		 values.click();
	  
	}

	@Then("Validate the DropDown List Out Model Related Items")
	public void validate_the_drop_down_list_out_model_related_items() {
		List <String> ExceptResult = new ArrayList();
		ExceptResult.add("Candles and Wax Melts");
		ExceptResult.add("Chocolate and Sweets");
		ExceptResult.add("Crafts");   
		ExceptResult.add("Decorations");             
		ExceptResult.add("Magnets");
		ExceptResult.add("Mugs & Coasters");
		ExceptResult.add("Prints & Posters");
		ExceptResult.add("Pride");
		ExceptResult.add("Textiles");
		ExceptResult.add("Travel Mugs & Water Bottles");
		ExceptResult.add("All Homeware"); 
		List <WebElement> ActualResult = driver.findElements(By.xpath("//ul[@id='HeaderMenu-MenuList-4']//descendant::a"));
		for (int i=0; i <ActualResult.size(); i++) {
			String Actual = ActualResult.get(i).getText();
			for (String Except:ExceptResult) {
				if(Actual.equalsIgnoreCase(Except)) {
					System.out.println("Model Releated Item: "+Actual);
				}
			}
		}
	   
	}
	@When("User Clicks on the Account")
	public void user_clicks_on_the_account() {
	   driver.findElement(By.xpath("//a[@class='header__icon header__icon--account link focus-inset small-hide']")).click();
	}

	@When("User provides the username {string}")
	public void user_provides_the_username(String Username) {
		 WebElement userNameField = driver.findElement(By.xpath("//input[@id='CustomerEmail']"));
		 userNameField.sendKeys(Username);
	}
	@When("user provides the Password {string}")
	public void user_provides_the_password(String password) {
	   WebElement UserPassword = driver.findElement(By.xpath("//input[@id='CustomerPassword']"));
	   UserPassword.sendKeys(password);
	}
	@When("user click on Sign_in")
	public void user_click_on_sign_in() {
	    driver.findElement(By.xpath("//div[@id='shopify-section-template--14838647881815__main']//descendant::button[2]")).click();
	}

//	@Then("Validate the Crenditals")
//	public void validate_the_crenditals() {
//		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@fdprocessedid='hd9xrs']")));
//		
//	 WebElement validate =  driver.findElement(By.xpath("//button[@fdprocessedid='hd9xrs']"));
//	 String text = validate.getText();
//	 System.out.println(text);
//	}

}