package testClasses;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class testCanvasLogin {
    WebDriver driver;
    WebDriverWait wait;


    @BeforeClass
    public void setUp() {
        System.out.println("Initializing WebDriver and launching browser...");
        System.setProperty("webdriver.chrome.driverarm64", "'/Users/ethanspringob/Desktop/School/FGCU Spring 2025/Software testing/chromedriver-mac-arm64'");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void login() {
        driver.get("https://fgcu.instructure.com/");

        // Locate and interact with login elements
        WebElement signInField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Sign in")));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        signInField.sendKeys("EXAMPLEXXXX@eagle.fgcu.edu");
        passwordField.sendKeys("EXAMPLE");
        loginButton.click();

        // Prompt for user action
        System.out.println("A call will pop up, click that, then Canvas should open up.");

        // Assert login success
        WebElement dashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dashboard")));
        Assert.assertTrue(dashboard.isDisplayed(), "Login failed!");
    }


}
