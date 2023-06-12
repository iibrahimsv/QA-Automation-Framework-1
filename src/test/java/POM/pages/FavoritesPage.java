package POM.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FavoritesPage extends BasePage {

    public FavoritesPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css = "[href='#!/favorites']")
    static WebElement favoritesTabLocator;

    @FindBy(css = "li.playlist.favorites")
    static WebElement favoritesLocatorBtn;

    @FindBy(css = "[title='Like HoliznaCC0 - Waiting On A Train by Unknown Artist']")
    static WebElement likeSongBtnLocator;

    @FindBy(css = "[title='Unlike HoliznaCC0 - Waiting On A Train by Unknown Artist']")
    static WebElement unlikeSongBtnLocator;

    @FindBy(css = "[class='fa fa-frown-o']")
    static WebElement sadFrownLocator;

    @FindBy( css = "[title ='HoliznaCC0 - Waiting On A Train']")
    static WebElement firstFavSongLocator;
    public FavoritesPage clickFavoritesTab() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[href='#!/favorites']")));
        WebElement FavoritesTabLocator =  driver.findElement((By) favoritesTabLocator);
        FavoritesTabLocator.click();
        return this;
    }
    public FavoritesPage selectSongToFavorite() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li.playlist.favorites")));
        WebElement songToFavour = driver.findElement((By) favoritesLocatorBtn);
        songToFavour.click();
        return this;
    }
    public FavoritesPage SelectSongToUnFavour() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title='Unlike HoliznaCC0 - Waiting On A Train by Unknown Artist']")));
        WebElement songToUnFavour = driver.findElement((By) unlikeSongBtnLocator);
        songToUnFavour.click();
        return this;
    }
    public void validateSongIsFavoured() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title='Like HoliznaCC0 - Waiting On A Train by Unknown Artist']")));
        WebElement songWasLikeBtn = driver.findElement((By) likeSongBtnLocator);
        songWasLikeBtn.isDisplayed();
    }
    public void validateSongIsUnfavoured() {
        WebElement songWasUnlikedBtn = driver.findElement((By) unlikeSongBtnLocator);
        songWasUnlikedBtn.isDisplayed();
    }
    public void validateNoSongsAreFavoured() {
        WebElement noSongsFavoured = driver.findElement((By) sadFrownLocator);
        noSongsFavoured.isDisplayed();
    }

    public void SelectFavSongToPlay() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title='Like HoliznaCC0 - Waiting On A Train by Unknown Artist']")));
        WebElement firstSongFavBtn = driver.findElement((By) firstFavSongLocator );
        Actions action = new Actions(driver);
        action.doubleClick(firstSongFavBtn);
    }


}

