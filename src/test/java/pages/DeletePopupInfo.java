package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageObjectManager.PageObjectManager;

public class DeletePopupInfo {

	WebDriver driver;
	private PageObjectManager pom;


	public DeletePopupInfo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@icon='pi pi-trash']")
	public WebElement deleteIcon;

	@FindBy(xpath = "//button[text() ='yes']")
	WebElement yesButton;

	@FindBy(xpath = "//button[text() ='yes']")
	WebElement noButton;

	@FindBy(xpath = "//*[text()='Are You Sure']")
	WebElement deleteAlertMesg;
	
	@FindBy(xpath = "//*[text()='Success Delete Msg']")
	WebElement deleteSuccessMesg;

	@FindBy(xpath = "//button[text() ='close']")
	WebElement deletePopupXButton;

	@FindBy(xpath = "//*[text()='Confirm']")
	WebElement confirmDeletePopup;
	
	public void clickDeleteIcon()
	{
		pom.getCommonMethods().clickWebElement(deleteIcon);
	}

	public boolean isYesButtonDisplayed()
	{
		return pom.getCommonMethods().isElemnetDisplayed(yesButton);
	}
	
	public boolean isNoButtonDisplayed()
	{
		return pom.getCommonMethods().isElemnetDisplayed(noButton);
	}
	
	public boolean isAlertMsgDisplayed()
	{
		return pom.getCommonMethods().isElemnetDisplayed(deleteAlertMesg);
	}
	
	
}
