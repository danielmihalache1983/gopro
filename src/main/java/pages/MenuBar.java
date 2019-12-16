package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;
import java.util.stream.Collectors;

public class MenuBar extends Page {

    public MenuBar(WebDriver webDriver) {
        super(webDriver);
    }

    private static final String camerasButton = "//li[@class='gpn-menu-list-item cameras']";
    private static final String countrySelectorLocator = "//div[@class='gpn-locale-select-container gpn-user-nav-item']";
    private static final String continentLocator = "(//div[contains(@class, '%s')])[1]/div/div";
    private static final String countryEntryHolder = "//div[contains(@class,'locale-select-country-item')]";
    private static final String countryEntryName = "./div[@class='country-name']/span";
    private static final String countryLanguageList = ".//button[contains(@class,'country-language')]";

    @FindBy(how = How.XPATH, using = camerasButton)
    private WebElement camerasButtonElement;

    @FindBy(how = How.XPATH, using = countrySelectorLocator)
    private WebElement countrySelector;

    private WebElement getContinentByName(String name) {
        return webDriver.findElement(By.xpath(String.format(continentLocator, name)));
    }

    private List<WebElement> getCountryHolderList() {
        return webDriver.findElements(By.xpath(countryEntryHolder));
    }

    public void navigateToCamerasCategory() {
        waitForVisibilityOf(camerasButton);
        camerasButtonElement.click();
    }

    public void selectCountryLanguage(String continent, String country, final String language) {
        openCountrySelector();
        selectContinent(continent);
        System.out.println("searching for country: " + country);
        for (WebElement el : getCountryHolderList()) {
            if (countryIs(country, el)) {
                el.findElements(By.xpath(countryLanguageList)).stream().filter(x -> x.getText().toLowerCase().contains(language.toLowerCase()))
                        .collect(Collectors.toList()).get(0).click();
                break;
            }
        }
    }

    private boolean countryIs(String country, WebElement el) {
        String c = el.findElement(By.xpath(countryEntryName)).getText();
        System.out.println("=====found: " + c);
        return c.toLowerCase().contains(country.toLowerCase());
    }

    private void openCountrySelector() {
        countrySelector.click();
    }

    private void selectContinent(String continent) {
        getContinentByName(continent.toLowerCase()).click();
    }
}
