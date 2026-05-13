package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {

    WebDriver driver;
    public final String BASE_URL = "https://www.saucedemo.com/";
    public static final String LOGIN_USER = "standard_user";
    public static final String PASSWORD = "secret_sauce";
    public static final String FIRST_NAME = "Ivan";
    public static final String LAST_NAME = "Ivanov";
    public static final String ZIP_CODE = "12345";

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
