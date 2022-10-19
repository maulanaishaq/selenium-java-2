package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseTest {

    public WebDriver driver;
    String baseURL = "https://www.saucedemo.com/";


    public WebDriver getDriver(){
        return driver;
    }

    public void intialization(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    public void tearDown(){
        driver.quit();
    }

}
