package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectManager.PageObjectManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import drivers.DriverManager;

public class DeletePopupInfoSteps {

    WebDriver driver = DriverManager.getDriver();
    PageObjectManager pom = new PageObjectManager(driver);

    @When("User clicks the Delete icon for a particular patient in the patient table")
    public void click_delete_icon() {
       // pom.getMyPatientPage().clickDeleteIcon();
    }

    @Then("{string}")
    public void validate_popup(String validation) {

        if (validation.contains("Alert title")) {

            String actual = pom.getCommonMethods().getAlert();
            Assert.assertTrue(actual.equals("Confirm"), "Title mismatch");
                    
        }

        else if (validation.contains("Alert text")) {

            String actual = pom.getCommonMethods().getAlert();
            		
            Assert.assertTrue(actual.contains("Are you sure to delete"),
                    "Alert text mismatch");
        }

        else if (validation.contains("Yes button")) {

            
        	Assert.assertTrue( pom.getDeletePopupInfo().isYesButtonDisplayed(),"Yes button not visible" );
                    
           
        }

        else if (validation.contains("No button")) {

            Assert.assertTrue(pom.getDeletePopupInfo().isNoButtonDisplayed(),"No button not visible");
        }
    }







    }

