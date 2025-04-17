package daspratick.com.selenium1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class selenium2 {

    @Test
    public void test(){

        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.makemytrip.com/");
        String title = driver.getTitle();
        String expectedTitle = "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday";
        Assert.assertEquals(title, expectedTitle);

        driver.quit(); // optional, to close the browser

    }




}
