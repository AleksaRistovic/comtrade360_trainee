package test.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class TestCase4 {

    @Test
    public void addManyItems() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\aristovic\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.xpath("//input[@id='login-button']"));

        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        login.click();

        WebElement addToCart = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        addToCart.click();
        WebElement shoppingCart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        shoppingCart.click();

        //We are expecting to find element
        boolean expectedElement = true;
        boolean actualElement;

        //Checking if there is an element we expect to be there and storing it as true or false so we can compare with expected result
        try {
            driver.findElement(By.xpath("//div[@class='cart_quantity_add']"));
            actualElement = true;
        } catch (NoSuchElementException e) {
            actualElement = false;
        }

        //Comparing actual with expected result
        Assert.assertEquals(actualElement, expectedElement);

        WebElement burgerBtn = driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        burgerBtn.click();
        WebElement logoutBtn = driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        logoutBtn.click();

    }
}
