package tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Story("Прохождение welcome экранов приложения")
public class WelcomeScreensTests extends TestBase {

    @Test
    @DisplayName("Шаги прохождения welcome скринов приложения при первом запуске приложения")
    void passWelcomeScreensTest() {
        step("Проходим welcome скрины приложения при первоми запуске приложения", () -> {
            welcomeScreen.passFirstWelcomeScreen();
            welcomeScreen.passSecondWelcomeScreen();
            welcomeScreen.passThirdWelcomeScreen();
            welcomeScreen.passFourthWelcomeScreen();
        });
        mainScreen.checkMainScreenIsOpen();
    }

}
