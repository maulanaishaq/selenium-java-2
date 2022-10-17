package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;


    public BasePage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement waitElement(By by){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void inputText(By by, String text){
        waitElement(by).sendKeys(text);
    }

    public void click(By by){
        waitElement(by).click();
    }


    public Boolean isDisplayed(By by){
        boolean result = waitElement(by).isDisplayed();
        return true;
    }

    public String getText(By by){
        return waitElement(by).getText();
    }


}
