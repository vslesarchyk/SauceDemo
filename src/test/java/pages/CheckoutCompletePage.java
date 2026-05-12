package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage{

    private final By TITLE = By.cssSelector("[data-test = title]");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public String getTitle(){
        return driver.findElement(TITLE).getText();
    }
}
