
Feature: Coupon Activation

Background: Given Start with Home screen

  Scenario Outline: Logged in User Filters and activates an active coupon
    Given Navigate to coupon section
    When Filter the coupons by partner as <partner>
    And the coupon list is not empty
    And click on first coupon activation
    Then the coupon is activated

    Examples: 
      | partner | 
      | Rewe |
      | Aral |