package interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Sortable {
    InteractionSetup setup;
    WebDriver driver;
    Actions act;
    JavascriptExecutor js;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        setup = new InteractionSetup();
        driver = setup.settingInteractionsPage();
        act = new Actions(driver);
        js = (JavascriptExecutor) driver;
        driver.findElement(By.xpath("//span[text()='Sortable']")).click();
        js.executeScript("window.scrollBy(0,350)", "");
    }

    @Test
    public void sortTest() {
        List<WebElement> list = driver.findElements(By.xpath("//* [@id='demo-tabpane-list']/div/div"));

        for (int i = 1; i <= list.size(); i++) {

            WebElement element = driver.findElement(By.xpath("//*[@id='demo-tabpane-list']/div/div"));

            WebElement destination = driver.findElement(By.xpath("//*[@id='demo-tabpane-list']/div/div[" + (6 - i + 1) + "]"));

            act.dragAndDrop(element, destination).perform();
        }
    }
}
