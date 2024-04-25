package alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class AlertBoxes {
    AlertSetup setup;
    WebDriver driver;
    Actions act;
    JavascriptExecutor js;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        setup = new AlertSetup();
        driver = setup.settingAlertPage();
        act = new Actions(driver);
        js = (JavascriptExecutor) driver;
        driver.findElement(By.xpath("//span[text()='Alerts']")).click();
        js.executeScript("window.scrollBy(0,250)", "");
    }

    @Test(priority = 0)
    @Deprecated
    public void testAlerts1() {
        driver.findElement(By.id("alertButton")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(8));

        System.out.println(driver.switchTo().alert().getText());

        //acccept
        driver.switchTo().alert().accept();

        //dismiss
        //driver.switchTo().alert().dismiss();
    }

    @Test(priority = 1)
    public void testAlerts2() {
        driver.findElement(By.id("confirmButton")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(8));

        System.out.println(driver.switchTo().alert().getText());

        //acccept
        driver.switchTo().alert().accept();

        //dismiss
        //driver.switchTo().alert().dismiss();
    }

    @Test(priority = 2)
    public void testAlerts3() {
        driver.findElement(By.id("promtButton")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(8));

        driver.switchTo().alert().sendKeys("thushan");

        //acccept
        driver.switchTo().alert().accept();

        //dismiss
        //driver.switchTo().alert().dismiss();
    }
}
