package UITests.Tests;

import UITests.Pages.MainPage;
import UITests.Pages.SearchResultPage;
import UITests.Pages.SeparateTVPage;
import UITests.Pages.TVSection;
import io.qameta.allure.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends InitialSteps {

    @Test(priority = 1, description = "Verify search result is correct")
    @Story("Story:Valid search")
    @Severity(SeverityLevel.NORMAL)
    public void SearchTest() {
        driver.get("https://market.yandex.ru/");
        openTVSection();
        setSearchParameters();
        clickFirstTVFromResults();
        verifyCorrectResult();
    }

    @Step("Open TV section")
    public void openTVSection() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openTVSection();
        screenshot();
    }

    @Step("Set search parameters")
    public void setSearchParameters() {
        TVSection tvSection = new TVSection(driver);
        tvSection.setPriceFrom(20000);
        tvSection.setManufacturers();
        driver.navigate().refresh();
        screenshot();
    }

    @Step("Click first TV from search results")
    public void clickFirstTVFromResults() {
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.clickFirstTVFromResultAndGoToNewPage();
        screenshot();
    }

    @Step("Verify correct result")
    public void verifyCorrectResult() {
        SeparateTVPage separateTVPage = new SeparateTVPage(driver);
        screenshot();
        Assert.assertTrue(separateTVPage.getTVName().contains("LG") || separateTVPage.getTVName().contains("Samsung"),
                "Real tv name: " + separateTVPage.getTVName());
        Assert.assertTrue(separateTVPage.getTVPrice() >= 20000, "Real price: " + separateTVPage.getTVPrice());
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
