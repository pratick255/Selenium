package daspratick.com.selenium1;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.Assert;

public class seleniumtest1 {
    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.makemytrip.com/");
        String title = driver.getTitle();
        String expectedTitle = "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday";
        Assert.assertEquals(title, expectedTitle);

        driver.quit(); // optional, to close the browser


    }
}