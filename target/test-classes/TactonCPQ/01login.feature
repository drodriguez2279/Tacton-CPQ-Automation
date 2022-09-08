#Author: Dahiana Rodriguez
@SmokeTest1
Feature: Login
@SmokeTest1
  Scenario: Test successful login
    Given browser is opened
    #And user navigates to the login page
    And user enters username and password
    And close browser