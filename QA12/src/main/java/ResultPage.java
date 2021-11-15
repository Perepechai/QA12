import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ResultPage  extends BasePage{
    private By searchBuyButton = new By.ByXPath("//div[@class=\"product-trade ng-star-inserted\"]//button");
    private By helpClick = new By.ByXPath("//a[@class=\"tabs__link tabs__link--active\"]");
    private By productCharacter = new By.ByXPath("//a[@class=\"ng-star-inserted\"]");
    private By productColorTitle = new By.ByXPath("//p[@class=\"var-options__label\"]");
    public ResultPage(WebDriver driver){
        this.driver = driver;
    }
    public CartPage buyProduct()
    {
        driver.findElement(helpClick).click();
        driver.findElement(searchBuyButton).click();
        return new CartPage(driver);
    }
    public String getProductColors(){
        driver.findElement(helpClick).click();
        return driver.findElement(productColorTitle).getText();
    }
    public String getProductCharacter() {
        driver.findElement(helpClick).click();
        return driver.findElement(productCharacter).getText();
    }

}
