package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage {

    String baseURL = "https://www.saucedemo.com/";
    By userNameId = By.id("user-name");
    By passwordId = By.id("password");
    By loginBtnId = By.id("login-button");

    By title = By.xpath("//span[starts-with(text(), \"Products\")]");

    By errorMessageLockedOut = By.xpath("//h3[starts-with(text(), \"Epic sadface: Sorry, this user has been locked out.\")]");

    By imgProblemId = By.xpath("//a[@id = \"item_4_img_link\"]//img");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage getUrl() {
        driver.get(baseURL);
        return this;
    }


    public LoginPage inputUsernamePassword(String username, String passowrd) {
        inputText(userNameId, username);
        inputText(passwordId, passowrd);
        click(loginBtnId);
        return this;
    }

    public LoginPage verifyLoginSuccessfully(Boolean expected1, String expected2) {
        waitElement(title);
        Assert.assertEquals(isDisplayed(title), expected1);
        Assert.assertEquals(getText(title), expected2);
        return this;
    }

    public LoginPage verifyErrorMessageLockedOut(Boolean expected1, String expected2) {
        waitElement(errorMessageLockedOut);
        Assert.assertEquals(isDisplayed(errorMessageLockedOut), expected1);
        Assert.assertEquals(getText(errorMessageLockedOut), expected2);
        return this;
    }

    public LoginPage verifyProblemUserLogin(Boolean expected) {
        waitElement(imgProblemId);
        Assert.assertEquals(isDisplayed(imgProblemId), expected);
        return this;
    }



}
