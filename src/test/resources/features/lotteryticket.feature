@lotteryticket
Feature: As a player, I want to be able to buy lottery tickets on the casino website

  Background:
    Given the player is on the home page
    Then the player clicks on the Returning User button

  Scenario Outline: Verify that the player can buy lottery ticket and the balance is updated
    When the player provides their valid email address as "<email>"
    Then the player is on the "demo-casino" page
    Then checks their account balance before buying a lottery ticket
    Then the player selects a "Lottery" to play
    Then chooses to spend "<draw amount>" on the ticket
    Then purchases the lottery ticket
    And the player should see that their balance has been updated after the purchase

    Examples:
      | email                 | draw amount |
      | fern.ndo@gmail.com    | 2           |
      | chris.toper@gmail.com | 3           |
      | jame.hines@gmail.com  | 5           |


  Scenario Outline: Verify that the player can add another ticket
    When the player provides their valid email address as "<email>"
    Then the player is on the "demo-casino" page
    Then checks their account balance before buying a lottery ticket
    Then the player selects a "Lottery" to play
    Then  the player should be able to add another ticket to their current session

    Examples:
      | email                 |
      | fern.ndo@gmail.com    |
      | chris.toper@gmail.com |
      | jame.hines@gmail.com  |


  Scenario: Verify that when the player selects numbers on the ticket, they are limited to a maximum of 7 numbers
    When the player provides their valid email address as "suleyman.aqyuz@gmail.com"
    Then the player is on the "demo-casino" page
    Then checks their account balance before buying a lottery ticket
    Then the player selects a "Lottery" to play
    Then  the player should be able to add another ticket to their current session
    And The player should not be able to select eight numbers on the ticket
      | 46 |
      | 35 |
      | 32 |
      | 34 |
      | 25 |
      | 13 |
      | 23 |
      | 12 |

