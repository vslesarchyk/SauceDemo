package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class CheckoutOverviewPage extends BasePage {

    private final By TITLE = By.cssSelector("[data-test = title]");
    private final By FINISH_BUTTON = By.id("finish");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы CheckoutOverviewPage")
    @Override
    public CheckoutOverviewPage open() {
        log.info("Opening CheckoutOverview Page");
        driver.get(BASE_URL + "/checkout-step-two.html");
        return this;
    }

    @Step("Страница CheckoutOverviewPage открыта")
    @Override
    public CheckoutOverviewPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".inventory_item_name")));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("Page isn't opened");
        }
        return this;
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    @Step("Страница CheckoutCompletePage открыта")
    public CheckoutCompletePage clickFinish() {
        log.info("Successfull click on Finish button");
        driver.findElement(FINISH_BUTTON).click();
        return new CheckoutCompletePage(driver);
    }
}
