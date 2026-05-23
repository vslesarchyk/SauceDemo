package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage{

    private final By TITLE = By.cssSelector("[data-test = title]");
    private final By FINISH_BUTTON = By.id("finish");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public void open(){
        driver.get(BASE_URL + "/checkout-step-two.html");
    }

    public String getTitle(){
        return driver.findElement(TITLE).getText();
    }

    public void clickFinish() {
        driver.findElement(FINISH_BUTTON).click();
    }
}
