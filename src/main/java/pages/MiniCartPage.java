package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MiniCartPage extends Page {
    public MiniCartPage(WebDriver webDriver) {
        super(webDriver);
    }

    private final String firstProductNameLocator = "(//div[@id='minicart-popup']//div[@class='mini-cart-name'])[1]";
    private final String miniCartContainer = "//div[@id='minicart-popup']";
    private final String closeButtonLocator = "//div[@id='minicart-popup-close']";
    private final String viewCartButtonLocator = "//a[@class='mini-cart-viewcart-cta btn-round']";

    @FindBy(how = How.XPATH, using = firstProductNameLocator)
    private WebElement firstProductName;

    @FindBy(how = How.XPATH, using = miniCartContainer)
    private WebElement miniCart;

    @FindBy(how = How.XPATH, using = closeButtonLocator)
    private WebElement closeButton;

    @FindBy(how = How.XPATH, using = viewCartButtonLocator)
    private WebElement viewCartButton;

    public boolean isDisplayed() {
        try {
            waitForVisibilityOf(miniCartContainer);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getFirstProductName() {
        waitForVisibilityOf(firstProductNameLocator);
        return firstProductName.getText();
    }

    public void close() {
        closeButton.click();
    }

    public void goToCart() {
        viewCartButton.click();
    }
}
