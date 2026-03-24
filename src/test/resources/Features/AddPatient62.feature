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
      | First Name Special Characters      |
      | First Name Required                |
      | Last Name Numeric                  |
      | Last Name Special Characters       |
      | Last Name Required                 |
      | Email Starts With Number           |
      | Email Missing At Symbol            |
      | Email Missing Dot Com              |
      | Email Already Exists               |
      | Email Required                     |
      | Contact Number Alphabets           |
      | Contact Number Special Characters  |
      | Contact Number Too Short           |
      | Contact Number Already Exists      |
      | Contact Number Required            |
      | Allergies Field Empty              |
      | Food Preference Field Empty        |
      | Cuisine Category Field Empty       |
      | Date of Birth Empty                |
      | Weight With Special Characters     |
      | Weight With Alphabets              |
      | Height With Special Characters     |
      | Height With Alphabets              |
      | Temperature With Special Characters|
      | Temperature With Alphabets         |
      | SP DP With Special Characters      |
      | SP DP With Alphabets               |
      | Invalid File Type Upload           |
      | File Exceeding Size Limit          |
