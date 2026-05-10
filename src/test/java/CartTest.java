import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CartTest extends BaseTest {
    String expectedProductName = "Sauce Labs Backpack";
    String expectedProductPrice = "$29.99";

    @Test
    public void checkCart() {
        SoftAssert softAssert = new SoftAssert();

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.className("submit-button")).click();
        driver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a")).click();
        String actualProductName=driver.findElement(By.xpath("//div[@data-test='inventory-item-name']")).getText();
        String actualProductPrice=driver.findElement(By.xpath("//div[@data-test='inventory-item-price']")).getText();
        softAssert.assertEquals(actualProductName, expectedProductName, "The name of the product is not equal");
        softAssert.assertEquals(actualProductPrice, expectedProductPrice, "The price of the product is not equal");
        softAssert.assertAll();
    }
}