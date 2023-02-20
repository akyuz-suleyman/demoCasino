@registiration
Feature:As a player, I want to register on the casino

  Background:
    Given the player is on the home page
    When the player clicks on the New Player button
    Then the player confirms their understanding by clicking I Get It Continue


  Scenario Outline: Verify player registration on the casino website with valid credentials
    When the player provides their valid email address as "<email>"
    Then the player enters their "<country code>" and "<phone number>"
    Then the player provides their full name as "<full name>"
    Then the player enters a password as "<password>"
    And the player should see a success message saying "Your registration is complete!"


    Examples:
      | email                 | country code | phone number | password | full name          |
      | fern.ndo@gmail.com   | +90          | 5356264735   | demo123  | Fernando Fuentes   |
      | chris.toper@gmail.com | +45          | 53462647351  | demo123  | Christopher Howell |
      | jame.hines@gmail.com  | +46          | 53562647355  | demo123  | James Hines        |
      | ammymi@gmail.com      | +32          | 535626473    | demo123  | Amy Smith          |
      | ferry@gmail.com       | +32          | 5356262735   | demo123  | Ferry Suite        |


  Scenario Outline: Verify player cannot register with invalid email address
    When the player provides their valid email address as "<invalid email>"
    And the player cannot move to the next step


    Examples:
      | invalid email |
      |               |
      | aleusfx.sas   |
      | 12347         |


  Scenario Outline: Verify player cannot register with invalid  fullname
    When the player provides their valid email address as "<email>"
    Then the player enters their "<country code>" and "<phone number>"
    Then the player provides their full name as "<invalid full name>"
    And the player cannot move to the next step


    Examples:
      | email                | country code | phone number | invalid full name |
      | sn.aqssufy@gmail.com | +90          | 5356264735   | 1234 133          |
      | aleudsfx@gmail.com   | +46          | 5356264735   | '3?..             |
      | ariufdsel@gmail.com  | +46          | 5356264735   |                   |

