package tests;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTest {

    @Test(description = "Проверка добавления двух товаров в корзину",
            testName = "checkAddProductsFromProductsPage",
            groups = {"smoke", "regression"}
    )
    @Owner("Slesarchyk V.A.")
    @Epic("Sauce Demo 3")
    @Feature("Cart")
    @Story("Add products to cart")
    @Description("Проверка добавления двух товаров в корзину")
    @Severity(SeverityLevel.CRITICAL)
    @Flaky
    @Link(name = "Аналитика", url = "https://www.saucedemo.com/")
    @TmsLink("SD-To1")
    @Issue("BUG-01")
    public void checkAddProductsFromProductsPage() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.open()
                .login(user, password)
                .addToCart("Sauce Labs Backpack")
                .addToCart("Test.allTheThings() T-Shirt (Red)")
                .clickCart();
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
    @Owner("Slesarchyk V.A.")
    @Epic("Sauce Demo 3")
    @Feature("Cart")
    @Story("Remove product from cart")
    @Severity(SeverityLevel.NORMAL)
    public void checkRemoveProductFromCart() {
        loginPage.open()
                .login(user, password)
                .addToCart("Sauce Labs Backpack")
                .addToCart("Test.allTheThings() T-Shirt (Red)")
                .clickCart()
                .removeFromCart("Test.allTheThings() T-Shirt (Red)");
        SoftAssert softAssert = new SoftAssert();
        List<String> products = cartPage.getProductItems();
        softAssert.assertTrue(products.contains("Sauce Labs Backpack"),
                "Sauce Labs Backpack is missing");
        softAssert.assertFalse(products.contains("Test.allTheThings() T-Shirt (Red)"),
                "Product was not removed");
        softAssert.assertAll();
    }
}