package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.testng.Assert.assertEquals;

public abstract class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    public final String BASE_URL = "https://www.saucedemo.com/";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void elementIsEmpty(By locator) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        int numberOfElements = driver.findElements(locator).size();
        assertEquals(numberOfElements, 0);
    }

     public void jSclick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("argument[0].click();", element);
    }

    public void waitForPageLoaded() {
        new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver)
                        .executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };
    }

    public abstract BasePage isPageOpened();

    public abstract BasePage open();
}
