package org.pageobjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.Rsc_Ecom.Utilites;

public class LogoLocator {
	Utilites utils = Utilites.getSingle();
	static WebDriver driver;
	
	public LogoLocator () {
		driver = utils.driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@id='rsc-main-page-logo']")
	private WebElement logo;
	
	@FindBy(xpath = "//img[@id='rsc-main-page-logo']")
	private WebElement logosize;
	
	@FindBy (xpath = "//img[@id='rsc-main-page-logo']")
	private WebElement logocolor;
	

	public WebElement getLogo() {
		return logo;
	}

	public WebElement getLogosize() {
		return logosize;
	}

	public WebElement getLogocolor() {
		return logocolor;
	}

}
