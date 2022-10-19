package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import utils.logs.Log;

import java.lang.reflect.Method;

import static utils.extentreports.ExtentTestManager.startTest;

public class InventoryTests extends BaseTest{

    InventoryPage inventoryPage;
    LoginPage loginPage;

    @BeforeMethod
    public void classLevelUp(){
        intialization();
        Log.info("Tests is starting!");
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
    }


    @AfterMethod
    public void closedClass(){
        Log.info("Tests are ending!");
        tearDown();
    }

    @Test
    public void addToCartTest(Method method){
        startTest(method.getName(), "Login Scenario with valid username and valid password.");
        loginPage.inputUsernamePassword("standard_user","secret_sauce");
        loginPage.verifyLoginSuccessfully(true, "PRODUCTS");
        inventoryPage.addToCartProduct();
        inventoryPage.verifyTotalProductInCart(true, "2");

    }



}
