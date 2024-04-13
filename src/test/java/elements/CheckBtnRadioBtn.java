package elements;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CheckBtnRadioBtn {
    ElementsSetup setup = new ElementsSetup();
    WebDriver driver = setup.settingPage();
    JavascriptExecutor js = (JavascriptExecutor) driver;

    @Test(priority = 0)
    @Deprecated
    public void testCheckBoxes() {
        WebElement checkBoxText = driver.findElement(By.id("item-1"));
        checkBoxText.click();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        WebElement expandButton = driver.findElement(By.xpath("//button[@title='Expand all']"));
        expandButton.click();

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

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //goto radio button page
        driver.navigate().back();
        //testRadioBtn();
    }

    @Test(priority = 1)
    public void testRadioBtn() {
        WebElement radioBtn = driver.findElement(By.id("item-2"));
        radioBtn.click();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        js.executeScript("window.scrollBy(0,400)", "");
        WebElement fisrtRadio = driver.findElement(By.cssSelector("label[for='yesRadio']"));
        fisrtRadio.click();

        WebElement secondRadio = driver.findElement(By.cssSelector("label[for='impressiveRadio']"));
        secondRadio.click();


        WebElement thirdRadio = driver.findElement(By.cssSelector("label[for='noRadio']"));
        if(thirdRadio.isEnabled()) {
            System.out.println("cannot click");
        }
//        thirdRadio.click();
    }
}
