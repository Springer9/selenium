package testClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MovieSearch extends BaseTest {

    @Test(priority = 1)
    public void searchInceptionMovie() {
        initDriver(); // In case the test is run independently

        // Navigate to IMDb home page
        driver.get("https://www.imdb.com/");

        // Search for "Inception"
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("suggestion-search")));
        searchBox.sendKeys("Inception");
        searchBox.sendKeys(Keys.ENTER);

        // Click on the correct Inception movie link
        WebElement inceptionLink = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(text(),'Inception') and contains(@href, '/title/tt1375666/')]")));
        inceptionLink.click();

        // Wait for the title to appear to ensure page has loaded
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
        Assert.assertTrue(title.getText().contains("Inception"), "Title does not match Inception");

        // Scroll down to ensure rating is in view
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");

        // Adjusted rating locator to be more flexible
        WebElement rating = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@data-testid,'hero-rating-bar__aggregate-rating')]//span[contains(@class,'sc')]")));
        Assert.assertTrue(rating.isDisplayed(), "Rating is not visible");

        // Confirm Christopher Nolan is listed as Director
        WebElement director = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(@href,'/name/') and contains(text(),'Christopher Nolan')]")));
        Assert.assertTrue(director.isDisplayed(), "Director Christopher Nolan not found");

        System.out.println("Inception movie details validated successfully.");
    }
}
