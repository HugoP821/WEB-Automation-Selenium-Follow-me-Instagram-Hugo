@Instagram
Feature: Test Instagram search functionality

  @Cart
  Scenario: As a user when I search for hugo user, I want to see the user of de owner of code of this project.
    Given the user navigates to www.instagram.com
    And login with your user
    And login with your password
    And selects the login button
    And search hugo user
    And click in follow user hugo
    Then the user is followed