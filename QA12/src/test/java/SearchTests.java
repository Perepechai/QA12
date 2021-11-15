import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class SearchTests {
    WebDriver driver;
    @BeforeSuite
    public void setDriverProperties(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }
    @BeforeMethod
    public void setUpBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://rozetka.com.ua/");
    }
    @Test
    public void searchResultTitlesTest(){
        String query = "selenium";
        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = homePage.search(query);
        List<String> resultsTitles = searchResultPage.getResultListTitle();
        for( String title: resultsTitles){
            Assert.assertTrue(title.toLowerCase().contains(query));
        }
    }
    @Test
    public void test2(){
        String query = "Наушники";
        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = homePage.search(query);
        ResultPage resultPage = searchResultPage.selectProduct();
        CartPage cartPage = resultPage.buyProduct();
        String result = cartPage.getTitle();
        Assert.assertTrue(result.contains(query));
    }
    @Test
    public void test3(){
        String query = "Наушники";
        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = homePage.search(query);
        ResultPage resultPage = searchResultPage.selectProduct();
        String color = resultPage.getProductColors();
        Assert.assertTrue(color.contains("Black"));
    }
    @Test
    public void test4(){
        String query = "Наушники";
        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = homePage.search(query);
        ResultPage resultPage = searchResultPage.selectProduct();
        String character = resultPage.getProductCharacter();
        Assert.assertTrue(character.contains("TWS (2 раздельно)"));
    }
    @AfterMethod(alwaysRun = true)
    public void takeScreenshot(ITestResult result)
    {
        if (!result.isSuccess())
            try {                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(scrFile, new File(result.getName() + "[" + LocalDate.now() + "][" + System.currentTimeMillis() + "].png"));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        driver.quit();
    }
}
