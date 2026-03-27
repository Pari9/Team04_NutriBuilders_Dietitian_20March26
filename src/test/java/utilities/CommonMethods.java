package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CommonMethods {

	private WebDriver driver;
	private WebDriverWait wait;

	public CommonMethods(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	public WebElement clickWebElement(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		return element;
	}

	public WebElement waitForVisibility(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement waitForVisibilityOfElement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

	public WebElement waitForVisibilityOfElements(WebElement element) {
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
		return element;
	}

	public String getText(WebElement element) {

		if (element != null) {
			return element.getText().trim();
		}
		return null;

	}

	public String getAlert() {

		try {
			Alert alert = driver.switchTo().alert();
			String alertMsg = alert.getText();
			alert.accept();
			System.out.println("alert is" + alertMsg);

			return (alertMsg);
		} catch (NoAlertPresentException e) {
			return null;
		}

	}

}
