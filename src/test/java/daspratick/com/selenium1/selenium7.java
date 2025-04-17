package daspratick.com.selenium1;

import org.openqa.selenium.chrome.ChromeDriver;

public class selenium7 {
    public static void main(String[] args) {

            ChromeDriver driver = new ChromeDriver();

            driver.get("https://www.spicejet.com/");
            String title = driver.getTitle();
    }
}
