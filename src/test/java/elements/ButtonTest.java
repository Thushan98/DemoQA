package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class ButtonTest {
    ElementsSetup setup;
    WebDriver driver;
    Actions act;
    JavascriptExecutor js;

    @BeforeClass
    public void setUp() {
        setup = new ElementsSetup();
        driver = setup.settingPage();
        act = new Actions(driver);
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void testButton() {
        WebElement webTable = driver.findElement(By.id("item-4"));
        webTable.click();

        js.executeScript("window.scrollBy(0,250)", "");

        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
        act.doubleClick(doubleClickBtn).perform();

        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        act.contextClick(rightClickBtn).perform();

        js.executeScript("window.scrollBy(0,500)", "");

        WebElement DBrLT = driver.findElement(By.xpath("//button[text()='Click Me']"));
        DBrLT.click();

        driver.quit();
    }
}
