package daspratick.com.selenium1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

public class Selenium3 {


    @Test
    public void booking_test() {


        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            // Open MakeMyTrip
            driver.get("https://www.makemytrip.com/");

            // Close login popup if present
            Actions actions = new Actions(driver);
            actions.moveByOffset(10, 10).click().build().perform();

            // Click on the "From" input field
            WebElement fromInput = driver.findElement(By.xpath("//label[@for='fromCity']"));
            fromInput.click();

            // Type and select New Delhi
            WebElement fromSearchBox = driver.findElement(By.xpath("//input[@placeholder='From']"));
            fromSearchBox.sendKeys("New Delhi");

            WebElement delhiOption = driver.findElement(By.xpath("//p[contains(text(),'New Delhi, India')]"));
            delhiOption.click();

            // Type and select Hyderabad
            WebElement toSearchBox = driver.findElement(By.xpath("//input[@placeholder='To']"));
            toSearchBox.sendKeys("Hyderabad");

            WebElement hyderabadOption = driver.findElement(By.xpath("//p[contains(text(),'Hyderabad, India')]"));
            hyderabadOption.click();

            // Wait a bit for date picker and click Search
            WebElement searchButton = driver.findElement(By.xpath("//a[text()='Search']"));
            searchButton.click();

            // Optional: Wait to observe results
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit(); // Close the browser


        }
    }
}
