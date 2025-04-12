package testClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void loginToIMDb() {
        initDriver();

        driver.get("https://www.imdb.com/");

        WebElement signInBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("a.ipc-btn.imdb-header__signin-text")));
        signInBtn.click();

        WebElement signInIMDb = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.linkText("Sign in with IMDb")));
        signInIMDb.click();

        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email")));
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_password")));
        WebElement signInSubmit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInSubmit")));

        email.sendKeys("imdb8320@gmail.com");
        password.sendKeys("testtest");
        signInSubmit.click();

        wait.until(ExpectedConditions.urlContains("imdb.com"));
        System.out.println("Logged in successfully.");
    }
}
