package alerts;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Windows {
    AlertSetup setup;
    WebDriver driver;
    Actions act;
    JavascriptExecutor js;
    String originalWindow;
    Set<String> windowHandles;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        setup = new AlertSetup();
        driver = setup.settingAlertPage();
        act = new Actions(driver);
        js = (JavascriptExecutor) driver;

        driver.findElement(By.xpath("//span[text()='Browser Windows']")).click();

        js.executeScript("window.scrollBy(0,250)", "");

    }

    @Test(priority = 0)
    @Deprecated
    public void testNewTab() {


        WebElement newTabBtn = driver.findElement(By.id("tabButton"));
        newTabBtn.click();
        originalWindow = driver.getWindowHandle();
        windowHandles = driver.getWindowHandles();

        // Switch to the new tab
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
        }

        // Get the displayed text from the new tab
        String displayedText = driver.findElement(By.tagName("body")).getText();
        System.out.println("Displayed Text on the new tab: " + displayedText);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Close the new tab
        //driver.close();

        driver.switchTo().window(originalWindow);

        //driver.navigate().back();

    }

    @Test(priority = 1)
    @Deprecated
    public void testNewWindow() {
        originalWindow = driver.getWindowHandle();
        windowHandles = driver.getWindowHandles();
        driver.findElement(By.id("windowButton")).click();

        // Wait for the new window to open
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.numberOfWindowsToBe(windowHandles.size() + 1));

        for (String windowHandle : windowHandles) {
            if(!windowHandle.equals(originalWindow)){
                driver.switchTo().window(windowHandle);
                System.out.println("Switched to new window");

                // Print the text from the body of the new window
                String bodyText = driver.findElement(By.tagName("body")).getText();
                System.out.println("Body Text: " + bodyText);

                // Close the new window and switch back to the original window
                driver.close();
                driver.switchTo().window(originalWindow);
                break;
            }
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test(priority = 2)
    @Deprecated
    public void testNewWindowMessage() {
        driver.findElement(By.id("messageWindowButton")).click();
        originalWindow = driver.getWindowHandle();
        windowHandles = driver.getWindowHandles();
        //Set<String> windowHandles = driver.getWindowHandles();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        System.out.println("size: "+windowHandles.size());
        for (String windowHandle : windowHandles) {
            if (windowHandles.size() == 2) {
                driver.switchTo().window(windowHandle);
                WebElement windowText = driver.findElement(By.tagName("body"));
                wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
                System.out.println(windowText.getText());
                System.out.println("------------------------");
            }
        }

    }

}
