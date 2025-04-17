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

public class selenium4 {
    public static void main(String[] args) {


        // Set up ChromeOptions to avoid popup or automation detection
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        Actions actions = new Actions(driver);

        try {
            // Open MakeMyTrip
            driver.get("https://www.makemytrip.com/");

            // Dismiss the login modal by clicking somewhere
            actions.moveByOffset(10, 10).click().perform();

            // Click on From field and type New Delhi
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='fromCity']"))).click();
            WebElement fromInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='From']")));
            fromInput.sendKeys("New Delhi");
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'New Delhi, India')]"))).click();

            // Type Hyderabad in To field
            WebElement toInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='To']")));
            toInput.clear();  // Optional: clear any prefilled text
            toInput.sendKeys("Hyderabad");
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Hyderabad, India')]"))).click();

            // Click on Search
            WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Search']")));
            searchButton.click();

            // Wait for a few seconds to observe results
            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit(); // Close browser after execution
        }
    }
}



