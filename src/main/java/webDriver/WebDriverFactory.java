package webDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {

    public static WebDriver getInstance() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        return new ChromeDriver();
    }
}
