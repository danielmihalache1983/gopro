import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoProTest extends TestBase {
    private String expectedTitle1;
    private String expectedTitle2;
    private int firstCamIndex = 1;
    private int secondCamIndex = 3;

    @Test
    public void setup() {
        webDriver.get(baseUrl);
        homePage.closeGdpr();
        menuBar.selectCountryLanguage(continent, country, language);
    }

    @Test(description = "Test that two cameras can successfully be added to cart", priority = 1)
    public void testTwoCamerasCanBeAddedToCart() {
        menuBar.navigateToCamerasCategory();
        expectedTitle1 = camerasPage.getCamTitleByIndex(firstCamIndex);
        System.out.println("Adding product to cart: " + expectedTitle1);
        camerasPage.addCamToCartByIndex(firstCamIndex);
        Assert.assertTrue(miniCartPage.isDisplayed(), "Mini Cart is not displayed");
        Assert.assertEquals(miniCartPage.getFirstProductName(), expectedTitle1, "Title of the product In mini cart is not as expected");
        miniCartPage.close();

        expectedTitle2 = camerasPage.getCamTitleByIndex(secondCamIndex);
        System.out.println("Adding product to cart: " + expectedTitle2);
        camerasPage.addCamToCartByIndex(secondCamIndex);
        Assert.assertTrue(miniCartPage.isDisplayed(), "Mini Cart is not displayed");
        Assert.assertEquals(miniCartPage.getFirstProductName(), expectedTitle2, "Title of the product In mini cart is not as expected");
    }

    @Test(description = "Test that first camera can be removed from cart", priority = 2)
    public void testFirstCameraCanBeRemovedFromCart() {
        miniCartPage.goToCart();
        cartPage.removeProductByName(expectedTitle1);
        for (String pName : cartPage.getNameList()) {
            System.out.println("Product found in cart: " + pName);
            Assert.assertNotEquals(pName, expectedTitle1, "Product was found in cart");
        }
    }

    @Test(description = "Test that second camera can be removed from cart", priority = 3)
    public void testSecondCameraCanBeRemovedFromCart() {
        cartPage.removeProductByName(expectedTitle2);
        for (String pName : cartPage.getNameList()) {
            System.out.println("Product found in cart: " + pName);
            Assert.assertNotEquals(pName, expectedTitle1, "Product was found in cart");
        }
        Assert.assertTrue(cartPage.emptyCartIsDisplayed(), "Cart is not empty");
    }

    @Test(description = "Test that removing second camera again will return exception", expectedExceptions = TimeoutException.class, priority = 4)
    public void testThatRemovingSecondCameraWillFail() {
        cartPage.removeProductByName(expectedTitle2);
    }
}
