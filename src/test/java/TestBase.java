import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.*;
import webDriver.WebDriverFactory;

class TestBase {

    WebDriver webDriver;
    String baseUrl;
    String continent;
    String country;
    String language;
    MenuBar menuBar;
    CamerasPage camerasPage;
    MiniCartPage miniCartPage;
    HomePage homePage;
    CartPage cartPage;

    @BeforeClass
    protected void init() {
        baseUrl = System.getProperty("baseUrl");
        continent = System.getProperty("continent");
        country = System.getProperty("country");
        language = System.getProperty("language");
        webDriver = WebDriverFactory.getInstance();
        menuBar = PageFactory.initElements(webDriver, MenuBar.class);
        camerasPage = PageFactory.initElements(webDriver, CamerasPage.class);
        miniCartPage = PageFactory.initElements(webDriver, MiniCartPage.class);
        homePage = PageFactory.initElements(webDriver, HomePage.class);
        cartPage = PageFactory.initElements(webDriver, CartPage.class);
    }

    @AfterClass
    protected void tearDown() {
        webDriver.quit();
    }
}
