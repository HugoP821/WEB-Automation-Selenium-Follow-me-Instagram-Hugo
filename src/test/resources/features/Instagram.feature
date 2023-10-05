@Instagram
Feature: Test Instagram search functionality

  @Follow
  Scenario: As a user when I search for hugo user, I want to see the user of de owner of code of this project.
    Given the user navigates to www.instagram.com
    And login with your user userInstagram
    And login with your password passwordInstagram
    And selects the login button
    And search hugo user hug.paal
    And click in follow user
    Then the user is followed