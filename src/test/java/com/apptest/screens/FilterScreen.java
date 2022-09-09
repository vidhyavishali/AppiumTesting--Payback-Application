package com.apptest.screens;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.apptest.utils.LOCATORS;

public class FilterScreen extends AppScreenBase {

	/**
	 * Locates the nth partner card in the list.
	 */
	public CouponsListScreen selectNthPreferredPartner(int n) {
		String nthPartnerXpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id ='de.payback.client.android:id/list']/android.widget.FrameLayout["
				+ n
				+ "]/android.view.ViewGroup/androidx.cardview.widget.CardView[@resource-id ='de.payback.client.android:id/card']";
		WebElement nthPartner = getWebElement(LOCATORS.XPATH, nthPartnerXpath);
		clickElement(nthPartner);
		logger.info(n + " th partner is selected");
		return new CouponsListScreen();

	}

	/**
	 * Resets the provided filter details
	 */
	public CouponScreen resetFilter() {
		WebElement reset = getWebElement(LOCATORS.ID, "de.payback.client.android:id/coupon_action_reset");
		clickElement(reset);
		logger.info("Filter is reset");
		return new CouponScreen();
	}

}
