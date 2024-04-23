package alerts;

import alerts.AlertSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

public class Windows {
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
    }

    @Test
    public void windowsTest() {
        driver.findElement(By.xpath("//span[text()='Browser Windows']")).click();

        js.executeScript("window.scrollBy(0,250)", "");

        WebElement newTabBtn = driver.findElement(By.id("tabButton"));
        newTabBtn.click();

        Set<String> windowHandles = driver.getWindowHandles();

        // Switch to the new tab
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
        }

        // Get the displayed text from the new tab
        String displayedText = driver.findElement(By.tagName("body")).getText();
        System.out.println("Displayed Text on the new tab: " + displayedText);

        // Close the new tab
        driver.close();


        driver.navigate().back();


    }
}
