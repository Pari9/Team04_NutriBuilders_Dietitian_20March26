package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utilities.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class AddPatient02Page {
	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();
	public AddPatient02Page(WebDriver driver) {
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

	@FindBy(xpath = "//*[@id=\"userNumber\"]")
	private WebElement contacNumber;

	@FindBy(xpath = "//button[contains(text(),'View PDF')]")
	private WebElement pdfIcon;

	@FindBy(xpath = "//td[contains(text(),'-2024')]")
	private WebElement uploadDate;

	@FindBy(xpath = "//td[contains(text(),'Diabetic') or contains(text(),'Thyroid')]")
	private WebElement healthConditions;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitButton;
			

//Actions
public void clickOnNewPatientLink() {
    newPatientLink.click();
}
public boolean isOnMyPatientsPage() {
    try {
        return addPatientDetailsTitle.isDisplayed();
    } catch (org.openqa.selenium.NoSuchElementException e) {
        return false;
    }
}


public void fillFormByTestCase(String testCaseID, String sheetName) {
    // Fetch the data internally so the Step Def doesn't have to
    List<Map<String, String>> excelData = getExcelData(sheetName); 
    
    for (Map<String, String> row : excelData) {
        if (row.get("TestCaseID").equalsIgnoreCase(testCaseID)) {
            // 1. Extract values from the row
            String input = row.get("InputData") == null ? "" : row.get("InputData");
            String field = row.get("ExpectedField").toLowerCase().trim();

            // 2. Perform the UI action based on the "ExpectedField" column
            switch (field) {
                case "firstname":
                    firstNameField.clear();
                    firstNameField.sendKeys(input);
                    lastNameField.click(); // Trigger validation error
                    break;

                case "lastname":
                    lastNameField.clear();
                    lastNameField.sendKeys(input);
                    firstNameField.click();
                    break;

                case "email":
                    emailField.clear();
                    emailField.sendKeys(input);
                    lastNameField.click();
                    break;

                case "contact number":
                    contactNumberField.clear();
                    contactNumberField.sendKeys(input);
                    lastNameField.click();
                    break;

                case "weight":
                    weightField.clear();
                    weightField.sendKeys(input);
                    heightField.click();
                    break;

                case "height":
                    heightField.clear();
                    heightField.sendKeys(input);
                    weightField.click();
                    break;

                case "temp":
                    temperatureField.clear();
                    temperatureField.sendKeys(input);
                    weightField.click();
                    break;

                case "spdp":
                    // Handles inputs like "120/80" from Excel
                    if(input.contains("/")) {
                        String[] vals = input.split("/");
                        spField.sendKeys(vals[0]);
                        dpField.sendKeys(vals[1]);
                    } else {
                        spField.sendKeys(input);
                    }
                    weightField.click();
                    break;

                default:
                    System.out.println("Warning: No matching field logic for " + field);
            }
            return; // Successfully processed, exit the loop
        }
    }
    // Throw error if the ID from the Feature file doesn't exist in Excel
    throw new RuntimeException("TestCaseID '" + testCaseID + "' not found in sheet: " + sheetName);
}
private List<Map<String, String>> getExcelData(String sheetName) {
	// Get the path from your global config file
    String path = utilities.ConfigReader.getProperty("test_data_path");
    
    try {
        // Instantiate your team's existing Excel utility
        utilities.ExcelUtils excel = new utilities.ExcelUtils(path);
        
        // Return all rows from the requested sheet (PatientData, Vitals, etc.)
        return ExcelUtils.getDataAll(sheetName);
        
    } catch (Exception e) {
        System.err.println("CRITICAL: Could not read sheet '" + sheetName + "' from " + path);
        return new ArrayList<>(); // Return empty list to prevent downstream crashes
    }

}}

