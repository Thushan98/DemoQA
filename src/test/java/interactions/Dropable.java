package interactions;

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

public class Dropable {
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
        driver.findElement(By.xpath("//span[text()='Droppable']")).click();
        js.executeScript("window.scrollBy(0,350)", "");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(priority = 0)
    public void droppableTesting() {
        WebElement dragEdElement = driver.findElement(By.id("draggable"));
        WebElement droppedElement = driver.findElement(By.id("droppable"));

        act.dragAndDrop(dragEdElement, droppedElement).build().perform();

        if(droppedElement.getText().equals("Dropped!")) {
            System.out.println("Drag and drop done");
        } else {
            System.out.println("not completed");
        }
    }

    @Test(priority = 1)
    public void dropAcceptableTesting() {
        driver.findElement(By.id("droppableExample-tab-accept")).click();

        WebElement acceptableElement = driver.findElement(By.id("acceptable"));
        WebElement notAcceptableElement = driver.findElement(By.id("notAcceptable"));
        WebElement droppedElement = driver.findElement(By.id("droppable"));

        wait.until(ExpectedConditions.elementToBeClickable(acceptableElement));
        act.dragAndDrop(acceptableElement, droppedElement).build().perform();

        if(droppedElement.getText().equals("Dropped!")) {
            System.out.println("Drag and drop acceptable");
        } else {
            System.out.println("not acceptable");
        }
    }
}
