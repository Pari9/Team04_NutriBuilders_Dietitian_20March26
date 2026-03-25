package stepDefinitions;

import drivers.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ViewReportsPage;

import java.util.List;

public class ViewReportsSteps {

    public ViewReportsPage reportPage;

    public ViewReportsSteps() {
        reportPage = new ViewReportsPage(DriverManager.getDriver());
    }

    @Given("User logged into the app and is in My Patients page")
    public void user_logged_into_the_app_and_is_in_my_patients_page() {
        //login method
        reportPage.navigateToMyPatientsPage();
    }

    // @Given("User is in My Patients page")
    public void user_is_in_my_patients_page() {
        reportPage.navigateToMyPatientsPage();
    }

    @When("User clicks View Previous Test Reports button for a specific record")
    public void user_clicks_view_previous_test_reports_button_for_a_specific_record() {
        reportPage.clickTestReports();
    }

    @Then("Title View Patient Test Reports should be displayed")
    public void title_view_patient_test_reports_should_be_displayed() {
        String title = "View Patient Test Reports";
        Assert.assertEquals(reportPage.getTitle(), title, "Title is not matching");

    }

    @When("User clicks View Previous Test Reports button for a particular record")
    public void user_clicks_view_previous_test_reports_button_for_a_particular_record() {
        reportPage.clickTestReports();

    }

    @Then("Patient ID field should be displayed")
    public void patient_id_field_should_be_displayed() {
        Assert.assertTrue(reportPage.isPatientIdDisplayed(), "Patient ID field is not displayed");
    }

    @Then("Name field should be displayed")
    public void name_field_should_be_displayed() {
        Assert.assertTrue(reportPage.isNameDisplayed(), "Name field is not displayed");
    }

    @Then("Email should be displayed")
    public void email_should_be_displayed() {
        Assert.assertTrue(reportPage.isEmailDisplayed(), "Email field is not displayed");
    }

    @Then("Contact Number field should be displayed")
    public void contact_number_field_should_be_displayed() {
        Assert.assertTrue(reportPage.isContactNumberDisplayed(), "Contact Number field is not displayed");
    }

    @Then("Close icon x should be displayed")
    public void close_icon_x_should_be_displayed() {
        Assert.assertTrue(reportPage.isCloseBtnDisplayed(), "close Button is not displayed");

    }

    // @Then("{string} corresponding to the record selected in My Patients page should be displayed")
    public void corresponding_to_the_record_selected_in_my_patients_page_should_be_displayed(String patientId) {
        Assert.assertEquals(reportPage.getPatientId(), patientId, "Patient id is not matching");
    }

    //@Then("Each report should display file report name")
    public void each_report_should_display_file_report_name() {

    }

    // @Then("Patient name corresponding to the record selected in My Patients page should be displayed")
    public void patient_name_corresponding_to_the_record_selected_in_my_patients_page_should_be_displayed() {

    }

    @Then("Reports table should be displayed")
    public void reports_table_should_be_displayed() {
    Assert.assertTrue(reportPage.isReportTableDisplayed(), "Reports table is not displayed");
    }

    @Then("Table headers should have below {string}")
    public void table_headers_should_have_below(String field) {
        Assert.assertTrue(reportPage.isColumnHeaderPresent(field), "Column header " + field + " is NOT present in the Reports table");
    }


    @Then("Record headers should be in the exact order")
    public void record_headers_should_be_in_the_exact_order(DataTable dataTable) {
        List<String> expectedOrder = dataTable.asList();
        Assert.assertTrue(
               reportPage.isColumnOrderCorrect(expectedOrder),
                "Column headers are not in the correct order"
        );

    }


    @Then("Pagination controls First, previous, next, last arrows should be displayed")
    public void pagination_controls_first_previous_next_last_arrows_should_be_displayed() {

    }

    @Then("Each report should display a record number")
    public void each_report_should_display_a_record_number() {

    }

    @Then("Each report should display View PDF button")
    public void each_report_should_display_view_pdf_button() {

    }


    @Then("Each report should display uploaded time")
    public void each_report_should_display_uploaded_time() {
    }

    @Then("Each report should display file\\/report name")
    public void each_report_should_display_file_repot_name() {
    }

    @Then("Each report should display vitals information")
    public void each_report_should_display_vitals_information() {

    }

    @Then("Vitals should be displayed in the order Weight → Height → Temperature → SP → DP")
    public void vitals_should_be_displayed_in_the_order_weight_height_temperature_sp_dp() {

    }

    @Then("Vitals should be displayed in multilines")
    public void vitals_should_be_displayed_in_multilines() {

    }

    @Then("Each report should display Identified health conditions")
    public void each_report_should_display_identified_health_conditions() {

    }

    @Then("Identified health conditions should be displayed in multilines")
    public void identified_health_conditions_should_be_displayed_in_multilines() {

    }


    @Given("User is in View Plan Test Reports page")
    public void user_is_in_view_plan_test_reports_page() {
    }

    @When("User clicks View PDF button for a particular record")
    public void user_clicks_view_pdf_button_for_a_particular_record() {

    }

    @Given("User is in View Patient Test Reports page with multiple record for the patient")
    public void user_is_in_view_patient_test_reports_page_with_multiple_record_for_the_patient() {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("User clicks the next page arrow \\(>)")
    public void user_clicks_the_next_page_arrow() {

    }

    @Then("Next set of  patient records should be displayed")
    public void next_set_of_patient_records_should_be_displayed() {

    }

    @Given("User is in Report table of View Patient Test Reports page")
    public void user_is_in_report_table_of_view_patient_test_reports_page() {

    }

    @When("User clicks the previous page arrow \\(<)")
    public void user_clicks_the_previous_page_arrow() {

    }

    @Then("Previous set of patient records should be displayed")
    public void previous_set_of_patient_records_should_be_displayed() {

    }

    @Given("User is in any page except first page of Report table")
    public void user_is_in_any_page_except_first_page_of_report_table() {

    }

    @When("User clicks the first page arrow \\(<<)")
    public void user_clicks_the_first_page_arrow() {

    }

    @Then("First page of patient records should be displayed")
    public void first_page_of_patient_records_should_be_displayed() {

    }

    @Given("User is in any page except last page of Report table")
    public void user_is_in_any_page_except_last_page_of_report_table() {

    }

    @When("User clicks the last page arrow \\(>>)")
    public void user_clicks_the_last_page_arrow() {

    }

    @Then("Last page of patient records should be displayed")
    public void last_page_of_patient_records_should_be_displayed() {

    }

    @Given("User is in any page of Report table")
    public void user_is_in_any_page_of_report_table() {

    }

    @When("User clicks any page navigation arrow")
    public void user_clicks_any_page_navigation_arrow() {

    }

    @Then("Pagination text should display the correct range and total number of patients")
    public void pagination_text_should_display_the_correct_range_and_total_number_of_patients() {

    }

    @Given("User is in View Patient Test Reports page with multiple pages of record")
    public void user_is_in_view_patient_test_reports_page_with_multiple_pages_of_record() {

    }

    @When("User navigates to any page")
    public void user_navigates_to_any_page() {

    }

    @Then("Pagination controls should be displayed")
    public void pagination_controls_should_be_displayed() {

    }

    @When("User navigates to the first page of patient record")
    public void user_navigates_to_the_first_page_of_patient_record() {

    }

    @Then("Previous arrow \\(<) should be disabled")
    public void previous_arrow_should_be_disabled() {

    }

    @Then("First page arrow \\(<<) should be disabled")
    public void first_page_arrow_should_be_disabled() {

    }

    @Then("Next arrow \\(>) should be enabled")
    public void next_arrow_should_be_enabled() {

    }

    @Then("Last page arrow \\(>>) should be enabled")
    public void last_page_arrow_should_be_enabled() {

    }

    @When("User navigates to any page after the first page")
    public void user_navigates_to_any_page_after_the_first_page() {
    }

    @Then("Previous arrow \\(<) should be enabled")
    public void previous_arrow_should_be_enabled() {

    }

    @Then("First page arrow \\(<<) should be enabled")
    public void first_page_arrow_should_be_enabled() {

    }

    @When("User navigates to any page except the last page")
    public void user_navigates_to_any_page_except_the_last_page() {

    }

    @When("User navigates to the last page of the patient record")
    public void user_navigates_to_the_last_page_of_the_patient_record() {

    }

    @Then("Next arrow \\(>) should be disabled")
    public void next_arrow_should_be_disabled() {

    }

    @Then("Last page arrow \\(>>) should be  disabled")
    public void last_page_arrow_should_be_disabled() {

    }

    @Given("User is in My Patient page")
    public void user_is_in_my_patient_page() {

    }

    @When("User clicks on View Patient Test Reports button")
    public void user_clicks_on_view_patient_test_reports_button() {

    }

    @Then("First, previous, next, last arrows should be disabled")
    public void first_previous_next_last_arrows_should_be_disabled() {

    }

    @Then("{string} should be displayed")
    public void should_be_displayed(String string) {

    }

    @Given("User is in dietician application dashboard page")
    public void user_is_in_dietician_application_dashboard_page() {

    }

    @When("User clicks on My Patients button")
    public void user_clicks_on_my_patients_button() {

    }

    @Then("User should see only {int} records in each page")
    public void user_should_see_only_records_in_each_page(Integer int1) {

    }


}
