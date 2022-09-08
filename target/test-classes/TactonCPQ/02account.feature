#Author: Dahiana Rodriguez
Feature: Account Page

  Background: User is Logged In
    Given browser is opened
    And user navigates to the login page
    And user enters username and password
    And user clicks in Account page
    And user enters account in filter
    And user clicks in search
    And user clicks in record

  @SmokeTest1
  Scenario: Account Search
    Given account details page is displayed
    And close browser

  @SmokeTest
  Scenario: Create Opportunity
    Given user clicks in Create Opportunity
    Then form is displayed
    And user enters information
    And user clicks in Create
    And opportunity details page is displayed
    #And close browser
