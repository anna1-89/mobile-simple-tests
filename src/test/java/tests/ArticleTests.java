package tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Story("Функционал сохранения и удаления статей")
public class ArticleTests extends TestBase{

    public static String saveArticleName = "Android Studio";
    public static String deleteArticleNameFromSaved = "APK";

    @Test
    @DisplayName("Сохранение найденной статьи в раздел \"Сохраненные\"")
    void successfulSavedArticleTest() {
        welcomeScreen.passWelcomeScreens();
        step("Переходим на вкладку \"Поиск\" и вводим запрос на поиск", () -> {
            mainScreen.clickSearchTab();
            searchScreen.closeWidget();
            searchScreen.clickOnSearchField();
            searchScreen.setSearchValue(saveArticleName);
        });
        searchScreen.openArticle(saveArticleName);
        articleScreen.clickSaveButton();
        step("Возвращаемся на вкладку \"Поиск\", в котором доступно главное меню", () -> {
            articleScreen.clickBackButton();
            articleScreen.clickBackButton();
            searchScreen.clickBackScreenButton();
        });
        searchScreen.clickSavedTab();
        savedArticles.checkArticleExists(saveArticleName);
    }

    @Test
    @DisplayName("Удаление статьи из раздела \"Сохраненные\"")
    void successfulDeleteArticleFromSavedTest() {
        welcomeScreen.passWelcomeScreens();
        step("Переходим на вкладку \"Поиск\" и вводим запрос на поиск", () -> {
            mainScreen.clickSearchTab();
            searchScreen.closeWidget();
            searchScreen.clickOnSearchField();
            searchScreen.setSearchValue(deleteArticleNameFromSaved);
        });
        searchScreen.openArticle(deleteArticleNameFromSaved);
        articleScreen.clickSaveButton();
        step("Возвращаемся на вкладку \"Поиск\", в котором доступно главное меню", () -> {
            articleScreen.clickBackButton();
            articleScreen.clickBackButton();
            searchScreen.clickBackScreenButton();
        });
        step("Открываем сохраненную статью и удаляем ее из сохраненных", () -> {
            searchScreen.clickSavedTab();
            savedArticles.openArticle(deleteArticleNameFromSaved);
            articleScreen.clickSaveButton();
            articleScreen.confirmDeleteFromSavedButton();
            articleScreen.clickBackButton();
        });
        savedArticles.checkArticleNotExists(deleteArticleNameFromSaved);
    }

}
