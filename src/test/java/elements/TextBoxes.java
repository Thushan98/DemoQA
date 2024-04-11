package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TextBoxes {
    Elements setup = new Elements();
    WebDriver driver = setup.settingPage();


    @Test
    public void testTextBoxes() {
        WebElement elementText = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementText.click();
    }
}
