package pages;

import base.basePage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;


public class landingPage extends basePage {
    String price1,price2,price3;
    By searchArea = By.xpath("//input[@placeholder='Enter place, postcode or hotel']");
    By btnSearch = By.xpath("//button[@id='search-console__form-button']");

    WebDriver driver = basePage.driver;

    public String navUrl()  {


        driver.get("https://www.premierinn.com/gb/en/home.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        if(driver.findElement(By.xpath("//button[@id='accept-all-cookies-button']")).isDisplayed()){
            driver.findElement(By.xpath("//button[@id='accept-all-cookies-button']")).click();
        }else
        {

        }
        driver.manage().window().maximize();
        String pageTitle = driver.getTitle();
        return pageTitle;
    }


/*
    public String searchHotel(String Location) throws InterruptedException {
        driver.findElement(searchArea).sendKeys(Location);
        driver.findElement(btnSearch).click();

        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='search-summary__location']"))));
        String searchTitle = driver.findElement(By.xpath("//div[@class='search-summary__location']")).getText();
        return searchTitle;
    }

 */
public void searchHotel(String Location1,String Location2,String Location3) throws InterruptedException {
//Passing first Location
    driver.findElement(searchArea).sendKeys(Location1);
    driver.findElement(btnSearch).click();

    Thread.sleep(5000);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='search-summary__location']"))));

    driver.findElement(By.xpath("(//cta-button[@type='button'])[1]")).click();

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));

    price1=driver.findElement(By.xpath("//label[@class='rate-tile rate-tile--selected']/p")).getText();

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//    System.out.println(price1);

//Passing second Location
    driver.get("https://www.premierinn.com/gb/en/home.html");

    driver.findElement(searchArea).sendKeys(Location2);
    driver.findElement(btnSearch).click();

    Thread.sleep(5000);
    WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(60));
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='search-summary__location']"))));

    driver.findElement(By.xpath("(//cta-button[@type='button'])[1]")).click();

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));

    price2=driver.findElement(By.xpath("//label[@class='rate-tile rate-tile--selected']/p")).getText();

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//    System.out.println(price2);

//Passing third Location
    driver.get("https://www.premierinn.com/gb/en/home.html");

    driver.findElement(searchArea).sendKeys(Location3);
    driver.findElement(btnSearch).click();

    Thread.sleep(5000);
    WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(60));
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='search-summary__location']"))));

    driver.findElement(By.xpath("(//cta-button[@type='button'])[1]")).click();

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));

    price3=driver.findElement(By.xpath("//label[@class='rate-tile rate-tile--selected']/p")).getText();

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
  //  System.out.println(price3);
}

public void comparePrice(String Location1,String Location2,String Location3) throws InterruptedException {
    //System.out.println("Prices are "+price1+" "+price2+" "+price3);
    String price1m = price1.replace("£","");
    float num1 = Float.parseFloat(price1m);
    String price2m = price2.replace("£","");
    float num2 = Float.parseFloat(price2m);
    String price3m = price3.replace("£","");
    float num3 = Float.parseFloat(price3m);
    //System.out.println("Conv num "+num2);

    HashMap<Float,String> hp = new HashMap();
    hp.put(num1,"London");
    hp.put(num2,"Manchester");
    hp.put(num3,"Leeds");

    float ar[] = {num1,num2,num3};

    float temp=0;
    for(int i=0;i<=ar.length-1;i++) {
        for (int j = i+1; j <= ar.length-1; j++) {
            if (ar[i] >ar[j]){
                temp=ar[i];
                ar[i]=ar[j];
                ar[j]=temp;

            }
        }

    }
    //System.out.println("Lowest Fare "+ar[0]);

    System.out.println("City is "+hp.get(ar[0]));

    if(hp.get(ar[0])=="London"){
        driver.get("https://www.premierinn.com/gb/en/home.html");
        driver.findElement(searchArea).sendKeys(Location1);
        driver.findElement(btnSearch).click();

        Thread.sleep(5000);
        /*
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='search-summary__location']"))));

        driver.findElement(By.xpath("(//cta-button[@type='button'])[1]")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));

        price1=driver.findElement(By.xpath("//label[@class='rate-tile rate-tile--selected']/p")).getText();

         */

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        String place1 = driver.findElement(By.xpath("(//li[@data-test-id='hotel-wrapper']//hotel-name)[1]")).getText();
        System.out.println("Name of the Hotel with lowest price is "+place1);


    }else if(hp.get(ar[0])=="Manchester"){
        driver.get("https://www.premierinn.com/gb/en/home.html");
        driver.findElement(searchArea).sendKeys(Location2);
        driver.findElement(btnSearch).click();

        Thread.sleep(5000);
        /*
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='search-summary__location']"))));

        driver.findElement(By.xpath("(//cta-button[@type='button'])[1]")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));

        price1=driver.findElement(By.xpath("//label[@class='rate-tile rate-tile--selected']/p")).getText();

         */

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        String place2 = driver.findElement(By.xpath("(//li[@data-test-id='hotel-wrapper']//hotel-name)[1]")).getText();
        System.out.println("Name of the Hotel with lowest price is "+place2);
    }else{
        driver.get("https://www.premierinn.com/gb/en/home.html");
        driver.findElement(searchArea).sendKeys(Location3);
        driver.findElement(btnSearch).click();

        Thread.sleep(5000);
        /*
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='search-summary__location']"))));

        driver.findElement(By.xpath("(//cta-button[@type='button'])[1]")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));

        price1=driver.findElement(By.xpath("//label[@class='rate-tile rate-tile--selected']/p")).getText();

         */

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        String place3 = driver.findElement(By.xpath("(//li[@data-test-id='hotel-wrapper']//hotel-name)[1]")).getText();
        System.out.println("Name of the Hotel with lowest price is "+place3);
    }
}

}
