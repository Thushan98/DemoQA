package alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class ModalTesting {
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
        js.executeScript("window.scrollBy(0,250)", "");
        driver.findElement(By.xpath("//span[text()='Modal Dialogs']")).click();

        js.executeScript("window.scrollBy(0,250)", "");
    }

    @Test
    public void testModal() {
        WebElement smallModalButton = driver.findElement(By.id("showSmallModal"));
        smallModalButton.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-content")));

        WebElement modalContentBody = driver.findElement(By.xpath(".//div[@class='modal-body']"));

        System.out.println(modalContentBody.getText());

        WebElement closeButton = driver.findElement(By.id("closeSmallModal"));
        closeButton.click();
    }
}
