Feature: Adding employees using different ways


  Background:
        #Given user is able to access HRMS application
        When user enters valid admin username and password
        And user clicks on login button
        Then user is able to login successfully
        When user clicks on PIM option
        And user clicks on add employee option

  @smoke @tamana
  Scenario: Adding employee simply using selenium
    When user enters employee first name and middle name and last name
    And user clicks on save button
    Then user is able to see employee added successfully

  @test
  Scenario: Adding employee using parameters
    When user enters employee "dayae" and "ms" and "shoaiby" values
    And user clicks on save button
    Then user is able to see employee added successfully

  @examples @regression
  Scenario Outline: Adding multiple employees using scenario outline
    When user enters employee value "<firstname>" and "<middlename>" and "<lastname>"
    And user clicks on save button
    Then user is able to see employee added successfully
    Examples:
      | firstname | middlename | lastname |
      |tamana     |ms          |anany     |
      |hamid      |ms          |ahmed     |
      |kevin      |ms          |adams     |

  @datatable @regression
  Scenario: Adding employees using data table
    When user enters employee value for firstname , middlename and lastname and save the employees.
     | firstname | middlename | lastname |
     | tamana    | ms         | anany    |
     | hamid     | ms         | ahmed    |
     | kevin     | ms         | adams    |

  @excel
  Scenario: Adding employees using excel file
    When user enters employee value for firstname , middlename and lastname using excel file and save the employees











