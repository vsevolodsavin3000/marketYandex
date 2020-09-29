package UITests.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    WebDriver driver;

    @FindBy(xpath = "//span[contains(text(),'Да, спасибо')]")
    private WebElement yesRegion;

    @FindBy(xpath = "//span[contains(text(),'Электроника')]")
    private WebElement electronicsTab;

    @FindBy(linkText = "Телевизоры")
    private WebElement TVCategory;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openTVSection(){
        WebDriverWait wait = new WebDriverWait(driver,10,300);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        wait.until(ExpectedConditions.visibilityOf(yesRegion)).click();
        executor.executeScript("arguments[0].click();", electronicsTab);
        wait.until(ExpectedConditions.elementToBeClickable(TVCategory)).click();
    }
}