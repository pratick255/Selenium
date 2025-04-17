package daspratick.com.selenium1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//public class selenium5 {


    public class selenium5 {
        public static void main(String[] args) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");

            WebDriver driver = new ChromeDriver(options);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            Actions actions = new Actions(driver);

            try {
                // Step 1: Open MakeMyTrip
                driver.get("https://www.makemytrip.com/");

                // Step 2: Dismiss login popup by clicking somewhere on screen
                actions.moveByOffset(10, 10).click().perform();

                // Step 3: Click From label and enter New Delhi
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='fromCity']"))).click();
                WebElement fromInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='From']")));
                fromInput.sendKeys("New Delhi");
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'New Delhi, India')]"))).click();

                // Step 4: Click To label FIRST (very important)
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='toCity']"))).click();

                // Step 5: Then enter Hyderabad
                WebElement toInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='To']")));
                toInput.sendKeys("Hyderabad");

                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Hyderabad, India')]"))).click();

                // Step 6: Click on Search button
                WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Search']")));
                searchBtn.click();

                Thread.sleep(5000);  // Wait to see result page
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                driver.quit();  // Close the browser
            }
        }
    }



