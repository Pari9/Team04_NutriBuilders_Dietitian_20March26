package stepDefinitions;

import org.openqa.selenium.WebDriver;
import drivers.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddPatient02;

public class AddPatient62_Steps {

	
	  WebDriver driver;
	    AddPatient02 addPatientPage;
	    public AddPatient62_Steps() {
	        // Initialize the driver and the Page Object
	        this.driver = DriverManager.getDriver();
	        this.addPatientPage = new AddPatient02(driver);
	    }
	    @Given("User is logged into the Dietitian application")
	    public void user_is_logged_into_the_dietitian_application() {
	       
	    }

	    @When("User clicks on {string} Link")
	    public void user_clicks_on_link(String string) {
	       
	    }

	    @Then("User is on Add Patient Details Dialog Box")
	    public void user_is_on_add_patient_details_dialog_box() {
	       
	    }

	    @When("User enters data for {string} from Excel sheet {string}")
	    public void user_enters_data_for_from_excel_sheet(String string, String string2) {

	    }

	    @Then("User should see the expected error for {string}")
	    public void user_should_see_the_expected_error_for(String string) {
	     
	    }


  
}