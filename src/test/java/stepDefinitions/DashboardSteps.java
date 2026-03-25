package stepDefinitions;

import drivers.DriverManager;
import hooks.Hooks;
import io.cucumber.java.en.*;
import pageObjectManager.PageObjectManager;
import utilities.ConfigReader;
import utilities.ExcelUtils;

public class DashboardSteps {

	private PageObjectManager pom;
	private ExcelUtils excel;
 
	public DashboardSteps(Hooks hooks)
	{
		this.pom = new PageObjectManager(DriverManager.getDriver());
		this.excel = new ExcelUtils(ConfigReader.getProperty("test_data_path"));
	}
	
	@Given("User is on the login page")
	public void user_is_on_the_login_page() {
	    
	}

	@When("user logs in with valid credentials")
	public void user_logs_in_with_valid_credentials() {
	    
	}
	
	@Then("User should be redirected to dashboard page")
	public void user_should_be_redirected_to_dashboard_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("user should see {int} navigation links in the navbar")
	public void user_should_see_navigation_links_in_the_navbar(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("User is on the Dashboard page")
	public void user_is_on_the_dashboard_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User clicks on {string}")
	public void user_clicks_on(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("user should navigate to {string}")
	public void user_should_navigate_to(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}



}
