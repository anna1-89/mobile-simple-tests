package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class ConfirmWindow {

    //Elements
    private static final SelenideElement confirmButton = $("[text=\"Yes\"]");

    //Actions

    @Step("Нажимаем на кнопку \"Да\" в всплывающем окне")
    public void pressConfirm() {
        confirmButton.click();
    }
}
