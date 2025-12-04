package com.achmadirfan.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.achmadirfan.framework.core.AbstractComponent;

public class CategoryPage extends AbstractComponent{

	WebDriver driver;
	
	public CategoryPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='gh-categories__title']")
	private WebElement categoryDropdown;
	
	@FindBy(xpath="//a[normalize-space()='Cell Phones, Smart Watches & Accessories']")
	private WebElement electronicsCategory;
	
	@FindBy(css=".brwel__item:nth-of-type(4)")
	private WebElement cellPhonesOption;
	
	@FindBy(css=".gh-search-button__label")
	private WebElement searchBtn;
	
	@FindBy(xpath="//input[@id='gh-ac']")
	private WebElement searchBox;
	
	private By searchColumn = By.xpath("//input[@id='gh-ac']");
	private By btnDropdown = By.xpath("//select[@id='gh-cat']");
	
	/**
	 * High-level navigation method to reach the Cell Phones category.
	 * Encapsulates a multi-step UI flow and prevents test classes
	 * from having to click individual elements.
	 *
	 * This keeps tests readable and resilient to UI changes.
	 */
	
	public FilterPage navigateToCellPhonesCategory() {

		categoryDropdown.click();
		electronicsCategory.click();
		cellPhonesOption.click();
		FilterPage filterClass = new FilterPage(driver);
		return filterClass;
	
	}
	
	/**
	 * Provides a simple, reusable way for test classes
	 * to trigger a search operation without interacting
	 * directly with low-level Selenium actions.
	 *
	 * Abstracts "how to search" so tests only focus on "what to search".
	 */
	
	public FilterAssert searchItem(String itemName) {
		
		waitVisibilityElement(searchColumn);
		searchBox.sendKeys(itemName);
		
		return new FilterAssert(driver);
		
	
	}
	
	/**
	 * Offers direct interaction with the category dropdown
	 * for use-cases where selecting categories affects search results.
	 *
	 * Useful when tests require control of search context.
	 */
	
	public void selectCategoryDropdown() {
		
		staticDropdown(btnDropdown);
		searchBtn.click();
		
	}
	
	 /**
	 * Ensures a consistent entry point for all tests.
	 * Avoid hardcoding "ebay.com" in multiple places.
	 */
	
	public void goTo() {
		
		driver.get("https://ebay.com");
		
	}
}
