package pages;

import com.google.common.base.Function;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;


public class BasePage {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    private static final int timeout = 5;
    private static final int pollingEvery = 200;

    public BasePage(WebDriver driver)
    {
        this.driver.set(driver);
    }


    public static WebDriver getDriver()
    {
        return driver.get();
    }

    // Generic wait helper

    protected WebElement fluentWait(final By locator) {
        Wait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(pollingEvery))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });

        return element;
    }


    // Find helpers

    protected WebElement findElementByTextEquals(String text)
    {
        return fluentWait(By.xpath(String.format("//*[text()='%s']", text)));
    }

    protected WebElement findElementContains(String text)
    {
        return fluentWait(By.xpath(String.format("//*[contains(., '%s')]", text)));
    }

    @Step("Check if {text} exist on the page")
    public boolean checkIfPageContainsText(String text)
    {
        try {
            findElementContains(text);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }



}
