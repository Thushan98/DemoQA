package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TextBoxes {
    ElementsSetup setup = new ElementsSetup();
    WebDriver driver = setup.settingPage();


    @Test
    @Deprecated
    public void testTextBoxes() {
        WebElement textBoxText = driver.findElement(By.id("item-0"));
        textBoxText.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");

        WebElement userName = driver.findElement(By.id("userName"));
        userName.sendKeys("thushanLogan");

        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("thushan@gmail.com");

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("No.70/A, BoxOffice Road, Daka");

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("same as above");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        js.executeScript("window.scrollBy(0,750)", "");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.quit();
    }
}
