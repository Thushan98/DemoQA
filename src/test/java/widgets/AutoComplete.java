package widgets;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AutoComplete {
    WidgetsSetup setup;
    WebDriver driver;
    Actions act;
    JavascriptExecutor js;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        setup = new WidgetsSetup();
        driver = setup.settingWidgetsPage();
        act = new Actions(driver);
        js = (JavascriptExecutor) driver;
        driver.findElement(By.xpath("//span[text()='Auto Complete']")).click();

        js.executeScript("window.scrollBy(0,250)", "");
    }

    @Test
    public void autoCompleteTest() {
        WebElement multipleAuto = driver.findElement(By.id("autoCompleteMultipleInput"));
        multipleAuto.click();
        multipleAuto.sendKeys("c");
        wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("auto-complete__menu")));
        multipleAuto.sendKeys(Keys.DOWN);
        multipleAuto.sendKeys(Keys.ENTER);

        multipleAuto.sendKeys("t");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("auto-complete__menu")));
        multipleAuto.sendKeys(Keys.DOWN);
        multipleAuto.sendKeys(Keys.DOWN);
        multipleAuto.sendKeys(Keys.ENTER);
        //driver.findElement(By.id("section2Heading")).click();

        WebElement singleAuto = driver.findElement(By.id("autoCompleteSingleInput"));
        singleAuto.click();
        singleAuto.sendKeys("c");
        wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("auto-complete__menu")));
        singleAuto.sendKeys(Keys.DOWN);
        singleAuto.sendKeys(Keys.ENTER);
    }
}
