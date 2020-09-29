package UITests.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeparateTVPage {
    WebDriver driver;

    @FindBy(id = "glpricefrom")
    private WebElement priceFrom;

    @FindBy(css = "h1")
    private WebElement TVname;

    @FindBy(xpath = "//span[contains(text(),'Цены')]")
    private WebElement pricesTab;

    public SeparateTVPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getTVName(){
        return TVname.getText();
    }

    public int getTVPrice(){
        pricesTab.click();
        return Integer.parseInt(priceFrom.getAttribute("placeholder").replaceAll(" ",""));
        //return starting price in search field placeholder
    }
}
