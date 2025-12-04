package com.achmadirfan.tests.search;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.achmadirfan.framework.core.BaseTest;
import com.achmadirfan.framework.pages.FilterAssert;

public class SearchItemTest extends BaseTest {

	 /**
	 * Ensures that the global search bar returns relevant results
	 * and the system is correctly matching user-entered keywords.
	 *
	 * This method simulates one of the most critical user journeys
	 * on any e-commerce website.
	 */
	
	@Test
	public void verifySearchItem() {
		// TODO Auto-generated method stub
		
		String expectedItem = "MacBook";
		FilterAssert filterAssert = category.searchItem(expectedItem);
		category.selectCategoryDropdown();
		filterAssert.waitForResultToLoad();
		String actualSearchResult = filterAssert.getProductName();	
		Assert.assertTrue(actualSearchResult.contains(expectedItem), 
                "Expected MacBook to be applied but got: " + actualSearchResult);

	}

}
