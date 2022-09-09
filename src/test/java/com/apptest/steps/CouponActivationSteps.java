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
	boolean couponsAvailablity;

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
			logger.error("Specified Partner is not available in our partners list");
	}

	@And("^the coupon list is not empty$")
	public void the_coupon_list_is_not_empty() throws Throwable {
		{
			int numberOfCoupons = couponListScr.getNumberOfCouponsYetToGetActivated();
			if (numberOfCoupons > 0)
				couponsAvailablity = true;
		}

	}

	@And("^click on first coupon activation$")
	public void click_on_first_coupon_activation() throws Throwable {
		if(couponsAvailablity)
		couponListScr.activateNthCoupon(1);
	}

	@Then("^the coupon is activated$")
	public void the_coupon_is_activated() throws Throwable {
		boolean couponActivationStatus = couponListScr.isNthCouponActivated(1);
		assertTrue(couponActivationStatus);
	}

}
