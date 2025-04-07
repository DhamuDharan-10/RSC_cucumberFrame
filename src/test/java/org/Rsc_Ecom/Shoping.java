package org.Rsc_Ecom;

import java.time.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pageobjectRepo.Shopinglocator;

import com.Base.Rsc_Ecom.Utilites;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;



public class Shoping {
	
	static WebDriverWait Waits;
	Shopinglocator shops = new Shopinglocator();
	Utilites utils = Utilites.getSingle() ;
	static WebDriver driver;
	@Given("Lauch the application RSC {string}")
	public void lauch_the_application_rsc(String laucher) {
																												
	}
	public Shoping() {
		 driver = utils.driver;
	}
	
	@When("user Accept or Dismiss the cookies")
	public void user_accept_or_dismiss_the_cookies() {
		utils.button(shops.getAccept());
	}

	@Then("Validate user lands on the Homepage {string}")
	public void validate_user_lands_on_the_homepage(String url) {
		
	   if (utils.returncurrentUrl().contains(url)) {
		   System.out.println("User navigate to the correct Application");
	   }else {
		   System.out.println("URl is not Working properly");
	   }
	}

	@When("validate the Sub_Models of Shop")
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
	   Waits = new WebDriverWait(driver, Duration.ofSeconds(10));
	    Waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='list-menu list-menu--inline']//descendant::span")));
	//   List <WebElement> SubModels = driver.findElements(By.xpath("//ul[@class='list-menu list-menu--inline']//descendant::span"));
	   for (int i = 0; i < shops.getSubModels().size(); i++) {
		   String ActualResult = shops.getSubModels().get(i).getText().trim();
		    for (String excepted : ExceptedResult) {
		    	 if (excepted.equalsIgnoreCase(ActualResult)) {
					   System.out.println("Required Model: "+ActualResult);
				   }
		    }
		   
		   
	   }
}

	@When("User Clicks on Clothes&Accessories")
	public void user_clicks_on_clothes_accessories() {
	//   WebElement clothes = driver.findElement(By.xpath("//span[text()='Clothing & Accessories']"));
		utils.button(shops.getClothes());
	}

	@Then("Validate DropDown items Displayed")
	public void validate_drop_down_items_displayed() {
	//   WebElement Visiblity = driver.findElement(By.xpath("//ul[@id='HeaderMenu-MenuList-2']"));
	   
	   System.out.println("DropDown is visible: "+utils.returnDisplay(shops.getVisiblity()));
	}

	@When("User Clicks the Search functionality")
	public void user_clicks_the_search_functionality() {
	//  WebElement Search =  driver.findElement(By.xpath("//details-modal[@class='header__search']"));
		utils.button(shops.getSearch());
	}

	@When("User Provide the Keys one dim list")
	public void user_provide_the_keys(DataTable dataTable) { 
		List<String> value= dataTable.asList();
		String key = value.get(0);
	//   WebElement Keys = driver.findElement(By.xpath("//input[@class='search__input field__input']"));
		utils.passkeys(shops.getKeys(), key);
	}

	@Then("validate items in the Description belongs to the Search")
	public void validate_items_in_the_description_belongs_to_the_search() {
		Waits = new WebDriverWait(driver, Duration.ofSeconds(10));
		Waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='predictive-search__item-heading h5']")));
	 //  List <WebElement> SearchResult = driver.findElements(By.xpath("//p[@class='predictive-search__item-heading h5']"));
	   for (int i = 0; i < shops.getSearchResult().size(); i++) {
		   String Products = shops.getSearchResult().get(i).getText();
		   if (utils.returnText(Products).trim().contains("Shirt")) {
			   System.out.println("Result Met With the search: "+Products);
		   }else {
			   System.out.println("Result NotMet With the search: "+Products);
		   }

	   }
	}
	 @When("User Clicks on Books HomeWare and Gifts")
	    public void user_clicks_on_books_home_ware_and_gifts() {
	    //    WebElement homeWare = driver.findElement(By.xpath("//summary[@id='HeaderMenu-homeware-and-gifts']"));
		 utils.button(shops.getBooks());
	    }
	@Then("Validate DropDown of HomeWare items Displayed")
	public void validate_drop_down_of_home_ware_items_displayed() {
	//   WebElement HomeWareList = driver.findElement(By.xpath("//details[@id='Details-HeaderMenu-4']"));
	  boolean display =  utils.returnDisplay(shops.getHomeWare());
	   System.out.println("option is visible: "+display);
	}
	
	@When("user clicks on All_HomeWare")
	public void user_clicks_on_all_home_ware() {
	//  WebElement HomeWare= driver.findElement(By.xpath("//a[@id='HeaderMenu-homeware-and-gifts-all-homeware']"));
		utils.button(shops.getHomeWare());
	}

	@Then("validate Wheather it is move to the current page")
	public void validate_wheather_it_is_move_to_the_current_page() {
	//   WebElement Text = driver.findElement(By.xpath("//div[@class='collection-hero__text-wrapper']"));
	   System.out.println("User navigate to the Current page: "+utils.returnText(shops.getText()));
	}

	@When("user clicks on Color")
	public void user_clicks_on_color() {
	//   WebElement Color= driver.findElement(By.xpath("//details[@id='Details-3-template--14838647521367__product-grid']"));
		utils.button(shops.getColor());
	}

	@Then("Validate the CheckBoxes is Multiple")
	public void validate_the_check_boxes_is_multiple() {
	 int Selected = 0;
	//  List <WebElement> CheckBoxes = driver.findElements(By.xpath("//div[@id='Facet-3-template--14838647521367__product-grid']//descendant::input[contains(@id,'Filter-filter.v.option.colour')]"));
         for (int i = 0; i < shops.getCheckBoxes().size(); i++) {
        	 WebElement CheckBox = shops.getCheckBoxes().get(i);
        	 utils.button(CheckBox, i);
        	 
        	 if(utils.returnSelected(CheckBox)) {
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
		 utils.button(values);
	  
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
	//	List <WebElement> ActualResult = driver.findElements(By.xpath("//ul[@id='HeaderMenu-MenuList-4']//descendant::a"));
		for (int i=0; i < shops.getActualResult().size(); i++) {
		//	String Actual = .getText();
			String Actual = utils.returnText(shops.getActualResult().get(i));
			for (String Except:ExceptResult) {
				if(Actual.equalsIgnoreCase(Except)) {
					System.out.println("Model Releated Item: "+Actual);
				}
			}
		}
	   
	}
	@When("User Clicks on the Account")
	public void user_clicks_on_the_account() {
	//   WebElement Account = driver.findElement(By.xpath("//a[@class='header__icon header__icon--account link focus-inset small-hide']"));
		utils.button(shops.getAccount());
	}

	@When("User provides the username {string}")
	public void user_provides_the_username(String Username) {
	//	 WebElement userNameField = driver.findElement(By.xpath("//input[@id='CustomerEmail']"));
		utils.passkeys(shops.getUserNameField(), Username);
	}
	@When("user provides the Password {string}")
	public void user_provides_the_password(String password) {
	//   WebElement UserPassword = driver.findElement(By.xpath("//input[@id='CustomerPassword']"));
		utils.passkeys(shops.getUserPassword(), password);
	}
	@When("user click on Sign_in")
	public void user_click_on_sign_in() {
	//    WebElement signin = driver.findElement(By.xpath("//div[@id='shopify-section-template--14838647881815__main']//descendant::button[2]"));
		utils.button(shops.getsignin());
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