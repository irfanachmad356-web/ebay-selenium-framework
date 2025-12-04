package com.achmadirfan.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.achmadirfan.framework.core.AbstractComponent;

public class FilterAssert extends AbstractComponent {

	WebDriver driver;
	
	public FilterAssert(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".brwr__list .brwr__item--applied")
	private WebElement appliedFilterText;
	
	@FindBy(xpath="//span[.='MacBook']")
	private WebElement productName;
	
	By textItem = By.xpath("//span[.='MacBook']");
	
	 /**
	 * Returns the text shown in the applied filter box.
	 * Keeping this logic separate from filter actions ensures
	 * a clean separation between performing actions and validating results.
	 */
	
	public String getAppliedFilter() {
		return appliedFilterText.getText();
	}
	
	 /**
	 * Ensures that the results page has fully loaded before extracting data.
	 * Prevents flaky tests caused by interacting with elements too early.
	 */
	
	public void waitForResultToLoad() {
		waitVisibilityElement(textItem);
	}
	
	 /**
	 * Retrieves the validated product name displayed in the results.
	 * Used for assertions that confirm whether the UI reflects
	 * the correct search term or filtering action.
	 */
	
	public String getProductName() {
		return productName.getText();
	}
	
}
