Feature: Coupon Activation

  Background: Given User is logged in and starts with Home screen

  Scenario Outline: Logged in User Filters and activates an active coupon
    Given Navigate to coupon section
    When Filter the coupons by partner as <partner>
    And the coupon list is not empty
    And click on coupon number <n> activation
    Then the coupon is activated

    Examples: 
      | Rewe | 1 |
      | Aral | 1 |
