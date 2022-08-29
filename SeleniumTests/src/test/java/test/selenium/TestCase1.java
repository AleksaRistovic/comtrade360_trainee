package test.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase1 {

    @Test
    public void verify() {
        //connecting a webdriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\aristovic\\Downloads\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        //Getting to web page that we are testing
        driver.get("https://www.saucedemo.com/");

        //Getting a web element by id
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));

        //Sending what keys (text) to be entered in chosen web element
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        //A minimum time to wait for response before preforming next step
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        //Clicking on web element of choice
        login.click();

        //Creating expected result to check the actual result
        String expectedUrl="https://www.saucedemo.com/inventory.html";
        String actualUrl= driver.getCurrentUrl();

        //Checking if actual result is equals to expected
        Assert.assertEquals(actualUrl,expectedUrl);

        //Getting a web element by xpath, also getting text from that element
        String actualHeader = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        String expectedHeader = "PRODUCTS";

        Assert.assertEquals(actualHeader, expectedHeader, "Header matched");

        //Getting a web element by class name
        WebElement shoppingCart = driver.findElement(By.className("shopping_cart_link"));
        //A way to get class text from element so you can check if it is as expected
        String actualCart = shoppingCart.getAttribute("class");

        //Second way to check if actual result is equals to expected
        for (String expectedCart : actualCart.split(" ")) {
            if (expectedCart.equals("shopping_cart_link")) {
                System.out.println("Class attribute contains: " + actualCart);
            } else {
                System.out.println("Class attribute dose not contain: " + actualCart);
            }
        }

        WebElement burgerButton = driver.findElement(By.id("react-burger-menu-btn"));
        String actualBurgerBtn = burgerButton.getAttribute("style");
        String expectedBurgerBtn = "position: absolute; left: 0px; top: 0px; z-index: 1; width: 100%; height: 100%; margin: 0px; padding: 0px; border: none; font-size: 0px; background: transparent; cursor: pointer;";

        Assert.assertEquals(actualBurgerBtn, expectedBurgerBtn);

        String twitter = driver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[1]/a")).getText();
        String expectTwitter = "Twitter";
        String facebook = driver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[2]/a")).getText();
        String expectFacebook = "Facebook";
        String linkedIn = driver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[3]/a")).getText();
        String expectLinkedIn = "LinkedIn";

        Assert.assertEquals(twitter, expectTwitter);
        Assert.assertEquals(facebook, expectFacebook);
        Assert.assertEquals(linkedIn, expectLinkedIn);

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        burgerButton.click();
        WebElement logOut = driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]"));
        String actualLogOut = logOut.getText();
        String expectedLogOut = "LOGOUT";

        Assert.assertEquals(actualLogOut, expectedLogOut);

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        logOut.click();
    }
}
