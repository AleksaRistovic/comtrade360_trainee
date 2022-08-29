package test.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class TestCase2 {

    @Test
    public void makeOrder() {

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

        WebElement sauceBackpack = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        sauceBackpack.click();
        String title = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getAttribute("class");
        String description = driver.findElement(By.xpath("//div[@class='inventory_details_desc large_size']")).getAttribute("class");
        String price = driver.findElement(By.xpath("//div[@class='inventory_details_price']")).getAttribute("class");

        String expectedTitle = "inventory_details_name large_size";
        String expectedDesc = "inventory_details_desc large_size";
        String expectedPrice = "inventory_details_price";

        Assert.assertEquals(title, expectedTitle);
        Assert.assertEquals(description, expectedDesc);
        Assert.assertEquals(price, expectedPrice);

        WebElement addToCart = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        addToCart.click();

        WebElement backToProducts = driver.findElement(By.xpath("//button[@id='back-to-products']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        backToProducts.click();

        WebElement jacketAddToCart = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        jacketAddToCart.click();

        WebElement shopCart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        shopCart.click();

        WebElement checkout = driver.findElement(By.xpath("//button[@id='checkout']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        checkout.click();

        WebElement firstName = driver.findElement(By.id("first-name"));
        WebElement lastName = driver.findElement(By.id("last-name"));
        WebElement zipCode = driver.findElement(By.id("postal-code"));
        WebElement continueOrder = driver.findElement(By.xpath("//input[@id='continue']"));

        firstName.sendKeys("Dragan");
        lastName.sendKeys("Markovic");
        zipCode.sendKeys("34000");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        continueOrder.click();

        WebElement finishBtn = driver.findElement(By.xpath("//button[@id='finish']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        finishBtn.click();

        String finishOrderMessage = driver.findElement(By.xpath("//h2[@class='complete-header']")).getText();
        String expectedMessage = "THANK YOU FOR YOUR ORDER";
        Assert.assertEquals(finishOrderMessage, expectedMessage);

        WebElement burgerBtn = driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        burgerBtn.click();
        WebElement logoutBtn = driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        logoutBtn.click();

    }
}
