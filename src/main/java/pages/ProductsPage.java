package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class ProductsPage extends BasePage {

    private final By TITLE = By.cssSelector("[data-test = title]");
    private final By CART = By.cssSelector("[data-test = shopping-cart-link]");
    private final String ADD_TO_CART_PATTERN =
            "//*[text()='%s']//ancestor::div[@class='inventory_item']//button[text()='Add to cart']";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage open() {
        log.info("Opening Products Page");
        driver.get(BASE_URL + "/inventory.html");
        return this;
    }

    @Override
    public ProductsPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("Page isn't opened");
        }
        return this;
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    @Step("Добавление в корзину товара с именем: '{product}'")
    public ProductsPage addToCart(String product) {
        log.info("Adding product '{}' to cart", product);
        driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTERN, product))).click();
        return this;
    }

    @Step("Нажатие на кнопку корзина")
    public CartPage clickCart() {
        log.info("Click on basket button");
        driver.findElement(CART).click();
        return new CartPage(driver);
    }
}
