package interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Resizable {
    InteractionSetup setup;
    WebDriver driver;
    Actions act;
    JavascriptExecutor js;

    @BeforeClass
    public void setUp() {
        setup = new InteractionSetup();
        driver = setup.settingInteractionsPage();
        act = new Actions(driver);
        js = (JavascriptExecutor) driver;
        driver.findElement(By.xpath("//span[text()='Resizable']")).click();
        js.executeScript("window.scrollBy(0,350)", "");
    }

    @Test
    public void sortTest() {
        WebElement resizer = driver.findElement(By.xpath("//*[@id='resizableBoxWithRestriction']/span"));
        act.clickAndHold(resizer).moveByOffset(500, 300).release().build().perform();
    }
}
