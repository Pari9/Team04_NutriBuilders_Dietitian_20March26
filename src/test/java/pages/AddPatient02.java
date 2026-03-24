package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class AddPatient02 {
	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();
	public AddPatient02(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@id='firstname' or @name='firstName']")
	private WebElement firstNameField;

	@FindBy(xpath = "//input[@id='lastname' or @name='lastName']")
	private WebElement lastNameField;

	@FindBy(xpath = "//input[@id='email' or @name='email']")
	private WebElement emailField;

	@FindBy(xpath = "//input[@id='phoneNumber' or @name='contactNumber']")
	private WebElement contactNumberField;

	@FindBy(xpath = "//input[@data-placeholder='Weight']")
	private WebElement weightField;

	@FindBy(xpath = "//input[@data-placeholder='Height']")
	private WebElement heightField;

	@FindBy(xpath = "//input[@data-placeholder='Temperature']")
	private WebElement temperatureField;

	@FindBy(xpath = "//input[@data-placeholder='SP']")
	private WebElement spField;

	@FindBy(xpath = "//input[@data-placeholder='DP']")
	private WebElement dpField;

	@FindBy(xpath = "//input[@data-placeholder='MM/DD/YYYY']")
	private WebElement datePicker;

	// --- Navigation & Page Titles ---
	@FindBy(xpath = "//*[text()='New Patient']")
	private WebElement newPatientLink;

	@FindBy(xpath = "//div[contains(text(),'My Patients')]")
	private WebElement addPatientDetailsTitle;
	
	// --- Dropdown Selectors ---
	@FindBy(xpath = "//mat-select[@id='allergies' or @placeholder='Allergies']")
	private WebElement allergiesDropdown;

	@FindBy(xpath = "//mat-select[@id='foodPreference' or @placeholder='Food Preference']")
	private WebElement foodPreferenceDropdown;

	@FindBy(xpath = "//mat-select[@id='cuisineCategory' or @placeholder='Cuisine Category']")
	private WebElement cuisineCategoryDropdown;

	// --- Date Picker Input ---
	@FindBy(xpath = "//input[@data-placeholder='MM/DD/YYYY' or @name='date']")
	private WebElement dateOfBirthField;

	@FindBy(xpath = "//button[@aria-label='Open calendar']")
	private WebElement calendarIcon;
	
	// --- File Upload & Report Locators ---
	@FindBy(xpath = "//input[@type='file']")
	private WebElement fileInput;

	@FindBy(xpath = "//*[text()='Invalid file type. Please upload a valid file']")
	private WebElement invalidFileTypeError;

	@FindBy(xpath = "//*[text()='File size exceeds the allowed limit']")
	private WebElement fileSizeError;

	// --- Test Report Table Elements ---
	@FindBy(xpath = "//td[contains(text(),'.pdf')]")
	private WebElement uploadedFileName;

	@FindBy(xpath = "//td[1]")
	private WebElement recordNumber;

	@FindBy(xpath = "//button[contains(text(),'View PDF')]")
	private WebElement pdfIcon;

	@FindBy(xpath = "//td[contains(text(),'-2024')]")
	private WebElement uploadDate;

	@FindBy(xpath = "//td[contains(text(),'Diabetic') or contains(text(),'Thyroid')]")
	private WebElement healthConditions;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitButton;
			
}