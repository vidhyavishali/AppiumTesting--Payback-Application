package com.apptest.screens;

import org.openqa.selenium.WebElement;

import com.apptest.utils.LOCATORS;

public class CouponScreen extends AppScreenBase {

	/**
	 * Clicks on the Partners filter
	 */
	public FilterScreen clickOnFilter() {

		WebElement filter = getWebElement(LOCATORS.ID, "de.payback.client.android:id/filter_button");
		clickElement(filter);
		return new FilterScreen();
	}

}
