package com.achmadirfan.tests.filters;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.achmadirfan.framework.core.BaseTest;
import com.achmadirfan.framework.pages.FilterAssert;
import com.achmadirfan.framework.pages.FilterPage;

public class CellPhonesFilterTest extends BaseTest {

	 /**
	 * Verifies the correctness of combined filtering,
	 * which represents a real user's behavior when narrowing down products.
	 *
	 * This method ensures the system correctly aggregates multiple filters
	 * and communicates them back to the user.
	 */
	
	@Test
	public void verifyFilterOnCellPhones() {
		// TODO Auto-generated method stub
		
		String totalfilter = "3";
		FilterPage filter = category.navigateToCellPhonesCategory();
		filter.applyOpenBoxCondition();
		filter.applyUnderPriceFilter();
		FilterAssert verify = filter.applyLocationNorthAmerica();
		String confirmMessage = verify.getAppliedFilter();
		Assert.assertTrue(confirmMessage.contains(totalfilter), 
                "Expected 3 filters to be applied but got: " + confirmMessage);
		
	}

}
