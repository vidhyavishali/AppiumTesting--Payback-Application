package com.apptest.steps;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;

import com.apptest.screens.CouponScreen;
import com.apptest.screens.CouponsListScreen;
import com.apptest.screens.FilterScreen;
import com.apptest.screens.HomeScreen;
import com.apptest.utils.appUtils.PreferredPartners;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CouponActivationSteps {

	private final static Logger logger = Logger.getLogger(CouponActivationSteps.class);

	CouponScreen couponScr;
	FilterScreen filterScr;
	CouponsListScreen couponListScr;
	boolean couponsAvailability;
	int numberOfCoupons = 0;

	@Given("^Navigate to coupon section$")
	public void navigate_to_coupon_section() throws Throwable {
		couponScr = new HomeScreen().clickOnCoupons();
	}

	@When("^Filter the coupons by partner as (.+)$")
	public void filter_the_coupons_by_partner_as(String partner) throws Throwable {
		Integer partnerIndex = PreferredPartners.getPartner(partner);
		if (partnerIndex != null) {
			couponListScr = couponScr.clickOnFilter().selectNthPreferredPartner(partnerIndex);
		} else
			logger.error("Specified Partner: " + partner + " with partner index: " + partnerIndex
					+ " is not available in our partners list");
	}

	@And("^the coupon list is not empty$")
	public void the_coupon_list_is_not_empty() throws Throwable {
		{
			numberOfCoupons = couponListScr.getNumberOfCouponsYetToGetActivated();
			if (numberOfCoupons > 0)
				couponsAvailability = true;
			else
				logger.error("Coupons from partner not available");
		}

	}

	@And("^click on coupon number (\\d+) activation$")
	public void click_on_nth_coupon_activation(int n) throws Throwable {
		if (couponsAvailability && numberOfCoupons >= n)
			couponListScr.activateNthCoupon(n);
		else
			logger.error("Required Coupon " + n + " is not available. Number of available coupons :" + numberOfCoupons);
	}

	@Then("^the coupon is activated$")
	public void the_coupon_is_activated() throws Throwable {
		boolean couponActivationStatus = couponListScr.isNthCouponActivated(1);
		assertTrue(couponActivationStatus);

	}

}
