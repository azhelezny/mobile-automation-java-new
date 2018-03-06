Feature: HelloKitty test

  @Positive @Sanity
  Scenario: read primary text from text area
    Given I am on HelloKitty application main page
    Then I see "Large Text"

  @Positive @Sanity
  Scenario: put the text, click the button, get text "hello [entered text]"
    Given I am on HelloKitty application main page
    And I type "Andrey"
    When I press the button
    Then I see "Hello, Andrey"