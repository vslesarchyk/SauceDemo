package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Retry;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test(
            description = "Проверка логина с позитивным логином и паролем",
            testName = "checkLoginWithPositiveCred",
            groups = {"smoke", "regression"},
            retryAnalyzer = Retry.class
    )
    @Owner("Slesarchyk V.A.")
    @Epic("Sauce Demo 1")
    @Feature("Log in")
    @Story("Log in with positive credential")
    @Description("Проверка логина с позитивным логином и паролем")
    @Severity(SeverityLevel.CRITICAL)
    @Flaky
    @Link(name = "Аналитика", url = "https://www.saucedemo.com/")
    @TmsLink("SD-To1")
    @Issue("BUG-01")
    public void checkLoginWithPositiveCred() {
        loginPage.open()
                .login(user, password);
        assertEquals(productsPage.getTitle(),
                "Products",
                "SO BAD");
    }

    @DataProvider(name = "Параметризированный тест для негативного логина")
    public Object[][] loginData() {
        return new Object[][]{
                {"", password, "Epic sadface: Username is required"},
                {user, "", "Epic sadface: Password is required"},
                {"test", "test", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(dataProvider = "Параметризированный тест для негативного логина",
            groups = "regression")
    @Owner("Slesarchyk V.A.")
    @Epic("Sauce Demo 1")
    @Feature("Log in")
    @Story("Log in with negative credential")
    @Severity(SeverityLevel.NORMAL)
    public void checkLoginTestWithNegativeCred1(String user, String password, String errorMessage) {
        loginPage.open()
                .loginWithNegativeCred(user, password);
        assertEquals(loginPage.getErrorMessage(),
                errorMessage,
                "SO BAD");
    }
}