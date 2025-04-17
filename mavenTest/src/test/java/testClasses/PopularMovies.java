package testClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class PopularMovies extends BaseTest {

    @Test(priority = 1)
    public void openPopularMovies() {
        initDriver(); // Needed in case the test is run independently
        driver.get("https://www.imdb.com/");
        // Wait for and click the "Most Popular Movies" item
        WebElement popularMovies = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='Most Popular Movies']/ancestor::a")));
        popularMovies.click();

        System.out.println("Popular Movies opened successfully.");
    }

    @Test(priority = 2)
    public void openMovie() {
        // Wait for the Minecraft movie link to be clickable and click it
        WebElement minecraftMovie = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//h3[text()='A Minecraft Movie']/ancestor::a")));
        minecraftMovie.click();
        System.out.println("Minecraft movie page opened.");
    }
    
    @Test(priority = 3)
    public void openPhotosTab() {
        // Wait and click on the "Photos" button by its visible text
        WebElement photosButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(text(), 'Photos')]/ancestor::button")));
        photosButton.click();
    
        System.out.println("Photos tab opened.");
    }    
    
    @Test(priority = 4)
    public void closePhotoViewer() {
        // Wait for and click the "Close" link to exit the photo gallery
        WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[data-testid='mv-breadcrumb-close-button']")));
        closeButton.click();
    
        System.out.println("Photo viewer closed.");
    }
    
    @Test(priority = 5)
    public void clickShareButton() {
        // Wait for and click the "Share on social media" button
        WebElement shareButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button[data-testid='share-button']")));
        shareButton.click();

        System.out.println("Share on social media button clicked.");
    }

    
}
    