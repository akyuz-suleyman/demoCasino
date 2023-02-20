@deposit
Feature:As a player, I want to be able to deposit funds into my casino account and verify that the balance has been updatedrectly

  Background:
    Given the player is on the home page
    When the player clicks on the Returning User button


  Scenario Outline: Verify that the user can deposit and check so the balance matches
    When the player provides their valid email address as "<email>"
    Then the player is on the "demo-casino" page
    Then the player checks their account balance before making a deposit
    Then the player clicks on the money button
    Then the player selects the "<deposit option>" deposit option
    Then the player selects the "<deposit amount>" deposit amount
    Then the player confirms the deposit by selecting the "<deposit confirm>" button
    Then the player should see a success message saying "Your deposit was successful!" and then clicks OK button
    And  the player should see that the account balance has been updated after deposit

    Examples:
      | email                 | deposit option | deposit amount | deposit confirm  |
      | fern.ndo@gmail.com    | Card           | 10             | Deposit Approved |
      | jame.hines@gmail.com  | Direct Bank    | 100            | Deposit Approved |
      | chris.toper@gmail.com | E-wallet       | 500            | Deposit Approved |


  Scenario Outline: Verify that the player is canceling a deposit should not change the account balance
    When the player provides their valid email address as "<email>"
    Then the player is on the "demo-casino" page
    Then the player checks their account balance before making a deposit
    Then the player clicks on the money button
    Then the player selects the "<deposit option>" deposit option
    Then the player selects the "<deposit amount>" deposit amount
    Then the player confirms the deposit by selecting the "<deposit cancel>" button
    Then the player should see a success message saying "your deposit was not approved" and then clicks exit
    And the player should see that the account balance has not been changed

    Examples:
      | email                     | deposit option | deposit amount | deposit cancel |
      | franco@gmail.com          | Card           | 10             | Deposit Failed |
      | miller@gmail.com          | Direct Bank    | 100            | Deposit Failed |
      | danielle.thomas@gmail.com | E-wallet       | 500            | Deposit Failed |


