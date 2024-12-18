Feature: Login scenarios

  Scenario Outline: Logout from menu settings
    Given I login with "<username>" and "<password>"
    Then I should see Products page with title "<title>"
    And I click on Menu
    And I click on Logout

    Examples:
      | username      | password     | title    |
      | standard_user | secret_sauce | PRODUCTS |