import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


/**
 * Created by as9l on 05.09.2017.
 */
public class FirstTest {
    private WebDriver driver;
    private WebDriverWait wait;


    @BeforeSuite
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 40);
        driver.get("http://www.sberbank.ru/ru/person");
    }


    @Test

    public void firstStep() throws Exception {

        driver.findElement(By.xpath("//div[contains(@class, 'header-container')]//span[@class='region-list__name']")).click();
    }


    @Test(dependsOnMethods = {"firstStep"})
    public void searchRegion() {
        driver.findElement(By.xpath("//div[@class='region-search-box']//input")).sendKeys("Нижегородская область");
        driver.findElement(By.xpath("//span[@class='region-search-box__option']/u")).click();

    }

    @Test(dependsOnMethods = {"searchRegion"})
    public void checkRegion() {

        WebElement regionElem = driver.findElement(By.xpath("//div[contains(@class, 'header-container')]//span[@class='region-list__name']"));
        wait.ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOf(regionElem));
        String newRegion = regionElem.getText();
        Assert.assertEquals("Регион не изменился!", newRegion, "Нижегородская область");

    }

    @Test(dependsOnMethods = {"checkRegion"})
    public void scrollToFooter() {
        WebElement fooder = driver.findElement(By.xpath("//span[@class='social__icon social__icon_type_fb']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", fooder);
        Assert.assertTrue("Cсылки не нашлись!", fooder.isDisplayed());
    }


    @AfterSuite
    public void closeDriver() {
        driver.quit();
        driver = null;

    }

}
