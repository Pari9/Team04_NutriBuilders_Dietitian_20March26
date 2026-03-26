package pageObjectManager;

import org.openqa.selenium.WebDriver;

import pages.*;

public class PageObjectManager {

	private WebDriver driver;
	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private AddPatient02Page addPatientPage;

	public PageObjectManager(WebDriver driver) {

		this.driver = driver;

	}
	
	public LoginPage getLoginPage() {

		if (loginPage == null) {
			loginPage = new LoginPage(driver);
		}
		return loginPage;

	}
	
	public DashboardPage getDashboardPage()
	{
		if(dashboardPage == null)
		{
			dashboardPage =new DashboardPage(driver);
		}
		return dashboardPage;
	}
	
	
	public AddPatient02Page getAddPatientPage() {
        if (addPatientPage == null) {
            addPatientPage = new AddPatient02Page(driver);
        }
        return addPatientPage;
    }
}
