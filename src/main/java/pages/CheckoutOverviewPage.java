package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutOverviewPage extends BasePage {

    private final By TITLE = By.cssSelector("[data-test = title]");
    private final By FINISH_BUTTON = By.id("finish");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы CheckoutOverviewPage")
    @Override
    public CheckoutOverviewPage open() {
        driver.get(BASE_URL + "/checkout-step-two.html");
        return this;
    }

    @Step("Страница CheckoutOverviewPage открыта")
    @Override
    public CheckoutOverviewPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".inventory_item_name")));
        return this;
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    @Step("Страница CheckoutCompletePage открыта")
    public CheckoutCompletePage clickFinish() {
        driver.findElement(FINISH_BUTTON).click();
        return new CheckoutCompletePage(driver);
    }
}
