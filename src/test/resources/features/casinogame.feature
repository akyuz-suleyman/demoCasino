@casinogame
Feature:As a player, I want to be able to play a casino game and have my balance updated automatically

  Background:
    Given the player is on the home page
    When the player clicks on the Returning User button


  Scenario Outline: Verify that the player can play a Busy Cat game and their balance updates
    When the player provides their valid email address as "<email>"
    Then the player is on the "demo-casino" page
    Then the player clicks on the money button
    Then the player selects the "<deposit option>" deposit option
    Then the player selects the "<deposit amount>" deposit amount
    Then the player confirms the deposit by selecting the "<deposit confirm>" button
    Then the player should see a success message saying "Your deposit was successful!" and then clicks OK button
    Then the player checks their account balance before playing a casino game
    Then the player selects a "Casino" to play
    Then the player selects the desired "<amount>" from the bet options
    Then the player selects the cat at row <row> and column <column>
    Then the player should see a confirmation message
    And the player should see that their balance has been updated after playing a casino game

    Examples:
      | email                 | deposit option | deposit amount | deposit confirm  | amount | row | column |
      | fern.ndo@gmail.com    | Direct Bank    | 100            | Deposit Approved | 5      | 1   | 1      |
      | chris.toper@gmail.com | E-wallet       | 500            | Deposit Approved | 5      | 1   | 2      |


  Scenario Outline: Verify that the player cannot play a Busy Cat game without a deposit
    Then the player provides their valid email address as "<email>"
    Then the player is on the "demo-casino" page
    Then the player checks their account balance before playing a casino game
    Then the player selects a "Casino" to play
    Then the player selects the desired "<amount>" from the bet options
    Then the player selects the cat at row <row> and column <column>
    Then the player should see alert "Lower your bet to play again." message


    Examples:
      | email            | amount | row | column |
      | franco@gmail.com | 5      | 1   | 1      |
      | miller@gmail.com | 5      | 1   | 2      |

