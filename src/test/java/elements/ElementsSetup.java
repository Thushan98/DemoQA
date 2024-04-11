package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import setup.SetupProject;

public class ElementsSetup {
    SetupProject setup = new SetupProject();
    WebDriver driver = setup.settingDriver();

    @BeforeTest
    public WebDriver settingPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        WebElement elementText = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementText.click();
        return driver;
    }
}
