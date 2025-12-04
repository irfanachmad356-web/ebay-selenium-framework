package com.achmadirfan.framework.core;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * WHY THIS CLASS EXISTS:
 * AbstractComponent provides reusable UI interaction utilities that are shared 
 * across all Page Objects. Instead of duplicating scrolling, waiting, or dropdown 
 * logic in multiple classes, we place them here to ensure consistency and reduce maintenance.
 *
 * PURPOSE:
 * - Encapsulate low-level Selenium operations (scrolling, waits, dropdown handling)
 * - Improve readability of Page Object classes by removing repeated logic
 * - Allow Page Objects to focus on business actions rather than Selenium mechanics
 *
 * BENEFIT:
 * Any fix or enhancement to common UI behavior only needs to be made once here.
 */

public class AbstractComponent {

	WebDriver driver;
	String categories = "Computers/Tablets & Networking";
	
	public AbstractComponent(WebDriver driver) {
		 
		/**
         * All Page Objects inherit this class, so they must share the same WebDriver instance.
         * Initializing PageFactory here ensures that subclasses do not need to repeat it.
         *
         * This constructor guarantees a consistent setup for every Page Object.
         */
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	 /**
     * Web elements are not always visible on screen, especially in dynamic websites.
     * Scrolling manually in every Page Object would cause duplication and increase fragility.
     *
     * This method provides a reliable, reusable way to:
     * - Bring elements into view
     * - Ensure they are clickable before interaction
     *
     * It prevents common Selenium issues such as ElementNotInteractableException.
     */
	
	public void scrollToView(By findBy) {
		
		WebElement target = driver.findElement(findBy);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		((JavascriptExecutor)driver).executeScript(
		    "arguments[0].scrollIntoView(true);", 
		    target
		);

		wait.until(ExpectedConditions.elementToBeClickable(findBy));
	}
	
	 /**
     * Many failures in Selenium happen because the element is not yet visible 
     * (even though it exists in the DOM).  
     *
     * This method centralizes the visibility wait so Page Objects do not need
     * to repeatedly configure WebDriverWait.
     *
     * BENEFIT:
     * - Reduces flakiness
     * - Ensures Page Objects wait for stable UI before interacting
     */
	
	public void waitVisibilityElement(By findBy) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	 /**
     * Selecting from a <select> static dropdown requires special handling in Selenium
     * using the Select class. Putting that logic directly inside Page Objects would
     * clutter them with technical details.
     *
     * This method abstracts:
     * - Locating the dropdown
     * - Creating the Select object
     * - Choosing the correct visible text
     *
     * WHY categories IS STORED HERE:
     * This class holds the default category value because multiple Page Objects 
     * may rely on the same selection behavior.
     */
	
	public void staticDropdown(By findBy) {
		
		WebElement staticDropdown = driver.findElement(findBy);
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByVisibleText(categories);
		
	}
}
