package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    private final By PRODUCT_ITEM = By.cssSelector("[data-test = inventory-item-name]");
    private final String REMOVE_FROM_CART_BUTTON =
            "//*[text()='%s']//ancestor::div[@class='cart_item']//button[starts-with(@id, 'remove')]";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "/cart.html");
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

    public void removeFromCart(String product) {
        driver.findElement(By.xpath(String.format(REMOVE_FROM_CART_BUTTON, product))).click();
    }
}
