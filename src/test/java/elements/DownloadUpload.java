package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DownloadUpload {
    ElementsSetup setup;
    WebDriver driver;
    JavascriptExecutor js;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        setup = new ElementsSetup();
        driver = setup.settingPage();
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void upload() {
        WebElement testUploadSection = driver.findElement(By.id("item-7"));
        testUploadSection.click();

        WebElement downloadButton = driver.findElement(By.id("downloadButton"));
        downloadButton.click();

        File uploadFile = new File("src/test/resources/sampleFile.jpeg");
        WebElement uploadButton = driver.findElement(By.id("uploadFile"));
        uploadButton.sendKeys(uploadFile.getAbsolutePath());

        String fileName = Paths.get(uploadFile.getAbsolutePath()).getFileName().toString();

        System.out.println("Uploaded file name: " + fileName);
        /*
        * WebElement fileNameDisplay = driver.findElement(By.id("uploadedFilePath"));
        * if(fileNameDisplay.isDisplayed()) {
        *   System.out.println("your file is uploaded");
        * }
        *
        * */
    }
}
