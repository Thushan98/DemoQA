package widgets;

import alerts.AlertSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AccordianWidgetTest {
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
        driver.findElement(By.xpath("//span[text()='Accordian']")).click();

        js.executeScript("window.scrollBy(0,250)", "");
    }

    @Test
    public void accordianTest() {
        WebElement section1 = driver.findElement(By.id("section1Heading"));
        section1.click();
        System.out.println(driver.findElement(By.id("section1Content")).isDisplayed() ? "Content has" : "false");

        driver.findElement(By.id("section2Heading")).click();
    }
}
