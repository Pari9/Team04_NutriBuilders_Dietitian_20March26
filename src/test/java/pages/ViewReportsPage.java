package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.CommonMethods;

import java.util.List;

public class ViewReportsPage {

    private WebDriver driver;
    private CommonMethods commonMethods;

    public ViewReportsPage(WebDriver driver) {
        this.driver = driver;
        this.commonMethods = new CommonMethods(driver);
        PageFactory.initElements(driver, this);

    }

    @FindBy (linkText = "My Patients") private WebElement myPatientsLink;
    @FindBy (xpath = "//button[text()='View Previous Test Reports']") private WebElement viewReportsBtn;
    @FindBy (tagName = "h1") private WebElement reportsTitle;
    @FindBy (id = "patientId") private WebElement patientId;
    @FindBy (id = "Name") private WebElement nameField;
    @FindBy (name = "Email") private WebElement emailField;
    @FindBy (name = "Contact Number") private WebElement contactNumberField;
    @FindBy (className = "Close") private WebElement closeBtn;
    @FindBy (xpath = "//table") private WebElement reportsTable;
    @FindBy (xpath = "//table//th") private WebElement reportsTableHeaders;


    public String getTitle() {
        return commonMethods.getText(reportsTitle);
    }

    public String getPatientId() {
        return commonMethods.getText(patientId);
    }

    public void navigateToMyPatientsPage() {
        commonMethods.clickWebElement(myPatientsLink);
    }

    public void clickTestReports() {
        commonMethods.clickWebElement(viewReportsBtn);
    }

    public Boolean isNameDisplayed() {
        return commonMethods.waitForVisibilityOfElement(nameField).isDisplayed();
    }

    public Boolean isPatientIdDisplayed() {
        return commonMethods.waitForVisibility((By) patientId).isDisplayed();
    }

    public Boolean isEmailDisplayed() {
        return commonMethods.waitForVisibilityOfElement(emailField).isDisplayed();
    }

    public Boolean isContactNumberDisplayed() {
        return commonMethods.waitForVisibilityOfElement(contactNumberField).isDisplayed();
    }

    public Boolean isCloseBtnDisplayed() {
        return commonMethods.waitForVisibilityOfElement(closeBtn).isDisplayed();
    }

    public Boolean isReportTableDisplayed() {
        return commonMethods.waitForVisibilityOfElement(reportsTable).isDisplayed();
    }

    public boolean isColumnHeaderPresent(String columnName) {
        List<WebElement> headers = driver.findElements((By) reportsTableHeaders);
        for (WebElement header : headers) {
            if (header.getText().trim().equals(columnName)) {
                return true;
            }
        }
        return false;
    }

    public boolean isColumnOrderCorrect(List<String> expectedOrder) {
        List<WebElement> headers = driver.findElements((By) reportsTableHeaders);
        for (int i = 0; i < expectedOrder.size(); i++) {
            if (!headers.get(i).getText().trim().equals(expectedOrder.get(i))) {
                return false;
            }
        }
        return true;
    }

    }
