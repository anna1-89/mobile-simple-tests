package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class SavedArticlesScreen {

    //Actions

    @Step("Открывем статью: {value}")
    public SavedArticlesScreen openArticle(String value) {
        SelenideElement article = $x("//*[contains(@text, '" + value + "')]");
        article.click();
        return this;
    }

    //Asserts

    @Step("Проверяем, что статья есть в списке Сохраненных: {value}")
    public SavedArticlesScreen checkArticleExists(String value) {
        SelenideElement article = $x("//*[contains(@text, '" + value + "')]");
        article.shouldHave(text(value));
        return this;
    }

    @Step("Проверяем, что статьи нет в списке Сохраненных: {value}")
    public SavedArticlesScreen checkArticleNotExists(String value) {
        $x("//*[contains(@text, '" + value + "')]").shouldNot(exist);
        return this;
    }

}
