package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class ButtonTest {
    ElementsSetup setup;
    WebDriver driver;
    Actions act;

    @BeforeClass
    public void setUp() {
        setup = new ElementsSetup();
        driver = setup.settingPage();
        act = new Actions(driver);
    }

    @Test
    public void testButton() {
        WebElement webTable = driver.findElement(By.id("item-4"));
        webTable.click();

        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
        act.doubleClick(doubleClickBtn).perform();

        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        act.contextClick(rightClickBtn).perform();

        WebElement DBrLT = driver.findElement(By.id("DBrLT"));
        DBrLT.click();
    }
}
