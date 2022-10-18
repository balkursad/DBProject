Feature: Homepage features.

  User Story:
  1.User should be able to click and reach the module pages.
  2.User should be able to see travel information on select page.
  3.User should see the error message when enter nothing on von box
  4.User should see the error message when enter nothing on nach box

      Background: User is expected to be on homepage
      Given user is on the Homepage
      And accept all cookies
  @firstCase
      Scenario Outline: Check to reach the modules
      When user clicks the "<modules>"
      Then verify that user is on related "<modules>" page

      Examples:
      |modules|
      |Tickets & Angebote|
      |Info & Services|
      |Geschäftskunden|

  @secondCase
      Scenario: User should be able to see travel information on select page.
      When user enter the "Mainz Hbf" on von box
      And user enter the "Ingelheim" on nach box
      And user select the next day with using arrow near the date data
      And user click timeset and type 2000
      And user select zwei reisende Personen
      And user select first age gap '27-64'
      And user select second age gap '0-5'
      And user select first class
      And user click suchen button
      Then verify that the information top on the page match with entered data

  @thirdCase
      Scenario: User should see the error message when enter nothing on von box
      When user enter the "Mainz Hbf" on von box
      And user click suchen button
      And user click again suchen button on the select page
      Then verify that there is error message about filling nach Box

  @fourthCase
      Scenario: User should see the error message when enter nothing on nach box
      When user enter the "Ingelheim" on nach box
      And user click suchen button
      And user click again suchen button on the select page
      Then verify that there is error message about filling von Box



