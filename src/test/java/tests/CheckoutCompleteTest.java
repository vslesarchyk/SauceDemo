package tests;

import org.testng.annotations.Test;
import pages.BasePage;

import static org.testng.Assert.assertEquals;

public class CheckoutCompleteTest extends BaseTest {

    @Test (
            description = "Проверка перехода на страницу с информацией об оформлении заказа",
            testName = "checkPageNavigationToCheckoutComplete",
            groups = {"smoke", "regression"}
    )
    public void checkPageNavigationToCheckoutComplete() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        checkoutInformationPage.clickCheckout();
        checkoutInformationPage.checkout("Ivan", "Ivanov", "12345");
        checkoutOverviewPage.clickFinish();
        assertEquals(checkoutCompletePage.getTitle(),
                "Checkout: Complete!",
                "Incorrect title");
    }
}