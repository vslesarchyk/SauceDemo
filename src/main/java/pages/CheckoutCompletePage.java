package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutCompletePage extends BasePage{

    private final By TITLE = By.cssSelector("[data-test = title]");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы CheckoutCompletePage")
    @Override
    public CheckoutCompletePage open(){
        driver.get(BASE_URL +"checkout-complete.html");
        return this;
    }

    public String getTitle(){
        return driver.findElement(TITLE).getText();
    }

    @Step("Страница CheckoutCompletePage открыта")
    @Override
    public CheckoutCompletePage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='complete-header']")));
        return this;
    }
}
