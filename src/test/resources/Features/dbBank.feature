Feature: Digital Bank

  Background: 
    Given Launch the digital bank application 'http://dbankdemo.com/login' in browser

  @test1
  Scenario Outline: To verify application is able to do fund transfer
    When User gets "<TestCaseID>" to perform fundtransfer
    And User enters the userName and password to log in to application
    And User initiate the fund transfer
    And User inputs the senderAccount, receiverAccount and amount to complete  the fund transfer
    And Verify user completes the fund transfer successfully
    Then User log out the application

    Examples: 
      | TestCaseID |
      | DB001      |
     
