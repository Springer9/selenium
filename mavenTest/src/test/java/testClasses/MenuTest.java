package testClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class MenuTest extends BaseTest {

    @Test(priority = 2)
    public void openMenu() {
        initDriver(); // Needed in case the test is run independently

        WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("imdbHeader-navDrawerOpen")));
        menuButton.click();

        System.out.println("Menu opened successfully.");
    }
}
