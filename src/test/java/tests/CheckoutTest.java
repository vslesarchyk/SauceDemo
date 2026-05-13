package tests;

import org.testng.annotations.Test;
import pages.BasePage;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkCheckoutWithPositiveCred() {
        loginPage.open();
        loginPage.login(BasePage.LOGIN_USER,BasePage.PASSWORD);
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        checkoutInformationPage.clickCheckout();
        checkoutInformationPage.checkout("Ivan", "Ivanov", "12345");
        assertEquals(checkoutOverviewPage.getTitle(),
                "Checkout: Overview",
                "Incorrect title");
    }

    @Test
    public void checkCheckoutWithEmptyFirstName() {
        loginPage.open();
        loginPage.login(BasePage.LOGIN_USER,BasePage.PASSWORD);
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        checkoutInformationPage.clickCheckout();
        checkoutInformationPage.checkout("", "Ivanov", "12345");
        assertEquals(checkoutInformationPage.getErrorMessage(),
                "Error: First Name is required",
                "Incorrect error message");
    }

    @Test
    public void checkCheckoutWithEmptyLastName() {
        loginPage.open();
        loginPage.login(BasePage.LOGIN_USER,BasePage.PASSWORD);
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        checkoutInformationPage.clickCheckout();
        checkoutInformationPage.checkout("Ivan", "", "12345");
        assertEquals(checkoutInformationPage.getErrorMessage(),
                "Error: Last Name is required",
                "Incorrect error message");
    }

    @Test
    public void checkCheckoutWithEmptyZipCode() {
        loginPage.open();
        loginPage.login(BasePage.LOGIN_USER,BasePage.PASSWORD);
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        checkoutInformationPage.clickCheckout();
        checkoutInformationPage.checkout("Ivan", "Ivanov", "");
        assertEquals(checkoutInformationPage.getErrorMessage(),
                "Error: Postal Code is required",
                "Incorrect error message");
    }

    @Test
    public void checkCheckoutWithEmptyFields() {
        loginPage.open();
        loginPage.login(BasePage.LOGIN_USER,BasePage.PASSWORD);
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        checkoutInformationPage.clickCheckout();
        checkoutInformationPage.checkout("", "", "");
        assertEquals(checkoutInformationPage.getErrorMessage(),
                "Error: First Name is required",
                "Incorrect error message");
    }
}
