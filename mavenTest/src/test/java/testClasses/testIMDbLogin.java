package testClasses;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class testIMDbLogin {
    WebDriver driver;
    WebDriverWait wait;


    @BeforeClass
    public void setUp() {
        System.out.println("Initializing WebDriver and launching browser...");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void login() {
        driver.get("https://www.imdb.com/");

        // Locate and interact with login elements
        WebElement signInBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.ipc-btn.imdb-header__signin-text")));
        signInBtn.click();

        WebElement signInGoogle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign in with IMDb")));
        signInGoogle.click();

        WebElement submitEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email")));
        WebElement submitPass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_password")));
        WebElement signInPass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInSubmit")));
        submitEmail.sendKeys("imdb8320@gmail.com");
        submitPass.sendKeys("testtest");
        signInPass.click();

        System.out.println("Sign In Success.");
    }


}
