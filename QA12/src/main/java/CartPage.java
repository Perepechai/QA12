import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{
    By cartProductTitle = new By.ByXPath("//a[@class=\"cart-product__title\"]");
    public CartPage(WebDriver driver){
        this.driver = driver;
    }
    public String getTitle(){
        return driver.findElement(cartProductTitle).getText();
    }
}
