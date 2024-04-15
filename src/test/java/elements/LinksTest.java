package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.net.HttpURLConnection;
import java.net.URL;

public class LinksTest {
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
    public void testLink() {
        WebElement testLinkSection = driver.findElement(By.id("item-5"));
        testLinkSection.click();

        js.executeScript("window.scrollBy(0,250)", "");

        WebElement simpleLink = driver.findElement(By.id("simpleLink"));
        simpleLink.click();

        WebElement brokenLink = driver.findElement(By.id("created"));
        brokenLink.click();


        wait = new WebDriverWait(driver, Duration.ofSeconds(8));

        driver.navigate().back();
        WebElement testBrokenLinkSection = driver.findElement(By.id("item-6"));
        testBrokenLinkSection.click();


        WebElement divElement = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]"));
        List<WebElement> links = divElement.findElements(By.tagName("a"));
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            String image = link.getAttribute("src");
            verifyLinks(url);
        }

        List<WebElement> imgs = divElement.findElements(By.tagName("img"));
        for (WebElement imgSrc : imgs) {
            String image = imgSrc.getAttribute("src");
            verifyLinks(image);
        }
    }

    public static void verifyLinks(String linkUrl)
    {
        try
        {
            URL url = new URL(linkUrl);

            //Now we will be creating url connection and getting the response code
            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
            httpURLConnect.setConnectTimeout(5000);
            httpURLConnect.connect();
            if(httpURLConnect.getResponseCode()>=400)
            {
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage()+"is a broken link");
            }

            //Fetching and Printing the response code obtained
            else{
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
            }
        }catch (Exception e) {
        }
    }
}
