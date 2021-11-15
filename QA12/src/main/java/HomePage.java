import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    By searchInput = new By.ByXPath("//input[@name = 'search']");
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public SearchResultPage search(String searchQuery){
        WebElement searchInputElement = driver.findElement(searchInput);
        searchInputElement.clear();
        searchInputElement.sendKeys(searchQuery);
        searchInputElement.sendKeys(Keys.ENTER);
        return new SearchResultPage(driver);
    }
}
