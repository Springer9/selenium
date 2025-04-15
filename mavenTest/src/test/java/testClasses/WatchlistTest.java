package testClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class WatchlistTest extends BaseTest {



    @Test(priority = 1)
    public void openWatchlist() {
        //initDriver();
        WebElement watchlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Watchlist")));
        watchlist.click();
    }

    @Test(priority = 2)
    public void togglePublic(){
        WebElement publicToggle = driver.findElement(By.cssSelector("label[for='hero-list-subnav-privacy-switch']"));
        publicToggle.click();
    }

    @Test(priority = 3)
    public void createList() throws InterruptedException {
        //initDriver();
        WebElement createListButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html//body//div[2]//main//div//section//section//div[3]//section//div[2]//div[2]//a//span//div[1]")));

        createListButton.click();
    }

}