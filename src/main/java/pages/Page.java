package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class Page {
    WebDriver webDriver;

    Page(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    void waitForVisibilityOf(String locator) {
        waitForVisibilityOf(locator, 10);
    }

    void waitForVisibilityOf(String locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(webDriver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
}
