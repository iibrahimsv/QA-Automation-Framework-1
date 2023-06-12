import POM.pages.FavoritesPage;
import POM.pages.HomePage;
import POM.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;


public class FavoritePlaylistTests extends BaseTest {

    public static WebDriverWait wait;

    public static Actions actions;


    @Test(priority = 1, description = "User Favorites a Songs & Validate") // Jira INTERNSHIP-34613 -- INTERNSHIP-34614
    public static void userFavoursSong() throws InterruptedException {

        browserConfigs();
        HomePage homePage = new LoginPage(driver).login();
        FavoritesPage favoritesPage = new FavoritesPage(driver);
        favoritesPage.clickFavoritesTab()
                .selectSongToFavorite()
                .validateSongIsFavoured();
    }
    @Test(priority = 2, description = "User UnFavours a Song & Validate") // Jira INTERNSHIP-34612 -- INTERNSHIP-34615
    public void userUnFavoursSong() {

        browserConfigs();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        FavoritesPage favoritesPage = new FavoritesPage(driver);
        favoritesPage.SelectSongToUnFavour()
                .validateSongIsUnfavoured();
    }
    @Test(priority = 3, description = "User has no Favoured Songs") // Jira INTERNSHIP-34616
    public void userHasNoFavorites() {

        browserConfigs();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        FavoritesPage favoritesPage = new FavoritesPage(driver);
        favoritesPage.clickFavoritesTab().validateNoSongsAreFavoured();
    }
    @Test(priority = 4, description = "User begins to listen to Favorite Song") // Jira
    public void userPlaysFavoriteSong() {

        browserConfigs();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        FavoritesPage favoritesPage = new FavoritesPage(driver);
        favoritesPage.clickFavoritesTab().validateNoSongsAreFavoured();
        favoritesPage.SelectFavSongToPlay();
    }
}
