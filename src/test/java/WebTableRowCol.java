import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableRowCol {

    static WebDriver driver;

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();


        driver.get("https://www.w3schools.com/html/html_tables.asp");

        int row = driver.findElements(By.xpath("//table[@id = \"customers\"]//tr")).size();
        int column = driver.findElements(By.xpath("//table[@id = \"customers\"]//th")).size();

        for (int i = 1; i <= row; i++){
                String value = driver.findElement(By.xpath("//table[@id ='customers']/tbody/tr["+(i+1)+"]/td[2]")).getText();
                System.out.println(value);

                if (value.equals("Giovanni Rovelli")){
                    break;
                }
        }




    }
}
