package pageObjectManager;

import org.openqa.selenium.WebDriver;

import pages.*;

public class PageObjectManager {

	private WebDriver driver;
	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private AddPatient03Page addPatientPage;

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
	
	
	public AddPatient03Page getAddPatientPage() {
        if (addPatientPage == null) {
            addPatientPage = new AddPatient03Page(driver);
        }
        return addPatientPage;
    }
}
