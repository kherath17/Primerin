package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class basePage {
    public static WebDriver driver;

    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }


    public static void tearDown(){
        driver.quit();
    }
}
