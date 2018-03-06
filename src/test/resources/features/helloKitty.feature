Feature: HelloKitty test

  @Positive @Sanity
  Scenario: read primary text from text area
    Given I am on HelloKitty application main page
    Then I see "hello world!"

  @Positive
  Scenario: put the text, click the button, get text "hello [entered text]"
    Given I am on HelloKitty application main page
    When I type "Andrey"
    Then I see "hello Andrey!"