Feature: Basketball England website

  Scenario: Filling out account registration form happy flow
    Given I am using "chrome" as browser
    Given I fill in date of birth is "27/08/1984"
    And I fill in first name "Marie"
    And I fill in last name "Svensson"
    And I fill in email address "svensson-test@gmail.com"
    And confim email address "svensson-test@gmail.com"
    And I choose password "test&12345"
    And I retype password "test&12345"
    And I choose the role "Fan"
    And I confirm terms & conditions
    And I confirm I'm over 18
    And I adhere to code of ethics
    When I confirm and join
    Then I receive a membership number