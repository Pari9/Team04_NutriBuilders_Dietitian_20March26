package pageObjectManager;

import org.openqa.selenium.WebDriver;

import pages.*;
import utilities.CommonMethods;

public class PageObjectManager {

	private WebDriver driver;
	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private DeletePopupInfo deletePopupInfo;
	private CommonMethods commonMethods;
	private AddPatient02Page addPatientPage;
	private CommonMethods commonMethods;
	private ViewReportsPage reportspage;
	private EditPatientFieldsPage editPatientsPage;

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
	
	public CommonMethods getCommonMethods()
	{
		if(commonMethods == null)
		{
			commonMethods = new CommonMethods(driver);
		}
		return commonMethods;
	}
	public AddPatient02Page getAddPatientPage() {
        if (addPatientPage == null) {
            addPatientPage = new AddPatient02Page(driver);
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
	public ViewReportsPage getReportsPage(){
		if(reportspage == null){
			return new ViewReportsPage(driver);
		}
		return reportspage;
	}

	public EditPatientFieldsPage getPatientspage(){
		if(editPatientsPage == null){
			return new EditPatientFieldsPage(driver);
		}
		return editPatientsPage;
	}
}
