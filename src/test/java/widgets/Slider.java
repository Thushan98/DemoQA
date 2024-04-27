package widgets;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Slider {
    WidgetsSetup setup;
    WebDriver driver;
    Actions act;
    JavascriptExecutor js;
    WebDriverWait wait;
    Select selectObj;

    @BeforeClass
    public void setUp() {
        setup = new WidgetsSetup();
        driver = setup.settingWidgetsPage();
        act = new Actions(driver);
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        driver.findElement(By.xpath("//span[text()='Slider']")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(priority = 0)
    @Deprecated
    public void sliderTest() {
        WebElement slider = driver.findElement(By.className("range-slider--primary"));
        // Click on the slider handle to focus it
        act.moveToElement(slider).click().build().perform();

        // Use the arrow keys to adjust the value
        slider.sendKeys(Keys.ARROW_RIGHT);
        slider.sendKeys(Keys.ARROW_RIGHT);

        // release the mouse button
        act.release().build().perform();

        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }
}
