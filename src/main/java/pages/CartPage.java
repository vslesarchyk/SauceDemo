package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    private final By PRODUCT_ITEM = By.cssSelector("[data-test = inventory-item-name]");
    private final String REMOVE_FROM_CART_BUTTON =
            "//*[text()='%s']//ancestor::div[@class='cart_item']//button[starts-with(@id, 'remove')]";
    private final By CHECKOUT_BUTTON = By.cssSelector("[data-test = checkout]");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Страница CartPage открыта")
    @Override
    public CartPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".inventory_item_name")));
        return this;
    }

    @Step("Открытие страницы CartPage")
    public CartPage open() {
        driver.get(BASE_URL + "/cart.html");
        return this;
    }

    public String getProductItem() {
        return driver.findElement(PRODUCT_ITEM).getText();
    }

    public List<String> getProductItems() {
        List<WebElement> elements = driver.findElements(PRODUCT_ITEM);
        List<String> products = new ArrayList<>();
        for (WebElement element : elements) {
            products.add(element.getText());
        }
        return products;
    }

    @Step("Удаление продукта из корзины: '{product}'")
    public CartPage removeFromCart(String product) {
        driver.findElement(By.xpath(String.format(REMOVE_FROM_CART_BUTTON, product))).click();
        return this;
    }

    @Step ("Нажатие на кнопку Checkout")
    public CheckoutInformationPage clickCheckout() {
        driver.findElement(CHECKOUT_BUTTON).click();
        return new CheckoutInformationPage(driver);
    }
}
