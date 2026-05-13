package tests;

import org.testng.annotations.Test;
import pages.BasePage;

import static org.testng.Assert.assertEquals;

public class CheckoutCompleteTest extends BaseTest {

    @Test
    public void checkPageNavigationToCheckoutComplete() {
        loginPage.open();
        loginPage.login(BasePage.LOGIN_USER, BasePage.PASSWORD);
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        checkoutInformationPage.clickCheckout();
        checkoutInformationPage.checkout(BasePage.FIRST_NAME, BasePage.PASSWORD, BasePage.ZIP_CODE);
        checkoutOverviewPage.clickFinish();
        assertEquals(checkoutCompletePage.getTitle(),
                "Checkout: Complete!",
                "Incorrect title");
    }
}