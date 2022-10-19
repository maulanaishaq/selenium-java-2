package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class InventoryPage extends BasePage {

    By btnAddToCartProduct1 = By.id("add-to-cart-sauce-labs-backpack");
    By btnAddTocartProduct2 = By.id("add-to-cart-sauce-labs-bike-light");
    By btnCart = By.className("shopping_cart_link");


    public InventoryPage(WebDriver driver){
        super(driver);
    }


    public InventoryPage addToCartProduct(){
        click(btnAddToCartProduct1);
        click(btnAddTocartProduct2);
        return this;
    }


    public InventoryPage verifyTotalProductInCart(Boolean expected1, String expected2){
        waitElement(btnCart);
        Assert.assertEquals(isDisplayed(btnCart), expected1);
        Assert.assertEquals(getText(btnCart), expected2);
        return this;
    }



}
