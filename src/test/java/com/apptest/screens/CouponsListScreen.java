package com.apptest.screens;

import org.openqa.selenium.WebElement;

import com.apptest.utils.LOCATORS;

public class CouponsListScreen extends AppScreenBase {
	/**
	 * Locates the Tab "Nicht Aktiviert" and retrieves the number of coupons from
	 * its text.
	 */
	public int getNumberOfCouponsYetToGetActivated() {

		String notActivatedTabXpath = "//android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView";
		WebElement notActivatedTab = getWebElement(LOCATORS.XPATH, notActivatedTabXpath);
		String noOfCouponsRaw = getElementText(notActivatedTab);
		int indexOf1 = noOfCouponsRaw.indexOf("(");
		int indexOf2 = noOfCouponsRaw.indexOf(")");
		return Integer.parseInt(noOfCouponsRaw.substring(indexOf1 + 1, indexOf2));
	}

	/**
	 * Locates the specified nth coupon's activation button and clicks them.
	 */
	public CouponsListScreen activateNthCoupon(int n) {

		String activateButtonXpath = "//android.widget.FrameLayout[" + n
				+ "]/android.widget.FrameLayout[@resource-id = 'de.payback.client.android:id/coupon']//android.widget.Button[@resource-id='de.payback.client.android:id/not_activated_button']";
		WebElement activateButton = getWebElement(LOCATORS.XPATH, activateButtonXpath);
		clickElement(activateButton);
		logger.info(n + " th coupon is activated");

		return this;
	}

	/**
	 * Locates the nth coupon and checks if its activated icon is enabled.
	 */
	public boolean isNthCouponActivated(int n) {

		String activatedIconXpath = "//android.widget.FrameLayout[" + n
				+ "]/android.widget.FrameLayout[@resource-id = 'de.payback.client.android:id/coupon']//android.widget.ImageView[@resource-id = 'de.payback.client.android:id/activated_icon']";
		WebElement activatedIcon = getWebElement(LOCATORS.XPATH, activatedIconXpath);
		return activatedIcon.isEnabled();

	}
}
