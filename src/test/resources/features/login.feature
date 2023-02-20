@login
Feature:As a player, I want to be able to login to the casino website

  Background:
    Given the player is on the home page


  Scenario Outline: Verify that player login on the casino website with valid credentials
    When the player clicks on the New Player button
    Then the player confirms their understanding by clicking I Get It Continue
    Then the player provides their valid email address as "<email>"
    Then the player enters their "<country code>" and "<phone number>"
    Then the player provides their full name as "<full name>"
    Then the player enters a password as "<password>"
    Then the player should see a success message saying "Your registration is complete!"
    Then the player clicks the Login button
    Then the player provides their valid email address as "<email>"
    And the player is on the "demo-casino" page


    Examples:
      | email                     | country code | phone number | password | full name       |
      | danielle.thomas@gmail.com | +90          | 5056264735   | demo123  | Danielle Thomas |
      | franco@gmail.com          | +40          | 5346267735   | demo123  | Ivan Franco     |
      | miller@gmail.com          | +444         | 5356264737   | demo123  | James Miller    |


  Scenario Outline: Verify that the player is successfully logged in by using Returning User button
    When the player clicks on the Returning User button
    Then the player provides their valid email address as "<email>"
    And the player is on the "demo-casino" page

    Examples:
      | email                     |
      | franco@gmail.com          |
      | miller@gmail.com          |
      | danielle.thomas@gmail.com |

