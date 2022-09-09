package com.apptest.screens;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.apptest.utils.LOCATORS;

public class FilterScreen extends AppScreenBase {

	/*
	 * selects 3rd partner - rewe*/
	public CouponsListScreen selectNthPreferredPartner(int n) {
		String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.cardview.widget.CardView/android.view.ViewGroup/android.widget.ImageView";
		List<WebElement> nthPartner = getWebElementList(LOCATORS.XPATH, xpath);
		clickElement(nthPartner.get(n));
		return new CouponsListScreen();
	
	}
	
	public CouponScreen resetFilter()
	{
		WebElement reset = getWebElement(LOCATORS.ID, "de.payback.client.android:id/coupon_action_reset");
		clickElement(reset);
		return new CouponScreen();
	}
	
	
}
