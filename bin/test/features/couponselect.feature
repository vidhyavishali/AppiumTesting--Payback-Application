
Feature: Coupon Activation

  Scenario Outline: User Filters and activates an active coupon
    Given Navigate to coupon section
    And Filter the coupons by partner as <partner>
    When the coupon list is not empty
    And click on first coupon activation
    And the coupon is valid 
    Then the coupon is activated

    Examples: 
      | partner | 
      | Rewe |   
      | Aral |  
