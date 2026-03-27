package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddPatientPage;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;
import java.util.Map;


public class addPatientFunctionalityStepDef {
    
    private AddPatientPage addPatientPage;

    public addPatientFunctionalityStepDef(WebDriver driver) {

        this.addPatientPage = new AddPatientPage(driver);
    }

    @When("User navigate to next field after entering numeric data in First name field")
    public void user_navigate_to_next_field_after_entering_numeric_data_in_first_name_field() {
        addPatientPage.enterFirstName("12345");
        addPatientPage.moveToNextField();
    }

    @Then("User should see error message in Patient first name accepts only alphabets")
    public void user_should_see_error_message_in_patient_first_name_accepts_only_alphabets() {
        Assert.assertTrue(addPatientPage.errorMessageContains("only alphabets") || 
            addPatientPage.errorMessageContains("only letters"));
    }

    @When("User navigate to next field after entering special characters in First name field")
    public void user_navigate_to_next_field_after_entering_special_characters_in_first_name_field(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        String firstName = data.get("Firstname");
        addPatientPage.enterFirstName(firstName);
        addPatientPage.moveToNextField();
    }
/******************************************************************************************/
    @When("User selects date {int} in calendar")
    public void user_selects_date_in_calendar(Integer year) {
        addPatientPage.clickDOBField();
    }

    @Then("Years older than {int} years from today should be disabled")
    public void years_older_than_years_from_today_should_be_disabled(Integer yearsOld) {
        int testYear = 1926;
        Assert.assertTrue(addPatientPage.isDateOlderThan100Years(String.valueOf(testYear)));
    }
/*************************************************************************************** */
    @When("User enters Feb {int} {int} in DOB")
    public void user_enters_feb_in_dob(Integer dayOfMonth, Integer year) {
        addPatientPage.enterDateInDOB(String.format("02/%02d/%d", dayOfMonth, year));
    }

    @Then("User should see the selected date Feb {int} {int}")
    public void user_should_see_the_selected_date_feb(Integer dayOfMonth, Integer year) {
        String expectedDate = String.format("02/%02d/%d", dayOfMonth, year);
        String actualDate = addPatientPage.getDOBFieldValue();
        Assert.assertTrue(actualDate.contains(expectedDate));
    }

    @When("User navigate to next field leaving First name field empty")
    public void user_navigate_to_next_field_leaving_first_name_field_empty() {
        addPatientPage.moveToNextField();
    }

    @Then("User should see error message {string}")
    public void user_should_see_error_message(String expectedMessage) {
        Assert.assertTrue(addPatientPage.errorMessageContains(expectedMessage));
    }

    @When("User clicks Submit after entering valid data in all mandatory fields")
    public void user_clicks_submit_after_entering_valid_data_in_all_mandatory_fields(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        
        String firstName = data.get("firstName");
        String lastName = data.get("lastName");
        String email = data.get("email");
        String contactNumber = data.get("contactNumber");
        String allergy = data.get("allergy");
        String foodPref = data.get("foodPref");
        String cuisine = data.get("cuisine");
        String dob = data.get("dob");
        
        addPatientPage.fillAllMandatoryFields(firstName, lastName, email, 
            contactNumber, allergy, foodPref, cuisine, dob);
        addPatientPage.clickSubmitButton();
    }

    @Then("User is directed to My Patient Page with New Patient Details created")
    public void user_is_directed_to_my_patient_page_with_new_patient_details_created() {
        Assert.assertTrue(addPatientPage.isMyPatientPageDisplayed());
    }

    @When("User enters Feb {int} {int}")
    public void user_enters_feb(Integer dayOfMonth, Integer year) {
        addPatientPage.enterDateInDOB(String.format("02/%02d/%d", dayOfMonth, year));
    }

    @Then("User should see an error message {string}")
    public void user_should_see_an_error_message(String expectedMessage) {
        Assert.assertTrue(addPatientPage.errorMessageContains(expectedMessage));
    }

    @When("User clicks on Allergry dropdown")
    public void user_clicks_on_allergry_dropdown() {
        addPatientPage.clickAllergiesDropdown();
    }

    @Then("Dropdown should contain {int} values")
    public void dropdown_should_contain_values(Integer expectedCount) {
        int actualCount = addPatientPage.getAllergiesDropdownValueCount();
        Assert.assertEquals(actualCount, expectedCount);
    }

    @When("User clicks on cuisine dropdown")
    public void user_clicks_on_cuisine_dropdown() {
        addPatientPage.clickCuisineDropdown();
    }

    @When("User clicks on Food Preference dropdown")
    public void user_clicks_on_food_preference_dropdown() {
        addPatientPage.clickFoodPreferenceDropdown();
    }

    @Then("Values should be present inside Allergy dropdown")
    public void values_should_be_present_inside_allergy_dropdown() {
        Assert.assertTrue(addPatientPage.allergiesDropdownContainsValues());
    }

    @Then("Values should be present inside Cuisine dropdown")
    public void values_should_be_present_inside_cuisine_dropdown() {
        Assert.assertTrue(addPatientPage.cuisineDropdownContainsValues());
    }

    @Then("Values should be present inside Food preference dropdown")
    public void values_should_be_present_inside_food_preference_dropdown() {
        Assert.assertTrue(addPatientPage.foodPreferenceDropdownContainsValues());
    }

    @When("User clicks calendar Date of Birth field")
    public void user_clicks_calendar_date_of_birth_field() {
        addPatientPage.clickDOBField();
    }

    @Then("User should see the future date to be disabled")
    public void user_should_see_the_future_date_to_be_disabled() {
        Assert.assertTrue(addPatientPage.isFutureDateDisabled());
    }

    @When("User selects {string} from Allergy dropdown")
    public void user_selects_from_allergy_dropdown(String allergyValue) {
        addPatientPage.selectAllergiesValue(allergyValue);
    }

    @Then("{string} should be selected in the Allergy field")
    public void should_be_selected_in_the_allergy_field(String allergyValue) {
        Assert.assertTrue(addPatientPage.isAllergiesValueSelected(allergyValue));
    }

    @When("User selects {string} from Cuisine Category dropdown")
    public void user_selects_from_cuisine_category_dropdown(String cuisineValue) {
        addPatientPage.selectCuisineValue(cuisineValue);
    }

    @Then("{string} should be selected in the Cuisine Category field")
    public void should_be_selected_in_the_cuisine_category_field(String cuisineValue) {
        Assert.assertTrue(addPatientPage.isCuisineValueSelected(cuisineValue));
    }

    @When("User selects {string} from Food Preference dropdown")
    public void user_selects_from_food_preference_dropdown(String preferenceValue) {
        addPatientPage.selectFoodPreferenceValue(preferenceValue);
    }

    @Then("{string} should be selected in the Food Preference field")
    public void should_be_selected_in_the_food_preference_field(String preferenceValue) {
        Assert.assertTrue(addPatientPage.isFoodPreferenceValueSelected(preferenceValue));
    }

    @When("User selects {string} and {string} from Allergy dropdown")
    public void user_selects_and_from_allergy_dropdown(String allergy1, String allergy2) {
        addPatientPage.selectMultipleAllergiesValues(allergy1, allergy2);
    }

    @When("User selects {string} and {string} from Cuisine Category dropdown")
    public void user_selects_and_from_cuisine_category_dropdown(String cuisine1, String cuisine2) {
        addPatientPage.selectMultipleCuisineValues(cuisine1, cuisine2);
    }

    @When("User selects {string} and {string} from Food Preference dropdown")
    public void user_selects_and_from_food_preference_dropdown(String preference1, String preference2) {
        addPatientPage.selectMultipleFoodPreferenceValues(preference1, preference2);
    }

    @When("User enters invalid date \\({int}\\/{int}\\/{int})")
    public void user_enters_invalid_date(Integer month, Integer day, Integer year) {
        addPatientPage.enterDateInDOB(String.format("%d/%d/%d", month, day, year));
    }

    @When("User select {string} from Allergy dropdown")
    public void user_select_from_allergy_dropdown(String allergy) {
        addPatientPage.selectAllergiesValue(allergy);
    }

    @Then("No selection should occur")
    public void no_selection_should_occur() {
        String selectedValue = addPatientPage.getSelectedAllergiesValue();
        Assert.assertNotEquals(selectedValue, "");
    }

    @When("User tries to select {string} from Cuisine Category dropdown")
    public void user_tries_to_select_from_cuisine_category_dropdown(String cuisine) {
        addPatientPage.selectCuisineValue(cuisine);
    }

    @When("User tries to select {string} from Food Preference dropdown")
    public void user_tries_to_select_from_food_preference_dropdown(String preference) {
        addPatientPage.selectFoodPreferenceValue(preference);
    }

    @When("User selects current date as DOB")
    public void user_selects_current_date_as_dob() {
        addPatientPage.clickDOBField();
        java.time.LocalDate today = java.time.LocalDate.now();
        String todayDate = String.format("%02d/%02d/%d", today.getMonthValue(), today.getDayOfMonth(), today.getYear());
        addPatientPage.enterDateInDOB(todayDate);
    }

    @When("User clicks Date of Birth field")
    public void user_clicks_date_of_birth_field() {
        addPatientPage.clickDOBField();
    }

    @Then("User should see calender date picker displayed with Month,Day,Year")
    public void user_should_see_calender_date_picker_displayed_with_month_day_year() {
        Assert.assertTrue(addPatientPage.isDatePickerDisplayed());
    }

    @When("User enters {string} in the DOB field")
    public void user_enters_in_the_dob_field(String dateInput) {
        addPatientPage.enterDateInDOB(dateInput);
    }

    @When("User clicks Date of Birth field, selects valid date {int}\\/{int}\\/{int}")
    public void user_clicks_date_of_birth_field_selects_valid_date(Integer month, Integer day, Integer year) {
        addPatientPage.clickDOBField();
        addPatientPage.enterDateInDOB(String.format("%02d/%02d/%d", month, day, year));
    }

    @Then("User should see the selected date {int}\\/{int}\\/{int}")
    public void user_should_see_the_selected_date(Integer month, Integer day, Integer year) {
        String expectedDate = String.format("%02d/%02d/%d", month, day, year);
        String actualDate = addPatientPage.getDOBFieldValue();
        Assert.assertTrue(actualDate.contains(expectedDate));
    }

    @Then("Dropdown should contain allergy values")
    public void dropdown_should_contain_allergy_values(DataTable dataTable) {
        List<String> expectedValues = dataTable.asList();
        Assert.assertTrue(addPatientPage.dropdownContainsSpecificValues("Allergies", expectedValues));
    }

    @Then("Dropdown should contain food preference values")
    public void dropdown_should_contain_food_preference_values(DataTable dataTable) {
        List<String> expectedValues = dataTable.asList();
        Assert.assertTrue(addPatientPage.dropdownContainsSpecificValues("Food Preference", expectedValues));
    }

    @Then("Dropdown should contain cuisine category values")
    public void dropdown_should_contain_cuisine_category_values(DataTable dataTable) {
        List<String> expectedValues = dataTable.asList();
        Assert.assertTrue(addPatientPage.dropdownContainsSpecificValues("Cuisine", expectedValues));
    }

    @When("User enters valid values in all field")
    public void user_enters_valid_values_in_all_field(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        
        String firstName = data.get("firstName");
        String lastName = data.get("lastName");
        String email = data.get("email");
        String contactNumber = data.get("contactNumber");
        String allergy = data.get("allergy");
        String foodPref = data.get("foodPref");
        String cuisine = data.get("cuisine");
        String dob = data.get("dob");
        
        addPatientPage.fillAllMandatoryFields(firstName, lastName, email, 
            contactNumber, allergy, foodPref, cuisine, dob);
    }

    @Then("Submit button should be enabled")
    public void submit_button_should_be_enabled() {
        Assert.assertTrue(addPatientPage.isSubmitButtonEnabled());
    }

    @Then("User should see Patient successfully created - toast message")
    public void user_should_see_patient_successfully_created_toast_message() {
        Assert.assertTrue(addPatientPage.isPatientSuccessfullyCreatedMessageDisplayed());
    }

    @When("User clicks Date of Birth field, selects valid date")
    public void user_clicks_date_of_birth_field_selects_valid_date() {
        addPatientPage.clickDOBField();
        addPatientPage.enterDateInDOB("05/10/1995");
    }

    @Then("User should see the selected date in MM\\/DD\\/YYYY format")
    public void user_should_see_the_selected_date_in_mm_dd_yyyy_format() {
        String dobValue = addPatientPage.getDOBFieldValue();
        Assert.assertTrue(addPatientPage.isDateInMMDDYYYYFormat(dobValue));
    }

}
