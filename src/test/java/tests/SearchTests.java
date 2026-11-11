package tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Story("Функционал поиска статей")
public class SearchTests extends TestBase{

    public static String searchedArticleName = "Android";

    @Test
    @DisplayName("Успешный поиск статьи wiki")
    void successfulSearchArticleTest() {
        welcomeScreen.passWelcomeScreens();
        step("Переходим на вкладку \"Поиск\" и вводим запрос на поиск", () -> {
            mainScreen.clickSearchTab();
            searchScreen.closeWidget();
            searchScreen.clickOnSearchField();
            searchScreen.setSearchValue(searchedArticleName);
        });
        searchScreen.checkArticlesListIsNotEmpty();
    }

    @Test
    @DisplayName("Открытие найденной статьи на просмотр")
    void successfulViewArticleTest() {
        welcomeScreen.passWelcomeScreens();
        step("Переходим на вкладку \"Поиск\" и вводим запрос на поиск", () -> {
            mainScreen.clickSearchTab();
            searchScreen.closeWidget();
            searchScreen.clickOnSearchField();
            searchScreen.setSearchValue(searchedArticleName);
        });
        searchScreen.openArticle(searchedArticleName);
        articleScreen.checkRightArticleIsOpen(searchedArticleName);
    }

}
