Feature: User story for login scenarios

  @sprint1 @smoke @anany1 @regression
  Scenario: Valid admin login
    #Given user is able to access HRMS application
    When user enters valid admin username and password
    And user clicks on login button
    Then user is able to login successfully


  @error
  Scenario: Validate error message
    When user enters invalid admin username and password
    And user clicks on login button
    Then user is able to see error message






