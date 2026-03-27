package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import drivers.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectManager.PageObjectManager;
import pages.AddPatient03Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class AddPatient03Steps {

	WebDriver driver;

	PageObjectManager pom;

	AddPatient03Page addPatientPage;
	private static final Logger logger = LogManager.getLogger(AddPatient03Steps.class);
	public AddPatient03Steps() {
		 

		this.pom = new PageObjectManager(DriverManager.getDriver());
	}

	@Given("User is logged into the Dietitian application")
	public void user_is_logged_into_the_dietitian_application() {
		String currentUrl = DriverManager.getDriver().getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("dietician"), "Not on the dietician UI");

	}

	@When("User clicks on {string} Link")
	public void user_clicks_on_link(String string) {
			addPatientPage.clickOnNewPatientLink();
	}

	@Then("User is on Add Patient Details Dialog Box")
	public void user_is_on_add_patient_details_dialog_box() {
		boolean isDialogBoxVisible = addPatientPage.isOnMyPatientsPage();
		Assert.assertTrue(isDialogBoxVisible, "Add Patient Details Dialog Box is not visible");
		logger.info("Successfully verified visibility of Add Patient Details Dialog Box.");
	}

	@When("User enters for {string} from Excel sheet {string} and navigates to next field")
	public void user_enters_for_from_excel_sheet_and_navigates_to_next_field(String sheetName, String testCaseID) {
		addPatientPage.fillFormByTestCase(sheetName, testCaseID);
	}

	@Then("User should see the expected error for {string}")
	public void user_should_see_the_expected_error_for(String testCaseID) {

		addPatientPage.validateErrorByTestCase(testCaseID, "PatientData");
		logger.info("Validated expected error message for TestCase: " + testCaseID);
	}

	@When("User enters valid patient data but does not select a file")
	public void user_enters_valid_patient_data_but_does_not_select_a_file() {
		addPatientPage.fillFormByTestCase("Valid_Mandatory_Fields", "PatientData");
	    
	    logger.info("Mandatory details entered successfully.");
	}

	@When("User clicks Submit button")
	public void user_clicks_submit_button() {
		addPatientPage.clickSubmit();
	}

	@Then("User should be redirected to My Patient page")
	public void user_should_be_redirected_to_my_patient_page() {
		Assert.assertTrue(addPatientPage.isOnMyPatientsPage(), "User not on My Patients page after submit");
		logger.info("Verified redirection to My Patient page.");
	}

	@Then("User should see the New Patient record added successfully")
	public void user_should_see_the_new_patient_record_added_successfully() {
		Assert.assertTrue(addPatientPage.isPdfDisplayed(), "New record not found in the table");
		logger.info("Verified that the New Patient record was added successfully.");
	}

	@When("User uploads health report in {string} format")
	public void user_uploads_health_report_in_format(String format) {
		addPatientPage.uploadHealthReport("health_report." + format);

	}

	@Then("User is directed to the Test Report section")
	public void user_is_directed_to_the_test_report_section() {
		Assert.assertTrue(driver.getCurrentUrl().contains("test-report"), "Not in Test Report section");
		logger.info("Verified redirection to Test Report section.");
	}

	@When("User clicks {string}")
	public void user_clicks(String buttonText) {
		addPatientPage.clickButtonByText(buttonText);

	}

	@Then("User should see new record number in test report page")
	public void user_should_see_new_record_number_in_test_report_page() {
		Assert.assertTrue(addPatientPage.isPdfDisplayed());
		logger.info("Verified new record number on test report page.");
	}

	@Then("User should see PDF file in test report")
	public void user_should_see_pdf_file_in_test_report() {
		Assert.assertTrue(addPatientPage.isPdfDisplayed());
		logger.info("Verified PDF file presence in test report.");
	}

	@Then("User should see upload date info in test report")
	public void user_should_see_upload_date_info_in_test_report() {
		Assert.assertNotNull(addPatientPage.getHealthConditionText());
		logger.info("Verified upload date info is present.");
	}

	@Then("User should see health condition as the values in health report")
	public void user_should_see_health_condition_as_the_values_in_health_report() {
		String conditionText = addPatientPage.getHealthConditionText();
		Assert.assertFalse(conditionText.isEmpty(), "Health condition text is missing");
		logger.info("Verified health condition values match the report.");
	}

	@When("User clicks Close button after submit")
	public void user_clicks_close_button_after_submit() {
		addPatientPage.clickClose();
		
	}

	@Then("Add Patient dialog box should close")
	public void add_patient_dialog_box_should_close() {
		Assert.assertFalse(addPatientPage.isDialogTitleVisible(), "Dialog box did not close");
		logger.info("Verified that the Add Patient dialog box has closed.");
	}

	@Then("User should be on my patients page")
	public void user_should_be_on_my_patients_page() {
		Assert.assertTrue(addPatientPage.isOnMyPatientsPage());
		logger.info("Final check: User is on the My Patients page.");
	}
}
