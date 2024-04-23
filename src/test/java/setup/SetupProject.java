package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class SetupProject {
    WebDriver driver;
    @BeforeTest
    public WebDriver settingDriver() {
        System.setProperty("webdriver.chrome.driver", "E:\\\\selenium\\\\chromedriver-win64\\\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        return driver;
    }
}
