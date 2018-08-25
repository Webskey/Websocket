Feature: Join Chat
  I want to connect to chat with specified username

  Scenario: Connect to chat succeed
    Given I am on Home Page
    When I enter "MyName"
    And I click connect
    Then I joined chat

  Scenario: Connect to chat failed
    Given I am on Home Page
    When I click connect
    Then I failed to join chat