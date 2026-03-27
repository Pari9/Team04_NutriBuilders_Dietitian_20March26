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
	private JavascriptExecutor js;

	public CommonMethods(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		js = (JavascriptExecutor) driver;
	}

	public void clickWebElement(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	public void clickElementByLocator(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	public WebElement waitForVisibility(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement waitForVisibilityOfElement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

	public String getText(By locator) {
		return waitForVisibility(locator).getText().trim();
	}

	public void scrollWaitAndClick(WebElement element) {

		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView({block:'center'});", element);

		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	public int getElementCount(List<WebElement> element) {
		return element.size();
	}

	public void clickElementByText(List<WebElement> elements, String text) {
		for (WebElement element : elements) {
			if (element.getText().trim().equalsIgnoreCase(text.trim())) {
				clickWebElement(element);
				return;
			}
		}
		throw new RuntimeException("Element with text not found: " + text);
	}
	public void clickElementByText(String text) {
	    // Dynamic XPath: Looks for a span containing the specific text inside an option
	    By optionLocator = By.xpath("//mat-option//span[contains(text(),\"" + text + "\")]");
	    
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
	        option.click();
	    } catch (Exception e) {
	        System.err.println("CRITICAL: Could not find or click the option: " + text);
	        throw e;
	    }
	}

	public boolean isElementPresentByText(List<WebElement> elements,
			String text) {

		if (elements == null || elements.isEmpty()) {
			return false;
		}
		for (WebElement element : elements) {
			if (element.getText() != null && element.getText().trim().equalsIgnoreCase(text.trim())) {
				return true;
			}
		}
		return false;
	}

	public boolean isElementTextEquals(WebElement element,
			String expectedText) {

		if (element == null || expectedText == null) {
			return false;
		}
		String actualText = element.getText().trim();
		return actualText.equalsIgnoreCase(expectedText.trim());
	}

	public String getText(WebElement element) {

		if (element != null) {
			return element.getText().trim();
		}
		return null;

	}

	public String getAttribute(WebElement element, String attributeName) {

		if (element != null) {
			return element.getAttribute(attributeName).trim();
		}
		return null;

	}

	public boolean isElementEnabled(WebElement element) {
		if (element == null) {
			throw new IllegalArgumentException("WebElement is null");
		}
		return element.isEnabled();
	}

	public void waitForUrlToContain(String partialUrl) {
		wait.until(ExpectedConditions.urlContains(partialUrl));
	}

	public void sendKeys(WebElement element, String text) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(text);
	}

	public String JavaScriptvalidation(WebElement element) {

		return ((String) js.executeScript(
				"return arguments[0].validationMessage;", element));

	}

	public boolean isElemnetDisplayed(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.isDisplayed();
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

	public void mouseOverAnElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();

	}
}
