package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends Page {
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    private final String closeGdprButtonLocator = "//button[@class='gpn-gdpr-close-button scroll-lock']";

    @FindBy(how = How.XPATH, using = closeGdprButtonLocator)
    private WebElement closeGdprButton;

    public void closeGdpr() {
        waitForVisibilityOf(closeGdprButtonLocator, 2);
        closeGdprButton.click();
    }
}
