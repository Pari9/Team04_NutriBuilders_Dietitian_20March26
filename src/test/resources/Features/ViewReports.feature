@LoginRequired
Feature: View Test Report

  Background:
   Given User logged into the app and is in My Patients page
    When User clicks View Previous Test Reports button for a particular record

    Scenario Outline: UI elements should be visible on vew patients test reports page
      Then <ElementsToBeDisplayed>
      Examples:
    |ElementsToBeDisplayed|
   # |Title View Patient Test Reports should be displayed  |
   # |Patient ID field should be displayed |
   # |Name field should be displayed |
   # |Email should be displayed  |
   # |Contact Number field should be displayed |
     |Close icon x should be displayed |

    #|Report table with headers Record Number, File, Uploaded Time, File/Report Name, Vitals, Identified Health Conditions|
    #|Pagination controls First, previous, next, last arrows|


  Scenario: Report table is displayed
    Then Reports table should be displayed

  Scenario Outline: Table headers column are displayed
    Then Table headers should have below "<fields>"
  Examples:
    |fields|
        |Record Number|
        |File|
        |Uploaded Time|
        |File/Report Name|
        |Vitals|
        |Identified Health Conditions|

  Scenario: Table headers column order
    Then Record headers should be in the exact order
      | Record Number         |
      | File                  |
      | Uploaded Time         |
      | File/Report Name      |
      | Vitals                |
      | Identified Health Conditions |
  Scenario: Pagination controls are displayed
    Then Pagination controls First, previous, next, last arrows should be displayed

  Scenario: Record number display
    Given User is in My Patients page
    When User clicks View Previous Test Reports button for a particular record
    Then Each report should display a record number

  Scenario: View PDF button display
    Given User is in My Patients page
    When User clicks View Previous Test Reports button for a particular record
    Then Each report should display View PDF button

  Scenario: Uploaded time display
    Given User is in My Patients page
    When User clicks View Previous Test Reports button for a particular record
    Then Each report should display uploaded time

  Scenario: File name display
    Given User is in My Patients page
    When User clicks View Previous Test Reports button for a particular record
    Then Each report should display file report name

  Scenario: Vitals information display
    Given User is in My Patients page
    When User clicks View Previous Test Reports button for a particular record
    Then Each report should display vitals information

  Scenario: Vitals order
    Given User is in My Patients page
    When User clicks View Previous Test Reports button for a particular record
    Then Vitals should be displayed in the order Weight → Height → Temperature → SP → DP

  Scenario: Vitals displayed in multiline format
    Given User is in My Patients page
    When User clicks View Previous Test Reports button for a particular record
    Then Vitals should be displayed in multilines

  Scenario: Health conditions display
    Given User is in My Patients page
    When User clicks View Previous Test Reports button for a particular record
    Then Each report should display Identified health conditions

  Scenario: Health conditions displayed in multiline format
    Given User is in My Patients page
    When User clicks View Previous Test Reports button for a particular record
    Then Identified health conditions should be displayed in multilines

  Rule: "View PDF" for dietician

    Background: User is in My Patients page

      Scenario: Corresponding PDF report opens for a record
         Given User is in View Plan Test Reports page
       When User clicks View PDF button for a particular record
        Then Corresponding report for that record should be opened

  Rule: Pagination management - User records with multiple test reports must be available

    Background: User is in view patient test report page with multiple records already exist in the system for that user

      Scenario: Navigate to the next page using pagination
        Given User is in View Patient Test Reports page with multiple record for the patient
        When User clicks the next page arrow (>)
        Then Next set of  patient records should be displayed

    Scenario: Navigate to the previous page using pagination
      Given User is in Report table of View Patient Test Reports page
      When User clicks the previous page arrow (<)
      Then Previous set of patient records should be displayed

    Scenario: Navigate to the first page using pagination
      Given User is in any page except first page of Report table
      When User clicks the first page arrow (<<)
      Then First page of patient records should be displayed

    Scenario: Navigate to the last page using pagination
      Given User is in any page except last page of Report table
      When User clicks the last page arrow (>>)
      Then Last page of patient records should be displayed

    Scenario: Pagination count is updated correctly
      Given User is in any page of Report table
      When User clicks any page navigation arrow
      Then Pagination text should display the correct range and total number of patients

    Scenario: Pagination is displayed when patient records exceed one page
      Given User is in View Patient Test Reports page with multiple pages of record
      When User navigates to any page
      Then Pagination controls should be displayed

    Scenario: Previous page arrow disabled on first page
      Given User is in View Patient Test Reports page with multiple pages of record
      When User navigates to the first page of patient record
      Then Previous arrow (<) should be disabled

    Scenario: First page arrow disabled on first page
      Given User is in View Patient Test Reports page with multiple pages of record
      When User navigates to the first page of patient record
      Then First page arrow (<<) should be disabled

    Scenario: Next page arrow enabled on first page
      Given User is in View Patient Test Reports page with multiple pages of record
      When User navigates to the first page of patient record
      Then Next arrow (>) should be enabled

    Scenario: Last page arrow enabled on first page
      Given User is in View Patient Test Reports page with multiple pages of record
      When User navigates to the first page of patient record
      Then Last page arrow (>>) should be enabled

    Scenario: Previous page arrow is enabled on all pages except the first page
      Given User is in View Patient Test Reports page with multiple pages of record
      When User navigates to any page after the first page
      Then Previous arrow (<) should be enabled

    Scenario: First page arrow is enabled on all pages except the first page
      Given User is in View Patient Test Reports page with multiple pages of record
      When User navigates to any page after the first page
      Then First page arrow (<<) should be enabled

    Scenario: Last page arrow is enabled on all pages except the last page
      Given User is in View Patient Test Reports page with multiple pages of record
      When User navigates to any page except the last page
      Then Last page arrow (>>) should be enabled

    Scenario: Next page arrow is enabled on all pages except the last page
      Given User is in View Patient Test Reports page with multiple pages of record
      When User navigates to any page except the last page
      Then Next arrow (>) should be enabled

    Scenario: Next Page arrow is disabled on last page
      Given User is in View Patient Test Reports page with multiple pages of record
      When User navigates to the last page of the patient record
      Then Next arrow (>) should be disabled

    Scenario: Last page arrow is disabled on last page
      Given User is in View Patient Test Reports page with multiple pages of record
      When User navigates to the last page of the patient record
      Then Last page arrow (>>) should be  disabled

  Rule: Pagination management - User records with single test reports must be available

  Background: User is logged into the application and only one patient record already exist in the system for that user

    Scenario: All pagination arrows disabled when only one page exists
      Given User is in My Patient page
      When User clicks on View Patient Test Reports button
      Then First, previous, next, last arrows should be disabled

  Rule: Pagination management - when no data exists in the table

    Background: User logged into the application without patient added to that user

    Scenario: Pagination when no patient data exists
      Given User is in My Patient page
      When User clicks on View Patient Test Reports button
      Then "Showing 0 to 0 of 0 patients" should be displayed

    Scenario: All pagination arrows disabled when no data exists
      Given User is in My Patient page
      When User clicks on View Patient Test Reports button
      Then First, previous, next, last arrows should be disabled


  Rule: Pagination management with maximum record in a page

    Background: User is in view patient test report page with multiple records already exist in the system for that user

    Scenario: Each page should display only 2  records
      Given User is in dietician application dashboard page
      When User clicks on My Patients button
      Then User should see only 2 records in each page

