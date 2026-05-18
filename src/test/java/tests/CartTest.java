package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTest {

    @Test (description = "Проверка добавления двух товаров в корзину",
            testName = "checkAddProductsFromProductsPage",
            groups = {"smoke", "regression"}
    )
    public void checkAddProductsFromProductsPage() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Test.allTheThings() T-Shirt (Red)");
        productsPage.clickCart();
        List<String> products = cartPage.getProductItems();
        softAssert.assertTrue(
                products.contains("Sauce Labs Backpack"),
                "Error: item is incorrect");
        softAssert.assertTrue(
                products.contains("Test.allTheThings() T-Shirt (Red)"),
                "Error: item is incorrect");
        softAssert.assertAll();
    }

    @Test(description = "Проверка удаления одного товара из корзины",
            testName = "checkRemoveProductFromCart",
            groups = {"smoke", "regression"}
    )
        public void checkRemoveProductFromCart() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Test.allTheThings() T-Shirt (Red)");
        productsPage.clickCart();
        cartPage.removeFromCart("Test.allTheThings() T-Shirt (Red)");
        List<String> products = cartPage.getProductItems();
        softAssert.assertTrue( products.contains("Sauce Labs Backpack"),
                "Sauce Labs Backpack is missing");
        softAssert.assertFalse( products.contains("Test.allTheThings() T-Shirt (Red)"),
                "Product was not removed");
        softAssert.assertAll();
    }
}