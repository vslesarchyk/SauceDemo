package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BasePage;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    @Test(
            description = "Проверка валидного заполнения данных о покупателе",
            testName = "checkCheckoutWithPositiveCred",
            groups = {"smoke", "regression"}
    )
    @Owner("Slesarchyk V.A.")
    @Epic("Sauce Demo 2")
    @Feature("Checkout")
    @Story("Checkout with credentials")
    @Severity(SeverityLevel.CRITICAL)
    public void checkCheckoutWithPositiveCred() {
        loginPage.open()
                .login("standard_user", "secret_sauce")
                .addToCart("Sauce Labs Backpack")
                .clickCart()
                .clickCheckout()
                .checkoutWithPositiveCred("Ivan", "Ivanov", "12345");
        assertEquals(checkoutOverviewPage.getTitle(),
                "Checkout: Overview",
                "Incorrect title");
    }

    @DataProvider(name = "Параметризированный тест для негативного checkout")
    public Object[][] loginData() {
        return new Object[][]{
                {"", "Ivanov", "12345", "Error: First Name is required"},
                {"Ivan", "", "12345", "Error: Last Name is required"},
                {"Ivan", "Ivanov", "", "Error: Postal Code is required"},
                {"", "", "", "Error: First Name is required"}
        };
    }

    @Test(dataProvider = "Параметризированный тест для негативного checkout",
            testName = "heckCheckoutWithNegativeCred",
            groups = {"regression", "smoke"}
    )
    @Owner("Slesarchyk V.A.")
    @Epic("Sauce Demo 2")
    @Feature("Checkout")
    @Story("Checkout with credentials")
    @Severity(SeverityLevel.NORMAL)
    public void checkCheckoutWithNegativeCred(String firstName, String lastName, String zipCode, String errorMessage) {
        loginPage.open()
                .login("standard_user", "secret_sauce")
                .addToCart("Sauce Labs Backpack")
                .clickCart()
                .isPageOpened()
                .clickCheckout()
                .checkoutWithNegativeCred(firstName, lastName, zipCode);
        assertEquals(checkoutInformationPage.getErrorMessage(),
                errorMessage,
                "Incorrect error message");
    }
}