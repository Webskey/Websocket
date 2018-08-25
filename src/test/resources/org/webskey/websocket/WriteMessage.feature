Feature: Write message
  I want to write messages in chat

  Scenario: Messaging in chat
    Given I am connected to chat
    When i write "Hi everyone" message
    And I click send button
    Then My message is displayed in conversation table