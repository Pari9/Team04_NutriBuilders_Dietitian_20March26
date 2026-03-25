Feature: Add Patient Details Validation

Background: Navigation to Add Patient Dialog box
    Given User is logged into the Dietitian application
    When User clicks on "New Patient" Link
    Then User is on Add Patient Details Dialog Box

@UI_Validation
Scenario Outline: Verify Patient Details UI validation for various fields
    When User enters for "<TestCaseID>" from Excel sheet "PatientData" and navigates to next field
    Then User should see the expected error for "<TestCaseID>"

 Examples:
      | TestCaseID 
      | First Name  Numeric Data            |
      | First Name Special Characters       |
      | First Name Mandatory                |
      | Last Name Numeric                   |
      | Last Name Special Characters        |
      | Last Name Mandatory                 |
      | Email Start With Number             |
      | EmailWithout @ Symbol               |
      | Email With Special Charact          |
      | Email without .com                  |
      | Email Already Exists                |
      | Email Mandatory                     |
      | Contact Number Alphabets            |
      | Contact Number Special Characters   |
      | Contact Number Too Short            |
      | Contact Number Too Long             |
      | Contact Number Mandatory            |
      | Allergies Field Empty               |
      | Food Preference Field Empty         |
      | Cuisine Category Field Empty        |
      | Date of Birth Empty                 |
      | Weight with Valid Data				|
      | Weight With Special Characters      |
      | Weight With Alphabets               |
      | Height With Valid Data              |
      | Height With Special Characters      |
      | Height With Alphabets               |
      | Temperature with valid data         |
      | Temperature With Special Characters |
      | Temperature With Alphabets          |
      | SD DP with Valid Data               |
      | SP DP With Special Characters       |
      | SP DP With Alphabets                |
      | Upload Valid Pdf File               |
      | Invalid File Type Upload            |
      | File Exceeding Size Limit           |

      
  @UploadWithoutFile
Scenario: Validate submission without selecting a file
When User enters valid patient data but does not select a file
When User clicks Submit button
Then User should be redirected to My Patient page
Then User should see the New Patient record added successfully

@TestReportVerification
Scenario: Verify the presence of record details in test report
When User uploads health report in "pdf" format
When User clicks Submit button
Then User is directed to the Test Report section
When User clicks "View Previous Test Report"
Then User should see new record number in test report page
Then User should see PDF file in test report
Then User should see upload date info in test report
Then User should see health condition as the values in health report

@Navigation
Scenario: Close Patient dialog box using the Close button

When User clicks Close button after submit
Then Add  Patient dialog box should close
Then User should be on my patients page



