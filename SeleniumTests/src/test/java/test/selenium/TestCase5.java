package test.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TestCase5 {

    @Test
    public void test5() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\aristovic\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.xpath("//input[@id='login-button']"));

        username.sendKeys("problem_user");
        password.sendKeys("secret_sauce");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        login.click();

        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        driver.findElement(By.xpath("//button[@id='checkout']")).click();

        WebElement firstName = driver.findElement(By.xpath("//input[@id='first-name']"));
        WebElement lastName = driver.findElement(By.xpath("//input[@id='last-name']"));
        WebElement zipCode = driver.findElement(By.xpath("//input[@id='postal-code']"));

        firstName.sendKeys("Dragan");
        lastName.sendKeys("Markovic");
        zipCode.sendKeys("34000");

        String actualFirstName = driver.findElement(By.xpath("//input[@id='first-name']")).getAttribute("value");
        String actualLastName = driver.findElement(By.xpath("//input[@id='last-name']")).getAttribute("value");
        String actualZipCode = driver.findElement(By.xpath("//input[@id='postal-code']")).getAttribute("value");

        String expectedFirstName = "Dragan";
        String expectedLastName = "Markovic";
        String expectedZipCode = "34000";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualFirstName, expectedFirstName);
        softAssert.assertEquals(actualLastName, expectedLastName);
        softAssert.assertEquals(actualZipCode, expectedZipCode);
        softAssert.assertAll();


    }

}
