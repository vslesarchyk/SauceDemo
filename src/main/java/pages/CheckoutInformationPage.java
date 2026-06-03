package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class CheckoutInformationPage extends BasePage {

    private final By FIRSTNAME_FIELD = By.id("first-name");
    private final By LASTNAME_FIELD = By.id("last-name");
    private final By ZIPCODE_FIELD = By.id("postal-code");
    private final By CONTINUE_BUTTON = By.id("continue");
    private final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");
    private final By CHECKOUT_BUTTON = By.id("checkout");

    public CheckoutInformationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы CheckoutInformationPage")
    @Override
    public CheckoutInformationPage open() {
        log.info("Opening CheckoutInformation Page");
        driver.get(BASE_URL + "/checkout-step-one.html");
        return this;
    }

    @Step("Страница CheckoutInformationPage открыта")
    @Override
    public CheckoutInformationPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Checkout: Your Information']")));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("Page isn't opened");
        }
        return this;
    }

    @Step("Выполнение заказа: '{first_name}', {last_name}', {zip_code}")
    public CheckoutOverviewPage checkoutWithPositiveCred(String first_name, String last_name, String zip_code) {
        log.info("Checkout with credentials: '{}', '{}', '{}'", first_name, last_name, zip_code );
        driver.findElement(FIRSTNAME_FIELD).sendKeys(first_name);
        driver.findElement(LASTNAME_FIELD).sendKeys(last_name);
        driver.findElement(ZIPCODE_FIELD).sendKeys(zip_code);
        driver.findElement(CONTINUE_BUTTON).click();
        return new CheckoutOverviewPage(driver);
    }

    @Step("Выполнение заказа: '{first_name}', {last_name}', {zip_code}")
    public CheckoutInformationPage checkoutWithNegativeCred(String first_name, String last_name, String zip_code) {
        log.info("Checkout with negative credentials: '{}', '{}', '{}'", first_name, last_name, zip_code );
        driver.findElement(FIRSTNAME_FIELD).sendKeys(first_name);
        driver.findElement(LASTNAME_FIELD).sendKeys(last_name);
        driver.findElement(ZIPCODE_FIELD).sendKeys(zip_code);
        driver.findElement(CONTINUE_BUTTON).click();
        return new CheckoutInformationPage(driver);
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
