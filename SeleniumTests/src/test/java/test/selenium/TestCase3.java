package test.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class TestCase3 {

    //Checking what happened when you checkout order without any item
    @Test
    public void shopNothing() {

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

        WebElement shoppingCart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        shoppingCart.click();

        WebElement checkoutBtn = driver.findElement(By.xpath("//button[@id='checkout']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        checkoutBtn.click();

        String infoText = driver.findElement(By.xpath("//div[@class='checkout_info_wrapper']")).getText();
        String expectedInfo = "There is no items in your cart";

        Assert.assertEquals(infoText, expectedInfo);

        WebElement burgerBtn = driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        burgerBtn.click();
        WebElement logoutBtn = driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        logoutBtn.click();

    }
}
