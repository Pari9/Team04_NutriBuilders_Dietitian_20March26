package stepDefinitions;

import org.testng.Assert;

import drivers.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddPatientPage;
import pages.DashboardPage;

public class AddPatientDialogStepDef {
    
    private AddPatientPage addPatientPage;
    private DashboardPage dashboardPage;
    
    public AddPatientDialogStepDef() {
        this.addPatientPage = new AddPatientPage(DriverManager.getDriver());
        this.dashboardPage = new DashboardPage(DriverManager.getDriver());
     }

    @Given("User is on Dashboard page")
    public void user_is_on_dashboard_page() {

    }

    @When("User clicks on New Patient in the header section")
    public void user_clicks_on_new_patient_in_the_header_section() {
        dashboardPage.clickOnLink("New Patient");
    }


    @Then("User should see Add Patient Details on the dialog box")
    public void user_should_see_add_patient_details_on_the_dialog_box() {
        String actualTitle = addPatientPage.getDialogTitle();
        Assert.assertEquals(actualTitle, "Add Patient Details");
    }

    @Then("User should see {int} input boxes in the Add Patient Details dialog box")
    public void user_should_see_input_boxes_in_the_add_patient_details_dialog_box(Integer expectedCount) {
        int actualCount = addPatientPage.countInputFields();
        Assert.assertEquals(actualCount, expectedCount);
    }


    @Then("User should see {int} dropdowns in the Add Patient Details dialog box")
    public void user_should_see_dropdowns_in_the_add_patient_details_dialog_box(Integer expectedCount) {
        int actualCount = addPatientPage.countDropdowns();
        Assert.assertEquals(actualCount, expectedCount);
    }

    @Then("User should see a date picker for DOB field with MM\\/DD\\/YYYY displayed")
    public void user_should_see_a_date_picker_for_dob_field_with_mm_dd_yyyy_displayed() {
        Assert.assertTrue(addPatientPage.isDOBDisplayed());
        String placeholder = addPatientPage.getDOBPlaceholder();
        Assert.assertEquals(placeholder, "Date of Birth"); 
                }

    @Then("User should see exactly {int} file upload option in Add Patient Details dialog box")
    public void user_should_see_exactly_file_upload_option_in_add_patient_details_dialog_box(Integer expectedCount) {
        int actualCount = addPatientPage.countFileUploadOptions();
        Assert.assertEquals(actualCount, expectedCount);
    }

    @Then("User should see text Upload Health Report")
    public void user_should_see_text_upload_health_report() {
        Assert.assertTrue(addPatientPage.isUploadHealthReportLabelDisplayed());
        String labelText = addPatientPage.getUploadHealthReportLabelText();
             Assert.assertEquals(labelText, "Upload Health Report");
    }

    @Then("User should see text No file Chosen")
    public void user_should_see_text_no_file_chosen() {
        Assert.assertTrue(addPatientPage.isNoFileChosenTextDisplayed());
        String noFileText = addPatientPage.getNoFileChosenText();
        Assert.assertEquals(noFileText, "No file Chosen");
    }

    @Then("User should see one Submit button")
    public void user_should_see_one_submit_button() {
        int submitButtonCount = addPatientPage.countSubmitButtons();
        Assert.assertEquals(submitButtonCount, 1); 
        Assert.assertTrue(addPatientPage.isSubmitButtonDisplayed());
    }

    @Then("User should see one Close button")
    public void user_should_see_one_close_button() {
        int closeButtonCount = addPatientPage.countCloseButtons();
        Assert.assertEquals(closeButtonCount, 1);
        Assert.assertTrue(addPatientPage.isCloseButtonDisplayed());
    }

    @Then("User should see one Submit button in disabled state")
    public void user_should_see_one_submit_button_in_disabled_state() {
        Assert.assertTrue(addPatientPage.isSubmitButtonDisabled());
    }

    @Then("User should see one Close button in enabled state")
    public void user_should_see_one_close_button_in_enabled_state() {
        Assert.assertTrue(addPatientPage.isCloseButtonEnabled());
    }

    @Then("User should see mandatory field with placeholder {string}")
    public void user_should_see_mandatory_field_with_placeholder(String placeholderText) {
        String actualPlaceholder = null;
        
        switch(placeholderText) {
            case "First name":
                actualPlaceholder = addPatientPage.getFirstNamePlaceholder();
                break;
            case "Last name":
                actualPlaceholder = addPatientPage.getLastNamePlaceholder();
                break;
            case "Email":
                actualPlaceholder = addPatientPage.getEmailPlaceholder();
                break;
            case "Contact Number":
                actualPlaceholder = addPatientPage.getContactNumberPlaceholder();
                break;
            default:
                Assert.fail("Unknown placeholder: " + placeholderText);
        }
        
        Assert.assertEquals(actualPlaceholder, placeholderText);
    }

    @Then("User should see mandatory dropdown with placeholder {string}")
    public void user_should_see_mandatory_dropdown_with_placeholder(String dropdownName) {
        String actualPlaceholder = null;
        
        switch(dropdownName) {
            case "Allergies":
                actualPlaceholder = addPatientPage.getAllergiesPlaceholder();
                break;
            case "Food Preference":
                actualPlaceholder = addPatientPage.getFoodPreferencePlaceholder();
                break;
            case "Cusine Category":
                actualPlaceholder = addPatientPage.getCuisineCategoryPlaceholder();
                break;
            default:
                Assert.fail("Unknown dropdown: " + dropdownName);
        }
        
        Assert.assertEquals(actualPlaceholder, dropdownName);
    }

    @Then("User should see mandatory DOB with placeholder {string}")
    public void user_should_see_mandatory_dob_with_placeholder(String placeholderText) {
        String actualPlaceholder = addPatientPage.getDOBPlaceholder();
        Assert.assertEquals(actualPlaceholder, placeholderText);
    }

    @Then("User should see non-manadatory field placeholder with {string}")
    public void user_should_see_non_manadatory_field_placeholder_with(String placeholderText) {
        String actualPlaceholder = null;
        
        switch(placeholderText) {
            case "Weight":
                actualPlaceholder = addPatientPage.getWeightPlaceholder();
                break;
            case "Height":
                actualPlaceholder = addPatientPage.getHeightPlaceholder();
                break;
            case "Temperature":
                actualPlaceholder = addPatientPage.getTemperaturePlaceholder();
                break;
            case "SP":
                actualPlaceholder = addPatientPage.getSPPlaceholder();
                break;
            case "DP":
                actualPlaceholder = addPatientPage.getDPPlaceholder();
                break;
            default:
                Assert.fail("Unknown non-mandatory field: " + placeholderText);
        }
        
        Assert.assertEquals(actualPlaceholder, placeholderText);
    }

    @Then("User should see a scroll bar at the right side of dialog box")
    public void user_should_see_a_scroll_bar_at_the_right_side_of_dialog_box() {
        Assert.assertTrue(addPatientPage.isScrollBarVisible());
    }
    
}
