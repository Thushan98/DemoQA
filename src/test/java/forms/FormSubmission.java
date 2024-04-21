package forms;

import elements.ElementsSetup;
import net.bytebuddy.implementation.bind.annotation.DefaultCall;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import setup.SetupProject;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FormSubmission {
    SetupProject setup = new SetupProject();
    WebDriver driver = setup.settingDriver();
    JavascriptExecutor js;
    WebDriverWait wait;
    Select selectObj;

    Actions actions;

    @BeforeTest
    public void setUp() {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        WebElement formSection = driver.findElement(By.xpath("//h5[text()='Forms']"));
        formSection.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    public void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll the page to the element's location
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @Test
    @Deprecated
    public void formSubmit() {

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement practiceForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Practice Form']")));
        System.out.println(practiceForm.isDisplayed());

        practiceForm.click();

        scrollToElement(driver, practiceForm);
        //form submittion

        driver.findElement(By.id("firstName")).sendKeys("Thushan");
        driver.findElement(By.id("lastName")).sendKeys("Dana");
        driver.findElement(By.id("userEmail")).sendKeys("thushan@gmail.com");
        WebElement gender = driver.findElement(By.id("gender-radio-1"));

        actions.moveToElement(gender).click().perform();
        driver.findElement(By.id("userNumber")).sendKeys("thushan");

        WebElement birthdays = driver.findElement(By.id("dateOfBirthInput"));
        birthdays.clear();
        WebElement birthdayCalendar = driver.findElement(By.className("react-datepicker-popper"));
        wait.until(ExpectedConditions.elementToBeClickable(birthdayCalendar));

        WebElement months = driver.findElement(By.className("react-datepicker__month-select"));
        selectObj = new Select(months);
        selectObj.selectByValue("10");

        WebElement years = driver.findElement(By.className("react-datepicker__year-select"));
        selectObj = new Select(years);
        selectObj.selectByVisibleText("1998");

        WebElement dates = driver.findElement(By.cssSelector("[aria-label='Choose Wednesday, November 18th, 1998']"));
        dates.click();

        WebElement subjectSelect = driver.findElement(By.id("subjectsContainer"));
        subjectSelect.click();
        WebElement subj = driver.findElement(By.id("subjectsInput"));
        subj.sendKeys("cc");
        subj.sendKeys(Keys.DOWN);
        subj.sendKeys(Keys.ENTER);

        subj.sendKeys("m");
        for (int i = 0; i < 2; i++) {
            subj.sendKeys(Keys.DOWN);
        }
        subj.sendKeys(Keys.ENTER);
        WebElement body = driver.findElement(By.tagName("body"));
        body.click();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

        WebElement hobby1 = driver.findElement(By.id("hobbies-checkbox-1"));
        scrollToElement(driver, subjectSelect);
        actions.moveToElement(hobby1).click().perform();
        WebElement hobby2 = driver.findElement(By.id("hobbies-checkbox-3"));
        actions.moveToElement(hobby2).click().perform();

        File uploadFile = new File("src/test/resources/sampleFile.jpeg");
        WebElement uploadButton = driver.findElement(By.id("uploadPicture"));
        scrollToElement(driver, uploadButton);
        uploadButton.sendKeys(uploadFile.getAbsolutePath());

        driver.findElement(By.id("currentAddress")).sendKeys("No.235/D, Koongha, Gmpaha");

        //body.click();


        WebElement stateSelect = driver.findElement(By.xpath("//div[contains(text(), \"Select State\")]"));
        scrollToElement(driver, stateSelect);
        System.out.println("state: " + stateSelect.isDisplayed());
        //stateSelect.click();
        //stateSelect.sendKeys("c");
        //stateSelect.sendKeys(Keys.DOWN);
//        WebElement dropdown = driver.findElement(By.className("css-2613qy-menu"));
//        wait.until(ExpectedConditions.elementToBeClickable(dropdown));
        //stateSelect.sendKeys(Keys.ENTER);

        WebElement citySelect = driver.findElement(By.id("city"));
//        citySelect.click();
//        citySelect.sendKeys(Keys.DOWN);
//        citySelect.sendKeys(Keys.ENTER);

        driver.findElement(By.id("submit")).click();

    }
}

