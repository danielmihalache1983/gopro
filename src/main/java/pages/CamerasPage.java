package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.Sleeper;

import java.util.List;

public class CamerasPage extends Page {
    public CamerasPage(WebDriver webDriver) {
        super(webDriver);
    }

    private final String cameraProductFixed = "//div[contains(@class, 'section-image')]";
    private final String addToCartList = cameraProductFixed + "//button[contains(@class, 'add-to-cart')]";
    private final String titlesList = cameraProductFixed + "//h2";

    @FindBy(how = How.XPATH, using = cameraProductFixed)
    public WebElement cameraProductElement;

    private List<WebElement> getAddToCartButtonList() {
        waitForVisibilityOf(addToCartList);
        return webDriver.findElements(By.xpath(addToCartList));
    }

    private List<WebElement> getTitlesList() {
        waitForVisibilityOf(titlesList);
        return webDriver.findElements(By.xpath(titlesList));
    }

    public String getCamTitleByIndex(int index) {
        return getTitlesList().get(index).getText();
    }

    public void addCamToCartByIndex(int index) {
        Sleeper.silentSleep(500);
        getAddToCartButtonList().get(index).click();
    }

}
