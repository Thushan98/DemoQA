package widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class DatePicker {
    WidgetsSetup setup;
    WebDriver driver;
    Actions act;
    JavascriptExecutor js;
    WebDriverWait wait;
    Select selectObj;

    @BeforeClass
    public void setUp() {
        setup = new WidgetsSetup();
        driver = setup.settingWidgetsPage();
        act = new Actions(driver);
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        driver.findElement(By.xpath("//span[text()='Date Picker']")).click();
        js.executeScript("window.scrollBy(0,250)", "");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test(priority = 0)
    public void dateTest() {
        WebElement selectedDate = driver.findElement(By.id("datePickerMonthYearInput"));
        selectedDate.click();
        selectedDate.clear();
        WebElement bCalendar = driver.findElement(By.className("react-datepicker-popper"));
        wait.until(ExpectedConditions.elementToBeClickable(bCalendar));

        WebElement months = driver.findElement(By.className("react-datepicker__month-select"));
        selectObj = new Select(months);
        selectObj.selectByValue("10");

        WebElement years = driver.findElement(By.className("react-datepicker__year-select"));
        selectObj = new Select(years);
        selectObj.selectByVisibleText("1998");

        WebElement dates = driver.findElement(By.cssSelector("[aria-label='Choose Wednesday, November 18th, 1998']"));
        dates.click();
    }

    @Test(priority = 1)
    public void timeTest() {
        WebElement dateField = driver.findElement(By.id("dateAndTimePickerInput"));
        dateField.click();
        dateField.clear();
        WebElement calendar = driver.findElement(By.className("react-datepicker"));
        wait.until(ExpectedConditions.elementToBeClickable(calendar));

        driver.findElement(By.className("react-datepicker__month-read-view")).click();
        WebElement months = driver.findElement(By.xpath("//div[text()='February']"));
        wait.until(ExpectedConditions.elementToBeClickable(months));
        months.click();

        driver.findElement(By.className("react-datepicker__year-read-view")).click();
        WebElement years = driver.findElement(By.xpath("//div[text()='2019']"));
        wait.until(ExpectedConditions.elementToBeClickable(years));
        years.click();

        WebElement dates = driver.findElement(By.cssSelector("[aria-label='Choose Tuesday, February 12th, 2019']"));
        dates.click();

        WebElement time = driver.findElement(By.xpath("//ul/li[text()='17:00']"));
        time.click();
    }
}
