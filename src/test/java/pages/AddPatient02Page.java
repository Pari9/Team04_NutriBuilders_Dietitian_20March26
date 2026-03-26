package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import utilities.CommonMethods;
import utilities.ExcelUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddPatient02Page {
    private WebDriver driver;
    private CommonMethods common;
    public AddPatient02Page(WebDriver driver) {
        this.driver = driver;
        this.common = new CommonMethods(driver); 
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
		
	// --- Name Field Errors ---
    @FindBy(xpath = "//*[contains(text(),'Firstname field is required')]")
    private WebElement firstNameRequiredError;

    @FindBy(xpath = "//*[contains(text(),'Lastname field is required')]")
    private WebElement lastNameRequiredError;

    @FindBy(xpath = "//*[contains(text(),'Patient first name accepts only alphabets')]")
    private WebElement firstNameAlphabetsError;

	// --- Email Error Messages ---
	@FindBy(xpath = "//*[text()='Please enter a valid email address']")
	private WebElement emailInvalidError;

	@FindBy(xpath = "//*[text()='Email id already exists']")
	private WebElement emailExistsError;

	@FindBy(xpath = "//*[text()='Email field is required']")
	private WebElement emailRequiredError;

	// --- Contact Number Error Messages ---
	@FindBy(xpath = "//*[text()='Contact number accepts only numeric values']")
	private WebElement contactNumericError;

	@FindBy(xpath = "//*[text()='Please enter a valid contact number']")
	private WebElement contactInvalidError;

	@FindBy(xpath = "//*[text()='Contact number already exists']")
	private WebElement contactExistsError;

	@FindBy(xpath = "//*[text()='Contact Num is required']")
	private WebElement contactRequiredError;

//Actions
	public void clickOnNewPatientLink() {
        common.clickWebElement(newPatientLink);
    }
	public boolean isOnMyPatientsPage() {
         return common.isElemnetDisplayed(addPatientDetailsTitle);
    }


public void fillFormByTestCase(String testCaseID, String sheetName) {
    List<Map<String, String>> excelData = getExcelData(sheetName); 
    
    for (Map<String, String> row : excelData) {
        if (row.get("TestCaseID").equalsIgnoreCase(testCaseID)) {
            String input = row.get("InputData") == null ? "" : row.get("InputData");
            String field = row.get("ExpectedField").toLowerCase().trim();

            switch (field) {
                case "firstname":
                    common.sendKeys(firstNameField, input);
                    common.clickWebElement(lastNameField); // Blur to trigger error
                    break;

                case "lastname":
                    common.sendKeys(lastNameField, input);
                    common.clickWebElement(firstNameField);
                    break;

                case "email":
                    common.sendKeys(emailField, input);
                    common.clickWebElement(lastNameField);
                    break;

                case "contact number":
                case "contact":
                    common.sendKeys(contactNumberField, input);
                    common.clickWebElement(lastNameField);
                    break;

                case "weight":
                    common.sendKeys(weightField, input);
                    common.clickWebElement(heightField);
                    break;

                case "height":
                    common.sendKeys(heightField, input);
                    common.clickWebElement(weightField);
                    break;

                case "temp":
                    common.sendKeys(temperatureField, input);
                    common.clickWebElement(weightField);
                    break;

                case "spdp":
                    if(input.contains("/")) {
                        String[] vals = input.split("/");
                        common.sendKeys(spField, vals[0]);
                        common.sendKeys(dpField, vals[1]);
                    } else {
                        common.sendKeys(spField, input);
                    }
                    common.clickWebElement(weightField);
                    break;

                default:
                    System.out.println("Warning: No matching field logic for " + field);
            }
            return; 
        }
    }
    throw new RuntimeException("TestCaseID '" + testCaseID + "' not found in sheet: " + sheetName);
}
private List<Map<String, String>> getExcelData(String sheetName) {
    String path = utilities.ConfigReader.getProperty("test_data_path");
    try {
        utilities.ExcelUtils excel = new utilities.ExcelUtils(path);
        return ExcelUtils.getDataAll(sheetName);
        
    } catch (Exception e) {
        System.err.println("CRITICAL: Could not read sheet '" + sheetName + "' from " + path);
        return new ArrayList<>();
    }

}
public void validateErrorByTestCase(String testCaseID, String sheetName) {
    List<Map<String, String>> data = getExcelData(sheetName);
    String expectedError = "";
    for (Map<String, String> row : data) {
        if (row.get("TestCaseID").equalsIgnoreCase(testCaseID)) {
            expectedError = row.get("ExpectedErrorMessage");
            break;
        }
    }
    if (expectedError == null || expectedError.trim().isEmpty()) {
        return;
    }

    try {
      
        By errorLocator = By.xpath("//*[contains(text(),\"" + expectedError.trim() + "\")]");
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(errorLocator));
         String actualError = errorMsg.getText().trim();
        Assert.assertEquals(actualError, expectedError.trim(), 
            "Error mismatch for TestCase: " + testCaseID);
            
    } catch (Exception e) {
        Assert.fail("Test Case [" + testCaseID + "]: Expected error message [" + expectedError + "] was not found on the UI.");
    }
    }
    public void uploadHealthReport(String fileName) {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/testData/" + fileName;
        fileInput.sendKeys(filePath);
    }

    public void clickSubmit() {
        common.clickWebElement(submitButton);
    }

    public void clickClose() {
        common.clickWebElement(submitButton);
    }

    public String getHealthConditionText() {
        return common.getText(healthConditions);
    }

    public boolean isPdfDisplayed() {
        return common.isElemnetDisplayed(uploadedFileName);
    
}public void clickButtonByText(String text) {
    driver.findElement(By.xpath("//button[contains(text(),'" + text + "')]")).click();
}

public boolean isDialogTitleVisible() {
    try {
        return addPatientDetailsTitle.isDisplayed();
    } catch (Exception e) {
        return false;
    }
}}

