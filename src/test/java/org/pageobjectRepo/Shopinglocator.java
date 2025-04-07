package org.pageobjectRepo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.Rsc_Ecom.Utilites;

public class Shopinglocator {
	
	Utilites utils = Utilites.getSingle();
	static WebDriver driver;
	
	public Shopinglocator() {
		driver = utils.driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[text()='Reject All' and @id='onetrust-reject-all-handler']")
	private WebElement Accept;
	
	@FindBy(xpath= "//ul[@class='list-menu list-menu--inline']//descendant::span")
	private List<WebElement> SubModels;
	
	@FindBy(xpath = "//span[text()='Clothing & Accessories']")
	private WebElement clothes;
	
	@FindBy (xpath = "//ul[@id='HeaderMenu-MenuList-2']")
	private WebElement Visiblity;
	
	@FindBy (xpath = "//details-modal[@class='header__search']")
	private WebElement Search;
	
	@FindBy (xpath = "//input[@class='search__input field__input']")
	private WebElement Keys;
	
	@FindBy(xpath = "//p[@class='predictive-search__item-heading h5']")
	private List<WebElement> SearchResult;
	
	@FindBy (xpath ="//summary[@id='HeaderMenu-homeware-and-gifts']")
	private WebElement Books;
	
	@FindBy (xpath="//details[@id='Details-HeaderMenu-4']")
	private WebElement HomeWareList;
	
	@FindBy (xpath="//a[@id='HeaderMenu-homeware-and-gifts-all-homeware']")
	private WebElement HomeWare;
	
	@FindBy (xpath="//div[@class='collection-hero__text-wrapper']")
	private WebElement Text;
	
	@FindBy (xpath = "//details[@id='Details-3-template--14838647521367__product-grid']")
	private WebElement color;
	
	@FindBy (xpath = "//div[@id='Facet-3-template--14838647521367__product-grid']//descendant::input[contains(@id,'Filter-filter.v.option.colour')]")
    private List<WebElement> CheckBoxes;
	
	@FindBy (xpath = "//ul[@id='HeaderMenu-MenuList-4']//descendant::a")
	private List<WebElement> ActualResult;
	
	@FindBy (xpath = "//a[@class='header__icon header__icon--account link focus-inset small-hide']")
	private WebElement Account;
	
	@FindBy (xpath = "//input[@id='CustomerEmail']")
	private WebElement userNameField;
	
	@FindBy (xpath = "//input[@id='CustomerPassword']")
	private WebElement UserPassword;
	
	@FindBy (xpath = "//div[@id='shopify-section-template--14838647881815__main']//descendant::button[2]")
	private WebElement signin;
	
	public WebElement getsignin() {
		return signin;
	}

	public WebElement getAccept() {
		return Accept;
	}

	public List<WebElement> getSubModels() {
		return SubModels;
	}

	public WebElement getClothes() {
		return clothes;
	}

	public WebElement getVisiblity() {
		return Visiblity;
	}

	public WebElement getSearch() {
		return Search;
	}

	public WebElement getKeys() {
		return Keys;
	}

	public List<WebElement> getSearchResult() {
		return SearchResult;
	}

	public WebElement getBooks() {
		return Books;
	}

	public WebElement getHomeWareList() {
		return HomeWareList;
	}

	public WebElement getHomeWare() {
		return HomeWare;
	}

	public WebElement getText() {
		return Text;
	}

	public WebElement getColor() {
		return color;
	}

	public List<WebElement> getCheckBoxes() {
		return CheckBoxes;
	}

	public List<WebElement> getActualResult() {
		return ActualResult;
	}

	public WebElement getAccount() {
		return Account;
	}

	public WebElement getUserNameField() {
		return userNameField;
	}

	public WebElement getUserPassword() {
		return UserPassword;
	}

	public WebElement getSignin() {
		return signin;
	}
}
