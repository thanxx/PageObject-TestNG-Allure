package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InitialPage extends BasePage{

    public InitialPage(WebDriver driver) {super(driver);}

    private final By signInButton = new By.ById("signin_button");

    @Step("Press SignIn Button")
    public LogInPage goToLogIn()
    {
        fluentWait(signInButton).click();
        return new LogInPage(getDriver());
    }
}
