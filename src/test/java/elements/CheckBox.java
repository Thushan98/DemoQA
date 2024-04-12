package elements;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CheckBox {
    ElementsSetup setup = new ElementsSetup();
    WebDriver driver = setup.settingPage();

    @Test
    @Deprecated
    public void testCheckBoxes() {
        WebElement checkBoxText = driver.findElement(By.id("item-1"));
        checkBoxText.click();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        WebElement expandButton = driver.findElement(By.xpath("//button[@title='Expand all']"));
        expandButton.click();
        System.out.println("clicked");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)", "");

        //driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("label[for='tree-node-desktop']")));

        //checkbox clicking
        WebElement desktopCheckbox = driver.findElement(By.cssSelector("label[for='tree-node-desktop']"));
        desktopCheckbox.click();

        WebElement angularCheckbox = driver.findElement(By.cssSelector("label[for='tree-node-angular']"));
        angularCheckbox.click();

        js.executeScript("window.scrollBy(0,550)", "");

        WebElement excelCheckbox = driver.findElement(By.cssSelector("label[for='tree-node-excelFile']"));
        excelCheckbox.click();
        js.executeScript("window.scrollBy(0,750)", "");
    }
}
