Feature: Swap Feature
  As a registered user I want to swap one cryptocurrency for another instantly
  So that I can take advantage of real-time market rates.

  Background: 
    Given user is logged in with valid credentials
    And user navigates to Swap page

  @Swap
  Scenario: Successful Swap Execution
    When the user selects "USDT" as the source currency
    And the user selects "BTC" as the target currency
    And the user enters "100" as the amount to swap
    And the user requests a quote
    And the user confirms the swap
    Then the swap is executed successfully
    And the transaction appears in the swap history

  @Swap
  Scenario: Swap Fails Due to Insufficient Funds
    When the user selects "USDT" as the source currency
    And the user selects "BTC" as the target currency
    And the user enters "1" as the amount to swap
    And the user requests a quote
    And the user confirms the swap
    Then the system displays minimum limit error message
