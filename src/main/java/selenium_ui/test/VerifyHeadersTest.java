package selenium_ui.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selenium_ui.action.HeadersAssertion;

import static selenium_ui.infra.SeleniumStringsPage.BASE_URL;

public class VerifyHeadersTest {
    private WebDriver driver;
    private HeadersAssertion headersAssertion;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(BASE_URL);
        headersAssertion = new HeadersAssertion(driver);
    }

    @Test(priority = 1)
    public void testWomenHeaderPresence() {
        Assert.assertTrue(headersAssertion.isWomenHeaderPresent());
    }

    @Test(priority = 2)
    public void testInternationalHeaderPresence() {
        Assert.assertTrue(headersAssertion.isInternationalHeaderPresent());
    }

    @Test(priority = 3)
    public void testMoreButtonPresence() {
        Assert.assertTrue(headersAssertion.isMoreButtonPresent());
    }

    @Test(priority = 4)
    public void testChampionsLeagueLinkPresence() {
        Assert.assertTrue(headersAssertion.isChampionsLeagueLinkPresent());
    }

    @Test(priority = 5)
    public void testEuropeanLeaguesHeaderPresence() {
        Assert.assertTrue(headersAssertion.isEuropeanLeaguesHeaderPresent());
    }

    @Test(priority = 6)
    public void testPremierLeagueHeaderPresence() {
        Assert.assertTrue(headersAssertion.isPremierLeagueHeaderPresent());
    }

    @Test(priority = 7)
    public void testTransferNewsHeaderPresence() {
        Assert.assertTrue(headersAssertion.isTransferNewsHeaderPresent());
    }

    @Test(priority = 8)
    public void testNewsLinkPresence() {
        Assert.assertTrue(headersAssertion.isNewsLinkPresent());
    }
}