import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends BasePage{
    private By results = new By.ByXPath("//a[@class=\"goods-tile__heading ng-star-inserted\"]");
    private By titleXpath = new By.ByXPath(".//span[@class='goods-tile__title']");
    public SearchResultPage(WebDriver driver){
        this.driver = driver;
    }
    public ResultPage selectProduct()
    {
        driver.findElement(results).click();
        return new ResultPage(driver);
    }
    public List<String> getResultListTitle(){
        List<WebElement> resultWebElements = driver.findElements(results);
        List<String> titles = new ArrayList<>();
        for (WebElement result: resultWebElements) {
            WebElement title = result.findElement(titleXpath);
            titles.add(title.getText());
        }
        return titles;
    }
}
