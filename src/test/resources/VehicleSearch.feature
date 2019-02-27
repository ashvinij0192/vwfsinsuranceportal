Feature: VehicleSearch
    Scenario: Verify vehicle search with valid input
      Given I am on dealer portal page
      Then I see Drive Away Insurance title of dealer search
      And I see Please enter the vehicle registration subtitle of dealer search
      When I enter Vehicle Registration no OV12UYY
      Then I click on find vehicle button
      And I see result
      | Result for : OV12UYY     | Cover start:  09 FEB 2022 : 21 : 56  | Cover end:    19 FEB 2022 : 05 : 29 |

    Scenario: Verify vehicle search with invalid input
      Given I am on dealer portal page
      Then I clear Vehicle Registration no input field
      When I enter Vehicle Registration no OV43UYY
      Then I click on find vehicle button
      And I see result
        | Sorry record not found  |   |  |
      When I refresh page
      Then I click on find vehicle button
      And I see error msg Please enter a valid car registration




