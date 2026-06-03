package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class CheckoutCompletePage extends BasePage {

    private final By TITLE = By.cssSelector("[data-test = title]");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы CheckoutCompletePage")
    @Override
    public CheckoutCompletePage open() {
        log.info("Opening CheckoutComplete Page");
        driver.get(BASE_URL + "checkout-complete.html");
        return this;
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    @Step("Страница CheckoutCompletePage открыта")
    @Override
    public CheckoutCompletePage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='complete-header']")));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("Page isn't opened");
        }
        return this;
    }
}
