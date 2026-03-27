package pageObjectManager;

import org.openqa.selenium.WebDriver;

import pages.*;
import utilities.CommonMethods;

public class PageObjectManager {

	private WebDriver driver;
	private LoginPage loginPage;
	private DashboardPage dashboardPage;

	private AddPatient03Page addPatientPage;

	private DeletePopupInfo deletePopupInfo;
	private CommonMethods commonMethods;


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
	
	public DeletePopupInfo getDeletePopupInfo()
	{
		if(deletePopupInfo == null)
		{
			deletePopupInfo = new DeletePopupInfo(driver);
		}
		return deletePopupInfo;
	}

	public AddPatient03Page getAddPatientPage() {
	
			if (addPatientPage == null) {
				addPatientPage = new AddPatient03Page(driver);
			}
			return addPatientPage;
		}
	

	public CommonMethods getCommonMethods()
	{
		if(commonMethods == null)
		{
			commonMethods = new CommonMethods(driver);
		}
		return commonMethods;
	}
}
