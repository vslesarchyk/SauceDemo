import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LocatorsTest extends BaseTest {

    @Test
    public void checkLocators() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.className("submit-button")).click();
        driver.findElement(By.tagName("div"));
        driver.findElement(By.linkText("Facebook"));
        driver.findElement(By.partialLinkText("Bike"));
        driver.findElement(By.xpath("button[@name='add-to-cart-sauce-labs-backpack']"));
        driver.findElement(By.xpath("//span[text()='Products']"));
        driver.findElement(By.xpath("div[contains(@data-test,'name')]"));
        driver.findElement(By.xpath("//div[contains(text(),'Labs')]"));
        driver.findElement(By.xpath("//*[text()='29.99']//ancestor::div"));
        driver.findElement(By.xpath("//a[contains(@data-test,'item-0')]//descendant::div"));
        driver.findElement(By.xpath("//div[@class='pricebar']/following::button"));
        driver.findElement(By.xpath("//button[text()='Add to cart']/parent::div"));
        driver.findElement(By.xpath("//button[text()='Add to cart']/preceding::div"));
        driver.findElement(By.xpath("//div[div and button]"));
        driver.findElement(By.cssSelector(".pricebar"));
        driver.findElement(By.cssSelector(".btn.btn_primary"));
        driver.findElement(By.cssSelector(".pricebar .inventory_item_price"));
        driver.findElement(By.cssSelector("#inventory_sidebar_link"));
        driver.findElement(By.cssSelector("div"));
        driver.findElement(By.cssSelector("div.footer_copy"));
        driver.findElement(By.cssSelector("[class=shopping_cart_container]"));
        driver.findElement(By.cssSelector("[class~=btn_small]"));
        driver.findElement(By.cssSelector("[data-test|='shopping-cart']"));
        driver.findElement(By.cssSelector("[href^='https']"));
        driver.findElement(By.cssSelector("[href$='.png']"));
        driver.findElement(By.cssSelector("[href*='manifest']"));
         }
}
