package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebTables {
    ElementsSetup setup;
    WebDriver driver;
    JavascriptExecutor js;
    WebDriverWait wait;
    WebElement submitButton;

    @BeforeClass
    public void setUp() {
        setup = new ElementsSetup();
        driver = setup.settingPage();
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(8));
    }

    @Test(priority = 0)
    public void gotoPage() {
        WebElement webTable = driver.findElement(By.id("item-3"));
        webTable.click();
    }
    @Test(priority = 1)
    @Deprecated
    public void addStudent() {
        WebElement addButton = driver.findElement(By.id("addNewRecordButton"));
        addButton.click();

        WebElement modalContainer = driver.findElement(By.className("modal-dialog"));
        wait.until(ExpectedConditions.visibilityOf(modalContainer));

        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Thushan");

        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Dananjana");

        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys("thushan@gmail.com");

        WebElement age = driver.findElement(By.id("age"));
        age.sendKeys("26");

        WebElement salary = driver.findElement(By.id("salary"));
        salary.sendKeys("5000");

        WebElement department = driver.findElement(By.id("department"));
        department.sendKeys("HR");

        submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        js.executeScript("window.scrollBy(0,450)", "");
    }

    @Test(priority = 2)
    public void editDetails() {
        WebElement editNewlyAddedRecord = driver.findElement(By.id("edit-record-4"));
        wait.until(ExpectedConditions.visibilityOf(editNewlyAddedRecord));
        editNewlyAddedRecord.click();

        WebElement newSalary = driver.findElement(By.id("salary"));
        newSalary.clear();
        newSalary.sendKeys("25000");
        submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        js.executeScript("window.scrollBy(0,450)", "");
    }

    @Test(priority = 3)
    public void deleteData() {
        WebElement deleteIcon = driver.findElement(By.id("delete-record-4"));
        deleteIcon.click();
    }

    @Test(priority = 4)
    @Deprecated
    public void searchData() {
        WebElement searchBar = driver.findElement(By.id("searchBox"));
        searchBar.sendKeys("Ald");

        driver.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
        searchBar.clear();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
