package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage{

    private final By TITLE = By.cssSelector("[data-test = title]");
    private final By CART = By.cssSelector("[data-test = shopping-cart-link]");
    private final String ADD_TO_CART_PATTERN =
            "//*[text()='%s']//ancestor::div[@class='inventory_item']//button[text()='Add to cart']";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void open(){
        driver.get(BASE_URL + "/inventory.html");
    }

    public String getTitle(){
        return driver.findElement(TITLE).getText();
    }

    @Step("Добавление в корзину товара с именем: '{product}'")
    public void addToCart(String product){
        driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTERN, product))).click();
    }

    @Step("Нажатие на кнопку корзина")
    public void clickCart() {
        driver.findElement(CART).click();
    }
}
