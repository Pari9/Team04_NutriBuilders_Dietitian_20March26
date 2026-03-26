Feature: Delete Patient Popup Info Validation

  Background:
    Given User is on the My Patient page

  Scenario Outline: Verify delete patient popup details
    When User clicks the Delete icon for a particular patient in the patient table
    Then "<Validation>"

    Examples:
      | Validation                                                                 |
      | Alert title should be Confirm                                            |
      | Alert text should be Are you sure to delete [Patient Name]?             |
      | Alert should display a Yes button                                          |
      | Alert should display a No button                                           |