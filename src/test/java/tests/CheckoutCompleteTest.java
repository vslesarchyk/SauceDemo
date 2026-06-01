package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.BasePage;

import static org.testng.Assert.assertEquals;

public class CheckoutCompleteTest extends BaseTest {

    @Test(
            description = "Проверка перехода на страницу информации об оформлении заказа",
            testName = "checkPageNavigationToCheckoutComplete",
            groups = {"smoke", "regression"}
    )
    @Owner("Slesarchyk V.A.")
    @Epic("Sauce Demo 2")
    @Feature("Checkout")
    @Story("Page navigation to checkout complete")
    @Severity(SeverityLevel.NORMAL)
    public void checkPageNavigationToCheckoutComplete() {
        loginPage.open()
                .login("standard_user", "secret_sauce")
                .addToCart("Sauce Labs Backpack")
                .clickCart()
                .clickCheckout()
                .checkoutWithPositiveCred("Ivan", "Ivanov", "12345")
                .clickFinish();
        assertEquals(checkoutCompletePage.getTitle(),
                "Checkout: Complete!",
                "Incorrect title");
    }
}