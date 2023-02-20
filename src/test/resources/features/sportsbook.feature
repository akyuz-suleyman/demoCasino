@sportsbook
Feature: As a player, I want to be able to place bets on my preferred sports events on the casino website

  Background:
    Given the player is on the home page
    When the player clicks on the Returning User button


  Scenario Outline:Verify that the user can bet on a sports event and balance updates
    When the player provides their valid email address as "<email>"
    Then the player is on the "demo-casino" page
    Then the player clicks on the money button
    Then the player selects the "<deposit option>" deposit option
    Then the player selects the "<deposit amount>" deposit amount
    Then the player confirms the deposit by selecting the "<deposit confirm>" button
    Then the player should see a success message saying "Your deposit was successful!" and then clicks OK button
    Then the player checks their account balance before betting on a sports event
    Then the player selects a "Sportsbook" to play
    Then the player selects the desired "<sports category>" and "<sports tournament>"
    Then the player selects the "<game team>" and "<betting option>"
    Then increases the bet amount by <bet amount> using the "+" button
    Then places the bet on the selected sports event
    Then the player should see a "Bet placed!" message
    Then clicks the Clear cart button
    And the player should be able to see that the balance has been updated after betting on a sports event


    Examples:
      | email                 | deposit option | deposit amount | deposit confirm  | sports category   | sports tournament | game team                             | betting option | bet amount |
      | james.hines@gmail.com | Direct Bank    | 100            | Deposit Approved | Football          | Premier League    | Liverpool - Everton                   | 1              | 5          |
      | fern.ndo@gmail.com    | Direct Bank    | 100            | Deposit Approved | Football          | Champions League  | Liverpool - Barcelona FC              | 2              | 3          |
      | james.hines@gmail.com | Direct Bank    | 100            | Deposit Approved | American Football | NFL               | Denver Broncos - Kansas City Chiefs   | 1              | 4          |
      | franco@gmail.com      | Direct Bank    | 100            | Deposit Approved | Hockey            | NHL               | Colorado Avalanche - Detroit Red Wing | 3              | 4          |

  Scenario Outline:Verify that the user cannot bet on a sports event without deposit
    When the player provides their valid email address as "<email>"
    Then the player is on the "demo-casino" page
    Then the player selects a "Sportsbook" to play
    Then the player selects the desired "<sports category>" and "<sports tournament>"
    Then the player selects the "<game team>" and "<betting option>"
    Then increases the bet amount by <bet amount> using the "+" button
    Then places the bet on the selected sports event
    And  the player should see alert "Bet amount is larger than your balance, try lowering your bet or make an deposit to finish bet." message


    Examples:
      | email            | sports category   | sports tournament | game team                             | betting option | bet amount |
      | ferry@gmail.com  | Football          | Premier League    | Liverpool - Everton                   | 1              | 5          |
      | ammymi@gmail.com | Football          | Champions League  | Liverpool - Barcelona FC              | 2              | 3          |
      | ferry@gmail.com  | American Football | NFL               | Denver Broncos - Kansas City Chiefs   | 1              | 4          |
      | ammymi@gmail.com | Hockey            | NHL               | Colorado Avalanche - Detroit Red Wing | 3              | 4          |


  Scenario Outline:Verify that the user can bet on a sports event without entering an amount
    When the player provides their valid email address as "<email>"
    Then the player is on the "demo-casino" page
    Then the player clicks on the money button
    Then the player selects the "<deposit option>" deposit option
    Then the player selects the "<deposit amount>" deposit amount
    Then the player confirms the deposit by selecting the "<deposit confirm>" button
    Then the player should see a success message saying "Your deposit was successful!" and then clicks OK button
    Then the player checks their account balance before betting on a sports event
    Then the player selects a "Sportsbook" to play
    Then the player selects the desired "<sports category>" and "<sports tournament>"
    Then the player selects the "<game team>" and "<betting option>"
    Then increases the bet amount by <bet amount> using the "+" button
    Then places the bet on the selected sports event
    And  the player shouldn't see a "Bet placed!" message


    Examples:
      | email                    | deposit option | deposit amount | deposit confirm  | sports category | sports tournament | game team                | betting option | bet amount |
      | chris.toper@gmail.com    | Direct Bank    | 100            | Deposit Approved | Football        | Premier League    | Liverpool - Everton      | 1              | 0          |
      | suleyman.aqyuz@gmail.com | Direct Bank    | 100            | Deposit Approved | Football        | Champions League  | Liverpool - Barcelona FC | 2              | 0          |


