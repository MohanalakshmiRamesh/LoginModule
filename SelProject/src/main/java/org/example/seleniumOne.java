package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class seleniumOne {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        driver.findElement(By.id("inputUsername")).sendKeys("Mohana");
        driver.findElement(By.name("inputPassword")).sendKeys("test123");
        driver.findElement(By.className("signInBtn")).click();

        String errorMessage = driver.findElement(By.cssSelector("p.error")).getText();
        Assert.assertEquals(errorMessage, "Your username or password is incorrect.");
    }

    @Test
    public void testForgotPassword() throws InterruptedException {
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Mohana");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("Mohana@gmail.com");
        driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("8940472878");

        driver.findElement(By.className("reset-pwd-btn")).click();
    }

    @Test
    public void testLoginWithValidCredentials() throws InterruptedException {
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.className("go-to-login-btn")).click();

        driver.findElement(By.id("inputUsername")).sendKeys("rahulshettyacademy");
        driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");

        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.className("signInBtn")).click();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
