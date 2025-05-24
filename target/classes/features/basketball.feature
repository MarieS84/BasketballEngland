Feature: Basketball England registration form website test

  Scenario: Filling out account registration form happy flow
    Given I am using "chrome" as browser
    Given I fill in date of birth is "27/08/1984"
    And I fill in first name "Marie"
    And I fill in last name "Svensson"
    And I fill in email address
    And confirm email address
    And I choose password "test&12345"
    And I retype password "test&12345"
    And I choose the role "signup_basketballrole_19"
    And I confirm terms & conditions
    And I am of legal age
    And I adhere to code of ethics
    When I confirm and join
    Then I receive a membership number

  Scenario Outline: Filling out account registration form with different user data
    Given I am using "<browser>" as browser
    Given I fill in date of birth is "27/08/1984"
    And I fill in first name "<first_name>"
    And I fill in last name "<last_name>"
    And I fill in email address
    And confirm email address
    And I choose password "test&12345"
    And I retype password "test&12345"
    And I choose the role "signup_basketballrole_19"
    And I confirm terms & conditions
    And I am of legal age
    And I adhere to code of ethics
    When I confirm and join
    Then I receive a membership number

    Examples:
      | browser | first_name | last_name |
      | chrome  | Marie      | Svensson  |
      | edge    | Kalle      | Johansson |


  Scenario: Filling out account registration form, last name is missing
    Given I am using "chrome" as browser
    Given I fill in date of birth is "27/08/1984"
    And I fill in first name "Marie"
    And I fill in last name ""
    And I fill in email address
    And confirm email address
    And I choose password "test&12345"
    And I retype password "test&12345"
    And I choose the role "signup_basketballrole_19"
    And I confirm terms & conditions
    And I am of legal age
    And I adhere to code of ethics
    When I confirm and join
    Then I get the warning message "Last Name is required"

  Scenario: Filling out account registration form, passwords don't match
    Given I am using "chrome" as browser
    Given I fill in date of birth is "27/08/1984"
    And I fill in first name "Marie"
    And I fill in last name "Svensson"
    And I fill in email address
    And confirm email address
    And I choose password "test&12345"
    And I retype password "test&123456"
    And I choose the role "signup_basketballrole_19"
    And I confirm terms & conditions
    And I am of legal age
    And I adhere to code of ethics
    When I confirm and join
    Then I get the password warning message "Password did not match"

  Scenario: Filling out account registration form, I don't confirm terms & conditions
    Given I am using "chrome" as browser
    Given I fill in date of birth is "27/08/1984"
    And I fill in first name "Marie"
    And I fill in last name "Svensson"
    And I fill in email address
    And confirm email address
    And I choose password "test&12345"
    And I retype password "test&12345"
    And I choose the role "signup_basketballrole_19"
    And I am of legal age
    And I adhere to code of ethics
    When I confirm and join
    Then I get the terms & conditions warning message "You must confirm that you have read and accepted our Terms and Conditions"