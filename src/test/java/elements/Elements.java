package elements;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import setup.SetupProject;

public class Elements {
    SetupProject setup = new SetupProject();
    WebDriver driver = setup.settingDriver();

    @BeforeTest
    public WebDriver settingPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        return driver;
    }
}
