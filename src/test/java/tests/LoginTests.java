package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.logs.Log;

import java.lang.reflect.Method;

import static utils.extentreports.ExtentTestManager.startTest;

public class LoginTests extends BaseTest {

    public LoginPage loginPage;


    @BeforeMethod
    public void classLevelUp(){
        intialization();
        Log.info("Tests is starting!");
        loginPage = new LoginPage(driver);
    }


    @AfterMethod
    public void closedClass(){
        Log.info("Tests are ending!");
        tearDown();
    }


    @Test
    public void validLoginTest_Successfully(Method method){
        startTest(method.getName(), "Login Scenario with valid username and valid password.");
        loginPage
                .inputUsernamePassword("standard_user", "secret_sauce")
                .verifyLoginSuccessfully(true, "Products");

    }


    @Test
    public void invalidLoginTest_LockedOut(Method method){
        startTest(method.getName(), "Login Scenario with invalid username and invalid password.");
        loginPage
                .inputUsernamePassword("locked_out_user", "secret_sauce")
                .verifyErrorMessageLockedOut(true, "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void validLoginTest_ProblemUser(Method method){
        startTest(method.getName(), "Login Scenario with invalid username and invalid password.");
        loginPage
                .inputUsernamePassword("problem_user", "secret_sauce")
                .verifyProblemUserLogin(true);
    }




}
