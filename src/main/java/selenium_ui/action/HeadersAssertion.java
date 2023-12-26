package selenium_ui.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium_ui.infra.HeadersPage;

import java.time.Duration;

public class HeadersAssertion{

    private WebDriver driver;
    private WebDriverWait wait;

    public HeadersAssertion(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitForElementPresent(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public boolean isWomenHeaderPresent() {
        waitForElementPresent(HeadersPage.WOMEN_HEADER);
        return isElementPresent(HeadersPage.WOMEN_HEADER);
    }

    // Update other methods to use locators from HeadersPage class
    public boolean isInternationalHeaderPresent() {
        waitForElementPresent(HeadersPage.INTERNATIONAL_HEADER);
        return isElementPresent(HeadersPage.INTERNATIONAL_HEADER);
    }

    public boolean isMoreButtonPresent() {
        waitForElementPresent(HeadersPage.MORE_BUTTON);
        return isElementPresent(HeadersPage.MORE_BUTTON);
    }

    public boolean isChampionsLeagueLinkPresent() {
        waitForElementPresent(HeadersPage.CHAMPIONS_LEAGUE_LINK);
        return isElementPresent(HeadersPage.CHAMPIONS_LEAGUE_LINK);
    }

    public boolean isEuropeanLeaguesHeaderPresent() {
        waitForElementPresent(HeadersPage.EUROPEAN_LEAGUES_HEADER);
        return isElementPresent(HeadersPage.EUROPEAN_LEAGUES_HEADER);
    }

    public boolean isPremierLeagueHeaderPresent() {
        waitForElementPresent(HeadersPage.PREMIER_LEAGUE_HEADER);
        return isElementPresent(HeadersPage.PREMIER_LEAGUE_HEADER);
    }

    public boolean isTransferNewsHeaderPresent() {
        waitForElementPresent(HeadersPage.TRANSFER_NEWS_HEADER);
        return isElementPresent(HeadersPage.TRANSFER_NEWS_HEADER);
    }

    public boolean isNewsLinkPresent() {
        waitForElementPresent(HeadersPage.NEWS_LINK);
        return isElementPresent(HeadersPage.NEWS_LINK);
    }
}
