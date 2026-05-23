package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInformationPage extends BasePage{

    private final By FIRSTNAME_FIELD= By.id("first-name");
    private final By LASTNAME_FIELD= By.id("last-name");
    private final By ZIPCODE_FIELD = By.id("postal-code");
    private final By CONTINUE_BUTTON= By.id("continue");
    private final By ERROR_MESSAGE= By.cssSelector("[data-test=error]");
    private final By CHECKOUT_BUTTON=By.id("checkout");

    public CheckoutInformationPage(WebDriver driver) {
        super(driver);
    }

    public void open(){
        driver.get(BASE_URL +"/checkout-step-one.html");
    }

    public void checkout(String first_name, String last_name, String zip_code){
        driver.findElement(FIRSTNAME_FIELD).sendKeys(first_name);
        driver.findElement(LASTNAME_FIELD).sendKeys(last_name);
        driver.findElement(ZIPCODE_FIELD).sendKeys(zip_code);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public String getErrorMessage(){
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    @Step("Переход на страницу для оформления заказа")
    public void clickCheckout() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }
}
