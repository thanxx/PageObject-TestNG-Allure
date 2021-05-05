package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage extends BasePage {
    public LogInPage(WebDriver driver) {super(driver);}

    private final By loginForm = new By.ById("user_login");
    private final By passwordForm = new By.ById("user_password");
    private final By rememberMe = new By.ById("user_remember_me");
    private final By signInButton = new By.ByXPath("//input[@name='submit']");

    @Step("Type {username} and {password}, click Remember Me checkbox, and click the Log In button")
    public AccountPage logIn(String username, String password){

        fluentWait(loginForm).sendKeys(username);
        fluentWait(passwordForm).sendKeys(password);
        fluentWait(rememberMe).click();
        fluentWait(signInButton).click();


        return new AccountPage(getDriver());
    }
}
