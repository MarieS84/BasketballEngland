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
    And I choose to accept terms & conditions "true"
    And I am of legal age
    And I adhere to code of ethics
    When I confirm and join
    Then I receive a membership number

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
    And I choose to accept terms & conditions "true"
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
    And I choose to accept terms & conditions "true"
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


  Scenario Outline: Filling out account registration form
    Given I am using "<browser>" as browser
    And I fill in date of birth is "<dateOfBirth>"
    And I fill in first name "<firstName>"
    And I fill in last name "<lastName>"
    And I fill in email address
    And confirm email address
    And I choose password "<password>"
    And I retype password "<confirmPassword>"
    And I choose the role "<role>"
    And I choose to accept terms & conditions "<acceptTerms>"
    And I am of legal age
    And I adhere to code of ethics
    When I confirm and join
    Then <expectedResult>

    Examples:
      | browser | dateOfBirth | firstName | lastName | password   | confirmPassword | role                     | acceptTerms | expectedResult                                                                                                           |
      | edge    | 27/08/1984  | Marie     | Svensson | test&12345 | test&12345      | signup_basketballrole_19 | true        | I receive a membership number                                                                                            |
      | edge    | 27/08/1984  | Marie     |          | test&12345 | test&12345      | signup_basketballrole_19 | true        | I get the warning message "Last Name is required"                                                                        |
      | chrome  | 27/08/1984  | Marie     | Svensson | test&12345 | test&123456     | signup_basketballrole_19 | true        | I get the password warning message "Password did not match"                                                              |
      | chrome  | 27/08/1984  | Marie     | Svensson | test&12345 | test&12345      | signup_basketballrole_19 | false       | I get the terms & conditions warning message "You must confirm that you have read and accepted our Terms and Conditions" |