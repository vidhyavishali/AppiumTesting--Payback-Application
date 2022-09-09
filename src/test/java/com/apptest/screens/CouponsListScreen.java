package com.apptest.screens;

import org.openqa.selenium.WebElement;

import com.apptest.utils.LOCATORS;

public class CouponsListScreen extends AppScreenBase {

	public int getNumberOfCouponsYetToGetActivated() {

		String notActivatedTabXpath = "//android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView";
		WebElement notActivatedTab = getWebElement(LOCATORS.XPATH, notActivatedTabXpath);
		String noOfCouponsRaw = getElementText(notActivatedTab);
		int indexOf1 = noOfCouponsRaw.indexOf("(");
		int indexOf2 = noOfCouponsRaw.indexOf(")");
		return Integer.parseInt(noOfCouponsRaw.substring(indexOf1 + 1, indexOf2));
	}

	public CouponsListScreen activateNthCoupon(int n) {
		if (n < getNumberOfCouponsYetToGetActivated())

			System.out.println("activating");
		String activateButtonXpath = "//android.widget.FrameLayout[" + n
				+ "]/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.view.ViewGroup/android.widget.Button";
		WebElement activateButton = getWebElement(LOCATORS.XPATH, activateButtonXpath);
//		clickElement(activateButton);
		return this;
	}

	public boolean isNthCouponActivated(int n) {

		String activatedIconXpath = "//android.widget.FrameLayout[" + n
				+ "]/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.view.ViewGroup/android.widget.ImageView[@resource-id = 'de.payback.client.android:id/info_icon']";
		WebElement activatedIcon = getWebElement(LOCATORS.XPATH, activatedIconXpath);
		return activatedIcon.isEnabled();

	}
}
