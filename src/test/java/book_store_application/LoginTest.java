package book_store_application;

import interactions.InteractionSetup;
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
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    AppSetup setup;
    WebDriver driver;
    Actions act;
    JavascriptExecutor js;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        setup = new AppSetup();
        driver = setup.settingAppPage();
        act = new Actions(driver);
        js = (JavascriptExecutor) driver;
        driver.findElement(By.xpath("//span[text()='Login']")).click();
        js.executeScript("window.scrollBy(0,350)", "");
        wait = new WebDriverWait(driver, Duration.ofSeconds(12));
    }

    @Test(priority = 0)
    @Deprecated
    public void newUserCreateTest() {
        driver.findElement(By.id("newUser")).click();

        //register
        driver.findElement(By.id("firstname")).sendKeys("Thushan");
        driver.findElement(By.id("lastname")).sendKeys("Dana");
        driver.findElement(By.id("userName")).sendKeys("thushan@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Thusha@123");

        WebElement captcha = driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"));
        wait.until(ExpectedConditions.elementToBeClickable(captcha));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.switchTo().frame(captcha);
        WebElement captchaSpan = driver.findElement(By.id("recaptcha-anchor"));
        captchaSpan.click();

        String ariaCheckedValue = captchaSpan.getAttribute("aria-checked");
        wait.until(ExpectedConditions.attributeToBe(captchaSpan, "aria-checked", "true"));
        driver.switchTo().defaultContent();

        driver.findElement(By.id("register")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        driver.findElement(By.id("gotologin")).click();

    }

    @Test(priority = 1)
    public void loginTesting() {
        driver.findElement(By.id("userName")).sendKeys("thushan@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Thushan@123");
        driver.findElement(By.id("login")).click();
    }

    @Test(priority = 2)
    public void testProfileAndStore() {
        driver.findElement(By.id("gotoStore")).click();
        WebElement noData = driver.findElement(By.xpath("//*[text()='No rows found']"));
        WebElement gotoStore = driver.findElement(By.id("gotoStore"));
        if(noData.isDisplayed()) {
            gotoStore.click();
        }

        WebElement dataTable = driver.findElement(By.className("rt-table"));
        wait.until(ExpectedConditions.visibilityOf(dataTable));

        driver.findElement(By.id("searchBox")).sendKeys("Git");

        List<WebElement> links = driver.findElements(By.tagName("a"));
        int javaLinksCount = 0;

        for (WebElement link : links) {
            if (link.getText().toLowerCase().contains("java")) {
                javaLinksCount++;
            }
        }
        System.out.println("no of results: "+ javaLinksCount);
    }
}
