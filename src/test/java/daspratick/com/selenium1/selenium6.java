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

//public class selenium6 {


    public class selenium6 {
        public static void main(String[] args) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");

            WebDriver driver = new ChromeDriver(options);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            Actions actions = new Actions(driver);

            try {
                // Open MakeMyTrip
                driver.get("https://www.makemytrip.com/");
                actions.moveByOffset(10, 10).click().perform(); // dismiss login popup

                // From: New Delhi
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='fromCity']"))).click();
                WebElement fromInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='From']")));
                fromInput.sendKeys("New Delhi");
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'New Delhi, India')]"))).click();

                // To: Hyderabad
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='toCity']"))).click();
                WebElement toInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='To']")));
                toInput.sendKeys("Hyderabad");
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Hyderabad, India')]"))).click();

                // Departure Date: 20 April
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Departure']"))).click();

                // Navigate calendar to April if not already there
                // NOTE: Make sure current month is not past April
                // Otherwise, loop with "Next" arrow to find month
                WebElement aprilDate = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@aria-label='Sun Apr 20 2025']")));
                aprilDate.click();

                // Click Search
                WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Search']")));
                searchBtn.click();

                Thread.sleep(5000); // observe result

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                driver.quit();
            }
        }
    }

