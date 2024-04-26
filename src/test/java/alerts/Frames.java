package alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class Frames {
    AlertSetup setup;
    WebDriver driver;
    Actions act;
    JavascriptExecutor js;

    @BeforeClass
    public void setUp() {
        setup = new AlertSetup();
        driver = setup.settingAlertPage();
        act = new Actions(driver);
        js = (JavascriptExecutor) driver;

        driver.findElement(By.xpath("//span[text()='Frames']")).click();

        js.executeScript("window.scrollBy(0,250)", "");
    }

    @Test(priority = 0)
    @Deprecated
    public void testNewTab() {
        WebElement iframe = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(iframe);

        System.out.println(driver.findElement(By.tagName("h1")).getText());

        driver.switchTo().defaultContent();
        List<WebElement> f = driver.findElements(By.tagName("iframe"));
        System.out.println("no of iframes: "+f.size());
    }
}
