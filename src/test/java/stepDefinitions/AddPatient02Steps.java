package stepDefinitions;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import drivers.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddPatient02Page;
import utilities.ExcelUtils;

public class AddPatient02Steps {

	
	  WebDriver driver;
	    AddPatient02Page addPatientPage;
	    public AddPatient02Steps() {
	        this.driver = DriverManager.getDriver();
	        this.addPatientPage = new AddPatient02Page(driver);
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
	       Assert.assertEquals(isDialogBoxVisible, "Add Patient Details is not visible");
	    }

	    @When("User enters for {string} from Excel sheet {string} and navigates to next field")
	    public void user_enters_for_from_excel_sheet_and_navigates_to_next_field(String sheetName, String testCaseID) {
	    	// 1. Call the ExcelReader to get the specific row as a Map
	        // Assuming 'reader' is your ExcelReader object
	        Map<String, String> rowData = ExcelUtils.getRowDataByScenario(sheetName, testCaseID);
	        
	        // 2. Extract values from the row map using your Excel column headers
	        String input = rowData.get("InputData");
	        String fieldName = rowData.get("ExpectedField");

	        // 3. Pass those values to the Page Object method we created
	        // This method handles the typing and the 'tabbing out' click
	        addPatientPage.fillFormByTestCase(fieldName, input);
	    }
	    


	    @Then("User should see the expected error for {string}")
	    public void user_should_see_the_expected_error_for(String string) {
	     
	    }


  
}