package testClasses;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
import java.time.Instant;

public class testMenu{

        @Test(priority = 2)
        public void openMenu() {
            new testIMDbLogin(); // Needed in case the test is run independently

            WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.id("imdbHeader-navDrawerOpen")));
            menuButton.click();

            System.out.println("Menu opened successfully.");
        }
    }

}
