Feature: Booking Feature Scenarios

  Scenario: Booking a tour from the home page
    Given a customer that navigates to the home page of travelcurious
    When the customer look for the tour: "The Palace of Versailles & Gardens: Private Day Trip from Paris" and click on it
    And the tourDetails Page is displayed
    And the user change the currency to GBP
    And the user select the date September 30
    And the user select the time 12:30
    And the user select 3 adults and 2 children attending the tour
    Then the tour info is displayed with a specific price "791"


