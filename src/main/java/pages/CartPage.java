package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends Page {
    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    private final String pname = "//div[@class='name']";
    private final String remove = "//button[@id='deleteProduct']";
    private final String cartRow = "//td[@class='cart-nested-table']";
    private final String cartEmptyLocator = "//div[@class='cart-empty']";

    @FindBy(how = How.XPATH, using = cartEmptyLocator)
    private WebElement cartEmpty;

    private List<WebElement> getCartRows() {
        waitForVisibilityOf(cartRow, 5);
        return webDriver.findElements(By.xpath(cartRow));
    }

    public boolean emptyCartIsDisplayed() {
        try {
            waitForVisibilityOf(cartEmptyLocator);
            return cartEmpty.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void removeProductByName(String name) {
        System.out.println("Removing product from cart: " + name);
        for (WebElement el : getCartRows()) {
            if (el.findElement(By.xpath(pname)).getText().equals(name)) {
                el.findElement(By.xpath(remove)).click();
                break;
            }
        }
    }

    public List<String> getNameList() {
        List<String> nl = new ArrayList<>();
        webDriver.findElements(By.xpath(pname)).forEach(x -> nl.add(x.getText()));
        return nl;
    }

    private List<WebElement> getRemoveButtons() {
        return webDriver.findElements(By.xpath(remove));
    }

    public int getIndexByProductName(String name) {
        return getNameList().indexOf(name);
    }

    public void removeProductByIndex(int index) {
        getRemoveButtons().get(index).click();
    }
}
