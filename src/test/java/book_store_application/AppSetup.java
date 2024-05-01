package book_store_application;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import setup.SetupProject;

public class AppSetup {
    SetupProject setup = new SetupProject();
    WebDriver driver = setup.settingDriver();

    public void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll the page to the element's location
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @BeforeTest
    public WebDriver settingAppPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement elementText = driver.findElement(By.xpath("//h5[text()='Book Store Application']"));
        scrollToElement(driver,elementText);
        elementText.click();
        return driver;
    }
}
