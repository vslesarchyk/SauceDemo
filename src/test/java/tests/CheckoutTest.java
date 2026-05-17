package tests;

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
    public void checkCheckoutWithPositiveCred() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        checkoutInformationPage.clickCheckout();
        checkoutInformationPage.checkout("Ivan", "Ivanov", "12345");
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
    public void checkCheckoutWithNegativeCred(String firstName, String lastName, String zipCode, String errorMessage) {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        checkoutInformationPage.clickCheckout();
        checkoutInformationPage.checkout(firstName, lastName, zipCode);
        assertEquals(checkoutInformationPage.getErrorMessage(),
                errorMessage,
                "Incorrect error message");
    }
}
