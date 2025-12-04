package com.achmadirfan.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.achmadirfan.framework.core.AbstractComponent;

public class FilterPage extends AbstractComponent{

	WebDriver driver;
	
	public FilterPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h3[@aria-label='Item location']")
	private WebElement btnLocation;
	
	@FindBy(xpath="//label[.='North America']")
	private WebElement btnNorthAmericaLabel;
	
	@FindBy(css=".btn-submit.btn.btn--primary")
	private WebElement btnSaveLocation;
	
	@FindBy(css=".brwr__list .brwr__item:nth-of-type(8)")
	private WebElement btnPriceFilter;
	
	@FindBy(css=".brwr__list .brwr__item:nth-of-type(6)")
	private WebElement btnConditionFilterMenu;
	
	@FindBy(xpath="//button[@class='filter-button filter-button--unselected brwr__all-filters']")
	private WebElement btnAllFilters;
	
	@FindBy(xpath="//*[contains(text(),'Under')]")
	private WebElement checkboxUnderPrice;
	
	@FindBy(xpath="//span[normalize-space()='Open box']")
	private WebElement checkboxOpenBox;
	
	By itemLocationSection = By.xpath("//h3[@aria-label='Item location']");
	
	 /**
	 * Applies the "Open Box" condition filter.
	 * This method exists to keep filter operations reusable and readable,
	 * and allows UI changes to be updated in one location.
	 */
	
	public void applyOpenBoxCondition() {
		
		btnConditionFilterMenu.click();
		checkboxOpenBox.click();
	
	}
	
	 /**
	 * Abstracts the logic for entering a price filter.
	 * Encapsulating this behavior prevents tests from depending
	 * on UI details like input fields and button positions.
	 */
	
	public void applyUnderPriceFilter() {
		
		btnPriceFilter.click();
		checkboxUnderPrice.click();
		
	}
	
	 /**
	 * Applies the geographic filter for "North America".
	 * This method expresses business intention rather than UI actions,
	 * improving test clarity and reducing maintenance cost.
	 */
	
	public FilterAssert applyLocationNorthAmerica() {
		
		btnAllFilters.click();
		scrollToView(itemLocationSection);
		btnLocation.click();
		btnNorthAmericaLabel.click();
		btnSaveLocation.click();
		
		return new FilterAssert(driver);
		
	}
}
