@AddPatient @ExcelData
Feature: Add Patient Details Validation

  Background: Navigation to Add Patient Dialog box
    Given User is logged into the Dietitian application
    When User clicks on "New Patient" Link
    Then User is on Add Patient Details Dialog Box

  @UI_Validation
  Scenario Outline: Verify Patient Details UI validation for various fields
    When User enters data for "<TestCaseID>" from Excel sheet "PatientData"
    Then User should see the expected error for "<TestCaseID>"

    Examples: 
      | TestCaseID                         |
      | Add_first_name_special_char        |
      | Mandatory_field_firstname          |
      | Add_last_name_numeric              |
      | Add_last_name_special_char         |
      | Mandatory_field_lastname           |
      | Add_email_starts_with_number       |
      | Add_email_without_@                |
      | Add_email_without_dot_com          |
      | Existing_email_id                  |
      | Mandatory_field_email              |
      | Add_contact_alphabets              |
      | Add_contact_special_char           |
      | Add_contact_less_than_required     |
      | Existing_contact_number            |
      | Mandatory_field_contact            |
      | Leaving_Allergies_empty            |
      | Leaving_Food_Preference_empty      |
      | Leaving_Cuisine_Category_empty     |
      | Leaving_DOB_empty                 |
      | Add_weight_with_special_characters |
      | Add_weight_with_alphabets          |
      | Add_height_with_special_characters |
      | Add_height_with_alphabets          |
      | Add_temperature_with_special_chars |
      | Add_temperature_with_alphabets     |
      | Add_SP_DP_with_special_characters  |
      | Add_SP_DP_with_alphabets           |
      | Upload_invalid_file_type           |
      | Upload_file_exceeding_size         |