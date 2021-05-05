import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.InitialPage;

public class MFTest extends BaseTest{


    @Test
    @Description("Visit initial page and log in to the account")
    @Severity(SeverityLevel.BLOCKER)
    public void logInTest() {
        AccountPage accountPage = new InitialPage(driver)
                .goToLogIn().logIn(TestData.username,TestData.password);
        Assert.assertTrue(accountPage.checkIfPageContainsText(TestData.cashAccounts));

    }


}
