Feature: Login scenarios

  Scenario Outline: Login with invalid username
    Given I enter username as "<username>"
    When I enter password as "<password>"
    And I login
    Then login should fail with error "<errormsg>"

    Examples:
      | username        | password     | errormsg                                                     |
      | invalidUsername | secret_sauce | Username and password do not match any user in this service. |

  Scenario Outline: Login with invalid password
    Given I enter username as "<username>"
    When I enter password as "<password>"
    And I login
    Then login should fail with error "<errormsg>"

    Examples:
      | username      | password        | errormsg                                                     |
      | standard_user | invalidPassword | Username and password do not match any user in this service. |

  Scenario Outline: Login with valid user name and password
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I login
    Then I should see Products page with title "<title>"

    Examples:
      | username      | password     | title    |
      | standard_user | secret_sauce | PRODUCTS |

  Scenario Outline: Logout
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I login
    Then I should see Products page with title "<title>"
    And I click on Menu
    And I click on Logout

    Examples:
      | username      | password     | title    |
      | standard_user | secret_sauce | PRODUCTS |