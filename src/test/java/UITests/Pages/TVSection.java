package UITests.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;

public class TVSection {
    WebDriver driver;

    @FindBy(id = "glpricefrom")
    private WebElement priceFrom;

    @FindBy(name = "Производитель LG")
    private WebElement LGCheckbox;

    @FindBy(name = "Производитель Samsung")
    private WebElement samsungCheckbox;

    public TVSection(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setManufacturers(){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", LGCheckbox);
        executor.executeScript("arguments[0].click();", LGCheckbox);
        executor.executeScript("arguments[0].scrollIntoView(true);", samsungCheckbox);
        executor.executeScript("arguments[0].click();", samsungCheckbox);
        executor.executeScript("scroll(0, -250);");
    }

    public void setPriceFrom(String priceFrom){
        this.priceFrom.clear();
        this.priceFrom.sendKeys(priceFrom);
    }

    public void setPriceFrom(int priceFrom){
        this.priceFrom.clear();
        this.priceFrom.sendKeys(Double.toString(priceFrom));
    }
}
