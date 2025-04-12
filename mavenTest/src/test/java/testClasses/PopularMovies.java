package testClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class PopularMovies extends BaseTest {

    @Test(priority = 3)
    public void openPopularMovies() {
        initDriver(); // Needed in case the test is run independently

        // Wait for and click the "Most Popular Movies" item
        WebElement popularMovies = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='Most Popular Movies']/ancestor::a")));
        popularMovies.click();

        System.out.println("Popular Movies opened successfully.");
    }
}
