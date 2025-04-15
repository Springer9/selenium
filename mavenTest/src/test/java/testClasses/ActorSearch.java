package testClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ActorSearch extends BaseTest {

    @Test(priority = 1)
    public void findBradPittAndFightClub() {
        initDriver();
        driver.get("https://www.imdb.com/");

        // Search for Brad Pitt
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("suggestion-search")));
        searchBox.sendKeys("Brad Pitt");
        searchBox.sendKeys(Keys.ENTER);

        // Click Brad Pitt's profile link
        WebElement actorLink = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(@href,'/name/nm0000093')]")));
        actorLink.click();

        // Scroll and search manually for Fight Club in the page
        boolean fightClubFound = false;
        for (int i = 0; i < 10; i++) {  // attempt scrolls to find it dynamically
            List<WebElement> links = driver.findElements(By.xpath("//a[contains(@href, '/title/') and contains(text(), 'Fight Club')]"));
            if (!links.isEmpty()) {
                links.get(0).click();
                fightClubFound = true;
                break;
            }
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ignored) {}
        }

        Assert.assertTrue(fightClubFound, "Fight Club link not found on Brad Pitt's profile page.");

        // Validate Fight Club movie page
        WebElement fightClubTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
        Assert.assertTrue(fightClubTitle.getText().toLowerCase().contains("fight club"), "Fight Club page did not load correctly");

        // Scroll down to view description, director, and cast
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1000);");

        // Check Director
        WebElement director = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//section[@data-testid='title-cast']//preceding::li[div//text()='Director']")));
        System.out.println("Director: " + director.getText());

        // Check Actors Section
        WebElement castSection = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//section[@data-testid='title-cast']")));
        Assert.assertTrue(castSection.isDisplayed(), "Cast section not visible");

        System.out.println("Fight Club cast section and director displayed successfully.");
    }
}
